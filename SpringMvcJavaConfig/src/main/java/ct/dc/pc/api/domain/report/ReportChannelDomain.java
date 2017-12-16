package ct.dc.pc.api.domain.report;

import ct.dc.pc.api.dao.channel.interfaces.*;
import ct.dc.pc.api.model.domain.report.*;
import ct.dc.pc.api.model.po.channel.*;
import ct.dc.pc.api.model.serialize.ChannelInfo;
import ct.dc.pc.api.model.serialize.ChannelTagSerInfo;
import ct.dc.pc.api.util.PromoteUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Map;

/**
 * Created by CTWLPC on 2017/9/15.
 */
@Component
public class ReportChannelDomain {
    @Autowired
    private IChannelRetainByWeekDao iChannelRetainByWeekDao;
    @Autowired
    private IChannelRetainByDayDao iChannelRetainByDayDao;
    @Autowired
    private IRegChannelLoginByDayDao iRegChannelLoginByDayDao;
    @Autowired
    private IChannelBriefByDayDao iChannelBriefByDayDao;
    @Autowired
    private IChannelLoginByDayDao iChannelLoginByDayDao;

    /**
     * 获取报表注册信息
     * @param beginDate
     * @param endDate
     * @return
     */
    public ArrayList<ReportChannelRegDo> listChannelRegIfs(int beginDate,int endDate){
        ArrayList<ReportChannelRegDo> results = new ArrayList<>();
        Map<Long,ChannelInfo> channels = PromoteUtils.listAllChannelIfs();
        Map<Integer,ChannelTagSerInfo> tags = PromoteUtils.listAllChannelTagIfs();
        for (ChannelBriefByDayPo info:iChannelBriefByDayDao.find(beginDate, endDate)){
            ReportChannelRegDo result = new ReportChannelRegDo();
            result.setChannelId(info.getChannel());
            if (channels.containsKey(info.getChannel())){
                ChannelInfo channelInfo = channels.get(info.getChannel());
                result.setChannelName(channelInfo.getChannName());
                result.setTags(listTagIfs(channelInfo.getTags(),tags));
            }
            result.setDate(info.getDate());
            result.setHards(info.getHardsReg());
            result.setUsers(info.getUserReg());
            results.add(result);
        }
        return results;
    };


    /**
     * 报表多日登录信息
     * @param beginDate
     * @param endDate
     * @return
     */
    public ArrayList<ReportChannelLoginDo> listChannelLoginIfs(int beginDate,int endDate){
        ArrayList<ReportChannelLoginDo> results = new ArrayList<>();
        Map<Long,ChannelInfo> channels = PromoteUtils.listAllChannelIfs();
        Map<Integer,ChannelTagSerInfo> tags = PromoteUtils.listAllChannelTagIfs();
        for (ChannelLoginByDayPo info:iChannelLoginByDayDao.find(beginDate, endDate)){
            ReportChannelLoginDo result = new ReportChannelLoginDo();
            BeanUtils.copyProperties(info, result);
            result.setChannelId(info.getChannel());
            if (channels.containsKey(info.getChannel())){
                ChannelInfo channelInfo = channels.get(info.getChannel());
                result.setChannelName(channelInfo.getChannName());
                result.setTags(listTagIfs(channelInfo.getTags(),tags));
            }
            results.add(result);
        }
        return results;
    }


    /**
     * 注册渠道多日登录
     * @param beginDate
     * @param endDate
     * @return
     */
    public ArrayList<ReportRegChannelLoginDo> listRegChannelLoginIfs(int beginDate,int endDate){
        ArrayList<ReportRegChannelLoginDo> results = new ArrayList<>();
        Map<Long,ChannelInfo> channels = PromoteUtils.listAllChannelIfs();
        Map<Integer,ChannelTagSerInfo> tags = PromoteUtils.listAllChannelTagIfs();
        for (RegChannelLoginByDayPo info:iRegChannelLoginByDayDao.find(beginDate, endDate)){
            ReportRegChannelLoginDo result = new ReportRegChannelLoginDo();
            BeanUtils.copyProperties(info, result);
            result.setChannelId(info.getChannel());
            if (channels.containsKey(info.getChannel())){
                ChannelInfo channelInfo = channels.get(info.getChannel());
                result.setChannelName(channelInfo.getChannName());
                ArrayList<ChannelTagInfo> tagIfs = listTagIfs(channelInfo.getTags(),tags);
                result.setTags(tagIfs);
            }
            results.add(result);
        }
        return results;
    }

    /**
     * 渠道注册留存
     * @param beginDate
     * @param endDate
     * @return
     */
    public ArrayList<ReportChannelRegRetainByDayDo> listChannelRetainIfs(int beginDate,int endDate){
        ArrayList<ReportChannelRegRetainByDayDo> results = new ArrayList<>();
        Map<Long,ChannelInfo> channels = PromoteUtils.listAllChannelIfs();
        Map<Integer,ChannelTagSerInfo> tags = PromoteUtils.listAllChannelTagIfs();
        for (ChannelRetainByDayPo info:iChannelRetainByDayDao.find(beginDate, endDate)){
            ReportChannelRegRetainByDayDo result = new ReportChannelRegRetainByDayDo();
            BeanUtils.copyProperties(info, result);
            result.setChannelId(info.getChannel());
            if (channels.containsKey(info.getChannel())){
                ChannelInfo channelInfo = channels.get(info.getChannel());
                result.setChannelName(channelInfo.getChannName());
                result.setTags(listTagIfs(channelInfo.getTags(),tags));
            }
            results.add(result);
        }
        return results;
    }

    /**
     * 渠道周留存
     * @param beginDate
     * @param endDate
     * @return
     */
    public ArrayList<ReportChannelRegWeekRetainDo> listChannelWeekRetainIfs(int beginDate, int endDate){
        ArrayList<ReportChannelRegWeekRetainDo> results = new ArrayList<>();
        Map<Long,ChannelInfo> channels = PromoteUtils.listAllChannelIfs();
        Map<Integer,ChannelTagSerInfo> tags = PromoteUtils.listAllChannelTagIfs();
        for (ChannelRetainByWeekPo info:iChannelRetainByWeekDao.find(beginDate, endDate)){
            ReportChannelRegWeekRetainDo result = new ReportChannelRegWeekRetainDo();
            BeanUtils.copyProperties(info, result);
            result.setChannelId(info.getChannel());
            if (channels.containsKey(info.getChannel())){
                ChannelInfo channelInfo = channels.get(info.getChannel());
                result.setChannelName(channelInfo.getChannName());
                result.setTags(listTagIfs(channelInfo.getTags(),tags));
            }
            results.add(result);
        }
        return results;
    }
    /**
     * 获取渠道标签信息
     * @param tags
     * @param tagSerIfs
     * @return
     */
    private ArrayList<ChannelTagInfo> listTagIfs(ArrayList<Integer> tags, Map<Integer,ChannelTagSerInfo> tagSerIfs){
        ArrayList<ChannelTagInfo> tagIfs = new ArrayList<>();
        for (int tagId:tags){
            ChannelTagInfo tagInfo = new ChannelTagInfo();
            tagInfo.setChannelTagId(tagId);
            if (tagSerIfs.containsKey(tagId)){
                ChannelTagSerInfo tagSerInfo = tagSerIfs.get(tagId);
                tagInfo.setChannelTagName(tagSerInfo.getName());
            }
            tagIfs.add(tagInfo);
        }
        return tagIfs;
    }
}
