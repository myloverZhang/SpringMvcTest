import ct.dc.mobile.api.domain.online.MobileHallOnlineDomain;
import ct.dc.mobile.api.model.domain.hall.HallOnlineByPerDayDo;

import java.util.ArrayList;

/**
 * Created by B41-80 on 2017/1/16.
 */
public class HallOnlineTest {
    public static void main(String[] args) {
        MobileHallOnlineDomain mobileHallOnlineDomain = new MobileHallOnlineDomain();
        ArrayList<HallOnlineByPerDayDo> results = mobileHallOnlineDomain.getPerDayByWebService(20140310,1);
    }
}

