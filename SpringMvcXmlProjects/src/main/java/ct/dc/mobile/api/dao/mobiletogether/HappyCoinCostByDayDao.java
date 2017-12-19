package ct.dc.mobile.api.dao.mobiletogether;

import ct.dc.mobile.api.dao.RespositoryBase;
import ct.dc.mobile.api.dao.mobiletogether.interfaces.IHappyCoinCostByDayDao;
import ct.dc.mobile.api.model.po.mobilehappycoin.AppCostByDayPo;
import org.bson.Document;
import org.springframework.beans.factory.annotation.Value;

import java.util.ArrayList;

/**
 * Created by CTWLPC on 2017/5/11.
 */
public class HappyCoinCostByDayDao extends RespositoryBase implements IHappyCoinCostByDayDao{
    @Override
    @Value("${mongo.stats.uri}")
    public void setMongoUri(String mongoUri) {
        super.setMongoUri(mongoUri);
    }

    @Override
    @Value("${mongo.happyCoin}")
    public void setDataBaseName(String dataBaseName) {
        super.setDataBaseName(dataBaseName);
    }

    @Override
    @Value("${mongo.happyCoin.costByDay}")
    public void setCollectionName(String collectionName) {
        super.setCollectionName(collectionName);
    }

    @Override
    public ArrayList<AppCostByDayPo> findByApp(long app, int beginDate, int endDate) {
        Document query = new Document().append("app",app)
                .append("date",new Document().append("$gte",beginDate).append("$lte",endDate));
        return findByDocuments(query);
    }

    private ArrayList<AppCostByDayPo> findByDocuments(Document query){
        ArrayList<AppCostByDayPo> results = new ArrayList<>();
        for (Document info:collectionInstance().find(query)){
            AppCostByDayPo result = new AppCostByDayPo();
            result.setApp(Long.valueOf(info.get("app").toString()));
            result.setCost(Long.valueOf(info.get("cost").toString()));
            result.setDate(info.getInteger("date"));
            result.setNum(info.getInteger("num"));
            result.setTimes(info.getInteger("times"));
            results.add(result);
        }
        return results;
    }
}
