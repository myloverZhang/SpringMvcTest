package ct.dc.mobile.api.dao.mobilearea.login.callable;

import com.mongodb.client.MongoCollection;
import ct.dc.mobile.api.model.po.mobilearea.AreaAppLoginDetailsByDayPo;
import org.bson.Document;

import java.util.ArrayList;
import java.util.concurrent.Callable;

/**
 * Created by B41-80 on 2017/1/12.
 */
public class AreaAppDetailsAggregateCallable implements Callable<ArrayList<AreaAppLoginDetailsByDayPo>>{
    private ArrayList<Document> aggrDocument;
    private int type;
    private MongoCollection<Document> collectionInstance;

    public AreaAppDetailsAggregateCallable(ArrayList<Document> aggrDocument, int type, MongoCollection<Document> collectionInstance) {
        this.aggrDocument = aggrDocument;
        this.type = type;
        this.collectionInstance = collectionInstance;
    }

    @Override
    public ArrayList<AreaAppLoginDetailsByDayPo> call() throws Exception {
        ArrayList<AreaAppLoginDetailsByDayPo> results = new ArrayList<AreaAppLoginDetailsByDayPo>();
        for (Document info:collectionInstance.aggregate(aggrDocument).allowDiskUse(true)){
            AreaAppLoginDetailsByDayPo result = new AreaAppLoginDetailsByDayPo();
            result.setType(type);
            result.setDate(info.getInteger("_id",0));
            result.setTimes(info.getInteger("times",0));
            result.setLoginUnitNum(info.getInteger("loginUnitNum",0));
            results.add(result);
        }
        return results;
    }
}
