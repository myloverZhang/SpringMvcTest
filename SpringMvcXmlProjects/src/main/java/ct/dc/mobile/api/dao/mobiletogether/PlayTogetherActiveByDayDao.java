package ct.dc.mobile.api.dao.mobiletogether;

import com.sun.org.apache.regexp.internal.RESyntaxException;
import ct.dc.mobile.api.dao.RespositoryBase;
import ct.dc.mobile.api.dao.mobiletogether.interfaces.IPlayTogetherActiveByDayDao;
import ct.dc.mobile.api.model.po.mobileplaytogether.AppActiveByDayPo;
import org.bson.Document;
import org.springframework.beans.factory.annotation.Value;

import java.util.ArrayList;

/**
 * Created by CTWLPC on 2017/5/11.
 */
public class PlayTogetherActiveByDayDao extends RespositoryBase implements IPlayTogetherActiveByDayDao{
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
    @Value("${mongo.active.activeByDay}")
    public void setCollectionName(String collectionName) {
        super.setCollectionName(collectionName);
    }

    @Override
    public ArrayList<AppActiveByDayPo> findByApp(long app, int beginDate, int endDate) {
        Document query = new Document().append("app",app)
                .append("date",new Document().append("$gte",beginDate).append("$lte",endDate));
        return findByDocument(query);
    }
    private ArrayList<AppActiveByDayPo> findByDocument(Document query){
        ArrayList<AppActiveByDayPo> results =  new ArrayList<>();
        for (Document info:collectionInstance().find(query)){
            AppActiveByDayPo result = new AppActiveByDayPo();;
            result.setAccount(info.getInteger("account",0));
            result.setApp(Long.valueOf(info.get("app").toString()));
            result.setHard(info.getInteger("hard",0));
            result.setDate(info.getInteger("date",0));
            result.setTimes(info.getInteger("times",0));
            results.add(result);
        }
        return results;
    }
}
