package com.yusj.magpie.jvm.classloading;

/**
 * @Description
 * @Author kakalgy
 * @Date 2019/1/6 19:56
 **/
public class ConstClass {
    static {
        System.out.println("Const Class init !");
    }

    public static final String he = "Hello world!!";
}
