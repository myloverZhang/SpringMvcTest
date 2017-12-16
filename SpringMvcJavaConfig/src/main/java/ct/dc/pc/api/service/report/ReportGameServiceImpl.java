package ct.dc.pc.api.service.report;

import ct.dc.pc.api.model.domain.report.ReportGameLoginByDayDo;
import ct.dc.pc.api.model.domain.report.ReportGameRetainByDayDo;
import ct.dc.pc.api.service.report.interfaces.IReportGameService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

/**
 * Created by B41-80 on 2017/4/7.
 */
@Service
public class ReportGameServiceImpl implements IReportGameService{
    /**
     * 报表 游戏留存信息
     *
     * @param beginDate
     * @param endDate
     * @return
     */
    @Override
    public ArrayList<ReportGameRetainByDayDo> listReportGameRetainInfo(int beginDate, int endDate) {
        return null;
    }

    /**
     * 报表 游戏多日登录信息
     *
     * @param beginDate
     * @param endDate
     * @return
     */
    @Override
    public ArrayList<ReportGameLoginByDayDo> listReportGameLoginInfo(int beginDate, int endDate) {
        return null;
    }
}
