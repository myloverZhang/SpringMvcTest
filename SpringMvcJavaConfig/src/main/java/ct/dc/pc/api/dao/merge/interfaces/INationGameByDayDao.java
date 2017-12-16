package ct.dc.pc.api.dao.merge.interfaces;

import ct.dc.pc.api.model.po.merge.MergeLoginByDayPo;
import ct.dc.pc.api.model.po.merge.MergeLoginDetailsByDayPo;

import java.util.ArrayList;
import java.util.concurrent.ExecutionException;

/**
 * Created by B41-80 on 2017/4/5.
 */
public interface INationGameByDayDao {
    /**
     * 根据日期查询全国的二合数据
     * @param beginDate
     * @param endDate
     * @return
     */
    ArrayList<MergeLoginByDayPo> find(int beginDate,int endDate) throws ExecutionException, InterruptedException;

    /**
     * 根据日期和游戏查询全国的二合明细
     * @param beginDate
     * @param endDate
     * @param game
     * @return
     */
    ArrayList<MergeLoginDetailsByDayPo> findDetails(int beginDate, int endDate, int game)
            throws ExecutionException, InterruptedException;
}
