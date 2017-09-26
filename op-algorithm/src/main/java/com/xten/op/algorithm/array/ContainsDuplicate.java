package com.xten.op.algorithm.array;

import java.util.HashSet;
import java.util.Set;

/**
 * Created with IntelliJ IDEA.
 * User: kongqingyu
 * Date: 2017/4/21
 * Time: 上午11:52
 */
public class ContainsDuplicate {

    public static boolean useSet(int[] a){
        Set<Integer> set = new HashSet<>();
        for (int i : a){
            if (!set.add(i)){
                return true;
            }
        }

        return false;
    }

    public static boolean useBubbleSort(int[] a){
        if (a.length > 2){
            for (int i = a.length-1 ;i>0;i--){
                for (int j =0; j<i;j++){

                    if (a[j] == a[j+1]){
                        return true;
                    }else if (a[j] > a[j+1]){
                        int temp = a[j];
                        a[j] = a[j+1];
                        a[j=1] = temp;
                    }

                }
            }
        }
        return false;
    }
}
