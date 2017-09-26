package com.xten.op.algorithm.dynamic;

/**
 * 对于0及26个字母分别对于0-26数字，举例如下：
 * [0,A,B,C,D,E,F,G.....U ,V ,W ,X ,Y ,Z]
 * [0,1,2,3,4,5,6,7.....21,22,23,24,25,26]
 *
 * 对于一系列数据，如：121212 ，列出对应可能的字母组合，如[ABABAB,AUBAB....]
 * User: kongqingyu
 * Date: 2017/7/10
 * Time: 下午8:43
 */
public class NumMappingPrograming {

// 设计思路：使用动态规划的思想，重点如下：
// 1.找出f(n) 与 f(n-1) 之间的关系
// 2.找到f(1) 的初始值

    static String[] chars = {"0","A","B","C","D","E","F","G","H","I","J","K","L","M","N","O","P","Q",
    "R","S","T","U","V","W","X","Y","Z"};

    public static void main(String[] args) {
        int[] param = {1,2,6};
        int num = f(param.length,param);
        System.out.println(num);
    }


    private static int f(int n,int[] param){
        if (n>=2 && (param[n-2]*10+param[n-1])<=26){
            return f(n-1,param) + f(n-2,param);
        }else if (n >=1){
            return f(n-1,param);
        }else{
            return 1;
        }

    }

    private static String getChar(int num){
        return chars[num];
    }



}
