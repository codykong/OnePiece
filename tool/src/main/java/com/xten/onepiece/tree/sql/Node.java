package com.xten.onepiece.tree.sql;

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
    private FilterLogicalExpression occur;
    private boolean data;
    private Boolean leftData;
    private Boolean rightData;
    private int level;

    public boolean calc(){
        return occur.calc(leftData,rightData);
    }

    public Node(){}

    public Node(FilterLogicalExpression expression){
        this.occur = expression;
    }

    public Node(boolean data){
        this.data = data;
    }

    public Node(boolean data,FilterLogicalExpression expression,int level){
        this.data = data;
        this.occur = expression;
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

    public boolean getData() {
        return data;
    }

    public void setData(boolean data) {
        this.data = data;
    }


    public FilterLogicalExpression getOccur() {
        return occur;
    }

    public void setOccur(FilterLogicalExpression occur) {
        this.occur = occur;
    }

    public Boolean getLeftData() {
        return leftData;
    }

    public void setLeftData(Boolean leftData) {
        this.leftData = leftData;
    }

    public Boolean getRightData() {
        return rightData;
    }

    public void setRightData(Boolean rightData) {
        this.rightData = rightData;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }
}
