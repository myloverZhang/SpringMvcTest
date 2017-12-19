package ct.dc.mobile.api.dao.mobileHall;

import ct.dc.mobile.api.dao.RespositoryBase;
import ct.dc.mobile.api.dao.mobileHall.Interface.IHallRegByDayDao;
import ct.dc.mobile.api.model.po.mobilehall.HallRegByDayPo;
import org.bson.Document;
import org.springframework.beans.factory.annotation.Value;

import java.util.ArrayList;

/**
 * Created by B41-80 on 2017/1/13.
 */
public class HallRegByDayDao extends RespositoryBase implements IHallRegByDayDao{
    @Value("${mongo.uri}")
    public void setMongoUri(String mongoUri) {
        super.setMongoUri(mongoUri);
    }

    @Value("${mongo.hall}")
    public void setDataBaseName(String dataBaseName) {
        super.setDataBaseName(dataBaseName);
    }

    @Value("${mongo.hall.regByDay}")
    public void setCollectionName(String collectionName) {
        super.setCollectionName(collectionName);
    }

    /**
     * 多日注册信息查询
     * @param begin
     * @param end
     * @param hallId
     * @return
     */
    @Override
    public ArrayList<HallRegByDayPo> find(int begin, int end, int hallId) {
        Document query = new Document().append("group",hallId)
                .append("date",new Document().append("$gte",begin).append("$lte",end));
        return findByQuery(query);
    }

    /**
     * 查询
     * @return
     */
    private ArrayList<HallRegByDayPo> findByQuery(Document query){
        ArrayList<HallRegByDayPo> results = new ArrayList<HallRegByDayPo>();
        for (Document info:collectionInstance().find(query)){
            HallRegByDayPo result = new HallRegByDayPo();
            result.setGroup(info.getInteger("group",0));
            result.setUsers(info.getInteger("users",0));
            result.setHards(info.getInteger("hards",0));
            result.setDate(info.getInteger("date",0));
            results.add(result);
        }
        return results;
    }
}
