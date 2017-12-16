package ct.dc.pc.api.dao.area;

import ct.dc.pc.api.dao.RepositoryBase;
import ct.dc.pc.api.dao.area.helper.AreaLoginInfoHelper;
import ct.dc.pc.api.dao.area.interfaces.IDistrictLoginByDay;
import ct.dc.pc.api.model.po.area.AreaLoginByDayPo;
import org.bson.Document;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;

/**
 * Created by B41-80 on 2017/3/31.
 */
@Repository
public class DistrictLoginByDayDao extends RepositoryBase implements IDistrictLoginByDay{
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
    @Value("${mongo.area.districtLoginByDay}")
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
     * 通过县区信息查询多日登录数据
     *
     * @param district
     * @param beginDate
     * @param endDate
     * @return
     */
    public ArrayList<AreaLoginByDayPo> findByDistrict(String district, int beginDate, int endDate) {
        Document query = new Document().append("district",district)
                .append("date",new Document().append("$gte",beginDate).append("$lte",endDate));
        return findByDocuments(query);
    }

    /**
     * 根据条件查询县区多日登录数据
     * @param query
     * @return
     */
    private ArrayList<AreaLoginByDayPo> findByDocuments(Document query){
        ArrayList<AreaLoginByDayPo> results = new ArrayList<AreaLoginByDayPo>();
        for (Document info:collectionInstance().find(query)){
            AreaLoginByDayPo result = new AreaLoginByDayPo();
            result.setDate(info.getInteger("date",0));
            result.setAreaId(info.getString("district"));
            result.setTimes(info.getInteger("times",0));
            Document users = info.get("users",Document.class);
            Document hards = info.get("hards",Document.class);
            AreaLoginInfoHelper.getLoginDetailInfo(result,hards,users);
            results.add(result);
        }
        return results;
    }
}
