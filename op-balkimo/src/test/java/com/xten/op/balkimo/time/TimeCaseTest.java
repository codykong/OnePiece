package com.xten.op.balkimo.time;


import org.junit.Test;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

/**
 * Created with IntelliJ IDEA.
 * User: kongqingyu
 * Date: 2017/6/5
 * Time: 下午6:08
 */
public class TimeCaseTest {

    @Test
    public void testLocalDate(){

        LocalDate today = LocalDate.now();
        System.out.println(today.toString());
    }

    @Test
    public void testDateFormat(){
        String day = "20170605";
        LocalDate format = LocalDate.parse(day, DateTimeFormatter.BASIC_ISO_DATE);
        System.out.printf("%s is %s",day,format);

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy MM dd");
        LocalDate format2 = LocalDate.parse("2017 01 01",formatter);
        System.out.printf("%s is %s",day,format2);
    }

}