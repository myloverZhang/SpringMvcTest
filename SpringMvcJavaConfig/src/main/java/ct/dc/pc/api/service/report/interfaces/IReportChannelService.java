package ct.dc.pc.api.service.report.interfaces;

import ct.dc.pc.api.model.domain.report.*;

import java.util.ArrayList;

/**
 * Created by CTWLPC on 2017/9/15.
 */
public interface IReportChannelService {
    /**
     * 获取注册信息
     * @param beginDate
     * @param endDate
     * @return
     */
    ArrayList<ReportChannelRegDo> listChannelRegIfs(int beginDate,int endDate);

    /**
     * 注册渠道多日登录信息
     * @param beginDate
     * @param endDate
     * @return
     */
    ArrayList<ReportRegChannelLoginDo> listRegChannelLoginIfs(int beginDate,int endDate);

    /**
     * 渠道多日登录信息
     * @param beginDate
     * @param endDate
     * @return
     */
    ArrayList<ReportChannelLoginDo> listChannelLoginIfs(int beginDate,int endDate);

    /**
     * 渠道多日留存信息
     * @param beginDate
     * @param endDate
     * @return
     */
    ArrayList<ReportChannelRegRetainByDayDo> listChannelRegRetainIfs(int beginDate,int endDate);

    /**
     * 渠道周留存信息
     * @param beginDate
     * @param endDate
     * @return
     */
    ArrayList<ReportChannelRegWeekRetainDo> listChannelRegWeekRetainIfs(int beginDate,int endDate);
}
