package ct.dc.mobile.api.dao.mobileHall;

import com.sun.org.apache.regexp.internal.RE;
import ct.dc.mobile.api.dao.RespositoryBase;
import ct.dc.mobile.api.dao.mobileHall.Interface.IHallLoginByDayDao;
import ct.dc.mobile.api.model.po.mobilehall.HallLoginByDayPo;
import org.bson.Document;
import org.springframework.beans.factory.annotation.Value;

import java.util.ArrayList;

/**
 * Created by B41-80 on 2017/1/13.
 */
public class HallLoginByDayDao extends RespositoryBase implements IHallLoginByDayDao{
    @Value("${mongo.uri}")
    public void setMongoUri(String mongoUri) {
        super.setMongoUri(mongoUri);
    }

    @Value("${mongo.hall}")
    public void setDataBaseName(String dataBaseName) {
        super.setDataBaseName(dataBaseName);
    }

    @Value("${mongo.hall.loginByDay}")
    public void setCollectionName(String collectionName) {
        super.setCollectionName(collectionName);
    }

    /**
     * 大厅多日登录查询
     * @param begin
     * @param end
     * @param hallId
     * @return
     */
    public ArrayList<HallLoginByDayPo> find(int begin, int end, int hallId) {
        Document query = new Document().append("date",new Document().append("$gte",begin).append("$lte",end))
                .append("group",hallId);
        return findByQuery(query);
    }

    /**
     * 查询
     * @return
     */
    private ArrayList<HallLoginByDayPo> findByQuery(Document query){
        ArrayList<HallLoginByDayPo> results = new ArrayList<HallLoginByDayPo>();
        for (Document info:collectionInstance().find(query)){
            HallLoginByDayPo result = new HallLoginByDayPo();
            result.setTimes(info.getInteger("times",0));
            result.setDate(info.getInteger("date",0));
            result.setGroup(info.getInteger("group",0));
            Document users = info.get("users",Document.class);
            Document hards = info.get("hards",Document.class);
            if (users!=null) {
                result.setUsers1D1(users.getInteger("users1d1",0));
                result.setUsers3D1(users.getInteger("users3d1",0));
                result.setUsers7D1(users.getInteger("users7d1",0));
                result.setUsers14D1(users.getInteger("users14d1",0));
                result.setUsers30D1(users.getInteger("users30d1",0));
            }
            if (hards!=null) {
                result.setHards1D1(hards.getInteger("hards1d1",0));
                result.setHards3D1(hards.getInteger("hards3d1",0));
                result.setHards7D1(hards.getInteger("hards7d1",0));
                result.setHards14D1(hards.getInteger("hards14d1",0));
                result.setHards30D1(hards.getInteger("hards30d1",0));
            }
            results.add(result);
        }
        return results;
    }

}
