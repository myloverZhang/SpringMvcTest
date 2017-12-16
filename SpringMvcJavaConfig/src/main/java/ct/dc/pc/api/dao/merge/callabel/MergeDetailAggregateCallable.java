package ct.dc.pc.api.dao.merge.callabel;

import com.mongodb.client.MongoCollection;
import ct.dc.pc.api.model.po.merge.MergeLoginDetailsByDayPo;
import org.bson.Document;

import java.util.ArrayList;
import java.util.concurrent.Callable;

/**
 * Created by B41-80 on 2017/4/5.
 */
public class MergeDetailAggregateCallable implements Callable<ArrayList<MergeLoginDetailsByDayPo>>{
    private ArrayList<Document> aggregateDocuments;
    private Integer type;
    private MongoCollection<Document> collection;

    public MergeDetailAggregateCallable(ArrayList<Document> aggregateDocuments, Integer type,
                                        MongoCollection<Document> collection) {
        this.aggregateDocuments = aggregateDocuments;
        this.type = type;
        this.collection = collection;
    }

    /**
     * Computes a result, or throws an exception if unable to do so.
     *
     * @return computed result
     * @throws Exception if unable to compute a result
     */
    public ArrayList<MergeLoginDetailsByDayPo> call() throws Exception {
        ArrayList<MergeLoginDetailsByDayPo> results = new ArrayList<MergeLoginDetailsByDayPo>();
        for (Document info:collection.aggregate(aggregateDocuments).allowDiskUse(true)){
            MergeLoginDetailsByDayPo result = new MergeLoginDetailsByDayPo();
            result.setDate(info.getInteger("_id",0));
            result.setTimes(info.getInteger("times",0));
            result.setType(type);
            result.setLoginUnitNum(info.getInteger("loginUnitNum",0));
            results.add(result);
        }
        return results;
    }
}
