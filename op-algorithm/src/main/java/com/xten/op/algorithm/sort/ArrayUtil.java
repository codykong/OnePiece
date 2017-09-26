package com.xten.op.algorithm.sort;

import com.xten.op.common.util.PrintUtil;

import java.util.Random;

/**
 * Created with IntelliJ IDEA.
 * User: kongqingyu
 * Date: 2016/12/26
 * Time: 上午11:17
 */
public class ArrayUtil {

    public static void main(String[] args) {

        PrintUtil.printJson(generate());
    }

    public static int[] generate(){
        Random random =new Random();
        int[] array =new int[random.nextInt(10)];
        for (int i=0;i<array.length;i++){
            array[i] = random.nextInt(10);
        }

        return array;
    }

    /**
     * 按要求产生一个数组
     * @param maxSize 最大容量
     * @param maxValue 最大值
     * @return
     */
    public static int[] generate(int maxSize,int maxValue){
        Random random =new Random();
        int[] array =new int[random.nextInt(maxSize)];
        for (int i=0;i<array.length;i++){
            array[i] = random.nextInt(maxValue);
        }

        return array;
    }

    public static int[] generateIncludeNegative(){
        Random random =new Random();
        int[] array =new int[random.nextInt(10)];
        for (int i=0;i<array.length;i++){
            array[i] = random.nextInt(10);

            if (random.nextBoolean()){
                array[i] = 0-array[i];
            }
        }

        return array;
    }
}
