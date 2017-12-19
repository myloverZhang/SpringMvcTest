package ct.dc.mobile.api.dao.mobiletogether.interfaces;

import ct.dc.mobile.api.model.po.mobileplaytogether.AppActiveRetainByDayPo;

import java.util.ArrayList;

/**
 * Created by CTWLPC on 2017/8/15.
 */
public interface IPlayTogetherActiveRetainByDay {
    /**
     * 获取多日游戏活跃数据
     * @param appId
     * @param beginDate
     * @param endDate
     * @return
     */
    ArrayList<AppActiveRetainByDayPo> listAppActiveByDayIfs(long appId,int beginDate,int endDate);
}
