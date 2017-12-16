package ct.dc.pc.api.dao.hall;

import ct.dc.pc.api.dao.RepositoryBase;
import ct.dc.pc.api.dao.hall.interfaces.IHallLoginPerDayDao;
import ct.dc.pc.api.model.po.hall.HallLoginPerDayPo;
import org.bson.Document;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;

/**
 * Created by B41-80 on 2017/4/1.
 */
@Repository
public class HallLoginPerDayDao extends RepositoryBase implements IHallLoginPerDayDao{
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
    @Value("${mongo.hall.loginPerDay}")
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
    public ArrayList<HallLoginPerDayPo> findByGroup(int group, int beginDate, int endDate) {
        Document query = new Document().append("group",group)
                .append("date",new Document().append("$gte",beginDate).append("$lte",endDate));
        return findByDocument(query);
    }

    /**
     * 根据大厅和日期查询数据
     *
     * @param group
     * @param date
     * @return
     */
    public ArrayList<HallLoginPerDayPo> findByGroup(int group, int date) {
        Document query = new Document().append("group",group)
                .append("date",date);
        return findByDocument(query);
    }

    /**
     * 根据条件查询数据
     * @param query
     * @return
     */
    private ArrayList<HallLoginPerDayPo> findByDocument(Document query){
        ArrayList<HallLoginPerDayPo> results = new ArrayList<HallLoginPerDayPo>();
        for (Document info:collectionInstance().find(query)){
            HallLoginPerDayPo result = new HallLoginPerDayPo();
            result.setDate(info.getInteger("date",0));
            result.setGroup(info.getInteger("group",0));
            result.setTrange(info.getInteger("trange",0));
            result.setUsers(info.getInteger("users",0));
            result.setTimes(info.getInteger("times",0));
            result.setHards(info.getInteger("hards",0));
            results.add(result);
        }
        return results;
    }
}
