package ct.dc.mobile.api.dao.mobileapp;

import ct.dc.mobile.api.dao.RespositoryBase;
import ct.dc.mobile.api.dao.mobileapp.Interface.ILoginByDayDAO;
import ct.dc.mobile.api.model.po.mobileapp.AppLoginByDayPo;
import org.apache.log4j.Logger;
import org.bson.Document;
import org.springframework.beans.factory.annotation.Value;

import java.util.ArrayList;

/**
 * Created by B41-80 on 2017/1/5.
 */
public class LoginByDayDAO extends RespositoryBase implements ILoginByDayDAO {
    private Logger logger = Logger.getLogger(LoginByDayDAO.class);
    @Value("${mongo.stats.uri}")
    public void setMongoUri(String mongoUri) {
        super.setMongoUri(mongoUri);
    }
    @Value("${mongo.app.db.stats}")
    public void setDataBaseName(String dataBaseName) {
        super.setDataBaseName(dataBaseName);
    }
    @Value("${mongo.app.loginByDay}")
    public void setCollectionName(String collectionName) {
        super.setCollectionName(collectionName);
    }

    /**
     * 根据日期查询多日登录信息
     * @return
     */
    public ArrayList<AppLoginByDayPo> findByDate(int begin,int end){
        Document query = new Document().append("date",new Document().append("$gte",begin).append("$lte",end));
        return find(query);
    }
    /**
     * 根据appid和日期范围查询登录信息
     * @param appId
     * @param begin
     * @param end
     * @return
     */
    public ArrayList<AppLoginByDayPo> findByDate(long appId,int begin,int end)
    {
        Document query = new Document();
        query.append("app",appId);
        Document date = new Document();
        date.append("$lte",end);
        date.append("$gte",begin);
        query.append("date",date);
        return find(query);
    }
    /**
     * 根据条件查询数据
     * @param query
     * @return
             */
    public ArrayList<AppLoginByDayPo> find(Document query) {
        ArrayList<AppLoginByDayPo> reults = new ArrayList<AppLoginByDayPo>();
        for (Document doc:collectionInstance().find(query))
        {
            AppLoginByDayPo info = new AppLoginByDayPo();
            info.setDate(doc.getInteger("date"));
            info.setApp(Long.valueOf(doc.get("app").toString()));
            info.setTimes(doc.getInteger("times"));
            Document users = doc.get("users",Document.class);
            Document hards = doc.get("hards",Document.class);
            if (users!=null)
            {
                logger.info(users.toJson());
                info.setUsers1d1(users.getInteger("users1d1",0));
                info.setUsers3d1(users.getInteger("users3d1",0));
                info.setUsers7d1(users.getInteger("users7d1",0));
                info.setUsers14d1(users.getInteger("users14d1",0));
                info.setUsers30d1(users.getInteger("users30d1",0));
            }
            if (hards!=null)
            {
                info.setHards1d1(hards.getInteger("hards1d1",0));
                info.setHards3d1(hards.getInteger("hards3d1",0));
                info.setHards7d1(hards.getInteger("hards7d1",0));
                info.setHards14d1(hards.getInteger("hards14d1",0));
                info.setHards30d1(hards.getInteger("hards30d1",0));
            }

            reults.add(info);
        }
        return reults;
    }

}
