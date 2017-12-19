package ct.dc.mobile.api.dao.mobileHall.Interface;

import ct.dc.mobile.api.model.po.mobilehall.HallOnlineByDayPo;

import java.util.ArrayList;

/**
 * Created by B41-80 on 2017/1/13.
 */
public interface IHallOnlineByDayDao {
    ArrayList<HallOnlineByDayPo> find(int begin,int end,int hallId);
}
