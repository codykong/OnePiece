package com.xten.drools;

/**
 * Created with IntelliJ IDEA.
 * User: kongqingyu
 * Date: 2017/8/9
 * Time: 下午5:26
 */
public class Match {

    public static void main(String[] args) {

        String text ="abbed";

        Boolean res = text.matches(".*(abc|abd|abe)+.*") ;
        System.out.println(res);
    }
}
