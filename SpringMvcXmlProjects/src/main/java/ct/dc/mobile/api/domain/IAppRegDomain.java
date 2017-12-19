package ct.dc.mobile.api.domain;

import ct.dc.mobile.api.model.domain.app.AppRegByDayDo;
import ct.dc.mobile.api.model.domain.app.AppRegByMonthDo;
import ct.dc.mobile.api.model.domain.report.ReportGameRegDo;

import java.util.ArrayList;

/**
 * Created by B41-80 on 2017/1/9.
 */
public interface IAppRegDomain {
    ArrayList<AppRegByDayDo> getRegUsersByDates(long app, int begin, int end);

    AppRegByMonthDo[] getRegUsersByMonth(long app, int begin, int end);

    ArrayList<ReportGameRegDo> getReportGameReg(int begin, int end);
}
