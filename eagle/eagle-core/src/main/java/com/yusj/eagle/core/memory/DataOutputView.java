package com.yusj.eagle.core.memory;

import com.yusj.eagle.annotation.Public;

import java.io.DataOutput;
import java.io.IOException;

/**
 * 此接口定义了一些可用于将内容顺序写入内存的内存视图。 该视图通常由一个或多个{@link org.apache.flink.core.memory.MemorySegment}支持。
 *
 * @Author kakalgy
 * @Date 2019/1/27 17:50
 **/
@Public
public interface DataOutputView extends DataOutput {
    /**
     * 跳过{@code numBytes}字节内存。 如果某个程序读取了跳过的内存，则结果未定义。
     *
     * @param numBytes 跳过的字节数
     * @return void
     * @throws IOException，如果发生任何与I/O相关的问题，比如视图无法前进到期望位置。
     **/
    void skipBytesToWrite(int numBytes) throws IOException;

    /**
     * 将数据源的{@code numBytes}个字节复制到此视图。
     *
     * @param source   数据源
     * @param numBytes 拷贝的字节数
     * @return void
     **/
    void write(DataInputView source, int numBytes) throws IOException;
}
