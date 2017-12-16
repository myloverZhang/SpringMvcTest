package ct.dc.pc.api.dao.channel;

import ct.dc.pc.api.dao.RepositoryBase;
import ct.dc.pc.api.dao.channel.interfaces.IChannelBriefByDayDao;
import ct.dc.pc.api.model.po.channel.ChannelBriefByDayPo;
import org.bson.Document;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;

/**
 * Created by CTWLPC on 2017/6/12.
 */
@Repository
public class ChannelBriefByDayDao extends RepositoryBase implements IChannelBriefByDayDao{

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
    @Value("${mongo.channel.briefByDay}")
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
     * 通过日期查询全局渠道概要信息
     *
     * @param channel
     * @param beginDate
     * @param endDate
     * @param limitNum
     * @return
     */
    public ArrayList<ChannelBriefByDayPo> findByChannel(long channel, int beginDate, int endDate, int limitNum) {
        Document match = new Document().append("date",new Document().append("$gte",beginDate).append("$lte", endDate))
                .append("channel",channel);
        return findByDocuments(match, limitNum);
    }

    /**
     * 通过日期查询全局多个渠道的信息
     *
     * @param channels
     * @param beginDate
     * @param endDate
     * @param limitNum
     * @return
     */
    public ArrayList<ChannelBriefByDayPo> findByChannels(ArrayList<Long> channels, int beginDate, int endDate, int limitNum) {
        Document matchWithDates = new Document().
                append("date",new Document().append("$gte",beginDate).append("$lte", endDate));
        Document matchWithEndDate = new Document().append("date",endDate)
                .append("channel",new Document().append("$in",channels));
        return findByDocuments(matchWithDates, matchWithEndDate, limitNum);
    }

    /**
     * 通过日期查询渠道信息
     *
     * @param beginDate
     * @param endDate
     * @param limitNum
     * @return
     */
    @Override
    public ArrayList<ChannelBriefByDayPo> find(int beginDate, int endDate, int limitNum) {
        Document matchWithEndDate = new Document().append("date",endDate);
        Document matchWithDates = new Document().append("date",new Document().append("$gte",beginDate).append("$lte", endDate));
        return findByDocuments(matchWithDates, matchWithEndDate, limitNum);
    }

    /**
     * 通过日期查询数据
     *
     * @param beginDate
     * @param endDate
     * @return
     */
    @Override
    public ArrayList<ChannelBriefByDayPo> find(int beginDate, int endDate) {
        Document match = new Document().append("date", new Document().append("$gte", beginDate).append("$lte", endDate));
        return findByDocuments(match, Integer.MAX_VALUE);
    }

    /**
     * 查询某个渠道 某个日期的数据
     * @param match
     * @param limitNum
     * @return
     */
    private ArrayList<ChannelBriefByDayPo> findByDocuments(Document match, int limitNum){
        ArrayList<ChannelBriefByDayPo> results = new ArrayList<>();
        for (Document info:collectionInstance().find(match).
                sort(new Document().append("date",-1)).
                limit(limitNum)){
            results.add(parseEntity(info));
        }
        return results;
    }

    private ArrayList<ChannelBriefByDayPo> findByDocuments(Document matchWithDates,Document matchWithEndDate, int limitNum){
        ArrayList<ChannelBriefByDayPo> results = new ArrayList<>();
        ArrayList<Long> channels = new ArrayList<>();
        for (Document info:collectionInstance().find(matchWithEndDate).
                sort(new Document().append("hards.reg",-1).append("channel",-1)).
                limit(limitNum)){
            channels.add(Long.parseLong(info.get("channel").toString()));
        }
        matchWithDates.append("channel",new Document().append("$in",channels));
        for (Document info:collectionInstance().find(matchWithDates)){
            results.add(parseEntity(info));
        }
        return results;
    }


    /**
     * documents 转换成实体
     * @param info
     * @return
     */
    private ChannelBriefByDayPo parseEntity(Document info){
        ChannelBriefByDayPo result = new ChannelBriefByDayPo();
        result.setChannel(Long.parseLong(info.get("channel").toString()));
        result.setDate(info.getInteger("date"));
        Document users = info.get("users", Document.class);
        Document hards = info.get("hards", Document.class);
        if(users != null){
            result.setUsersLogin(Long.parseLong(users.containsKey("login")?users.get("login").toString():"0"));
            result.setUserReg(Long.parseLong(users.containsKey("reg")?users.get("reg").toString():"0"));
        }else{
            result.setUsersLogin(0L);
            result.setUserReg(0L);
        }
        if(hards != null){
            result.setHardsLogin(Long.parseLong(hards.containsKey("login")?hards.get("login").toString():"0"));
            result.setHardsReg(Long.parseLong(hards.containsKey("reg")?hards.get("reg").toString():"0"));
        }else{
            result.setHardsReg(0L);
            result.setHardsLogin(0L);
        }
        return result;
    }
 }
