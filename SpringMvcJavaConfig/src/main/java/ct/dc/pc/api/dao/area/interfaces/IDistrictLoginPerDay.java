package ct.dc.pc.api.dao.area.interfaces;

import ct.dc.pc.api.model.po.area.AreaLoginPerDayPo;

import java.util.ArrayList;

/**
 * Created by B41-80 on 2017/3/31.
 */
public interface IDistrictLoginPerDay {
    /**
     * 根据日期县区获取数据
     * @param district
     * @param date
     * @return
     */
    ArrayList<AreaLoginPerDayPo> findByDistrict(String district,int date);
}
