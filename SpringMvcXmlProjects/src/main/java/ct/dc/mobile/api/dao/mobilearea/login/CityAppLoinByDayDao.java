package ct.dc.mobile.api.dao.mobilearea.login;

import ct.dc.mobile.api.dao.RespositoryBase;
import ct.dc.mobile.api.dao.mobilearea.Interface.ICityAppLoginByDayDao;
import ct.dc.mobile.api.dao.mobilearea.login.callable.AppAreaAggregateCallable;
import ct.dc.mobile.api.dao.mobilearea.login.callable.AppAreaDetailsAggregateCallable;
import ct.dc.mobile.api.enums.StatTypeEnum;
import ct.dc.mobile.api.model.po.mobileapp.AppAreaLoginByDayPo;
import ct.dc.mobile.api.model.po.mobileapp.AppAreaLoginDetailByDayPo;
import ct.dc.mobile.api.model.po.mobilearea.AreaAppLoginByDayPo;
import ct.dc.mobile.api.model.po.mobilearea.AreaAppLoginDetailsByDayPo;
import org.bson.Document;
import org.springframework.beans.factory.annotation.Value;

import java.util.ArrayList;
import java.util.concurrent.*;

/**
 * Created by B41-80 on 2017/1/10.
 */
public class CityAppLoinByDayDao extends RespositoryBase implements ICityAppLoginByDayDao{
    private ExecutorService pool = Executors.newFixedThreadPool(10);
    @Value("${mongo.uri}")
    public void setMongoUri(String mongoUri) {
        super.setMongoUri(mongoUri);
    }

    @Value("${mongo.areaApp}")
    public void setDataBaseName(String dataBaseName) {
        super.setDataBaseName(dataBaseName);
    }

    @Value("${mongo.areaApp.cityByDay}")
    public void setCollectionName(String collectionName) {
        super.setCollectionName(collectionName);
    }

    /**
     * 二合数据二级界面结果查询
     * @param app
     * @param areaId
     * @param begin
     * @param end
     * @return
     */
    public ArrayList<AppAreaLoginDetailByDayPo> findDetail(long app,String areaId,int begin,int end) throws ExecutionException, InterruptedException {
        Document query = new Document().append("app",app)
                .append("date",new Document().append("$gte",begin).append("$lte",end))
                .append("city",areaId);
        ArrayList<Document> aggrAccountDocument = new ArrayList<Document>();
        aggrAccountDocument.add(new Document().append("$match",query));
        aggrAccountDocument.add(new Document().append("$group",DetailsGroupByAccountOnce()));
        aggrAccountDocument.add(new Document().append("$group",DetailsGroupByDateTwice()));
        ArrayList<Document> aggrHardDocument = new ArrayList<Document>();
        aggrHardDocument.add(new Document().append("$match",query));
        aggrHardDocument.add(new Document().append("$group",DetailsGroupByHardOnce()));
        aggrHardDocument.add(new Document().append("$group",DetailsGroupByDateTwice()));
        Callable accountCallable = new AppAreaDetailsAggregateCallable(aggrAccountDocument,StatTypeEnum.ACCOUNT.getValue(),collectionInstance());
        Callable hardCallable = new AppAreaDetailsAggregateCallable(aggrHardDocument,StatTypeEnum.HARD.getValue(),collectionInstance());
        Future<ArrayList<AppAreaLoginDetailByDayPo>> accountResults = pool.submit(accountCallable);
        Future<ArrayList<AppAreaLoginDetailByDayPo>> hardResults = pool.submit(hardCallable);
        ArrayList<AppAreaLoginDetailByDayPo> results = new ArrayList<AppAreaLoginDetailByDayPo>();
        results.addAll(accountResults.get());
        results.addAll(hardResults.get());
        return results;
    }
    /**
     * 查询二合数据一级结果
     * @param app
     * @param begin
     * @param end
     * @return
     */
    public ArrayList<AppAreaLoginByDayPo> findFull(long app,int begin,int end) throws ExecutionException, InterruptedException {
        Document query = new Document().append("app",app).append("date",(new Document().append("$gte",begin).append("$lte",end)));
        ArrayList<Document> aggrAccountDocument = new ArrayList<Document>();
        aggrAccountDocument.add(new Document().append("$match",query));
        aggrAccountDocument.add(new Document().append("$group",GroupByAccountOnce()));
        aggrAccountDocument.add(new Document().append("$group",GroupByCityTwice()));
        ArrayList<Document> aggrHardDocument = new ArrayList<Document>();
        aggrHardDocument.add(new Document().append("$match",query));
        aggrHardDocument.add(new Document().append("$group",GroupByHardOnce()));
        aggrHardDocument.add(new Document().append("$group",GroupByCityTwice()));
        Callable accountCallable = new AppAreaAggregateCallable(aggrAccountDocument,StatTypeEnum.ACCOUNT.getValue(),collectionInstance());
        Future<ArrayList<AppAreaLoginByDayPo>> accountResults = pool.submit(accountCallable);
        Callable hardCallable = new AppAreaAggregateCallable(aggrHardDocument,StatTypeEnum.HARD.getValue(),collectionInstance());
        Future<ArrayList<AppAreaLoginByDayPo>> hardResults = pool.submit(hardCallable);
        ArrayList<AppAreaLoginByDayPo> results = new ArrayList<AppAreaLoginByDayPo>();
        results.addAll(accountResults.get());
        results.addAll(hardResults.get());
        return results;
    }

