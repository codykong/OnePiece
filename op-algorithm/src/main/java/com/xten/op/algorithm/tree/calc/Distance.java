package com.xten.op.algorithm.tree.calc;

import com.xten.op.algorithm.tree.BinaryNode;
import com.xten.op.algorithm.tree.TreeUtil;
import com.xten.op.common.util.PrintUtil;

/**
 * Created with IntelliJ IDEA.
 * User: kongqingyu
 * Date: 2016/12/26
 * Time: 下午3:32
 */
public class Distance {

    private static int max =0;
    public static void main(String[] args) {
        BinaryNode node =new BinaryNode(0,7);
        TreeUtil.generateBinary(node);
        PrintUtil.printJson(node);
        maxLeafDistance(node);
        System.out.println(max);

    }

    private static int maxLeafDistance(BinaryNode node){
        int leftDept = 0;
        int rightDept = 0;

        if (node.getLeft() !=null){
            leftDept = maxLeafDistance(node.getLeft())+1;
        }

        if (node.getRight()  !=null){
            rightDept = maxLeafDistance(node.getRight())+1;
        }

        if (max < leftDept +rightDept){
            max = leftDept +rightDept;
        }

        if (leftDept > rightDept){
            return leftDept;
        }else {
            return rightDept;
        }





    }


}
