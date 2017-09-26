package com.xten.op.datatype;

/**
 * Created with IntelliJ IDEA.
 * User: kongqingyu
 * Date: 2017/1/3
 * Time: 下午8:53
 */
public class StringCase {
    public static void main(String[] args) {
        String str ="abc";
        String str1 ="abc";
        String str2 = new String("abc");
        System.out.println(str == str1);
        System.out.println(str == "abc");
        System.out.println(str == str2);
        String str3 = "ab" + "c";
        System.out.println(str == str3);
    }
}
