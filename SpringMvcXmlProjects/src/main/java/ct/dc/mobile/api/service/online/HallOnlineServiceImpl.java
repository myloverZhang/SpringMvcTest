package ct.dc.mobile.api.service.online;

import ct.dc.mobile.api.domain.online.MobileHallOnlineDomain;
import ct.dc.mobile.api.model.domain.hall.HallOnlineByDayDo;
import ct.dc.mobile.api.model.domain.hall.HallOnlineByMonthDo;
import ct.dc.mobile.api.model.domain.hall.HallOnlineByPerDayDo;
import ct.dc.mobile.api.service.IMobileHallOnlineService;

import java.util.ArrayList;

/**
 * Created by B41-80 on 2017/1/13.
 */
public class HallOnlineServiceImpl implements IMobileHallOnlineService{
    private MobileHallOnlineDomain mobileHallOnlineDomain;

    public void setMobileHallOnlineDomain(MobileHallOnlineDomain mobileHallOnlineDomain) {
        this.mobileHallOnlineDomain = mobileHallOnlineDomain;
    }

    @Override
    public ArrayList<HallOnlineByDayDo> onlineUsersByDay(int begin, int end, int hallId) {
        return mobileHallOnlineDomain.onlineByDay(begin,end,hallId);
    }

    @Override
    public ArrayList<HallOnlineByPerDayDo> onlineUsersPerDay(int date, int hallId) {
        return mobileHallOnlineDomain.onlineByPerDay(date,hallId);
    }

    @Override
    public ArrayList<HallOnlineByMonthDo> onlineUsersByMonth(int begin, int end, int hallId) {
        return mobileHallOnlineDomain.onlineByMonth(begin,end,hallId);
    }
}
