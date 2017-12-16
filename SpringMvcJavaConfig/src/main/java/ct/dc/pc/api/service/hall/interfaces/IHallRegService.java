package ct.dc.pc.api.service.hall.interfaces;

import ct.dc.pc.api.model.domain.hall.HallRegByDayDo;
import ct.dc.pc.api.model.domain.hall.HallRegByMonthDo;

import java.util.ArrayList;

/**
 * Created by B41-80 on 2017/4/6.
 */
public interface IHallRegService {
    /**
     * 大厅多日注册
     * @param group
     * @param beginDate
     * @param endDate
     * @return
     */
    ArrayList<HallRegByDayDo> listHallRegByDayInfo(int group,int beginDate,int endDate);

    /**
     * 大厅多月注册
     * @param group
     * @param beginMonth
     * @param endMonth
     * @return
     */
    HallRegByMonthDo[] listHallRegByMonthInfo(int group,int beginMonth,int endMonth);
}
