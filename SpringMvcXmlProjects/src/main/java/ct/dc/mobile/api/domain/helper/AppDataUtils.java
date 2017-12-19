package ct.dc.mobile.api.domain.helper;

import com.alibaba.fastjson.JSON;
import ct.dc.mobile.api.model.serialize.AppInfo;
import ct.dc.mobile.api.model.serialize.AppJsonInfo;
import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.methods.PostMethod;
import org.springframework.beans.factory.annotation.Value;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by B41-80 on 2017/1/17.
 */
public class AppDataUtils {
    private static String commonApiUri;
    private static String allAppMethod;
    @Value("${dcCommonApi.allApps}")
    public void setAllAppMethod(String allAppMethod) {
        this.allAppMethod = allAppMethod;
    }

    @Value("${dcCommonApi}")
    public void setCommonApiUri(String commonApiUri) {
        this.commonApiUri = commonApiUri;
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
     * 获取所有的游戏信息
     * @return
     */
    private static ArrayList<AppInfo> allAppByRemote(){
        try {
            HttpClient client = new HttpClient();
            PostMethod post = new PostMethod(commonApiUri+allAppMethod);
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
