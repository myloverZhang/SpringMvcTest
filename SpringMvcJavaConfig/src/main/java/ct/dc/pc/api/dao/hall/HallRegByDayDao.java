package ct.dc.pc.api.dao.hall;

import ct.dc.pc.api.dao.RepositoryBase;
import ct.dc.pc.api.dao.hall.interfaces.IHallRegByDayDao;
import ct.dc.pc.api.model.po.hall.HallRegByDayPo;
import org.bson.Document;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;

/**
 * Created by B41-80 on 2017/4/1.
 */
@Repository
public class HallRegByDayDao extends RepositoryBase implements IHallRegByDayDao{
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
    @Value("${mongo.hall.regByDay}")
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
     * 根据大厅和日期后期注册数据
     *
     * @param group
     * @param beginDate
     * @param endDate
     * @return
     */
    public ArrayList<HallRegByDayPo> findByGroup(int group, int beginDate, int endDate) {
        Document query = new Document().append("group",group)
                .append("date",new Document().append("$gte",beginDate).append("$lte",endDate));
        return findByDocument(query);
    }

    /**
     * 根据日期查询数据
     *
     * @param beginDate
     * @param endDate
     * @return
     */
    @Override
    public ArrayList<HallRegByDayPo> find(int beginDate, int endDate) {
        Document query = new Document().append("date",new Document().append("$gte",beginDate).append("$lte",endDate));
        return findByDocument(query);
    }

    /**
     * 根据条件获取数据
     * @param query
     * @return
     */
    private ArrayList<HallRegByDayPo> findByDocument(Document query){
        ArrayList<HallRegByDayPo> results = new ArrayList<HallRegByDayPo>();
        for (Document info:collectionInstance().find(query)){
            HallRegByDayPo result = new HallRegByDayPo();
            result.setDate(info.getInteger("date",0));
            result.setGroup(info.getInteger("group",0));
            result.setUsers(info.getInteger("users",0));
            result.setHards(info.getInteger("hards",0));
            results.add(result);
        }
        return results;
    }
}
