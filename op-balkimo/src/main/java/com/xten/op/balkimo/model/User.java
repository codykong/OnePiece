package com.xten.op.balkimo.model;

/**
 * Created with IntelliJ IDEA.
 * User: kongqingyu
 * Date: 2017/1/6
 * Time: 上午10:49
 */
public class User {

    private Integer id;
    private String name;

    public User(){}

    public User(Integer id){
        this.id = id;
    }

    public User(Integer id,String name){
        this.id = id;
        this.name = name;
    }

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
