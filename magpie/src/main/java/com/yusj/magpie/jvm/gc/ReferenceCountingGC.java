package com.yusj.magpie.jvm.gc;

/**
 * @Description 引用计数法的缺陷，testGC()方法执行后，objA和objB是否会被GC
 * @Author kakalgy
 * @Date 2018/12/12 21:09
 **/
public class ReferenceCountingGC {
    public Object instance = null;
    private static final int _1MB = 1024 * 1024;

    /**
     * 这个成员属相的唯一意义是占点内存，以便能在GC日志中看清楚是否被回收过
     **/
    private byte[] bigSize = new byte[2 * _1MB];

    public static void testGC() {
        ReferenceCountingGC objA = new ReferenceCountingGC();
        ReferenceCountingGC objB = new ReferenceCountingGC();
        objA.instance = objB;
        objB.instance = objA;

        objA = null;
        objB = null;

//假设在这行发生GC，objA和objB是否能被回收
        System.gc();
    }


    public static void main(String[] args) {
        testGC();
    }
}
