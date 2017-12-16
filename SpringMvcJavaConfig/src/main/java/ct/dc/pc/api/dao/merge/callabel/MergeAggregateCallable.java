package ct.dc.pc.api.dao.merge.callabel;

import com.mongodb.client.MongoCollection;
import ct.dc.pc.api.model.po.merge.MergeLoginByDayPo;
import org.bson.Document;

import java.util.ArrayList;
import java.util.concurrent.Callable;

/**
 * Created by B41-80 on 2017/4/5.
 */
public class MergeAggregateCallable implements Callable<ArrayList<MergeLoginByDayPo>>{
    private MongoCollection<Document> collection;
    private int type;
    private ArrayList<Document> aggregateDocuments;

    public MergeAggregateCallable(MongoCollection<Document> collection, int type,
                                  ArrayList<Document> aggregateDocuments) {
        this.collection = collection;
        this.type = type;
        this.aggregateDocuments = aggregateDocuments;
    }

    public void setCollection(MongoCollection<Document> collection) {
        this.collection = collection;
    }

    public void setType(int type) {
        this.type = type;
    }

    public void setAggregateDocuments(ArrayList<Document> aggregateDocuments) {
        this.aggregateDocuments = aggregateDocuments;
    }

    /**
     * Computes a result, or throws an exception if unable to do so.
     *
     * @return computed result
     * @throws Exception if unable to compute a result
     */
    public ArrayList<MergeLoginByDayPo> call() throws Exception {
        ArrayList<MergeLoginByDayPo> results = new ArrayList<MergeLoginByDayPo>();
        for (Document info:collection.aggregate(aggregateDocuments).allowDiskUse(true)){
            MergeLoginByDayPo result = new MergeLoginByDayPo();
            result.setId(info.getInteger("_id",0));
            result.setType(type);
            result.setTimes(info.getInteger("times",0));
            result.setLoginUnitNum(info.getInteger("loginUnitNum",0));
            results.add(result);
        }
        return results;
    }
}
