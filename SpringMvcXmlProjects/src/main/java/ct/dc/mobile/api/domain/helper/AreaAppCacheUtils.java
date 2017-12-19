package ct.dc.mobile.api.domain.helper;

import com.alibaba.fastjson.JSON;
import ct.dc.libredis.impl.RedisImpl;
import ct.dc.libredis.model.RedisConfigInfo;
import ct.dc.mobile.api.model.domain.areaApp.AreaAppLoginByDayDo;
import ct.dc.mobile.api.model.domain.areaApp.AreaAppLoginDetailsByDayDo;
import org.springframework.beans.factory.annotation.Value;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by B41-80 on 2017/1/19.
 */
public class AreaAppCacheUtils {
    private static RedisImpl redisUtils;
    private static int expireTime;
    private static String host;
    private static Integer port;
    private static String password;
    private static Integer database;
    private static Integer timeout;
    private static Integer maxActive;
    private static Integer maxIdle;
    private static Integer maxWait;
    private static Boolean testOnBorrow;

    @Value("${redis.host}")
    public void setHost(String host) {
        this.host = host;
    }
    @Value("${redis.port}")
    public void setPort(Integer port) {
        this.port = port;
    }
    @Value("${redis.pass}")
    public void setPassword(String password) {
        this.password = password;
    }

    @Value("${redis.database}")
    public void setDatabase(Integer database) {
        this.database = database;
    }

    @Value("${redis.timeout}")
    public void setTimeout(Integer timeout) {
        this.timeout = timeout;
    }

    @Value("${redis.maxActive}")
    public void setMaxActive(Integer maxActive) {
        this.maxActive = maxActive;
    }

    @Value("${redis.maxIdle}")
    public void setMaxIdle(Integer maxIdle) {
        this.maxIdle = maxIdle;
    }

    @Value("${redis.maxWait}")
    public void setMaxWait(Integer maxWait) {
        this.maxWait = maxWait;
    }

    @Value("${redis.testOnBorrow}")
    public void setTestOnBorrow(Boolean testOnBorrow) {
        this.testOnBorrow = testOnBorrow;
    }

    @Value("${redis.expireTime}")
    public void setExpireTime(int expireTime) {
        this.expireTime = expireTime;
    }

    /**
     * 获取redis工具类
     * @return
     */
    private static RedisImpl getRedisUtils(){
        if (redisUtils == null){
            RedisConfigInfo config = new RedisConfigInfo();
            config.setDatabase(database);
            config.setHost(host);
            config.setMax_active(maxActive);
            config.setMax_idle(maxIdle);
            config.setMax_wait(maxWait);
            config.setPort(port);
            config.setTest_on_borrow(testOnBorrow);
            config.setTimeout(timeout);
            config.setPassword(password);
            redisUtils = new RedisImpl(config);
        }
        return redisUtils;
    }
    /**
     * 通过缓存获取二合一级界面的数据
     * @return
     */
    public static ArrayList<AreaAppLoginByDayDo> getParamCache(int begin,int end,String areaId){
        String key = getTheCacheKey(begin,end,areaId);
        return (ArrayList<AreaAppLoginByDayDo>)serializeRedisStr(getRedisUtils().getString(key),AreaAppLoginByDayDo.class);
    }

    /**
     * 通过缓存获取二合二级界面的数据
     * @return
     */
    public static ArrayList<AreaAppLoginDetailsByDayDo> getParamCache(int begin,int end,long app,String areaId){
        String key = getTheCacheKey(begin,end,app,areaId);
        return (ArrayList<AreaAppLoginDetailsByDayDo>)serializeRedisStr(getRedisUtils().getString(key),AreaAppLoginDetailsByDayDo.class);
    }

    /**
     * 设置一级界面的缓存
     */
    public static void  setParamCache(int begin,int end,String value,String areaId){
        String key = getTheCacheKey(begin,end,areaId);
        redisUtils.setString(key,expireTime,value);
    }

    /**
     * 设置二级界面的缓存
     */
    public static void setParamCache(int begin,int end,long app,String value,String areaId){
        String key = getTheCacheKey(begin,end,app,areaId);
        redisUtils.setString(key,expireTime,value);
    }
    /**
     * 获取缓存的key
     * @return
     */
    private static String getTheCacheKey(int begin,int end,long app,String areaId){
        return String.format("Mobile_Area_%d_%d_%s_%d",begin,end,areaId,app);
    }

    /**
     * 获取缓存的key
     * @return
     */
    private static String getTheCacheKey(int begin,int end,String areaId){
        return String.format("Mobile_Area_%d_%d_%s",begin,end,areaId);
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
