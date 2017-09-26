package com.xten.op.algorithm.tree.traverse;

import com.xten.op.algorithm.tree.BinaryNode;
import com.xten.op.algorithm.tree.TreeUtil;
import com.xten.op.common.util.PrintUtil;

import java.util.Stack;

/**
 * Created with IntelliJ IDEA.
 * User: kongqingyu
 * Date: 2017/6/19
 * Time: 上午10:57
 */
public class PostOrderTraverse {

    public static void main(String[] args) {
        BinaryNode node = new BinaryNode(0,7);
        TreeUtil.generateBinary(node);
        PrintUtil.printJson(node);
        traverse(node);
    }


    public static void traverse(BinaryNode node){

        Stack<BinaryNode> stack = new Stack<>();
        stack.push(node);
        BinaryNode right = node;

        while (!stack.isEmpty()){
            while (stack.peek().getLeft()!=null && stack.peek().getRight()!=right){
                stack.push(stack.peek().getLeft());
            }

            if (!stack.isEmpty() && stack.peek().getRight()!=null && stack.peek().getRight()!=right){
                stack.push(stack.peek().getRight());
            }else {
                right = stack.pop();
                System.out.println(right.getData());
            }
        }

    }

}
