package com.yusj.parrot.core.memory;

import com.yusj.parrot.annotation.Public;

import java.io.DataInput;
import java.io.IOException;

/**
 * This interface defines a view over some memory that can be used to sequentially read the contents of the memory.
 * The view is typically backed by one or more {@link MemorySegment}.
 */
@Public
public interface DataInputView extends DataInput {

    /**
     * Skips {@code numBytes} bytes of memory. In contrast to the {@link #skipBytes(int)} method,
     * this method always skips the desired number of bytes or throws an {@link java.io.EOFException}.
     * <p>
     * <p/>在读取内存数据时，跳过numBytes个字节；与DataInput.skipBytes不同的是skipBytesToRead一定会跳过numBytes个字节，
     * 而DataInput.skipBytes在剩余字节数不够的时候不会跳过numBytes个字节
     *
     * @param numBytes The number of bytes to skip.
     * @throws IOException Thrown, if any I/O related problem occurred such that the input could not
     *                     be advanced to the desired position.
     */
    void skipBytesToRead(int numBytes) throws IOException;

    /**
     * Reads up to {@code len} bytes of memory and stores it into {@code b} starting at offset {@code off}.
     * It returns the number of read bytes or -1 if there is no more data left.
     * <p/>从内存中off位置读取len个字节到b中
     *
     * @param b   byte array to store the data to
     * @param off offset into byte array
     * @param len byte length to read
     * @return the number of actually read bytes of -1 if there is no more data left
     * @throws IOException
     */
    int read(byte[] b, int off, int len) throws IOException;

    /**
     * Tries to fill the given byte array {@code b}. Returns the actually number of read bytes or -1 if there is no
     * more data.
     * <p/>从内存中读取字节填充到b中
     *
     * @param b byte array to store the data to
     * @return the number of read bytes or -1 if there is no more data left
     * @throws IOException
     */
    int read(byte[] b) throws IOException;
}

