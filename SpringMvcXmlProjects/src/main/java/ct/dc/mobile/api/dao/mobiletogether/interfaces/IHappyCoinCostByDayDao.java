package ct.dc.mobile.api.dao.mobiletogether.interfaces;

import ct.dc.mobile.api.model.po.mobilehappycoin.AppCostByDayPo;

import java.util.ArrayList;

/**
 * Created by CTWLPC on 2017/5/11.
 */
public interface IHappyCoinCostByDayDao {
    ArrayList<AppCostByDayPo> findByApp(long app,int beginDate,int endDate);
}
