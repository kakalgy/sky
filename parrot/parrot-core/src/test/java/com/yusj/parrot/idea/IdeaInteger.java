package com.yusj.parrot.idea;

import org.junit.Test;

public class IdeaInteger {
    /**
     * 将字符串转换为int型的参数
     * 除了十进制，还可以将二进制的字符串，16进制的字符串转换为int
     */
    @Test
    public void testParseInt() {
        String s1 = "10";

        System.out.println(Integer.parseInt(s1, 10));
        System.out.println(Integer.parseInt(s1, 2));
        System.out.println(Integer.parseInt(s1, 16));

        //当字符串不符合16进制规范抛出异常
        String s = "t4";
        System.out.println(Integer.parseInt(s, 16));
    }
}
