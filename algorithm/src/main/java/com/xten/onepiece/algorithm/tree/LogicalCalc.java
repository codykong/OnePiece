package com.xten.onepiece.algorithm.tree;

import com.xten.onepiece.common.util.PrintUtil;

import java.util.Random;
import java.util.Stack;

/**
 * Created with IntelliJ IDEA.
 * User: kongqingyu
 * Date: 2016/12/22
 * Time: 上午11:41
 */
public class LogicalCalc {

    private static int size =0;

    public static void main(String[] args) {
        BooleanClauseNode node =new BooleanClauseNode(BooleanClauseNode.FilterLogicalExpression.AND,7);
        autoGenerateNode(node);
        boolean[] factors = new boolean[size];
        for (int i =0; i< factors.length ;i ++){
            factors[i] = new Random().nextBoolean();

        }
        PrintUtil.printJson(factors);

        System.out.println(calc(factors,node));

        PrintUtil.printJson(node);

    }



    /**
     * 按照树的后序遍历,利用stack实现不递归计算结果;
     * 如果左子树为true且条件为or,则肯定为true;如果左子树为false且条件为and,则肯定为false;则无需计算右子树
     * @param factors 以因子id为下标,结果为值生成的因子结果数组
     * @return
     */
    public static boolean calc(boolean[] factors,BooleanClauseNode root){

//        BooleanClauseNode root = booleanClauseNode;
        Stack<BooleanClauseNode> stack = new Stack<>();

        stack.push(root);

        BooleanClauseNode node = root;
        boolean res =true;
        while (!stack.isEmpty()){
            // 遍历左子树,直到叶子节点
            while (stack.peek().getLeft() !=null){
                stack.push(stack.peek().getLeft());
            }

            // 如果是叶子节点或右子树已经被遍历过的父节点,则进行逻辑计算
            while (!stack.isEmpty() && (stack.peek().getRight()==null || stack.peek().getRight()==node)){

                node = stack.pop();

                if (!node.hasChild()){
                    node.setData(factors[node.getIndex()]);
                }

                // 判断左右子树,并将值赋给父节点
                if (!stack.isEmpty()){
                    // 如果是叶子节点,则不进行处理
                    if (stack.peek().getLeft()== node){
                        boolean leftData = node.getData();
                        // 如果左子树为true且条件为or,则肯定为true;如果左子树为false且条件为and,则肯定为false;则无需计算右子树
                        while (!stack.isEmpty() && stack.peek().ignoreRight(leftData)){
                            node = stack.pop();
                            node.setData(leftData);
                            System.out.println(1);
                        }
                    }else {
                        // 在已知不能忽略右子树的前提下计算结果
                        stack.peek().setDataWithNotIgnoreRight(node.getData());
                    }

                }
                res = node.getData();

            }
            // 将右子树压如栈中
            if (!stack.isEmpty() && stack.peek().getRight()!=null){
                stack.push(stack.peek().getRight());
            }
        }
        return res;
    }

    /**
     * 随机生成树
     * @param node
     */
    public static void autoGenerateNode(BooleanClauseNode node){
        Random random = new Random();

        if (random.nextInt(node.getLevel())>2){
            BooleanClauseNode.FilterLogicalExpression expression = BooleanClauseNode.FilterLogicalExpression.OR;
            if (random.nextBoolean()){
                expression = BooleanClauseNode.FilterLogicalExpression.AND;
            }
            BooleanClauseNode left =new BooleanClauseNode(expression,node.getLevel()-1);
            node.setLeft(left);
            autoGenerateNode(left);
        }else {
            node.setLeft(new BooleanClauseNode(size));
            size = size +1;
        }

        if (random.nextInt(node.getLevel())>2){
            BooleanClauseNode.FilterLogicalExpression expression = BooleanClauseNode.FilterLogicalExpression.OR;
            if (random.nextBoolean()){
                expression = BooleanClauseNode.FilterLogicalExpression.AND;
            }
            BooleanClauseNode right =new BooleanClauseNode(expression,node.getLevel()-1);
            node.setRight(right);
            autoGenerateNode(right);
        }else {
            node.setRight(new BooleanClauseNode(size));
            size = size +1;
        }
    }

}
