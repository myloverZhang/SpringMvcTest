package ct.dc.pc.api.controller;

import ct.dc.liblogs.ICtDataLogger;
import ct.dc.liblogs.impl.CtDataLoggerImpl;
import ct.dc.liblogs.model.LogContent;
import ct.dc.pc.api.model.dto.input.*;
import ct.dc.pc.api.model.dto.output.ResultDto;
import ct.dc.pc.api.service.channel.interfaces.IHallChannelService;
import ct.dc.pc.api.service.hall.interfaces.IHallLoginService;
import ct.dc.pc.api.service.hall.interfaces.IHallOnlineService;
import ct.dc.pc.api.service.hall.interfaces.IHallRegService;
import ct.dc.pc.api.service.hall.interfaces.IHallRetainService;
import ct.dc.pc.api.util.ResourceClass;
import ct.dc.pc.api.util.date.DateUtils;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Arrays;
import java.util.List;

/**
 * Created by B41-80 on 2017/4/6.
 */
@Controller
@RequestMapping(value = "/Hall")
@ResponseBody
public class HallController {
    private final List<Integer> NOT_PC_GROUP = Arrays.asList(ResourceClass.GroupNotPc);
    private static ICtDataLogger logger = new CtDataLoggerImpl(ChannelTagByDaysDto.class);
    @Autowired
    private IHallLoginService iHallLoginService;
    @Autowired
    private IHallOnlineService iHallOnlineService;
    @Autowired
    private IHallRegService iHallRegService;
    @Autowired
    private IHallRetainService iHallRetainService;
    @Autowired
    private IHallChannelService iHallChannelService;

    @RequestMapping(value = "/LoginUsersByDay",method = RequestMethod.POST)
    @ResponseBody
    @ApiOperation(value = "根据日期获取大厅多日登录信息")
    public ResultDto loginUsersByDay(@RequestBody HallDaysDto params){
        if (NOT_PC_GROUP.contains(params.getHallId())){
            return new ResultDto(false,null,"当前大厅组号并非属于PC大厅范围");
        }
        return new ResultDto(
                true,
                iHallLoginService.listHallLoginByDayInfo(params.getHallId(),params.getBeginDate(),params.getEndDate()),
                ""
        );
    }

    @RequestMapping(value = "/LoginUsersPerDay",method = RequestMethod.POST)
    @ResponseBody
    @ApiOperation(value = "根据日期获取大厅单日登录信息")
    public ResultDto loginUsersPerDay(@RequestBody HallDayDto params){
        if (NOT_PC_GROUP.contains(params.getHallId())){
            return new ResultDto(false,null,"当前大厅组号并非属于PC大厅范围");
        }
        return new ResultDto(
                true,
                iHallLoginService.listHallLoginPerDayInfo(params.getHallId(),params.getDate()),
                ""
        );
    }

    @RequestMapping(value = "/UidsMoreThanMinLoginTimes",method = RequestMethod.POST)
    @ResponseBody
    @ApiOperation(value = " 获取指定大厅达到指定最少次数的用户ID")
    public ResultDto uidsMoreThanMinLoginTimes(@RequestBody HallDayTimesDto params){
        if (NOT_PC_GROUP.contains(params.getHallId())){
            return new ResultDto(false,null,"当前大厅组号并非属于PC大厅范围");
        }
        return new ResultDto(
                true,
                iHallLoginService.listHallLoginUidTimesInfo(params.getHallId(),params.getDate(),params.getMinTime()),
                ""
        );
    }

    @RequestMapping(value = "/OnlineUsersPerDay",method = RequestMethod.POST)
    @ApiOperation(value = "根据日期获取大厅单日在线信息")
    @ResponseBody
    public ResultDto onlineUsersPerDay(@RequestBody HallDayDto params){
        if (NOT_PC_GROUP.contains(params.getHallId())){
            return new ResultDto(false,null,"当前大厅组号并非属于PC大厅范围");
        }
        return new ResultDto(
                true,
                iHallOnlineService.listHallOnlinePerDayInfo(params.getHallId(),params.getDate()),
                ""
        );
    }

    @RequestMapping(value = "/OnlineUsersByDay",method = RequestMethod.POST)
    @ResponseBody
    @ApiOperation(value = "根据日期获取大厅多日在线信息")
    public ResultDto onlineUsersByDay(@RequestBody HallDaysDto params){
        if (NOT_PC_GROUP.contains(params.getHallId())){
            return new ResultDto(false,null,"当前大厅组号并非属于PC大厅范围");
        }
        return new ResultDto(
                true,
                iHallOnlineService.listHallOnlineByDayInfo(params.getHallId(),params.getBeginDate(),params.getEndDate()),
                ""
        );
    }

    @RequestMapping(value = "/OnlineStandardByMonth",method = RequestMethod.POST)
    @ResponseBody
    @ApiOperation(value = "根据日期获取大厅多月在线信息")
    public ResultDto onlineStandardByMonth(@RequestBody HallMonthsDto params){
        if (NOT_PC_GROUP.contains(params.getHallId())){
            return new ResultDto(false,null,"当前大厅组号并非属于PC大厅范围");
        }
        return new ResultDto(
                true,
                iHallOnlineService.listHallOnlineByMonthInfo(params.getHallId(),params.getBeginMonth(),params.getBeginMonth()),
                ""
        );
    }


    @RequestMapping(value = "/RegUsersByDay",method = RequestMethod.POST)
    @ResponseBody
    @ApiOperation(value = " 根据日期获取大厅多日注册信息")
    public ResultDto regUsersByDay(@RequestBody HallDaysDto params){
        if (NOT_PC_GROUP.contains(params.getHallId())){
            return new ResultDto(false,null,"当前大厅组号并非属于PC大厅范围");
        }
        return new ResultDto(
                true,
                iHallRegService.listHallRegByDayInfo(params.getHallId(),params.getBeginDate(),params.getEndDate()),
                ""
        );
    }

