package ct.dc.pc.api.service.game;

import ct.dc.pc.api.domain.login.GameLoginDomain;
import ct.dc.pc.api.model.domain.game.GameLoginByDayDo;
import ct.dc.pc.api.model.domain.game.GameLoginPerDayDo;
import ct.dc.pc.api.service.game.interfaces.IGameLoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * Created by B41-80 on 2017/4/6.
 */
@Service
public class GameLoginServiceImpl implements IGameLoginService{
    @Autowired
    private GameLoginDomain gameLoginDomain;

    /**
     * 游戏多日登录数据
     *
     * @param game
     * @param beginDate
     * @param endDate
     * @return
     */
    public ArrayList<GameLoginByDayDo> listGameLoginByDayInfo(int game, int beginDate, int endDate) {
        return gameLoginDomain.listGameLoginByDayInfo(game, beginDate, endDate);
    }

    /**
     * 游戏单日登录数据
     *
     * @param game
     * @param date
     * @return
     */
    public ArrayList<GameLoginPerDayDo> listGameLoginPerDayInfo(int game, int date) {
        return gameLoginDomain.listGameLoginPerDayInfo(game, date);
    }
}
