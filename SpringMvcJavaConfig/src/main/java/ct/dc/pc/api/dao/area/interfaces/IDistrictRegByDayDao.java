package ct.dc.pc.api.dao.area.interfaces;

import ct.dc.pc.api.model.po.area.AreaRegByDayPo;

import java.util.ArrayList;

/**
 * Created by B41-80 on 2017/3/31.
 */
public interface IDistrictRegByDayDao {
    /**
     * 根据县区和日期查找数据
     * @param district
     * @param beginDate
     * @param endDate
     * @return
     */
    ArrayList<AreaRegByDayPo> findByDistrict(String district,int beginDate,int endDate);
}
