package com.xten.drools.duplicate;

import com.google.gson.Gson;

/**
 * Created with IntelliJ IDEA.
 * User: kongqingyu
 * Date: 2017/4/5
 * Time: 下午7:57
 */
public class DuplicateFact {

    public DuplicateFact(Integer id,Integer type){
        this.id = id;
        this.type =type;
    }

    private Integer id ;
    private Integer type;
    private int res;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public int getRes() {
        return res;
    }

    public void setRes(int res) {
        this.res = res;
    }


    @Override
    public String toString() {
        return new Gson().toJson(this);
    }
}
