package ct.dc.mobile.api.domain;

import ct.dc.mobile.api.model.domain.app.AppRetainByDaysDo;
import ct.dc.mobile.api.model.domain.report.ReportGameRetainDo;

import java.util.ArrayList;

/**
 * Created by B41-80 on 2017/1/9.
 */
public interface IAppRetainDomain {
    ArrayList<AppRetainByDaysDo> getRetainResultsByDays(long app, int begin, int end);

    ArrayList<ReportGameRetainDo> getReportRetain(int begin, int end);
}
