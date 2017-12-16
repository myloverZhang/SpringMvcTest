package ct.dc.pc.api.dao.hall;

import ct.dc.pc.api.dao.RepositoryBase;
import ct.dc.pc.api.dao.hall.interfaces.IChannelRetainByDayDao;
import ct.dc.pc.api.model.po.hall.HallChannelRetainByDayPo;
import org.bson.Document;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;

/**
 * Created by CTWLPC on 2017/6/13.
 */
@Repository(value = "hallChannelRetainByDayDao")
public class ChannelRetainByDayDao extends RepositoryBase implements IChannelRetainByDayDao{
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
    @Value("${mongo.hall.channelRetainByDay}")
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
    /**
     * 通过渠道和大厅信息获取渠道留存
     *
     * @param channel
     * @param group
     * @param beginDate
     * @param endDate
     * @return
     */
    @Override
    public ArrayList<HallChannelRetainByDayPo> find(long channel, long group, int beginDate, int endDate) {
        Document match = new Document().append("channel",channel)
                .append("group",group)
                .append("date",new Document().append("$gte",beginDate).append("$lte",endDate));
        return findByDocument(match);
    }
    private ArrayList<HallChannelRetainByDayPo> findByDocument(Document match){
        ArrayList<HallChannelRetainByDayPo> results = new ArrayList<>();
        for (Document info:collectionInstance().find(match)){
            HallChannelRetainByDayPo result = new HallChannelRetainByDayPo();
            result.setChannel(Long.parseLong(info.get("channel").toString()));
            result.setDate(info.getInteger("date"));
            result.setGroup(Long.parseLong(info.get("group").toString()));
            Document users = info.get("users",Document.class);
            Document hards = info.get("hards",Document.class);
            if (users != null){
                result.setUsersNew(Long.parseLong(users.get("new") != null?users.get("new").toString():"0"));
                result.setUsersD1(Long.parseLong(users.get("d1")!=null?users.get("d1").toString():"0"));
                result.setUsersD3(Long.parseLong(users.get("d3")!=null?users.get("d3").toString():"0"));
                result.setUsersD7(Long.parseLong(users.get("d7")!=null?users.get("d7").toString():"0"));
                result.setUsersD14(Long.parseLong(users.get("d14")!=null?users.get("d14").toString():"0"));
                result.setUsersD30(Long.parseLong(users.get("d30")!=null?users.get("d30").toString():"0"));
            }else{
                result.setUsersNew(0L);
                result.setUsersD1(0L);
                result.setUsersD3(0L);
                result.setUsersD7(0L);
                result.setUsersD14(0L);
                result.setUsersD30(0L);
            }
            if(hards != null){
                result.setHardsNew(Long.parseLong(hards.get("new")!=null?hards.get("new").toString():"0"));
                result.setHardsD1(Long.parseLong(hards.get("d1")!=null?hards.get("d1").toString():"0"));
                result.setHardsD3(Long.parseLong(hards.get("d3")!=null?hards.get("d3").toString():"0"));
                result.setHardsD7(Long.parseLong(hards.get("d7")!=null?hards.get("d7").toString():"0"));
                result.setHardsD14(Long.parseLong(hards.get("d14")!=null?hards.get("d14").toString():"0"));
                result.setHardsD30(Long.parseLong(hards.get("d30")!=null?hards.get("d30").toString():"0"));
            }else {
                result.setHardsNew(0L);
                result.setHardsD1(0L);
                result.setHardsD3(0L);
                result.setHardsD7(0L);
                result.setHardsD14(0L);
                result.setHardsD30(0L);
            }
            results.add(result);
        }
        return results;
    }
}
