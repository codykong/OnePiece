package com.xten.op.algorithm.tree;


import com.google.gson.Gson;
import com.xten.op.common.util.PrintUtil;

import java.util.Random;

/**
 * Created with IntelliJ IDEA.
 * User: kongqingyu
 * Date: 2016/12/26
 * Time: 下午3:35
 */
public class TreeUtil {

    public static void main(String[] args) {
        BinaryNode node = new BinaryNode(0,7);
        generateBinary(node);
        PrintUtil.printJson(node);
    }

    public static BinaryNode generateBinary(String json){
        BinaryNode node =new Gson().fromJson(json,BinaryNode.class);
        return node;
    }

    /**
     * 随机生成树
     * @param node
     */
    public static void generateBinary(BinaryNode node){
        Random random = new Random();

        if (random.nextInt(node.getLevel())>2){
            BinaryNode left =new BinaryNode(random.nextInt(100),node.getLevel() -1 );
            node.setLeft(left);
            generateBinary(left);
        }

        if (random.nextInt(node.getLevel())>2){
            BinaryNode right =new BinaryNode(random.nextInt(100),node.getLevel() -1);
            node.setRight(right);
            generateBinary(right);
        }
    }
}
