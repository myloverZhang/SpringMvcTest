package ct.dc.mobile.api.dao.mobileapp.Interface;

import ct.dc.mobile.api.model.po.mobileapp.AppLoginByDayPo;

import java.util.ArrayList;

/**
 * Created by B41-80 on 2017/1/11.
 */
public interface ILoginByDayDAO {
    ArrayList<AppLoginByDayPo> findByDate(long appId, int begin, int end);
    ArrayList<AppLoginByDayPo> findByDate(int begin,int end);
}
