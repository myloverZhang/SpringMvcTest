package ct.dc.pc.api.service.game.interfaces;

import ct.dc.pc.api.model.domain.game.GameRetainByDayDo;

import java.util.ArrayList;

/**
 * Created by B41-80 on 2017/4/6.
 */
public interface IGameRetainService {
    /**
     * 游戏多日留存
     * @param game
     * @param beginDate
     * @param endDate
     * @return
     */
    ArrayList<GameRetainByDayDo> listGameRetainByDayInfo(int game,int beginDate,int endDate);
}
