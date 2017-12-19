package ct.dc.mobile.api.service;

import ct.dc.mobile.api.model.domain.area.AreaLoginByDayDo;
import ct.dc.mobile.api.model.domain.area.AreaLoginByPerDayDo;

import java.util.ArrayList;

/**
 * Created by B41-80 on 2017/1/11.
 */
public interface IMobileAreaLoginService {
    ArrayList<AreaLoginByDayDo> loginUsersByDay(String areaId, int begin, int end);
    ArrayList<AreaLoginByPerDayDo> loginUsersByPerDay(String areaId,int date);
}
