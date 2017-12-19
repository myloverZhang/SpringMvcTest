package ct.dc.mobile.api.domain.playtogether;

import ct.dc.mobile.api.dao.mobiletogether.interfaces.IHappyCoinCostByDayDao;
import ct.dc.mobile.api.model.domain.happycoin.AppCostByDayDo;
import ct.dc.mobile.api.model.po.mobilehappycoin.AppCostByDayPo;

import java.util.ArrayList;

/**
 * Created by CTWLPC on 2017/5/11.
 */
public class AppHappyCoinCostByDayDomain {
    private IHappyCoinCostByDayDao iHappyCoinCostByDayDao;

    public void setiHappyCoinCostByDayDao(IHappyCoinCostByDayDao iHappyCoinCostByDayDao) {
        this.iHappyCoinCostByDayDao = iHappyCoinCostByDayDao;
    }
    public ArrayList<AppCostByDayDo> listCostIfsByApp(long app,int beginDate,int endDate){
        ArrayList<AppCostByDayDo> results = new ArrayList<>();
        for (AppCostByDayPo info:iHappyCoinCostByDayDao.findByApp(app, beginDate, endDate)){
            AppCostByDayDo result = new AppCostByDayDo();
            result.setCost(info.getCost()/10.0);
            result.setDate(info.getDate());
            result.setNum(info.getNum());
            result.setTimes(info.getTimes());
            results.add(result);
        }
        return results;
    }
}
