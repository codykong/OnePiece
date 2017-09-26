package com.xten.drools.fact;

import java.util.HashMap;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * User: kongqingyu
 * Date: 2017/4/11
 * Time: 下午3:30
 */
public class BaseFact {


    private int id;
    private boolean res;
    private int status;
    private String text;

    private Map<String,String> values = new HashMap<>();

    public boolean isRes() {
        return res;
    }

    public void setRes(boolean res) {
        this.res = res;
    }



    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Map<String, String> getValues() {
        return values;
    }

    public void setValues(Map<String, String> values) {
        this.values = values;
    }

    public void addValue(String key,String value) {
        values.put(key,value);
    }

    public String getValue(String key) {
        return values.get(key);
    }
}
