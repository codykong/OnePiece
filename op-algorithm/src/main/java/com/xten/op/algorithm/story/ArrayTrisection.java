package com.xten.op.algorithm.story;

import com.xten.op.algorithm.sort.ArrayUtil;
import com.xten.op.common.util.PrintUtil;

/**
 * 任意数分三组,使得每组的和尽量相等
 * User: kongqingyu
 * Date: 2017/1/3
 * Time: 下午5:11
 */
public class ArrayTrisection {

    public static void main(String[] args) {
        int[] array = ArrayUtil.generate(10,100);
        PrintUtil.printJson(array);
        trisectInSort(array);
    }

    /**
     * 使用选择排序,当选出最大的数据时即可以加到最小的和上
     * @param array
     */
    private static void trisectInSort(int[] array){
        int sum1 =0,sum2 = 0,sum3 =0;
        int temp =0;
        for (int i =0; i < array.length;i++){
            temp = array[i];
            for (int j = i+1;j <array.length; j++){
                if (array[j] > temp){
                    int a = temp;
                    temp = array[j];
                    array[j] = a;
                }

            }

            if (sum1 <= sum2 && sum1 <= sum3 ){
                sum1 = sum1 +temp;
            }else if (sum2 <=sum3){
                sum2 = sum2 +temp;
            }else {
                sum3 = sum3 + temp;
            }



        }
        System.out.println(sum1);
        System.out.println(sum2);
        System.out.println(sum3);
    }

    /**
     * 先排序,再从最大值开始,取出值放到最小的和中
     * @param array
     */
    private static void trisect(int[] array){
        array = sortDesc(array);
        PrintUtil.printJson(array);
        int sum1 =0,sum2 = 0,sum3 =0;
        for (int i =0;i < array.length;i++){
            if (sum1 <= sum2 && sum1 <= sum3 ){
                sum1 = sum1 +array[i];
            }else if (sum2 <=sum3){
                sum2 = sum2 +array[i];
            }else {
                sum3 = sum3 + array[i];
            }
        }

        System.out.println(sum1);
        System.out.println(sum2);
        System.out.println(sum3);


    }

    private static int[] sortDesc(int[] array){
        int temp;
        for (int i =0;i < array.length -1; i++){
            for (int j =0; j <array.length-i-1;j++){
                if (array[j] < array[j+1]){
                    temp = array[j];
                    array[j] = array[j+1];
                    array[j+1] = temp;
                }

            }
        }

        return array;
    }
}
