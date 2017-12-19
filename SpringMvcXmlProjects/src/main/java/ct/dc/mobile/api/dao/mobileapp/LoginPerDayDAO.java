package ct.dc.mobile.api.dao.mobileapp;

import ct.dc.mobile.api.dao.RespositoryBase;
import ct.dc.mobile.api.dao.mobileapp.Interface.ILoginPerDayDAO;
import ct.dc.mobile.api.model.po.mobileapp.AppLoginByPerDayPo;
import org.apache.log4j.Logger;
import org.bson.Document;
import org.springframework.beans.factory.annotation.Value;

import java.util.ArrayList;

/**
 * Created by B41-80 on 2017/1/9.
 */
public class LoginPerDayDAO extends RespositoryBase implements ILoginPerDayDAO {
    private Logger logger = Logger.getLogger(LoginPerDayDAO.class);
    @Value("${mongo.uri}")
    public void setMongoUri(String mongoUri) {
        super.setMongoUri(mongoUri);
    }

    @Value("${mongo.app.db}")
    public void setDataBaseName(String dataBaseName) {
        super.setDataBaseName(dataBaseName);
    }

    @Value("${mongo.app.loginByPerDay}")
    public void setCollectionName(String collectionName) {
        logger.info(String.format("colectionName============================%s",collectionName));
        super.setCollectionName(collectionName);
    }

    /**
     * 查询单日登录的数据
     * @param appid
     * @param date
     * @return
     */
    public ArrayList<AppLoginByPerDayPo> find(long appid,int date)
    {
        Document query = new Document();
        query.append("app",appid);
        query.append("date",date);
        return findByDocument(query);
    }

    /**
     * 组装查询参数并查询数据
     * @return
     */
    private ArrayList<AppLoginByPerDayPo> findByDocument(Document query)
    {
        ArrayList<AppLoginByPerDayPo> results = new ArrayList<AppLoginByPerDayPo>();
        for (Document info:collectionInstance().find(query))
        {
            AppLoginByPerDayPo result = new AppLoginByPerDayPo();
            result.setTimes(info.getInteger("times"));
            result.setDate(info.getInteger("date"));
            result.setApp(info.getLong("app"));
            result.setHards(info.getInteger("hards"));
            result.setUsers(info.getInteger("users"));
            result.setTrange(info.getInteger("trange",0));
            results.add(result);
        }
        return results;
    }
}
