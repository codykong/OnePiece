package com.xten.op.algorithm.tree.calc;

import com.xten.op.algorithm.tree.BinaryNode;
import com.xten.op.algorithm.tree.TreeUtil;

import java.util.Stack;

/**
 * Created with IntelliJ IDEA.
 * User: kongqingyu
 * Date: 2016/12/26
 * Time: 下午4:39
 */
public class CommonAncestor {

    public static void main(String[] args) {

        BinaryNode node = TreeUtil.generateBinary("{\"left\":{\"left\":{\"data\":13,\"level\":5},\"right\":{\"left\":{\"data\":60,\"level\":4},\"right\":{\"right\":{\"data\":19,\"level\":3},\"data\":31,\"level\":4},\"data\":37,\"level\":5},\"data\":81,\"level\":6},\"right\":{\"left\":{\"left\":{\"right\":{\"data\":14,\"level\":3},\"data\":76,\"level\":4},\"right\":{\"left\":{\"data\":63,\"level\":3},\"right\":{\"data\":22,\"level\":3},\"data\":7,\"level\":4},\"data\":85,\"level\":5},\"right\":{\"left\":{\"data\":26,\"level\":4},\"data\":87,\"level\":5},\"data\":62,\"level\":6},\"data\":0,\"level\":7}");
//        TreeUtil.generateBinary(node);
//        PrintUtil.printJson(node);

        Stack<BinaryNode> ancestor = find(node,22);
        while (!ancestor.isEmpty()){
            node = ancestor.pop();
            System.out.println(node.getData());
        }
    }

    public static Stack find(BinaryNode root,int a){
        Stack<BinaryNode> stack = new Stack<>();
        Stack<BinaryNode> ancestor = new Stack<>();

        if (root ==null){
            System.out.println("not match");
        }

        stack.push(root);

        while (!stack.isEmpty()){

            while (stack.peek().getLeft() != null){
                stack.push(stack.peek().getLeft());
            }

            BinaryNode node = stack.pop();
            ancestor.push(node);
            if (node.getData()==a){
                return stack;
            }

//            if ((node.getData() == a || node.getData() == b) && ancestor.isEmpty()){
//                ancestor = (Stack<BinaryNode>) stack.clone();
//            }else {
//
//            }

            while (!stack.isEmpty() && (stack.peek().getRight() ==null || stack.peek().getRight()== node) ){

//                if ((node.getData() == a || node.getData() == b) && ancestor.isEmpty()){
//                    ancestor = (Stack<BinaryNode>) stack.clone();
//                }else {
//
//                }
                node = stack.pop();
                ancestor.push(node);
                if (node.getData()==a){
                    return stack;
                }
            }

            if (!stack.isEmpty() && stack.peek().getRight()!=null){
                stack.push(stack.peek().getRight());
            }

        }

        return ancestor;
    }
}
