package ct.dc.pc.api.service.game.interfaces;

import ct.dc.pc.api.model.domain.game.GameLoginByDayDo;
import ct.dc.pc.api.model.domain.game.GameLoginPerDayDo;

import java.util.ArrayList;

/**
 * Created by B41-80 on 2017/4/6.
 */
public interface IGameLoginService {
    /**
     * 游戏多日登录数据
     * @param game
     * @param beginDate
     * @param endDate
     * @return
     */
    ArrayList<GameLoginByDayDo> listGameLoginByDayInfo(int game,int beginDate,int endDate);

    /**
     * 游戏单日登录数据
     * @param game
     * @param date
     * @return
     */
    ArrayList<GameLoginPerDayDo> listGameLoginPerDayInfo(int game,int date);
}
