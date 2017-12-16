package ct.dc.pc.api.service.report.interfaces;

import ct.dc.pc.api.model.domain.report.ReportCityLoginByDayDo;
import ct.dc.pc.api.model.domain.report.ReportCityRegByDayDo;
import ct.dc.pc.api.model.domain.report.ReportCityRetainByDayDo;

import java.util.ArrayList;

/**
 * Created by B41-80 on 2017/4/7.
 */
public interface IReportAreaService {
    /**
     * 地级市多日留存报表信息
     * @param beginDate
     * @param endDate
     * @return
     */
    ArrayList<ReportCityRetainByDayDo> listReportCityRetainInfo(int beginDate,int endDate);

    /**
     * 地级市多日登录报表信息
     * @param beginDate
     * @param endDate
     * @return
     */
    ArrayList<ReportCityLoginByDayDo> listReportCityLoginInfo(int beginDate,int endDate);

    /**
     * 地级市注册 报表信息
     * @param beginDate
     * @param endDate
     * @return
     */
    ArrayList<ReportCityRegByDayDo> listReportCityRegInfo(int beginDate,int endDate);
}
