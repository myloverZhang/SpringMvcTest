package ct.dc.mobile.api.dao.mobilechannel;

import ct.dc.mobile.api.dao.RespositoryBase;
import ct.dc.mobile.api.dao.mobilechannel.Interface.IChannelBriefByDayDAO;
import ct.dc.mobile.api.model.po.mobilechannel.ChannelBriefPo;
import org.bson.Document;
import org.springframework.beans.factory.annotation.Value;

import java.util.ArrayList;

/**
 * Created by B41-80 on 2017/1/18.
 */
public class ChannelBriefByDayDAO extends RespositoryBase implements IChannelBriefByDayDAO {
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
    @Value("${mongo.channel.briefByDay}")
    public void setCollectionName(String collectionName) {
        super.setCollectionName(collectionName);
    }

    /**
     * 通过一个渠道查询
     * @param begin
     * @param end
     * @param app
     * @param channel
     * @return
     */
    @Override
    public ArrayList<ChannelBriefPo> find(int begin, int end, long app, Long channel) {
        Document query = new Document().append("date",new Document().append("$gte",begin).append("$lte",end))
                .append("app",app)
                .append("channel",channel);
        return findByQuery(query);
    }

    /**
     * 通过多个渠道查询
     * @param begin
     * @param end
     * @param app
     * @param channels
     * @return
     */
    @Override
    public ArrayList<ChannelBriefPo> find(int begin, int end, long app, ArrayList<Long> channels) {
        Document query = new Document().append("date",new Document().append("$gte",begin).append("$lte",end))
                .append("app",app)
                .append("channel",new Document().append("$in",channels));
        return findByQuery(query);
    }

    @Override
    public ArrayList<ChannelBriefPo> find(int begin, int end, long app) {
        Document query = new Document().append("date",new Document().append("$gte",begin).append("$lte",end))
                .append("app",app);
        return findByQuery(query);
    }

    /**
     * 通过查询条件查询数据
     * @return
     */
    private ArrayList<ChannelBriefPo> findByQuery(Document query){
        ArrayList<ChannelBriefPo> results = new ArrayList<ChannelBriefPo>();
        for (Document info:collectionInstance().find(query)){
            ChannelBriefPo result = new ChannelBriefPo();
            result.setApp(info.getLong("app"));
            result.setChannel(info.getLong("channel"));
            result.setDate(info.getInteger("date"));
            Document users = info.get("users",Document.class);
            Document hards = info.get("hards",Document.class);
            if (users!=null){
                result.setUsersFirstLogin(users.getInteger("new",0));
                result.setUsersLogin(users.getInteger("login",0));
                result.setUsersReg(users.getInteger("reg",0));
            }else {
                result.setUsersFirstLogin(0);
                result.setUsersLogin(0);
                result.setUsersReg(0);
            }
            if (hards!=null){
                result.setHardsFirstLogin(hards.getInteger("new",0));
                result.setHardsLogin(hards.getInteger("login",0));
                result.setHardsReg(hards.getInteger("reg",0));
            }else {
                result.setHardsFirstLogin(0);
                result.setHardsLogin(0);
                result.setHardsReg(0);
            }
            results.add(result);
        }
        return results;
    }
}
