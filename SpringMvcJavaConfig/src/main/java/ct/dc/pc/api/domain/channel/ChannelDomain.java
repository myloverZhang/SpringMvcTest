package ct.dc.pc.api.domain.channel;

import ct.dc.pc.api.dao.channel.interfaces.*;
import ct.dc.pc.api.enums.StatTypeEnum;
import ct.dc.pc.api.model.domain.channel.*;
import ct.dc.pc.api.model.po.channel.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by CTWLPC on 2017/6/13.
 */
@Component
public class ChannelDomain {
    @Autowired
    private IChannelBriefByDayDao iChannelBriefByDayDao;
    @Autowired
    private IChannelLoginByDayDao iChannelLoginByDayDao;
    @Autowired
    private IChannelRetainByDayDao iChannelRetainByDayDao;
    @Autowired
    private IChannelRetainByWeekDao iChannelRetainByWeekDao;
    @Autowired
    private IRegChannelLoginByDayDao iRegChannelLoginByDayDao;
    public void setiChannelBriefByDayDao(IChannelBriefByDayDao iChannelBriefByDayDao) {
        this.iChannelBriefByDayDao = iChannelBriefByDayDao;
    }

    public void setiChannelLoginByDayDao(IChannelLoginByDayDao iChannelLoginByDayDao) {
        this.iChannelLoginByDayDao = iChannelLoginByDayDao;
    }

    public void setiChannelRetainByDayDao(IChannelRetainByDayDao iChannelRetainByDayDao) {
        this.iChannelRetainByDayDao = iChannelRetainByDayDao;
    }
    /**
     * 通过查的结果获取计算后的结果
     * @return
     */
    private ArrayList<BriefSumDO> countResultByInfos(ArrayList<ChannelBriefByDayPo> infos){
        HashMap<Long,BriefSumDO> hardResults = new HashMap<Long, BriefSumDO>();
        HashMap<Long,BriefSumDO> accountResults = new HashMap<Long, BriefSumDO>();
        for (ChannelBriefByDayPo info:infos){
            if (!hardResults.containsKey(info.getChannel())){
                accountResults.put(info.getChannel(),new BriefSumDO(info.getChannel(), StatTypeEnum.ACCOUNT.getValue(),0L,0L));
                hardResults.put(info.getChannel(),new BriefSumDO(info.getChannel(),StatTypeEnum.HARD.getValue(),0L,0L));
            }
            BriefSumDO hardBrief = hardResults.get(info.getChannel());
            BriefSumDO accountBrief = accountResults.get(info.getChannel());
            hardBrief.setLogin(hardBrief.getLogin()+info.getHardsLogin());
            hardBrief.setReg(hardBrief.getReg()+info.getHardsReg());
            accountBrief.setReg(accountBrief.getReg()+info.getUserReg());
            accountBrief.setLogin(accountBrief.getLogin()+info.getUsersLogin());
        }
        ArrayList<BriefSumDO> results = new ArrayList<BriefSumDO>();
        results.addAll(hardResults.values());
        results.addAll(accountResults.values());
        return results;
    }
    /**
     * 获取全局渠道的概要信息
     * @return
     */
    public ArrayList<BriefSumDO> listBriefByDayIfs(ArrayList<Long> channels, int beginDate, int endDate, int limitNum){
        ArrayList<BriefByDayDo> results = new ArrayList<>();
        return countResultByInfos(channels.size()>0?iChannelBriefByDayDao.findByChannels(channels,beginDate,
                endDate, limitNum):iChannelBriefByDayDao.find(beginDate, endDate, limitNum));

    }

    /**
     *获取渠道相关的注册信息
     * @param channels
     * @param beginDate
     * @param endDate
     * @param limitNum
     * @return
     */
    public ArrayList<RegDetailByDayDo> listRegDetailsByDayIfs(ArrayList<Long> channels, int beginDate, int endDate, int limitNum){
        ArrayList<RegDetailByDayDo> results = new ArrayList<>();
        for (ChannelBriefByDayPo info:channels.size()==0 ? iChannelBriefByDayDao.find(beginDate, endDate, limitNum):
                iChannelBriefByDayDao.findByChannels(channels, beginDate, endDate, limitNum)){
            parseToEntityFromPo(results, info);
        }
        return results;
    }

