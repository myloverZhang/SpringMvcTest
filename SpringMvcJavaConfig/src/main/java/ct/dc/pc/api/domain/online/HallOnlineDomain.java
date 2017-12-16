package ct.dc.pc.api.domain.online;

import ct.dc.pc.api.dao.hall.interfaces.IHallOnlineByDayDao;
import ct.dc.pc.api.domain.helper.SortByInteger;
import ct.dc.pc.api.model.domain.hall.HallOnlineByDayDo;
import ct.dc.pc.api.model.domain.hall.HallOnlineByMonthDo;
import ct.dc.pc.api.model.domain.hall.HallOnlinePerDayDo;
import ct.dc.pc.api.model.po.hall.HallOnlineByDayPo;
import io.swagger.models.auth.In;
import org.apache.commons.digester3.Digester;
import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.methods.PostMethod;
import org.apache.commons.httpclient.methods.RequestEntity;
import org.apache.commons.httpclient.methods.StringRequestEntity;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * Created by B41-80 on 2017/4/6.
 */
@Component
@PropertySource("classpath:svcaddress.properties")
public class HallOnlineDomain {
    @Autowired
    private IHallOnlineByDayDao iHallOnlineByDayDao;
    @Value("${logDBService}")
    private String loginDbServiceUri;
    private Logger logger = Logger.getLogger(HallOnlineDomain.class);
    /**
     * 安卓端多日在线
     * @param beginDate
     * @param endDate
     * @return
             */
    public ArrayList<HallOnlineByDayDo> listOnlineDaysInfo(int group,int beginDate, int endDate){
        ArrayList<HallOnlineByDayDo> results = new ArrayList<HallOnlineByDayDo>();
        for (HallOnlineByDayPo info:iHallOnlineByDayDao.findByGroup(group, beginDate, endDate)){
            results.add(getOnlineDaysInfo(info));
        }
        return results;
    }

    /**
     * 多月在线
     * @param beginMonth
     * @param endMonth
     * @return
     */
    public ArrayList<HallOnlineByMonthDo> listOnlineMonthsInfo(int group,int beginMonth, int endMonth){
        ArrayList<HallOnlineByMonthDo> results = new ArrayList<HallOnlineByMonthDo>();
        HashMap<Integer,ArrayList<Integer>> monthOnlineInfos = new HashMap<Integer, ArrayList<Integer>>();
        for (HallOnlineByDayPo info:iHallOnlineByDayDao.findByGroup(group,beginMonth*100 + 1,endMonth*100+31)){
            int month = info.getDate()/100;
            if (!monthOnlineInfos.containsKey(month)){
                monthOnlineInfos.put(month,new ArrayList<Integer>());
            }
            monthOnlineInfos.get(month).add(info.getMaxUsers());
        }
        Iterator iterator = monthOnlineInfos.entrySet().iterator();
        while (iterator.hasNext()){
            Map.Entry entry = (Map.Entry)iterator.next();
            int month = (Integer)entry.getKey();
            ArrayList<Integer> maxUsers = (ArrayList<Integer>)entry.getValue();
            maxUsers.sort(new SortByInteger());
            HallOnlineByMonthDo result = new HallOnlineByMonthDo(month, getStandardUsers(maxUsers));
            results.add(result);
        }
        return results;
    }

