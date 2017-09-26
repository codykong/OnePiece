package com.xten.op.algorithm.sort;

import com.xten.op.common.util.PrintUtil;

/**
 * Created with IntelliJ IDEA.
 * User: kongqingyu
 * Date: 2016/12/26
 * Time: 下午2:05
 */
public class QuickSort {


    public static void main(String[] args) {
        int[] array = ArrayUtil.generate();
//        int[] array = {4,3,9,9,0,4};
        PrintUtil.printJson(array);
        sort(array,0,array.length-1);
        PrintUtil.printJson(array);

    }

    public static void sort(int[] array,int left ,int right){


        int pivot = partition(array,left,right);
        if (pivot > left +1){
            sort(array,left,pivot-1);
        }

        if (right > pivot +1){
            sort(array,pivot+1,right);
        }


    }

    private static int partition(int[] array ,int left ,int right){

        // 寻找旋转点，取数组的中位数
        int middle = (left + right)/2;
        if (right-left >=3){
            sortUp(array,left,middle);
            sortUp(array,middle,right);
            sortUp(array,left,middle);
            left ++ ;
            right --;
        }

        int pivot = array[middle];
        swap(array,left,middle);

        while (left < right){
            while (left < right && array[right] >= pivot){
                right -- ;
            }
            array[left] = array[right];

            while (left < right && array[left] <= pivot ){
                left ++ ;
            }

            array[right] = array[left];

        }
        array[left] = pivot;

        return left;
    }

    private static void sortUp(int[] array ,int left,int right){
        if(array[left] > array[right]) {

            swap(array,left,right);
        }
    }

    private static void swap(int[] array ,int left,int right){
        int temp = array[left];
        array[left] = array[right];
        array[right] = temp;
    }

}
