package ct.dc.pc.api.domain.retain;

import ct.dc.pc.api.dao.game.interfaces.IGameRetainByDayDao;
import ct.dc.pc.api.enums.StatTypeEnum;
import ct.dc.pc.api.model.domain.game.GameRetainByDayDo;
import ct.dc.pc.api.model.po.game.GameRetainByDayPo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;

/**
 * Created by B41-80 on 2017/4/6.
 */
@Component
public class GameRetainDomain {
    @Autowired
    private IGameRetainByDayDao iGameRetainByDayDao;


    /**
     * 游戏多日留存
     * @param game
     * @param beginDate
     * @param endDate
     * @return
     */
    public ArrayList<GameRetainByDayDo> listGameRetainByDayInfo(int game,int beginDate,int endDate){
        ArrayList<GameRetainByDayDo> results = new ArrayList<GameRetainByDayDo>();
        for (GameRetainByDayPo info:iGameRetainByDayDao.findByGame(game, beginDate, endDate)){
            GameRetainByDayDo account = new GameRetainByDayDo();
            GameRetainByDayDo hard = new GameRetainByDayDo();

            account.setType(StatTypeEnum.ACCOUNT.getValue());
            account.setDate(info.getDate());
            account.setNewCount(info.getUsersNew());
            account.setUsers1Day(info.getUsersD1());
            account.setUsers3Day(info.getUsersD3());
            account.setUsers7Day(info.getUsersD7());
            account.setUsers14Day(info.getUsersD14());
            account.setUsers30Day(info.getUsersD30());

            hard.setType(StatTypeEnum.HARD.getValue());
            hard.setDate(info.getDate());
            hard.setNewCount(info.getHardsNew());
            hard.setUsers1Day(info.getHardsD1());
            hard.setUsers3Day(info.getHardsD3());
            hard.setUsers7Day(info.getHardsD7());
            hard.setUsers14Day(info.getHardsD14());
            hard.setUsers30Day(info.getHardsD30());

            results.add(account);
            results.add(hard);
        }
        return results;
    }
}
