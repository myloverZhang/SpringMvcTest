package ct.dc.pc.api.service.hall.interfaces;

import ct.dc.pc.api.model.domain.hall.HallLoginByDayDo;
import ct.dc.pc.api.model.domain.hall.HallLoginPerDayDo;
import ct.dc.pc.api.model.domain.hall.HallLoginUidTimesDo;

import java.util.ArrayList;

/**
 * Created by B41-80 on 2017/4/6.
 */
public interface IHallLoginService {
    /**
     * 大厅多日登录信息
     * @param group
     * @param beginDate
     * @param endDate
     * @return
     */
    ArrayList<HallLoginByDayDo> listHallLoginByDayInfo(int group,int beginDate,int endDate);

    /**
     * 大厅单日登录信息
     * @param group
     * @param date
     * @return
     */
    ArrayList<HallLoginPerDayDo> listHallLoginPerDayInfo(int group,int date);

    /**
     * 用户登录次数
     * @param group
     * @param date
     * @param minTimes
     * @return
     */
    ArrayList<HallLoginUidTimesDo> listHallLoginUidTimesInfo(int group,int date,int minTimes);
}
