package com.xten.op.algorithm.tree.traverse;

import com.xten.op.algorithm.tree.BinaryNode;
import com.xten.op.algorithm.tree.TreeUtil;
import com.xten.op.common.util.PrintUtil;

import java.util.Stack;

/**
 * Created with IntelliJ IDEA.
 * User: kongqingyu
 * Date: 2017/6/19
 * Time: 上午11:12
 */
public class InOrderTraverse {

    public static void main(String[] args) {

        BinaryNode node = new BinaryNode(0,7);
        TreeUtil.generateBinary(node);
        PrintUtil.printJson(node);
        inTraverse(node);
        traverse(node);

    }

    public static void inTraverse(BinaryNode node){
        if (node == null){
            return;
        }

        Stack<BinaryNode> stack = new Stack<>();
        stack.push(node);
        while (!stack.isEmpty()){
            while (stack.peek().getLeft() != null){
                stack.push(stack.peek().getLeft());
            }
            BinaryNode p = stack.pop();
            System.out.println(p.getData());


            if (!stack.isEmpty()){

                p = stack.pop();
                System.out.println(p.getData());

                stack.push(p.getRight());
            }

        }
    }

    public static void traverse(BinaryNode node){


        Stack<BinaryNode> stack = new Stack();
        stack.push(node);
        while (!stack.isEmpty()){
            while (stack.peek().getLeft() !=null ){
                stack.push(stack.peek().getLeft());
            }

            BinaryNode left = stack.pop();

            if (!stack.isEmpty()){
                BinaryNode p = stack.peek();
                p.setLeft(null);
            }


            if (left.getRight()!=null){
                stack.push(left.getRight());
            }

            System.out.println(left.getData());

        }



    }
}
