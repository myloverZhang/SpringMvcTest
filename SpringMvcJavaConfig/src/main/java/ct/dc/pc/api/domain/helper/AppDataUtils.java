package ct.dc.pc.api.domain.helper;

import com.alibaba.fastjson.JSON;
import ct.dc.pc.api.model.serialize.AppInfo;
import ct.dc.pc.api.model.serialize.AppJsonInfo;
import ct.dc.pc.api.model.serialize.GameInfo;
import ct.dc.pc.api.model.serialize.GameJsonInfo;
import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.methods.PostMethod;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by B41-80 on 2017/1/17.
 */
@PropertySource("classpath:svcaddress.properties")
@Component
public class AppDataUtils {
    @Value("${dcCommonApi.allGames}")
    private String commonApiUri;
    @Value("${dcCommonApi.allApps}")
    private String allAppMethod;
    @Value("${dcCommonApi}")
    private String allGameMethod;


    private static AppDataUtils appDataUtils;
    @PostConstruct
    public void init(){
        appDataUtils = this;
    }
       /**
     * 获取应用对应的信息
     * @param
     * @return
     */
    public static HashMap<String,String> allApp(){
        HashMap<String,String> results = new HashMap<String, String>();
        for (AppInfo info:allAppByRemote()){
            if (!results.containsKey(String.valueOf(info.getAppId()))){
                results.put(String.valueOf(info.getAppId()),info.getAppName());
            }
        }
        return results;
    }

    /**
     * 获取所有游戏的信息
     * @return
     */
    public static HashMap<String,String> allGame(){
        HashMap<String,String> results = new HashMap<>();
        for (GameInfo info:allGameByRemote()){
            if (!results.containsKey(String.valueOf(info.getId()))){
                results.put(String.valueOf(info.getId()),info.getName());
            }
        }
        return results;
    }
    /**
     * 获取所有的游戏信息
     * @return
     */
    private static ArrayList<GameInfo> allGameByRemote(){
        try {
            HttpClient client = new HttpClient();
            PostMethod post = new PostMethod(appDataUtils.commonApiUri + appDataUtils.allGameMethod);
            client.executeMethod(post);
            String result = post.getResponseBodyAsString();
            GameJsonInfo results = JSON.parseObject(result,GameJsonInfo.class);
            if (results.getStatus()){
                return results.getData();
            }
            return null;
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }
    /**
     * 获取所有的游戏信息
     * @return
     */
    private static ArrayList<AppInfo> allAppByRemote(){
        try {
            HttpClient client = new HttpClient();
            PostMethod post = new PostMethod(appDataUtils.commonApiUri + appDataUtils.allAppMethod);
            client.executeMethod(post);
            String result = post.getResponseBodyAsString();
            AppJsonInfo results = JSON.parseObject(result,AppJsonInfo.class);
            if (results.getStatus()){
                return results.getData();
            }
            return null;
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }
}
