package com.xten.onepiece.tree;

import com.google.gson.Gson;

import java.util.Random;
import java.util.Stack;

/**
 * Created with IntelliJ IDEA.
 * User: kongqingyu
 * Date: 2016/12/16
 * Time: 下午3:15
 */
public class LRD {

    static int value = 1;

    public static void main(String[] args) {

        Node root = new Node(value,7);
        generateNode(root);
        System.out.println(root.toString());
        LRD(root);

    }

    public static void DLR(Node root){
        if (root == null){
            return;
        }

        Stack<Node> stack = new Stack<>();
        stack.push(root);

        while (!stack.isEmpty()){

        }
    }

    public static void LDR(Node root){
        if (root == null){
            return;
        }

        Stack<Node> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()){
            while (stack.peek().getLeft() != null){
                stack.push(stack.peek().getLeft());
            }
            Node p = stack.pop();
            System.out.println(p.getData());


            if (!stack.isEmpty()){

                p = stack.pop();
                System.out.println(p.getData());

                stack.push(p.getRight());
            }

        }

    }

    public static void LRD(Node root){

        Stack<Node> stack = new Stack<>();

        stack.push(root);

        Node node = root;
        while (!stack.isEmpty()){
            while (stack.peek().getLeft() !=null){
                stack.push(stack.peek().getLeft());
            }

            while (!stack.isEmpty() && (stack.peek().getRight()==null || stack.peek().getRight().getData()==node.getData())){
                node = stack.pop();
                System.out.println(node.getData());

            }

            if (!stack.isEmpty() && stack.peek().getRight()!=null){
                stack.push(stack.peek().getRight());
            }

        }

    }

    public static void generateNode(Node node){
        Random random = new Random();

        if (random.nextInt(node.getLevel())>2){
            value ++;
            Node left =new Node(value,node.getLevel()-1);
            node.setLeft(left);
            generateNode(left);

            value ++;
            Node right =new Node(value,node.getLevel()-1);
            node.setRight(right);
            generateNode(right);
        }


    }





}
