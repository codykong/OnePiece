package com.xten.kafka.demo;

/**
 * Created with IntelliJ IDEA.
 * User: kongqingyu
 * Date: 2017/5/23
 * Time: 下午2:00
 */
public class KafkaConsumerProducerDemo {
    public static void main(String[] args) {
        boolean isAsync = args.length == 0 || !args[0].trim().equalsIgnoreCase("sync");
        Producer producerThread = new Producer(KafkaProperties.TOPIC, isAsync);
        producerThread.start();

//        Consumer consumerThread = new Consumer(KafkaProperties.TOPIC);
//        consumerThread.start();

    }
}
