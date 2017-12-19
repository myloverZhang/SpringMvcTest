package ct.dc.mobile.api.domain;

import ct.dc.mobile.api.model.domain.areaApp.AppAreaLoginByDayDo;
import ct.dc.mobile.api.model.domain.areaApp.AppAreaLoginDetailsByDayDo;

import java.util.ArrayList;

/**
 * Created by ssf on 2017/1/10.
 */
public interface IAppAreaDomain {
    ArrayList<AppAreaLoginByDayDo> appAreaByDay(long app, int begin, int end);

    ArrayList<AppAreaLoginDetailsByDayDo> appAreaDetailsByDay(long app, int begin, int end, String city);
}
