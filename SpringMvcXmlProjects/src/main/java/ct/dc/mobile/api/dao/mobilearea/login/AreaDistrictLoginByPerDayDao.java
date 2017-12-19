package ct.dc.mobile.api.dao.mobilearea.login;

import ct.dc.mobile.api.dao.RespositoryBase;
import ct.dc.mobile.api.dao.mobilearea.Interface.IAreaDistrictLoginByPerDayDao;
import ct.dc.mobile.api.model.po.mobilearea.AreaLoginByPerDayPo;
import org.bson.Document;
import org.springframework.beans.factory.annotation.Value;

import java.util.ArrayList;

/**
 * Created by B41-80 on 2017/1/11.
 */
public class AreaDistrictLoginByPerDayDao extends RespositoryBase implements IAreaDistrictLoginByPerDayDao {
    @Value("${mongo.uri}")
    public void setMongoUri(String mongoUri) {
        super.setMongoUri(mongoUri);
    }

    @Value("${mongo.area}")
    public void setDataBaseName(String dataBaseName) {
        super.setDataBaseName(dataBaseName);
    }

    @Value("${mongo.area.districtLoginByPerDay}")
    public void setCollectionName(String collectionName) {
        super.setCollectionName(collectionName);
    }

    /**
     * 县区单日登录
     * @param district
     * @param date
     * @return
     */
    @Override
    public ArrayList<AreaLoginByPerDayPo> find(String district, int date) {
        Document query = new Document().append("district",district).append("date",date);
        return findByQuery(query);
    }

    /**
     * 查询县区单日登录
     * @param query
     * @return
     */
    private ArrayList<AreaLoginByPerDayPo> findByQuery(Document query){
        ArrayList<AreaLoginByPerDayPo> results = new ArrayList<AreaLoginByPerDayPo>();
        for (Document info:collectionInstance().find(query)){
            AreaLoginByPerDayPo result = new AreaLoginByPerDayPo();
            result.setAreaId(info.getString("district"));
            result.setDate(info.getInteger("date",0));
            result.setTrange(info.getInteger("trange",0));
            result.setUsers(info.getInteger("users",0));
            result.setHards(info.getInteger("hards",0));
            result.setTimes(info.getInteger("times",0));
            results.add(result);
        }
        return results;
    }
}
