package ct.dc.pc.api.dao.area.interfaces;

import ct.dc.pc.api.model.po.area.AreaRegByDayPo;

import java.util.ArrayList;

/**
 * Created by B41-80 on 2017/3/31.
 */
public interface INationRegByDayDao {
    /**
     * 根据日期获取全国注册信息
     * @param beginDate
     * @param endDate
     * @return
     */
    ArrayList<AreaRegByDayPo> find(int beginDate,int endDate);
}
