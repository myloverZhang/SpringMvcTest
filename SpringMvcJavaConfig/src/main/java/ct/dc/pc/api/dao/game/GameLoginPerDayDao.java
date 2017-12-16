package ct.dc.pc.api.dao.game;

import ct.dc.pc.api.dao.RepositoryBase;
import ct.dc.pc.api.dao.game.interfaces.IGameLoginPerDayDao;
import ct.dc.pc.api.model.po.game.GameLoginPerDayPo;
import org.bson.Document;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;

/**
 * Created by B41-80 on 2017/4/1.
 */
@Repository
public class GameLoginPerDayDao extends RepositoryBase implements IGameLoginPerDayDao {
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
    @Value("${mongo.game.loginPerDay}")
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
     * 根据游戏和日期查询数据
     *
     * @param game
     * @param beginDate
     * @param endDate
     * @return
     */
    public ArrayList<GameLoginPerDayPo> findByGame(int game, int beginDate, int endDate) {
        Document query = new Document().append("game",game)
                .append("date",new Document().append("$gte",beginDate).append("$lte",endDate));
        return findByDocument(query);
    }

    /**
     * 根据游戏和日期查询数据
     *
     * @param game
     * @param date
     * @return
     */
    public ArrayList<GameLoginPerDayPo> findByGame(int game, int date) {
        Document query = new Document().append("game",game)
                .append("date",date);
        return findByDocument(query);
    }

    /**
     * 根据条件查询数据
     * @param query
     * @return
     */
    private ArrayList<GameLoginPerDayPo> findByDocument(Document query){
        ArrayList<GameLoginPerDayPo> results = new ArrayList<GameLoginPerDayPo>();
        for (Document info:collectionInstance().find(query)){
            GameLoginPerDayPo result = new GameLoginPerDayPo();
            result.setDate(info.getInteger("date",0));
            result.setGame(info.getInteger("game",0));
            result.setTrange(info.getInteger("trange",0));
            result.setUsers(info.getInteger("users",0));
            result.setHards(info.getInteger("hards",0));
            result.setTimes(info.getInteger("times",0));
            results.add(result);
        }
        return results;
    }
}
