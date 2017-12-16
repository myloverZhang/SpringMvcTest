package ct.dc.pc.api.dao.area.interfaces;

import ct.dc.pc.api.model.po.area.AreaLoginPerDayPo;

import java.util.ArrayList;

/**
 * Created by B41-80 on 2017/3/31.
 */
public interface INationLoginPerDayDao {
    /**
     * 根据日期查询全国单日登录信息
     * @param date
     * @return
     */
    ArrayList<AreaLoginPerDayPo> find(int date);
}
