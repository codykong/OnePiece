package com.xten.op.algorithm.sort;

import com.xten.op.common.util.PrintUtil;

/**
 * 冒泡排序
 * User: kongqingyu
 * Date: 2016/12/26
 * Time: 上午11:25
 */
public class BubbleSort {
    public static void main(String[] args) {
        int[] array = ArrayUtil.generate();
        PrintUtil.printJson(array);
//        sort(array);
        bubbleSort(array);
    }

    public static void bubbleSort(int[] array){
        if (array.length>1){
            for (int i =array.length-1;i>0;i--){
                for(int j =0; j <i;j++){
                    if (array[j] > array[j+1]){
                        int a = array[j];
                        array[j] = array[j+1];
                        array[j+1] = a;
                    }
                }

            }
        }
        PrintUtil.printJson(array);



    }

    public static void sort(int[] array){
        if (array.length>1){
            for (int i=0;i<array.length - 1;i++){
                for (int j=0; j < array.length - i-1; j++){
                    if (array[j] > array[j+1]){
                        int temp = array[j+1];
                        array[j+1]=array[j];
                        array[j] = temp;
                    }
                }
            }
        }
        PrintUtil.printJson(array);
    }
}
