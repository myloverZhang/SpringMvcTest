package ct.dc.mobile.api.service.login;

import ct.dc.mobile.api.domain.login.MobileAppLoginDomain;
import ct.dc.mobile.api.model.domain.app.AppLoginByDayDo;
import ct.dc.mobile.api.model.domain.app.AppLoginByPerDayDo;
import ct.dc.mobile.api.service.IMobileAppLoginService;

import java.util.ArrayList;

/**
 * Created by B41-80 on 2017/1/5.
 */
public class AppLoginServiceImpl implements IMobileAppLoginService {
    private MobileAppLoginDomain appLoginDomain;

    public void setAppLoginDomain(MobileAppLoginDomain appLoginDomain) {
        this.appLoginDomain = appLoginDomain;
    }

    /**
     * 多日登录
     * @param appId
     * @param begin
     * @param end
     * @return
     */
    public ArrayList<AppLoginByDayDo> appUsersByDay(long appId, int begin, int end)
    {
        return appLoginDomain.getLoginUserByDay(appId,begin,end);
    }

    /**
     * 单日登录
     * @param appId
     * @param date
     * @return
     */
    public ArrayList<AppLoginByPerDayDo> appUsersByPerDay(long appId, int date) {

        return appLoginDomain.getLoginUserByPerDay(appId,date);
    }
}