    @RequestMapping(value = "/RegUsersByMonth",method = RequestMethod.POST)
    @ResponseBody
    @ApiOperation(value = "根据日期获取大厅多月注册信息")
    public ResultDto regUsersByMonth(@RequestBody HallMonthsDto params){
        if (NOT_PC_GROUP.contains(params.getHallId())){
            return new ResultDto(false,null,"当前大厅组号并非属于PC大厅范围");
        }
        return new ResultDto(
                true,
                iHallRegService.listHallRegByMonthInfo(params.getHallId(),params.getBeginMonth(),params.getEndMonth()),
                ""
        );
    }

    @RequestMapping(value = "/RetainByDay",method = RequestMethod.POST)
    @ResponseBody
    @ApiOperation(value = "按日统计大厅留存率")
    public ResultDto retainByDay(@RequestBody HallRetainDaysDto params){
        if (NOT_PC_GROUP.contains(params.getHallId())){
            return new ResultDto(false,null,"当前大厅组号并非属于PC大厅范围");
        }

        logger.info("hallretaindaysdto" + params.toString());
        return new ResultDto(
                true,
                iHallRetainService.listHallRetainByDayInfo(params.getHallId(),params.getBeginDate(),params.getEndDate(),
                        params.getRetainType()),
                ""
        );
    }


    @ResponseBody
    @RequestMapping(value = "ChannelBriefInfoByDay",method = RequestMethod.POST)
    @ApiOperation(value = "大厅渠道概要信息")
    public ResultDto channelBriefByDayIfs(@RequestBody HallChannelTagByDaysDto params){
        try {
            if (!DateUtils.isDate(params.getBeginDate())||!DateUtils.isDate(params.getEndDate())){
                return new ResultDto(false,null,"日期格式错误");
            }
            if (params.getBeginDate()>params.getEndDate()){
                return new ResultDto(false,null,"开始时间不能大于结束时间");
            }
            if (params.getChannelTag() == null){
                params.setChannelTag("");
            }
        }catch (Exception ex){
            LogContent content = new LogContent();
            content.setEvent("大厅渠道接口一级界面参数验证错误");
            content.setContent(ex.getMessage());
            logger.error(content);
        }
        return new ResultDto(
                true,
                iHallChannelService.listBriefByDayIfs(params.getChannelTag(),params.getHallId(),params.getBeginDate(),
                        params.getEndDate()),
                ""
        );
    }
    @ResponseBody
    @RequestMapping(value = "ChannelRegDetailsInfoByDay",method = RequestMethod.POST)
    @ApiOperation(value = "全局渠道注册明细")
    public ResultDto channelRegDetailByDayIfs(@RequestBody HallChannelByDayDto params){
        try {
            if (!DateUtils.isDate(params.getBeginDate())||!DateUtils.isDate(params.getEndDate())){
                return new ResultDto(false,null,"日期格式错误");
            }
            if (params.getBeginDate()>params.getEndDate()){
                return new ResultDto(false,null,"开始时间不能大于结束时间");
            }

        }
        catch (Exception ex){
            LogContent content = new LogContent();
            content.setEvent("大厅渠道二级界面注册信息接口参数验证错误");
            content.setContent(ex.getMessage());
            logger.error(content);
        }
        return new ResultDto(
                true,
                iHallChannelService.listRegDetailsByDayIfs(params.getChannelId(),params.getHallId(),
                        params.getBeginDate(),params.getEndDate()),
                ""
        );

    }
    @ResponseBody
    @RequestMapping(value = "ChannelLoginDetailsInfoByDay", method = RequestMethod.POST)
    @ApiOperation(value = "全局渠道多日登录信息")
    public ResultDto channelLoginDetailByDayIfs(@RequestBody HallChannelByDayDto params){
        try {
            if (!DateUtils.isDate(params.getBeginDate())||!DateUtils.isDate(params.getEndDate())){
                return new ResultDto(false,null,"日期格式错误");
            }
            if (params.getBeginDate()>params.getEndDate()){
                return new ResultDto(false,null,"开始时间不能大于结束时间");
            }

        }catch (Exception ex){
            LogContent content = new LogContent();
            content.setEvent("二级界面大厅渠道多日登录接口参数验证错误");
            content.setContent(ex.getMessage());
            logger.error(content);
        }
        return new ResultDto(
                true,
                iHallChannelService.listLoginDetailsByDayIfs(params.getChannelId(),params.getHallId(),
                        params.getBeginDate(),params.getEndDate()),
                ""
        );
    }

    @ResponseBody
    @RequestMapping(value = "ChannelRetainDetailsInfoByDay", method = RequestMethod.POST)
    @ApiOperation(value = "pc全局留存明细")
    public ResultDto channelRetainDetailsByDay(@RequestBody HallChannelByDayDto params){
        try {
            if (!DateUtils.isDate(params.getBeginDate())||!DateUtils.isDate(params.getEndDate())){
                return new ResultDto(false,null,"日期格式错误");
            }
            if (params.getBeginDate()>params.getEndDate()){
                return new ResultDto(false,null,"开始时间不能大于结束时间");
            }

        }catch (Exception ex){
            LogContent content = new LogContent();
            content.setEvent("二级界面大厅渠道多日留存接口参数验证错误");
            content.setContent(ex.getMessage());
            logger.error(content);
        }

        return new ResultDto(
                true,
                iHallChannelService.listRetainDetailsByDayIfs(params.getChannelId(),params.getHallId(),
                        params.getBeginDate(),params.getEndDate()),
                ""
        );
    }
}
