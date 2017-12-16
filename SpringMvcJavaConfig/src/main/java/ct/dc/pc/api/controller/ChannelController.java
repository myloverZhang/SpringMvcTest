package ct.dc.pc.api.controller;

import ct.dc.liblogs.ICtDataLogger;
import ct.dc.liblogs.impl.CtDataLoggerImpl;
import ct.dc.liblogs.model.LogContent;
import ct.dc.pc.api.model.dto.input.ChannelByDaysDto;
import ct.dc.pc.api.model.dto.input.ChannelByWeeksDto;
import ct.dc.pc.api.model.dto.input.ChannelTagByDaysDto;
import ct.dc.pc.api.model.dto.input.ChannelTagByWeeksDto;
import ct.dc.pc.api.model.dto.output.ResultDto;
import ct.dc.pc.api.service.channel.interfaces.IChannelService;
import ct.dc.pc.api.util.date.DateUtils;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by CTWLPC on 2017/6/12.
 */
@Controller
@RequestMapping(value = "/Channel")
@ResponseBody
public class ChannelController {

    private static ICtDataLogger logger = new CtDataLoggerImpl(ChannelTagByDaysDto.class);
    @Autowired
    private IChannelService iChannelService;

    @ResponseBody
    @RequestMapping(value = "ChannelBriefInfoByDay",method = RequestMethod.POST)
    @ApiOperation(value = "渠道全局概要信息")
    public ResultDto channelBriefByDayIfs(@RequestBody ChannelTagByDaysDto params){
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
            if (params.getLimitNum() == null || params.getLimitNum() <= 0){
                params.setLimitNum(Integer.MAX_VALUE);
            }
        }catch (Exception ex){
            LogContent content = new LogContent();
            content.setEvent("渠道接口一级界面参数验证错误");
            content.setContent(ex.getMessage());
            logger.error(content);
        }
        return new ResultDto(
                true,
                iChannelService.listBriefByDayIfs(
                        params.getChannelTag(),
                        params.getBeginDate(),
                        params.getEndDate(),
                        params.getLimitNum()
                ),
                ""
        );
    }


    @ResponseBody
    @RequestMapping(value = "ChannelRegDaysIfsWithId",method = RequestMethod.POST)
    @ApiOperation(value = "全局渠道注册明细")
    public ResultDto channelRegDetailByDayIfs(@RequestBody ChannelByDaysDto params){
        try {
            if (!DateUtils.isDate(params.getBeginDate())||!DateUtils.isDate(params.getEndDate())){
                return new ResultDto(false,null,"日期格式错误");
            }
            if (params.getBeginDate()>params.getEndDate()){
                return new ResultDto(false,null,"开始时间不能大于结束时间");
            }
            if (params.getLimitNum() == null || params.getLimitNum() <= 0){
                params.setLimitNum(Integer.MAX_VALUE);
            }
        }
        catch (Exception ex){
            LogContent content = new LogContent();
            content.setEvent("渠道二级界面注册信息接口参数验证错误");
            content.setContent(ex.getMessage());
            logger.error(content);
        }
        return new ResultDto(
                true,
                iChannelService.listRegDetailsByDayIfs(
                        params.getChannelId(),
                        params.getBeginDate(),
                        params.getEndDate(),
                        params.getLimitNum()
                ),
                ""
        );
    }

    @ResponseBody
    @RequestMapping(value = "ChannelRegDaysIfsWithTag",method = RequestMethod.POST)
    @ApiOperation(value = "全局渠道注册明细 按照标签查询")
    public ResultDto channelRegDetailByDayIfs(@RequestBody ChannelTagByDaysDto params){
        try {
            if (!DateUtils.isDate(params.getBeginDate())||!DateUtils.isDate(params.getEndDate())){
                return new ResultDto(false,null,"日期格式错误");
            }
            if (params.getBeginDate()>params.getEndDate()){
                return new ResultDto(false,null,"开始时间不能大于结束时间");
            }
            if (params.getLimitNum() == null || params.getLimitNum() <= 0){
                params.setLimitNum(Integer.MAX_VALUE);
            }

        }
        catch (Exception ex){
            LogContent content = new LogContent();
            content.setEvent("渠道二级界面注册信息接口参数验证错误");
            content.setContent(ex.getMessage());
            logger.error(content);
        }
        return new ResultDto(
                true,
                iChannelService.listRegDetailsByDayIfs(
                        params.getChannelTag(),
                        params.getBeginDate(),
                        params.getEndDate(),
                        params.getLimitNum()
                ),
                ""
        );

    }


    @ResponseBody
    @RequestMapping(value = "ChannelLoginIfsWithId", method = RequestMethod.POST)
    @ApiOperation(value = "全局渠道多日登录信息")
    public ResultDto channelLoginDetailByDayIfs(@RequestBody ChannelByDaysDto params){
        try {
            if (!DateUtils.isDate(params.getBeginDate())||!DateUtils.isDate(params.getEndDate())){
                return new ResultDto(false,null,"日期格式错误");
            }
            if (params.getBeginDate()>params.getEndDate()){
                return new ResultDto(false,null,"开始时间不能大于结束时间");
            }
            if (params.getLimitNum() == null || params.getLimitNum() <= 0){
                params.setLimitNum(Integer.MAX_VALUE);
            }

        }catch (Exception ex){
            LogContent content = new LogContent();
            content.setEvent("二级界面渠道多日登录接口参数验证错误");
            content.setContent(ex.getMessage());
            logger.error(content);
        }
        return new ResultDto(
                true,
                iChannelService.listLoginDetailsByDayIfs(
                        params.getChannelId(),
                        params.getBeginDate(),
                        params.getEndDate(),
                        params.getLimitNum()
                ),
                ""
        );
    }

    @ResponseBody
    @RequestMapping(value = "ChannelLoginIfsWithTag", method = RequestMethod.POST)
    @ApiOperation(value = "全局渠道多日登录信息 按照标签查询")
    public ResultDto channelLoginDetailByDayIfs(@RequestBody ChannelTagByDaysDto params){
        try {
            if (!DateUtils.isDate(params.getBeginDate())||!DateUtils.isDate(params.getEndDate())){
                return new ResultDto(false,null,"日期格式错误");
            }
            if (params.getBeginDate()>params.getEndDate()){
                return new ResultDto(false,null,"开始时间不能大于结束时间");
            }
            if (params.getLimitNum() == null || params.getLimitNum() <= 0){
                params.setLimitNum(Integer.MAX_VALUE);
            }

        }catch (Exception ex){
            LogContent content = new LogContent();
            content.setEvent("二级界面渠道多日登录接口参数验证错误");
            content.setContent(ex.getMessage());
            logger.error(content);
        }
        return new ResultDto(
                true,
                iChannelService.listLoginDetailsByDayIfs(
                        params.getChannelTag(),
                        params.getBeginDate(),
                        params.getEndDate(),
                        params.getLimitNum()
                ),
                ""
        );
    }

    @ResponseBody
    @RequestMapping(value = "ChannelRetainIfsWithId", method = RequestMethod.POST)
    @ApiOperation(value = "pc全局留存明细")
    public ResultDto channelRetainDetailsByDay(@RequestBody ChannelByDaysDto params){
        try {
            if (!DateUtils.isDate(params.getBeginDate())||!DateUtils.isDate(params.getEndDate())){
                return new ResultDto(false,null,"日期格式错误");
            }
            if (params.getBeginDate()>params.getEndDate()){
                return new ResultDto(false,null,"开始时间不能大于结束时间");
            }
            if (params.getLimitNum() == null || params.getLimitNum() <= 0){
                params.setLimitNum(Integer.MAX_VALUE);
            }

        }catch (Exception ex){
            LogContent content = new LogContent();
            content.setEvent("二级界面渠道多日留存接口参数验证错误");
            content.setContent(ex.getMessage());
            logger.error(content);
        }

        return new ResultDto(
                true,
                iChannelService.listRetainDetailsByDayIfs(
                        params.getChannelId(),
                        params.getBeginDate(),
                        params.getEndDate(),
                        params.getLimitNum()
                ),
                ""
        );
    }



    @ResponseBody
    @RequestMapping(value = "ChannelRetainIfsWithTag", method = RequestMethod.POST)
    @ApiOperation(value = "pc全局留存明细 按照标签查询")
    public ResultDto channelRetainDetailsByDay(@RequestBody ChannelTagByDaysDto params){
        try {
            if (!DateUtils.isDate(params.getBeginDate())||!DateUtils.isDate(params.getEndDate())){
                return new ResultDto(false,null,"日期格式错误");
            }
            if (params.getBeginDate()>params.getEndDate()){
                return new ResultDto(false,null,"开始时间不能大于结束时间");
            }
            if (params.getLimitNum() == null || params.getLimitNum() <= 0){
                params.setLimitNum(Integer.MAX_VALUE);
            }

        }catch (Exception ex){
            LogContent content = new LogContent();
            content.setEvent("二级界面渠道多日留存接口参数验证错误");
            content.setContent(ex.getMessage());
            logger.error(content);
        }

        return new ResultDto(
                true,
                iChannelService.listRetainDetailsByDayIfs(
                        params.getChannelTag(),
                        params.getBeginDate(),
                        params.getEndDate(),
                        params.getLimitNum()
                ),
                ""
        );
    }


    @ResponseBody
    @RequestMapping(value = "RegChannelLoginIfsWithTag", method = RequestMethod.POST)
    @ApiOperation(value = "全局注册渠道 多日登录信息 按照标签查询")
    public ResultDto regChannelLoginDetailIfs(@RequestBody ChannelTagByDaysDto params){
        try {
            if (!DateUtils.isDate(params.getBeginDate())||!DateUtils.isDate(params.getEndDate())){
                return new ResultDto(false,null,"日期格式错误");
            }
            if (params.getBeginDate()>params.getEndDate()){
                return new ResultDto(false,null,"开始时间不能大于结束时间");
            }
            if (params.getLimitNum() == null || params.getLimitNum() <= 0){
                params.setLimitNum(Integer.MAX_VALUE);
            }
        }catch (Exception ex){
            LogContent content = new LogContent();
            content.setEvent("二级界面渠道多日登录接口参数验证错误");
            content.setContent(ex.getMessage());
            logger.error(content);
        }
        return new ResultDto(
                true,
                iChannelService.listLoginDetailsRegChannelIfs(
                        params.getChannelTag(),
                        params.getBeginDate(),
                        params.getEndDate(),
                        params.getLimitNum()
                ),
                ""
        );
    }

    @ResponseBody
    @RequestMapping(value = "RegChannelLoginIfsWithId", method = RequestMethod.POST)
    @ApiOperation(value = "全局注册渠道 多日登录信息 按照渠道ID查询")
    public ResultDto regChannelLoginDetailIfs(@RequestBody ChannelByDaysDto params){
        try {
            if (!DateUtils.isDate(params.getBeginDate())||!DateUtils.isDate(params.getEndDate())){
                return new ResultDto(false,null,"日期格式错误");
            }
            if (params.getBeginDate()>params.getEndDate()){
                return new ResultDto(false,null,"开始时间不能大于结束时间");
            }
            if (params.getLimitNum() == null || params.getLimitNum() <= 0){
                params.setLimitNum(Integer.MAX_VALUE);
            }
        }catch (Exception ex){
            LogContent content = new LogContent();
            content.setEvent("二级界面渠道多日登录接口参数验证错误");
            content.setContent(ex.getMessage());
            logger.error(content);
        }
        return new ResultDto(
                true,
                iChannelService.listLoginDetailsRegChannelIfs(
                        params.getChannelId(),
                        params.getBeginDate(),
                        params.getEndDate(),
                        params.getLimitNum()
                ),
                ""
        );
    }


    @ResponseBody
    @RequestMapping(value = "ChannelWeekRetainIfsWithTag", method = RequestMethod.POST)
    @ApiOperation(value = "pc全局注册渠道周留存明细 按照标签查询")
    public ResultDto channelRetainByWeekIfs(@RequestBody ChannelTagByWeeksDto params){
        try {
            if (!DateUtils.isDate(params.getBeginWeek())||!DateUtils.isDate(params.getEndWeek())){
                return new ResultDto(false,null,"日期格式错误");
            }
            if (params.getBeginWeek()>params.getEndWeek()){
                return new ResultDto(false,null,"开始时间不能大于结束时间");
            }
            if (params.getLimitNum() == null || params.getLimitNum() <= 0){
                params.setLimitNum(Integer.MAX_VALUE);
            }
        }catch (Exception ex){
            LogContent content = new LogContent();
            content.setEvent("二级界面渠道多日留存接口参数验证错误");
            content.setContent(ex.getMessage());
            logger.error(content);
        }

        return new ResultDto(
                true,
                iChannelService.listRetainDetailsByWeekIfs(
                        params.getChannelTag(),
                        params.getBeginWeek(),
                        params.getEndWeek(),
                        params.getLimitNum()
                ),
                ""
        );
    }

    @ResponseBody
    @RequestMapping(value = "ChannelWeekRetainIfsWithId", method = RequestMethod.POST)
    @ApiOperation(value = "pc全局渠道周留存明细 按照渠道id查询")
    public ResultDto channelRetainByWeekIfs(@RequestBody ChannelByWeeksDto params) {
        try {
            if (!DateUtils.isDate(params.getBeginWeek()) || !DateUtils.isDate(params.getEndWeek())) {
                return new ResultDto(false, null, "日期格式错误");
            }
            if (params.getBeginWeek() > params.getEndWeek()) {
                return new ResultDto(false, null, "开始时间不能大于结束时间");
            }
            if (params.getLimitNum() == null || params.getLimitNum() <= 0){
                params.setLimitNum(Integer.MAX_VALUE);
            }
        } catch (Exception ex) {
            LogContent content = new LogContent();
            content.setEvent("二级界面渠道多日留存接口参数验证错误");
            content.setContent(ex.getMessage());
            logger.error(content);
        }

        return new ResultDto(
                true,
                iChannelService.listRetainDetailsByWeekIfs(
                        params.getChannelId(),
                        params.getBeginWeek(),
                        params.getEndWeek(),
                        params.getLimitNum()
                ),
                ""
        );
    }
}
