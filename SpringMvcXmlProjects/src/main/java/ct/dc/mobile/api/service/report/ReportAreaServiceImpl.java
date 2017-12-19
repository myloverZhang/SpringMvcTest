package ct.dc.mobile.api.service.report;

import ct.dc.mobile.api.domain.login.MobileAreaLoginDomain;
import ct.dc.mobile.api.domain.reg.MobileAreaRegDomain;
import ct.dc.mobile.api.model.domain.report.ReportAreaLoginDo;
import ct.dc.mobile.api.model.domain.report.ReportAreaRegDo;
import ct.dc.mobile.api.service.IMobileReportAreaService;

import java.util.ArrayList;

/**
 * Created by B41-80 on 2017/1/17.
 */
public class ReportAreaServiceImpl implements IMobileReportAreaService{
    private MobileAreaLoginDomain mobileAreaLoginDomain;
    private MobileAreaRegDomain mobileAreaRegDomain;

    public void setMobileAreaLoginDomain(MobileAreaLoginDomain mobileAreaLoginDomain) {
        this.mobileAreaLoginDomain = mobileAreaLoginDomain;
    }

    public void setMobileAreaRegDomain(MobileAreaRegDomain mobileAreaRegDomain) {
        this.mobileAreaRegDomain = mobileAreaRegDomain;
    }

    /**
     * 报表地区登录信息
     * @param begin
     * @param end
     * @return
     */
    @Override
    public ArrayList<ReportAreaLoginDo> getAreaLogin(int begin, int end) {
        return mobileAreaLoginDomain.reportAreaLogin(begin,end);
    }

    /**
     * 报表地区注册时间
     * @param begin
     * @param end
     * @return
     */
    @Override
    public ArrayList<ReportAreaRegDo> getAreaReg(int begin, int end) {
        return mobileAreaRegDomain.reportCityRegByDays(begin,end);
    }
}
