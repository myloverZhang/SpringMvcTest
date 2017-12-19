package ct.dc.mobile.api.service;

import ct.dc.mobile.api.model.domain.areaApp.AreaAppLoginByDayDo;
import ct.dc.mobile.api.model.domain.areaApp.AreaAppLoginDetailsByDayDo;

import java.util.ArrayList;

/**
 * Created by B41-80 on 2017/1/12.
 */
public interface IMobileAreaAppLoginService {
    ArrayList<AreaAppLoginByDayDo> areaAppLoginByDay(String areaId, int begin, int end);
    ArrayList<AreaAppLoginDetailsByDayDo> areaAppLoginDetailsByDay(String areaId, int begin, int end, long app);
}
