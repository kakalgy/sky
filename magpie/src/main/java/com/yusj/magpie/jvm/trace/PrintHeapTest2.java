package com.yusj.magpie.jvm.trace;

/**
 * @Description
 * @Author kakalgy
 * @Date 2018/12/10 22:24
 **/
public class PrintHeapTest2 {
    public static void main(String[] args) {
        byte[] b = null;
        for (int i = 0; i < 1000; i++) {
            b = new byte[1 * 1024 * 1024];
            System.out.println("--------------------------------------");
        }
        System.gc();
    }
}

//-XX:+UseSerialGC -XX:+PrintGCDetails
//-XX:+UseParNewGC -XX:+PrintGCDetails
//-XX:+UseParallelGC -XX:+PrintGCDetails
//-XX:+UseParallelOldGC -XX:+PrintGCDetails
//-XX:+UseConcMarkSweepGC -XX:+PrintGCDetails

