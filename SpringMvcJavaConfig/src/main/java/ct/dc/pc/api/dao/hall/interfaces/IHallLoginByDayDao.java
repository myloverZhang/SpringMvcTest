package ct.dc.pc.api.dao.hall.interfaces;

import ct.dc.pc.api.model.po.hall.HallLoginByDayPo;

import java.util.ArrayList;

/**
 * Created by B41-80 on 2017/4/1.
 */
public interface IHallLoginByDayDao {
    /**
     * 根据大厅和日期获取大厅多日登录信息
     * @param group
     * @param beginDate
     * @param endDate
     * @return
     */
    ArrayList<HallLoginByDayPo> findByGroup(int group, int beginDate, int endDate);

    /**
     * 根据大厅登录
     * @param beginDate
     * @param endDate
     * @return
     */
    ArrayList<HallLoginByDayPo> find(int beginDate, int endDate);

}
