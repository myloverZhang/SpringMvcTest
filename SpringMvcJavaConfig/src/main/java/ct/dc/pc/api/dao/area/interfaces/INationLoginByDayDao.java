package ct.dc.pc.api.dao.area.interfaces;

import ct.dc.pc.api.model.po.area.AreaLoginByDayPo;

import java.util.ArrayList;

/**
 * Created by B41-80 on 2017/3/31.
 */
public interface INationLoginByDayDao {
    /**
     * 根据日期获取全国的多日登录信息
     * @param beginDate
     * @param endDate
     * @return
     */
    ArrayList<AreaLoginByDayPo> find(int beginDate,int endDate);
}
