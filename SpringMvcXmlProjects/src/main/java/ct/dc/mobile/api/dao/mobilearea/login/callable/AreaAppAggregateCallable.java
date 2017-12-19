package ct.dc.mobile.api.dao.mobilearea.login.callable;

import com.mongodb.client.MongoCollection;
import ct.dc.mobile.api.model.po.mobilearea.AreaAppLoginByDayPo;
import org.bson.Document;

import java.util.ArrayList;
import java.util.concurrent.Callable;

/**
 * Created by B41-80 on 2017/1/12.
 */
public class AreaAppAggregateCallable implements Callable<ArrayList<AreaAppLoginByDayPo>>{
    private ArrayList<Document> aggrDocument;
    private int type;
    private MongoCollection<Document> collectionInstance;

    public AreaAppAggregateCallable(ArrayList<Document> aggrDocument, int type, MongoCollection<Document> collectionInstance) {
        this.aggrDocument = aggrDocument;
        this.type = type;
        this.collectionInstance = collectionInstance;
    }

    @Override
    public ArrayList<AreaAppLoginByDayPo> call() throws Exception {
        ArrayList<AreaAppLoginByDayPo> results = new ArrayList<AreaAppLoginByDayPo>();
        for (Document info:collectionInstance.aggregate(aggrDocument).allowDiskUse(true)){
            AreaAppLoginByDayPo result = new AreaAppLoginByDayPo();
            result.setId(info.getLong("_id"));
            result.setLoginUnitNum(info.getInteger("loginUnitNum",0));
            result.setTimes(info.getInteger("times",0));
            result.setType(type);
            results.add(result);
        }
        return results;
    }
}
