package ct.dc.pc.api.dao.hall;

import ct.dc.pc.api.dao.RepositoryBase;
import ct.dc.pc.api.dao.hall.interfaces.IHallLoginByDayDao;
import ct.dc.pc.api.model.po.hall.HallLoginByDayPo;
import org.bson.Document;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;

/**
 * Created by B41-80 on 2017/4/1.
 */
@Repository
public class HallLoginByDayDao extends RepositoryBase implements IHallLoginByDayDao{
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
    @Value("${mongo.hall.loginByDay}")
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
     * 根据大厅和日期获取大厅多日登录信息
     *
     * @param group
     * @param beginDate
     * @param endDate
     * @return
     */
    public ArrayList<HallLoginByDayPo> findByGroup(int group, int beginDate, int endDate) {
        Document query = new Document().append("group",group)
                .append("date",new Document().append("$gte",beginDate).append("$lte",endDate));
        return findByDocument(query);
    }

    /**
     * 根据大厅登录
     *
     * @param beginDate
     * @param endDate
     * @return
     */
    @Override
    public ArrayList<HallLoginByDayPo> find(int beginDate, int endDate) {
        Document query = new Document().append("date",new Document().append("$gte",beginDate).append("$lte",endDate));
        return findByDocument(query);
    }

    /**
     * 根据条件查询数据
     * @param query
     * @return
     */
    private ArrayList<HallLoginByDayPo> findByDocument(Document query){
        ArrayList<HallLoginByDayPo> results = new ArrayList<HallLoginByDayPo>();
        for (Document info:collectionInstance().find(query)){
            HallLoginByDayPo result = new HallLoginByDayPo();
            result.setDate(info.getInteger("date",0));
            result.setTimes(info.getInteger("times",0));
            result.setGroup(info.getInteger("group",0));
            Document users = info.get("users",Document.class);
            Document hards = info.get("hards",Document.class);
            if (users!=null){
                result.setUsers1D1(users.getInteger("users1d1",0));
                result.setUsers3D1(users.getInteger("users3d1",0));
                result.setUsers7D1(users.getInteger("users7d1",0));
                result.setUsers14D1(users.getInteger("users14d1",0));
                result.setUsers30D1(users.getInteger("users30d1",0));
            }else {
                result.setUsers1D1(0);
                result.setUsers3D1(0);
                result.setUsers7D1(0);
                result.setUsers14D1(0);
                result.setUsers30D1(0);
            }
            if (hards!=null){
                result.setHards1D1(hards.getInteger("hards1d1",0));
                result.setHards3D1(hards.getInteger("hards3d1",0));
                result.setHards7D1(hards.getInteger("hards7d1",0));
                result.setHards14D1(hards.getInteger("hards14d1",0));
                result.setHards30D1(hards.getInteger("hards30d1",0));
            }else {
                result.setHards1D1(0);
                result.setHards3D1(0);
                result.setHards7D1(0);
                result.setHards14D1(0);
                result.setHards30D1(0);
            }
            results.add(result);
        }
        return results;
    }
}
