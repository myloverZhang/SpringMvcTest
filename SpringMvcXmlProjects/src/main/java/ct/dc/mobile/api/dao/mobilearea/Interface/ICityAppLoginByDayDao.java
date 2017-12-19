package ct.dc.mobile.api.dao.mobilearea.Interface;

import ct.dc.mobile.api.model.po.mobileapp.AppAreaLoginByDayPo;
import ct.dc.mobile.api.model.po.mobileapp.AppAreaLoginDetailByDayPo;
import ct.dc.mobile.api.model.po.mobilearea.AreaAppLoginByDayPo;
import ct.dc.mobile.api.model.po.mobilearea.AreaAppLoginDetailsByDayPo;

import java.util.ArrayList;
import java.util.concurrent.ExecutionException;

/**
 * Created by B41-80 on 2017/1/11.
 */
public interface ICityAppLoginByDayDao {
    ArrayList<AppAreaLoginDetailByDayPo> findDetail(long app, String areaId, int begin, int end) throws ExecutionException, InterruptedException;

    ArrayList<AppAreaLoginByDayPo> findFull(long app, int begin, int end) throws ExecutionException, InterruptedException;

    ArrayList<AreaAppLoginByDayPo> findFull(int begin, int end, String city) throws ExecutionException, InterruptedException;

    ArrayList<AreaAppLoginDetailsByDayPo> findDetails(int begin, int end, long app, String city) throws ExecutionException, InterruptedException;

}
