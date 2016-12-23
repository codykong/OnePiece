package com.xten.drools.clock;

/**
 * Created with IntelliJ IDEA.
 * User: kongqingyu
 * Date: 2016/12/12
 * Time: 上午11:39
 */
public class Clock {
    private int hour;
    private int minute;
    private int second;

    @Override
    public String toString() {
        return hour + ":" + minute + ":" + second;
    }

    public int getSecond() {
        return second;
    }

    public void setSecond(int second) {
        this.second = second;
    }

    public int getMinute() {
        return minute;
    }

    public void setMinute(int minute) {
        this.minute = minute;
    }

    public int getHour() {
        return hour;
    }

    public void setHour(int hour) {
        this.hour = hour;
    }
}
