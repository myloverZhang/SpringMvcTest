package ct.dc.mobile.api.dao.mobilearea.login.callable;

import com.mongodb.client.MongoCollection;
import ct.dc.mobile.api.model.po.mobileapp.AppAreaLoginByDayPo;
import org.bson.Document;

import java.util.ArrayList;
import java.util.concurrent.Callable;

/**
 * Created by B41-80 on 2017/1/12.
 */
public class AppAreaAggregateCallable implements Callable<ArrayList<AppAreaLoginByDayPo>> {
    private ArrayList<Document> aggrDocument;
    private int type;
    private MongoCollection<Document> collectionInstance;

    public AppAreaAggregateCallable(ArrayList<Document> aggrDocument, int type, MongoCollection<Document> collectionInstance) {
        this.aggrDocument = aggrDocument;
        this.type = type;
        this.collectionInstance = collectionInstance;
    }

    @Override
    public ArrayList<AppAreaLoginByDayPo> call() throws Exception {
        ArrayList<AppAreaLoginByDayPo> results = new ArrayList<AppAreaLoginByDayPo>();
        for (Document info : collectionInstance.aggregate(aggrDocument).allowDiskUse((true))) {
            AppAreaLoginByDayPo result = new AppAreaLoginByDayPo();
            result.setType(type);
            result.setId(info.getString("_id"));
            result.setLoginUnitNum(info.getInteger("loginUnitNum", 0));
            result.setTimes(info.getInteger("times"));
            results.add(result);
        }
        return results;
    }
}
