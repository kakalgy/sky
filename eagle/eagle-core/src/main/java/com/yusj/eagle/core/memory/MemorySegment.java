package com.yusj.eagle.core.memory;

import com.yusj.eagle.annotation.Internal;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;

/**
 * @Author kakalgy
 * @Date 2019/1/27 20:43
 **/
@Internal
abstract public class MemorySegment {

    /**
     * Unsafe句柄 用来复制透明的内存（堆内/堆外）
     */
    @SuppressWarnings("restriction")
    protected static final sun.misc.Unsafe UNSAFE = MemoryUtils.UNSAFE;

    /**
     * arrayBaseOffset方法是一个本地方法，可以获取数组第一个元素的偏移地址，对于每个类型的数组，值是不变的
     */
    @SuppressWarnings("restriction")
    protected static final long BYTE_ARRAY_BASE_OFFSET = UNSAFE.arrayBaseOffset(byte[].class);

    /**
     * 标记ByteOrder顺序的常量。因为这是一个布尔常量，判断是否为LITTLE_ENDIAN，所以JIT编译器可以很好地使用它来消除不适用的代码路径。
     */
    private static final boolean LITTLE_ENDIAN = (ByteOrder.nativeOrder() == ByteOrder.LITTLE_ENDIAN);

    //-------------------------------------------------------
    //-------------------------------------------------------
    //
    //类的属性
    //
    //-------------------------------------------------------
    //-------------------------------------------------------
    /**
     * 我们访问内存的堆字节数组对象。
     * <p>如果内存在堆内，则值为非null；如果内存在堆外，则值为null。</p>
     * <p>如果我们有这个缓冲区，我们必须永远不会使这个引用无效，否则内存段将指向堆外的未定义地址，并且可能在无序执行情况下导致分段错误。</p>
     */
    protected final byte[] heapMemory;

    /**
     * 堆外内存数据的地址，相对于堆内存字节数组。 如果堆内存字节数组为空(heapMemory == null)，则它将成为堆外的绝对内存地址。
     */
    protected long address;

    /**
     * 最后一个可寻址字节后的一个字节的地址，也就是说，值为当MemorySegment未释放时的 (address + size)
     */
    protected final long addressLimit;

    /**
     * MemorySegment的大小（以字节为单位）
     */
    protected final int size;

    /**
     * MemorySegment的可选所有者
     */
    private final Object owner;

    //-------------------------------------------------------
    //-------------------------------------------------------
    //
    //构造函数
    //
    //-------------------------------------------------------
    //-------------------------------------------------------

    /**
     * 创建一个表示字节数组内存的新MemorySegment。---堆内内存
     * <p>由于字节数组由堆内存储器支持，因此该内存段将其数据保存在堆上。 缓冲区必须至少为8字节大小。</p>
     *
     * @param buffer 字节数组，其内存由此MemorySegment表示。
     * @param owner
     */
    MemorySegment(byte[] buffer, Object owner) {
        if (buffer == null) {
            throw new NullPointerException("buffer");
        }
        this.heapMemory = buffer;
        this.address = BYTE_ARRAY_BASE_OFFSET;
        this.size = buffer.length;
        this.addressLimit = this.address + this.size;
        this.owner = owner;
    }

    /**
     * 创建一个新的MemorySegment，表示指针给出的绝对地址处的内存。---堆外内存
     *
     * @param offHeapAddress MemorySegment表示的内存地址
     * @param size           MemorySegment的大小
     * @param owner
     */
    MemorySegment(long offHeapAddress, int size, Object owner) {
        if (offHeapAddress <= 0) {
            throw new IllegalArgumentException("negative pointer or size");
        }
        if (offHeapAddress >= Long.MAX_VALUE - Integer.MAX_VALUE) {
            //这是确保折叠检查对数字溢出安全的必要条件,collapsed checks
            throw new IllegalArgumentException("Segment initialized with too large address: " + offHeapAddress
                    + " ; Max allowed address is " + (Long.MAX_VALUE - Integer.MAX_VALUE - 1));
        }

        this.heapMemory = null;
        this.address = offHeapAddress;
        this.addressLimit = this.address + size;
        this.size = size;
        this.owner = owner;
    }

    //-------------------------------------------------------
    //-------------------------------------------------------
    //
    //MemorySegment操作
    //
    //-------------------------------------------------------
    //-------------------------------------------------------

    /**
     * 返回MemorySegment的大小（以字节为单位）
     *
     * @return
     */
    public int size() {
        return this.size;
    }

    /**
     * 检查MemorySegment是否已释放。
     *
     * @return <tt>true</tt> 代表MemorySegment已经被释放
     */
    public boolean isFreed() {
        return address > addressLimit;
    }

    /**
     * 释放MemorySegment
     * <p>调用此操作后，MemorySegment上无法进一步操作，并且将失败。 实际内存（堆或堆外）仅在此MemorySegment对象变为垃圾回收后才会释放。</p>
     */
    public void free() {
        //这可以确保我们不再放置数据并触发对已释放段的检查
        address = addressLimit + 1;
    }

    /**
     * 检查此MemorySegment是否由堆外内存支持
     *
     * @return <tt>true</tt> 代表由堆外内存支持， <tt>false</tt>代表由堆内内存支持
     */
    public boolean isOffHeap() {
        return this.heapMemory == null;
    }

    /**
     * 返回堆内内存的byte数组
     *
     * @return 底层byte数组
     * @throws IllegalStateException 如果MemorySegment不支持堆内内存
     */
    public byte[] getArray() {
        if (heapMemory != null) {
            return heapMemory;
        } else {
            throw new IllegalStateException("Memory segment does not represent heap memory");
        }
    }

