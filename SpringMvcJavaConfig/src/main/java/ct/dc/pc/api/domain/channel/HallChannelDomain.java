package ct.dc.pc.api.domain.channel;

import ct.dc.pc.api.dao.hall.interfaces.IChannelBriefByDayDao;
import ct.dc.pc.api.dao.hall.interfaces.IChannelLoginByDayDao;
import ct.dc.pc.api.dao.hall.interfaces.IChannelRetainByDayDao;
import ct.dc.pc.api.enums.StatTypeEnum;
import ct.dc.pc.api.model.domain.channel.*;
import ct.dc.pc.api.model.po.hall.HallChannelBriefByDayPo;
import ct.dc.pc.api.model.po.hall.HallChannelLoginByDayPo;
import ct.dc.pc.api.model.po.hall.HallChannelRetainByDayPo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by CTWLPC on 2017/6/13.
 */
@Component
public class HallChannelDomain {
    @Autowired
    private IChannelBriefByDayDao iChannelBriefByDayDao;
    @Autowired
    private IChannelLoginByDayDao iChannelLoginByDayDao;
    @Autowired
    private IChannelRetainByDayDao iChannelRetainByDayDao;

    /**
     * 通过查的结果获取计算后的结果
     * @return
     */
    private ArrayList<HallBriefSumDo> countResultByInfos(ArrayList<HallChannelBriefByDayPo> infos){
        HashMap<Long,HallBriefSumDo> hardResults = new HashMap<Long, HallBriefSumDo>();
        HashMap<Long,HallBriefSumDo> accountResults = new HashMap<Long, HallBriefSumDo>();
        for (HallChannelBriefByDayPo info:infos){
            if (!hardResults.containsKey(info.getChannel())){
                accountResults.put(info.getChannel(),new HallBriefSumDo(info.getChannel(), StatTypeEnum.ACCOUNT.getValue(),0L,0L,0L));
                hardResults.put(info.getChannel(),new HallBriefSumDo(info.getChannel(),StatTypeEnum.HARD.getValue(),0L,0L,0L));
            }
            HallBriefSumDo hardBrief = hardResults.get(info.getChannel());
            HallBriefSumDo accountBrief = accountResults.get(info.getChannel());
            hardBrief.setLogin(hardBrief.getLogin()+info.getHardsLogin());
            hardBrief.setReg(hardBrief.getReg()+info.getHardsReg());
            hardBrief.setFirstLogin(hardBrief.getFirstLogin()+info.getHardsFirstLogin());
            accountBrief.setReg(accountBrief.getReg()+info.getUserReg());
            accountBrief.setLogin(accountBrief.getLogin()+info.getUsersLogin());
            accountBrief.setFirstLogin(accountBrief.getFirstLogin()+info.getUserFirstLogin());
        }
        ArrayList<HallBriefSumDo> results = new ArrayList<HallBriefSumDo>();
        results.addAll(hardResults.values());
        results.addAll(accountResults.values());
        return results;
    }
    /**
     * 大厅维度下的渠道概要信息
     * @param channels
     * @param group
     * @param beginDate
     * @param endDate
     * @return
     */
    public ArrayList<HallBriefSumDo> listBriefByDayIfs(ArrayList<Long> channels, long group,int beginDate, int endDate){
        return countResultByInfos(channels.size()>0?iChannelBriefByDayDao.findByChannels(channels, group,
                beginDate, endDate):iChannelBriefByDayDao.find(group, beginDate, endDate));

    }

    /**
     * 大厅维度下的渠道概要统计
     * @param channel
     * @param group
     * @param beginDate
     * @param endDate
     * @return
     */
    public ArrayList<HallRegDetailsByDayDo> listRegDetailsByDayIfs(Long channel, long group, int beginDate, int endDate){
        ArrayList<HallRegDetailsByDayDo> results = new ArrayList<>();
        for (HallChannelBriefByDayPo info:iChannelBriefByDayDao.findByChannel(channel, group ,beginDate, endDate)){
            HallRegDetailsByDayDo account = new HallRegDetailsByDayDo();
            account.setChannelId(info.getChannel());
            account.setDate(info.getDate());
            account.setReg(info.getUserReg());
            account.setType(StatTypeEnum.ACCOUNT.getValue());
            results.add(account);

            HallRegDetailsByDayDo hard = new HallRegDetailsByDayDo();
            hard.setChannelId(info.getChannel());
            hard.setType(StatTypeEnum.HARD.getValue());
            hard.setDate(info.getDate());
            hard.setReg(info.getHardsReg());
            results.add(hard);
        }
        if (results.size() == 0){
            HallRegDetailsByDayDo account = new HallRegDetailsByDayDo();
            account.setChannelId(0L);
            account.setDate(beginDate);
            account.setReg(0L);
            account.setType(StatTypeEnum.ACCOUNT.getValue());
            results.add(account);

            HallRegDetailsByDayDo hard = new HallRegDetailsByDayDo();
            hard.setChannelId(0L);
            hard.setType(StatTypeEnum.HARD.getValue());
            hard.setDate(beginDate);
            hard.setReg(0L);
            results.add(hard);
        }
        return results;
    }

