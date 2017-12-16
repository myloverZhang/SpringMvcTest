package ct.dc.pc.api.dao.area.interfaces;

import ct.dc.pc.api.model.po.area.AreaRegByDayPo;

import java.util.ArrayList;

/**
 * Created by B41-80 on 2017/3/31.
 */
public interface ICity2RegByDayDao {
    /**
     * 根据地级市和日期查询注册信息
     * @param city
     * @param beginDate
     * @param endDate
     * @return
     */
    ArrayList<AreaRegByDayPo> findByCity(String city,int beginDate,int endDate);

    /**
     * 根据日期查询地级市多日注册数据
     * @param beginDate
     * @param endDate
     * @return
     */
    ArrayList<AreaRegByDayPo> find(int beginDate,int endDate);
}
