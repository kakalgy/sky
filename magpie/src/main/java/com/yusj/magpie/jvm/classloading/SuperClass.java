package com.yusj.magpie.jvm.classloading;

/**
 * @Description
 * @Author kakalgy
 * @Date 2019/1/6 19:43
 **/
public class SuperClass {

    static {
        System.out.println("SuperClass init!");
    }

    public static int value = 123;
}