    /**
     * 通过单一渠道获取数据
     * @param channel
     * @param beginDate
     * @param endDate
     * @return
     */
    public ArrayList<RegDetailByDayDo> listRegDetailsByDayIfs(long channel,int beginDate,int endDate){
        ArrayList<RegDetailByDayDo> results = new ArrayList<>();
        for (ChannelBriefByDayPo info:iChannelBriefByDayDao.findByChannel(channel, beginDate, endDate,Integer.MAX_VALUE)){
            parseToEntityFromPo(results, info);
        }
        return results;
    }

    private void parseToEntityFromPo(ArrayList<RegDetailByDayDo> results, ChannelBriefByDayPo info){
        RegDetailByDayDo account = new RegDetailByDayDo();
        account.setChannelId(info.getChannel());
        account.setDate(info.getDate());
        account.setReg(info.getUserReg());
        account.setType(StatTypeEnum.ACCOUNT.getValue());
        results.add(account);

        RegDetailByDayDo hard = new RegDetailByDayDo();
        hard.setChannelId(info.getChannel());
        hard.setType(StatTypeEnum.HARD.getValue());
        hard.setDate(info.getDate());
        hard.setReg(info.getHardsReg());
        results.add(hard);
    }
    /**
     * 全局渠道多日登录明细
     * @param channels
     * @param beginDate
     * @param endDate
     * @param limitNum
     * @return
     */
    public ArrayList<LoginDetailsByDayDo> listLoginDetailsByDayIfs(ArrayList<Long> channels, int beginDate, int endDate, int limitNum){
        ArrayList<LoginDetailsByDayDo> results = new ArrayList<>();
        for (ChannelLoginByDayPo info:channels.size() == 0 ? iChannelLoginByDayDao.find(beginDate, endDate, limitNum):
                iChannelLoginByDayDao.findByChannels(channels ,beginDate, endDate, limitNum)){
            parseToEntityFromPo(results,info);
        }
        return results;
    }


    /**
     * 通过单一渠道获取数据
     * @param channel
     * @param beginDate
     * @param endDate
     * @return
     */
    public ArrayList<LoginDetailsByDayDo> listLoginDetailsByDayIfs(long channel, int beginDate, int endDate){
        ArrayList<LoginDetailsByDayDo> results = new ArrayList<>();
        for (ChannelLoginByDayPo info:iChannelLoginByDayDao.findByChannel(channel, beginDate, endDate, Integer.MAX_VALUE)){
            parseToEntityFromPo(results,info);
        }
        return results;
    }

