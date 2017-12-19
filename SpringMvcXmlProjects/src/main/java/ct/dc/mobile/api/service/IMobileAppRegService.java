package ct.dc.mobile.api.service;

import ct.dc.mobile.api.model.domain.app.AppRegByDayDo;
import ct.dc.mobile.api.model.domain.app.AppRegByMonthDo;

import java.util.ArrayList;

/**
 * Created by B41-80 on 2017/1/9.
 */
public interface IMobileAppRegService {
    ArrayList<AppRegByDayDo> regInfoByDays(long app, int begin, int end);
    AppRegByMonthDo[] regInfoByMonth(long app, int begin, int end);
}
