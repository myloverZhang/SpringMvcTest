package ct.dc.pc.api.service.report;

import ct.dc.pc.api.model.domain.report.ReportHallLoginByDayDo;
import ct.dc.pc.api.model.domain.report.ReportHallRegByDayDo;
import ct.dc.pc.api.model.domain.report.ReportHallRetainByDayDo;
import ct.dc.pc.api.service.report.interfaces.IReportHallService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

/**
 * Created by B41-80 on 2017/4/7.
 */
@Service
public class ReportRegServiceImpl implements IReportHallService{
    /**
     * 报表 大厅多日登录信息
     *
     * @param beginDate
     * @param endDate
     * @return
     */
    @Override
    public ArrayList<ReportHallLoginByDayDo> listReportHallLoginInfo(int beginDate, int endDate) {
        return null;
    }

    /**
     * 报表 大厅多日留存
     *
     * @param beginDate
     * @param endDate
     * @return
     */
    @Override
    public ArrayList<ReportHallRetainByDayDo> listReportHallRetainInHallInfo(int beginDate, int endDate) {
        return null;
    }

    /**
     * 报表 大厅多日留存
     *
     * @param beginDate
     * @param endDate
     * @return
     */
    @Override
    public ArrayList<ReportHallRetainByDayDo> listReportHallRetainInPcInfo(int beginDate, int endDate) {
        return null;
    }

    /**
     * 报表 大厅多日注册
     *
     * @param beginDate
     * @param endDate
     * @return
     */
    @Override
    public ArrayList<ReportHallRegByDayDo> listReportHallRegInfo(int beginDate, int endDate) {
        return null;
    }
}
