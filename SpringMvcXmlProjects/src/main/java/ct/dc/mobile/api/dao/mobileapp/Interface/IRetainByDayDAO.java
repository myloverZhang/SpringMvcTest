package ct.dc.mobile.api.dao.mobileapp.Interface;

import ct.dc.mobile.api.model.po.mobileapp.AppRetainByDayPo;

import java.util.ArrayList;

/**
 * Created by B41-80 on 2017/1/11.
 */
public interface IRetainByDayDAO {
    ArrayList<AppRetainByDayPo> find(long app, int begin, int end);
    ArrayList<AppRetainByDayPo> find(int begin,int end);
}
