package com.xten.op.springboot.model;

/**
 * Created with IntelliJ IDEA.
 * User: kongqingyu
 * Date: 2017/1/9
 * Time: 下午5:04
 */
public class User {
    private Integer id;
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}
