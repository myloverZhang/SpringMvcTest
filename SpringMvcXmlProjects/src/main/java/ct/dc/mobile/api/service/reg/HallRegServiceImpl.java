package ct.dc.mobile.api.service.reg;

import ct.dc.mobile.api.domain.reg.MobileHallRegDomain;
import ct.dc.mobile.api.model.domain.hall.HallRegByDayDo;
import ct.dc.mobile.api.model.domain.hall.HallRegByMonthDo;
import ct.dc.mobile.api.service.IMobileHallRegService;

import java.util.ArrayList;

/**
 * Created by B41-80 on 2017/1/13.
 */
public class HallRegServiceImpl implements IMobileHallRegService{
    private MobileHallRegDomain mobileHallRegDomain;

    public void setMobileHallRegDomain(MobileHallRegDomain mobileHallRegDomain) {
        this.mobileHallRegDomain = mobileHallRegDomain;
    }

    @Override
    public ArrayList<HallRegByDayDo> regUsersByDay(int hallId, int begin, int end) {
        return mobileHallRegDomain.regUsersByDay(begin,end,hallId);
    }

    @Override
    public HallRegByMonthDo[] regUserByMonth(int hallId, int begin, int end) {
        return mobileHallRegDomain.regUsersByMonth(begin,end,hallId);
    }
}
