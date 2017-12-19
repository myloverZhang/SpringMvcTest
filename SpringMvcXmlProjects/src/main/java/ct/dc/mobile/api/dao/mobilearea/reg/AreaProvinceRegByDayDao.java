package ct.dc.mobile.api.dao.mobilearea.reg;

import ct.dc.mobile.api.dao.RespositoryBase;
import ct.dc.mobile.api.dao.mobilearea.Interface.IAreaProvinceRegByDayDao;
import ct.dc.mobile.api.model.po.mobilearea.AreaRegByDayPo;
import org.bson.Document;
import org.springframework.beans.factory.annotation.Value;

import java.util.ArrayList;

/**
 * Created by B41-80 on 2017/1/11.
 */
public class AreaProvinceRegByDayDao extends RespositoryBase implements IAreaProvinceRegByDayDao {
    @Value("${mongo.uri}")
    public void setMongoUri(String mongoUri) {
        super.setMongoUri(mongoUri);
    }

    @Value("${mongo.area}")
    public void setDataBaseName(String dataBaseName) {
        super.setDataBaseName(dataBaseName);
    }

    @Value("${mongo.area.provinceRegByDay}")
    public void setCollectionName(String collectionName) {
        super.setCollectionName(collectionName);
    }

    /**
     * 省份的多日注册信息
     * @param begin
     * @param end
     * @param province
     * @return
     */
    @Override
    public ArrayList<AreaRegByDayPo> find(int begin, int end, String province) {
        Document query = new Document().append("province",province)
                .append("date",new Document().append("$gte",begin).append("$lte",end));
        return findByQuery(query);
    }

    /**
     * 省份的多日注册信息
     * @return
     */
    private ArrayList<AreaRegByDayPo> findByQuery(Document query){
        ArrayList<AreaRegByDayPo> results = new ArrayList<AreaRegByDayPo>();
        for (Document info:collectionInstance().find(query)){
            AreaRegByDayPo result = new AreaRegByDayPo();
            result.setDate(info.getInteger("date",0));
            result.setUsers(info.getInteger("users",0));
            result.setHards(info.getInteger("hards",0));
            result.setAreaId(info.getString("province"));
            results.add(result);
        }
        return results;
    }
}
