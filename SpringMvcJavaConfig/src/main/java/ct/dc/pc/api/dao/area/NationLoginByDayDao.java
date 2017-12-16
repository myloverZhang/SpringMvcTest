package ct.dc.pc.api.dao.area;

import ct.dc.pc.api.dao.RepositoryBase;
import ct.dc.pc.api.dao.area.helper.AreaLoginInfoHelper;
import ct.dc.pc.api.dao.area.interfaces.INationLoginByDayDao;
import ct.dc.pc.api.model.po.area.AreaLoginByDayPo;
import org.bson.Document;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;

/**
 * Created by B41-80 on 2017/3/31.
 */
@Repository
public class NationLoginByDayDao extends RepositoryBase implements INationLoginByDayDao{
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
    @Value("${mongo.area.nationLoginByDay}")
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
     * 根据日期获取全国的多日登录信息
     *
     * @param beginDate
     * @param endDate
     * @return
     */
    public ArrayList<AreaLoginByDayPo> find(int beginDate, int endDate) {
        Document query = new Document().append("date", new Document().append("$gte",beginDate).append("$lte",endDate));
        return findByDocument(query);
    }

    /**
     * 根据查询数据
     * @param query
     * @return
     */
    private ArrayList<AreaLoginByDayPo> findByDocument(Document query){
        ArrayList<AreaLoginByDayPo> results = new ArrayList<AreaLoginByDayPo>();
        for (Document info:collectionInstance().find(query)){
            AreaLoginByDayPo result = new AreaLoginByDayPo();
            result.setDate(info.getInteger("date",0));
            result.setTimes(Integer.valueOf(info.get("times").toString()));
            Document hards = info.get("hards",Document.class);
            Document users = info.get("users",Document.class);
            AreaLoginInfoHelper.getLoginDetailInfo(result,hards,users);
            results.add(result);
        }
        return results;
    }
}
