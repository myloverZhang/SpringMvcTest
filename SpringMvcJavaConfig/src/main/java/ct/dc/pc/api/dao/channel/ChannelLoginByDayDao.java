package ct.dc.pc.api.dao.channel;

import ct.dc.pc.api.dao.RepositoryBase;
import ct.dc.pc.api.dao.channel.interfaces.IChannelLoginByDayDao;
import ct.dc.pc.api.model.po.channel.ChannelLoginByDayPo;
import org.bson.Document;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;

/**
 * Created by CTWLPC on 2017/6/12.
 */
@Repository
public class ChannelLoginByDayDao extends RepositoryBase implements IChannelLoginByDayDao{
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
    public ArrayList<ChannelLoginByDayPo> find(int beginDate, int endDate, int limitNum) {
        Document matchWithDates = new Document().append("date",new Document().append("$gte", beginDate).append("$lte", endDate));
        Document matchWithEndDate = new Document().append("date", endDate);
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
    public ArrayList<ChannelLoginByDayPo> find(int beginDate, int endDate) {
        Document match = new Document().append("date", new Document().append("$gte", beginDate).append("$lte", endDate));
        return findByDocuments(match, Integer.MAX_VALUE);
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
    public ArrayList<ChannelLoginByDayPo> findByChannel(long channel, int beginDate, int endDate, int limitNum) {
        Document match = new Document().append("channel", channel)
                .append("date",new Document().append("$gte", beginDate).append("$lte", endDate));
        return findByDocuments(match, limitNum);
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
    public ArrayList<ChannelLoginByDayPo> findByChannels(ArrayList<Long> channels, int beginDate, int endDate, int limitNum) {
        Document matchWithEndDate = new Document().append("channel", new Document().append("$in",channels))
                .append("date",endDate);
        Document matchWithDates = new Document()
                .append("date",new Document().append("$gte", beginDate).append("$lte", endDate));
        return findByDocuments(matchWithDates, matchWithEndDate, limitNum);
    }

    private ArrayList<ChannelLoginByDayPo> findByDocuments(Document match, int limitNum){
        ArrayList<ChannelLoginByDayPo> results = new ArrayList<>();
        for (Document info:collectionInstance().find(match).
                sort(new Document().append("date",-1)).
                limit(limitNum)){
            results.add(parseEntity(info));
        }
        return results;
    }

    private ArrayList<ChannelLoginByDayPo> findByDocuments(Document matchWithDates, Document matchWithEndDate, int limitNum){
        ArrayList<ChannelLoginByDayPo> results = new ArrayList<>();
        ArrayList<Long> channels = new ArrayList<>();
        for (Document info:collectionInstance().find(matchWithEndDate).
                sort(new Document().append("hards.hards1d1",-1).append("channel",-1)).
                limit(limitNum)){
            channels.add(Long.parseLong(info.get("channel").toString()));
        }
        matchWithDates.append("channel",new Document().append("$in", channels));
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
    private ChannelLoginByDayPo parseEntity(Document info){
        ChannelLoginByDayPo result = new ChannelLoginByDayPo();
        result.setChannel(Long.parseLong(info.get("channel").toString()));
        result.setDate(info.getInteger("date"));
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
        return result;
    }
}
