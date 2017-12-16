package ct.dc.pc.api.dao.hall.interfaces;

import ct.dc.pc.api.model.po.hall.HallLoginPerDayPo;

import java.util.ArrayList;

/**
 * Created by B41-80 on 2017/4/1.
 */
public interface IHallLoginPerDayDao {
    /**
     * 根据大厅和日期查询数据
     * @param group
     * @param beginDate
     * @param endDate
     * @return
     */
    ArrayList<HallLoginPerDayPo> findByGroup(int group,int beginDate,int endDate);
    /**
     * 根据大厅和日期查询数据
     * @param group
     * @param date
     * @return
     */
    ArrayList<HallLoginPerDayPo> findByGroup(int group,int date);
}
