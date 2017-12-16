package ct.dc.pc.api.dao.hall.interfaces;

import ct.dc.pc.api.model.po.hall.HallOnlineByDayPo;

import java.util.ArrayList;

/**
 * Created by B41-80 on 2017/4/1.
 */
public interface IHallOnlineByDayDao {
    /**
     * 根据大厅和日期查询数据
     * @param group
     * @param beginDate
     * @param endDate
     * @return
     */
    ArrayList<HallOnlineByDayPo> findByGroup(int group,int beginDate,int endDate);
}
