package com.xten.op.algorithm.binary;

/**
 * Description:
 * User: kongqingyu
 * Date: 2017/8/28
 */
public class IntToBinary {

    public static void main(String[] args) {
        int sum = add(1,3);
        System.out.println(sum);

        System.out.println('a' < 'b');
    }

    public static int add(int x, int y) {
        if (y == 0) return x;
        int sum, carry;
        sum = x ^ y;
        carry = (x & y) << 1;
        return add(sum, carry);
    }


    public static String toFullBinaryString(int num) {
        char[] chs = new char[Integer.SIZE];
        for(int i = 0; i < Integer.SIZE; i++) {
            chs[Integer.SIZE - 1 - i] = (char)(((num >> i) & 1) + '0');
        }
        return new String(chs);
    }


    public static char[] toBinary(String s) {
        char[] res = s.toCharArray();



        System.out.println(res[0] == 'A');
        System.out.println(res);

        return res;
    }
}
