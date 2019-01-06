package com.yusj.magpie.jvm.trace;

import java.util.Vector;

/**
 * @Description
 * @Author kakalgy
 * @Date 2018/12/11 21:27
 **/
public class OOMDumpTest {
    public static void main(String[] args) {
        Vector v = new Vector();
        for (int i = 0; i < 25; i++)
            v.add(new byte[1 * 1024 * 1024]);
    }
}
