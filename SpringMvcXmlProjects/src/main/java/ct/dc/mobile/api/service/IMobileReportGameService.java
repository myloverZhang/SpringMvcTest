package ct.dc.mobile.api.service;

import ct.dc.mobile.api.model.domain.report.ReportGameLoginDo;
import ct.dc.mobile.api.model.domain.report.ReportGameRegDo;
import ct.dc.mobile.api.model.domain.report.ReportGameRetainDo;

import java.util.ArrayList;

/**
 * Created by B41-80 on 2017/1/17.
 */
public interface IMobileReportGameService {
    ArrayList<ReportGameLoginDo> getGameLogin(int begin, int end);

    ArrayList<ReportGameRetainDo> getGameRetain(int begin, int end);

    ArrayList<ReportGameRegDo> getGameReg(int begin, int end);
}
