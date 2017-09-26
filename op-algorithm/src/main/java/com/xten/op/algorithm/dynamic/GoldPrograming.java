package com.xten.op.algorithm.dynamic;

/**
 * 题目二： 国王和金矿

 * 有一个国家发现了5座金矿，每座金矿的黄金储量不同，需要参与挖掘的工人数也不同。参与挖矿工人的总数是10人。每座金矿要么全挖，要么不挖，不能派出一半人挖取一半金矿。要求用程序求解出，要想得到尽可能多的黄金，应该选择挖取哪几座金矿？
 * 链接：https://mp.weixin.qq.com/s?__biz=MzI2NjA3NTc4Ng==&mid=2652079324&idx=1&sn=b9ea93c3e30b3f85f3175d201b296ef3&chksm=f1748f39c603062ff669ea3507463cfeaa2a7c8aebbe6a03770229afc00614e40df9d7dc148a&mpshare=1&scene=1&srcid=0620ClrY2uB0aHUoQ1mLcnG5&key=f899fac88420dff123670364051fdee4bd44b6337ee96e7b3031220c803858339e23780a1bbc246eb38ca07a074f5bc8eef646853c0f602301f2f25ca7f00d27b610186c5a11ba1b1f2cc16de049ae2f&ascene=0&uin=NjM5MTM2NTIx&devicetype=iMac+MacBookPro11%2C2+OSX+OSX+10.12.4+build(16E195)&version=12020810&nettype=WIFI&fontScale=100&pass_ticket=caxPPTsypSNCrDu94d5%2FlJA5C6fHQXLnRRojjJm0Rz9nuv6FzIChcflmwRoW%2BVRI
 * User: kongqingyu
 * Date: 2017/6/20
 * Time: 上午10:56
 */
public class GoldPrograming {

    public static void main(String[] args) {

        int[] g= {400,500,200,300,350};
        int[] p = {5,5,3,4,3};

        System.out.println(gold(5,10,g,p));

    }

    /**
     * @param n 总金矿数
     * @param w 总工人数
     * @param g 金矿的黄金量
     * @param p 金矿的用工量
     * @return
     */
    public static int gold(int n,int w,int[] g,int[] p){

        int[] preResults = new int[w];
        int[] results = new int[w];

        // 设置只有一个金矿时的初始值
        for (int i =1 ;i <=w ; i++){
            if (i < p[0]){
                preResults[i-1] = 0;
            }else {
                preResults[i-1] = g[0];
            }
        }

        // 第一座金矿已经计算，则无需计算，从第二座金矿开始计算
        for (int i =1 ;i<n;i++){
            // j为了方便处理代表的是人数，对应数组中的下标为j-1
            for (int j=1;j<=w;j++){
                // 当该金矿所需人数大于给定人数时，取上一个金矿的金额
                if (j < p[i]){
                    results[j-1] = preResults[j-1];
                }else if(j==p[i]){
                    // 当金矿所需人数=给定人数时，取上一个金矿和本金矿的最大值
                    results[j-1] = Math.max(preResults[j-1],g[i]);
                }else{
                    // 否则采用带胎规划
                    results[j-1] = Math.max(preResults[j-1],preResults[j-1-p[i]]+g[i]);
                }
            }

            preResults = results;
            results = new int[w];
        }

        return  preResults[w-1];
    }
}
