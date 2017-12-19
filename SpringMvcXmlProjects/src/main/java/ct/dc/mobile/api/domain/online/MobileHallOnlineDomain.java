package ct.dc.mobile.api.domain.online;

import com.sun.org.apache.bcel.internal.generic.FADD;
import com.sun.xml.internal.messaging.saaj.util.ByteInputStream;
import ct.dc.mobile.api.dao.mobileHall.Interface.IHallOnlineByDayDao;
import ct.dc.mobile.api.model.domain.hall.HallOnlineByDayDo;
import ct.dc.mobile.api.model.domain.hall.HallOnlineByMonthDo;
import ct.dc.mobile.api.model.domain.hall.HallOnlineByPerDayDo;
import ct.dc.mobile.api.model.po.mobilehall.HallOnlineByDayPo;
import org.apache.commons.digester3.Digester;
import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.NameValuePair;
import org.apache.commons.httpclient.methods.PostMethod;
import org.apache.commons.httpclient.methods.RequestEntity;
import org.apache.commons.httpclient.methods.StringRequestEntity;
import org.apache.commons.httpclient.methods.multipart.StringPart;
import org.apache.log4j.Logger;
import org.jcp.xml.dsig.internal.DigesterOutputStream;
import org.springframework.beans.factory.annotation.Value;


import java.io.*;
import java.security.MessageDigest;
import java.util.*;

/**
 * Created by B41-80 on 2017/1/13.
 */
public class MobileHallOnlineDomain {

    private IHallOnlineByDayDao iHallOnlineByDayDao;
    private Logger logger = Logger.getLogger(MobileHallOnlineDomain.class);
    @Value("${logDBService}")
    private String logDbServiceUri;

    public void setiHallOnlineByDayDao(IHallOnlineByDayDao iHallOnlineByDayDao) {
        this.iHallOnlineByDayDao = iHallOnlineByDayDao;
    }

