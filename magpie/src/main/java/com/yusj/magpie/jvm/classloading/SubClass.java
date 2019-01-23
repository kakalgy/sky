package com.yusj.magpie.jvm.classloading;

/**
 * @Description
 * @Author kakalgy
 * @Date 2019/1/6 19:43
 **/
public class SubClass extends SuperClass {
    static {
        System.out.println("SubClass init!");
    }
}
