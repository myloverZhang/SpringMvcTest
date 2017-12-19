package ct.dc.mobile.api.dao.mobilearea.login;

import ct.dc.mobile.api.dao.RespositoryBase;
import ct.dc.mobile.api.dao.mobilearea.Interface.IDistrictAppLoginByDayDao;
import ct.dc.mobile.api.model.po.mobilearea.AreaAppLoginByDayPo;
import ct.dc.mobile.api.model.po.mobilearea.AreaAppLoginDetailsByDayPo;
import org.bson.Document;
import org.springframework.beans.factory.annotation.Value;

import java.util.ArrayList;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by B41-80 on 2017/1/12.
 */
public class DistrictAppLoginByDayDao extends RespositoryBase implements IDistrictAppLoginByDayDao{
    private ExecutorService pool = Executors.newFixedThreadPool(10);
    @Value("${mongo.uri}")
    public void setMongoUri(String mongoUri) {
        super.setMongoUri(mongoUri);
    }

    @Value("${mongo.areaApp}")
    public void setDataBaseName(String dataBaseName) {
        super.setDataBaseName(dataBaseName);
    }

    @Value("${mongo.areaApp.districtByDay}")
    public void setCollectionName(String collectionName) {
        super.setCollectionName(collectionName);
    }

    @Override
    public ArrayList<AreaAppLoginByDayPo> findFull(int begin, int end, String district) throws ExecutionException, InterruptedException {
        Document query = new Document().append("district",district)
                .append("date",new Document().append("$gte",begin).append("$lte",end));
        return AggregateUtil.areaAppFullInfos(query,collectionInstance(),pool);
    }

    @Override
    public ArrayList<AreaAppLoginDetailsByDayPo> findDetails(int begin, int end, long app, String district) throws ExecutionException, InterruptedException {
        Document query = new Document().append("district",district)
                .append("date",new Document().append("$gte",begin).append("$lte",end))
                .append("app",app);
        return AggregateUtil.areaAppDetailsInfos(query,collectionInstance(),pool);
    }
}
