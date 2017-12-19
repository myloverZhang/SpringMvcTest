package ct.dc.mobile.api.dao.mobilearea.Interface;

import ct.dc.mobile.api.model.po.mobilearea.AreaRegByDayPo;

import java.util.ArrayList;

/**
 * Created by B41-80 on 2017/1/11.
 */
public interface IAreaCityRegByDayDao {
    ArrayList<AreaRegByDayPo> find(int begin, int end,String city);
    ArrayList<AreaRegByDayPo> find(int begin,int end);
}
