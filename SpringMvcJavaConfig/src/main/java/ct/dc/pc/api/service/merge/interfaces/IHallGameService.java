package ct.dc.pc.api.service.merge.interfaces;

import ct.dc.pc.api.model.domain.merge.MergeLoginByDayDo;
import ct.dc.pc.api.model.domain.merge.MergeLoginDetailByDayDo;

import java.util.ArrayList;

/**
 * Created by B41-80 on 2017/4/7.
 */
public interface IHallGameService {
    /**
     * 游戏大厅数据
     * @param beginDate
     * @param endDate
     * @param game
     * @return
     */
    ArrayList<MergeLoginByDayDo> listGameHallInfo(int beginDate,int endDate,int game);

    /**
     * 大厅游戏数据
     * @param beginDate
     * @param endDate
     * @param hallIDd
     * @return
     */
    ArrayList<MergeLoginByDayDo> listHallGameInfo(int beginDate,int endDate,int hallIDd);

    /**
     * 大厅游戏二合明细
     * @param beginDate
     * @param endDate
     * @param halId
     * @param game
     * @return
     */
    ArrayList<MergeLoginDetailByDayDo> listMergeDetailInfo(int beginDate,int endDate,int halId,int game);
}
