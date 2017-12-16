package ct.dc.pc.api.dao.game.interfaces;

import ct.dc.pc.api.model.po.game.GameRetainByDayPo;

import java.util.ArrayList;

/**
 * Created by B41-80 on 2017/4/1.
 */
public interface IGameRetainByDayDao {
    /**
     * 根据游戏和日期查找留存数据
     * @param game
     * @param beginDate
     * @param endDate
     * @return
     */
    ArrayList<GameRetainByDayPo> findByGame(int game,int beginDate,int endDate);

    /**
     * 根据日期查询留存数据
     * @param beginDate
     * @param endDate
     * @return
     */
    ArrayList<GameRetainByDayPo> find(int beginDate,int endDate);
}
