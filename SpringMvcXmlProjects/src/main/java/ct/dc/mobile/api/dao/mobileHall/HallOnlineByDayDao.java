package ct.dc.mobile.api.dao.mobileHall;

import ct.dc.mobile.api.dao.RespositoryBase;
import ct.dc.mobile.api.dao.mobileHall.Interface.IHallOnlineByDayDao;
import ct.dc.mobile.api.model.po.mobilehall.HallOnlineByDayPo;
import org.bson.Document;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scripting.support.RefreshableScriptTargetSource;

import java.util.ArrayList;

/**
 * Created by B41-80 on 2017/1/13.
 */
public class HallOnlineByDayDao extends RespositoryBase implements IHallOnlineByDayDao{

    @Value("${mongo.uri}")
    public void setMongoUri(String mongoUri) {
        super.setMongoUri(mongoUri);
    }

    @Value("${mongo.hall}")
    public void setDataBaseName(String dataBaseName) {
        super.setDataBaseName(dataBaseName);
    }

    @Value("${mongo.hall.onlineByDay}")
    public void setCollectionName(String collectionName) {
        super.setCollectionName(collectionName);
    }

    /**
     * 多日在线查询
     * @param begin
     * @param end
     * @param hallId
     * @return
     */
    @Override
    public ArrayList<HallOnlineByDayPo> find(int begin, int end, int hallId) {
        Document query = new Document().append("group",hallId)
                .append("date",new Document().append("$gte",begin).append("$lte",end));
        return findByQuery(query);
    }

    /**
     * 查询
     * @param query
     * @return
     */
    private ArrayList<HallOnlineByDayPo> findByQuery(Document query){
        ArrayList<HallOnlineByDayPo> results = new ArrayList<HallOnlineByDayPo>();
        for (Document info:collectionInstance().find(query)){
            HallOnlineByDayPo result = new HallOnlineByDayPo();
            result.setDate(info.getInteger("date",0));
            result.setGroup(info.getInteger("group",0));
            result.setAvgUsers(info.getInteger("avgusers",0));
            result.setMaxUsers(info.getInteger("maxusers",0));
            results.add(result);
        }
        return results;
    }
}
