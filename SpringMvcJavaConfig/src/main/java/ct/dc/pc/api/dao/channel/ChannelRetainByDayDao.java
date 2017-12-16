package ct.dc.pc.api.dao.channel;

import ct.dc.pc.api.dao.RepositoryBase;
import ct.dc.pc.api.dao.channel.interfaces.IChannelRetainByDayDao;
import ct.dc.pc.api.model.po.channel.ChannelRetainByDayPo;
import org.bson.Document;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;

/**
 * Created by CTWLPC on 2017/6/12.
 */
@Repository
public class ChannelRetainByDayDao extends RepositoryBase implements IChannelRetainByDayDao{
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
    @Value("${mongo.channel.retainByDay}")
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
     * 根据渠道信息查询留存
     *
     * @param channel
     * @param beginDate
     * @param endDate
     * @param limitNum
     * @return
     */
    @Override
    public ArrayList<ChannelRetainByDayPo> findByChannel(long channel, int beginDate, int endDate, int limitNum) {
        Document match = new Document().append("channel",channel)
                .append("date",new Document().append("$gte",beginDate).append("$lte",endDate));
        return findByDocument(match, limitNum);
    }

    /**
     * 根据日期查询留存
     *
     * @param beginDate
     * @param endDate
     * @param limitNum
     * @return
     */
    @Override
    public ArrayList<ChannelRetainByDayPo> find(int beginDate, int endDate, int limitNum) {
        Document matchWithDates = new Document().append("date",new Document().append("$gte",beginDate).append("$lte",endDate));
        Document matchWithEndDate = new Document().append("date",endDate);
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
    public ArrayList<ChannelRetainByDayPo> find(int beginDate, int endDate) {
        Document match = new Document().append("date", new Document().append("$gte", beginDate).append("$lte", endDate));
        return findByDocument(match, Integer.MAX_VALUE);
    }

    /**
     * 根据渠道信息查询留存
     *
     * @param channels
     * @param beginDate
     * @param endDate
     * @param limitNum
     * @return
     */
    @Override
    public ArrayList<ChannelRetainByDayPo> findByChannels(ArrayList<Long> channels, int beginDate, int endDate, int limitNum) {
        Document matchWithDates = new Document().
                append("date",new Document().append("$gte",beginDate).append("$lte",endDate));
        Document matchWithEndDate = new Document().append("channel",new Document().append("$in",channels))
                .append("date",endDate);
        return findByDocument(matchWithDates, matchWithEndDate, limitNum);
    }

    private ArrayList<ChannelRetainByDayPo> findByDocument(Document match, int limitNum) {
        ArrayList<ChannelRetainByDayPo> results = new ArrayList<>();
        for (Document info:collectionInstance().find(match).
                sort(new Document().append("date", -1)).
                limit(limitNum)){
            results.add(parseEntity(info));
        }
        return results;
    }

    private ArrayList<ChannelRetainByDayPo> findByDocument(Document matchWithDates, Document matchWithEndDate, int limitNum) {
        ArrayList<ChannelRetainByDayPo> results = new ArrayList<>();
        ArrayList<Long> channels = new ArrayList<>();
        for (Document info:collectionInstance().find(matchWithEndDate).
                sort(new Document().append("hards.new", -1).append("channel",-1)).
                limit(limitNum)){
            channels.add(Long.parseLong(info.get("channel").toString()));
        }
        matchWithDates.append("channel",new Document().append("$in",channels));
        for (Document info: collectionInstance().find(matchWithDates)){
            results.add(parseEntity(info));
        }
        return results;
    }


    /**
     * 关系映射
     * @param info
     * @return
     */
    private ChannelRetainByDayPo parseEntity(Document info){
        ChannelRetainByDayPo result = new ChannelRetainByDayPo();
        result.setChannel(Long.parseLong(info.get("channel").toString()));
        result.setDate(info.getInteger("date"));
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
        return result;
    }
}
