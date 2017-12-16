package ct.dc.pc.api.dao.hall.interfaces;

import ct.dc.pc.api.model.po.hall.HallRetainHallByDayPo;

import java.util.ArrayList;

/**
 * Created by B41-80 on 2017/4/1.
 */
public interface IHallRetainHallByDayDao {
    /**
     * 根据大厅和日期查询
     * @param group
     * @param beginDate
     * @param endDate
     * @return
     */
    ArrayList<HallRetainHallByDayPo> findByGroup(int group,int beginDate,int endDate);

    /**
     * 根据日期查询留存数据
     * @param beginDate
     * @param endDate
     * @return
     */
    ArrayList<HallRetainHallByDayPo> find(int beginDate,int endDate);
}
