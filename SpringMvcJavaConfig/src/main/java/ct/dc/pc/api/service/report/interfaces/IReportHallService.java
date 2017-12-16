package ct.dc.pc.api.service.report.interfaces;

import ct.dc.pc.api.model.domain.report.ReportHallLoginByDayDo;
import ct.dc.pc.api.model.domain.report.ReportHallRegByDayDo;
import ct.dc.pc.api.model.domain.report.ReportHallRetainByDayDo;

import java.util.ArrayList;

/**
 * Created by B41-80 on 2017/4/7.
 */
public interface IReportHallService {
    /**
     * 报表 大厅多日登录信息
     * @param beginDate
     * @param endDate
     * @return
     */
    ArrayList<ReportHallLoginByDayDo> listReportHallLoginInfo(int beginDate,int endDate);

    /**
     * 报表 大厅多日留存
     * @param beginDate
     * @param endDate
     * @return
     */
    ArrayList<ReportHallRetainByDayDo> listReportHallRetainInHallInfo(int beginDate,int endDate);

    /**
     * 报表 大厅多日留存
     * @param beginDate
     * @param endDate
     * @return
     */
    ArrayList<ReportHallRetainByDayDo> listReportHallRetainInPcInfo(int beginDate,int endDate);

    /**
     * 报表 大厅多日注册
     * @param beginDate
     * @param endDate
     * @return
     */
    ArrayList<ReportHallRegByDayDo> listReportHallRegInfo(int beginDate,int endDate);
}

