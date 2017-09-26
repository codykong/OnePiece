package com.xten.op.balkimo.gvm.memory;

import com.xten.op.balkimo.model.User;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Created with IntelliJ IDEA.
 * User: kongqingyu
 * Date: 2017/1/6
 * Time: 上午10:48
 */
public class OutOfMemoryCase {

    public static void main(String[] args) {
        List<User> array = new ArrayList<>();
        while (true){
            array.add(new User(new Random().nextInt(),"aaaaaa"));
        }
    }
}
