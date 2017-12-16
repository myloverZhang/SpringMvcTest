package ct.dc.pc.api.service.merge;

import ct.dc.pc.api.domain.hallgame.HallGameDomain;
import ct.dc.pc.api.model.domain.merge.MergeLoginByDayDo;
import ct.dc.pc.api.model.domain.merge.MergeLoginDetailByDayDo;
import ct.dc.pc.api.service.merge.interfaces.IHallGameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

/**
 * Created by B41-80 on 2017/4/7.
 */
@Service
public class HallGameService implements IHallGameService{
    @Autowired
    private HallGameDomain hallGameDomain;
    /**
     * 游戏大厅数据
     *
     * @param beginDate
     * @param endDate
     * @param game
     * @return
     */
    @Override
    public ArrayList<MergeLoginByDayDo> listGameHallInfo(int beginDate, int endDate, int game) {
        return hallGameDomain.listGameHallInfo(beginDate, endDate, game);
    }

    /**
     * 大厅游戏数据
     *
     * @param beginDate
     * @param endDate
     * @param hallIDd
     * @return
     */
    @Override
    public ArrayList<MergeLoginByDayDo> listHallGameInfo(int beginDate, int endDate, int hallIDd) {
        return hallGameDomain.listHallGameInfo(beginDate, endDate, hallIDd);
    }

    /**
     * 大厅游戏二合明细
     *
     * @param beginDate
     * @param endDate
     * @param halId
     * @param game
     * @return
     */
    @Override
    public ArrayList<MergeLoginDetailByDayDo> listMergeDetailInfo(int beginDate, int endDate, int halId, int game) {
        return hallGameDomain.listMergeDetailInfo(beginDate, endDate, halId, game);
    }
}
