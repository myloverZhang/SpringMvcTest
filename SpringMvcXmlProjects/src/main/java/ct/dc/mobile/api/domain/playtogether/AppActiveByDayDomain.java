package ct.dc.mobile.api.domain.playtogether;

import ct.dc.mobile.api.dao.mobiletogether.interfaces.IPlayTogetherActiveByDayDao;
import ct.dc.mobile.api.dao.mobiletogether.interfaces.IPlayTogetherActiveRetainByDay;
import ct.dc.mobile.api.enums.StatTypeEnum;
import ct.dc.mobile.api.model.domain.playtogether.AppActiveByDayDo;
import ct.dc.mobile.api.model.domain.playtogether.AppActiveRetainByDayDo;
import ct.dc.mobile.api.model.po.mobileplaytogether.AppActiveByDayPo;
import ct.dc.mobile.api.model.po.mobileplaytogether.AppActiveRetainByDayPo;

import java.util.ArrayList;

/**
 * Created by CTWLPC on 2017/5/11.
 */
public class AppActiveByDayDomain{
    private IPlayTogetherActiveByDayDao iPlayTogetherActiveByDayDao;

    private IPlayTogetherActiveRetainByDay iPlayTogetherActiveRetainByDay;

    public void setiPlayTogetherActiveByDayDao(IPlayTogetherActiveByDayDao iPlayTogetherActiveByDayDao) {
        this.iPlayTogetherActiveByDayDao = iPlayTogetherActiveByDayDao;
    }

    public void setiPlayTogetherActiveRetainByDay(IPlayTogetherActiveRetainByDay iPlayTogetherActiveRetainByDay) {
        this.iPlayTogetherActiveRetainByDay = iPlayTogetherActiveRetainByDay;
    }

    /**
     * 游戏多日活跃
     * @param app
     * @param beginDate
     * @param endDate
     * @return
     */
    public ArrayList<AppActiveByDayDo> listActiveIfsByApp(long app, int beginDate, int endDate){
        ArrayList<AppActiveByDayDo> results = new ArrayList<>();
        for (AppActiveByDayPo info:iPlayTogetherActiveByDayDao.findByApp(app, beginDate, endDate)){
            AppActiveByDayDo account = new AppActiveByDayDo();
            account.setActive(info.getAccount());
            account.setTimes(info.getTimes());
            account.setDate(info.getDate());
            account.setType(StatTypeEnum.ACCOUNT.getValue());
            results.add(account);

            AppActiveByDayDo hard = new AppActiveByDayDo();
            hard.setType(StatTypeEnum.HARD.getValue());
            hard.setDate(info.getDate());
            hard.setTimes(info.getTimes());
            hard.setActive(info.getHard());
            results.add(hard);
        }
        return results;
    }

    /**
     * 游戏活跃多日留存
     * @param app
     * @param beginDate
     * @param endDate
     * @return
     */
    public ArrayList<AppActiveRetainByDayDo> listActiveRetainByDay(long app,int beginDate,int endDate){
        ArrayList<AppActiveRetainByDayDo> results = new ArrayList<>();
        for (AppActiveRetainByDayPo info:iPlayTogetherActiveRetainByDay.listAppActiveByDayIfs(app, beginDate, endDate)){
            AppActiveRetainByDayDo account = new AppActiveRetainByDayDo();
            account.setDate(info.getDate());
            account.setType(StatTypeEnum.ACCOUNT.getValue());
            account.setNewCount(info.getUsersNew());
            account.setUsers1Day(info.getUsersD1());
            account.setUsers3Day(info.getUsersD3());
            account.setUsers7Day(info.getUsersD7());
            account.setUsers14Day(info.getUsersD14());
            account.setUsers30Day(info.getUsersD30());
            results.add(account);

            AppActiveRetainByDayDo hard = new AppActiveRetainByDayDo();
            hard.setDate(info.getDate());
            hard.setType(StatTypeEnum.HARD.getValue());
            hard.setNewCount(info.getHardsNew());
            hard.setUsers1Day(info.getHardsD1());
            hard.setUsers3Day(info.getHardsD3());
            hard.setUsers7Day(info.getHardsD7());
            hard.setUsers14Day(info.getHardsD14());
            hard.setUsers30Day(info.getHardsD30());
            results.add(hard);
        }
        return results;
    }
}
