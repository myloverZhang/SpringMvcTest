package ct.dc.pc.api.dao.hall;

import ct.dc.pc.api.dao.RepositoryBase;
import ct.dc.pc.api.dao.hall.interfaces.IHallOnlineByDayDao;
import ct.dc.pc.api.model.po.hall.HallOnlineByDayPo;
import org.bson.Document;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;

/**
 * Created by B41-80 on 2017/4/1.
 */
@Repository
public class HallOnlineByDayDao extends RepositoryBase implements IHallOnlineByDayDao{
    @Override
    @Value("${mongo.uri}")
    public void setMongoUri(String mongoUri) {
        super.setMongoUri(mongoUri);
    }

    @Override
    @Value("${mongo.hall}")
    public void setDataBaseName(String dataBaseName) {
        super.setDataBaseName(dataBaseName);
    }

    @Override
    @Value("${mongo.hall.onlineByDay}")
    public void setCollectionName(String collectionName) {
        super.setCollectionName(collectionName);
    }
    @Override
    @Value("${mongo.hall.userName}")
    public void setUserName(String userName) {
        super.setUserName(userName);
    }

    @Override
    @Value("${mongo.hall.passWord}")
    public void setPassWord(String passWord) {
        super.setPassWord(passWord);
    }
    /**
     * 根据大厅和日期查询数据
     *
     * @param group
     * @param beginDate
     * @param endDate
     * @return
     */
    public ArrayList<HallOnlineByDayPo> findByGroup(int group, int beginDate, int endDate) {
        Document query = new Document().append("group",group)
                .append("date",new Document().append("$gte",beginDate).append("$lte",endDate));
        return findByDocument(query);
    }

    /**
     * 根据条件查询数据
     * @param query
     * @return
     */
    private ArrayList<HallOnlineByDayPo> findByDocument(Document query){
        ArrayList<HallOnlineByDayPo> results = new ArrayList<HallOnlineByDayPo>();
        for (Document info:collectionInstance().find(query)){
            HallOnlineByDayPo result = new HallOnlineByDayPo();
            result.setDate(info.getInteger("date",0));
            result.setGroup(info.getInteger("group",0));
            result.setAvgUsers(info.getInteger("avgusers",0));
            result.setMaxUsers(info.getInteger("maxusers",0));
            results.add(result);
        }
        return results;
    }

}
