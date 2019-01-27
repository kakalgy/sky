package com.yusj.eagle.types;

import com.yusj.eagle.annotation.Public;
import com.yusj.eagle.core.io.IOReadableWritable;
import com.yusj.eagle.core.memory.DataInputView;
import com.yusj.eagle.core.memory.DataOutputView;

import java.io.IOException;

/**
 * 支持深拷贝的基本类型实现的接口。
 *
 * @Author kakalgy
 * @Date 2019/1/27 19:28
 **/
@Public
public interface CopyableValue<T> extends Value {
    /**
     * 获取序列化后数据类型的长度（以字节为单位）。
     *
     * @return 数据类型的长度，如果是可变长度，则为{@code -1}。
     */
    int getBinaryLength();

    /**
     * 将此对象深拷贝到{@code target}实例。
     *
     * @param target 复制到的目标对象。
     */
    void copyTo(T target);

    /**
     * 将此对象深拷贝到一个新实例中。
     * <p>此方法对于通用用户定义函数在存储多个对象时克隆{@link CopyableValue}非常有用。
     * 使用对象重用时，必须创建深层副本，并且类型擦除会阻止调用new。</p>
     *
     * @return 带有复制字段的新对象
     */
    T copy();

    /**
     * 将下一个序列化实例从{@code source}复制到{@code target}。
     * <p>此方法等效于调用{@code IOReadableWritable.read(DataInputView)}，
     * 后跟{@code IOReadableWritable.write(DataOutputView)}，但不需要中间反序列化。</p>
     *
     * @param source 序列化实例的数据源。
     * @param target 序列化实例的数据目标。
     * @throws IOException
     * @see IOReadableWritable
     */
    void copy(DataInputView source, DataOutputView target) throws IOException;
}
