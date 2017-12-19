package ct.dc.mobile.api.controller;

import ct.dc.mobile.api.model.dto.input.HallDayDto;
import ct.dc.mobile.api.model.dto.input.HallDaysDto;
import ct.dc.mobile.api.model.dto.input.HallMonthsDto;
import ct.dc.mobile.api.model.dto.output.ResultDto;
import ct.dc.mobile.api.service.IMobileHallLoginService;
import ct.dc.mobile.api.service.IMobileHallOnlineService;
import ct.dc.mobile.api.service.IMobileHallRegService;
import ct.dc.mobile.api.utils.ResourceUtils;
import io.swagger.annotations.ApiOperation;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Arrays;
import java.util.List;

/**
 * 移动大厅接口控制器
 * Created by B41-80 on 2017/1/13.
 */
@Controller
@RequestMapping(value = "/MobileHall")
@ResponseBody
public class MobileHallController
{
    private List<Integer> group = Arrays.asList(ResourceUtils.GROUP_MOBILE);
    private IMobileHallOnlineService iMobileHallOnlineService;

    private IMobileHallLoginService iMobileHallLoginService;
    private IMobileHallRegService iMobileHallRegService;

    public void setiMobileHallLoginService(IMobileHallLoginService iMobileHallLoginService) {
        this.iMobileHallLoginService = iMobileHallLoginService;
    }

    public void setiMobileHallRegService(IMobileHallRegService iMobileHallRegService) {
        this.iMobileHallRegService = iMobileHallRegService;
    }

    public void setiMobileHallOnlineService(IMobileHallOnlineService iMobileHallOnlineService) {
        this.iMobileHallOnlineService = iMobileHallOnlineService;
    }

    /**
     * 大厅多日登录
     * @param params
     * @return
     */
    @RequestMapping(value = "/LoginUsersByDay",method = RequestMethod.POST)
    @ResponseBody
    @ApiOperation(value = "大厅多日登录")
    public ResultDto loginUsersByDay(@RequestBody HallDaysDto params){
        if (!group.contains(params.getHallId())){
            return new ResultDto(false,null,"当前大厅组号并非属于移动大厅范围");
        }
        return new ResultDto(true,iMobileHallLoginService.loginUsersByDay(params.getHallId(),params.getBeginDate(),params.getEndDate()),"");
    }

    /**
     * 大厅单日登录
     * @param params
     * @return
     */
    @RequestMapping(value = "/LoginUsersPerDay",method = RequestMethod.POST)
    @ResponseBody
    @ApiOperation(value = "大厅单日登录")
    public ResultDto loginUsersPerDay(@RequestBody HallDayDto params){
        if (!group.contains(params.getHallId())){
            return new ResultDto(false,null,"当前大厅组号并非属于移动大厅范围");
        }
        return new ResultDto(true,iMobileHallLoginService.loginUsersPerDay(params.getHallId(),params.getDate()),"");
    }

    /**
     * 大厅单日在线
     * @param params
     * @return
     */
    @RequestMapping(value = "/OnlineUsersPerDay",method = RequestMethod.POST)
    @ResponseBody
    @ApiOperation(value = "大厅单日在线")
    public ResultDto onlineUsersPerDay(@RequestBody HallDayDto params){
        return new ResultDto(true,iMobileHallOnlineService.onlineUsersPerDay(params.getDate(),params.getHallId()),"");
    }

    /**
     * 大厅多日在线
     * @param params
     * @return
     */
    @RequestMapping(value = "/OnlineUsersByDay",method = RequestMethod.POST)
    @ResponseBody
    @ApiOperation(value = "大厅多日在线")
    public ResultDto onlineUsersByDay(@RequestBody HallDaysDto params){
        if (!group.contains(params.getHallId())){
            return new ResultDto(false,null,"当前大厅组号并非属于移动大厅范围");
        }
        return new ResultDto(true,iMobileHallOnlineService.onlineUsersByDay(params.getBeginDate(),params.getEndDate(),params.getHallId()),"");
    }

    /**
     * 大厅多月在线
     * @param params
     * @return
     */
    @RequestMapping(value = "/OnlineStandardByMonth",method = RequestMethod.POST)
    @ResponseBody
    @ApiOperation(value = "大厅多月在线")
    public ResultDto onlineStandardByMonth(@RequestBody HallMonthsDto params){
        return new ResultDto(true,iMobileHallOnlineService.onlineUsersByMonth(params.getBeginMonth(),params.getEndMonth(),params.getHallId()),"");
    }

    /**
     * 大厅多日注册
     * @param params
     * @return
     */
    @RequestMapping(value = "/RegUsersByDay",method = RequestMethod.POST)
    @ResponseBody
    @ApiOperation(value = "大厅多日注册")
    public ResultDto regUsersByDay(@RequestBody HallDaysDto params){
        if (!group.contains(params.getHallId())){
            return new ResultDto(false,null,"当前大厅组号并非属于移动大厅范围");
        }
        return new ResultDto(true,iMobileHallRegService.regUsersByDay(params.getHallId(),params.getBeginDate(),params.getEndDate()),"");
    }

    /**
     * 大厅多月注册
     * @param params
     * @return
     */
    @RequestMapping(value = "/RegUsersByMonth",method = RequestMethod.POST)
    @ResponseBody
    @ApiOperation(value = "大厅多月注册")
    public ResultDto regUsersByMonth(@RequestBody HallMonthsDto params){
        if (!group.contains(params.getHallId())){
            return new ResultDto(false,null,"当前大厅组号并非属于移动大厅范围");
        }
        return new ResultDto(true,iMobileHallRegService.regUserByMonth(params.getHallId(),params.getBeginMonth(),params.getEndMonth()),"");
    }
}
