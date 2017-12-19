package ct.dc.mobile.api.service;

import ct.dc.mobile.api.model.domain.playtogether.AppActiveByDayDo;
import ct.dc.mobile.api.model.domain.playtogether.AppActiveRetainByDayDo;

import java.util.ArrayList;

/**
 * Created by CTWLPC on 2017/5/11.
 */
public interface IMobilePlayTogetherActiveService {
    /**
     * 游戏多日活跃
     * @param app
     * @param beginDate
     * @param endDate
     * @return
     */
    ArrayList<AppActiveByDayDo> listAppActiveIfsByDay(long app,int beginDate,int endDate);

    /**
     * 游戏活跃多日留存
     * @param app
     * @param beginDate
     * @param endDate
     * @return
     */
    ArrayList<AppActiveRetainByDayDo> listAppActiveRetainByDayIfs(long app,int beginDate,int endDate);
}
