package com.xten.op.balkimo.gvm.reference;

import java.lang.ref.SoftReference;

/**
 * 软引用在内存不足时就会被回收,适合用于实现内存敏感的高速缓存
 * User: kongqingyu
 * Date: 2017/1/4
 * Time: 下午7:50
 */
public class SoftReferenceCase {

    public static void main(String[] args) {

        String str = "abc";
        SoftReference<String> sr = new SoftReference(str);
        String s = sr.get();
        System.out.println(s);
    }
}
