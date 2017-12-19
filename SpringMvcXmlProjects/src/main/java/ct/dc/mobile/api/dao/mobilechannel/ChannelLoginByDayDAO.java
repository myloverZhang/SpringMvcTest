package ct.dc.mobile.api.dao.mobilechannel;

import ct.dc.mobile.api.dao.RespositoryBase;
import ct.dc.mobile.api.dao.mobilechannel.Interface.IChannelLoginByDayDAO;
import ct.dc.mobile.api.model.po.mobilechannel.ChannelLoginPo;
import org.bson.Document;
import org.springframework.beans.factory.annotation.Value;

import java.nio.channels.Channel;
import java.util.ArrayList;

/**
 * Created by B41-80 on 2017/1/18.
 */
public class ChannelLoginByDayDAO extends RespositoryBase implements IChannelLoginByDayDAO{

    @Override
    @Value("${mongo.stats.uri}")
    public void setMongoUri(String mongoUri) {
        super.setMongoUri(mongoUri);
    }

    @Override
    @Value("${mongo.channel}")
    public void setDataBaseName(String dataBaseName) {
        super.setDataBaseName(dataBaseName);
    }

    @Override
    @Value("${mongo.channel.loginByDay}")
    public void setCollectionName(String collectionName) {
        super.setCollectionName(collectionName);
    }

    @Override
    public ArrayList<ChannelLoginPo> find(int begin, int end, long app, Long channel) {
        Document query = new Document().append("date",new Document().append("$gte",begin).append("$lte",end))
                .append("app",app)
                .append("channel",channel);
        return findByQuery(query);
    }

    /**
     * 查询
     * @return
     */
    private ArrayList<ChannelLoginPo> findByQuery(Document query){
        ArrayList<ChannelLoginPo> results = new ArrayList<ChannelLoginPo>();
        for (Document info:collectionInstance().find(query)){
            ChannelLoginPo result = new ChannelLoginPo();
            result.setDate(info.getInteger("date",0));
            result.setChannel(Long.valueOf(info.get("channel").toString()));
            result.setTimes(info.getInteger("times",0));
            result.setApp(Long.valueOf(info.get("app").toString()));
            Document users = info.get("users",Document.class);
            Document hards = info.get("hards",Document.class);
            if (users!=null){
                result.setUsers1D1(users.getInteger("users1d1",0));
                result.setUsers3D1(users.getInteger("users3d1",0));
                result.setUsers7D1(users.getInteger("users7d1",0));
                result.setUsers14D1(users.getInteger("users14d1",0));
                result.setUsers30D1(users.getInteger("users30d1",0));
            }else {
                result.setUsers1D1(0);
                result.setUsers3D1(0);
                result.setUsers7D1(0);
                result.setUsers14D1(0);
                result.setUsers30D1(0);
            }
            if (hards!=null){
                result.setHards1D1(hards.getInteger("hards1d1",0));
                result.setHards3D1(hards.getInteger("hards3d1",0));
                result.setHards7D1(hards.getInteger("hards7d1",0));
                result.setHards14D1(hards.getInteger("hards14d1",0));
                result.setHards30D1(hards.getInteger("hards30d1",0));
            }else {
                result.setHards1D1(0);
                result.setHards3D1(0);
                result.setHards7D1(0);
                result.setHards14D1(0);
                result.setHards30D1(0);
            }
            results.add(result);
        }
        return results;
    }
}
