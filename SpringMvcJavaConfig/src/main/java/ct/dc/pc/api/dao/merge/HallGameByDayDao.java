package ct.dc.pc.api.dao.merge;

import ct.dc.pc.api.dao.RepositoryBase;
import ct.dc.pc.api.dao.merge.interfaces.IHallGameByDayDao;
import ct.dc.pc.api.model.po.merge.MergeLoginByDayPo;
import ct.dc.pc.api.model.po.merge.MergeLoginDetailsByDayPo;
import org.bson.Document;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * Created by B41-80 on 2017/4/5.
 */
@Repository
public class HallGameByDayDao extends RepositoryBase implements IHallGameByDayDao{
    private ThreadPoolExecutor pool = new ThreadPoolExecutor(2,5,10L, TimeUnit.SECONDS,
            new ArrayBlockingQueue<Runnable>(3));
    @Override
    @Value("${mongo.uri}")
    public void setMongoUri(String mongoUri) {
        super.setMongoUri(mongoUri);
    }

    @Override
    @Value("${mongo.merge}")
    public void setDataBaseName(String dataBaseName) {
        super.setDataBaseName(dataBaseName);
    }

    @Override
    @Value("${mongo.merge.hallGameByDay}")
    public void setCollectionName(String collectionName) {
        super.setCollectionName(collectionName);
    }
    @Override
    @Value("${mongo.merge.userName}")
    public void setUserName(String userName) {
        super.setUserName(userName);
    }

    @Override
    @Value("${mongo.merge.passWord}")
    public void setPassWord(String passWord) {
        super.setPassWord(passWord);
    }
    /**
     * 根据大厅和日期查询二合数据
     *
     * @param beginDate
     * @param endDate
     * @param game
     * @return
     */
    public ArrayList<MergeLoginByDayPo> findByGame(int beginDate, int endDate, int game)
            throws ExecutionException, InterruptedException {
        Document match = new Document().append("game",game)
                .append("date",new Document().append("$gte",beginDate).append("$lte",endDate));
        return HallGameAggregateUtil.listGameHallLoginInfo(pool,collectionInstance(),match);
    }

    /**
     * 根据大厅和日期
     *
     * @param beginDate
     * @param endDate
     * @param group
     * @return
     * @throws ExecutionException
     * @throws InterruptedException
     */
    @Override
    public ArrayList<MergeLoginByDayPo> findByGroup(int beginDate, int endDate, int group) throws ExecutionException, InterruptedException {
        Document match = new Document().append("group",group)
                .append("date",new Document().append("$gte",beginDate).append("$lte",endDate));
        return HallGameAggregateUtil.listHallGameLoginInfo(pool,collectionInstance(),match);
    }

    /**
     * 根据大厅、日期好游戏id查询
     *
     * @param beginDate
     * @param endDate
     * @param group
     * @param game
     * @return
     */
    public ArrayList<MergeLoginDetailsByDayPo> findDetail(int beginDate, int endDate, int group, int game)
            throws ExecutionException, InterruptedException {
        Document match = new Document().append("game",game)
                .append("group",group)
                .append("date",new Document().append("$gte",beginDate).append("$lte",endDate));
        return HallGameAggregateUtil.listMergeDetailLoginByDayInfo(match,pool,collectionInstance());
    }
}
