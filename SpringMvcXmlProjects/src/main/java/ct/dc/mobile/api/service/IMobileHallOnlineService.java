package ct.dc.mobile.api.service;

import ct.dc.mobile.api.model.domain.hall.HallOnlineByDayDo;
import ct.dc.mobile.api.model.domain.hall.HallOnlineByMonthDo;
import ct.dc.mobile.api.model.domain.hall.HallOnlineByPerDayDo;

import java.util.ArrayList;

/**
 * Created by B41-80 on 2017/1/13.
 */
public interface IMobileHallOnlineService {
    ArrayList<HallOnlineByDayDo> onlineUsersByDay(int begin, int end, int hallId);

    ArrayList<HallOnlineByPerDayDo> onlineUsersPerDay(int date, int hallId);

    ArrayList<HallOnlineByMonthDo> onlineUsersByMonth(int begin, int end, int hallId);
}
