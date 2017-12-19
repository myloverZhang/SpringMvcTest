package ct.dc.mobile.api.dao.mobileHall.Interface;

import ct.dc.mobile.api.model.po.mobilehall.HallRegByDayPo;

import java.util.ArrayList;

/**
 * Created by B41-80 on 2017/1/13.
 */
public interface IHallRegByDayDao {
    ArrayList<HallRegByDayPo> find(int begin,int end,int hallId);
}
