package com.yusj.magpie.jvm.classloading.bootstrap;

/**
 * @Description
 * @Author kakalgy
 * @Date 2019/1/13 19:25
 **/
public class FindClassOrder {
    /**
     * 使用参数-Xbootclasspath/a:E:\Battle
     **/
    public static void main(String args[]) {
        HelloLoader loader = new HelloLoader();
        loader.print();
    }
}
