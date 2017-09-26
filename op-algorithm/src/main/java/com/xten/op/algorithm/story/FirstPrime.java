package com.xten.op.algorithm.story;

/**
 * Description: http://www.lintcode.com/zh-cn/problem/first-missing-prime-number/
 * User: kongqingyu
 * Date: 2017/9/26
 */
public class FirstPrime {


    public static void main(String[] args) {
        int[] array = {3,5,7};
        System.out.println(firstMissingPrime(array));
    }

    public static int firstMissingPrime(int[] array) {


        if (array == null || array.length == 0 || array[0] != 2) {
            return 2;
        }

        boolean isZhi = true;
        int index = 1;
        int num = 3;
        while (true) {

            for (int i = 0; i < index; i++) {
                if (num % array[i] == 0) {
                    isZhi = false;
                    break;
                }

            }

            if (isZhi && (index >= array.length || num < array[index])) {
                return num;
            } else if (isZhi && num == array[index]) {
                index++;
            }

            num++;
            isZhi = true;


        }
    }
}
