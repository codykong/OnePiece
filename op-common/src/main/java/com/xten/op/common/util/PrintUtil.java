package com.xten.op.common.util;

import com.google.gson.Gson;

/**
 * Created with IntelliJ IDEA.
 * User: kongqingyu
 * Date: 2016/12/21
 * Time: 下午4:37
 */
public class PrintUtil {

    public static void printJson(Object o){
        System.out.println(new Gson().toJson(o));
    }
}
