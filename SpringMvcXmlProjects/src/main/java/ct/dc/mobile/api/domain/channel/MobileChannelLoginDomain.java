package ct.dc.mobile.api.domain.channel;

import ct.dc.mobile.api.dao.mobilechannel.Interface.IChannelLoginByDayDAO;
import ct.dc.mobile.api.enums.StatTypeEnum;
import ct.dc.mobile.api.model.domain.channel.LoginDetailDO;
import ct.dc.mobile.api.model.po.mobilechannel.ChannelLoginPo;

import java.util.ArrayList;

/**
 * Created by B41-80 on 2017/1/18.
 */
public class MobileChannelLoginDomain {
    private IChannelLoginByDayDAO iChannelLoginByDayDAO;

    public void setiChannelLoginByDayDAO(IChannelLoginByDayDAO iChannelLoginByDayDAO) {
        this.iChannelLoginByDayDAO = iChannelLoginByDayDAO;
    }

    /**
     * 通过po获取do类
     * @return
     */
    private ArrayList<LoginDetailDO> getLoginDetails(ChannelLoginPo info){
        ArrayList<LoginDetailDO> results = new ArrayList<LoginDetailDO>();
        LoginDetailDO hard = new LoginDetailDO();
        hard.setDate(info.getDate());
        hard.setChannelId(info.getChannel());
        hard.setTimes((long)info.getTimes());
        hard.setType(StatTypeEnum.HARD.getValue());
        hard.setUsers1D1(info.getHards1D1());
        hard.setUsers3D1(info.getHards3D1());
        hard.setUsers7D1(info.getHards7D1());
        hard.setUsers14D1(info.getHards14D1());
        hard.setUsers30D1(info.getHards30D1());

        LoginDetailDO account = new LoginDetailDO();
        account.setDate(info.getDate());
        account.setType(StatTypeEnum.ACCOUNT.getValue());
        account.setTimes((long)info.getTimes());
        account.setChannelId(info.getChannel());
        account.setUsers1D1(info.getUsers1D1());
        account.setUsers3D1(info.getUsers3D1());
        account.setUsers7D1(info.getUsers7D1());
        account.setUsers14D1(info.getUsers14D1());
        account.setUsers30D1(info.getUsers30D1());
        results.add(hard);
        results.add(account);
        return results;
    }
    /**
     * 渠道多日登录
     * @param begin
     * @param end
     * @param app
     * @param channel
     * @return
     */
    public ArrayList<LoginDetailDO> loginInfos(int begin,int end,long app,Long channel){
        ArrayList<LoginDetailDO> results = new ArrayList<LoginDetailDO>();
        for (ChannelLoginPo info:iChannelLoginByDayDAO.find(begin,end,app,channel)){
            results.addAll(getLoginDetails(info));
        }
        if (results.size() == 0){
            LoginDetailDO hard = new LoginDetailDO();
            hard.setDate(begin);
            hard.setChannelId(channel);
            hard.setTimes(0L);
            hard.setType(StatTypeEnum.HARD.getValue());
            hard.setUsers1D1(0);
            hard.setUsers3D1(0);
            hard.setUsers7D1(0);
            hard.setUsers14D1(0);
            hard.setUsers30D1(0);

            LoginDetailDO account = new LoginDetailDO();
            account.setDate(begin);
            account.setType(StatTypeEnum.ACCOUNT.getValue());
            account.setTimes(0L);
            account.setChannelId(channel);
            account.setUsers1D1(0);
            account.setUsers3D1(0);
            account.setUsers7D1(0);
            account.setUsers14D1(0);
            account.setUsers30D1(0);
            results.add(hard);
            results.add(account);
        }
        return results;
    }
}
