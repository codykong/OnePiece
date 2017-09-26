package com.xten.op.balkimo.gvm.memory;

/**
 * Created with IntelliJ IDEA.
 * User: kongqingyu
 * Date: 2017/1/17
 * Time: 上午10:14
 */
public class StringMem {

    public static void main(String[] args) {
//        String s =new String("abc");
        String a = "ab"+"c";
        String b = "abc";


        System.out.println(a == b);
    }
}
