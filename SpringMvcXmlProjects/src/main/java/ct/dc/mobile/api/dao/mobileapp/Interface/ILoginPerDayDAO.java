package ct.dc.mobile.api.dao.mobileapp.Interface;

import ct.dc.mobile.api.model.po.mobileapp.AppLoginByPerDayPo;

import java.util.ArrayList;

/**
 * Created by B41-80 on 2017/1/11.
 */
public interface ILoginPerDayDAO {
    ArrayList<AppLoginByPerDayPo> find(long appid, int date);
}
