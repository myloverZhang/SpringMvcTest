package ct.dc.pc.api.dao.area.interfaces;

import ct.dc.pc.api.model.po.area.AreaLoginPerDayPo;

import java.util.ArrayList;

/**
 * Created by B41-80 on 2017/3/31.
 */
public interface ICity2LoginPerDayDao {
    /**
     * 通过地级市和日期查找单日登录数据
     * @param city
     * @param beginDate
     * @param endDate
     * @return
     */
    ArrayList<AreaLoginPerDayPo> findByCity(String city,int beginDate,int endDate);

    /**
     * 通过地级市和日期查找单日登录数据
     * @param city
     * @param date
     * @return
     */
    ArrayList<AreaLoginPerDayPo> findByCity(String city,int date);
}
