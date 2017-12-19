package ct.dc.mobile.api.dao.mobileapp.Interface;

import ct.dc.mobile.api.model.po.mobileapp.AppRegByDayPo;

import java.util.ArrayList;

/**
 * Created by B41-80 on 2017/1/11.
 */
public interface IRegByDayDAO {
    ArrayList<AppRegByDayPo> find(long app,int begin, int end);
    ArrayList<AppRegByDayPo> find(int begin,int end);
}
