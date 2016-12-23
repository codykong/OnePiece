package com.xten.onepiece.algorithm.story;

/**
 * Created with IntelliJ IDEA.
 * User: kongqingyu
 * Date: 2016/12/22
 * Time: 下午9:23
 */
public class Rabbit {

    public static int month;
    public static int size;

    /**
     * 题目：古典问题：有一对兔子，从出生后第3个月起每个月都生一对兔子，
     * 小兔子长到第三个月后每个月又生一对兔子，假如兔子都不死，问每个月的兔子总数为多少？
     * @param args
     */
    public static void main(String[] args) {


        month = 7;

        if (month<=2){
            System.out.println(1);
        }else {
            calcRabbitNum(3,1,1);
            System.out.println(size);
        }

    }



    public static void calcRabbitNum(int m,int lastMonth,int monthBeforeLast){

        if (m == month){
            size = lastMonth + monthBeforeLast;
        }else {
            calcRabbitNum(m+1,lastMonth + monthBeforeLast,lastMonth);
        }
    }
}
