package com.yusj.magpie.jvm.trace;

/**
 * @Description
 * @Author kakalgy
 * @Date 2018/12/10 21:10
 **/
public class PrintHeapTest1 {
    public static void main(String[] args) {

        byte[] b=new byte[1*1024*1024];
        System.out.println("分配了1M空间给数组");

        b=new byte[4*1024*1024];
        System.out.println("分配了4M空间给数组");

        System.gc();


        System.out.print("Xmx=");
        System.out.println(Runtime.getRuntime().maxMemory() / 1024.0 / 1024 + "M");

        System.out.print("free mem=");
        System.out.println(Runtime.getRuntime().freeMemory() / 1024.0 / 1024 + "M");

        System.out.print("total mem=");
        System.out.println(Runtime.getRuntime().totalMemory() / 1024.0 / 1024 + "M");

    }
}
