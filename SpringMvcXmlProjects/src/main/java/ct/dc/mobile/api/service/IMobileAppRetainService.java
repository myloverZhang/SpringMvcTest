package ct.dc.mobile.api.service;

import ct.dc.mobile.api.model.domain.app.AppRetainByDaysDo;

import java.util.ArrayList;

/**
 * Created by B41-80 on 2017/1/9.
 */
public interface IMobileAppRetainService {
    ArrayList<AppRetainByDaysDo> retainInfoByDays(long app, int begin, int end);
}
