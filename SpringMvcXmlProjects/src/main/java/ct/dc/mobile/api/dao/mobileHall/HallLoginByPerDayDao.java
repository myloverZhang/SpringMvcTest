package ct.dc.mobile.api.dao.mobileHall;

import ct.dc.mobile.api.dao.RespositoryBase;
import ct.dc.mobile.api.dao.mobileHall.Interface.IHallLoginByPerDayDao;
import ct.dc.mobile.api.model.po.mobilehall.HallLoginByDayPo;
import ct.dc.mobile.api.model.po.mobilehall.HallLoginPerDayPo;
import org.bson.Document;
import org.springframework.beans.factory.annotation.Value;

import java.util.ArrayList;

/**
 * Created by B41-80 on 2017/1/13.
 */
public class HallLoginByPerDayDao extends RespositoryBase implements IHallLoginByPerDayDao{
    @Value("${mongo.uri}")
    public void setMongoUri(String mongoUri) {
        super.setMongoUri(mongoUri);
    }

    @Value("${mongo.hall}")
    public void setDataBaseName(String dataBaseName) {
        super.setDataBaseName(dataBaseName);
    }

    @Value("${mongo.hall.loginByPerDay}")
    public void setCollectionName(String collectionName) {
        super.setCollectionName(collectionName);
    }

    /**
     * 大厅单日登录
     * @param date
     * @param hallId
     * @return
     */

    @Override
    public ArrayList<HallLoginPerDayPo> find(int date, int hallId) {
        Document query = new Document().append("date",date)
                .append("group",hallId);
        return findByQuery(query);
    }

    /**
     * 查询
     * @param query
     * @return
     */
    private ArrayList<HallLoginPerDayPo> findByQuery(Document query){
        ArrayList<HallLoginPerDayPo> results = new ArrayList<HallLoginPerDayPo>();
        for (Document info:collectionInstance().find(query)){
            HallLoginPerDayPo result = new HallLoginPerDayPo();
            result.setGroup(info.getInteger("group",0));
            result.setUsers(info.getInteger("users",0));
            result.setTrange(info.getInteger("trange",0));
            result.setDate(info.getInteger("date",0));
            result.setHards(info.getInteger("hards",0));
            result.setTimes(info.getInteger("times",0));
            results.add(result);
        }
        return results;
    }

}
