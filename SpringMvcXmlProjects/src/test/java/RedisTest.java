import ct.dc.libredis.impl.RedisImpl;
import ct.dc.libredis.model.RedisConfigInfo;

/**
 * Created by B41-80 on 2017/1/20.
 */
public class RedisTest {
    public static void main(String[] args){
        RedisConfigInfo config = new RedisConfigInfo();

        RedisImpl redis = new RedisImpl(config);
    }
}
