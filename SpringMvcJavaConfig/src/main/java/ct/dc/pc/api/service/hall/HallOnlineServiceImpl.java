package ct.dc.pc.api.service.hall;

import ct.dc.pc.api.domain.online.HallOnlineDomain;
import ct.dc.pc.api.model.domain.hall.HallOnlineByDayDo;
import ct.dc.pc.api.model.domain.hall.HallOnlineByMonthDo;
import ct.dc.pc.api.model.domain.hall.HallOnlinePerDayDo;
import ct.dc.pc.api.service.hall.interfaces.IHallOnlineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

/**
 * Created by B41-80 on 2017/4/6.
 */
@Service
public class HallOnlineServiceImpl implements IHallOnlineService{
    @Autowired
    private HallOnlineDomain hallOnlineDomain;
    /**
     * 大厅多日在线
     *
     * @param group
     * @param beginDate
     * @param endDate
     * @return
     */
    @Override
    public ArrayList<HallOnlineByDayDo> listHallOnlineByDayInfo(int group, int beginDate, int endDate) {
        return hallOnlineDomain.listOnlineDaysInfo(group, beginDate, endDate);
    }

    /**
     * 大厅单日在线
     *
     * @param group
     * @param date
     * @return
     */
    @Override
    public ArrayList<HallOnlinePerDayDo> listHallOnlinePerDayInfo(int group, int date) {
        return hallOnlineDomain.listOnlinePerDayInfo(group, date);
    }

    /**
     * 大厅多月在线
     *
     * @param group
     * @param beginMonth
     * @param endMonth
     * @return
     */
    @Override
    public ArrayList<HallOnlineByMonthDo> listHallOnlineByMonthInfo(int group, int beginMonth, int endMonth) {
        return hallOnlineDomain.listOnlineMonthsInfo(group, beginMonth, endMonth);
    }
}
