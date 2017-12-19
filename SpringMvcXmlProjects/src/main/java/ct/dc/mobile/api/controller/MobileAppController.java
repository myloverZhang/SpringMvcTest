package ct.dc.mobile.api.controller;

import ct.dc.mobile.api.model.dto.input.*;
import ct.dc.mobile.api.model.dto.output.ResultDto;
import ct.dc.mobile.api.service.IMobileAppAreaLoginService;
import ct.dc.mobile.api.service.IMobileAppLoginService;
import ct.dc.mobile.api.service.IMobileAppRegService;
import ct.dc.mobile.api.service.IMobileAppRetainService;
import ct.dc.mobile.api.utils.date.DateUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Date;

/**
 * 移动应用相关接口控制器
 * Created by B41-80 on 2017/1/5.
 */
@Controller
@ResponseBody
@RequestMapping(value = "/MobileApp")
public class MobileAppController {
    private IMobileAppLoginService appLoginService;
    private IMobileAppRegService appRegService;
    private IMobileAppRetainService appRetainService;
    private IMobileAppAreaLoginService appAreaLoginService;

    public void setAppLoginService(IMobileAppLoginService appLoginService) {
        this.appLoginService = appLoginService;
    }

    public void setAppRegService(IMobileAppRegService appRegService) {
        this.appRegService = appRegService;
    }

    public void setAppRetainService(IMobileAppRetainService appRetainService) {
        this.appRetainService = appRetainService;
    }

    public void setAppAreaLoginService(IMobileAppAreaLoginService appAreaLoginService) {
        this.appAreaLoginService = appAreaLoginService;
    }

    /**
     * 通过日期获取注册信息
     *
     * @param params
     * @return
     */
    @RequestMapping(value = "/RegUsersByDay", method = RequestMethod.POST)
    @ResponseBody
    public ResultDto regUsersByDay(@RequestBody AppDaysDto params) {
        return new ResultDto(true, appRegService.regInfoByDays(params.getAppId(), params.getBeginDate(), params.getEndDate()), "");
    }

    /**
     * 通过月份获取注册信息(未补零)
     *
     * @param params
     * @return
     */
    @RequestMapping(value = "/RegUsersByMonth", method = RequestMethod.POST)
    @ResponseBody
    public ResultDto regUsersByMonth(@RequestBody AppMonthsDto params) {
        return new ResultDto(true, appRegService.regInfoByMonth(params.getAppId(), params.getBeginMonth(), params.getEndMonth()), "");
    }

    /**
     * 获取app多日登录的信息
     *
     * @param params
     * @return
     */
    @RequestMapping(value = "/LoginUsersByDay", method = RequestMethod.POST)
    @ResponseBody
    public ResultDto loginUsersByDay(@RequestBody AppDaysDto params) {
        if (params.getAppId() <= 0) {
            return new ResultDto(false, null, "appid错误");
        }
        return new ResultDto(true, appLoginService.appUsersByDay(params.getAppId(), params.getBeginDate(), params.getEndDate()), "");
    }

    /**
     * 游戏单日登录
     *
     * @return
     */
    @RequestMapping(value = "/LoginUsersPerDay", method = RequestMethod.POST)
    @ResponseBody
    public ResultDto loginUsersPerDay(@RequestBody AppDayDto params) {
        if (params.getAppId() <= 0) {
            return new ResultDto(false, null, "appId错误");
        }
        return new ResultDto(true, appLoginService.appUsersByPerDay(params.getAppId(), params.getDate()), "");
    }

    /**
     * 留存
     *
     * @param params
     * @return
     */
    @RequestMapping(value = "/RetainByDay", method = RequestMethod.POST)
    @ResponseBody
    public ResultDto retainByDay(@RequestBody AppDaysDto params) {
        return new ResultDto(true, appRetainService.retainInfoByDays(params.getAppId(), params.getBeginDate(), params.getEndDate()), "");
    }

    /**
     * 二合一级界面接口
     *
     * @param params
     * @return
     */
    @RequestMapping(value = "/GameAreaLoginByDays",method = RequestMethod.POST)
    @ResponseBody
    public ResultDto gameAreaLoginByDays(@RequestBody AppAreaDto params) {
        if (!DateUtils.isDate(params.getBeginDate())||!DateUtils.isDate(params.getEndDate())){
            return new ResultDto(false,null,"日期格式错误");
        }
        if (DateUtils.addDay(DateUtils.DateToInt(new Date()),-30)>params.getBeginDate()){
            return new ResultDto(false,null,"日期范围错误");
        }
        if (params.getBeginDate()>params.getEndDate()){
            return new ResultDto(false,null,"开始时间不能大于结束时间");
        }
        int yesToday = DateUtils.addDay(DateUtils.DateToInt(new Date()),-1);
        if (params.getAppId()<=0){
            return new ResultDto(false,null,"appId错误");
        }
        if (params.getEndDate()>yesToday){
            params.setEndDate(yesToday);
        }
        return new ResultDto(true,appAreaLoginService.appAreaLoginByDays(params.getBeginDate(),params.getEndDate(),params.getAppId()),"");
    }

    /**
     *
     * @return
     */
    @RequestMapping(value = "/GameAreaLoginDetailsByDays",method = RequestMethod.POST)
    @ResponseBody
    public ResultDto gameAreaLoginDetailsByDays(@RequestBody AppAreaDetailDto params){
        if (params.getAreaId().length()!=4){
            return new ResultDto(false,null,"地区信息错误");
        }
        if (DateUtils.addDay(DateUtils.DateToInt(new Date()),-30)>params.getBeginDate()){
            return new ResultDto(false,null,"日期范围错误");
        }
        if (params.getBeginDate()>params.getEndDate()){
            return new ResultDto(false,null,"开始时间不能大于结束时间");
        }
        if (params.getAppId()< 0){
            return new ResultDto(false,null,"app信息错误");
        }
        int yesToday = DateUtils.addDay(DateUtils.DateToInt(new Date()),-1);
        if (params.getEndDate()>yesToday){
            params.setEndDate(yesToday);
        }
        return new ResultDto(true,appAreaLoginService.appAreaLoginDetailsByDays(params.getBeginDate(),params.getEndDate(),params.getAreaId(),params.getAppId()),"");
    }
}
