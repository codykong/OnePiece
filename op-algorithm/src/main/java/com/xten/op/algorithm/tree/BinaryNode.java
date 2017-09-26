package com.xten.op.algorithm.tree;

/**
 * Created with IntelliJ IDEA.
 * User: kongqingyu
 * Date: 2016/12/26
 * Time: 下午3:36
 */
public class BinaryNode {
    private BinaryNode left;
    private BinaryNode right;
    private int data;
    private int level;

    public BinaryNode(){}

    public BinaryNode(int data,int level){
        this.data = data;
        this.level = level;
    }

    @Override
    public String toString() {
        return String.valueOf(data);
    }

    public BinaryNode(int data){
        this.data = data;
    }

    public BinaryNode getLeft() {
        return left;
    }

    public void setLeft(BinaryNode left) {
        this.left = left;
    }

    public BinaryNode getRight() {
        return right;
    }

    public void setRight(BinaryNode right) {
        this.right = right;
    }

    public int getData() {
        return data;
    }

    public void setData(int data) {
        this.data = data;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }
}
