package ct.dc.mobile.api.service.retain;

import ct.dc.mobile.api.domain.retain.MobileAppRetainDomain;
import ct.dc.mobile.api.model.domain.app.AppRetainByDaysDo;
import ct.dc.mobile.api.service.IMobileAppRetainService;

import java.util.ArrayList;

/**
 * Created by B41-80 on 2017/1/9.
 */
public class AppRetainServiceImpl implements IMobileAppRetainService{
    private MobileAppRetainDomain mobileAppRetainDomain;

    public void setMobileAppRetainDomain(MobileAppRetainDomain mobileAppRetainDomain) {
        this.mobileAppRetainDomain = mobileAppRetainDomain;
    }

    public ArrayList<AppRetainByDaysDo> retainInfoByDays(long app, int begin, int end) {
        return  mobileAppRetainDomain.getRetainResultsByDays(app,begin,end);
    }
}
