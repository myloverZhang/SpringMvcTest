package ct.dc.pc.api.dao.game.interfaces;

import ct.dc.pc.api.model.domain.game.GameLoginByDayDo;
import ct.dc.pc.api.model.po.game.GameLoginByDayPo;

import java.util.ArrayList;

/**
 * Created by B41-80 on 2017/4/1.
 */
public interface IGameLoginByDayDao {
    /**
     * 根据游戏和日期查询多日登录数据
     * @param game
     * @param beginDate
     * @param endDate
     * @return
     */
    ArrayList<GameLoginByDayPo> findByGame(int game,int beginDate,int endDate);

    /**
     * 根据日期查询多日登录数据
     * @param beginDate
     * @param endDate
     * @return
     */
    ArrayList<GameLoginByDayPo> find(int beginDate,int endDate);
}
