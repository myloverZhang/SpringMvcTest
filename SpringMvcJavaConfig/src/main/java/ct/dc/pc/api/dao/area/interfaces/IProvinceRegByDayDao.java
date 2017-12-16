package ct.dc.pc.api.dao.area.interfaces;

import ct.dc.pc.api.model.po.area.AreaRegByDayPo;

import java.util.ArrayList;

/**
 * Created by B41-80 on 2017/3/31.
 */
public interface IProvinceRegByDayDao {
    /**
     * 根据省份和日期查询注册信息
     * @param province
     * @param beginDate
     * @param endDate
     * @return
     */
    ArrayList<AreaRegByDayPo> findByProvince(String province,int beginDate,int endDate);
}
