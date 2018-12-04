package com.yusj.parrot.core.memory;

import com.yusj.parrot.annotation.Public;

import java.io.DataOutput;
import java.io.IOException;

/**
 * This interface defines a view over some memory that can be used to sequentially write contents to the memory.
 * The view is typically backed by one or more {@link org.apache.flink.core.memory.MemorySegment}.
 */
@Public
public interface DataOutputView extends DataOutput {

    /**
     * Skips {@code numBytes} bytes memory. If some program reads the memory that was skipped over, the
     * results are undefined.
     * <p/>
     * 在内存中跳过numBytes个字节
     *
     * @param numBytes The number of bytes to skip.
     * @throws IOException Thrown, if any I/O related problem occurred such that the view could not
     *                     be advanced to the desired position.
     */
    void skipBytesToWrite(int numBytes) throws IOException;

    /**
     * Copies {@code numBytes} bytes from the source to this view.
     * <p/>
     * 从source中读取numBytes个字节写入output(内存)中
     *
     * @param source   The source to copy the bytes from.
     * @param numBytes The number of bytes to copy.
     * @throws IOException Thrown, if any I/O related problem occurred, such that either the input view
     *                     could not be read, or the output could not be written.
     */
    void write(DataInputView source, int numBytes) throws IOException;
}