    /**
     * 地区游戏二合一级界面
     * @param begin
     * @param end
     * @param city
     * @return
     */
    @Override
    public ArrayList<AreaAppLoginByDayPo> findFull(int begin, int end, String city) throws ExecutionException, InterruptedException {
        Document query = new Document().append("city",city)
                .append("date",new Document().append("$gte",begin).append("$lte",end));
        return AggregateUtil.areaAppFullInfos(query,collectionInstance(),pool);
    }

    /**
     * 地区游戏二合二级界面
     * @param begin
     * @param end
     * @param app
     * @param city
     * @return
     */
    @Override
    public ArrayList<AreaAppLoginDetailsByDayPo> findDetails(int begin, int end, long app, String city) throws ExecutionException, InterruptedException {
        Document query = new Document().append("city",city)
                .append("app",app)
                .append("date",new Document("$gte",begin).append("$lte",end));
        return AggregateUtil.areaAppDetailsInfos(query,collectionInstance(),pool);
    }

    /**
     * 二级界面之按账号一次聚合条件
     * @return
     */
    private Document DetailsGroupByAccountOnce(){
        return new Document().append("_id",new Document().append("date","$date").append("uid","$uid"))
                .append("times",new Document().append("$sum","$times"));
    }

    /**
     * 二级界面之按照设备一次聚合条件
     * @return
     */
    private Document DetailsGroupByHardOnce(){
        return new Document().append("_id",new Document().append("date","$date").append("hardid","$hardid"))
                .append("times",new Document("$sum","$times"));
    }
    /**
     * 二级界面二次聚合条件
     * @return
     */
    private Document DetailsGroupByDateTwice(){
        return new Document().append("_id","$_id.date")
                .append("times",new Document("$sum","$times"))
                .append("loginUnitNum",new Document().append("$sum",1));
    }
    /**
     * 一级界面按设备聚合条件
     * @return
     */
    private Document GroupByHardOnce(){
        return new Document().append("_id", new Document().append("city","$city").append("hardid","$hardid"))
                .append("times",new Document("$sum","$times"));
    }
    /**
     * 一级界面账号聚合条件
     * @return
     */
    private  Document GroupByAccountOnce(){
        Document firgroup = new Document().append("_id",new Document().append("city","$city").append("uid","$uid"))
                .append("times",new Document().append("$sum","$times"));
        return firgroup;
    }

    /**
     * 一级界面按照city进行二次聚合
     * @return
     */
    private Document GroupByCityTwice(){
        Document secgroup = new Document().append("_id","$_id.city")
                .append("times",new Document().append("$sum","$times"))
                .append("loginUnitNum",new Document("$sum",1));
        return secgroup;
    }


}
