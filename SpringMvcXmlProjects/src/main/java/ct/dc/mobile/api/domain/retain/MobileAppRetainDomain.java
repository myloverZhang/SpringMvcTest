package ct.dc.mobile.api.domain.retain;

import ct.dc.mobile.api.dao.mobileapp.Interface.IRetainByDayDAO;
import ct.dc.mobile.api.domain.IAppRetainDomain;
import ct.dc.mobile.api.domain.helper.AppDataUtils;
import ct.dc.mobile.api.enums.StatTypeEnum;
import ct.dc.mobile.api.model.domain.app.AppRetainByDaysDo;
import ct.dc.mobile.api.model.domain.report.ReportGameRetainDo;
import ct.dc.mobile.api.model.po.mobileapp.AppRetainByDayPo;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by B41-80 on 2017/1/9.
 */
public class MobileAppRetainDomain implements IAppRetainDomain{
    private IRetainByDayDAO iRetainByDayDAO;

    public void setiRetainByDayDAO(IRetainByDayDAO iRetainByDayDAO) {
        this.iRetainByDayDAO = iRetainByDayDAO;
    }

    @Override
    public ArrayList<AppRetainByDaysDo> getRetainResultsByDays(long app, int begin, int end) {
        ArrayList<AppRetainByDaysDo> results = new ArrayList<AppRetainByDaysDo>();
        for (AppRetainByDayPo info: iRetainByDayDAO.find(app,begin,end)){
            results.addAll(getRetainInfoFromPo(info));
        }
        return results;
    }

    @Override
    public ArrayList<ReportGameRetainDo> getReportRetain(int begin, int end) {
        ArrayList<ReportGameRetainDo> results = new ArrayList<ReportGameRetainDo>();
        HashMap<String,String> allApp = AppDataUtils.allApp();
        for (AppRetainByDayPo info: iRetainByDayDAO.find(begin,end)){
            ReportGameRetainDo result = new ReportGameRetainDo();
            result.setDate(info.getDate());
            result.setApp(info.getApp());
            result.setAppName(allApp.containsKey(String.valueOf(info.getApp()))?allApp.get(String.valueOf(info.getApp())):"");
            result.setHardsNew(info.getHardsNew());
            result.setHardsD1(info.getHardsD1());
            result.setHardsD3(info.getHardsD3());
            result.setHardsD7(info.getHardsD7());
            result.setHardsD14(info.getHardsD14());
            result.setHardsD30(info.getHardsD30());
            result.setUsersNew(info.getUsersNew());
            result.setUsersD1(info.getUsersD1());
            result.setUsersD3(info.getUsersD3());
            result.setUsersD7(info.getUsersD7());
            result.setUsersD14(info.getUsersD14());
            result.setUsersD30(info.getUsersD30());
            results.add(result);
        }
        return results;
    }

    /**
     * 处理po类型成需要的do类型
     * @param info
     * @return
     */
    private ArrayList<AppRetainByDaysDo> getRetainInfoFromPo(AppRetainByDayPo info) {
        ArrayList<AppRetainByDaysDo> results = new ArrayList<AppRetainByDaysDo>();
        AppRetainByDaysDo account = new AppRetainByDaysDo();
        AppRetainByDaysDo hard = new AppRetainByDaysDo();
        account.setDate(info.getDate());
        hard.setDate(info.getDate());
        account.setType(StatTypeEnum.ACCOUNT.getValue());
        account.setNewCount(info.getUsersNew());
        account.setUsers1Day(info.getUsersD1());
        account.setUsers3Day(info.getUsersD3());
        account.setUsers7Day(info.getUsersD7());
        account.setUsers14Day(info.getUsersD14());
        account.setUsers30Day(info.getUsersD30());
        hard.setType(StatTypeEnum.HARD.getValue());
        hard.setUsers1Day(info.getHardsD1());
        hard.setUsers3Day(info.getHardsD3());
        hard.setUsers7Day(info.getHardsD7());
        hard.setUsers14Day(info.getHardsD14());
        hard.setUsers30Day(info.getHardsD30());
        hard.setNewCount(info.getHardsNew());
        results.add(account);
        results.add(hard);
        return results;
    }


}
