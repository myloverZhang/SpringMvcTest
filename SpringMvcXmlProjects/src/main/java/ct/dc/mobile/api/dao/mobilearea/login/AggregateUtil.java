package ct.dc.mobile.api.dao.mobilearea.login;

import com.mongodb.client.MongoCollection;
import ct.dc.mobile.api.dao.mobilearea.login.callable.AreaAppAggregateCallable;
import ct.dc.mobile.api.dao.mobilearea.login.callable.AreaAppDetailsAggregateCallable;
import ct.dc.mobile.api.enums.StatTypeEnum;
import ct.dc.mobile.api.model.po.mobilearea.AreaAppLoginByDayPo;
import ct.dc.mobile.api.model.po.mobilearea.AreaAppLoginDetailsByDayPo;
import org.bson.Document;

import java.util.ArrayList;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;

/**
 * Created by B41-80 on 2017/1/12.
 */
public class AggregateUtil {
    /**
     * 一级界面按账号聚合条件
     * @return
     */
    public static Document groupByAccountOnce(){
        return new Document().append("_id",new Document().append("app","$app").append("uid","$uid"))
                .append("times",new Document().append("$sum","$times"));
    }

    /**
     * 一级界面按设备聚合条件
     * @return
     */
    public static Document groupByHardOnce(){
        return new Document().append("_id",new Document().append("app","$app").append("hardid","$hardid"))
                .append("times",new Document().append("$sum","$times"));
    }
    /**
     * 一级界面按app进行二次聚合
     * @return
     */
    public static Document groupByAppTwice(){
        return new Document().append("_id","$_id.app")
                .append("times",new Document().append("$sum","$times"))
                .append("loginUnitNum",new Document().append("$sum",1));
    }

    /**
     * 二级界面按账号一次聚合条件
     * @return
     */
    public static Document detailsGroupByAccountOnce(){
        return new Document().append("_id",new Document().append("date","$date").append("uid","$uid"))
                .append("times",new Document().append("$sum","$times"));
    }

    /**
     * 二级界面按设备一次聚合条件
     * @return
     */
    public static Document detailsGroupByHardOnce(){
        return new Document().append("_id",new Document().append("date","$date").append("hard","$hardid"))
                .append("times",new Document().append("$sum","$times"));
    }
    /**
     * 二级界面二次聚合条件
     * @return
     */
    public static Document detailsGroupByDateTwice(){
        return new Document().append("_id","$_id.date")
                .append("times",new Document().append("$sum","$times"))
                .append("loginUnitNum",new Document().append("$sum",1));
    }

    /**
     * 获取一级界面账号聚合的聚合条件
     * @param query
     * @return
     */
    public static ArrayList<Document> getAggreAccountDocuments(Document query){
        ArrayList<Document> aggrAccountDocuments = new ArrayList<Document>();
        aggrAccountDocuments.add(new Document().append("$match",query));
        aggrAccountDocuments.add(new Document().append("$group",groupByAccountOnce()));
        aggrAccountDocuments.add(new Document().append("$group",groupByAppTwice()));
        return aggrAccountDocuments;
    }

    /**
     * 获取一级界面设备聚合的聚合条件
     * @param query
     * @return
     */
    public static ArrayList<Document> getAggreHardsDocuments(Document query){
        ArrayList<Document> aggrHardDocuments = new ArrayList<Document>();
        aggrHardDocuments.add(new Document().append("$match",query));
        aggrHardDocuments.add(new Document().append("$group",groupByHardOnce()));
        aggrHardDocuments.add(new Document().append("$group",groupByAppTwice()));
        return aggrHardDocuments;
    }

    /**
     * 二合明细账号聚合条件
     * @param query
     * @return
     */
    public static ArrayList<Document> detailsAggreAccountDocuments(Document query){
        ArrayList<Document> aggrAccountDocuments = new ArrayList<Document>();
        aggrAccountDocuments.add(new Document().append("$match",query));
        aggrAccountDocuments.add(new Document().append("$group", detailsGroupByAccountOnce()));
        aggrAccountDocuments.add(new Document().append("$group", detailsGroupByDateTwice()));
        return aggrAccountDocuments;
    }

    /**
     * 二合明细设备聚合条件
     * @return
     */
    public static ArrayList<Document> detailsAggreHardDocuments(Document query){
        ArrayList<Document> aggrHardDocuments = new ArrayList<Document>();
        aggrHardDocuments.add(new Document().append("$match",query));
        aggrHardDocuments.add(new Document().append("$group",detailsGroupByHardOnce()));
        aggrHardDocuments.add(new Document().append("$group",detailsGroupByDateTwice()));
        return aggrHardDocuments;
    }

    /**
     * 查询二合一级界面的数据
     * @return
     */
    public static ArrayList<AreaAppLoginByDayPo> areaAppFullInfos(Document query, MongoCollection<Document> collectionInstance, ExecutorService pool) throws ExecutionException, InterruptedException {
        ArrayList<Document> aggrAccountDocuments = AggregateUtil.getAggreAccountDocuments(query);
        Callable accountCallable = new AreaAppAggregateCallable(aggrAccountDocuments, StatTypeEnum.ACCOUNT.getValue(),collectionInstance);
        ArrayList<Document> aggrHardDocuments = AggregateUtil.getAggreHardsDocuments(query);
        Callable hardCallable = new AreaAppAggregateCallable(aggrHardDocuments,StatTypeEnum.HARD.getValue(),collectionInstance);
        Future<ArrayList<AreaAppLoginByDayPo>> accountResults = pool.submit(accountCallable);
        Future<ArrayList<AreaAppLoginByDayPo>> hardResults = pool.submit(hardCallable);
        ArrayList<AreaAppLoginByDayPo> results = new ArrayList<AreaAppLoginByDayPo>();
        results.addAll(accountResults.get());
        results.addAll(hardResults.get());
        return results;
    }

    /**
     * 二合数据的二级界面数据
     * @param query
     * @param collectionInstance
     * @param pool
     * @return
     */
    public static ArrayList<AreaAppLoginDetailsByDayPo> areaAppDetailsInfos(Document query,MongoCollection<Document> collectionInstance,ExecutorService pool) throws ExecutionException, InterruptedException {
        ArrayList<Document> aggrAccountDocuments = AggregateUtil.detailsAggreAccountDocuments(query);
        ArrayList<Document> aggrHardDocuments = AggregateUtil.detailsAggreHardDocuments(query);
        Callable accountCallable = new AreaAppDetailsAggregateCallable(aggrAccountDocuments, StatTypeEnum.ACCOUNT.getValue(),collectionInstance);
        Callable hardCallable = new AreaAppDetailsAggregateCallable(aggrHardDocuments,StatTypeEnum.HARD.getValue(),collectionInstance);
        Future<ArrayList<AreaAppLoginDetailsByDayPo>> accountResults = pool.submit(accountCallable);
        Future<ArrayList<AreaAppLoginDetailsByDayPo>> hardResults = pool.submit(hardCallable);
        ArrayList<AreaAppLoginDetailsByDayPo> results = new ArrayList<AreaAppLoginDetailsByDayPo>();
        results.addAll(accountResults.get());
        results.addAll(hardResults.get());
        return results;
    }
}
