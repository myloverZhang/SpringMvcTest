package ct.dc.pc.api.dao.hall.interfaces;

import ct.dc.pc.api.model.po.hall.HallRetainPcByDayPo;

import java.util.ArrayList;

/**
 * Created by B41-80 on 2017/4/1.
 */
public interface IHallRetainPcByDayDao {
    /**
     * 根据大厅和日期查询数据
     * @param group
     * @param beginDate
     * @param endDate
     * @return
     */
    ArrayList<HallRetainPcByDayPo> findByGroup(int group,int beginDate,int endDate);

    /**
     * 根据日期查询数据
     * @param beginDate
     * @param endDate
     * @return
     */
    ArrayList<HallRetainPcByDayPo> find(int beginDate,int endDate);
}
