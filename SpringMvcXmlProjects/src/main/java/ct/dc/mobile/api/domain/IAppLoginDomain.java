package ct.dc.mobile.api.domain;

import ct.dc.mobile.api.model.domain.app.AppLoginByDayDo;
import ct.dc.mobile.api.model.domain.app.AppLoginByPerDayDo;

import java.util.ArrayList;

/**
 * Created by B41-80 on 2017/1/5.
 */
public interface IAppLoginDomain{
    /**
     * 获取多日登录用户
     * @param appid
     * @param begin
     * @param end
     * @return
     */
    ArrayList<AppLoginByDayDo> getLoginUserByDay(long appid, int begin, int end);

    /**
     * 获取单日登录用户
     * @param appid
     * @param date
     * @return
     */
    ArrayList<AppLoginByPerDayDo> getLoginUserByPerDay(long appid, int date);
}
