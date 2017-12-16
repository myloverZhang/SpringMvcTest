package ct.dc.pc.api.util;

import com.alibaba.fastjson.JSON;
import ct.dc.libinfrastructure.CommonUtils;
import ct.dc.pc.api.model.serialize.ChannelInfo;
import ct.dc.pc.api.model.serialize.ChannelJsonInfo;
import ct.dc.pc.api.model.serialize.ChannelTagJsonInfo;
import ct.dc.pc.api.model.serialize.ChannelTagSerInfo;
import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.methods.GetMethod;
import org.apache.commons.httpclient.methods.PostMethod;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by B41-80 on 2017/1/19.
 */
@Component
@PropertySource("classpath:svcaddress.properties")
public class PromoteUtils {
    @Value("${channelsByTag}")
    private String channelByTag;
    @Value("${dcCommonApi}")
    private String commonUri;
    @Value("${dcCommonApi.allChannels}")
    private String allChannelsMethod;
    @Value("${dcCommonApi.allChannelTags}")
    private String allChannelTagMethod;
    private static Logger logger = Logger.getLogger(PromoteUtils.class);
    private static PromoteUtils promoteUtils;

    @PostConstruct
    public void init(){
        promoteUtils = this;
    }
    /**
     * 获取所有的渠道信息
     * @return
     */
    public static ArrayList<Long> allChannelsByTag(int tagId){
        ArrayList<Long> results = new ArrayList<Long>();
        for (ChannelInfo info : allChannels()){
            if (info.getTags().contains(tagId)){
                results.add(info.getChannId());
            }
        }
        return results;
    }
    /**
     * 获取所有的渠道信息
     * @return
     */
    public static ArrayList<ChannelInfo> allChannels(){
        HttpClient client = new HttpClient();
        PostMethod post = new PostMethod(promoteUtils.commonUri+promoteUtils.allChannelsMethod);
        try {
            client.executeMethod(post);
            ChannelJsonInfo result = JSON.parseObject(post.getResponseBodyAsString(),ChannelJsonInfo.class);
            if (result.getStatus()){
                return result.getData();
            }
            return null;
        } catch (IOException e) {
            logger.error(e.getMessage());
            return null;
        }
    }

    /**
     * 获取所有渠道标签
     * @return
     */
    private static ArrayList<ChannelTagSerInfo> allChannelTags(){
        HttpClient client = new HttpClient();
        PostMethod post = new PostMethod(promoteUtils.commonUri+promoteUtils.allChannelTagMethod);
        try {
            client.executeMethod(post);
            ChannelTagJsonInfo result = JSON.parseObject(post.getResponseBodyAsString(),ChannelTagJsonInfo.class);
            if (result.getStatus()){
                return result.getData();
            }
            return null;
        } catch (IOException e) {
            logger.error(e.getMessage());
            return null;
        }
    }

    /**
     * 渠道标签信息
     * @return
     */
    public static Map<Integer,ChannelTagSerInfo> listAllChannelTagIfs(){
        Map<Integer,ChannelTagSerInfo> results = new HashMap<>();
        for (ChannelTagSerInfo info:allChannelTags()){
            if (!results.containsKey(info.getId())){
                results.put(info.getId(),info);
            }
            results.replace(info.getId(),info);
        }
        return results;
    }
    /**
     * 获取所有的渠道信息
     * @return
     */
    public static Map<Long,ChannelInfo> listAllChannelIfs(){
        Map<Long,ChannelInfo> results = new HashMap<Long,ChannelInfo>();
        for (ChannelInfo channelInfo:allChannels()){
            if (!results.containsKey(channelInfo.getChannId())){
                results.put(channelInfo.getChannId(),channelInfo);
            }
            results.replace(channelInfo.getChannId(),channelInfo);
        }
        return results;
    }

    /**
     * 通过tag获取渠道信息
     * @return
     */
    public static ArrayList<Long> getChannelsByTag(int tag){
        return allChannelsByTag(tag);
    }
}
