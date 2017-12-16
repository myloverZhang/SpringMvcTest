package ct.dc.pc.api.service.report;

import ct.dc.pc.api.model.domain.report.ReportCityLoginByDayDo;
import ct.dc.pc.api.model.domain.report.ReportCityRegByDayDo;
import ct.dc.pc.api.model.domain.report.ReportCityRetainByDayDo;
import ct.dc.pc.api.service.report.interfaces.IReportAreaService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

/**
 * Created by B41-80 on 2017/4/7.
 */
@Service
public class ReportAreaServiceImpl implements IReportAreaService{


    /**
     * 地级市多日留存报表信息
     *
     * @param beginDate
     * @param endDate
     * @return
     */
    @Override
    public ArrayList<ReportCityRetainByDayDo> listReportCityRetainInfo(int beginDate, int endDate) {
        return null;
    }

    /**
     * 地级市多日登录报表信息
     *
     * @param beginDate
     * @param endDate
     * @return
     */
    @Override
    public ArrayList<ReportCityLoginByDayDo> listReportCityLoginInfo(int beginDate, int endDate) {
        return null;
    }

    /**
     * 地级市注册 报表信息
     *
     * @param beginDate
     * @param endDate
     * @return
     */
    @Override
    public ArrayList<ReportCityRegByDayDo> listReportCityRegInfo(int beginDate, int endDate) {
        return null;
    }
}
