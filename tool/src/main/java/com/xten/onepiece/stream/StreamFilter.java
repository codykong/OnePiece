package com.xten.onepiece.stream;

import com.google.common.collect.Lists;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created with IntelliJ IDEA.
 * User: kongqingyu
 * Date: 2016/12/21
 * Time: 下午3:09
 */
public class StreamFilter {

    public static void main(String[] args) {
        List<Integer> a = Lists.newArrayList(1,2,3,4,5,6,7);
        List<Integer> b= a.stream().filter(t -> t < 5).collect(Collectors.toList());
        System.out.println(a);
        System.out.println(b);
    }
}
