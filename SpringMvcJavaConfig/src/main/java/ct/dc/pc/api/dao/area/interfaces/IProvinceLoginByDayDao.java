package ct.dc.pc.api.dao.area.interfaces;

import ct.dc.pc.api.model.po.area.AreaLoginByDayPo;

import java.util.ArrayList;

/**
 * Created by B41-80 on 2017/3/31.
 */
public interface IProvinceLoginByDayDao {
    /**
     * 根据省份后期多日登录数据
     * @param province
     * @param beginDate
     * @param endDate
     * @return
     */
    ArrayList<AreaLoginByDayPo> findByProvince(String province,int beginDate,int endDate);
}
