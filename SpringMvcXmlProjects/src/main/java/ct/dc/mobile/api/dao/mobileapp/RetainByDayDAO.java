package ct.dc.mobile.api.dao.mobileapp;

import ct.dc.mobile.api.dao.RespositoryBase;
import ct.dc.mobile.api.dao.mobileapp.Interface.IRetainByDayDAO;
import ct.dc.mobile.api.model.po.mobileapp.AppRetainByDayPo;
import org.apache.log4j.Logger;
import org.bson.Document;
import org.springframework.beans.factory.annotation.Value;

import java.util.ArrayList;

/**
 * Created by B41-80 on 2017/1/9.
 */
public class RetainByDayDAO extends RespositoryBase implements IRetainByDayDAO {
    private Logger logger = Logger.getLogger(RetainByDayDAO.class);
    @Value("${mongo.uri}")
    public void setMongoUri(String mongoUri) {
        super.setMongoUri(mongoUri);
    }

    @Value("${mongo.app.db}")
    public void setDataBaseName(String dataBaseName) {
        super.setDataBaseName(dataBaseName);
    }

    @Value("${mongo.app.retainByDay}")
    public void setCollectionName(String collectionName) {
        super.setCollectionName(collectionName);
    }

    /**
     * 查询留存信息
     * @param app
     * @param begin
     * @param end
     * @return
     */
    public ArrayList<AppRetainByDayPo> find(long app,int begin,int end){
        Document query = new Document();
        query.append("app",app);
        query.append("date",new Document().append("$gte",begin).append("$lte",end));
        return findByQuery(query);
    }

    @Override
    public ArrayList<AppRetainByDayPo> find(int begin, int end) {
        Document query = new Document().append("date",new Document().append("$lte",end).append("$gte",begin));
        return findByQuery(query);
    }

    /**
     * 查询留存明细
     * @param query
     * @return
     */
    private ArrayList<AppRetainByDayPo> findByQuery(Document query){
        ArrayList<AppRetainByDayPo> results = new ArrayList<AppRetainByDayPo>();
        for (Document info:collectionInstance().find(query)){
            AppRetainByDayPo result = new AppRetainByDayPo();
            result.setDate(info.getInteger("date"));
            result.setApp(info.getLong("app"));
            Document users = info.get("users",Document.class);
            Document hards = info.get("hards",Document.class);
            if (users!=null){
                result.setUsersNew(users.getInteger("new",0));
                result.setUsersD1(users.getInteger("d1",0));
                result.setUsersD3(users.getInteger("d3",0));
                result.setUsersD7(users.getInteger("d7",0));
                result.setUsersD14(users.getInteger("d14",0));
                result.setUsersD30(users.getInteger("d30",0));
            }
            if (hards!=null){
                result.setHardsNew(hards.getInteger("new",0));
                result.setHardsD1(hards.getInteger("d1",0));
                result.setHardsD3(hards.getInteger("d3",0));
                result.setHardsD7(hards.getInteger("d7",0));
                result.setHardsD14(hards.getInteger("d14",0));
                result.setHardsD30(hards.getInteger("d30",0));
            }
            results.add(result);
        }
        return results;
    }
}
