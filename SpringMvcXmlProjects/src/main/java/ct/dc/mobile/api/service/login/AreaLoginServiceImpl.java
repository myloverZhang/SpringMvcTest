package ct.dc.mobile.api.service.login;

import ct.dc.mobile.api.domain.login.MobileAreaLoginDomain;
import ct.dc.mobile.api.model.domain.area.AreaLoginByDayDo;
import ct.dc.mobile.api.model.domain.area.AreaLoginByPerDayDo;
import ct.dc.mobile.api.service.IMobileAreaLoginService;

import java.util.ArrayList;

/**
 * Created by B41-80 on 2017/1/11.
 */
public class AreaLoginServiceImpl implements IMobileAreaLoginService{

    private MobileAreaLoginDomain mobileAreaLoginDomain;

    public void setMobileAreaLoginDomain(MobileAreaLoginDomain mobileAreaLoginDomain) {
        this.mobileAreaLoginDomain = mobileAreaLoginDomain;
    }

    @Override
    public ArrayList<AreaLoginByDayDo> loginUsersByDay(String areaId, int begin, int end) {
        if (areaId.length()==0){
            return mobileAreaLoginDomain.nationUsersByDay(begin,end);
        }
        if (areaId.length()==2){
            return mobileAreaLoginDomain.provinceUsersByDay(areaId,begin,end);
        }
        if (areaId.length()==4){
            return mobileAreaLoginDomain.cityUsersByDay(areaId,begin,end);
        }
        if (areaId.length()==6){
            return mobileAreaLoginDomain.districtUsersByDay(areaId,begin,end);
        }
        return null;
    }

    @Override
    public ArrayList<AreaLoginByPerDayDo> loginUsersByPerDay(String areaId, int date) {
        if (areaId.length()==0){
            return mobileAreaLoginDomain.nationUsersByPerDay(date);
        }
        if (areaId.length()==2){
            return mobileAreaLoginDomain.provinceUserByPerDay(areaId,date);
        }
        if (areaId.length()==4){
            return mobileAreaLoginDomain.cityUsersByPerDay(areaId,date);
        }
        if (areaId.length()==6){
            return mobileAreaLoginDomain.districtUsersByPerDay(areaId,date);
        }
        return null;
    }
}
