package ct.dc.pc.api.dao.area;

import ct.dc.libinfrastructure.CommonUtils;
import ct.dc.liblogs.ICtDataLogger;
import ct.dc.liblogs.impl.CtDataLoggerImpl;
import ct.dc.pc.api.dao.RepositoryBase;
import ct.dc.pc.api.dao.area.helper.AreaLoginInfoHelper;
import ct.dc.pc.api.dao.area.interfaces.ICity2LoginByDayDao;
import ct.dc.pc.api.model.po.area.AreaLoginByDayPo;
import org.bson.Document;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;

/**
 * Created by B41-80 on 2017/3/31.
 */
@Repository
public class City2LoginByDayDao extends RepositoryBase implements ICity2LoginByDayDao{
    private ICtDataLogger logger = new CtDataLoggerImpl(City2LoginByDayDao.class);
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
    @Value("${mongo.area.cityLoginByDay}")
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
     * 根据地级市和日期查找多日登录数据
     *
     * @param city
     * @param beginDate
     * @param endDate
     * @return
     */
    public ArrayList<AreaLoginByDayPo> findByCity(String city, int beginDate, int endDate) {
        Document query = new Document().append("city",city)
                .append("date",new Document().append("$gte",beginDate).append("$lte",endDate));
        return findByDocuments(query);
    }

    /**
     * 根据日期查询多日登录数据
     *
     * @param beginDate
     * @param endDate
     * @return
     */
    @Override
    public ArrayList<AreaLoginByDayPo> find(int beginDate, int endDate) {
        try {
            Document query = new Document().append("date",new Document().append("$gte",beginDate).append("$lte",endDate));
            return findByDocuments(query);
        }catch (Exception ex){
            logger.error(String.format("查询出错：%s", CommonUtils.getStackErrors(ex)));
            return new ArrayList<>();
        }
    }

    /**
     * 根据条件查找地级市多日登录数据
     * @return
     */
    private ArrayList<AreaLoginByDayPo> findByDocuments(Document query){
        ArrayList<AreaLoginByDayPo> results = new ArrayList<AreaLoginByDayPo>();
        for (Document info:collectionInstance().find(query)){
            AreaLoginByDayPo result = new AreaLoginByDayPo();
            result.setDate(info.getInteger("date",0));
            result.setTimes(info.getInteger("times",0));
            result.setAreaId(info.getString("city"));
            Document users = info.get("users",Document.class);
            Document hards = info.get("hards",Document.class);
            AreaLoginInfoHelper.getLoginDetailInfo(result,hards,users);
            results.add(result);
        }
        return results;
    }
}
