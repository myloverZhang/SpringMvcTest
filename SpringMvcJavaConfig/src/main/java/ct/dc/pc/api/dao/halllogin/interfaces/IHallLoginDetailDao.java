package ct.dc.pc.api.dao.halllogin.interfaces;

import ct.dc.pc.api.model.po.hall.HallLoginUidTimesPo;

import java.util.ArrayList;

/**
 * Created by B41-80 on 2017/4/6.
 */
public interface IHallLoginDetailDao {
    /**
     * 获取大厅的所有用户的登录次数
     * @param date
     * @param group
     * @return
     */
    ArrayList<HallLoginUidTimesPo> listLoginTimesInfo(int date,int group);
}
