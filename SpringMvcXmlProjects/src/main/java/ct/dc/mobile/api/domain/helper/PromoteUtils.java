package ct.dc.mobile.api.domain.helper;

import com.alibaba.fastjson.JSON;
import ct.dc.mobile.api.model.serialize.ChannelInfo;
import ct.dc.mobile.api.model.serialize.ChannelJsonInfo;
import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.methods.PostMethod;
import org.apache.log4j.Logger;
import org.bson.Document;
import org.springframework.beans.factory.annotation.Value;

import java.io.IOException;
import java.util.ArrayList;

/**
 * Created by B41-80 on 2017/1/19.
 */
public class PromoteUtils {
    private static String commonUri;
    private static String allChannelsMethod;
    private static Logger logger = Logger.getLogger(PromoteUtils.class);
    @Value("${dcCommonApi}")
    public void setCommonUri(String commonUri) {
        this.commonUri = commonUri;
    }

    @Value("${dcCommonApi.allChannels}")
    public void setAllChannelsMethod(String allChannelsMethod) {
        this.allChannelsMethod = allChannelsMethod;
    }

    /**
     * 获取所有的渠道信息
     * @return
     */
    public static ArrayList<ChannelInfo> allChannels(){
        HttpClient client = new HttpClient();
        PostMethod post = new PostMethod(commonUri+allChannelsMethod);
        try {
            client.executeMethod(post);
            String data = post.getResponseBodyAsString();
            ChannelJsonInfo result = JSON.parseObject(data,ChannelJsonInfo.class);
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
     * 通过tag获取渠道信息
     * @return
     */
    public static ArrayList<Long> getChannelsByTag(int tag){
        ArrayList<Long> results = new ArrayList<Long>();
        for (ChannelInfo info : allChannels()){
            if (info.getTags().contains(tag)){
                results.add(info.getChannId());
            }
        }
        return results;
    }
}
