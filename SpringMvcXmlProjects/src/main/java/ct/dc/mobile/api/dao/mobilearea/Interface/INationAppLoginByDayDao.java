package ct.dc.mobile.api.dao.mobilearea.Interface;

import ct.dc.mobile.api.model.po.mobilearea.AreaAppLoginByDayPo;
import ct.dc.mobile.api.model.po.mobilearea.AreaAppLoginDetailsByDayPo;

import java.util.ArrayList;
import java.util.concurrent.ExecutionException;

/**
 * Created by B41-80 on 2017/1/12.
 */
public interface INationAppLoginByDayDao {
    ArrayList<AreaAppLoginByDayPo> findFull(int begin, int end) throws ExecutionException, InterruptedException;

    ArrayList<AreaAppLoginDetailsByDayPo> findDetails(int begin, int end, long app) throws ExecutionException, InterruptedException;
}
