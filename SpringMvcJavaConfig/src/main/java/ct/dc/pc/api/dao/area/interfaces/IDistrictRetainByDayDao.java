package ct.dc.pc.api.dao.area.interfaces;

import ct.dc.pc.api.model.po.area.AreaRetainByDayPo;

import java.util.ArrayList;

/**
 * Created by B41-80 on 2017/3/31.
 */
public interface IDistrictRetainByDayDao {
    /**
     * 根据县区获取数据
     * @param district
     * @param beginDate
     * @param endDate
     * @return
     */
    ArrayList<AreaRetainByDayPo> findByDistrict(String district,int beginDate,int endDate);
}
