package ct.dc.mobile.api.dao.mobilechannel;

import ct.dc.mobile.api.dao.RespositoryBase;
import ct.dc.mobile.api.dao.mobilechannel.Interface.IChannelRetainByDayDAO;
import ct.dc.mobile.api.model.po.mobilechannel.ChannelRetainPo;
import org.bson.Document;
import org.springframework.beans.factory.annotation.Value;

import java.util.ArrayList;

/**
 * Created by B41-80 on 2017/1/18.
 */
public class ChannelRetainByDayDAO extends RespositoryBase implements IChannelRetainByDayDAO{
    @Override
    @Value("${mongo.uri}")
    public void setMongoUri(String mongoUri) {
        super.setMongoUri(mongoUri);
    }

    @Override
    @Value("${mongo.channel}")
    public void setDataBaseName(String dataBaseName) {
        super.setDataBaseName(dataBaseName);
    }

    @Override
    @Value("${mongo.channel.retainByDay}")
    public void setCollectionName(String collectionName) {
        super.setCollectionName(collectionName);
    }

    @Override
    public ArrayList<ChannelRetainPo> find(int begin, int end, long app, Long channel) {
        Document query = new Document().append("date",new Document().append("$gte",begin).append("$lte",end))
                .append("app",app)
                .append("channel",channel);
        return findByQuery(query);
    }

    /**
     * 根据条件查询数据
     * @return
     */
    private ArrayList<ChannelRetainPo> findByQuery(Document query){
        ArrayList<ChannelRetainPo> results = new ArrayList<ChannelRetainPo>();
        for (Document info:collectionInstance().find(query)){
            ChannelRetainPo result = new ChannelRetainPo();
            result.setApp(info.getLong("app"));
            result.setChannel(info.getLong("channel"));
            result.setDate(info.getInteger("date",0));
            Document users = info.get("users",Document.class);
            Document hards = info.get("hards",Document.class);
            if (users != null){
                result.setUsersNew(users.getInteger("new",0));
                result.setUsersD1(users.getInteger("d1",0));
                result.setUsersD3(users.getInteger("d3",0));
                result.setUsersD7(users.getInteger("d7",0));
                result.setUsersD14(users.getInteger("d14",0));
                result.setUsersD30(users.getInteger("d30",0));
            }else   {
                result.setUsersNew(0);
                result.setUsersD1(0);
                result.setUsersD3(0);
                result.setUsersD7(0);
                result.setUsersD14(0);
                result.setUsersD30(0);
            }
            if (hards!=null){
                result.setHardsNew(hards.getInteger("new",0));
                result.setHardsD1(hards.getInteger("d1",0));
                result.setHardsD3(hards.getInteger("d3",0));
                result.setHardsD7(hards.getInteger("d7",0));
                result.setHardsD14(hards.getInteger("d14",0));
                result.setHardsD30(hards.getInteger("d30",0));
            }else {
                result.setHardsNew(0);
                result.setHardsD1(0);
                result.setHardsD3(0);
                result.setHardsD7(0);
                result.setHardsD14(0);
                result.setHardsD30(0);
            }
            results.add(result);
        }
        return results;
    }
}
