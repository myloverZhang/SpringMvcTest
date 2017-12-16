package ct.dc.pc.api.domain.login;

import ct.dc.pc.api.dao.game.interfaces.IGameLoginByDayDao;
import ct.dc.pc.api.dao.game.interfaces.IGameLoginPerDayDao;
import ct.dc.pc.api.enums.StatTypeEnum;
import ct.dc.pc.api.model.domain.game.GameLoginByDayDo;
import ct.dc.pc.api.model.domain.game.GameLoginPerDayDo;
import ct.dc.pc.api.model.po.game.GameLoginByDayPo;
import ct.dc.pc.api.model.po.game.GameLoginPerDayPo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;

/**
 * Created by B41-80 on 2017/4/6.
 */
@Component
public class GameLoginDomain {
    @Autowired
    private IGameLoginByDayDao iGameLoginByDayDao;
    @Autowired
    private IGameLoginPerDayDao iGameLoginPerDayDao;

    /**
     * 游戏多日登录
     * @param game
     * @param beginDate
     * @param endDate
     * @return
     */
    public ArrayList<GameLoginByDayDo> listGameLoginByDayInfo(int game,int beginDate,int endDate){
        ArrayList<GameLoginByDayDo> results = new ArrayList<GameLoginByDayDo>();
        for (GameLoginByDayPo info:iGameLoginByDayDao.findByGame(game, beginDate, endDate)){
            GameLoginByDayDo account = new GameLoginByDayDo();
            account.setDate(info.getDate());
            account.setTimes(info.getTimes());
            account.setType(StatTypeEnum.ACCOUNT.getValue());
            account.setUsers1D1(info.getUsers1D1());
            account.setUsers3D1(info.getUsers3D1());
            account.setUsers7D1(info.getUsers7D1());
            account.setUsers14D1(info.getUsers14D1());
            account.setUsers30D1(info.getUsers30D1());

            GameLoginByDayDo hard = new GameLoginByDayDo();
            hard.setDate(info.getDate());
            hard.setTimes(info.getTimes());
            hard.setType(StatTypeEnum.HARD.getValue());
            hard.setUsers1D1(info.getHards1D1());
            hard.setUsers3D1(info.getHards3D1());
            hard.setUsers7D1(info.getHards7D1());
            hard.setUsers14D1(info.getHards14D1());
            hard.setUsers30D1(info.getHards30D1());

            results.add(account);
            results.add(hard);
        }
        return results;
    }

    /**
     * 游戏单日登录
     * @param game
     * @param date
     * @return
     */
    public ArrayList<GameLoginPerDayDo> listGameLoginPerDayInfo(int game,int date){
        ArrayList<GameLoginPerDayDo> results = new ArrayList<GameLoginPerDayDo>();
        for (GameLoginPerDayPo info:iGameLoginPerDayDao.findByGame(game, date)){
            GameLoginPerDayDo result = new GameLoginPerDayDo();
            result.setTimes(info.getTimes());
            result.setUsers(info.getUsers());
            result.setHards(info.getHards());
            result.setTrange(info.getTrange());
            results.add(result);
        }
        return results;
    }
}
