package ct.dc.mobile.api.service.playtogether;

import ct.dc.mobile.api.domain.playtogether.AppActiveByDayDomain;
import ct.dc.mobile.api.model.domain.playtogether.AppActiveByDayDo;
import ct.dc.mobile.api.model.domain.playtogether.AppActiveRetainByDayDo;
import ct.dc.mobile.api.service.IMobilePlayTogetherActiveService;

import java.util.ArrayList;

/**
 * Created by CTWLPC on 2017/5/11.
 */
public class MobilePlayTogetherActiveServiceImpl implements IMobilePlayTogetherActiveService{

    private AppActiveByDayDomain appActiveByDayDomain;

    public void setAppActiveByDayDomain(AppActiveByDayDomain appActiveByDayDomain) {
        this.appActiveByDayDomain = appActiveByDayDomain;
    }

    @Override
    public ArrayList<AppActiveByDayDo> listAppActiveIfsByDay(long app, int beginDate, int endDate) {
        return appActiveByDayDomain.listActiveIfsByApp(app, beginDate, endDate);
    }

    /**
     * 游戏活跃多日留存
     *
     * @param app
     * @param beginDate
     * @param endDate
     * @return
     */
    @Override
    public ArrayList<AppActiveRetainByDayDo> listAppActiveRetainByDayIfs(long app, int beginDate, int endDate) {
        return appActiveByDayDomain.listActiveRetainByDay(app, beginDate, endDate);
    }
}
