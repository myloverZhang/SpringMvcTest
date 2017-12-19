import ct.dc.mobile.api.utils.date.DateUtils;

import java.util.Date;

/**
 * Created by B41-80 on 2017/1/10.
 */
public class DateUtilsTest {
    public static void main(String[] args){
//        int date = 20171101;
//        System.out.println(DateUtils.StringToDate("2016-01-01"));
//        if (DateUtils.isDate(date)){
//            System.out.println("True");
//        }else {
//            System.out.println("False");
//        }
//
//        String dateString = "2016-12-01";
//        System.out.println(DateUtils.addDay(dateString,-4));
        Date date1 = new Date();
        System.out.println(date1);
        int results = DateUtils.DateToInt(date1);
        System.out.println(DateUtils.IntToDate(results));
        System.out.println(results);
    }
}
