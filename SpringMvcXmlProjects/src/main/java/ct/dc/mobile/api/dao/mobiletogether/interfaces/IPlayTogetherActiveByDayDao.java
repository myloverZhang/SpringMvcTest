package ct.dc.mobile.api.dao.mobiletogether.interfaces;

import ct.dc.mobile.api.model.po.mobileplaytogether.AppActiveByDayPo;

import java.util.ArrayList;

/**
 * Created by CTWLPC on 2017/5/11.
 */
public interface IPlayTogetherActiveByDayDao {
    ArrayList<AppActiveByDayPo> findByApp(long app,int beginDate,int endDate);
}
