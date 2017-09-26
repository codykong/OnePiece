package com.xten.op.algorithm.story;

import com.xten.op.common.util.PrintUtil;

import java.math.BigInteger;
import java.util.Base64;

/**
 * Created with IntelliJ IDEA.
 * User: kongqingyu
 * Date: 2017/1/3
 * Time: 下午8:24
 */
public class Base64Case {

    public static void main(String[] args) {

        String str ="123456";
        byte[] bytes =  Base64.getEncoder().encode(str.getBytes());
        PrintUtil.printJson(bytes);
        String a = Base64.getEncoder().encode(str.getBytes()).toString();
        System.out.println(a);
        PrintUtil.printJson(str.getBytes());
        PrintUtil.printJson(new BigInteger(1,str.getBytes()).toString(2));
    }
}
