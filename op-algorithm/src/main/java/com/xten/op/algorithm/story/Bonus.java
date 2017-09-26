package com.xten.op.algorithm.story;

/**
 * 题目：狐进行了一次黑客马拉松大赛，全公司一共分为了N个组，每组一个房间排成一排开始比赛，比赛结束后没有公布成绩，
 * 但是每个组能够看到自己相邻的两个组里比自己成绩低的组的成绩，比赛结束之后要发奖金，以1w为单位，每个组都至少会发1w的奖金，
 * 另外，如果一个组发现自己的奖金没有高于比自己成绩低的组发的奖金，就会不满意，作为比赛的组织方，
 * 根据成绩计算出至少需要发多少奖金才能让所有的组满意。

 输入描述：
 每组数据先输入N，然后N行输入N个正整数，每个数表示每个组的比赛成绩。

 输出描述：
 输出至少需要多少w的奖金
 http://mp.weixin.qq.com/s/ge3GwwUKL1gjs6Y61CUt2g
 * User: kongqingyu
 * Date: 2017/7/25
 * Time: 上午10:43
 */
public class Bonus {

//    分析：
//    常量：比赛成绩数组
//    限制：
//        1. 每组至少发1w奖金
//        2. 奖金要高于左右两边比自己成绩低的组
//        3. 排成一排
//    目标：最小奖金数
//
//    表达式：if
//    思考：只需要保证高于左右两边即可，因此进行两次遍历，第一次保证比左边的高，第二次保证比右边的高

    public static void main(String[] args) {
        int[] scores = {1,3,6,4,1,7,9};
        int[] bonus =  {1,2,3,2,1,2,3};

        System.out.println(minScore(scores));


    }

    private static int minScore(int[] scores){

        int[] bonuses = new int[scores.length];

        int defaultBonus = 1;

        for (int i=0;i < scores.length;i++){

            if (i > 0 && scores[i] > scores[i-1]){
                bonuses[i] = bonuses[i-1] +1;
            }else {
                bonuses[i] = defaultBonus;
            }

        }

        int total = 0;

        for (int i= scores.length-1 ; i>=0 ;i--){
            if (i < scores.length-1 && scores[i] > scores[i+1]){
                bonuses[i] = bonuses[i+1] +1;
            }

            total += bonuses[i];
        }

        return total;

    }


}
