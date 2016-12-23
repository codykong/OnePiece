package com.xten.onepiece.tree.sql;


import java.util.Random;
import java.util.Stack;

/**
 * Created with IntelliJ IDEA.
 * User: kongqingyu
 * Date: 2016/12/20
 * Time: 下午1:01
 */
public class LogicalCalc {

    public static void main(String[] args) {

//        Node node = generateNode();
        Node node = new Node(true,FilterLogicalExpression.AND,7);
        autoGenerateNode(node);
        System.out.println(node);
        System.out.println(calc(node));

    }

    /**
     * 按照树的后序遍历,利用stack实现不递归计算结果
     * @param root
     */
    public static boolean calc(Node root){

        Stack<Node> stack = new Stack<>();

        stack.push(root);

        Node node = root;
        boolean res =true;
        while (!stack.isEmpty()){
            // 遍历左子树,直到叶子节点
            while (stack.peek().getLeft() !=null){
                stack.push(stack.peek().getLeft());
            }

            // 如果是叶子节点或右子树已经被遍历过的父节点,则进行逻辑计算
            while (!stack.isEmpty() && (stack.peek().getRight()==null || stack.peek().getRight()==node)){

                node = stack.pop();

                // 判断左右子树,并将值赋给父节点
                if (!stack.isEmpty()){
                    if (stack.peek().getLeft()== node){
                        boolean tempData = node.getData();
                        while (!stack.isEmpty() && ((stack.peek().getOccur().equals(FilterLogicalExpression.AND) && tempData ==false)
                                || (stack.peek().getOccur().equals(FilterLogicalExpression.OR) && tempData ==true))){
                            node = stack.pop();
                            node.setData(tempData);
                        }
                        if (!stack.isEmpty()){
                            stack.peek().setLeftData(node.getData());
                        }

                    }else {
                        Node pNode = stack.peek();
                        pNode.setRightData(node.getData());
                        pNode.setData(pNode.getOccur().calc(pNode.getLeftData(),pNode.getRightData()));
                        res = node.getData();
                    }
                }

            }

            // 将右子树压如栈中
            if (!stack.isEmpty() && stack.peek().getRight()!=null){
                stack.push(stack.peek().getRight());
            }

        }

        return res;


    }

    public static void autoGenerateNode(Node node){
        Random random = new Random();

        if (random.nextInt(node.getLevel())>2){
            FilterLogicalExpression expression = FilterLogicalExpression.OR;
            if (random.nextBoolean()){
                expression = FilterLogicalExpression.AND;
            }
            Node left =new Node(random.nextBoolean(),expression,node.getLevel()-1);
            node.setLeft(left);
            autoGenerateNode(left);

            if (random.nextBoolean()){
                expression = FilterLogicalExpression.OR;
            }
            Node right =new Node(random.nextBoolean(),expression,node.getLevel()-1);
            node.setRight(right);
            autoGenerateNode(right);
        }
    }

    public static Node generateNode(){
        Node root = new Node(FilterLogicalExpression.AND);
        Node a =new Node(true);
        Node b =new Node(false);
        Node aAndB = new Node(FilterLogicalExpression.AND);
        aAndB.setLeft(a);
        aAndB.setRight(b);
        root.setLeft(aAndB);

        Node cAndD = new Node(FilterLogicalExpression.AND);
        root.setRight(new Node(true));

        return root;

    }
}
