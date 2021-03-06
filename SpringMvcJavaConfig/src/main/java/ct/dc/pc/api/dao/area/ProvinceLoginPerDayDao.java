package ct.dc.pc.api.dao.area;

import ct.dc.pc.api.dao.RepositoryBase;
import ct.dc.pc.api.dao.area.interfaces.IProvinceLoginPerDayDao;
import ct.dc.pc.api.model.po.area.AreaLoginPerDayPo;
import org.bson.Document;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;

/**
 * Created by B41-80 on 2017/3/31.
 */
@Repository
public class ProvinceLoginPerDayDao extends RepositoryBase implements IProvinceLoginPerDayDao{
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
    @Value("${mongo.area.provinceLoginPerDay}")
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
     * 根据省份查询单日登录数据
     *
     * @param province
     * @param date
     * @return
     */
    public ArrayList<AreaLoginPerDayPo> findByProvince(String province, int date) {
        Document query = new Document().append("province",province)
                .append("date",date);
        return findByDocument(query);
    }

    /**
     * 根据条件获取数据
     * @return
     */
    private ArrayList<AreaLoginPerDayPo> findByDocument(Document query){
        ArrayList<AreaLoginPerDayPo> results = new ArrayList<AreaLoginPerDayPo>();
        for (Document info:collectionInstance().find(query)){
            AreaLoginPerDayPo result = new AreaLoginPerDayPo();
            result.setAreaId(info.getString("province"));
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
