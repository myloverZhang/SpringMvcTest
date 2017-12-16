package ct.dc.pc.api.dao.merge.interfaces;

import ct.dc.pc.api.model.po.merge.MergeLoginByDayPo;
import ct.dc.pc.api.model.po.merge.MergeLoginDetailsByDayPo;

import java.util.ArrayList;
import java.util.concurrent.ExecutionException;

/**
 * Created by B41-80 on 2017/4/1.
 */
public interface ICityGameByDayDao {
    /**
     * 查询概要信息
     * @param city
     * @param beginDate
     * @param endDate
     * @return
     */
    ArrayList<MergeLoginByDayPo> find(String city,int beginDate,int endDate)
            throws ExecutionException, InterruptedException;

    /**
     * 查询二合明细
     * @param city
     * @param beginDate
     * @param endDate
     * @param game
     * @return
     */
    ArrayList<MergeLoginDetailsByDayPo> findDetails(String city, int beginDate, int endDate, int game)
            throws ExecutionException, InterruptedException;
}
