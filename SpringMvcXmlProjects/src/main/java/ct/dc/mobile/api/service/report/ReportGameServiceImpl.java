package ct.dc.mobile.api.service.report;

import ct.dc.mobile.api.domain.login.MobileAppLoginDomain;
import ct.dc.mobile.api.domain.reg.MobileAppRegDomain;
import ct.dc.mobile.api.domain.retain.MobileAppRetainDomain;
import ct.dc.mobile.api.model.domain.report.ReportGameLoginDo;
import ct.dc.mobile.api.model.domain.report.ReportGameRegDo;
import ct.dc.mobile.api.model.domain.report.ReportGameRetainDo;
import ct.dc.mobile.api.service.IMobileReportGameService;

import java.util.ArrayList;

/**
 * Created by B41-80 on 2017/1/17.
 */
public class ReportGameServiceImpl implements IMobileReportGameService{
    private MobileAppLoginDomain mobileAppLoginDomain;
    private MobileAppRetainDomain mobileAppRetainDomain;
    private MobileAppRegDomain mobileAppRegDomain;

    public void setMobileAppLoginDomain(MobileAppLoginDomain mobileAppLoginDomain) {
        this.mobileAppLoginDomain = mobileAppLoginDomain;
    }

    public void setMobileAppRetainDomain(MobileAppRetainDomain mobileAppRetainDomain) {
        this.mobileAppRetainDomain = mobileAppRetainDomain;
    }

    public void setMobileAppRegDomain(MobileAppRegDomain mobileAppRegDomain) {
        this.mobileAppRegDomain = mobileAppRegDomain;
    }

    /**
     * 报表应用多日登录
     * @param begin
     * @param end
     * @return
     */
    @Override
    public ArrayList<ReportGameLoginDo> getGameLogin(int begin, int end) {
        return mobileAppLoginDomain.listReportLogin(begin,end);
    }

    /**
     * 报表app留存
     * @param begin
     * @param end
     * @return
     */
    @Override
    public ArrayList<ReportGameRetainDo> getGameRetain(int begin, int end) {
        return mobileAppRetainDomain.getReportRetain(begin,end);
    }

    /**
     * 报表应用注册
     * @param begin
     * @param end
     * @return
     */
    @Override
    public ArrayList<ReportGameRegDo> getGameReg(int begin, int end) {
        return mobileAppRegDomain.getReportGameReg(begin,end);
    }
}
