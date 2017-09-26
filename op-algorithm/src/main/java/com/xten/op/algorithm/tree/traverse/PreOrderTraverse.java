package com.xten.op.algorithm.tree.traverse;

import com.xten.op.algorithm.tree.BinaryNode;
import com.xten.op.algorithm.tree.TreeUtil;
import com.xten.op.common.util.PrintUtil;

/**
 * Created with IntelliJ IDEA.
 * User: kongqingyu
 * Date: 2017/6/19
 * Time: 上午10:57
 */
public class PreOrderTraverse {

    public static void main(String[] args) {
        BinaryNode node = new BinaryNode(0,7);
        TreeUtil.generateBinary(node);
        PrintUtil.printJson(node);
        traverse(node);
    }

    public static void stackTraverse(BinaryNode node){


    }

    public static void traverse(BinaryNode node){

        System.out.println(node.getData());
        if (node.getLeft()!=null){
            traverse(node.getLeft());
        }

        if (node.getRight()!=null){
            traverse(node.getRight());
        }

    }

}
