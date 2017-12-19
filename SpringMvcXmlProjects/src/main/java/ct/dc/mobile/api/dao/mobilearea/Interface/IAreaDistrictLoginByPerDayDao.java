package ct.dc.mobile.api.dao.mobilearea.Interface;

import ct.dc.mobile.api.model.po.mobilearea.AreaLoginByPerDayPo;

import java.util.ArrayList;

/**
 * Created by B41-80 on 2017/1/11.
 */
public interface IAreaDistrictLoginByPerDayDao {
    ArrayList<AreaLoginByPerDayPo> find(String district, int date);
}
