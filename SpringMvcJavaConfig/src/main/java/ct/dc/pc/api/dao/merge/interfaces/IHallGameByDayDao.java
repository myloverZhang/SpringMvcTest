package ct.dc.pc.api.dao.merge.interfaces;

import ct.dc.pc.api.model.po.merge.MergeLoginByDayPo;
import ct.dc.pc.api.model.po.merge.MergeLoginDetailsByDayPo;

import java.util.ArrayList;
import java.util.concurrent.ExecutionException;

/**
 * Created by B41-80 on 2017/4/5.
 */
public interface IHallGameByDayDao {
    /**
     * 根据游戏和日期查询二合数据
     * @param beginDate
     * @param endDate
     * @param game
     * @return
     */
    ArrayList<MergeLoginByDayPo> findByGame(int beginDate, int endDate, int game) throws ExecutionException,
            InterruptedException;

    /**
     * 根据大厅和日期
     * @param beginDate
     * @param endDate
     * @param group
     * @return
     * @throws ExecutionException
     * @throws InterruptedException
     */
    ArrayList<MergeLoginByDayPo> findByGroup(int beginDate, int endDate, int group) throws ExecutionException,
            InterruptedException;
    /**
     * 根据大厅、日期好游戏id查询
     * @param beginDate
     * @param endDate
     * @param group
     * @param game
     * @return
     */
    ArrayList<MergeLoginDetailsByDayPo> findDetail(int beginDate, int endDate, int group, int game)
            throws ExecutionException, InterruptedException;
}
