package ct.dc.pc.api.controller;

import ct.dc.pc.api.model.dto.input.DaysDto;
import ct.dc.pc.api.model.dto.input.WeeksDto;
import ct.dc.pc.api.model.dto.output.ReportResultsDto;
import ct.dc.pc.api.service.report.interfaces.IReportAreaService;
import ct.dc.pc.api.service.report.interfaces.IReportChannelService;
import ct.dc.pc.api.service.report.interfaces.IReportGameService;
import ct.dc.pc.api.service.report.interfaces.IReportHallService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by B41-80 on 2017/4/7.
 */
@Controller
@RequestMapping(value = "/Report")
@ResponseBody
public class ReportController {

    @Autowired
    private IReportGameService iReportGameService;
    @Autowired
    private IReportAreaService iReportAreaService;
    @Autowired
    private IReportHallService iReportHallService;
    @Autowired
    private IReportChannelService iReportChannelService;
    @RequestMapping(value = "/GameRetain",method = RequestMethod.POST)
    @ResponseBody
    @ApiOperation(value = "获取游戏留存报表")
    public ReportResultsDto gameRetain(@RequestBody DaysDto params){
        return new ReportResultsDto(
                true,
                iReportGameService.listReportGameRetainInfo(params.getBeginDate(), params.getEndDate())
        );
    }
    @RequestMapping(value = "/GameLogin",method = RequestMethod.POST)
    @ResponseBody
    @ApiOperation(value = "获取游戏登录报表")
    public ReportResultsDto gameLogin(@RequestBody DaysDto params){
        return new ReportResultsDto(
                true,
                iReportGameService.listReportGameLoginInfo(params.getBeginDate(), params.getEndDate())
        );
    }

    @RequestMapping(value = "/AreaReg", method = RequestMethod.POST)
    @ResponseBody
    @ApiOperation(value = "地区注册")
    public ReportResultsDto  areaReg(@RequestBody DaysDto params){
        return new ReportResultsDto(
                true,
                iReportAreaService.listReportCityRegInfo(params.getBeginDate(), params.getEndDate())
        );
    }

    @RequestMapping(value = "/AreaLogin", method = RequestMethod.POST)
    @ResponseBody
    @ApiOperation(value = "地区登录")
    public ReportResultsDto areaLogin(@RequestBody DaysDto params){
        return new ReportResultsDto(
                true,
                iReportAreaService.listReportCityLoginInfo(params.getBeginDate(),params.getEndDate())
        );
    }

    @RequestMapping(value = "/AreaRetain", method = RequestMethod.POST)
    @ResponseBody
    @ApiOperation(value = "地区留存")
    public ReportResultsDto areaRetain(@RequestBody DaysDto params){
        return new ReportResultsDto(
                true,
                iReportAreaService.listReportCityRetainInfo(params.getBeginDate(),params.getEndDate())
        );
    }

    @RequestMapping(value = "/HallReg",method = RequestMethod.POST)
    @ResponseBody
    @ApiOperation(value = "大厅注册")
    public ReportResultsDto hallReg(@RequestBody DaysDto params){
        return new ReportResultsDto(
                true,iReportHallService.listReportHallRegInfo(params.getBeginDate(),params.getEndDate())
        );
    }

    @RequestMapping(value = "/HallLogin", method = RequestMethod.POST)
    @ResponseBody
    @ApiOperation(value = "大厅多日登陆")
    public ReportResultsDto hallLogin(@RequestBody DaysDto params){
        return new ReportResultsDto(
                true,
                iReportHallService.listReportHallLoginInfo(params.getBeginDate(),params.getEndDate())
        );
    }

    @RequestMapping(value = "/HallRetainInHall",method = RequestMethod.POST)
    @ApiOperation(value = "大厅留存")
    @ResponseBody
    public ReportResultsDto hallRetainInHall(@RequestBody DaysDto params){
        return new ReportResultsDto(
                true,
                iReportHallService.listReportHallRetainInHallInfo(params.getBeginDate(),params.getEndDate())
        );
    }

    @RequestMapping(value = "/HallRetainInPc", method = RequestMethod.POST)
    @ResponseBody
    @ApiOperation(value = "大厅留存")
    public ReportResultsDto hallRetainInPc(@RequestBody DaysDto params){
        return new ReportResultsDto(
                true,
                iReportHallService.listReportHallRetainInPcInfo(params.getBeginDate(),params.getEndDate())
        );
    }


    @RequestMapping(value = "/ChannelReg", method = RequestMethod.POST)
    @ResponseBody
    @ApiOperation(value = "渠道注册")
    public ReportResultsDto channelReg(@RequestBody DaysDto params){
        return new ReportResultsDto(
                true,
                iReportChannelService.listChannelRegIfs(params.getBeginDate(),params.getEndDate())
        );
    }

    @RequestMapping(value = "/RegChannelLogin", method = RequestMethod.POST)
    @ResponseBody
    @ApiOperation(value = "注册渠道登录信息")
    public ReportResultsDto regChannelLogin(@RequestBody DaysDto params){
        return new ReportResultsDto(
                true,
                iReportChannelService.listRegChannelLoginIfs(params.getBeginDate(),params.getEndDate())
        );
    }

    @RequestMapping(value = "/ChannelLogin", method = RequestMethod.POST)
    @ResponseBody
    @ApiOperation(value = "渠道多日登录")
    public ReportResultsDto channelLogin(@RequestBody DaysDto params){
        return new ReportResultsDto(
                true,
                iReportChannelService.listChannelLoginIfs(params.getBeginDate(),params.getEndDate())
        );
    }

    @RequestMapping(value = "/ChannelRegRetain", method = RequestMethod.POST)
    @ResponseBody
    @ApiOperation(value = "注册留存")
    public ReportResultsDto channelRegRetain(@RequestBody DaysDto params){
        return new ReportResultsDto(
                true,
                iReportChannelService.listChannelRegRetainIfs(params.getBeginDate(), params.getEndDate())
        );
    }

    @ResponseBody
    @RequestMapping(value = "/ChannelRegWeekRetain", method = RequestMethod.POST)
    @ApiOperation(value = "注册周留存")
    public ReportResultsDto channelRegWeekRetain(@RequestBody WeeksDto params){
        return new ReportResultsDto(
                true,
                iReportChannelService.listChannelRegWeekRetainIfs(params.getBeginWeek(),params.getEndWeek())
        );
    }
}
