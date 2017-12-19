package ct.dc.mobile.api.dao.mobilearea.login.callable;

import com.mongodb.client.MongoCollection;
import ct.dc.mobile.api.model.po.mobileapp.AppAreaLoginDetailByDayPo;
import org.bson.Document;

import java.util.ArrayList;
import java.util.concurrent.Callable;

/**
 * Created by B41-80 on 2017/1/12.
 */
public class AppAreaDetailsAggregateCallable implements Callable<ArrayList<AppAreaLoginDetailByDayPo>>{
    private ArrayList<Document> aggrDocument;
    private int type;
    private MongoCollection<Document> collectionInstance;

    public AppAreaDetailsAggregateCallable(ArrayList<Document> aggrDocument, int type, MongoCollection<Document> collectionInstance) {
        this.aggrDocument = aggrDocument;
        this.type = type;
        this.collectionInstance = collectionInstance;
    }

    @Override
    public ArrayList<AppAreaLoginDetailByDayPo> call() throws Exception {
        ArrayList<AppAreaLoginDetailByDayPo> results = new ArrayList<AppAreaLoginDetailByDayPo>();
        for (Document info:collectionInstance.aggregate(aggrDocument).allowDiskUse(true)){
            AppAreaLoginDetailByDayPo result = new AppAreaLoginDetailByDayPo();
            result.setType(type);
            result.setLoginUnitNum(info.getInteger("loginUnitNum",0));
            result.setTimes(info.getInteger("times",0));
            result.setDate(info.getInteger("_id",0));
            results.add(result);
        }
        return results;
    }
}
