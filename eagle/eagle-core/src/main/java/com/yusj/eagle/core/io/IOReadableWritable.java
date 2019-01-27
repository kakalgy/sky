package com.yusj.eagle.core.io;

import com.yusj.eagle.annotation.Public;
import com.yusj.eagle.core.memory.DataInputView;
import com.yusj.eagle.core.memory.DataOutputView;

import java.io.IOException;

/**
 * 这个接口必须被每个类所实现，只要这个类的对象必须被序列化为二进制数据，反之亦然；特别是，records必须实现此接口，以指定如何将其数据转换为二进制表示
 * <p>实现此接口时，请确保实现类具有默认（零参数）构造函数！</p>
 *
 * @Author kakalgy
 * @Date 2019/1/27 17:57
 **/
@Public
public interface IOReadableWritable {

    /**
     * 将对象的内部数据写入给定的DataOutputView。
     *
     * @param out 用来接收数据的DataOutputView
     * @return void
     * @throws IOException
     **/
    void write(DataOutputView out) throws IOException;

    /**
     * 从给定的DataInputView中读取对象的内部数据。
     *
     * @param in 数据源
     * @return void
     * @throws IOException
     **/
    void read(DataInputView in) throws IOException;
}
