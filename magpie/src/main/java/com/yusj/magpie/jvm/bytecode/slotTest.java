package com.yusj.magpie.jvm.bytecode;

/**
 * @Description
 * @Author kakalgy
 * @Date 2019/1/13 21:38
 **/
public class slotTest {
    /**
     * -XX:+PrintGCDetails
     * -verbose:gc
     * 查看slot是否会被重用，以及对垃圾回收的影响
     **/
    public static void main(String[] args) {
        //分为三种情况

        //第一种情况：
//        byte[] placeholder = new byte[64 * 1024 * 1024];
//        System.gc();

        //[GC (System.gc())  73431K->66336K(502784K), 0.0201657 secs]
        //[Full GC (System.gc())  66336K->66194K(502784K), 0.0055720 secs]

        //第二种情况：
//        {
//            byte[] placeholder = new byte[64 * 1024 * 1024];
//        }
//        System.gc();

        //[GC (System.gc())  73431K->66384K(502784K), 0.0297598 secs]
        //[Full GC (System.gc())  66384K->66194K(502784K), 0.0044176 secs]

        //第三种情况：
        {
            byte[] placeholder = new byte[64 * 1024 * 1024];
        }
        int aa = 0;
        System.gc();

        //[GC (System.gc())  73431K->816K(502784K), 0.0007151 secs]
        //[Full GC (System.gc())  816K->658K(502784K), 0.0108107 secs]

//        byte[] placeholder = new byte[64 * 1024 * 1024];
//        int aa = 0;
//        System.gc();

        //[GC (System.gc())  73431K->66336K(502784K), 0.0258781 secs]
        //[Full GC (System.gc())  66336K->66194K(502784K), 0.0138321 secs]
    }
}
