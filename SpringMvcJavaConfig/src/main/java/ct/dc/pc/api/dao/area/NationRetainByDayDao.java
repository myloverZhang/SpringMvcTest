package ct.dc.pc.api.dao.area;

import ct.dc.pc.api.dao.RepositoryBase;
import ct.dc.pc.api.dao.area.helper.AreaLoginInfoHelper;
import ct.dc.pc.api.dao.area.interfaces.INationRetainByDayDao;
import ct.dc.pc.api.model.po.area.AreaRetainByDayPo;
import org.bson.Document;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;

/**
 * Created by B41-80 on 2017/3/31.
 */
@Repository
public class NationRetainByDayDao extends RepositoryBase implements INationRetainByDayDao{
    @Override
    @Value("${mongo.uri}")
    public void setMongoUri(String mongoUri) {
        super.setMongoUri(mongoUri);
    }

    @Override
    @Value("${mongo.area}")
    public void setDataBaseName(String dataBaseName) {
        super.setDataBaseName(dataBaseName);
    }

    @Override
    @Value("${mongo.area.nationRetainByDay}")
    public void setCollectionName(String collectionName) {
        super.setCollectionName(collectionName);
    }
    @Override
    @Value("${mongo.area.userName}")
    public void setUserName(String userName) {
        super.setUserName(userName);
    }

    @Override
    @Value("${mongo.area.passWord}")
    public void setPassWord(String passWord) {
        super.setPassWord(passWord);
    }
    /**
     * 根据日期获取全国留存
     *
     * @param beginDate
     * @param endDate
     * @return
     */
    public ArrayList<AreaRetainByDayPo> find(int beginDate, int endDate) {
        Document query = new Document().append("date",new Document().append("$gte",beginDate).append("$lte",endDate));
        return findByDocument(query);
    }

    /**
     * 根据条件获取留存数据
     * @param query
     * @return
     */
    private ArrayList<AreaRetainByDayPo> findByDocument(Document query){
        ArrayList<AreaRetainByDayPo> results = new ArrayList<AreaRetainByDayPo>();
        for (Document info:collectionInstance().find(query)){
            AreaRetainByDayPo result = AreaLoginInfoHelper.getRetainInfo(info);
            results.add(result);
        }
        return results;
    }
}
