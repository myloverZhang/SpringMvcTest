package ct.dc.mobile.api.dao.mobilearea.Interface;

import ct.dc.mobile.api.model.po.mobilearea.AreaLoginByDayPo;

import java.util.ArrayList;

/**
 *
 *地区多日登录（非全国的接口）
 * Created by B41-80 on 2017/1/11.
 */
public interface IAreaProvinceLoginByDayDao {
    ArrayList<AreaLoginByDayPo> find(String province,int begin, int end);
}