    /**
     * 单日在线
     * @param date
     * @return
     */
    public ArrayList<HallOnlinePerDayDo> listOnlinePerDayInfo(int group,int date){
        ArrayList<HallOnlinePerDayDo> results = new ArrayList<>();
        InputStream is = null;
        HttpClient client = new HttpClient();
        try {
            PostMethod method = new PostMethod(loginDbServiceUri);
            RequestEntity entity = new StringRequestEntity("<?xml version=\"1.0\" encoding=\"utf-8\"?>" +
                    "<soap:Envelope xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xmlns:xsd=\"http://www.w3.org/2001/XMLSchema\" xmlns:soap=\"http://schemas.xmlsoap.org/soap/envelope/\">" +
                    "<soap:Body>" +
                    "<GroupUsers_GetOnlinePerDay xmlns=\"http://grsvc.uc108.org:2305/\">" +
                    "<dt>" + intToString(date) + "</dt>" +
                    "<gid>" + String.valueOf(group) + "</gid>" +
                    "</GroupUsers_GetOnlinePerDay>" +
                    "</soap:Body>" +
                    "</soap:Envelope>", "text/xml", "utf-8");
            method.setRequestEntity(entity);
            method.setRequestHeader("Content-Type", "text/xml;charset=utf-8");
            client.executeMethod(method);
            is = method.getResponseBodyAsStream();
            Digester digester = new Digester();
            digester.setValidating(false);
            digester.addObjectCreate("soap:Envelope/soap:Body/GroupUsers_GetOnlinePerDayResponse/GroupUsers_GetOnlinePerDayResult", java.util.ArrayList.class);
            digester.addSetProperties("soap:Envelope/soap:Body/GroupUsers_GetOnlinePerDayResponse/GroupUsers_GetOnlinePerDayResult");
            digester.addObjectCreate("soap:Envelope/soap:Body/GroupUsers_GetOnlinePerDayResponse/GroupUsers_GetOnlinePerDayResult/GroupUsersInfo", "ct.dc.pc.api.model.domain.hall.HallOnlinePerDayDo");
            digester.addBeanPropertySetter("soap:Envelope/soap:Body/GroupUsers_GetOnlinePerDayResponse/GroupUsers_GetOnlinePerDayResult/GroupUsersInfo/Users", "users");
            digester.addBeanPropertySetter("soap:Envelope/soap:Body/GroupUsers_GetOnlinePerDayResponse/GroupUsers_GetOnlinePerDayResult/GroupUsersInfo/LookDay", "date");
            digester.addBeanPropertySetter("soap:Envelope/soap:Body/GroupUsers_GetOnlinePerDayResponse/GroupUsers_GetOnlinePerDayResult/GroupUsersInfo/LookTime", "time");
            digester.addSetProperties("soap:Envelope/soap:Body/GroupUsers_GetOnlinePerDayResponse/GroupUsers_GetOnlinePerDayResult/GroupUsersInfo");
            digester.addSetNext("soap:Envelope/soap:Body/GroupUsers_GetOnlinePerDayResponse/GroupUsers_GetOnlinePerDayResult/GroupUsersInfo", "add", "ct.dc.pc.api.model.domain.hall.HallOnlinePerDayDo");
            ArrayList<HallOnlinePerDayDo> result = (ArrayList<HallOnlinePerDayDo>)digester.parse(is);
            return result;
        }catch (Exception ex){
            logger.error(ex.getMessage());
            return null;
        }
    }
    /**
     * 计算标准月在线信息
     * @param maxUsers
     * @return
     */
    private Integer getStandardUsers(ArrayList<Integer> maxUsers){
        int sum = 0;
        int count = 0;
        int length = maxUsers.size();
        if (length == 0)
            return 0;
        if (length > 6) {
            for (int i = 3; i < length - 3; i++) {
                count++;
                sum = maxUsers.get(i) + sum;
            }
        }else{
            for(int i = 0;i<length;i++){
                count++;
                sum = maxUsers.get(i) + sum ;
            }
        }
        return sum/count;
    }
    /**
     * 有po在线类获取do类
     * @param info
     * @return
     */
    private HallOnlineByDayDo getOnlineDaysInfo(HallOnlineByDayPo info){
        HallOnlineByDayDo result = new HallOnlineByDayDo();
        result.setMaxUsers(info.getMaxUsers());
        result.setDate(info.getDate());
        result.setAvgUsers(info.getAvgUsers());
        return result;
    }
    /**
     * 将int型的时间转换成string
     *
     * @param date
     * @return
     */
    private String intToString(int date) {
        int month = (date / 100) % 100;
        int day = date % 100;
        String monthString = String.format("%d", month);
        String dayString = String.format("%d", day);
        if (month < 10) {
            monthString = String.format("0%d", month);
        }
        if (day < 10) {
            dayString = String.format("0%d", day);
        }
        return String.format("%d-%s-%s", date / 10000, monthString, dayString);
    }
}
