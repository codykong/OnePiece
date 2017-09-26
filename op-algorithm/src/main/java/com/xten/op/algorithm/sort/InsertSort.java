package com.xten.op.algorithm.sort;

import com.xten.op.common.util.PrintUtil;

/**
 * Created with IntelliJ IDEA.
 * User: kongqingyu
 * Date: 2016/12/26
 * Time: 下午2:45
 */
public class InsertSort {

    public static void main(String[] args) {
        int[] array = ArrayUtil.generate();
        PrintUtil.printJson(array);
        insertSort(array);
        PrintUtil.printJson(array);

    }

    public static void insertSort(int[] array){
        if (array.length>1){
            int start = array.length -2 ;
            while (start>=0){
                int temp = array[start];
                for (int i = start+1 ;i <array.length;i++){
                    if (temp > array[i]){
                        array[i-1] = array[i];
                    }else {
                        array[i-1] = temp;
                        break;
                    }
                }

                if (temp > array[array.length-1]){
                    array[array.length-1] = temp;
                }
                start --;
            }
        }

    }

    public static void sort(int[] array){

        if (array.length>1){
            int start =array.length-2;

            while (start >= 0){
                int temp = array[start];
                for (int i = start +1;i < array.length ;i ++ ){
                    if (temp > array[i]){
                        array[i-1] = array[i];
                        array[i] = temp;
                    }else {
                        break;
                    }
                }
                start --;
            }
        }

    }

    public static void sortCopy(int[] array){
        if (array == null){
            System.out.println("array is null");
        }else if (array.length >1){

            int start = array.length -2;
            int temp;
            while (start >=0){
                temp = array[start];
                for (int i = start +1;i<array.length;i++){
                    if (temp > array[i]){
                        array[i-1] = array[i];
                        array[i] = temp;
                    }else {
                        break;
                    }
                }
                start --;
            }
        }
    }

    public static void sort2(int[] array){
        if (array.length>1){
            int start = array.length-2;
            int temp;
            while (start>=0){
                temp =array[start];
                for (int i = start+1;i<array.length;i++){
                    if (array[start] > array[i]){
                        temp = array[i];
                        array[i] = temp;
                        array[start] =temp;
                    }else {
                        break;
                    }
                }
                start--;
            }
        }
    }
}
