package com.xten.op.algorithm.queue;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * Created with IntelliJ IDEA.
 * User: kongqingyu
 * Date: 2016/12/26
 * Time: 下午5:34
 */
public class QueueBasic {

    public static void main(String[] args) {
        Queue<Integer> queue = new ArrayDeque<>();
        queue.add(1);
        queue.add(2);
        queue.add(3);
        queue.add(4);
        queue.add(5);
        queue.add(6);
        queue.add(7);
        queue.offer(8);
        queue.poll();

        while (!queue.isEmpty()){
            queue.remove();

            System.out.println(queue.poll());

        }
    }
}
