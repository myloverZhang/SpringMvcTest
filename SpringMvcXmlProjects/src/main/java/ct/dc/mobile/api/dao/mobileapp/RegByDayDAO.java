package ct.dc.mobile.api.dao.mobileapp;

import ct.dc.mobile.api.dao.RespositoryBase;
import ct.dc.mobile.api.dao.mobileapp.Interface.IRegByDayDAO;
import ct.dc.mobile.api.model.po.mobileapp.AppRegByDayPo;
import org.bson.Document;
import org.springframework.beans.factory.annotation.Value;

import java.util.ArrayList;

/**
 * Created by B41-80 on 2017/1/9.
 */
public class RegByDayDAO extends RespositoryBase implements IRegByDayDAO {
    @Value("${mongo.uri}")
    public void setMongoUri(String mongoUri) {
        super.setMongoUri(mongoUri);
    }

    @Value("${mongo.app.db}")
    public void setDataBaseName(String dataBaseName) {
        super.setDataBaseName(dataBaseName);
    }

    @Value("${mongo.app.regByDay}")
    public void setCollectionName(String collectionName) {
        super.setCollectionName(collectionName);
    }

    /**
     * 查询注册信息
     * @param app
     * @param begin
     * @param end
     * @return
     */
    public ArrayList<AppRegByDayPo> find(long app, final int begin, int end) {
        Document query = new Document();
        query.append("app",app);
        query.append("date",new Document().append("$lte",end).append("$gte",begin));
        return findByQuery(query);
    }

    @Override
    public ArrayList<AppRegByDayPo> find(int begin, int end) {
        Document query = new Document().append("date",new Document().append("$lte",end).append("$gte",begin));
        return findByQuery(query);
    }

    /**
     * 按条件查询
     * @param query
     * @return
     */
    private ArrayList<AppRegByDayPo> findByQuery(Document query)
    {
        ArrayList<AppRegByDayPo> results = new ArrayList<AppRegByDayPo>();
        for (Document info:collectionInstance().find(query)){
             AppRegByDayPo result = new AppRegByDayPo();
            result.setHards(info.getInteger("hards"));
            result.setUsers(info.getInteger("users"));
            long app = info.get("app") instanceof Long ? info.getLong("app"):info.getInteger("app");
            result.setApp(app);
            result.setDate(info.getInteger("date"));
            results.add(result);
        }
        return results;
    }
}
