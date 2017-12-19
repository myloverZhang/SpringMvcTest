package ct.dc.mobile.api.service.reg;

import ct.dc.mobile.api.domain.reg.MobileAreaRegDomain;
import ct.dc.mobile.api.model.domain.area.AreaRegDayDo;
import ct.dc.mobile.api.model.domain.area.AreaRegMonthDo;
import ct.dc.mobile.api.service.IMobileAreaRegService;

import java.util.ArrayList;

/**
 * Created by B41-80 on 2017/1/12.
 */
public class AreaRegServiceImpl implements IMobileAreaRegService{
    private MobileAreaRegDomain mobileAreaRegDomain;

    public void setMobileAreaRegDomain(MobileAreaRegDomain mobileAreaRegDomain) {
        this.mobileAreaRegDomain = mobileAreaRegDomain;
    }

    @Override
    public ArrayList<AreaRegDayDo> regInfoByDay(int begin, int end, String areaId) {
        if (areaId.length()==0){
            return mobileAreaRegDomain.nationRegUsersByDay(begin,end);
        }
        if (areaId.length()==2){
            return mobileAreaRegDomain.provinceRegUsersByDay(begin,end,areaId);
        }
        if (areaId.length()==4){
            return mobileAreaRegDomain.cityRegUsersByDay(begin,end,areaId);
        }
        if (areaId.length()==6){
            return mobileAreaRegDomain.districtRegUsersByDay(begin,end,areaId);
        }
        return null;
    }

    @Override
    public AreaRegMonthDo[] regInfoByMonth(int begin, int end, String areaId) {
        if (areaId.length()==0){
            return mobileAreaRegDomain.nationRegUsersByMonth(begin,end);
        }
        if (areaId.length()==2){
            return mobileAreaRegDomain.provinceRegUsersByMonth(begin,end,areaId);
        }
        if (areaId.length()==4){
            return mobileAreaRegDomain.cityRegUsersByMonth(begin,end,areaId);
        }
        if (areaId.length()==6){
            return mobileAreaRegDomain.districtRegUsersByMonth(begin,end,areaId);
        }
        return new AreaRegMonthDo[0];
    }
}
