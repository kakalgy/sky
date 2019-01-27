package com.yusj.eagle.types;

import com.yusj.eagle.annotation.Public;
import com.yusj.eagle.core.io.IOReadableWritable;

import java.io.Serializable;

/**
 * 可能够序列化的基本类型Value的接口
 * <p>此接口扩展{@link IOReadableWritable}并要求实现其值的序列化。</p>
 *
 * @Author kakalgy
 * @Date 2019/1/27 18:05
 * @see IOReadableWritable
 **/
@Public
public interface Value extends IOReadableWritable, Serializable {
}
