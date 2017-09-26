package com.xten.op.tree;

import java.util.Stack;

/**
 * Created with IntelliJ IDEA.
 * User: kongqingyu
 * Date: 2016/12/16
 * Time: 下午5:41
 */
public class StackTest {

    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();

        stack.push(1);
        Integer i = stack.peek();
        i = stack.pop();
        System.out.println(i);

    }
}
