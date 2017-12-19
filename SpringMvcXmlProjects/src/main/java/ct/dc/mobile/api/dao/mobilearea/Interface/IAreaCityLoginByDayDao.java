package ct.dc.mobile.api.dao.mobilearea.Interface;

import ct.dc.mobile.api.model.po.mobilearea.AreaLoginByDayPo;

import java.util.ArrayList;

/**
 * Created by B41-80 on 2017/1/11.
 */
public interface IAreaCityLoginByDayDao {
    ArrayList<AreaLoginByDayPo> find(String city, int begin, int end);
    ArrayList<AreaLoginByDayPo> find(int begin,int end);
}
