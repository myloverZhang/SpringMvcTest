package ct.dc.pc.api.service.report;

import ct.dc.pc.api.domain.report.ReportChannelDomain;
import ct.dc.pc.api.model.domain.report.*;
import ct.dc.pc.api.service.report.interfaces.IReportChannelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

/**
 * Created by CTWLPC on 2017/9/15.
 */
@Service
public class ReportChannelServiceImpl implements IReportChannelService{
    @Autowired
    private ReportChannelDomain reportChannelDomain;
    /**
     * 获取注册信息
     *
     * @param beginDate
     * @param endDate
     * @return
     */
    @Override
    public ArrayList<ReportChannelRegDo> listChannelRegIfs(int beginDate, int endDate) {
        return reportChannelDomain.listChannelRegIfs(beginDate, endDate);
    }

    /**
     * 注册渠道多日登录信息
     *
     * @param beginDate
     * @param endDate
     * @return
     */
    @Override
    public ArrayList<ReportRegChannelLoginDo> listRegChannelLoginIfs(int beginDate, int endDate) {
        return reportChannelDomain.listRegChannelLoginIfs(beginDate, endDate);
    }

    /**
     * 渠道多日登录信息
     *
     * @param beginDate
     * @param endDate
     * @return
     */
    @Override
    public ArrayList<ReportChannelLoginDo> listChannelLoginIfs(int beginDate, int endDate) {
        return reportChannelDomain.listChannelLoginIfs(beginDate, endDate);
    }

    /**
     * 渠道多日留存信息
     *
     * @param beginDate
     * @param endDate
     * @return
     */
    @Override
    public ArrayList<ReportChannelRegRetainByDayDo> listChannelRegRetainIfs(int beginDate, int endDate) {
        return reportChannelDomain.listChannelRetainIfs(beginDate, endDate);
    }

    /**
     * 渠道周留存信息
     *
     * @param beginDate
     * @param endDate
     * @return
     */
    @Override
    public ArrayList<ReportChannelRegWeekRetainDo> listChannelRegWeekRetainIfs(int beginDate, int endDate) {
        return reportChannelDomain.listChannelWeekRetainIfs(beginDate, endDate);
    }
}
