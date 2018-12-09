package com.yusj.magpie.jvm.trace;

/**
 * @Description
 * @Author kakalgy
 * @Date 2018/12/9 20:48
 **/
public class GCSimpleObject {
    private String name;
    private int age;

    public GCSimpleObject(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public GCSimpleObject() {
    }
}
