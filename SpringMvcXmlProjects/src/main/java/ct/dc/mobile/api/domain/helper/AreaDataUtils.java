package ct.dc.mobile.api.domain.helper;

import com.alibaba.fastjson.JSON;
import ct.dc.mobile.api.model.serialize.CityInfo;
import ct.dc.mobile.api.model.serialize.CityJsonInfo;
import ct.dc.mobile.api.model.serialize.ProvinceInfo;
import ct.dc.mobile.api.model.serialize.ProvinceJsonInfo;
import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.methods.PostMethod;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Value;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by B41-80 on 2017/1/17.
 */
public class AreaDataUtils {
    private static String commonUri;
    private static String allCitiesMethod;
    private static String allProvinceMethod;
    private static Logger logger = Logger.getLogger(AreaDataUtils.class);
    @Value("${dcCommonApi}")
    public void setCommonUri(String commonUri) {
        this.commonUri = commonUri;
    }

    @Value("${dcCommonApi.allCities}")
    public void setAllCitiesMethod(String allCitiesMethod) {
        this.allCitiesMethod = allCitiesMethod;
    }

    @Value("${dcCommonApi.allProvinces}")
    public void setAllProvinceMethod(String allProvinceMethod) {
        this.allProvinceMethod = allProvinceMethod;
    }

    /**
     * 所有省信息
     * @return
     */
    public static HashMap<String,String> allProvinces(){
        HashMap<String,String> results = new HashMap<String, String>();
        try {
            HttpClient client = new HttpClient();
            PostMethod post = new PostMethod(commonUri+allProvinceMethod);
            client.executeMethod(post);
            ProvinceJsonInfo jsonInfo = JSON.parseObject(post.getResponseBodyAsString(),ProvinceJsonInfo.class);
            if (jsonInfo.getStatus()){
                for (ProvinceInfo info:jsonInfo.getData()){
                    if (!results.containsKey(info.getProvinceCode())){
                        results.put(info.getProvinceCode(),info.getProvinceName());
                    }
                }
                return results;
            }
            return null;
        }catch (Exception ex){
            logger.error(ex.getMessage());
            return null;
        }
    }
    /**
     * 获取所有的地级市信息
     * @return
     */
    public static HashMap<String,CityInfo> allCities(){
        HashMap<String,CityInfo> results = new HashMap<String, CityInfo>();
        try {
            HttpClient client = new HttpClient();
            PostMethod post = new PostMethod(commonUri+allCitiesMethod);
            client.executeMethod(post);
            String result = post.getResponseBodyAsString();
            CityJsonInfo jsonResult = JSON.parseObject(result,CityJsonInfo.class);
            if (jsonResult.getStatus()){
                for (CityInfo info:jsonResult.getData()){
                    if (!results.containsKey(info.getCityCode())){
                        results.put(info.getCityCode(),info);
                    }
                }
                return results;
            }
            return null;
        } catch (IOException e) {
            logger.error(e.getMessage());
            return null;
        }
    }
}
