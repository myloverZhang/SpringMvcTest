package ct.dc.pc.api.dao.area;

import ct.dc.pc.api.dao.RepositoryBase;
import ct.dc.pc.api.dao.area.interfaces.IDistrictRegByDayDao;
import ct.dc.pc.api.model.po.area.AreaRegByDayPo;
import org.bson.Document;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;

/**
 * Created by B41-80 on 2017/3/31.
 */
@Repository
public class DistrictRegByDayDao extends RepositoryBase implements IDistrictRegByDayDao{
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
    @Value("${mongo.area.districtRegByDay}")
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
     * 根据县区和日期查找数据
     *
     * @param district
     * @param beginDate
     * @param endDate
     * @return
     */
    public ArrayList<AreaRegByDayPo> findByDistrict(String district, int beginDate, int endDate) {
        Document query = new Document().append("district",district)
                .append("date",new Document().append("$gte",beginDate).append("$lte",endDate));
        return findByDocument(query);
    }

    /**
     * 根据条件获取注册数据
     * @param query
     * @return
     */
    private ArrayList<AreaRegByDayPo> findByDocument(Document query){
        ArrayList<AreaRegByDayPo> results = new ArrayList<AreaRegByDayPo>();
        for (Document info:collectionInstance().find(query)){
            AreaRegByDayPo result = new AreaRegByDayPo();
            result.setDate(info.getInteger("date",0));
            result.setAreaId(info.getString("district"));
            result.setUsers(info.getInteger("users",0));
            result.setHards(info.getInteger("hards",0));
            results.add(result);
        }
        return results;
    }
}
