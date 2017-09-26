package com.xten.op.balkimo.others;

/**
 * Created with IntelliJ IDEA.
 * User: kongqingyu
 * Date: 2017/1/4
 * Time: 下午7:55
 */
public class GenericsCase {

    public static void main(String[] args) {
        Deal<String> deal = new Deal();
        deal.add("aaaa");
        System.out.println(deal.get(0));

        Deal<Integer> deal1 = new Deal<>();
        deal1.add(123);
        System.out.println(deal1.get(0));
    }


}
