package ct.dc.mobile.api.dao.mobileHall.Interface;

import ct.dc.mobile.api.model.po.mobilehall.HallLoginByDayPo;

import java.util.ArrayList;

/**
 * Created by B41-80 on 2017/1/13.
 */
public interface IHallLoginByDayDao {
    ArrayList<HallLoginByDayPo> find(int begin,int end,int hallId);
}
