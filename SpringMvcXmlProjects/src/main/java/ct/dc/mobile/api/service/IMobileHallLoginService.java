package ct.dc.mobile.api.service;

import ct.dc.mobile.api.model.domain.hall.HallLoginByDayDo;
import ct.dc.mobile.api.model.domain.hall.HallLoginByPerDayDo;

import java.util.ArrayList;

/**
 * Created by B41-80 on 2017/1/13.
 */
public interface IMobileHallLoginService {
    ArrayList<HallLoginByDayDo> loginUsersByDay(int hallId,int begin,int end);
    ArrayList<HallLoginByPerDayDo> loginUsersPerDay(int hallId,int date);
}
