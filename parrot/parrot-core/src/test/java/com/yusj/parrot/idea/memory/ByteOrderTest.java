package com.yusj.parrot.idea.memory;

import org.junit.Test;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;

/**
 * *ByteOrder定义了写入buffer时字节的顺序
 * <p>
 * 例：数字0x12345678
 * Big Endian:
 * <p>
 * 低地址                                            高地址
 * ----------------------------------------------------------------------------->
 * |     12     |      34    |     56      |     78    |
 * <p>
 * Little Endian:
 * <p>
 * 低地址                                            高地址
 * ----------------------------------------------------------------------------->
 * |     78     |      56    |     34      |     12    |
 *
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
 *
 * 对于ByteBuffer的理解：
 * 1.首先，这是在内存中分配内存空间，按照allocate的参数capacity来分配byte数量
 *
 * 2.不管是BIG_ENDIAN还是LITTLE_ENDIAN，对ByteBuffer的使用都是从低地址开始到高地址结束
 *
 * 3.BIG_ENDIAN和LITTLE_ENDIAN的区别在于，从低地址到高地址的分配过程中，按照分配元素占用的字节数来排定顺序
 *      例如：putInt(3) int型一共4个byte 也就是0003
 *              按照BIG_ENDIAN：则为0003
 *              按照LITTLE_ENDIAN，则为3000
 *           二者之间仅仅是排列的不同，在分配内存后，position的位置是相同的
 *
 * 4.flip()函数，是将limit设置为当前postition，position设为0
 *
 * 5.ByteBuffer分为两种：
 *      HeapByteBuffer：用子节数组封装的一种的ByteBuffer,分配在堆上，受GC控制
 *      DircectByteBuffer：不是分配在堆上，不受GC控制
 *      两者的区别
 *          1,创建和释放DirectByteBuffer的代价要比HeapByteBuffer要高，
 *          2,DirectByteBuffer的读写的操作要比HeapByteBuffer要快
 */
public class ByteOrderTest {
    @Test
    public void testByteOrder() {
        ByteBuffer buf = ByteBuffer.allocate(8);
        System.out.println("Default java endian: " + buf.order().toString());

        buf.putShort((short) 1);
//        buf.put((byte) 1);
        buf.order(ByteOrder.LITTLE_ENDIAN);
        System.out.println("Now: " + buf.order().toString());
        buf.putShort((short) 2);
        buf.putInt(3);
//        buf.put((byte) 2);
        buf.flip();
        System.out.println("buf.limit(): " + buf.limit());
        for (int i = 0; i < buf.limit(); i++) {
            System.out.print(buf.get(i) & 0xFF);
        }

        System.out.println();

        System.out.println("My PC: " + ByteOrder.nativeOrder().toString());
    }

    @Test
    public void mainTest() {
        ByteBuffer buffer = ByteBuffer.allocate(4);
        buffer.order(ByteOrder.BIG_ENDIAN);
        buffer.asIntBuffer().put(1);
        System.out.println(buffer.array()[3]);
        buffer.order(ByteOrder.LITTLE_ENDIAN);
        System.out.println(buffer.array()[3]);
    }
}
