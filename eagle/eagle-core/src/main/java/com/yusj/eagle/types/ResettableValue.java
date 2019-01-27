package com.yusj.eagle.types;

import com.yusj.eagle.annotation.Public;

/**
 * 可以设置新Value的接口
 *
 * @Author kakalgy
 * @Date 2019/1/27 19:49
 **/
@Public
public interface ResettableValue<T extends Value> extends Value {
    /**
     * 将封装类型的Value设置为另一个Value
     *
     * @param value 封装类型的新Value值
     */
    void setValue(T value);
}
