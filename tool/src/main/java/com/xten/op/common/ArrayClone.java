package com.xten.op.common;

/**
 * Created with IntelliJ IDEA.
 * User: kongqingyu
 * Date: 2016/12/21
 * Time: 上午11:03
 */
public class ArrayClone {

    public static void main(String[] args) {

        Boolean[] a =new Boolean[2];
        a[0] = true;
        a[1] = false;
//        Boolean[] b = Arrays.copyOf(a,a.length);
//        System.out.println(new Gson().toJson(b));
//        System.out.println(b.length);
        System.out.println(a[0]);

    }
}
