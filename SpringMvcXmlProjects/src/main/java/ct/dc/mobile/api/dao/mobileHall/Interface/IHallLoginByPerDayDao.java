package ct.dc.mobile.api.dao.mobileHall.Interface;

import ct.dc.mobile.api.model.po.mobilehall.HallLoginPerDayPo;

import java.util.ArrayList;

/**
 * Created by B41-80 on 2017/1/13.
 */
public interface IHallLoginByPerDayDao {
    ArrayList<HallLoginPerDayPo> find(int date,int hallId);
}
