package com.xten.onepiece.tree;

import com.google.gson.Gson;

/**
 * Created with IntelliJ IDEA.
 * User: kongqingyu
 * Date: 2016/12/16
 * Time: 下午2:03
 */
public class Node {

    private Node left;
    private Node right;
    private String occur; //must or
    private int data;
    private int level;

    public Node(){}

    public Node(int data,int level){
        this.data = data;
        this.level = level;
    }

    @Override
    public String toString(){
        return new Gson().toJson(this);
    }

    public boolean hasChild(){
        return left!=null;
    }

    public Node getLeft() {
        return left;
    }

    public void setLeft(Node left) {
        this.left = left;
    }

    public Node getRight() {
        return right;
    }

    public void setRight(Node right) {
        this.right = right;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public int getData() {
        return data;
    }

    public void setData(int data) {
        this.data = data;
    }

    public String getOccur() {
        return occur;
    }

    public void setOccur(String occur) {
        this.occur = occur;
    }
}
