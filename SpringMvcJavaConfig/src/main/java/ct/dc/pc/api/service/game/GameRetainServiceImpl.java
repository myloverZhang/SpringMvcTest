package ct.dc.pc.api.service.game;

import ct.dc.pc.api.dao.game.interfaces.IGameRetainByDayDao;
import ct.dc.pc.api.domain.retain.GameRetainDomain;
import ct.dc.pc.api.model.domain.game.GameRetainByDayDo;
import ct.dc.pc.api.service.game.interfaces.IGameRetainService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

/**
 * Created by B41-80 on 2017/4/6.
 */
@Service
public class GameRetainServiceImpl implements IGameRetainService{
    @Autowired
    private GameRetainDomain gameRetainDomain;

    /**
     * 游戏多日留存
     *
     * @param game
     * @param beginDate
     * @param endDate
     * @return
     */
    public ArrayList<GameRetainByDayDo> listGameRetainByDayInfo(int game, int beginDate, int endDate) {
        return gameRetainDomain.listGameRetainByDayInfo(game, beginDate, endDate);
    }
}
