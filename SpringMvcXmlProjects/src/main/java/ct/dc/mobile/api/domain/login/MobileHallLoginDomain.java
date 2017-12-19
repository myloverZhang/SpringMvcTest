package ct.dc.mobile.api.domain.login;

import ct.dc.mobile.api.dao.mobileHall.Interface.IHallLoginByDayDao;
import ct.dc.mobile.api.dao.mobileHall.Interface.IHallLoginByPerDayDao;
import ct.dc.mobile.api.enums.StatTypeEnum;
import ct.dc.mobile.api.model.domain.hall.HallLoginByDayDo;
import ct.dc.mobile.api.model.domain.hall.HallLoginByPerDayDo;
import ct.dc.mobile.api.model.po.mobilehall.HallLoginByDayPo;
import ct.dc.mobile.api.model.po.mobilehall.HallLoginPerDayPo;

import java.util.ArrayList;

/**
 * Created by B41-80 on 2017/1/13.
 */
public class MobileHallLoginDomain {
    private IHallLoginByDayDao iHallLoginByDayDao;
    private IHallLoginByPerDayDao iHallLoginByPerDayDao;

    public void setiHallLoginByDayDao(IHallLoginByDayDao iHallLoginByDayDao) {
        this.iHallLoginByDayDao = iHallLoginByDayDao;
    }

    public void setiHallLoginByPerDayDao(IHallLoginByPerDayDao iHallLoginByPerDayDao) {
        this.iHallLoginByPerDayDao = iHallLoginByPerDayDao;
    }

    /**
     * 大厅多日登录
     * @param begin
     * @param end
     * @param hallId
     * @return
     */
    public ArrayList<HallLoginByDayDo> hallLoginUsersByDay(int begin,int end,int hallId){
        ArrayList<HallLoginByDayDo> results = new ArrayList<HallLoginByDayDo>();
        for (HallLoginByDayPo info:iHallLoginByDayDao.find(begin,end,hallId)){
            results.addAll(getLoginByPo(info));
        }
        return results;
    }

    /**
     * 大厅单日登录
     * @param date
     * @param hallId
     * @return
     */
    public ArrayList<HallLoginByPerDayDo> hallLoginUserPerDay(int date,int hallId){
        ArrayList<HallLoginByPerDayDo> results = new ArrayList<HallLoginByPerDayDo>();
        for (HallLoginPerDayPo info:iHallLoginByPerDayDao.find(date,hallId)){
            HallLoginByPerDayDo result = new HallLoginByPerDayDo();
            result.setUsers(info.getUsers());
            result.setHards(info.getHards());
            result.setTrange(info.getTrange());
            result.setTimes(info.getTimes());
            results.add(result);
        }
        return results;
    }
    /**
     * 转换出需要的do类
     *
     * @param info
     * @return
     */
    private ArrayList<HallLoginByDayDo> getLoginByPo(HallLoginByDayPo info) {
        ArrayList<HallLoginByDayDo> results = new ArrayList<HallLoginByDayDo>();
        HallLoginByDayDo hard = new HallLoginByDayDo();
        HallLoginByDayDo account = new HallLoginByDayDo();
        hard.setType(StatTypeEnum.HARD.getValue());
        hard.setDate(info.getDate());
        hard.setTimes(info.getTimes());
        hard.setUsers1D1(info.getHards1D1());
        hard.setUsers3D1(info.getHards3D1());
        hard.setUsers7D1(info.getHards7D1());
        hard.setUsers14D1(info.getHards14D1());
        hard.setUsers30D1(info.getHards30D1());
        account.setType(StatTypeEnum.ACCOUNT.getValue());
        account.setDate(info.getDate());
        account.setTimes(info.getTimes());
        account.setUsers1D1(info.getUsers1D1());
        account.setUsers3D1(info.getUsers3D1());
        account.setUsers7D1(info.getUsers7D1());
        account.setUsers14D1(info.getUsers14D1());
        account.setUsers30D1(info.getUsers30D1());
        results.add(account);
        results.add(hard);
        return results;
    }
}
