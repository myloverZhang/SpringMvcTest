package ct.dc.pc.api.dao.merge.interfaces;

import ct.dc.pc.api.model.po.merge.MergeLoginByDayPo;
import ct.dc.pc.api.model.po.merge.MergeLoginDetailsByDayPo;

import java.util.ArrayList;
import java.util.concurrent.ExecutionException;

/**
 * Created by B41-80 on 2017/4/5.
 */
public interface IProvinceGameByDayDao {
    /**
     * 根据省份和日期查询二合数据
     * @param province
     * @param beginDate
     * @param endDate
     * @return
     */
    ArrayList<MergeLoginByDayPo> find(String province,int beginDate,int endDate)
            throws ExecutionException, InterruptedException;

    /**
     * 根据省份、日期和游戏id获取二合明细
     * @param province
     * @param beginDate
     * @param endDate
     * @param game
     * @return
     */
    ArrayList<MergeLoginDetailsByDayPo> findDetails(String province, int beginDate, int endDate, int game)
            throws ExecutionException, InterruptedException;
}
