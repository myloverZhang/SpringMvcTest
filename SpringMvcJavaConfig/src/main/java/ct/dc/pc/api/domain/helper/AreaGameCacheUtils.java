package ct.dc.pc.api.domain.helper;

import com.alibaba.fastjson.JSON;
import ct.dc.libredis.impl.RedisImpl;
import ct.dc.libredis.model.RedisConfigInfo;
import ct.dc.pc.api.model.domain.merge.MergeLoginByDayDo;
import ct.dc.pc.api.model.domain.merge.MergeLoginDetailByDayDo;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by B41-80 on 2017/1/19.
 */
@PropertySource("classpath:redis.properties")
@Component
public class AreaGameCacheUtils {
    private static RedisImpl redisUtils;
    @Value("${redis.expireTime}")
    private int expireTime;
    @Value("${redis.host}")
    private String host;
    @Value("${redis.port}")
    private Integer port;
    @Value("${redis.pass}")
    private String password;
    @Value("${redis.database}")
    private Integer database;
    @Value("${redis.timeout}")
    private Integer timeout;
    @Value("${redis.maxActive}")
    private Integer maxActive;
    @Value("${redis.maxIdle}")
    private Integer maxIdle;
    @Value("${redis.maxWait}")
    private Integer maxWait;
    @Value("${redis.testOnBorrow}")
    private Boolean testOnBorrow;


    private static AreaGameCacheUtils areaGameCacheUtils;
    @PostConstruct
    public void init(){
        areaGameCacheUtils = this;
    }
    /**
     * 获取redis工具类
     * @return
     */
    private static RedisImpl getRedisUtils(){
        if (redisUtils == null){
            RedisConfigInfo config = new RedisConfigInfo();
            config.setDatabase(areaGameCacheUtils.database);
            config.setHost(areaGameCacheUtils.host);
            config.setMax_active(areaGameCacheUtils.maxActive);
            config.setMax_idle(areaGameCacheUtils.maxIdle);
            config.setMax_wait(areaGameCacheUtils.maxWait);
            config.setPort(areaGameCacheUtils.port);
            config.setTest_on_borrow(areaGameCacheUtils.testOnBorrow);
            config.setTimeout(areaGameCacheUtils.timeout);
            config.setPassword(areaGameCacheUtils.password);
            redisUtils = new RedisImpl(config);
        }
        return redisUtils;
    }
    /**
     * 通过缓存获取二合一级界面的数据
     * @return
     */
    public static ArrayList<MergeLoginByDayDo> getParamCache(int begin, int end, String areaId){
        String key = getTheCacheKey(begin,end,areaId);
        return (ArrayList<MergeLoginByDayDo>)serializeRedisStr(getRedisUtils().getString(key),MergeLoginByDayDo.class);
    }

    /**
     * 通过缓存获取二合二级界面的数据
     * @return
     */
    public static ArrayList<MergeLoginDetailByDayDo> getParamCache(int begin, int end, int game, String areaId){
        String key = getTheCacheKey(begin,end,game,areaId);
        return (ArrayList<MergeLoginDetailByDayDo>)serializeRedisStr(getRedisUtils().getString(key),MergeLoginDetailByDayDo.class);
    }

    /**
     * 设置一级界面的缓存
     */
    public static void  setParamCache(int begin,int end,String value,String areaId){
        String key = getTheCacheKey(begin,end,areaId);
        redisUtils.setString(key,areaGameCacheUtils.expireTime,value);
    }

    /**
     * 设置二级界面的缓存
     */
    public static void setParamCache(int begin,int end,int game,String value,String areaId){
        String key = getTheCacheKey(begin,end,game,areaId);
        redisUtils.setString(key,areaGameCacheUtils.expireTime,value);
    }
    /**
     * 获取缓存的key
     * @return
     */
    private static String getTheCacheKey(int begin,int end,int game,String areaId){
        return String.format("Dc.Pc_%d_%d_%s_%d",begin,end,areaId,game);
    }

    /**
     * 获取缓存的key
     * @return
     */
    private static String getTheCacheKey(int begin,int end,String areaId){
        return String.format("Dc.Pc_%d_%d_%s",begin,end,areaId);
    }

    /**
     * 序列化
     * @param redisString
     * @param <T>
     * @return
     */
    private static  <T> List<T> serializeRedisStr(String redisString, Class<T> type){
        if (redisString!=null){
            return JSON.parseArray(redisString,type);
        }
        return null;
    }
}
