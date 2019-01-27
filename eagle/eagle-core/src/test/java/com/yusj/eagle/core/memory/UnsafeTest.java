package com.yusj.eagle.core.memory;

import org.junit.Test;

/**
 * @Author kakalgy
 * @Date 2019/1/27 22:15
 **/
public class UnsafeTest {
    @SuppressWarnings("restriction")
    protected static final sun.misc.Unsafe UNSAFE = MemoryUtils.UNSAFE;

    @Test
    public void testArrayBaseOffset() {
        System.out.println(UNSAFE.arrayBaseOffset(byte[].class));
        System.out.println(UNSAFE.arrayBaseOffset(byte[].class));

        int[] arr = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};

        int b = UNSAFE.arrayBaseOffset(int[].class);
        System.out.println(b);

        int s = UNSAFE.arrayIndexScale(int[].class);
        System.out.println(s);

        UNSAFE.putInt(arr, (long) b + s * 9, 1);

        for (int i = 0; i < 10; i++) {

            int v = UNSAFE.getInt(arr, (long) b + s * i);

            System.out.print(v + " ");

        }
    }
}
