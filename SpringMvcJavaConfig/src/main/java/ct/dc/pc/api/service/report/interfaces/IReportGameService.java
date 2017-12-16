package ct.dc.pc.api.service.report.interfaces;

import ct.dc.pc.api.model.domain.report.ReportGameLoginByDayDo;
import ct.dc.pc.api.model.domain.report.ReportGameRetainByDayDo;

import java.util.ArrayList;

/**
 * Created by B41-80 on 2017/4/7.
 */
public interface IReportGameService {
    /**
     * 报表 游戏留存信息
     * @param beginDate
     * @param endDate
     * @return
     */
    ArrayList<ReportGameRetainByDayDo> listReportGameRetainInfo(int beginDate, int endDate);

    /**
     * 报表 游戏多日登录信息
     * @param beginDate
     * @param endDate
     * @return
     */
    ArrayList<ReportGameLoginByDayDo> listReportGameLoginInfo(int beginDate,int endDate);
}
