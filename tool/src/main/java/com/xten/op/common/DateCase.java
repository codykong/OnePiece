package com.xten.op.common;


import java.util.Calendar;

/**
 * Created with IntelliJ IDEA.
 * User: kongqingyu
 * Date: 2016/12/6
 * Time: 下午1:28
 */
public class DateCase {

    public static void main(String[] args) {
        Calendar calendar = Calendar.getInstance();
        calendar.set(2016,05,05);
        System.out.println(calendar.get(Calendar.DAY_OF_MONTH));
//        String dt= DateFormatUtils.format(calendar.getTime(),"yyyyMMdd");
//        System.out.println(dt);


    }
}