    /**
     * 大厅渠道多日登录信息
     * @param channel
     * @param beginDate
     * @param endDate
     * @return
     */
    public ArrayList<HallLoginDetailsByDayDo> listLoginDetailsByDayIfs(Long channel, long group, int beginDate, int endDate){
        ArrayList<HallLoginDetailsByDayDo> results = new ArrayList<>();
        for (HallChannelLoginByDayPo info:iChannelLoginByDayDao.find(channel, group, beginDate, endDate)){
            HallLoginDetailsByDayDo account = new HallLoginDetailsByDayDo();
            account.setChannelId(info.getChannel());
            account.setDate(info.getDate());
            account.setTimes(info.getTimes());
            account.setType(StatTypeEnum.ACCOUNT.getValue());
            account.setUsers1D1(info.getUsers1D1());
            account.setUsers3D1(info.getUsers3D1());
            account.setUsers7D1(info.getUsers7D1());
            account.setUsers14D1(info.getUsers14D1());
            account.setUsers30D1(info.getUsers30D1());
            results.add(account);

            HallLoginDetailsByDayDo hard = new HallLoginDetailsByDayDo();
            hard.setChannelId(info.getChannel());
            hard.setDate(info.getDate());
            hard.setTimes(info.getTimes());
            hard.setType(StatTypeEnum.HARD.getValue());
            hard.setUsers1D1(info.getHards1D1());
            hard.setUsers3D1(info.getHards3D1());
            hard.setUsers7D1(info.getHards7D1());
            hard.setUsers14D1(info.getHards14D1());
            hard.setUsers30D1(info.getHards30D1());
            results.add(hard);
        }
        if (results.size() == 0){
            HallLoginDetailsByDayDo account = new HallLoginDetailsByDayDo();
            account.setChannelId(0L);
            account.setDate(beginDate);
            account.setTimes(0L);
            account.setType(StatTypeEnum.ACCOUNT.getValue());
            account.setUsers1D1(0L);
            account.setUsers3D1(0L);
            account.setUsers7D1(0L);
            account.setUsers14D1(0L);
            account.setUsers30D1(0L);
            results.add(account);

            HallLoginDetailsByDayDo hard = new HallLoginDetailsByDayDo();
            hard.setChannelId(0L);
            hard.setDate(beginDate);
            hard.setTimes(0L);
            hard.setType(StatTypeEnum.HARD.getValue());
            hard.setUsers1D1(0L);
            hard.setUsers3D1(0L);
            hard.setUsers7D1(0L);
            hard.setUsers14D1(0L);
            hard.setUsers30D1(0L);
            results.add(hard);
        }
        return results;
    }


    /**
     * 大厅渠道多日留存
     * @param channel
     * @param group
     * @param beginDate
     * @param endDate
     * @return
     */
    public ArrayList<HallRetainDetailsByDayDo> listRetainDetailsByDayIfs(Long channel, long group, int beginDate, int endDate){
        ArrayList<HallRetainDetailsByDayDo> results = new ArrayList<>();
        for (HallChannelRetainByDayPo info:iChannelRetainByDayDao.find(channel, group, beginDate, endDate)){
            HallRetainDetailsByDayDo account = new HallRetainDetailsByDayDo();
            account.setChannelId(info.getChannel());
            account.setDate(info.getDate());
            account.setType(StatTypeEnum.ACCOUNT.getValue());
            account.setNewCount(info.getUsersNew());
            account.setUsers1Day(info.getUsersD1());
            account.setUsers3Day(info.getUsersD3());
            account.setUsers7Day(info.getUsersD7());
            account.setUsers14Day(info.getUsersD14());
            account.setUsers30Day(info.getUsersD30());
            results.add(account);

            HallRetainDetailsByDayDo hard = new HallRetainDetailsByDayDo();
            hard.setChannelId(info.getChannel());
            hard.setDate(info.getDate());
            hard.setType(StatTypeEnum.HARD.getValue());
            hard.setNewCount(info.getHardsNew());
            hard.setUsers1Day(info.getHardsD1());
            hard.setUsers3Day(info.getHardsD3());
            hard.setUsers7Day(info.getHardsD7());
            hard.setUsers14Day(info.getHardsD14());
            hard.setUsers30Day(info.getHardsD30());
            results.add(hard);
        }
        if (results.size() == 0){
            HallRetainDetailsByDayDo account = new HallRetainDetailsByDayDo();
            account.setChannelId(0L);
            account.setDate(beginDate);
            account.setType(StatTypeEnum.ACCOUNT.getValue());
            account.setNewCount(0L);
            account.setUsers1Day(0L);
            account.setUsers3Day(0L);
            account.setUsers7Day(0L);
            account.setUsers14Day(0L);
            account.setUsers30Day(0L);
            results.add(account);

            HallRetainDetailsByDayDo hard = new HallRetainDetailsByDayDo();
            hard.setChannelId(0L);
            hard.setDate(beginDate);
            hard.setType(StatTypeEnum.HARD.getValue());
            hard.setNewCount(0L);
            hard.setUsers1Day(0L);
            hard.setUsers3Day(0L);
            hard.setUsers7Day(0L);
            hard.setUsers14Day(0L);
            hard.setUsers30Day(0L);
            results.add(hard);
        }
        return results;
    }
}
