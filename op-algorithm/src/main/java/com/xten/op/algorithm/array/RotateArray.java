package com.xten.op.algorithm.array;

import com.xten.op.common.util.PrintUtil;

/**
 * Created with IntelliJ IDEA.
 * User: kongqingyu
 * Date: 2017/4/21
 * Time: 上午11:27
 */
public class RotateArray {

    /**
     * 1. 对首位的字符进行位置调换
     * 2. 按照要求对字符串进行拆分
     * 2. 翻转两次，及恢复到原状态
     * @param args
     */
    public static void main(String[] args) {
        int[] a ={1,2,3,4,5,6,7,8};
        int k =3;
        PrintUtil.printJson(a);
        reverse(a,0,a.length-1);
        PrintUtil.printJson(a);
        reverse(a,0,k-1);
        PrintUtil.printJson(a);
        reverse(a,k,a.length-1);
        PrintUtil.printJson(a);
    }

    public static   void reverse(int[] a ,int l ,int r){

        while (l <r){
            int temp =a[l];
            a[l] = a[r];
            a[r] = temp;
            l++;
            r--;
        }
    }
}
