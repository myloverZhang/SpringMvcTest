package ct.dc.mobile.api.dao.mobiletogether;

import ct.dc.mobile.api.dao.RespositoryBase;
import ct.dc.mobile.api.dao.mobiletogether.interfaces.IPlayTogetherActiveRetainByDay;
import ct.dc.mobile.api.model.po.mobileplaytogether.AppActiveRetainByDayPo;
import org.bson.Document;
import org.springframework.beans.factory.annotation.Value;

import java.util.ArrayList;

/**
 * Created by CTWLPC on 2017/8/15.
 */
public class PlayTogetherActiveRetainByDayDao extends RespositoryBase implements IPlayTogetherActiveRetainByDay{
    @Override
    @Value("${mongo.stats.uri}")
    public void setMongoUri(String mongoUri) {
        super.setMongoUri(mongoUri);
    }

    @Override
    @Value("${mongo.active}")
    public void setDataBaseName(String dataBaseName) {
        super.setDataBaseName(dataBaseName);
    }

    @Override
    @Value("${mongo.active.retainByDay}")
    public void setCollectionName(String collectionName) {
        super.setCollectionName(collectionName);
    }

    /**
     * 获取多日游戏活跃数据
     *
     * @param appId
     * @param beginDate
     * @param endDate
     * @return
     */
    @Override
    public ArrayList<AppActiveRetainByDayPo> listAppActiveByDayIfs(long appId, int beginDate, int endDate) {
        Document match = new Document().append("app",appId)
                .append("date",new Document().append("$gte",beginDate).append("$lte",endDate));
        return findByDocument(match);
    }

    /**
     * 条件查找
     * @param query
     * @return
     */
    public ArrayList<AppActiveRetainByDayPo> findByDocument(Document query){
        ArrayList<AppActiveRetainByDayPo> results = new ArrayList<>();
        for (Document info:collectionInstance().find(query)){
            AppActiveRetainByDayPo result = new AppActiveRetainByDayPo();
            result.setApp(Long.valueOf(info.get("app").toString()));
            result.setDate(info.getInteger("date"));
            Document users = info.get("users",Document.class);
            Document hards = info.get("hards",Document.class);
            if (users != null){
                result.setUsersNew(users.getInteger("new",0));
                result.setUsersD1(users.getInteger("d1",0));
                result.setUsersD3(users.getInteger("d3",0));
                result.setUsersD7(users.getInteger("d7",0));
                result.setUsersD14(users.getInteger("d14",0));
                result.setUsersD30(users.getInteger("d30",0));
            } else {
                result.setUsersNew(0);
                result.setUsersD1(0);
                result.setUsersD3(0);
                result.setUsersD7(0);
                result.setUsersD14(0);
                result.setUsersD30(0);
            }
            if (hards != null){
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
