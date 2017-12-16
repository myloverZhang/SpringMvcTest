package ct.dc.pc.api.dao.area.helper;

import ct.dc.pc.api.model.po.area.AreaLoginByDayPo;
import ct.dc.pc.api.model.po.area.AreaRetainByDayPo;
import org.bson.Document;

/**
 * Created by B41-80 on 2017/3/31.
 */
public class AreaLoginInfoHelper {
    /**
     * 解析查询到的数据库数据
     * @param result
     * @param hards
     * @param users
     */
    public static void getLoginDetailInfo(AreaLoginByDayPo result, Document hards,Document users){
        if (users!=null){
            result.setUsers1D1(users.getInteger("users1d1",0));
            result.setUsers3D1(users.getInteger("users3d1",0));
            result.setUsers7D1(users.getInteger("users7d1",0));
            result.setUsers14D1(users.getInteger("users14d1",0));
            result.setUsers30D1(users.getInteger("users30d1",0));
        }else {
            result.setUsers1D1(0);
            result.setUsers3D1(0);
            result.setUsers7D1(0);
            result.setUsers14D1(0);
            result.setUsers30D1(0);
        }
        if (hards!=null){
            result.setHards1D1(hards.getInteger("hards1d1",0));
            result.setHards3D1(hards.getInteger("hards3d1",0));
            result.setHards7D1(hards.getInteger("hards7d1",0));
            result.setHards14D1(hards.getInteger("hards14d1",0));
            result.setHards30D1(hards.getInteger("hards30d1",0));
        }else {
            result.setHards1D1(0);
            result.setHards3D1(0);
            result.setHards7D1(0);
            result.setHards14D1(0);
            result.setHards30D1(0);
        }
    }

    /**
     * 后期留存信息
     * @param info
     * @return
     */
    public static AreaRetainByDayPo getRetainInfo(Document info){
        AreaRetainByDayPo result = new AreaRetainByDayPo();
        result.setDate(info.getInteger("date",0));
        Document users = info.get("users",Document.class);
        Document hards = info.get("hards",Document.class);
        if (users!=null){
            result.setUsersD1(users.getInteger("d1",0));
            result.setUsersNew(users.getInteger("new",0));
            result.setUsersD3(users.getInteger("d3",0));
            result.setUsersD7(users.getInteger("d7",0));
            result.setUsersD14(users.getInteger("d14",0));
            result.setUsersD30(users.getInteger("d30",0));
        }else{
            result.setUsersD1(0);
            result.setUsersNew(0);
            result.setUsersD3(0);
            result.setUsersD7(0);
            result.setUsersD14(0);
            result.setUsersD30(0);
        }
        if (hards!=null){
            result.setHardsNew(hards.getInteger("new",0));
            result.setHardsD1(hards.getInteger("d1",0));
            result.setHardsD3(hards.getInteger("d3",0));
            result.setHardsD7(hards.getInteger("d7",0));
            result.setHardsD14(hards.getInteger("d14",0));
            result.setHardsD30(hards.getInteger("d30",0));
        }else {
            result.setHardsNew(0);
            result.setHardsD1(0);
            result.setHardsD3(0);
            result.setHardsD7(0);
            result.setHardsD14(0);
            result.setHardsD30(0);
        }
        return result;
    }
}
