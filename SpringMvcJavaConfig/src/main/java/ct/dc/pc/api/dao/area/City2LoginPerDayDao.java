package ct.dc.pc.api.dao.area;

import ct.dc.pc.api.dao.RepositoryBase;
import ct.dc.pc.api.dao.area.interfaces.ICity2LoginPerDayDao;
import ct.dc.pc.api.model.po.area.AreaLoginPerDayPo;
import org.bson.Document;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;

/**
 * Created by B41-80 on 2017/3/31.
 */
@Repository
public class City2LoginPerDayDao extends RepositoryBase implements ICity2LoginPerDayDao{
    @Override
    @Value("${mongo.uri}")
    public void setMongoUri(String mongoUri) {
        super.setMongoUri(mongoUri);
    }

    @Override
    @Value("${mongo.area}")
    public void setDataBaseName(String dataBaseName) {
        super.setDataBaseName(dataBaseName);
    }

    @Override
    @Value("${mongo.area.cityLoginPerDay}")
    public void setCollectionName(String collectionName) {
        super.setCollectionName(collectionName);
    }
    @Override
    @Value("${mongo.area.userName}")
    public void setUserName(String userName) {
        super.setUserName(userName);
    }

    @Override
    @Value("${mongo.area.passWord}")
    public void setPassWord(String passWord) {
        super.setPassWord(passWord);
    }
    /**
     * 通过地级市和日期查找单日登录数据
     *
     * @param city
     * @param beginDate
     * @param endDate
     * @return
     */
    public ArrayList<AreaLoginPerDayPo> findByCity(String city, int beginDate, int endDate) {
        Document query = new Document().append("city",city)
                .append("date",new Document().append("$gte",beginDate).append("$lte",endDate));
        return findByDocument(query);
    }

    /**
     * 通过地级市和日期查找单日登录数据
     *
     * @param city
     * @param date
     * @return
     */
    public ArrayList<AreaLoginPerDayPo> findByCity(String city, int date) {
        Document query = new Document().append("city",city)
                .append("date",date);
        return findByDocument(query);
    }

    /**
     * 根据条件查询单日登录数据
     * @return
     */
    private ArrayList<AreaLoginPerDayPo> findByDocument(Document query){
        ArrayList<AreaLoginPerDayPo> results = new ArrayList<AreaLoginPerDayPo>();
        for (Document info:collectionInstance().find(query)){
            AreaLoginPerDayPo result = new AreaLoginPerDayPo();
            result.setDate(info.getInteger("date",0));
            result.setTimes(info.getInteger("times",0));
            result.setUsers(info.getInteger("users",0));
            result.setAreaId(info.getString("city"));
            result.setTrange(info.getInteger("trange",0));
            result.setHards(info.getInteger("hards",0));
            results.add(result);
        }
        return results;
    }
}
