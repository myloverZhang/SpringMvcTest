package ct.dc.mobile.api.service.reg;

import ct.dc.mobile.api.domain.reg.MobileAppRegDomain;
import ct.dc.mobile.api.model.domain.app.AppRegByDayDo;
import ct.dc.mobile.api.model.domain.app.AppRegByMonthDo;
import ct.dc.mobile.api.service.IMobileAppRegService;

import java.util.ArrayList;

/**
 * Created by B41-80 on 2017/1/9.
 */
public class AppRegServiceImpl implements IMobileAppRegService{
    private MobileAppRegDomain mobileAppRegDomain;

    public void setMobileAppRegDomain(MobileAppRegDomain mobileAppRegDomain) {
        this.mobileAppRegDomain = mobileAppRegDomain;
    }

    public ArrayList<AppRegByDayDo> regInfoByDays(long app, int begin, int end) {
        return mobileAppRegDomain.getRegUsersByDates(app,begin,end);
    }

    public AppRegByMonthDo[] regInfoByMonth(long app, int begin, int end) {
        return mobileAppRegDomain.getRegUsersByMonth(app,begin,end);
    }
}
