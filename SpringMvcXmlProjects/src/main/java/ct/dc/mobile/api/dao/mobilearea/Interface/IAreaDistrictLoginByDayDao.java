package ct.dc.mobile.api.dao.mobilearea.Interface;

import ct.dc.mobile.api.model.po.mobilearea.AreaLoginByDayPo;

import java.util.ArrayList;

/**
 * Created by B41-80 on 2017/1/11.
 */
public interface IAreaDistrictLoginByDayDao {
    ArrayList<AreaLoginByDayPo> find(String district, int begin, int end);
}
