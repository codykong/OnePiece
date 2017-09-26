package com.xten.op.algorithm.story;

/**
 * Description:
 * User: kongqingyu
 * Date: 2017/8/30
 */
public class CrossString {

    public static void main(String[] args) {

        System.out.println(isCross("aabcc","dbbca","aadbbcbcac"));
    }

    public static boolean isCross(String a ,String b ,String c) {

        String abc = "a + b";
        char[] ca = a.toCharArray();
        char[] cb = b.toCharArray();
        char[] cc = c.toCharArray();

        int ai = 0;
        int bi = 0;

        int temp = 0;

        for(int i =0; i< cc.length ;i++) {
            if (ai+temp >= ca.length || bi+temp >= cb.length){
                return false;
            }else if (ca[ai+temp] == cc[i] && cb[bi+temp] == cc[i]) {
                temp++;
            }else if (ca[ai+temp] == cc[i]) {
                ai ++;
                temp = 0;
            }else  if (cb[bi+temp] == cc[i]) {
                bi ++;
                temp = 0;
            }else {
                return false ;
            }
        }

        return true;

    }
}
