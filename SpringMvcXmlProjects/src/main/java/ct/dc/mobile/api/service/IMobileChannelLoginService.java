package ct.dc.mobile.api.service;

import ct.dc.mobile.api.model.domain.channel.LoginDetailDO;

import java.util.ArrayList;

/**
 * Created by B41-80 on 2017/1/18.
 */
public interface IMobileChannelLoginService {
    ArrayList<LoginDetailDO> loginInfoByDays(int begin,int end,long app,Long channel);
}