    /**
     * 返回堆外内存的内存地址
     *
     * @return 堆外的绝对内存地址
     * @throws IllegalStateException 如果MemorySegment不支持堆外内存
     */
    public long getAddress() {
        if (heapMemory == null) {
            return address;
        } else {
            throw new IllegalStateException("Memory segment does not represent off heap memory");
        }
    }

    /**
     * 将位于偏移量(offset)和长度(length)之间的底层内存块包装在NIO字节缓冲区中。
     *
     * @param offset MemorySegment的偏移量
     * @param length 要包装为ByteBuffer的字节数。
     * @return 由MemorySegment的指定部分支持的ByteBuffer。
     * @throws IndexOutOfBoundsException 如果offset为负或大于MemorySegment大小，或者offset加上length大于MemorySegment大小。
     */
    public abstract ByteBuffer wrap(int offset, int length);

    /**
     * 获取此内存段的所有者。 如果未设置所有者，则返回null。
     *
     * @return
     */
    public Object getOwner() {
        return owner;
    }


    //------------------------------------------------------------------------
    //------------------------------------------------------------------------
    //
    //随机访问get（）和put（）方法
    //
    //------------------------------------------------------------------------
    //------------------------------------------------------------------------

    //------------------------------------------------------------------------
    // 实施注意事项：
    //      我们尝试尽可能多地进行检查。 我们需要遵守以下规则，以防止段错误：
    //
    //  - 在检查和使用之前，将可变字段添加到堆栈中。
    //    这可以保护我们免受并发修改，这些修改使指针无效
    //  - 使用减法进行范围检查，因为它们是可容忍的
    //------------------------------------------------------------------------

    /**
     * 读取给定位置的字节。
     *
     * @param index 将要被读出的字节的位置
     * @return 读出的字节
     * @throws IndexOutOfBoundsException 如果索引为负或大于或等于内存段的大小，则抛出异常。
     */
    public abstract byte get(int index);

    /**
     * 在给定位置将给定字节写入此缓冲区。
     *
     * @param index 写入字节的索引。
     * @param b     将要写入的字节
     * @throws IndexOutOfBoundsException 如果索引为负或大于或等于内存段的大小，则抛出异常。
     */
    public abstract void put(int index, byte b);

    /**
     * 批量获取方法。将dst.length长度的内存从指定位置index开始复制到目标内存dst。
     *
     * @param index 读取第一个字节的位置。
     * @param dst   内存将被复制到的目的内存。
     * @throws IndexOutOfBoundsException 如果索引为负数或者太大以至于索引index与MemorySegment(内存段)末尾之间的数据不足以填充目标数组，则抛出异常。
     */
    public abstract void get(int index, byte[] dst);

    /**
     * 批量写入方法。 将src.length长度的内存从源内存src复制到从指定位置开始的内存段。
     *
     * @param index MemorySegment内存段数组中的索引，写入数据的位置。
     * @param src   要从中复制数据的源内存数组。
     * @throws IndexOutOfBoundsException 如果索引是为负数，或者太大以至于数组大小超过索引和内存段末尾之间的内存量，则抛出异常。
     */
    public abstract void put(int index, byte[] src);

    /**
     * 批量获取方法。从dst给定的偏移量(offset)开始，将指定长度(length)的内存复制到目标内存dst，。
     *
     * @param index  读取第一个字节的位置。
     * @param dst    内存将被复制到的目的内存。
     * @param offset 目标内存中的复制偏移量。
     * @param length 需要拷贝的字节数
     * @throws IndexOutOfBoundsException 如果索引为负，或太大以致请求的字节数超过了索引和内存段末尾之间的内存量。
     */
    public abstract void get(int index, byte[] dst, int offset, int length);

    /**
     * 批量写入方法。 将从源内存src中的偏移的位置offset开始的长度为length的内存复制到从指定索引index开始的MemorySegment(内存段)中。
     *
     * @param index  MemorySegment内存段数组中的索引，写入数据的位置。
     * @param src    要从中复制数据的源内存数组。
     * @param offset 开始复制的源数组中的偏移量。
     * @param length 需要拷贝的字节数
     * @throws IndexOutOfBoundsException 如果索引为负，或太大以致请求的字节数超过了索引和内存段末尾之间的内存量。
     */
    public abstract void put(int index, byte[] src, int offset, int length);

    /**
     * 在给定位置读取一个字节并返回其布尔表示。
     *
     * @param index 将要被读出的字节的位置
     * @return 读出的字节的布尔表示
     * @throws IndexOutOfBoundsException 如果索引为负数，或者MemorySegment段大小减1，则抛出异常。
     */
    public abstract boolean getBoolean(int index);

    /**
     * 在给定位置将包含字节值的一个字节写入此缓冲区。
     *
     * @param index 写入内存的位置。
     * @param value 要写入的char值。
     * @throws IndexOutOfBoundsException 如果索引为负数，或者MemorySegment段大小减1，则抛出异常。
     */
    public abstract void putBoolean(int index, boolean value);

    /**
     * 以系统的本机ByteOrder顺序从给定位置读取char值。
     *
     * @param index 从中读取内存的位置。
     * @return 给定位置的char值
     * @throws IndexOutOfBoundsException 如果索引为负数，或者MemorySegment段大小减2，则抛出异常。
     */
    @SuppressWarnings("restriction")
    public final char getChar(int index) {
        final long pos = address + index;
        if (index >= 0 && pos <= addressLimit - 2) {
            return UNSAFE.getChar(heapMemory, pos);
        } else if (address > addressLimit) {
            //见isFreed()方法
            throw new IllegalStateException("This segment has been freed.");
        } else {
            //索引不合法
            throw new IndexOutOfBoundsException();
        }
    }


}