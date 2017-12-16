package ct.dc.pc.api.dao.hall;

import ct.dc.pc.api.dao.RepositoryBase;
import ct.dc.pc.api.dao.hall.interfaces.IChannelBriefByDayDao;
import ct.dc.pc.api.model.po.hall.HallChannelBriefByDayPo;
import org.bson.Document;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;

/**
 * Created by CTWLPC on 2017/6/13.
 */
@Repository("hallChannelBriefByDayDao")
public class ChannelBriefByDayDao extends RepositoryBase implements IChannelBriefByDayDao{
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
    @Value("${mongo.hall.channelBriefByDay}")
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
     * 通过渠道和大厅获取渠道概要信息
     *
     * @param channel
     * @param group
     * @param beginDate
     * @param endDate
     * @return
     */
    @Override
    public ArrayList<HallChannelBriefByDayPo> findByChannel(long channel, long group, int beginDate, int endDate) {
        Document match = new Document().append("channel",channel)
                .append("group",group)
                .append("date",new Document().append("$gte",beginDate).append("$lte",endDate));
        return findByDocuments(match);
    }

    /**
     * 通过日期查询所有渠道概要信息
     *
     * @param group
     * @param beginDate
     * @param endDate
     * @return
     */
    @Override
    public ArrayList<HallChannelBriefByDayPo> find(long group, int beginDate, int endDate) {
        Document match = new Document().append("group", group)
                .append("date",new Document().append("$gte",beginDate).append("$lte",endDate));
        return findByDocuments(match);
    }

    /**
     * 根据多个渠道和大厅信息获取概要信息
     *
     * @param channels
     * @param group
     * @param beginDate
     * @param endDate
     * @return
     */
    @Override
    public ArrayList<HallChannelBriefByDayPo> findByChannels(ArrayList<Long> channels, long group, int beginDate, int endDate) {
        Document match = new Document().append("channel",new Document().append("$in",channels))
                .append("group",group)
                .append("date",new Document().append("$gte",beginDate).append("$lte",endDate));
        return findByDocuments(match);
    }

    private ArrayList<HallChannelBriefByDayPo> findByDocuments(Document match){
        ArrayList<HallChannelBriefByDayPo> results = new ArrayList<>();
        for (Document info:collectionInstance().find(match)){
            HallChannelBriefByDayPo result = new HallChannelBriefByDayPo();
            result.setChannel(Long.parseLong(info.get("channel").toString()));
            result.setDate(info.getInteger("date"));
            result.setGroup(Long.parseLong(info.get("group").toString()));
            Document users = info.get("users", Document.class);
            Document hards = info.get("hards", Document.class);
            if(users != null){
                result.setUsersLogin(Long.parseLong(users.get("login").toString()));
                result.setUserReg(Long.parseLong(users.get("reg").toString()));
                result.setUserFirstLogin(Long.parseLong(users.get("firstlogin").toString()));
            }else{
                result.setUsersLogin(0L);
                result.setUserReg(0L);
                result.setUserFirstLogin(0L);
            }
            if(hards != null){
                result.setHardsLogin(Long.parseLong(hards.get("login").toString()));
                result.setHardsReg(Long.parseLong(hards.get("reg").toString()));
                result.setHardsFirstLogin(Long.parseLong(hards.get("firstlogin").toString()));
            }else{
                result.setHardsReg(0L);
                result.setHardsLogin(0L);
                result.setHardsFirstLogin(0L);
            }
            results.add(result);
        }
        return results;
    }
}
