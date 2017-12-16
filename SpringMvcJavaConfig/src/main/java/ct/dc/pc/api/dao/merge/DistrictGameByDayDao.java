package ct.dc.pc.api.dao.merge;

import ct.dc.pc.api.dao.RepositoryBase;
import ct.dc.pc.api.dao.merge.interfaces.IDistrictGameByDayDao;
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
 * Created by B41-80 on 2017/4/1.
 */
@Repository
public class DistrictGameByDayDao extends RepositoryBase implements IDistrictGameByDayDao{
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
    @Value("${mongo.merge.districtGameByDay}")
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
     * 通过县区和日期查询数据
     *
     * @param district
     * @param beginDate
     * @param endDate
     * @return
     */
    public ArrayList<MergeLoginByDayPo> find(String district, int beginDate, int endDate)
            throws ExecutionException, InterruptedException {
        Document match = new Document().append("district",district)
                .append("date",new Document().append("$gte",beginDate).append("$lte",endDate));
        return AreaGameAggregateUtil.listMergeLoginByDayInfo(match,pool,collectionInstance());
    }

    /**
     * 查询二合明细
     *
     * @param district
     * @param beginDate
     * @param endDate
     * @param game
     * @return
     */
    public ArrayList<MergeLoginDetailsByDayPo> findDetails(String district, int beginDate, int endDate, int game)
            throws ExecutionException, InterruptedException {
        Document match = new Document().append("district",district)
                .append("game",game)
                .append("date",new Document().append("$gte",beginDate).append("$lte",endDate));
        return AreaGameAggregateUtil.listMergeDetailLoginByDayInfo(match,pool,collectionInstance());
    }
}
