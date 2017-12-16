package ct.dc.pc.api.dao.halllogin;

import ct.dc.pc.api.dao.RepositoryBase;
import ct.dc.pc.api.dao.halllogin.interfaces.IHallLoginDetailDao;
import ct.dc.pc.api.model.po.hall.HallLoginUidTimesPo;
import org.bson.Document;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;

/**
 * Created by B41-80 on 2017/4/6.
 */@Repository
public class HallLoginDetailDao extends RepositoryBase implements IHallLoginDetailDao{
    @Override
    @Value("${mongo.uri}")
    public void setMongoUri(String mongoUri) {
        super.setMongoUri(mongoUri);
    }

    @Override
    @Value("${mongo.hallLogin}")
    public void setDataBaseName(String dataBaseName) {
        super.setDataBaseName(dataBaseName);
    }

    @Override
    @Value("${mongo.hallLogin.loginDetail}")
    public void setCollectionName(String collectionName) {
        super.setCollectionName(collectionName);
    }
    @Override
    @Value("${mongo.hallLogin.userName}")
    public void setUserName(String userName) {
        super.setUserName(userName);
    }

    @Override
    @Value("${mongo.hallLogin.passWord}")
    public void setPassWord(String passWord) {
        super.setPassWord(passWord);
    }
    /**
     * 获取大厅的所有用户的登录次数
     *
     * @param date
     * @param group
     * @return
     */
    public ArrayList<HallLoginUidTimesPo> listLoginTimesInfo(int date, int group) {
        ArrayList<HallLoginUidTimesPo> results = new ArrayList<HallLoginUidTimesPo>();
        Document match = new Document().append("date",date).append("group",group);
        Document aggregate = new Document().append("_id","$uid")
                .append("times",new Document().append("$sum",1));
        ArrayList<Document> aggregateDocuments = new ArrayList<Document>();
        aggregateDocuments.add(new Document().append("$match",match));
        aggregateDocuments.add(new Document().append("$group",aggregate));
        for (Document info:collectionInstance().aggregate(aggregateDocuments)){
            HallLoginUidTimesPo result = new HallLoginUidTimesPo();
            result.setUid(info.getInteger("_id",0));
            result.setTimes(info.getInteger("times",0));
            results.add(result);
        }
        return results;
    }
}
