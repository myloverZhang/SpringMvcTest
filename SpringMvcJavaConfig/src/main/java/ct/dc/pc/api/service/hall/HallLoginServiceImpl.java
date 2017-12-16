package ct.dc.pc.api.service.hall;

import ct.dc.pc.api.domain.login.HallLoginDomain;
import ct.dc.pc.api.model.domain.hall.HallLoginByDayDo;
import ct.dc.pc.api.model.domain.hall.HallLoginPerDayDo;
import ct.dc.pc.api.model.domain.hall.HallLoginUidTimesDo;
import ct.dc.pc.api.service.hall.interfaces.IHallLoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

/**
 * Created by B41-80 on 2017/4/6.
 */
@Service
public class HallLoginServiceImpl implements IHallLoginService{
    @Autowired
    private HallLoginDomain hallLoginDomain;

    /**
     * 大厅多日登录信息
     *
     * @param group
     * @param beginDate
     * @param endDate
     * @return
     */
    @Override
    public ArrayList<HallLoginByDayDo> listHallLoginByDayInfo(int group, int beginDate, int endDate) {
        return hallLoginDomain.listHallLoginByDayInfo(group, beginDate, endDate);
    }

    /**
     * 大厅单日登录信息
     *
     * @param group
     * @param date
     * @return
     */
    @Override
    public ArrayList<HallLoginPerDayDo> listHallLoginPerDayInfo(int group, int date) {
        return hallLoginDomain.listHallLoginPerDayInfo(group,date);
    }

    /**
     * 用户登录次数
     *
     * @param group
     * @param date
     * @param minTimes
     * @return
     */
    @Override
    public ArrayList<HallLoginUidTimesDo> listHallLoginUidTimesInfo(int group, int date, int minTimes) {
        return hallLoginDomain.listHallLoginTimes(group, date, minTimes);
    }
}
