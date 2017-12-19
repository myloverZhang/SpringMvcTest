package ct.dc.mobile.api.service;

import ct.dc.mobile.api.model.domain.report.ReportAreaLoginDo;
import ct.dc.mobile.api.model.domain.report.ReportAreaRegDo;

import java.util.ArrayList;

/**
 * Created by B41-80 on 2017/1/17.
 */
public interface IMobileReportAreaService {
    ArrayList<ReportAreaLoginDo> getAreaLogin(int begin, int end);

    ArrayList<ReportAreaRegDo> getAreaReg(int begin, int end);
}
