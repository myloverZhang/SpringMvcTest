package ct.dc.mobile.api.service;

import ct.dc.mobile.api.model.domain.happycoin.AppCostByDayDo;

import java.util.ArrayList;

/**
 * Created by CTWLPC on 2017/5/11.
 */
public interface IMobileHappyCoinService {
    ArrayList<AppCostByDayDo> listAppCostIfsByDay(long app,int beginDate,int endDate);
}
