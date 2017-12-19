package ct.dc.mobile.api.service;

import ct.dc.mobile.api.model.domain.app.AppLoginByDayDo;
import ct.dc.mobile.api.model.domain.app.AppLoginByPerDayDo;

import java.util.ArrayList;

/**
 * Created by B41-80 on 2017/1/5.
 */
public interface IMobileAppLoginService {
    /**
     * 获取app多日登录信息
     * @param appid
     * @param begin
     * @param end
     * @return
     */
    ArrayList<AppLoginByDayDo> appUsersByDay(long appid, int begin, int end);

    /**
     * 获取app单日登录信息
     * @param appid
     * @param date
     * @return
     */
    ArrayList<AppLoginByPerDayDo> appUsersByPerDay(long appid, int date);
}
