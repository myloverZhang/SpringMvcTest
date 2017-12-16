package ct.dc.pc.api.dao.area.interfaces;

import ct.dc.pc.api.model.po.area.AreaLoginPerDayPo;

import java.util.ArrayList;

/**
 * Created by B41-80 on 2017/3/31.
 */
public interface IProvinceLoginPerDayDao {
    /**
     * 根据省份查询单日登录数据
     * @param province
     * @param date
     * @return
     */
    ArrayList<AreaLoginPerDayPo> findByProvince(String province,int date);
}
