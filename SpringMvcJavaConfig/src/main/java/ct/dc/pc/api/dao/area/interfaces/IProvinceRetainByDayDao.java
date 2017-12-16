package ct.dc.pc.api.dao.area.interfaces;

import ct.dc.pc.api.model.po.area.AreaRetainByDayPo;

import java.util.ArrayList;

/**
 * Created by B41-80 on 2017/3/31.
 */
public interface IProvinceRetainByDayDao {
    /**
     * 根据省份和日期查找留存信息
     * @param province
     * @param beginDate
     * @param endDate
     * @return
     */
    ArrayList<AreaRetainByDayPo> findByProvince(String province,int beginDate,int endDate);
}
