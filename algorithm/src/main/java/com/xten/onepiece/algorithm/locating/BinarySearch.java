package com.xten.onepiece.algorithm.locating;

import com.xten.onepiece.common.util.PrintUtil;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

/**
 * Created with IntelliJ IDEA.
 * User: kongqingyu
 * Date: 2016/12/21
 * Time: 下午4:28
 */
public class BinarySearch {

    public static void main(String[] args) {

        int[] array = {1,3,5,6};
//        search(array,1);
        System.out.println(searchWithoutRecursion(array,5));
    }

    public static int searchWithoutRecursion(int[] array,int expected){
        int low = 0;
        int high = array.length-1;
        int index = -1;
        while (low <= high){
            int mid = (low + high)/2;
            if (array[mid] == expected){
                index = mid;
                break;
            }else if (array[mid] > expected){
                high = mid -1;
            }else {
                low = mid +1;
            }
        }
        return index;
    }

    /**
     * 使用递归,计算中间数的算法 mid = (a+b)/2
     * @param array 需要计算的数组
     * @param expected 需要的值
     * @param low 下限
     * @param high 上限
     * @return
     */
    public static int searchWithRecursion(int[] array,int expected,int low,int high){

        if (low > high){
            return -1;
        }

        int mid = (low + high)/2;
        if (array[mid] > expected){
            return searchWithRecursion(array,expected,low,mid-1);
        }else if (array[mid] < expected){
            return searchWithRecursion(array,expected,mid+1,high);
        }
        return mid;

    }

    public static void search(int[] array,int expected){
        int index = -1;
        if (array.length!=0){
            int start = 0;
            int end = array.length -1;
            boolean b =true;
            while (b){
                int point = (end - start)/2 +start  ;
                if (end-start == 1 ){
                    if (array[start]==expected){
                        index =start;
                        b= false;
                    }else if (array[end]==expected){
                        index = end;
                        b= false;
                    }else {
                        System.out.println("not found");
                        b= false;
                    }

                }else if (array[point]==expected){
                    index = point;
                    b= false;
                }else if (array[point] > expected){
                    end = point;
                }else {
                    start = point;
                }
            }

        }

        System.out.println(index);
    }





    public static int[] buildASCArray(){
        Random random =new Random();
//        int size = random.nextInt(10);
        int[] array = {1,4,6,8,9,12};
//        for (int i=0;i<size;i++){
//            array[i] = random.nextInt(10);
//        }
//
//        Arrays.sort(array);

        return array;

    }
}
