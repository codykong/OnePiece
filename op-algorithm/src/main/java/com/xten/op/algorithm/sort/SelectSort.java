package com.xten.op.algorithm.sort;

import com.xten.op.common.util.PrintUtil;

/**
 * 选择排序
 * User: kongqingyu
 * Date: 2016/12/26
 * Time: 上午11:59
 */
public class SelectSort {

    public static void main(String[] args) {
        int[] array = ArrayUtil.generate();
        PrintUtil.printJson(array);
        sort(array);
    }

    public static void sort(int[] array){
        if (array.length >1){
            int min= 0;
            for (int i=0;i< array.length -1;i++){
                min = i;
                for (int j = i +1;j<array.length;j++){
                    if (array[min] > array[j]){
                        min = j;
                    }
                }
                if (min!=i){
                    int temp = array[i];
                    array[i] = array[min];
                    array[min] = temp;
                }


            }

        }

        PrintUtil.printJson(array);
    }

    public static void selectSort(int[] array){
        if (array.length >1){
            for (int i =0;i<array.length-1;i++){
                int small = i ;
                for (int j=0;j<array.length;j++){
                    if (array[small] >array[j]){

                    }
                }

            }
        }
    }
}
