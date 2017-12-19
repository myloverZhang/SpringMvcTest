package ct.dc.mobile.api.service.playtogether;

import ct.dc.mobile.api.dao.mobiletogether.interfaces.IHappyCoinCostByDayDao;
import ct.dc.mobile.api.domain.playtogether.AppHappyCoinCostByDayDomain;
import ct.dc.mobile.api.model.domain.happycoin.AppCostByDayDo;
import ct.dc.mobile.api.model.po.mobilehappycoin.AppCostByDayPo;
import ct.dc.mobile.api.service.IMobileHappyCoinService;

import java.util.ArrayList;

/**
 * Created by CTWLPC on 2017/5/11.
 */
public class MobileHappyCoinServiceImpl implements IMobileHappyCoinService{
    private AppHappyCoinCostByDayDomain appHappyCoinCostByDayDomain;

    public void setAppHappyCoinCostByDayDomain(AppHappyCoinCostByDayDomain appHappyCoinCostByDayDomain) {
        this.appHappyCoinCostByDayDomain = appHappyCoinCostByDayDomain;
    }

    @Override
    public ArrayList<AppCostByDayDo> listAppCostIfsByDay(long app, int beginDate, int endDate) {
        return appHappyCoinCostByDayDomain.listCostIfsByApp(app, beginDate, endDate);
    }
}
