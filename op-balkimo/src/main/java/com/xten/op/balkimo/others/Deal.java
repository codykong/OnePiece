package com.xten.op.balkimo.others;

import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: kongqingyu
 * Date: 2017/1/4
 * Time: 下午7:56
 */
public class Deal<T> {

    private List<T> array;

    public Deal(){
        this.array = new ArrayList<>();
    }

    public void add(T val){
        array.add(val);
    }

    public T get(int index){
        return  array.get(index);
    }
}
