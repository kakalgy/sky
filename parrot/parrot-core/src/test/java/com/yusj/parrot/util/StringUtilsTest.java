package com.yusj.parrot.util;

import org.junit.Test;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

public class StringUtilsTest {
    /**
     * 测试@Nonnull和@Nullable，目前看来并没有什么检测，只是加上注解
     */
    @Test
    public void testNonnullAnnotation() {
        nonNull(null);
        nullable(null);
    }

    private void nonNull(@Nonnull String str) {
        System.out.println(str);
    }

    private void nullable(@Nullable String str) {
        System.out.println(str);
    }


    /**************************
     * 移位运算
     **************************/
    /**
     * 左移运算：
     * 右边空出的位用0填补，高位左移溢出则舍弃该高位。
     * 计算机中常用补码表示数据，注，用补码计算
     */
    @Test
    public void testLeftMove() {
        int a = 8;//00001000
        a = 8 << 2;//00100000=32
        System.out.println(a);

        int b = -8;
        /*
         *首先计算-8的补码:
            原码：10000000 00000000 00000000 00001000
            反码：11111111 11111111 11111111 11110111
            补码：11111111 11111111 11111111 11111000
            左移：11111111 11111111 11111111 11100000
            反码：11111111 11111111 11111111 11011111
            原码：10000000 00000000 00000000 00100000
         */
        b = b << 2;//-32
        System.out.println(b);

        /**
         * 原码：10000000 00000000 00000000 00100000
         * 反码：11111111 11111111 11111111 11011111
         * 补码：11111111 11111111 11111111 11100000
         */
        b = b << 26;
        System.out.println(b);
        b = b << 1;
        System.out.println(b);//说明左移到最后是包括符号位的
        System.out.println(Integer.MIN_VALUE);
    }

    /**
     * 右移运算：
     * 左边空出的位用0或者1填补。正数用0填补，负数用1填补。
     * 注：不同的环境填补方式可能不同；低位右移溢出则舍弃该位。
     */
    @Test
    public void testRightMove() {
        int a = 8;//00001000
        a = 8 >> 2;//00000010=2
        System.out.println(a);

        int b = -8;
        /*
         *首先计算-8的补码:
            原码：10000000 00000000 00000000 00001000
            反码：11111111 11111111 11111111 11110111
            补码：11111111 11111111 11111111 11111000
            右移：11111111 11111111 11111111 11111110
            反码：11111111 11111111 11111111 11111101
            原码：10000000 00000000 00000000 00000010
         */
        b = b >> 2;//-2
        System.out.println(b);

        b = b >> 3;//-1
        System.out.println(b);//已经到最终位置 11111111 11111111 11111111 11111111
    }

    /**
     * 无符号右移：
     * 正数与右移规则一样，负数的无符号右移，就是相应的补码移位所得，在高位补0即可
     * 注意：无符号右移包含符号位，即负数符号位也会右移，变成正数
     */
    @Test
    public void testNoSymbolRightMove() {
        int a = 8;//00001000
        a = 8 >>> 2;//00000010=2
        System.out.println(a);

        int b = -8;
        /*
         *首先计算-8的补码:
            原码：10000000 00000000 00000000 00001000
            反码：11111111 11111111 11111111 11110111
            补码：11111111 11111111 11111111 11111000
       无符号右移：00111111 11111111 11111111 11111110
            反码：00111111 11111111 11111111 11111101
            原码：11000000 00000000 00000000 00000010
         */
        b = b >>> 2;//-2
        System.out.println(b);
    }

    /**
     * 测试byte数组转换为16进制字符串
     */
    @Test
    public void testByteToHexString() {
        byte a = 1;
        byte b = 4;
        byte c = 8;
        byte d = 16;
        byte[] array = new byte[]{a, b, c, d};
        System.out.println(StringUtils.byteToHexString(array));
    }

    /**
     * 测试byte数组转换为16进制字符串
     */
    @Test
    public void testHexStringToByte() {
        String s = "10a23c";
        byte[] b = StringUtils.hexStringToByte(s);
        for (byte b1 : b) {
            System.out.println((int) b1);
        }
    }

    /**
     * 测试对象为Array类型时，轮询toString()转换为字符串
     */
    @Test
    public void testArrayToString() {
        int[] i = new int[]{1, 2, 3};
        System.out.println(StringUtils.arrayToString(i));
        char[] c = new char[]{'d', 'r', 'g'};
        System.out.println(StringUtils.arrayToString(c));
    }
}
