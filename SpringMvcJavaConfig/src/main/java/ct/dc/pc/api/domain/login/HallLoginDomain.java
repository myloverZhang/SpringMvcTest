package ct.dc.pc.api.domain.login;

import ct.dc.pc.api.dao.hall.interfaces.IHallLoginByDayDao;
import ct.dc.pc.api.dao.hall.interfaces.IHallLoginPerDayDao;
import ct.dc.pc.api.dao.halllogin.interfaces.IHallLoginDetailDao;
import ct.dc.pc.api.enums.StatTypeEnum;
import ct.dc.pc.api.model.domain.hall.HallLoginByDayDo;
import ct.dc.pc.api.model.domain.hall.HallLoginPerDayDo;
import ct.dc.pc.api.model.domain.hall.HallLoginUidTimesDo;
import ct.dc.pc.api.model.po.hall.HallLoginByDayPo;
import ct.dc.pc.api.model.po.hall.HallLoginPerDayPo;
import ct.dc.pc.api.model.po.hall.HallLoginUidTimesPo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;

/**
 * Created by B41-80 on 2017/4/6.
 */
@Component
public class HallLoginDomain {
    @Autowired
    private IHallLoginByDayDao iHallLoginByDayDao;
    @Autowired
    private IHallLoginPerDayDao iHallLoginPerDayDao;
    @Autowired
    private IHallLoginDetailDao iHallLoginDetailDao;

    /**
     * 大厅多日登录信息
     * @param group
     * @param beginDate
     * @param endDate
     * @return
     */
    public ArrayList<HallLoginByDayDo> listHallLoginByDayInfo(int group,int beginDate,int endDate){
        ArrayList<HallLoginByDayDo> results = new ArrayList<HallLoginByDayDo>();
        for (HallLoginByDayPo info:iHallLoginByDayDao.findByGroup(group, beginDate, endDate)){
            HallLoginByDayDo account = new HallLoginByDayDo();
            account.setDate(info.getDate());
            account.setTimes(info.getTimes());
            account.setType(StatTypeEnum.ACCOUNT.getValue());
            account.setUsers1D1(info.getUsers1D1());
            account.setUsers3D1(info.getUsers3D1());
            account.setUsers7D1(info.getUsers7D1());
            account.setUsers14D1(info.getUsers14D1());
            account.setUsers30D1(info.getUsers30D1());

            HallLoginByDayDo hard = new HallLoginByDayDo();
            hard.setDate(info.getDate());
            hard.setTimes(info.getTimes());
            hard.setType(StatTypeEnum.HARD.getValue());
            hard.setUsers1D1(info.getHards1D1());
            hard.setUsers3D1(info.getHards3D1());
            hard.setUsers7D1(info.getHards7D1());
            hard.setUsers14D1(info.getHards14D1());
            hard.setUsers30D1(info.getHards30D1());

            results.add(account);
            results.add(hard);
        }
        return results;
    }

    /**
     * 大厅单日登录信息
     * @param group
     * @param date
     * @return
     */
    public ArrayList<HallLoginPerDayDo> listHallLoginPerDayInfo(int group,int date){
        ArrayList<HallLoginPerDayDo> results = new ArrayList<HallLoginPerDayDo>();
        for (HallLoginPerDayPo info:iHallLoginPerDayDao.findByGroup(group,date)){
            HallLoginPerDayDo result = new HallLoginPerDayDo();
            result.setTrange(info.getTrange());
            result.setUsers(info.getUsers());
            result.setHards(info.getHards());
            result.setTimes(info.getTimes());
            results.add(result);
        }
        return results;
    }

    /**
     * 获取指定大厅达到指定最少次数的用户ID
     * @param group
     * @param date
     * @param mingTimes
     * @return
     */
    public ArrayList<HallLoginUidTimesDo> listHallLoginTimes(int group,int date,int mingTimes){
        ArrayList<HallLoginUidTimesDo> results= new ArrayList<HallLoginUidTimesDo>();
        for (HallLoginUidTimesPo info:iHallLoginDetailDao.listLoginTimesInfo(date, group)){
            if (info.getTimes()>mingTimes){
                HallLoginUidTimesDo result = new HallLoginUidTimesDo();
                result.setTimes(info.getTimes());
                result.setUid(info.getUid());
                results.add(result);
            }
        }
        return results;
    }
}
