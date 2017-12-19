package ct.dc.mobile.api.service.login;

import ct.dc.mobile.api.domain.login.MobileHallLoginDomain;
import ct.dc.mobile.api.model.domain.hall.HallLoginByDayDo;
import ct.dc.mobile.api.model.domain.hall.HallLoginByPerDayDo;
import ct.dc.mobile.api.service.IMobileHallLoginService;

import java.util.ArrayList;

/**
 * Created by B41-80 on 2017/1/13.
 */
public class HallLoginServiceImpl implements IMobileHallLoginService{
    private MobileHallLoginDomain mobileHallLoginDomain;

    public void setMobileHallLoginDomain(MobileHallLoginDomain mobileHallLoginDomain) {
        this.mobileHallLoginDomain = mobileHallLoginDomain;
    }

    @Override
    public ArrayList<HallLoginByDayDo> loginUsersByDay(int hallId, int begin, int end) {
        return mobileHallLoginDomain.hallLoginUsersByDay(begin,end,hallId);
    }

    @Override
    public ArrayList<HallLoginByPerDayDo> loginUsersPerDay(int hallId, int date) {
        return mobileHallLoginDomain.hallLoginUserPerDay(date,hallId);
    }
}