    public void setLogDbServiceUri(String logDbServiceUri) {
        this.logDbServiceUri = logDbServiceUri;
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

    /**
     * 单日在线
     *
     * @param date
     * @param hallid
     * @return
     */
    public ArrayList<HallOnlineByPerDayDo> getPerDayByWebService(int date, int hallid) {
        InputStream is = null;
        HttpClient client = new HttpClient();
        try {
            PostMethod method = new PostMethod(logDbServiceUri);
            RequestEntity entity = new StringRequestEntity("<?xml version=\"1.0\" encoding=\"utf-8\"?>" +
                    "<soap:Envelope xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xmlns:xsd=\"http://www.w3.org/2001/XMLSchema\" xmlns:soap=\"http://schemas.xmlsoap.org/soap/envelope/\">" +
                    "<soap:Body>" +
                    "<GroupUsers_GetOnlinePerDay xmlns=\"http://grsvc.uc108.org:2305/\">" +
                    "<dt>" + intToString(date) + "</dt>" +
                    "<gid>" + String.valueOf(hallid) + "</gid>" +
                    "</GroupUsers_GetOnlinePerDay>" +
                    "</soap:Body>" +
                    "</soap:Envelope>", "text/xml", "utf-8");
            method.setRequestEntity(entity);
            method.setRequestHeader("Content-Type", "text/xml;charset=utf-8");
//            method.addParameter("dt",intToString(date));
//            method.addParameter("gid",String.valueOf(hallid));
            client.executeMethod(method);
            is = method.getResponseBodyAsStream();
            Digester digester = new Digester();
            digester.setValidating(false);
            digester.addObjectCreate("soap:Envelope/soap:Body/GroupUsers_GetOnlinePerDayResponse/GroupUsers_GetOnlinePerDayResult", java.util.ArrayList.class);
            digester.addSetProperties("soap:Envelope/soap:Body/GroupUsers_GetOnlinePerDayResponse/GroupUsers_GetOnlinePerDayResult");
            digester.addObjectCreate("soap:Envelope/soap:Body/GroupUsers_GetOnlinePerDayResponse/GroupUsers_GetOnlinePerDayResult/GroupUsersInfo", "ct.dc.mobile.api.model.domain.hall.HallOnlineByPerDayDo");
            digester.addBeanPropertySetter("soap:Envelope/soap:Body/GroupUsers_GetOnlinePerDayResponse/GroupUsers_GetOnlinePerDayResult/GroupUsersInfo/Users", "users");
            digester.addBeanPropertySetter("soap:Envelope/soap:Body/GroupUsers_GetOnlinePerDayResponse/GroupUsers_GetOnlinePerDayResult/GroupUsersInfo/LookDay", "date");
            digester.addBeanPropertySetter("soap:Envelope/soap:Body/GroupUsers_GetOnlinePerDayResponse/GroupUsers_GetOnlinePerDayResult/GroupUsersInfo/LookTime", "time");
            digester.addSetProperties("soap:Envelope/soap:Body/GroupUsers_GetOnlinePerDayResponse/GroupUsers_GetOnlinePerDayResult/GroupUsersInfo");
            digester.addSetNext("soap:Envelope/soap:Body/GroupUsers_GetOnlinePerDayResponse/GroupUsers_GetOnlinePerDayResult/GroupUsersInfo", "add", "ct.dc.mobile.api.model.domain.hall.HallOnlineByPerDayDo");
            ArrayList<HallOnlineByPerDayDo> result = (ArrayList<HallOnlineByPerDayDo>) digester.parse(is);
            return result;
        } catch (Exception ex) {
            logger.error(ex.getMessage());
            return null;
        }
    }

    /**
     * 大厅单日登录
     *
     * @return
     */
    public ArrayList<HallOnlineByPerDayDo> onlineByPerDay(int date, int hallId) {
        return getPerDayByWebService(date, hallId);
    }

    /**
     * 大厅多日在线
     *
     * @param begin
     * @param end
     * @param hallId
     * @return
     */
    public ArrayList<HallOnlineByDayDo> onlineByDay(int begin, int end, int hallId) {
        ArrayList<HallOnlineByDayDo> results = new ArrayList<HallOnlineByDayDo>();
        for (HallOnlineByDayPo info : iHallOnlineByDayDao.find(begin, end, hallId)) {
            HallOnlineByDayDo result = new HallOnlineByDayDo();
            result.setDate(info.getDate());
            result.setAvgUsers(info.getAvgUsers());
            result.setMaxUsers(info.getMaxUsers());
            results.add(result);
        }
        return results;
    }

    /**
     * 月份标准在线
     *
     * @return
     */
    public ArrayList<HallOnlineByMonthDo> onlineByMonth(int begin, int end, int hallId) {
        ArrayList<HallOnlineByMonthDo> results = new ArrayList<HallOnlineByMonthDo>();
        HashMap<Integer, ArrayList<Integer>> mapResults = new HashMap<Integer, ArrayList<Integer>>();
        for (HallOnlineByDayPo info : iHallOnlineByDayDao.find(begin * 100 + 1, end * 100 + 31, hallId)) {
            int month = info.getDate() / 100;
            if (!mapResults.containsKey(month)) {
                mapResults.put(month, new ArrayList<Integer>());
            }
            mapResults.get(month).add(info.getMaxUsers());
        }
        Iterator iterator = mapResults.entrySet().iterator();
        while (iterator.hasNext()) {
            Map.Entry entry = (Map.Entry) iterator.next();
            Integer month = (Integer) entry.getKey();
            ArrayList<Integer> maxUsers = (ArrayList<Integer>)entry.getValue();
            maxUsers.sort(new SortByInteger());
            HallOnlineByMonthDo result = new HallOnlineByMonthDo(month, getStandardUsers(maxUsers));
            results.add(result);
        }
        return results;
    }

    /**
     * 获取标准用户数
     *
     * @return
     */
    private int getStandardUsers(ArrayList<Integer> users) {
        int sum = 0;
        int count = 0;
        int length = users.size();
        if (length == 0)
            return 0;
        if (length > 6) {
            for (int i = 3; i < length - 3; i++) {
                count++;
                sum = users.get(i) + sum;
            }
        }else{
            for(int i = 0;i<length;i++){
                count++;
                sum = users.get(i) + sum ;
            }
        }
        return sum/count;
    }


    /**
     * 排序函数
     */
    class SortByInteger implements Comparator {

        @Override
        public int compare(Object o1, Object o2) {
            Integer integer1 = (Integer) o1;
            Integer integer2 = (Integer) o2;
            if (integer1 > integer2)
                return 1;
            else if (integer1 < integer2)
                return -1;
            else
                return 0;
        }
    }
}
