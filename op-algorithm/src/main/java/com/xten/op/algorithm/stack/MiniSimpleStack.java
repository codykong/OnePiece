package com.xten.op.algorithm.stack;

import java.util.EmptyStackException;
import java.util.Stack;

/**
 * 最小栈，要求实现栈的进栈、出栈及O(1)时间复杂度下获取最小值
 * User: kongqingyu
 * Date: 2017/7/7
 * Time: 下午7:03
 */
public class MiniSimpleStack<T> {
    private final Object[] elements ;
    private final int capacity;
    private int elementCount = 0;

    public MiniSimpleStack(int capacity){
        if (capacity<=0){
            throw new IllegalArgumentException("capacity must >0");
        }
        this.elements = new Object[capacity];
        this.capacity = capacity;
    }

    public synchronized void push(T value){
        if (elementCount >= capacity){
            throw new IllegalArgumentException("stack is full");
        }
        elementCount++;
        elements[elementCount] = value;
    }

    public synchronized T pop(){
        if (elementCount <= 0){
            throw new EmptyStackException();
        }
        T obj = peek();
        elementCount--;
        return obj;
    }

    public synchronized boolean isEmpty(){
        return elementCount==0;
    }

    public synchronized T peek(){
        if (elementCount >= capacity){
            throw new IllegalArgumentException("stack is full");
        }
        return (T)elements[elementCount-1];
    }

    public static void main(String[] args) {
        int capacity = 3;
        MiniSimpleStack opStack = new MiniSimpleStack<Integer>(capacity);
        for (int i = 0; i < capacity; i++) {
            opStack.push(i);

        }

        System.out.println(opStack.peek());
        System.out.println(opStack.pop());
        System.out.println(opStack.peek());

        Stack<String> stack = new Stack<>();


    }

}
