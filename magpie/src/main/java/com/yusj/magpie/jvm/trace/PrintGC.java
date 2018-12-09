package com.yusj.magpie.jvm.trace;

/**
 * @Description
 * @Author kakalgy
 * @Date 2018/12/9 20:35
 **/
public class PrintGC {

    public static void main(String[] args) {
        for (int i = 0; i < 1; i++) {
            for (int j = 0; j < 1000000; j++) {
                GCSimpleObject gcSimpleObject = new GCSimpleObject("kaka" + j, 18 + i);
            }
            System.gc();
        }
    }
}
