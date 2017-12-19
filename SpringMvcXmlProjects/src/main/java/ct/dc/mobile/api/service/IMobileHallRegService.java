package ct.dc.mobile.api.service;

import ct.dc.mobile.api.model.domain.hall.HallRegByDayDo;
import ct.dc.mobile.api.model.domain.hall.HallRegByMonthDo;

import java.util.ArrayList;

/**
 * Created by B41-80 on 2017/1/13.
 */
public interface IMobileHallRegService {
    ArrayList<HallRegByDayDo> regUsersByDay(int hallId, int begin, int end);

    HallRegByMonthDo[] regUserByMonth(int hallId, int begin, int end);
}
