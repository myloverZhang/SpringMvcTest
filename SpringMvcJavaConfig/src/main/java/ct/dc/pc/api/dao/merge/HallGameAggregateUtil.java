package ct.dc.pc.api.dao.merge;

import com.mongodb.client.MongoCollection;
import ct.dc.pc.api.dao.merge.callabel.MergeAggregateCallable;
import ct.dc.pc.api.dao.merge.callabel.MergeDetailAggregateCallable;
import ct.dc.pc.api.enums.StatTypeEnum;
import ct.dc.pc.api.model.po.merge.MergeLoginByDayPo;
import ct.dc.pc.api.model.po.merge.MergeLoginDetailsByDayPo;
import org.bson.Document;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;

/**
 * Created by B41-80 on 2017/4/5.
 */
@Repository
public class HallGameAggregateUtil {
    /**
     * 一级界面账号维度一次聚合条件
     * @return
     */
    private static Document getAggrAccountDocumentOnceByHall(){
        Document aggregateDocument = new Document().append("_id",new Document().append("uid","$uid")
                .append("hall","$group"))
                .append("times",new Document().append("$sum","$times"));
        return aggregateDocument;
    }
    /**
     * 一级界面账号维度一次聚合条件
     * @return
     */
    private static Document getAggrAccountDocumentOnceByGame(){
        Document aggregateDocument = new Document().append("_id",new Document().append("uid","$uid")
                .append("game","$game"))
                .append("times",new Document().append("$sum","$times"));
        return aggregateDocument;
    }
    /**
     * 一级界面设备维度一次聚合条件
     * @return
     */
    private static Document getAggrHardDocumentOnceByHall(){
        Document aggregateDocument = new Document().append("_id",new Document().append("hard","$hard")
                .append("hall","$group"))
                .append("times",new Document().append("$sum","$times"));
        return aggregateDocument;
    }
    /**
     * 一级界面设备维度一次聚合条件
     * @return
     */
    private static Document getAggrHardDocumentOnceByGame(){
        Document aggregateDocument = new Document().append("_id",new Document().append("hard","$hard")
                .append("game","$game"))
                .append("times",new Document().append("$sum","$times"));
        return aggregateDocument;
    }
    /**
     * 一级界面二次聚合条件
     * @return
     */
    private static Document getAggrDocumentTwiceByHall(){
        Document aggregateDocument = new Document().append("_id","$_id.hall")
                .append("loginUnitNum",new Document().append("$sum",1))
                .append("times",new Document().append("$sum","$times"));
        return aggregateDocument;
    }

    /**
     * 一级界面二次聚合条件
     * @return
     */
    private static Document getAggrDocumentTwiceByGame(){
        Document aggregateDocument = new Document().append("_id","$_id.game")
                .append("loginUnitNum",new Document().append("$sum",1))
                .append("times",new Document().append("$sum","$times"));
        return aggregateDocument;
    }
    /**
     * 二级界面设备维度聚合条件
     * @return
     */
    private static Document getAggregateHardDetailDocumentOnce(){
        Document aggregateDocument = new Document().append("_id",new Document().append("hard","$hard")
                .append("date","$date"))
                .append("times",new Document().append("$sum","$times"));
        return aggregateDocument;
    }

    /**
     * 二级界面账号维度聚合条件
     * @return
     */
    private static Document getAggregateAccountDetailDocumentsOnce(){
        Document aggregateDocument = new Document().append("_id",new Document().append("uid","$uid")
                .append("date","$date"))
                .append("times",new Document().append("$sum","$times"));
        return aggregateDocument;
    }

    private static Document getAggregateDetailDocumentsTwice(){
        Document aggregateDocument = new Document().append("_id","$_id.date")
                .append("times",new Document().append("$sum","$times"))
                .append("loginUnitNum",new Document().append("$sum",1));
        return aggregateDocument;
    }


    /**
     * 一级界面设备维度聚合条件
     * @param match
     * @return
     */
    private static ArrayList<Document> listAggrHardDocumentsByHall(Document match){
        ArrayList<Document> aggregateDocuments = new ArrayList<Document>();
        aggregateDocuments.add(new Document().append("$match",match));
        aggregateDocuments.add(new Document().append("$group", getAggrHardDocumentOnceByHall()));
        aggregateDocuments.add(new Document().append("$group", getAggrDocumentTwiceByHall()));
        return aggregateDocuments;
    }
    /**
     * 一级界面设备维度聚合条件
     * @param match
     * @return
     */
    private static ArrayList<Document> listAggrHardDocumentsByGame(Document match){
        ArrayList<Document> aggregateDocuments = new ArrayList<Document>();
        aggregateDocuments.add(new Document().append("$match",match));
        aggregateDocuments.add(new Document().append("$group", getAggrHardDocumentOnceByGame()));
        aggregateDocuments.add(new Document().append("$group", getAggrDocumentTwiceByGame()));
        return aggregateDocuments;
    }
    /**
     * 一级界面账号维度聚合条件
     * @param match
     * @return
     */
    private static ArrayList<Document> listAggrAccountDocumentsByHall(Document match){
        ArrayList<Document> aggregateDocuments = new ArrayList<Document>();
        aggregateDocuments.add(new Document().append("$match",match));
        aggregateDocuments.add(new Document().append("$group", getAggrAccountDocumentOnceByHall()));
        aggregateDocuments.add(new Document().append("$group", getAggrDocumentTwiceByHall()));
        return aggregateDocuments;
    }
    /**
     * 一级界面账号维度聚合条件
     * @param match
     * @return
     */
    private static ArrayList<Document> listAggrAccountDocumentsByGame(Document match){
        ArrayList<Document> aggregateDocuments = new ArrayList<Document>();
        aggregateDocuments.add(new Document().append("$match",match));
        aggregateDocuments.add(new Document().append("$group", getAggrAccountDocumentOnceByGame()));
        aggregateDocuments.add(new Document().append("$group", getAggrDocumentTwiceByGame()));
        return aggregateDocuments;
    }
    /**
     * 二级界面 设备维度聚合条件
     * @param match
     * @return
     */
    private static ArrayList<Document> listAggregateHardDetailDocuments(Document match){
        ArrayList<Document> aggregateDocuments = new ArrayList<Document>();
        aggregateDocuments.add(new Document().append("$match",match));
        aggregateDocuments.add(new Document().append("$group",getAggregateHardDetailDocumentOnce()));
        aggregateDocuments.add(new Document().append("$group",getAggregateDetailDocumentsTwice()));
        return aggregateDocuments;
    }

