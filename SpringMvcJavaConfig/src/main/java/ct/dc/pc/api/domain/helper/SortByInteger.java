package ct.dc.pc.api.domain.helper;

import java.util.Comparator;

/**
 * Created by B41-80 on 2017/3/3.
 */
public class SortByInteger implements Comparator{

    @Override
    public int compare(Object o1, Object o2) {
        Integer integer1 = (Integer)o1;
        Integer integer2 = (Integer)o2;
        if (integer1>integer2)
            return 1;
        if (integer1<integer2)
            return -1;
        if (integer1 == integer2)
            return 0;
        return 0;
    }
}
