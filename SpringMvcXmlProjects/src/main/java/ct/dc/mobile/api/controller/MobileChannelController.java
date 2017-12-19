package ct.dc.mobile.api.controller;

import ct.dc.mobile.api.model.dto.input.ChannelDaysDto;
import ct.dc.mobile.api.model.dto.input.ChannelTagDaysDto;
import ct.dc.mobile.api.model.dto.output.ResultDto;
import ct.dc.mobile.api.service.IMobileChannelBriefService;
import ct.dc.mobile.api.service.IMobileChannelLoginService;
import ct.dc.mobile.api.service.IMobileChannelRetainService;
import ct.dc.mobile.api.utils.date.DateUtils;
import io.swagger.annotations.ApiOperation;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import sun.invoke.util.VerifyAccess;

import java.util.ArrayList;

/**
 * Created by B41-80 on 2017/1/18.
 */
@ResponseBody
@RequestMapping(value = "/MobileChannel")
@Controller
public class MobileChannelController {
    private IMobileChannelBriefService iMobileChannelBriefService;
    private IMobileChannelRetainService iMobileChannelRetainService;
    private IMobileChannelLoginService iMobileChannelLoginService;

    public void setiMobileChannelBriefService(IMobileChannelBriefService iMobileChannelBriefService) {
        this.iMobileChannelBriefService = iMobileChannelBriefService;
    }

    public void setiMobileChannelRetainService(IMobileChannelRetainService iMobileChannelRetainService) {
        this.iMobileChannelRetainService = iMobileChannelRetainService;
    }

    public void setiMobileChannelLoginService(IMobileChannelLoginService iMobileChannelLoginService) {
        this.iMobileChannelLoginService = iMobileChannelLoginService;
    }

    /**
     * 渠道一级界面
     * @param params
     * @return
     */
    @RequestMapping(value = "/ChannelBriefInfoByDay",method = RequestMethod.POST)
    @ApiOperation(value = "渠道分析一级界面注册信息接口")
    @ResponseBody
    public ResultDto channelBriefInfoByDay(@RequestBody ChannelTagDaysDto params){
        if (!DateUtils.isDate(params.getBeginDate())||!DateUtils.isDate(params.getEndDate())){
            return new ResultDto(false,null,"日期格式错误");
        }
        if (params.getBeginDate()>params.getEndDate()){
            return new ResultDto(false,null,"开始时间不能大于结束时间");
        }
        if (params.getAppId()<=0){
            return new ResultDto(false,null,"应用id错误");
        }
        if (params.getChannelTag() == null){
            params.setChannelTag("");
        }
        return new ResultDto(true,iMobileChannelBriefService.briefInfoByDays(params.getBeginDate(),
                params.getEndDate(),params.getAppId(),params.getChannelTag()),"");
    }

    /**
     * 渠道相关注册信息接口
     * @return
     */
    @RequestMapping(value = "/ChannelRegDetailsByDay",method = RequestMethod.POST)
    @ResponseBody
    @ApiOperation(value = "渠道相关注册信息接口")
    public ResultDto channelRegDetailsByDay(@RequestBody ChannelDaysDto params){
        if (!DateUtils.isDate(params.getBeginDate())||!DateUtils.isDate(params.getEndDate())){
            return new ResultDto(false,null,"日期格式错误");
        }
        if (params.getBeginDate()>params.getEndDate()){
            return new ResultDto(false,null,"开始时间不能大于结束时间");
        }
        if (params.getAppId()<=0){
            return new ResultDto(false,null,"应用id错误");
        }
        return new ResultDto(true,iMobileChannelBriefService.regInfoByDays(params.getBeginDate(),
                params.getEndDate(),params.getAppId(),params.getChannelId()),"");
    }

    /**
     * 渠道信息多日登录
     * @return
     */
    @RequestMapping(value = "/ChannelLoginDetailsByDay",method = RequestMethod.POST)
    @ResponseBody
    @ApiOperation(value = "渠道相关多日登录接口")
    public ResultDto channelLoginDetailsByDay(@RequestBody ChannelDaysDto params){
        if (!DateUtils.isDate(params.getBeginDate())||!DateUtils.isDate(params.getEndDate())){
            return new ResultDto(false,null,"日期格式错误");
        }
        if (params.getBeginDate()>params.getEndDate()){
            return new ResultDto(false,null,"开始时间不能大于结束时间");
        }
        if (params.getAppId()<=0){
            return new ResultDto(false,null,"应用id错误");
        }
        return new ResultDto(true,iMobileChannelLoginService.loginInfoByDays(params.getBeginDate(),
                params.getEndDate(),params.getAppId(),params.getChannelId()),"");
    }
    @RequestMapping(value = "/ChannelRetainInfoByDay",method = RequestMethod.POST)
    @ResponseBody
    @ApiOperation(value = "渠道信息留存接口")
    public ResultDto channelRetainInfoByDay(@RequestBody ChannelDaysDto params){
        if (!DateUtils.isDate(params.getBeginDate())||!DateUtils.isDate(params.getEndDate())){
            return new ResultDto(false,null,"日期格式错误");
        }
        if (params.getBeginDate()>params.getEndDate()){
            return new ResultDto(false,null,"开始时间不能大于结束时间");
        }
        if (params.getAppId()<=0){
            return new ResultDto(false,null,"应用id错误");
        }
        return new ResultDto(true,iMobileChannelRetainService.retainInfoByDays(params.getBeginDate(),
                params.getEndDate(),params.getAppId(),params.getChannelId()),"");
    }
}
