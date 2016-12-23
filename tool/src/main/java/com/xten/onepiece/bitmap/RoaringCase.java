package com.xten.onepiece.bitmap;

import org.roaringbitmap.RoaringBitmap;

/**
 * Created with IntelliJ IDEA.
 * User: kongqingyu
 * Date: 2016/12/6
 * Time: 上午10:30
 */
public class RoaringCase {

    public static void main(String[] args) {
        RoaringBitmap bitmap= new RoaringBitmap();
        bitmap.add(1);
        bitmap.add(-1);
        System.out.println(bitmap.getCardinality());
    }
}
