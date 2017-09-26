package com.xten.op.algorithm.tree.calc;

import com.xten.op.algorithm.sort.ArrayUtil;
import com.xten.op.algorithm.tree.BinaryNode;
import com.xten.op.common.util.PrintUtil;

/**
 * Created with IntelliJ IDEA.
 * User: kongqingyu
 * Date: 2016/12/28
 * Time: 下午7:58
 */
public class ArrayToTree {
    public static void main(String[] args) {

        int[] array = ArrayUtil.generate();
        PrintUtil.printJson(array);
        transform(array);
    }

    public static void transform(int[] array){
        if (array.length<1){
            System.out.println("null tree");
        }else {
            BinaryNode node = transform(array,0,array.length-1);
            PrintUtil.printJson(node);
        }

    }

    public static BinaryNode  transform(int[] array,int start,int end){
        if (start > end){
            return null;
        }else {
            int mid = (start + end) /2;
            BinaryNode node =new BinaryNode(array[mid]);
            node.setLeft(transform(array,start,mid-1) );
            node.setRight(transform(array,mid+1,end));
            return node;
        }


    }
}
