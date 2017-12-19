package ct.dc.mobile.api.domain.reg;

import ct.dc.mobile.api.dao.mobileapp.Interface.IRegByDayDAO;
import ct.dc.mobile.api.domain.IAppRegDomain;
import ct.dc.mobile.api.domain.helper.AppDataUtils;
import ct.dc.mobile.api.model.domain.app.AppRegByDayDo;
import ct.dc.mobile.api.model.domain.app.AppRegByMonthDo;
import ct.dc.mobile.api.model.domain.report.ReportGameRegDo;
import ct.dc.mobile.api.model.po.mobileapp.AppRegByDayPo;

import java.util.*;

/**
 * Created by B41-80 on 2017/1/9.
 */
public class MobileAppRegDomain implements IAppRegDomain{
    private IRegByDayDAO iRegByDayDAO;//注册信息数据访问层

    public void setiRegByDayDAO(IRegByDayDAO iRegByDayDAO) {
        this.iRegByDayDAO = iRegByDayDAO;
    }

    /**
     * 获取多日的注册信息
     * @param app
     * @param begin
     * @param end
     * @return
     */
    public ArrayList<AppRegByDayDo> getRegUsersByDates(long app, int begin, int end) {
        ArrayList<AppRegByDayDo> results = new ArrayList<AppRegByDayDo>();
        for (AppRegByDayPo info: getRegInfoByDates(app,begin,end)){
            AppRegByDayDo result = new AppRegByDayDo();
            result.setDate(info.getDate());
            result.setUsers(info.getUsers());
            result.setHards(info.getHards());
            results.add(result);
        }
        return results;
    }

    /**
     * 获取多月的注册信息
     * @param app
     * @param begin
     * @param end
     * @return
     */
    public AppRegByMonthDo[] getRegUsersByMonth(long app, int begin, int end) {
        AppRegByMonthDo[] results = new AppRegByMonthDo[]{};
        HashMap<Integer,AppRegByMonthDo> mapResults = new HashMap<Integer,AppRegByMonthDo>();
        for (AppRegByDayPo info: iRegByDayDAO.find(app,begin*100+1,end*100+31)){
            int month = info.getDate()/100;
            if (!mapResults.containsKey(month)){
                mapResults.put(month,new AppRegByMonthDo(month,0,0));
            }
            AppRegByMonthDo value = mapResults.get(month);
            value.setUsers(value.getUsers()+info.getUsers());
            value.setHards(value.getHards()+info.getHards());
        }
        return mapResults.values().toArray(results);
    }


    /**
     * 报表游戏注册
     * @param begin
     * @param end
     * @return
     */
    @Override
    public ArrayList<ReportGameRegDo> getReportGameReg(int begin, int end) {
        ArrayList<ReportGameRegDo> results = new ArrayList<ReportGameRegDo>();
        HashMap<String,String> allApp = AppDataUtils.allApp();
        for (AppRegByDayPo info: iRegByDayDAO.find(begin,end)){
            ReportGameRegDo result = new ReportGameRegDo();
            result.setApp(info.getApp());
            result.setAppName(allApp.containsKey(String.valueOf(info.getApp()))?allApp.get(String.valueOf(info.getApp())):"");
            result.setUsers(info.getUsers());
            result.setDate(info.getDate());
            result.setHards(info.getHards());
            results.add(result);
        }
        return results;
    }

    /**
     * 根据日期查询
     * @param app
     * @param begin
     * @param end
     * @return
     */
    private ArrayList<AppRegByDayPo> getRegInfoByDates(long app, int begin, int end) {
        return iRegByDayDAO.find(app,begin,end);
    }
}
