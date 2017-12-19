package ct.dc.mobile.api.dao.mobilearea.Interface;

import ct.dc.mobile.api.model.po.mobilearea.AreaLoginByDayPo;

import java.util.ArrayList;

/**
 * 多日登录全国接口
 * Created by B41-80 on 2017/1/11.
 */
public interface IAreaNationLoginByDayDao {
    ArrayList<AreaLoginByDayPo> find(int begin, int end);
}
