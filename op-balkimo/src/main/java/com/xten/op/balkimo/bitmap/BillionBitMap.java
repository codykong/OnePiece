package com.xten.op.balkimo.bitmap;

import org.roaringbitmap.RoaringBitmap;
import org.roaringbitmap.longlong.LongBitmapDataProvider;
import org.roaringbitmap.longlong.Roaring64NavigableMap;

import java.util.Random;

/**
 * Description:
 * User: kongqingyu
 * Date: 2017/9/12
 */
public class BillionBitMap {


    public static void main(String[] args) {

        Random random = new Random();

        RoaringBitmap r = RoaringBitmap.bitmapOf();

        int i =0;

        while (i < 2000000000){
            r.add(random.nextInt(2000000000));
            i++;

            if(i % 3000000 ==1){
                System.out.println(i);
            }

        }

        System.out.println(r.getSizeInBytes());

    }
}
