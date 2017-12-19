package ct.dc.mobile.api.dao.mobilearea.login;

import ct.dc.mobile.api.dao.RespositoryBase;
import ct.dc.mobile.api.dao.mobilearea.Interface.IAreaCityLoginByDayDao;
import ct.dc.mobile.api.model.po.mobilearea.AreaLoginByDayPo;
import org.bson.Document;
import org.springframework.beans.factory.annotation.Value;

import java.util.ArrayList;

/**
 * Created by B41-80 on 2017/1/11.
 */
public class AreaCityLoginByDayDao extends RespositoryBase implements IAreaCityLoginByDayDao{
    @Value("${mongo.stats.uri}")
    public void setMongoUri(String mongoUri) {
        super.setMongoUri(mongoUri);
    }

    @Value("${mongo.area.stats}")
    public void setDataBaseName(String dataBaseName) {
        super.setDataBaseName(dataBaseName);
    }

    @Value("${mongo.area.cityLoginByDay}")
    public void setCollectionName(String collectionName) {
        super.setCollectionName(collectionName);
    }

    /**
     * 地级市多日登录查询
     * @param city
     * @param begin
     * @param end
     * @return
     */
    @Override
    public ArrayList<AreaLoginByDayPo> find(String city, int begin, int end) {
        Document query = new Document().append("city",city)
                .append("date",new Document().append("$gte",begin).append("$lte",end));
        return findByQuery(query);
    }

    @Override
    public ArrayList<AreaLoginByDayPo> find(int begin, int end) {
        Document query = new Document().append("date",new Document().append("$gte",begin).append("$lte",end));
        return findByQuery(query);
    }

    /**
     * 地级市数据查询
     * @param query
     * @return
     */
    private ArrayList<AreaLoginByDayPo> findByQuery(Document query){
        ArrayList<AreaLoginByDayPo> results =new ArrayList<AreaLoginByDayPo>();
        for (Document info:collectionInstance().find(query)){
            AreaLoginByDayPo result = new AreaLoginByDayPo();
            result.setTimes(info.getInteger("times",0));
            result.setDate(info.getInteger("date",0));
            result.setAreaId(info.getString("city"));
            Document users = info.get("users",Document.class);
            Document hards = info.get("hards",Document.class);
            if (users!=null) {
                result.setUsers1D1(users.getInteger("users1d1",0));
                result.setUsers3D1(users.getInteger("users3d1",0));
                result.setUsers7D1(users.getInteger("users7d1",0));
                result.setUsers14D1(users.getInteger("users14d1",0));
                result.setUsers30D1(users.getInteger("users30d1",0));
            }
            if (hards!=null) {
                result.setHards1D1(hards.getInteger("hards1d1",0));
                result.setHards3D1(hards.getInteger("hards3d1",0));
                result.setHards7D1(hards.getInteger("hards7d1",0));
                result.setHards14D1(hards.getInteger("hards14d1",0));
                result.setHards30D1(hards.getInteger("hards30d1",0));
            }
            results.add(result);
        }
        return results;
    }
}
