package ct.dc.mobile.api.domain.channel;

import ct.dc.mobile.api.dao.mobilechannel.Interface.IChannelBriefByDayDAO;
import ct.dc.mobile.api.domain.helper.PromoteUtils;
import ct.dc.mobile.api.enums.StatTypeEnum;
import ct.dc.mobile.api.model.domain.channel.BriefSumDO;
import ct.dc.mobile.api.model.domain.channel.RegDetailDO;
import ct.dc.mobile.api.model.po.mobilechannel.ChannelBriefPo;
import ct.dc.mobile.api.utils.ResourceUtils;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by B41-80 on 2017/1/18.
 */
public class MobileChannelBriefDomain {
    private IChannelBriefByDayDAO iChannelBriefByDayDAO;

    public void setiChannelBriefByDayDAO(IChannelBriefByDayDAO iChannelBriefByDayDAO) {
        this.iChannelBriefByDayDAO = iChannelBriefByDayDAO;
    }


    /**
     * 通过查的结果获取计算后的结果
     * @return
     */
    private ArrayList<BriefSumDO> countResultByInfos(ArrayList<ChannelBriefPo> infos){
        HashMap<Long,BriefSumDO> hardResults = new HashMap<Long, BriefSumDO>();
        HashMap<Long,BriefSumDO> accountResults = new HashMap<Long, BriefSumDO>();
        for (ChannelBriefPo info:infos){
            if (!hardResults.containsKey(info.getChannel())){
                accountResults.put(info.getChannel(),new BriefSumDO(info.getChannel(), StatTypeEnum.ACCOUNT.getValue(),0L,0L,0L));
                hardResults.put(info.getChannel(),new BriefSumDO(info.getChannel(),StatTypeEnum.HARD.getValue(),0L,0L,0L));
            }
            BriefSumDO hardBrief = hardResults.get(info.getChannel());
            BriefSumDO accountBrief = accountResults.get(info.getChannel());
            hardBrief.setLogin(hardBrief.getLogin()+info.getHardsLogin());
            hardBrief.setReg(hardBrief.getReg()+info.getHardsReg());
            hardBrief.setFirstLogin(hardBrief.getFirstLogin()+info.getHardsFirstLogin());
            accountBrief.setReg(accountBrief.getReg()+info.getUsersReg());
            accountBrief.setLogin(accountBrief.getLogin()+info.getUsersLogin());
            accountBrief.setFirstLogin(accountBrief.getFirstLogin()+info.getUsersFirstLogin());
        }
        ArrayList<BriefSumDO> results = new ArrayList<BriefSumDO>();
        results.addAll(hardResults.values());
        results.addAll(accountResults.values());
        return results;
    }

    /**
     * 通过po类获取新增信息
     * @param info
     * @return
     */
    private ArrayList<RegDetailDO> getRegDetails(ChannelBriefPo info){
        RegDetailDO hard = new RegDetailDO(info.getDate(),info.getChannel(),StatTypeEnum.HARD.getValue(),(long)info.getHardsReg());
        RegDetailDO account = new RegDetailDO(info.getDate(),info.getChannel(),StatTypeEnum.ACCOUNT.getValue(),(long)info.getUsersReg());
        ArrayList<RegDetailDO> results = new ArrayList<RegDetailDO>();
        results.add(hard);
        results.add(account);
        return results;
    }
    /**
     * 渠道分析一级界面
     * @param begin
     * @param end
     * @param app
     * @param tag
     * @return
     */
    public ArrayList<BriefSumDO> briefInfos(int begin,int end,long app,String tag){
        ArrayList<Long> channels = new ArrayList<Long>();
        if (tag !=null && !tag.equals("")){
            if (tag.equals(ResourceUtils.ALL_CHANNEL)){
                return countResultByInfos(iChannelBriefByDayDAO.find(begin,end,app));
            }
            int tagNum = Integer.valueOf(tag);
            channels.addAll(PromoteUtils.getChannelsByTag(tagNum));
        }
        return countResultByInfos(iChannelBriefByDayDAO.find(begin,end,app,channels));
    }

    /**
     * 注册信息
     * @param begin
     * @param end
     * @param app
     * @param channel
     * @return
     */
    public ArrayList<RegDetailDO> regInfosByDays(int begin, int end, long app, Long channel){
        ArrayList<RegDetailDO> results = new ArrayList<RegDetailDO>();
        for (ChannelBriefPo info: iChannelBriefByDayDAO.find(begin,end,app,channel)){
            RegDetailDO hardresult = new RegDetailDO();
            results.addAll(getRegDetails(info));
        }
        if (results.size() == 0){
            RegDetailDO hard = new RegDetailDO(begin,channel,StatTypeEnum.HARD.getValue(),0L);
            RegDetailDO account = new RegDetailDO(begin,channel,StatTypeEnum.ACCOUNT.getValue(),0L);
            results.add(hard);
            results.add(account);
        }
        return results;
    }
}
