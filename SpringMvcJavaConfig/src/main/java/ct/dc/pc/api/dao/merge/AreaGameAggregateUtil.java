package ct.dc.pc.api.dao.merge;

import com.mongodb.client.MongoCollection;
import ct.dc.pc.api.dao.merge.callabel.MergeAggregateCallable;
import ct.dc.pc.api.dao.merge.callabel.MergeDetailAggregateCallable;
import ct.dc.pc.api.enums.StatTypeEnum;
import ct.dc.pc.api.model.po.merge.MergeLoginByDayPo;
import ct.dc.pc.api.model.po.merge.MergeLoginDetailsByDayPo;
import org.bson.Document;

import java.util.ArrayList;
import java.util.concurrent.*;

/**
 * Created by B41-80 on 2017/4/5.
 */
public class AreaGameAggregateUtil {
    /**
     * 一级界面获取账户一次聚合document
     * @return
     */
    private static Document getAggrDocByAccountOnce(){
        Document aggregate = new Document().append("_id",new Document().append("uid","$uid").append("game","$game"))
                .append("times",new Document().append("$sum","$times"));
        return aggregate;
    }

    /**
     * 一级界面获取游戏维度的二次聚合条件
     * @return
     */
    private static Document getAggrDocByGameTwice(){
        Document aggregate = new Document().append("_id","$_id.game")
                .append("times",new Document().append("$sum","$times"))
                .append("loginUnitNum",new Document().append("$sum",1));
        return aggregate;
    }

    /**
     * 一级界面获取设备维度的一次聚合条件
     * @return
     */
    private static Document getAggrDocByHardOnce(){
        Document aggregate = new Document().append("_id",new Document().append("hard","$hard").append("game","$game"))
                .append("times",new Document().append("$sum","$times"));
        return aggregate;
    }

    /**
     * 二级界面获取账户维度一次聚合条件
     * @return
     */
    private static Document getAggrDocByAccountDetailOnce(){
        Document aggregate = new Document().append("_id",new Document().append("uid","$uid").append("date","$date"))
                .append("times",new Document().append("$sum","$times"));
        return aggregate;
    }


    /**
     * 二级界面设备维度的
     * @return
     */
    private static Document getAggrDocByHardDetailOnce(){
        Document aggregate = new Document().append("_id",new Document().append("hard","$hard").append("date","$date"))
                .append("times",new Document().append("$sum","$times"));
        return aggregate;
    }
    /**
     * 二级界面获取日期维度二次聚合条件
     * @return
     */
    private static Document getAggrDocByDateDetailTwice(){
        Document aggregate = new Document().append("_id","$_id.date")
                .append("times",new Document().append("$sum","$times"))
                .append("loginUnitNum",new Document().append("$sum",1));
        return aggregate;
    }

    /**
     * 一级界面获取设备维度的documents
     * @param match
     * @return
     */
    private static ArrayList<Document> listAggregateHardDocuments(Document match){
        ArrayList<Document> aggregateDocuments = new ArrayList<Document>();
        aggregateDocuments.add(new Document().append("$match",match));
        aggregateDocuments.add(new Document().append("$group",getAggrDocByHardOnce()));
        aggregateDocuments.add(new Document().append("$group",getAggrDocByGameTwice()));
        return aggregateDocuments;
    }

    /**
     * 一级界面获取账号维度的documents
     * @param match
     * @return
     */
    private static ArrayList<Document> listAggregateAccountDocuments(Document match){
        ArrayList<Document> aggregateDocuments = new ArrayList<Document>();
        aggregateDocuments.add(new Document().append("$match",match));
        aggregateDocuments.add(new Document().append("$group",getAggrDocByAccountOnce()));
        aggregateDocuments.add(new Document().append("$group",getAggrDocByGameTwice()));
        return aggregateDocuments;
    }

    /**
     * 账号维度 二级界面聚合条件
     * @param match
     * @return
     */
    private static ArrayList<Document> listAggregateAccountDetailDocuments(Document match){
        ArrayList<Document> aggregateDocument = new ArrayList<Document>();
        aggregateDocument.add(new Document().append("$match",match));
        aggregateDocument.add(new Document().append("$group",getAggrDocByAccountDetailOnce()));
        aggregateDocument.add(new Document().append("$group",getAggrDocByDateDetailTwice()));
        return aggregateDocument;
    }

    /**
     * 设备维度 二级界面聚合条件
     * @param match
     * @return
     */
    private static ArrayList<Document> listAggregateHardDetailDocuments(Document match){
        ArrayList<Document> aggregateDocument = new ArrayList<Document>();
        aggregateDocument.add(new Document().append("$match",match));
        aggregateDocument.add(new Document().append("$group",getAggrDocByHardDetailOnce()));
        aggregateDocument.add(new Document().append("$group",getAggrDocByDateDetailTwice()));
        return aggregateDocument;
    }
    /**
     * 获取地区游戏二合一级界面数据
     * @param match
     * @param pool
     * @param collection
     * @return
     */
    public static ArrayList<MergeLoginByDayPo> listMergeLoginByDayInfo(Document match, ExecutorService pool,
                                                                       MongoCollection<Document> collection)
            throws ExecutionException, InterruptedException {
        ArrayList<MergeLoginByDayPo> results = new ArrayList<MergeLoginByDayPo>();
        ArrayList<Document> hardAggregateDocuments = listAggregateHardDocuments(match);
        ArrayList<Document> accountAggregateDocuments = listAggregateAccountDocuments(match);
        MergeAggregateCallable hardCallable = new MergeAggregateCallable(collection,
                StatTypeEnum.HARD.getValue(),hardAggregateDocuments);
        MergeAggregateCallable accountCallable = new MergeAggregateCallable(collection,
                StatTypeEnum.ACCOUNT.getValue(),accountAggregateDocuments);
        Future<ArrayList<MergeLoginByDayPo>> hardResults = pool.submit(hardCallable);
        Future<ArrayList<MergeLoginByDayPo>> accountResults = pool.submit(accountCallable);
        results.addAll(hardResults.get());
        results.addAll(accountResults.get());
        return results;
    }

    /**
     *获取地区游戏二合 二级界面数据
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
