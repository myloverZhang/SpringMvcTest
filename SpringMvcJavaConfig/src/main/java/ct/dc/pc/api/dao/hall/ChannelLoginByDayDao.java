package ct.dc.pc.api.dao.hall;

import ct.dc.pc.api.dao.RepositoryBase;
import ct.dc.pc.api.dao.hall.interfaces.IChannelLoginByDayDao;
import ct.dc.pc.api.model.po.hall.HallChannelLoginByDayPo;
import org.bson.Document;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;

/**
 * Created by CTWLPC on 2017/6/13.
 */
@Repository(value = "hallChannelLoginByDayDao")
public class ChannelLoginByDayDao extends RepositoryBase implements IChannelLoginByDayDao{
    @Override
    @Value("${mongo.stats.uri}")
    public void setMongoUri(String mongoUri) {
        super.setMongoUri(mongoUri);
    }

    @Override
    @Value("${mongo.hall}")
    public void setDataBaseName(String dataBaseName) {
        super.setDataBaseName(dataBaseName);
    }

    @Override
    @Value("${mongo.hall.channelLoginByDay}")
    public void setCollectionName(String collectionName) {
        super.setCollectionName(collectionName);
    }
    @Override
    @Value("${mongo.stats.userName}")
    public void setUserName(String userName) {
        super.setUserName(userName);
    }

    @Override
    @Value("${mongo.stats.passWord}")
    public void setPassWord(String passWord) {
        super.setPassWord(passWord);
    }
    @Override
    public ArrayList<HallChannelLoginByDayPo> find(long channel, long group, int beginDate, int endDate) {
        Document match = new Document().append("channel",channel)
                .append("group", group)
                .append("date",new Document().append("$gte",beginDate).append("$lte",endDate));
        return findByDocument(match);
    }
    private ArrayList<HallChannelLoginByDayPo> findByDocument(Document match){
        ArrayList<HallChannelLoginByDayPo> results = new ArrayList<>();
        for (Document info:collectionInstance().find(match)){
            HallChannelLoginByDayPo result = new HallChannelLoginByDayPo();
            result.setChannel(Long.parseLong(info.get("channel").toString()));
            result.setDate(info.getInteger("date"));
            result.setGroup(Long.parseLong(info.get("group").toString()));
            result.setTimes(Long.parseLong(info.get("times").toString()));
            Document users = info.get("users",Document.class);
            Document hards = info.get("hards", Document.class);
            if (users != null){
                result.setUsers1D1(Long.parseLong(users.get("users1d1") != null?users.get("users1d1").toString():"0"));
                result.setUsers3D1(Long.parseLong(users.get("users3d1") != null?users.get("users3d1").toString():"0"));
                result.setUsers7D1(Long.parseLong(users.get("users7d1") != null?users.get("users7d1").toString():"0"));
                result.setUsers14D1(Long.parseLong(users.get("users14d1") != null?users.get("users14d1").toString():"0"));
                result.setUsers30D1(Long.parseLong(users.get("users30d1") != null?users.get("users30d1").toString():"0"));
            }else{
                result.setUsers1D1(0L);
                result.setUsers3D1(0L);
                result.setUsers7D1(0L);
                result.setUsers14D1(0L);
                result.setUsers30D1(0L);
            }
            if (hards != null){
                result.setHards1D1(Long.parseLong(hards.get("hards1d1") != null?hards.get("hards1d1").toString():"0"));
                result.setHards3D1(Long.parseLong(hards.get("hards3d1") != null?hards.get("hards3d1").toString():"0"));
                result.setHards7D1(Long.parseLong(hards.get("hards7d1") != null?hards.get("hards7d1").toString():"0"));
                result.setHards14D1(Long.parseLong(hards.get("hards14d1") != null?hards.get("hards14d1").toString():"0"));
                result.setHards30D1(Long.parseLong(hards.get("hards30d1") != null?hards.get("hards30d1").toString():"0"));
            }else{
                result.setHards1D1(0L);
                result.setHards3D1(0L);
                result.setHards7D1(0L);
                result.setHards14D1(0L);
                result.setHards30D1(0L);
            }
            results.add(result);
        }
        return results;
    }
}
