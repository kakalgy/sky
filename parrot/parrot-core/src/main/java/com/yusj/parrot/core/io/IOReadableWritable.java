package com.yusj.parrot.core.io;

import com.yusj.parrot.annotation.Public;
import com.yusj.parrot.core.memory.DataInputView;
import com.yusj.parrot.core.memory.DataOutputView;

import java.io.IOException;

/**
 * This interface must be implemented by every class whose objects have to be serialized to their binary representation
 * and vice-versa. In particular, records have to implement this interface in order to specify how their data can be
 * transferred to a binary representation.
 *
 * <p>
 * When implementing this Interface make sure that the implementing class has a default
 * (zero-argument) constructor! 需要注意的是：所有继承这个接口的类都必须有个无参数的构造函数
 * </p>
 * <p>
 * 所有需要转换为二进制的对象都需要继承这个接口
 * </p>
 */
@Public
public interface IOReadableWritable {

    /**
     * Writes the object's internal data to the given data output view.
     * <p>
     * 将对象的数据写入DataOutputView中
     * </p>
     *
     * @param out the output view to receive the data.
     * @throws IOException thrown if any error occurs while writing to the output stream
     */
    void write(DataOutputView out) throws IOException;

    /**
     * Reads the object's internal data from the given data input view.
     * <p>
     * 从DataInputView中读取对象的数据
     * </p>
     *
     * @param in the input view to read the data from
     * @throws IOException thrown if any error occurs while reading from the input stream
     */
    void read(DataInputView in) throws IOException;

}

