package ct.dc.pc.api.dao.channel;

import ct.dc.pc.api.dao.RepositoryBase;
import ct.dc.pc.api.dao.channel.interfaces.IChannelRetainByWeekDao;
import ct.dc.pc.api.model.po.channel.ChannelRetainByWeekPo;
import org.bson.Document;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;

/**
 * Created by CTWLPC on 2017/9/7.
 */
@Repository
public class ChannelRetainByWeekDao extends RepositoryBase implements IChannelRetainByWeekDao{
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
    @Value("${mongo.channel.retainByWeek}")
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
     * 通过日期查询渠道全局多日登录
     *
     * @param beginDate
     * @param endDate
     * @param limitNum
     * @return
     */
    @Override
    public ArrayList<ChannelRetainByWeekPo> find(int beginDate, int endDate, int limitNum) {
        Document matchWithDates = new Document().append("week",new Document().append("$gte",beginDate).append("$lte",endDate));
        Document matchWithEndDate = new Document().append("week",endDate);
        return findByDocument(matchWithDates, matchWithEndDate, limitNum);
    }

    /**
     * 根据日期查询数据
     *
     * @param beginDate
     * @param endDate
     * @return
     */
    @Override
    public ArrayList<ChannelRetainByWeekPo> find(int beginDate, int endDate) {
        Document match = new Document().append("week",new Document().append("$gte", beginDate).append("$lte", endDate));
        return findByDocument(match, Integer.MAX_VALUE);
    }

    /**
     * 通过日期和渠道id获取全局多日登录
     *
     * @param channel
     * @param beginDate
     * @param endDate
     * @param limitNum
     * @return
     */
    @Override
    public ArrayList<ChannelRetainByWeekPo> findByChannel(long channel, int beginDate, int endDate, int limitNum) {
        Document match = new Document().append("channel",channel)
                .append("week",new Document().append("$gte",beginDate).append("$lte",endDate));
        return findByDocument(match, limitNum);
    }

    /**
     * 通过日期和多个渠道id获取全局多日登录
     *
     * @param channels
     * @param beginDate
     * @param endDate
     * @param limitNum
     * @return
     */
    @Override
    public ArrayList<ChannelRetainByWeekPo> findByChannels(ArrayList<Long> channels, int beginDate, int endDate, int limitNum) {
        Document matchWithDates = new Document().
                append("week",new Document().append("$gte",beginDate).append("$lte",endDate));
        Document matchWithEndDate = new Document().append("channel",new Document().append("$in",channels))
                .append("week",endDate);
        return findByDocument(matchWithDates, matchWithEndDate, limitNum);
    }

    private ArrayList<ChannelRetainByWeekPo> findByDocument(Document match, int limitNum) {
        ArrayList<ChannelRetainByWeekPo> results = new ArrayList<>();
        for (Document info:collectionInstance().find(match).
                sort(new Document().append("week",-1)).
                limit(limitNum)){
            results.add(parseEntity(info));
        }
        return results;

    }
    private ArrayList<ChannelRetainByWeekPo> findByDocument(Document matchWithDates, Document matchWithEndDate, int limitNum) {
        ArrayList<ChannelRetainByWeekPo> results = new ArrayList<>();
        ArrayList<Long> channels = new ArrayList<>();
        for (Document info:collectionInstance().find(matchWithEndDate).
                sort(new Document().append("hards.new",-1).append("channel",-1)).
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
     * 关系映射
     * @param info
     * @return
     */
    private ChannelRetainByWeekPo parseEntity(Document info){
        ChannelRetainByWeekPo result = new ChannelRetainByWeekPo();
        result.setChannel(Long.parseLong(info.get("channel").toString()));
        result.setDate(info.getInteger("week"));
        Document users = info.get("users",Document.class);
        Document hards = info.get("hards",Document.class);
        if (users != null){
            result.setUsersNew(Long.parseLong(users.get("new") != null?users.get("new").toString():"0"));
            result.setUsersW1(Long.parseLong(users.get("w1")!=null?users.get("w1").toString():"0"));
            result.setUsersW2(Long.parseLong(users.get("w2")!=null?users.get("w2").toString():"0"));
            result.setUsersW3(Long.parseLong(users.get("w3")!=null?users.get("w3").toString():"0"));
            result.setUsersW4(Long.parseLong(users.get("w4")!=null?users.get("w4").toString():"0"));
        }else{
            result.setUsersNew(0L);
            result.setUsersW1(0L);
            result.setUsersW2(0L);
            result.setUsersW3(0L);
            result.setUsersW4(0L);
        }
        if(hards != null){
            result.setHardsNew(Long.parseLong(hards.get("new")!=null?hards.get("new").toString():"0"));
            result.setHardsW1(Long.parseLong(hards.get("w1")!=null?hards.get("w1").toString():"0"));
            result.setHardsW2(Long.parseLong(hards.get("w2")!=null?hards.get("w2").toString():"0"));
            result.setHardsW3(Long.parseLong(hards.get("w3")!=null?hards.get("w3").toString():"0"));
            result.setHardsW4(Long.parseLong(hards.get("w4")!=null?hards.get("w4").toString():"0"));
        }else {
            result.setHardsNew(0L);
            result.setHardsW1(0L);
            result.setHardsW2(0L);
            result.setHardsW3(0L);
            result.setHardsW4(0L);
        }
        return result;
    }
}
