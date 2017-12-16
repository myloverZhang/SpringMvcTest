package ct.dc.pc.api.dao.area.interfaces;

import ct.dc.pc.api.model.po.area.AreaLoginByDayPo;

import java.util.ArrayList;

/**
 * Created by B41-80 on 2017/3/31.
 */
public interface IDistrictLoginByDay {
    /**
     * 通过县区信息查询多日登录数据
     * @param district
     * @param beginDate
     * @param endDate
     * @return
     */
    ArrayList<AreaLoginByDayPo> findByDistrict(String district,int beginDate,int endDate);
}
