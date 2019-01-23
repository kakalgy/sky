package com.yusj.magpie.jvm.classloading;

/**
 * @Description
 * @Author kakalgy
 * @Date 2019/1/6 22:31
 **/
public class ClinitClassTest {
    static {
        i = 0;
        //这里的i由于顺序的原因，可以赋值，但是不能访问
//        System.out.println(i);
    }
    static int i=1;
}
