package com.xten.op.algorithm.programme;

import com.xten.op.common.util.PrintUtil;

/**
 * 最大子数组
 * User: kongqingyu
 * Date: 2016/12/30
 * Time: 上午11:49
 */
public class MaxSonArray {

    public static void main(String[] args) {

//        int[] array = ArrayUtil.generateIncludeNegative();
        int[] array = {-5,-2};
        PrintUtil.printJson(array);
        max(array);
    }

    /**
     *
     * @param array
     */
    public static void max(int[] array){

        if (array.length>0){
            // 记录本阶段内的最大值
            int max = array[0];

            int temp = array[0];
            for (int i =1 ;i < array.length;i++){
                // 如果前置相加是负数，则无需关注前置，从新开始记录
                if (temp < 0){
                    temp =0;
                }
                temp = temp + array[i];
                if (max < temp){
                    max = temp;
                }

            }

            System.out.println(max);
        }

    }


}
