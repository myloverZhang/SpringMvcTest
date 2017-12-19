package ct.dc.mobile.api.domain.channel;

import ct.dc.mobile.api.dao.mobilechannel.Interface.IChannelRetainByDayDAO;
import ct.dc.mobile.api.enums.StatTypeEnum;
import ct.dc.mobile.api.model.domain.channel.RetainDetailDO;
import ct.dc.mobile.api.model.po.mobilechannel.ChannelRetainPo;

import java.util.ArrayList;

/**
 * Created by B41-80 on 2017/1/18.
 */
public class MobileChannelRetainDomain {
    private IChannelRetainByDayDAO iChannelRetainByDayDAO;

    public void setiChannelRetainByDayDAO(IChannelRetainByDayDAO iChannelRetainByDayDAO) {
        this.iChannelRetainByDayDAO = iChannelRetainByDayDAO;
    }

    /**
     * 通过po获取do
     * @return
     */
    private ArrayList<RetainDetailDO> getRetainDetails(ChannelRetainPo info){
        ArrayList<RetainDetailDO> results = new ArrayList<RetainDetailDO>();
        RetainDetailDO hard = new RetainDetailDO();
        hard.setDate(info.getDate());
        hard.setChannelId(info.getChannel());
        hard.setType(StatTypeEnum.HARD.getValue());
        hard.setNewCount(info.getHardsNew());
        hard.setUsers1Day(info.getHardsD1());
        hard.setUsers3Day(info.getHardsD3());
        hard.setUsers7Day(info.getHardsD7());
        hard.setUsers14Day(info.getHardsD14());
        hard.setUsers30Day(info.getHardsD30());

        RetainDetailDO account = new RetainDetailDO();
        account.setDate(info.getDate());
        account.setType(StatTypeEnum.ACCOUNT.getValue());
        account.setChannelId(info.getChannel());
        account.setNewCount(info.getUsersNew());
        account.setUsers1Day(info.getUsersD1());
        account.setUsers3Day(info.getUsersD3());
        account.setUsers7Day(info.getUsersD7());
        account.setUsers14Day(info.getUsersD14());
        account.setUsers30Day(info.getUsersD30());
        results.add(account);
        results.add(hard);
        return results;
    }
    /**
     * 渠道分析留存数据
     * @param begin
     * @param end
     * @param app
     * @param channel
     * @return
     */
    public ArrayList<RetainDetailDO> retainInfos(int begin,int end,long app,Long channel){
        ArrayList<RetainDetailDO> results = new ArrayList<RetainDetailDO>();
        for (ChannelRetainPo info:iChannelRetainByDayDAO.find(begin,end,app,channel)){
            results.addAll(getRetainDetails(info));
        }
        if (results.size() == 0){
            RetainDetailDO hard = new RetainDetailDO();
            hard.setDate(begin);
            hard.setChannelId(channel);
            hard.setType(StatTypeEnum.HARD.getValue());
            hard.setNewCount(0);
            hard.setUsers1Day(0);
            hard.setUsers3Day(0);
            hard.setUsers7Day(0);
            hard.setUsers14Day(0);
            hard.setUsers30Day(0);

            RetainDetailDO account = new RetainDetailDO();
            account.setDate(begin);
            account.setType(StatTypeEnum.ACCOUNT.getValue());
            account.setChannelId(channel);
            account.setNewCount(0);
            account.setUsers1Day(0);
            account.setUsers3Day(0);
            account.setUsers7Day(0);
            account.setUsers14Day(0);
            account.setUsers30Day(0);
            results.add(account);
            results.add(hard);
        }
        return results;
    }
}
