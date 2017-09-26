package com.xten.op.balkimo.invoked;

import java.lang.invoke.MethodHandle;
import java.lang.invoke.MethodHandles;
import java.lang.invoke.MethodType;

/**
 * Created with IntelliJ IDEA.
 * User: kongqingyu
 * Date: 2017/4/1
 * Time: 下午4:11
 */
public class InvokedDynamic {

    public static void main(String[] args) {


        Object rcvr = "a";
        try {
            MethodType mt = MethodType.methodType(int.class);
            MethodHandles.Lookup l = MethodHandles.lookup();
            MethodHandle mh = l.findVirtual(rcvr.getClass(), "hashCode", mt);

            int ret;
            try {
                ret = (int)mh.invoke(rcvr);
                System.out.println(ret);
            } catch (Throwable t) {
                t.printStackTrace();
            }
        } catch (IllegalArgumentException | NoSuchMethodException | SecurityException e) {
            e.printStackTrace();
        } catch (IllegalAccessException x) {
            x.printStackTrace();
        }

    }
}