    /**
     * 二级界面 账号维度聚合条件
     * @param match
     * @return
     */
    private static ArrayList<Document> listAggregateAccountDetailDocuments(Document match){
        ArrayList<Document> aggregateDocuments = new ArrayList<Document>();
        aggregateDocuments.add(new Document().append("$match",match));
        aggregateDocuments.add(new Document().append("$group",getAggregateAccountDetailDocumentsOnce()));
        aggregateDocuments.add(new Document().append("$group",getAggregateDetailDocumentsTwice()));
        return aggregateDocuments;
    }


    /**
     * 一级界面  根据game聚合的一级界面数据
     * @param pool
     * @param collection
     * @param match
     * @return
     */
    public static ArrayList<MergeLoginByDayPo> listHallGameLoginInfo(ExecutorService pool,
                                                                     MongoCollection<Document> collection,Document match)
            throws ExecutionException, InterruptedException {
        ArrayList<MergeLoginByDayPo> hallGameResults = new ArrayList<MergeLoginByDayPo>();
        ArrayList<Document> hardAggrDocuments = listAggrHardDocumentsByGame(match);
        ArrayList<Document> accountAggrDocuments = listAggrAccountDocumentsByGame(match);
        MergeAggregateCallable hardCallable = new MergeAggregateCallable(collection, StatTypeEnum.HARD.getValue(),
                hardAggrDocuments);
        MergeAggregateCallable accountCallable = new MergeAggregateCallable(collection,StatTypeEnum.ACCOUNT.getValue(),
                accountAggrDocuments);
        Future<ArrayList<MergeLoginByDayPo>> hardResult = pool.submit(hardCallable);
        Future<ArrayList<MergeLoginByDayPo>> accountResult = pool.submit(accountCallable);
        hallGameResults.addAll(hardResult.get());
        hallGameResults.addAll(accountResult.get());
        return hallGameResults;
    }
    /**
     * 一级界面  根据hallid聚合的一级界面数据
     * @param pool
     * @param collection
     * @param match
     * @return
     */
    public static ArrayList<MergeLoginByDayPo> listGameHallLoginInfo(ExecutorService pool,
                                                                     MongoCollection<Document> collection, Document match) throws ExecutionException, InterruptedException {
        ArrayList<MergeLoginByDayPo> hallGameResults = new ArrayList<MergeLoginByDayPo>();
        ArrayList<Document> hardAggrDocuments = listAggrHardDocumentsByHall(match);
        ArrayList<Document> accountAggrDocuments = listAggrAccountDocumentsByHall(match);
        MergeAggregateCallable hardCallable = new MergeAggregateCallable(collection, StatTypeEnum.HARD.getValue(),
                hardAggrDocuments);
        MergeAggregateCallable accountCallable = new MergeAggregateCallable(collection,StatTypeEnum.ACCOUNT.getValue(),
                accountAggrDocuments);
        Future<ArrayList<MergeLoginByDayPo>> hardResult = pool.submit(hardCallable);
        Future<ArrayList<MergeLoginByDayPo>> accountResult = pool.submit(accountCallable);
        hallGameResults.addAll(hardResult.get());
        hallGameResults.addAll(accountResult.get());
        return hallGameResults;
    }

    /**
     * 二级界面数据
     * @param match
     * @param pool
     * @param collection
     * @return
     * @throws ExecutionException
     * @throws InterruptedException
     */
    public static ArrayList<MergeLoginDetailsByDayPo> listMergeDetailLoginByDayInfo(Document match, ExecutorService pool,
                                                                                    MongoCollection<Document> collection)
            throws ExecutionException, InterruptedException {
        ArrayList<MergeLoginDetailsByDayPo> results = new ArrayList<MergeLoginDetailsByDayPo>();
        ArrayList<Document> hardDetailAggregateDocuments = listAggregateHardDetailDocuments(match);
        ArrayList<Document> accountDetailAggregateDocuments = listAggregateAccountDetailDocuments(match);
        Callable<ArrayList<MergeLoginDetailsByDayPo>> hardCallable = new MergeDetailAggregateCallable(
                hardDetailAggregateDocuments,StatTypeEnum.HARD.getValue(),collection);
        Callable<ArrayList<MergeLoginDetailsByDayPo>>accountCallable = new MergeDetailAggregateCallable(
                accountDetailAggregateDocuments,StatTypeEnum.ACCOUNT.getValue(),collection);
        Future<ArrayList<MergeLoginDetailsByDayPo>> hardResults = pool.submit(hardCallable);
        Future<ArrayList<MergeLoginDetailsByDayPo>> accountResults = pool.submit(accountCallable);
        results.addAll(accountResults.get());
        results.addAll(hardResults.get());
        return results;
    }
}
