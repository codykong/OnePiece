package com.xten.op.algorithm.story;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Description: http://lintcode.com/zh-cn/problem/sliding-window-unique-elements-sum/
 * User: kongqingyu
 * Date: 2017/9/25
 */
public class SlidingWindowUniqueElementSum {

    public static void main(String[] args) {
        int[] array = {1,2,1,3,3};
        System.out.println(sum(array,3));
    }


    public static int sum(int[] array,int size){

        int count = 0;

        Set<Integer> singleNum = new HashSet<>();
        Map<Integer,Integer> numCount = new HashMap<>();

        if (array == null || array.length == 0 || array.length < size){
            return 0;
        }

        for (int i =0; i<array.length;i++){

           add(singleNum,numCount,array[i]);
           if (i>=size-1){
               if (i > size -1){
                   remove(singleNum,numCount,array[i-size]);
               }

               count += singleNum.size();

           }

        }

        return count;



    }


    public static void add( Set<Integer> singleNum,Map<Integer,Integer> numCount,int num){

        int numC = numCount.getOrDefault(num,0);
        if (numC == 0){
            singleNum.add(num);
        }else {
            singleNum.remove(num);
        }

        numCount.put(num,numC+1);
    }

    public static void remove( Set<Integer> singleNum,Map<Integer,Integer> numCount,int num){

        int numC = numCount.getOrDefault(num,0);
        if (numC == 1){
            singleNum.remove(num);
            numCount.remove(num);
        }else if (numC == 2){
            singleNum.add(num);
            numCount.put(num,numC-1);
        }else {
            numCount.put(num,numC-1);
        }


    }
}
