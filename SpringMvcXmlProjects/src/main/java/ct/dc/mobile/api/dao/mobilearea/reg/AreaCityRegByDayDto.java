package ct.dc.mobile.api.dao.mobilearea.reg;

import ct.dc.mobile.api.dao.RespositoryBase;
import ct.dc.mobile.api.dao.mobilearea.Interface.IAreaCityRegByDayDao;
import ct.dc.mobile.api.model.po.mobilearea.AreaRegByDayPo;
import org.bson.Document;
import org.springframework.beans.factory.annotation.Value;

import java.util.ArrayList;

/**
 * Created by B41-80 on 2017/1/11.
 */
public class AreaCityRegByDayDto extends RespositoryBase implements IAreaCityRegByDayDao {
    @Value("${mongo.uri}")
    public void setMongoUri(String mongoUri) {
        super.setMongoUri(mongoUri);
    }

    @Value("${mongo.area}")
    public void setDataBaseName(String dataBaseName) {
        super.setDataBaseName(dataBaseName);
    }

    @Value("${mongo.area.cityRegByDay}")
    public void setCollectionName(String collectionName) {
        super.setCollectionName(collectionName);
    }

    /**
     * 地级市注册信息
     * @param begin
     * @param end
     * @param city
     * @return
     */
    @Override
    public ArrayList<AreaRegByDayPo> find(int begin, int end, String city) {
        Document query = new Document().append("city",city)
                .append("date",new Document().append("$gte",begin).append("$lte",end));
        return findByQuery(query);
    }

    @Override
    public ArrayList<AreaRegByDayPo> find(int begin, int end) {
        Document query = new Document().append("date",new Document().append("$lte",end).append("$gte",begin));
        return findByQuery(query);
    }

    /**
     * 地级市注册信息查询
     * @param query
     * @return
     */
    private ArrayList<AreaRegByDayPo> findByQuery(Document query){
        ArrayList<AreaRegByDayPo> results = new ArrayList<AreaRegByDayPo>();
        for (Document info:collectionInstance().find(query)){
            AreaRegByDayPo result = new AreaRegByDayPo();
            result.setAreaId(info.getString("city"));
            result.setHards(info.getInteger("hards",0));
            result.setUsers(info.getInteger("users",0));
            result.setDate(info.getInteger("date",0));
            results.add(result);
        }
        return results;
    }
}
