package com.xten.op.algorithm.story;

/**
 * Created with IntelliJ IDEA.
 * User: kongqingyu
 * Date: 2017/4/17
 * Time: 下午3:11
 */
public class AvgAge {

    public static void main(String[] args) {

        int age = avgAge(0.2d,5,5,1,3);
        System.out.println(age);

    }

    private static int avgAge(double leaveRate,int num,int avgAge,int now,int need){

        double newAge = Math.ceil((1-leaveRate)*(avgAge+1)+21*leaveRate);

        if (now <need){
            return avgAge(leaveRate,num,(int) newAge,now+1,need);
        }



        return (int)newAge;

    }
}
