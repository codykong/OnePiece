package com.xten.op.algorithm.heap;

import com.google.gson.Gson;

import java.security.InvalidParameterException;

/**
 * 最大堆
 * User: kongqingyu
 * Date: 2017/7/31
 * Time: 上午11:56
 */
public class MaxHeap {

    private final Comparable[] array ;
    private int current;

    public MaxHeap(int size){
        array = new Comparable[size+1];
        current = 0;
    }

    public void insert(Comparable c){
        if (current >= array.length -1){
            throw new InvalidParameterException("heap is full");
        }
        current++;

        for(int i = current ; i>=1; i = i/2){
            if (i == 1 || array[i/2].compareTo(c)>=0){
                array[i] = c;
                break;
            }else {
                array[i] = array[i/2];
            }
        }
    }

    public Comparable getTop(){
        if (current < 1){
            throw new InvalidParameterException("heap is empty");
        }

        return array[1];
    }

    public Comparable pop(){
        Comparable c = getTop();

        Comparable min = array[current];
        current --;
         int last =1;

        for(int i = 1 ;i < current; ){
            int right = i*2 +1;
            if(right <= current && array[right].compareTo(array[i*2]) > 0 ){
                array[i] = array[right];
                i = right;

            }else {
                array[i] = array[i*2];
                i = i*2;
            }

            last= i;
        }

        array[last] = min;





        return c;
    }

    @Override
    public String toString() {
        return new Gson().toJson(this);
    }

    public static void main(String[] args) {

        MaxHeap heap = new MaxHeap(8);

        heap.insert(1);
        System.out.println(heap.toString());
        heap.insert(2);
        System.out.println(heap.toString());
        heap.insert(3);
        System.out.println(heap.toString());
        heap.insert(4);
        System.out.println(heap.toString());
        heap.insert(3);
        System.out.println(heap.toString());
        heap.insert(3);
        System.out.println(heap.toString());
        System.out.println(heap.pop());
        System.out.println(heap.toString());

    }




}
