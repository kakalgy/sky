package com.yusj.parrot.core.memory;

import org.junit.Test;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;

/**
 * *ByteOrder定义了写入buffer时字节的顺序
 * <p>
 * ---java默认是big-endian
 * <p>
 * *API
 * ---2个内置的ByteOrder
 * ByteOrder.BIG_ENDIAN和ByteOrder.LITTLE_ENDIAN
 * <p>
 * ---ByteOrder.nativeOrder()
 * 返回本地jvm运行的硬件的字节顺序.使用和硬件一致的字节顺序可能使buffer更加有效.
 * <p>
 * ---ByteOrder.toString()
 * 返回ByteOrder的名字,BIG_ENDIAN或LITTLE_ENDIAN
 */
public class ByteOrderTest {
    @Test
    public void testByteOrder() {
        ByteBuffer buf = ByteBuffer.allocate(4);
        System.out.println("Default java endian: " + buf.order().toString());

        buf.putShort((short) 1);
        buf.order(ByteOrder.LITTLE_ENDIAN);
        System.out.println("Now: " + buf.order().toString());
        buf.putShort((short) 2);

        buf.flip();
        for (int i = 0; i < buf.limit(); i++)
            System.out.println(buf.get() & 0xFF);

        System.out.println("My PC: " + ByteOrder.nativeOrder().toString());
    }
}