    private void parseToEntityFromPo(ArrayList<LoginDetailsByDayDo> results, ChannelLoginByDayPo info){
        LoginDetailsByDayDo account = new LoginDetailsByDayDo();
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

        LoginDetailsByDayDo hard = new LoginDetailsByDayDo();
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
    /**
     * 全局渠道多日登录明细
     * @param channels
     * @param beginDate
     * @param endDate
     * @param limitNum
     * @return
     */
    public ArrayList<LoginDetailRegChannelDo> listLoginDetailsWithRegChannelIfs(ArrayList<Long> channels, int beginDate, int endDate, int limitNum){
        ArrayList<LoginDetailRegChannelDo> results = new ArrayList<>();
        for (RegChannelLoginByDayPo info:channels.size() == 0 ? iRegChannelLoginByDayDao.find(beginDate, endDate, limitNum):
                iRegChannelLoginByDayDao.findByChannels(channels, beginDate, endDate, limitNum)){
            parseToEntityFromPo(results,info);
        }

        return results;
    }

    /**
     * 通过单一渠道获取数据
     * @param channel
     * @param beginDate
     * @param endDate
     * @return
     */
    public ArrayList<LoginDetailRegChannelDo> listLoginDetailsWithRegChannelIfs(long channel, int beginDate, int endDate){
        ArrayList<LoginDetailRegChannelDo> results = new ArrayList<>();
        for (RegChannelLoginByDayPo info:iRegChannelLoginByDayDao.findByChannel(channel,beginDate,endDate,Integer.MAX_VALUE)){
            parseToEntityFromPo(results, info);
        }

        return results;
    }
    private void parseToEntityFromPo(ArrayList<LoginDetailRegChannelDo> results, RegChannelLoginByDayPo info){
        LoginDetailRegChannelDo account = new LoginDetailRegChannelDo();
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

        LoginDetailRegChannelDo hard = new LoginDetailRegChannelDo();
        hard.setChannelId(info.getChannel());
        hard.setDate(info.getDate());
        hard.setTimes(0L);
        hard.setType(StatTypeEnum.HARD.getValue());
        hard.setUsers1D1(0L);
        hard.setUsers3D1(0L);
        hard.setUsers7D1(0L);
        hard.setUsers14D1(0L);
        hard.setUsers30D1(0L);
        results.add(hard);
    }
    /**
     * 根据渠道获取留存信息
     * @param channels
     * @param beginDate
     * @param endDate
     * @param limitNum
     * @return
     */
    public ArrayList<RetainDetailsByDayDo> listRetainDetailsByDayIfs(ArrayList<Long> channels, int beginDate, int endDate, int limitNum){
        ArrayList<RetainDetailsByDayDo> results = new ArrayList<>();
        for (ChannelRetainByDayPo info:channels.size()==0?iChannelRetainByDayDao.find(beginDate, endDate, limitNum):
                iChannelRetainByDayDao.findByChannels(channels, beginDate, endDate, limitNum)){
            parseToEntityFromPo(results, info);
        }
        return results;
    }

    /**
     * 通过单一渠道获取数据
     * @param channel
     * @param beginDate
     * @param endDate
     * @return
     */
    public ArrayList<RetainDetailsByDayDo> listRetainDetailsByDayIfs(long channel, int beginDate, int endDate){
        ArrayList<RetainDetailsByDayDo> results = new ArrayList<>();
        for (ChannelRetainByDayPo info:iChannelRetainByDayDao.findByChannel(channel, beginDate, endDate,Integer.MAX_VALUE)){
            parseToEntityFromPo(results, info);
        }
        return results;
    }
    private void parseToEntityFromPo(ArrayList<RetainDetailsByDayDo> results, ChannelRetainByDayPo info){
        RetainDetailsByDayDo account = new RetainDetailsByDayDo();
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

        RetainDetailsByDayDo hard = new RetainDetailsByDayDo();
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
    /**
     * 根据渠道获取留存信息
     * @param channels
     * @param beginDate
     * @param endDate
     * @param limitNum
     * @return
     */
    public ArrayList<RetainDetailsByWeekDo> listRetainDetailsByWeekIfs(ArrayList<Long> channels, int beginDate, int endDate, int limitNum){
        ArrayList<RetainDetailsByWeekDo> results = new ArrayList<>();
        for (ChannelRetainByWeekPo info:channels.size()==0?iChannelRetainByWeekDao.find(beginDate, endDate, limitNum):
                iChannelRetainByWeekDao.findByChannels(channels, beginDate, endDate, limitNum)){
            parseToEntityFromPo(results, info);
        }
        return results;
    }

    /**
     * 通过单一渠道获取数据
     * @param channel
     * @param beginDate
     * @param endDate
     * @return
     */
    public ArrayList<RetainDetailsByWeekDo> listRetainDetailsByWeekIfs(long channel, int beginDate, int endDate){
        ArrayList<RetainDetailsByWeekDo> results = new ArrayList<>();
        for (ChannelRetainByWeekPo info:iChannelRetainByWeekDao.findByChannel(channel, beginDate, endDate, Integer.MAX_VALUE)){
            parseToEntityFromPo(results, info);
        }
        return results;
    }
    private void parseToEntityFromPo(ArrayList<RetainDetailsByWeekDo> results, ChannelRetainByWeekPo info){
        RetainDetailsByWeekDo account = new RetainDetailsByWeekDo();
        account.setChannelId(info.getChannel());
        account.setDate(info.getDate());
        account.setType(StatTypeEnum.ACCOUNT.getValue());
        account.setNewCount(info.getUsersNew());
        account.setUsers1Week(info.getUsersW1());
        account.setUsers2Week(info.getUsersW2());
        account.setUsers3Week(info.getUsersW3());
        account.setUsers4Week(info.getUsersW4());
        results.add(account);

        RetainDetailsByWeekDo hard = new RetainDetailsByWeekDo();
        hard.setChannelId(info.getChannel());
        hard.setDate(info.getDate());
        hard.setType(StatTypeEnum.HARD.getValue());
        hard.setNewCount(info.getHardsNew());
        hard.setUsers1Week(info.getHardsW1());
        hard.setUsers2Week(info.getHardsW2());
        hard.setUsers3Week(info.getHardsW3());
        hard.setUsers4Week(info.getHardsW4());
        results.add(hard);
    }
}
