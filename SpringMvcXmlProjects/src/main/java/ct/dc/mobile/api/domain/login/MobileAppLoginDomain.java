package ct.dc.mobile.api.domain.login;

import ct.dc.mobile.api.dao.mobileapp.Interface.ILoginByDayDAO;
import ct.dc.mobile.api.dao.mobileapp.Interface.ILoginPerDayDAO;
import ct.dc.mobile.api.domain.IAppLoginDomain;
import ct.dc.mobile.api.domain.helper.AppDataUtils;
import ct.dc.mobile.api.enums.StatTypeEnum;
import ct.dc.mobile.api.model.domain.app.AppLoginByDayDo;
import ct.dc.mobile.api.model.domain.app.AppLoginByPerDayDo;
import ct.dc.mobile.api.model.domain.report.ReportGameLoginDo;
import ct.dc.mobile.api.model.po.mobileapp.AppLoginByDayPo;
import ct.dc.mobile.api.model.po.mobileapp.AppLoginByPerDayPo;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by B41-80 on 2017/1/5.
 */
public class MobileAppLoginDomain implements IAppLoginDomain {
    private ILoginByDayDAO iLoginByDayDAO;
    private ILoginPerDayDAO iLoginPerDayDAO;

    public void setiLoginByDayDAO(ILoginByDayDAO iLoginByDayDAO) {
        this.iLoginByDayDAO = iLoginByDayDAO;
    }

    public void setiLoginPerDayDAO(ILoginPerDayDAO iLoginPerDayDAO) {
        this.iLoginPerDayDAO = iLoginPerDayDAO;
    }

    /**
     * 获取多日登录信息
     * @param appid
     * @param begin
     * @param end
     * @return
     */
    public ArrayList<AppLoginByDayDo> getLoginUserByDay(long appid, int begin, int end) {
        ArrayList<AppLoginByDayPo> infos = iLoginByDayDAO.findByDate(appid, begin, end);
        ArrayList<AppLoginByDayDo> results = new ArrayList<AppLoginByDayDo>();
        for (AppLoginByDayPo info : infos) {
            results.addAll(getLoginByPo(info));
        }
        return results;
    }

    /**
     * 转换出需要的do类
     *
     * @param info
     * @return
     */
    private ArrayList<AppLoginByDayDo> getLoginByPo(AppLoginByDayPo info) {
        ArrayList<AppLoginByDayDo> results = new ArrayList<AppLoginByDayDo>();
        AppLoginByDayDo hard = new AppLoginByDayDo();
        AppLoginByDayDo account = new AppLoginByDayDo();
        hard.setType(StatTypeEnum.HARD.getValue());
        hard.setDate(info.getDate());
        hard.setTimes(info.getTimes());
        hard.setUsers1D1(info.getHards1d1());
        hard.setUsers3D1(info.getHards3d1());
        hard.setUsers7D1(info.getHards7d1());
        hard.setUsers14D1(info.getHards14d1());
        hard.setUsers30D1(info.getHards30d1());
        account.setType(StatTypeEnum.ACCOUNT.getValue());
        account.setDate(info.getDate());
        account.setTimes(info.getTimes());
        account.setUsers1D1(info.getUsers1d1());
        account.setUsers3D1(info.getUsers3d1());
        account.setUsers7D1(info.getUsers7d1());
        account.setUsers14D1(info.getUsers14d1());
        account.setUsers30D1(info.getUsers30d1());
        results.add(account);
        results.add(hard);
        return results;
    }

    /**
     * 单日登录信息
     *
     * @param appId
     * @param date
     * @return
     */
    public ArrayList<AppLoginByPerDayDo> getLoginUserByPerDay(long appId, int date) {
        ArrayList<AppLoginByPerDayDo> results = new ArrayList<AppLoginByPerDayDo>();
        for (AppLoginByPerDayPo info: iLoginPerDayDAO.find(appId,date)
             ) {
            AppLoginByPerDayDo result = getLoginUserByPerPo(info);
            results.add(result);
        }
        return results;
    }

    /**
     * 转换成需要的domain类
     * @param info
     * @return
     */
    private AppLoginByPerDayDo getLoginUserByPerPo(AppLoginByPerDayPo info) {
        AppLoginByPerDayDo result = new AppLoginByPerDayDo();
        result.setUsers(info.getUsers());
        result.setTimes(info.getTimes());
        result.setHards(info.getHards());
        result.setTrange(info.getTrange());
        return result;
    }

    /**
     * 报表游戏留存
     * @return
     */
    public ArrayList<ReportGameLoginDo> listReportLogin(int begin, int end){
        HashMap<String,String> allApp = AppDataUtils.allApp();
        ArrayList<ReportGameLoginDo> results = new ArrayList<ReportGameLoginDo>();
        for (AppLoginByDayPo info: iLoginByDayDAO.findByDate(begin,end)){
            ReportGameLoginDo result = new ReportGameLoginDo();
            result.setDate(info.getDate());
            result.setApp(info.getApp());
            result.setTimes(info.getTimes());
            result.setAppName(allApp.containsKey(String.valueOf(info.getApp()))?allApp.get(String.valueOf(info.getApp())):"");
            result.setUsers1D1(info.getUsers1d1());
            result.setUsers3D1(info.getUsers3d1());
            result.setUsers7D1(info.getUsers7d1());
            result.setUsers14D1(info.getUsers14d1());
            result.setUsers30D1(info.getUsers30d1());
            result.setHards1D1(info.getHards1d1());
            result.setHards3D1(info.getHards3d1());
            result.setHards7D1(info.getHards7d1());
            result.setHards14D1(info.getHards14d1());
            result.setHards30D1(info.getHards30d1());
            results.add(result);
        }
        return results;
    }


}
