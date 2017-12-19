package ct.dc.mobile.api.dao.mobilearea.reg;

import ct.dc.mobile.api.dao.RespositoryBase;
import ct.dc.mobile.api.dao.mobilearea.Interface.IAreaNationRegByDayDao;
import ct.dc.mobile.api.model.po.mobilearea.AreaRegByDayPo;
import org.bson.Document;
import org.springframework.beans.factory.annotation.Value;

import java.util.ArrayList;

/**
 * Created by B41-80 on 2017/1/11.
 */
public class AreaNationRegByDayDao extends RespositoryBase implements IAreaNationRegByDayDao {

    @Value("${mongo.uri}")
    public void setMongoUri(String mongoUri) {
        super.setMongoUri(mongoUri);
    }

    @Value("${mongo.area}")
    public void setDataBaseName(String dataBaseName) {
        super.setDataBaseName(dataBaseName);
    }

    @Value("${mongo.area.nationRegByDay}")
    public void setCollectionName(String collectionName) {
        super.setCollectionName(collectionName);
    }

    /**
     * 全国注册信息
     * @param begin
     * @param end
     * @param areaId
     * @return
     */
    @Override
    public ArrayList<AreaRegByDayPo> find(int begin, int end) {
        Document query = new Document().append("date",new Document().append("$gte",begin).append("$lte",end));
        return findByQuery(query);
    }

    /**
     * 全国范围注册信息查询
     * @param query
     * @return
     */
    private ArrayList<AreaRegByDayPo> findByQuery(Document query){
        ArrayList<AreaRegByDayPo> results = new ArrayList<AreaRegByDayPo>();
        for (Document info:collectionInstance().find(query)){
            AreaRegByDayPo result = new AreaRegByDayPo();
            result.setHards(info.getInteger("hards",0));
            result.setUsers(info.getInteger("users",0));
            result.setDate(info.getInteger("date",0));
            results.add(result);
        }
        return results;
    }
}
