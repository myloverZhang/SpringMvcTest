package ct.dc.pc.api.dao.game;

import ct.dc.pc.api.dao.RepositoryBase;
import ct.dc.pc.api.dao.game.interfaces.IGameRetainByDayDao;
import ct.dc.pc.api.model.po.game.GameRetainByDayPo;
import org.bson.Document;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;

/**
 * Created by B41-80 on 2017/4/1.
 */
@Repository
public class GameRetainByDayDao extends RepositoryBase implements IGameRetainByDayDao{
    @Override
    @Value("${mongo.uri}")
    public void setMongoUri(String mongoUri) {
        super.setMongoUri(mongoUri);
    }

    @Override
    @Value("${mongo.game}")
    public void setDataBaseName(String dataBaseName) {
        super.setDataBaseName(dataBaseName);
    }

    @Override
    @Value("${mongo.game.retainByDay}")
    public void setCollectionName(String collectionName) {
        super.setCollectionName(collectionName);
    }
    @Override
    @Value("${mongo.game.userName}")
    public void setUserName(String userName) {
        super.setUserName(userName);
    }

    @Override
    @Value("${mongo.game.passWord}")
    public void setPassWord(String passWord) {
        super.setPassWord(passWord);
    }
    /**
     * 根据游戏和日期查找留存数据
     *
     * @param game
     * @param beginDate
     * @param endDate
     * @return
     */
    public ArrayList<GameRetainByDayPo> findByGame(int game, int beginDate, int endDate) {
        Document query = new Document().append("game",game)
                .append("date",new Document().append("$gte",beginDate).append("$lte",endDate));
        return findByDocument(query);
    }

    /**
     * 根据日期查询留存数据
     *
     * @param beginDate
     * @param endDate
     * @return
     */
    @Override
    public ArrayList<GameRetainByDayPo> find(int beginDate, int endDate) {
        Document query = new Document().append("date",new Document().append("$gte",beginDate).append("$lte",endDate));
        return findByDocument(query);
    }

    /**
     * 根据条件查询数据
     * @param query
     * @return
     */
    private ArrayList<GameRetainByDayPo> findByDocument(Document query){
        ArrayList<GameRetainByDayPo> results = new ArrayList<GameRetainByDayPo>();
        for (Document info:collectionInstance().find(query)){
            GameRetainByDayPo result = new GameRetainByDayPo();
            result.setDate(info.getInteger("date",0));
            result.setGame(info.getInteger("game",0));
            Document users = info.get("users",Document.class);
            Document hards = info.get("hards",Document.class);
            if (users!=null){
                result.setUsersD1(users.getInteger("d1",0));
                result.setUsersNew(users.getInteger("new",0));
                result.setUsersD3(users.getInteger("d3",0));
                result.setUsersD7(users.getInteger("d7",0));
                result.setUsersD14(users.getInteger("d14",0));
                result.setUsersD30(users.getInteger("d30",0));
            }else{
                result.setUsersD1(0);
                result.setUsersNew(0);
                result.setUsersD3(0);
                result.setUsersD7(0);
                result.setUsersD14(0);
                result.setUsersD30(0);
            }
            if (hards!=null){
                result.setHardsNew(hards.getInteger("new",0));
                result.setHardsD1(hards.getInteger("d1",0));
                result.setHardsD3(hards.getInteger("d3",0));
                result.setHardsD7(hards.getInteger("d7",0));
                result.setHardsD14(hards.getInteger("d14",0));
                result.setHardsD30(hards.getInteger("d30",0));
            }else {
                result.setHardsNew(0);
                result.setHardsD1(0);
                result.setHardsD3(0);
                result.setHardsD7(0);
                result.setHardsD14(0);
                result.setHardsD30(0);
            }
            results.add(result);
        }
        return results;
    }
}
