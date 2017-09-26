package com.xten.op.algorithm.story;

/**
 * User: kongqingyu
 * Date: 2016/12/27
 * Time: 下午7:39
 */
public class DaffodilNumber {

    public static void main(String[] args) {
        for (int i=100;i<1000;i++){
            int hNumber = i /100;
            int tNumber = i %10/10;
            int num = i % 100;

            if (i == (hNumber * hNumber * hNumber + tNumber * tNumber * tNumber + num * num *num)){
                System.out.println(i);
            }
        }
    }
}
