package ct.dc.mobile.api.service.areaapp;

import ct.dc.mobile.api.domain.areaapp.MobileAreaAppDomain;
import ct.dc.mobile.api.model.domain.areaApp.AreaAppLoginByDayDo;
import ct.dc.mobile.api.model.domain.areaApp.AreaAppLoginDetailsByDayDo;
import ct.dc.mobile.api.service.IMobileAreaAppLoginService;

import java.util.ArrayList;

/**
 * Created by B41-80 on 2017/1/12.
 */
public class AreaAppLoginServiceImpl implements IMobileAreaAppLoginService{

    private MobileAreaAppDomain mobileAreaAppDomain;

    public void setMobileAreaAppDomain(MobileAreaAppDomain mobileAreaAppDomain) {
        this.mobileAreaAppDomain = mobileAreaAppDomain;
    }

    /**
     * 二合一级界面
     * @param areaId
     * @param begin
     * @param end
     * @return
     */
    @Override
    public ArrayList<AreaAppLoginByDayDo> areaAppLoginByDay(String areaId, int begin, int end) {
        if (areaId.length()==0){
            return mobileAreaAppDomain.nationAreaAppLoginByDay(begin,end);
        }
        if (areaId.length()==2){
            return mobileAreaAppDomain.provinceAreaAppLoginByDay(areaId,begin,end);
        }
        if (areaId.length()==4){
            return mobileAreaAppDomain.cityAreaAppLoginByDay(areaId,begin,end);
        }
        if (areaId.length()==6){
            return mobileAreaAppDomain.districtAreaAppLoginByDay(areaId,begin,end);
        }
        return null;
    }

    /**
     * 二合二级界面
     * @param areaId
     * @param begin
     * @param end
     * @param app
     * @return
     */
    @Override
    public ArrayList<AreaAppLoginDetailsByDayDo> areaAppLoginDetailsByDay(String areaId, int begin, int end, long app) {
        if (areaId.length()==0){
            return mobileAreaAppDomain.nationAreaAppLoginDetailsByDay(begin,end,app);
        }
        if (areaId.length()==2){
            return mobileAreaAppDomain.provinceAreaAppLoginDetailsByDay(areaId,begin,end,app);
        }
        if (areaId.length()==4){
            return mobileAreaAppDomain.cityAreaAppLoginDetailsByDay(areaId,begin,end,app);
        }
        if (areaId.length()==6){
            return mobileAreaAppDomain.districtAreaAppLoginDetailsByDay(areaId,begin,end,app);
        }
        return null;
    }
}
