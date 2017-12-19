package ct.dc.mobile.api.service;

import ct.dc.mobile.api.model.domain.areaApp.AppAreaLoginByDayDo;
import ct.dc.mobile.api.model.domain.areaApp.AppAreaLoginDetailsByDayDo;

import java.util.ArrayList;

/**
 * Created by B41-80 on 2017/1/11.
 */
public interface IMobileAppAreaLoginService {
    /**
     * 获取应用地区二合的一级界面数据
     * @param begin
     * @param end
     * @param app
     * @return
     */
    ArrayList<AppAreaLoginByDayDo> appAreaLoginByDays(int begin, int end, long app);

    /**
     * 获得应用地区二合的二级界面数据
     * @param begin
     * @param end
     * @param areaId
     * @param app
     * @return
     */
    ArrayList<AppAreaLoginDetailsByDayDo> appAreaLoginDetailsByDays(int begin, int end, String areaId, long app);
}
