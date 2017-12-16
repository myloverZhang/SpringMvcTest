package ct.dc.pc.api.domain.helper;

import com.alibaba.fastjson.JSON;
import ct.dc.pc.api.model.serialize.CityInfo;
import ct.dc.pc.api.model.serialize.CityJsonInfo;
import ct.dc.pc.api.model.serialize.ProvinceInfo;
import ct.dc.pc.api.model.serialize.ProvinceJsonInfo;
import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.methods.PostMethod;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.io.IOException;
import java.util.HashMap;

/**
 * Created by B41-80 on 2017/1/17.
 */
@PropertySource("classpath:svcaddress.properties")
@Component
public class AreaDataUtils {
    @Value("${dcCommonApi}")
    private String commonUri;
    @Value("${dcCommonApi.allCities}")
    private String allCitiesMethod;
    @Value("${dcCommonApi.allProvinces}")
    private String allProvinceMethod;
    private static Logger logger = Logger.getLogger(AreaDataUtils.class);
    private static AreaDataUtils areaDataUtils;

    @PostConstruct
    public void init(){
        areaDataUtils = this;
    }
    /**
     * 所有省信息
     * @return
     */
    public static HashMap<String,String> allProvinces(){
        HashMap<String,String> results = new HashMap<String, String>();
        try {
            HttpClient client = new HttpClient();
            PostMethod post = new PostMethod(areaDataUtils.commonUri+areaDataUtils.allProvinceMethod);
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
            PostMethod post = new PostMethod(areaDataUtils.commonUri+areaDataUtils.allCitiesMethod);
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
