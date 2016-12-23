package com.xten.onepiece.common;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Created with IntelliJ IDEA.
 * User: kongqingyu
 * Date: 2016/12/22
 * Time: 下午3:16
 */
public class DoubleSet {

    public static void main(String[] args) {
        String a ="a";
        Object b =a;
        test((String) b);
    }

    private static void test(String a){
        System.out.println(a.equals("a"));
    }
}
