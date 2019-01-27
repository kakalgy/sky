package com.yusj.eagle.core.memory;

import com.yusj.eagle.annotation.Public;

import java.io.DataInput;
import java.io.IOException;

/**
 * 此接口定义了一些可用于顺序读取内存内容的内存视图。 该视图通常由一个或多个{@link MemorySegment}支持。
 *
 * @Author kakalgy
 * @Date 2019/1/27 14:58
 **/
@Public
public interface DataInputView extends DataInput {

    /**
     * 跳过{@code numBytes}个字节的内存。
     * 与{@link #skipBytes（int）}方法相比，此方法总是跳过所需的字节数或抛出{@link java.io.EOFException}。
     *
     * @param numBytes 跳过的字节数
     * @return void
     * @throws IOException，如果发生任何与I/O相关的问题，比如输入无法前进到期望位置。
     **/
    void skipBytesToRead(int numBytes) throws IOException;

    /**
     * 读取{@code len}个字节的内存，并将其存储到{@code b}，从偏移量{@code off}开始。 如果没有剩余数据，它返回读取字节数或-1。
     *
     * @param b
     * @param len
     * @param off
     * @return int
     **/
    int read(byte[] b, int off, int len) throws IOException;

    /**
     * 尝试填充给定的字节数组{@code b}。 返回实际的读取字节数，如果没有更多数据，则返回-1。
     *
     * @param b
     * @return int
     **/
    int read(byte[] b) throws IOException;
}
