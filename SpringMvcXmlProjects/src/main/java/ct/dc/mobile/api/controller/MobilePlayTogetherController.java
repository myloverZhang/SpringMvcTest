package ct.dc.mobile.api.controller;

import ct.dc.mobile.api.model.dto.input.AppDayDto;
import ct.dc.mobile.api.model.dto.input.AppDaysDto;
import ct.dc.mobile.api.model.dto.output.ResultDto;
import ct.dc.mobile.api.service.IMobileHappyCoinService;
import ct.dc.mobile.api.service.IMobilePlayTogetherActiveService;
import io.swagger.annotations.ApiOperation;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import sun.invoke.util.VerifyAccess;

/**
 * Created by CTWLPC on 2017/5/11.
 */
@Controller
@ResponseBody
@RequestMapping(value = "/playTogether")
public class MobilePlayTogetherController {
    private IMobilePlayTogetherActiveService iMobilePlayTogetherActiveService;
    private IMobileHappyCoinService iMobileHappyCoinService;

    public void setiMobilePlayTogetherActiveService(IMobilePlayTogetherActiveService iMobilePlayTogetherActiveService) {
        this.iMobilePlayTogetherActiveService = iMobilePlayTogetherActiveService;
    }

    public void setiMobileHappyCoinService(IMobileHappyCoinService iMobileHappyCoinService) {
        this.iMobileHappyCoinService = iMobileHappyCoinService;
    }
    @ResponseBody
    @RequestMapping(value = "/appActiveByDay",method = RequestMethod.POST)
    @ApiOperation(value = "游戏多日活跃-房卡")
    public ResultDto listAppActiveByDay(@RequestBody AppDaysDto params){
        if (params.getAppId() <= 0) {
            return new ResultDto(false, null, "appId错误");
        }
        return new ResultDto(
                true,
                iMobilePlayTogetherActiveService.listAppActiveIfsByDay(params.getAppId(),params.getBeginDate(),params.getEndDate()),
                ""
        );
    }

    @ResponseBody
    @RequestMapping(value = "/appCostByDay",method = RequestMethod.POST)
    @ApiOperation(value = "游戏多日消息-房卡")
    public ResultDto listAppCostByDay(@RequestBody AppDaysDto params){
        if (params.getAppId() <= 0) {
            return new ResultDto(false, null, "appId错误");
        }
        return new ResultDto(
                true,
                iMobileHappyCoinService.listAppCostIfsByDay(params.getAppId(),params.getBeginDate(),params.getEndDate()),
                ""
        );
    }
    @ResponseBody
    @RequestMapping(value = "/appRetainByDay",method = RequestMethod.POST)
    @ApiOperation(value = "游戏多日留存")
    public ResultDto listAppActiveRetainByDay(@RequestBody AppDaysDto params){
        if (params.getAppId() <= 0){
            return new ResultDto(false,null,"appId错误");
        }
        return new ResultDto(
                true,
                iMobilePlayTogetherActiveService.listAppActiveRetainByDayIfs(params.getAppId(),params.getBeginDate(),params.getEndDate()),
                ""
        );
    }
}
