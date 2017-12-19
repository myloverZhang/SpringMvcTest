package ct.dc.mobile.api.service.apparea;

import ct.dc.mobile.api.domain.apparea.MobileAppAreaDomain;
import ct.dc.mobile.api.model.domain.areaApp.AppAreaLoginByDayDo;
import ct.dc.mobile.api.model.domain.areaApp.AppAreaLoginDetailsByDayDo;
import ct.dc.mobile.api.service.IMobileAppAreaLoginService;

import java.util.ArrayList;

/**
 * Created by B41-80 on 2017/1/10.
 */
public class AppAreaLoginServiceImpl implements IMobileAppAreaLoginService{
    private MobileAppAreaDomain mobileAppAreaDomain;

    public void setMobileAppAreaDomain(MobileAppAreaDomain mobileAppAreaDomain) {
        this.mobileAppAreaDomain = mobileAppAreaDomain;
    }

    /**
     * 获取应用地区二合的一级界面数据
     * @param begin
     * @param end
     * @param app
     * @return
     */
    public ArrayList<AppAreaLoginByDayDo> appAreaLoginByDays(int begin,int end, long app) {
        return mobileAppAreaDomain.appAreaByDay(app,begin,end);
    }

    /**
     * 获得应用地区二合的二级界面数据
     * @param begin
     * @param end
     * @param areaId
     * @param app
     * @return
     */
    public ArrayList<AppAreaLoginDetailsByDayDo> appAreaLoginDetailsByDays(int begin,int end,String areaId,long app){
        return mobileAppAreaDomain.appAreaDetailsByDay(app,begin,end,areaId);
    }
}
