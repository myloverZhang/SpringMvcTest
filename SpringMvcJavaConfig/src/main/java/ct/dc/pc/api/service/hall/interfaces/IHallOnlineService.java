package ct.dc.pc.api.service.hall.interfaces;

import ct.dc.pc.api.model.domain.hall.HallOnlineByDayDo;
import ct.dc.pc.api.model.domain.hall.HallOnlineByMonthDo;
import ct.dc.pc.api.model.domain.hall.HallOnlinePerDayDo;

import java.util.ArrayList;

/**
 * Created by B41-80 on 2017/4/6.
 */
public interface IHallOnlineService {
    /**
     * 大厅多日在线
     * @param group
     * @param beginDate
     * @param endDate
     * @return
     */
    ArrayList<HallOnlineByDayDo> listHallOnlineByDayInfo(int group,int beginDate,int endDate);

    /**
     * 大厅单日在线
     * @param group
     * @param date
     * @return
     */
    ArrayList<HallOnlinePerDayDo> listHallOnlinePerDayInfo(int group,int date);

    /**
     * 大厅多月在线
     * @param group
     * @param beginMonth
     * @param endMonth
     * @return
     */
    ArrayList<HallOnlineByMonthDo> listHallOnlineByMonthInfo(int group,int beginMonth,int endMonth);
}
