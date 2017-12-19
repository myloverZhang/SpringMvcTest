package ct.dc.mobile.api.service;

import ct.dc.mobile.api.model.domain.area.AreaRegDayDo;
import ct.dc.mobile.api.model.domain.area.AreaRegMonthDo;

import java.awt.geom.Area;
import java.util.ArrayList;

/**
 * Created by B41-80 on 2017/1/12.
 */
public interface IMobileAreaRegService {
    ArrayList<AreaRegDayDo> regInfoByDay(int begin,int end,String areaId);
    AreaRegMonthDo[] regInfoByMonth(int begin,int end,String areaId);
}
