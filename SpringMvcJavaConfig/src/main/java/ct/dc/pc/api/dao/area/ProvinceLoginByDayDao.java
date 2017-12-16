package ct.dc.pc.api.dao.area;

import ct.dc.pc.api.dao.RepositoryBase;
import ct.dc.pc.api.dao.area.helper.AreaLoginInfoHelper;
import ct.dc.pc.api.dao.area.interfaces.IProvinceLoginByDayDao;
import ct.dc.pc.api.model.po.area.AreaLoginByDayPo;
import org.bson.Document;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;

/**
 * Created by B41-80 on 2017/3/31.
 */
@Repository
public class ProvinceLoginByDayDao extends RepositoryBase implements IProvinceLoginByDayDao{
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
    @Value("${mongo.area.provinceLoginByDay}")
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
     * 根据省份后期多日登录数据
     *
     * @param province
     * @param beginDate
     * @param endDate
     * @return
     */
    public ArrayList<AreaLoginByDayPo> findByProvince(String province, int beginDate, int endDate) {
        Document query = new Document().append("province",province)
                .append("date",new Document().append("$gte",beginDate).append("$lte",endDate));
        return findByDocument(query);
    }
    /**
     * 根据条件查询数据
     */
    private ArrayList<AreaLoginByDayPo> findByDocument(Document query){
        ArrayList<AreaLoginByDayPo> results = new ArrayList<AreaLoginByDayPo>();
        for (Document info:collectionInstance().find(query)){
            AreaLoginByDayPo result = new AreaLoginByDayPo();
            result.setTimes(info.getInteger("times",0));
            result.setDate(info.getInteger("date",0));
            result.setAreaId(info.getString("province"));
            Document hards = info.get("hards",Document.class);
            Document users = info.get("users",Document.class);
            AreaLoginInfoHelper.getLoginDetailInfo(result,hards,users);
            results.add(result);
        }
        return results;
    }
}
