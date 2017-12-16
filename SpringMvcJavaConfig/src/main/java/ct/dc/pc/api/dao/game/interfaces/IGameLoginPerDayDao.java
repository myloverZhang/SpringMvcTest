package ct.dc.pc.api.dao.game.interfaces;

import ct.dc.pc.api.model.po.game.GameLoginPerDayPo;

import java.util.ArrayList;

/**
 * Created by B41-80 on 2017/4/1.
 */
public interface IGameLoginPerDayDao {
    /**
     * 根据游戏和日期查询数据
     * @param game
     * @param beginDate
     * @param endDate
     * @return
     */
    ArrayList<GameLoginPerDayPo> findByGame(int game,int beginDate,int endDate);
    /**
     * 根据游戏和日期查询数据
     * @param game
     * @param date
     * @return
     */
    ArrayList<GameLoginPerDayPo> findByGame(int game,int date);
}
