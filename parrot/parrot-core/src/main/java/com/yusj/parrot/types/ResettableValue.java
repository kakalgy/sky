package com.yusj.parrot.types;

import com.yusj.parrot.annotation.Public;

/**
 * @param <T>
 */
@Public
public interface ResettableValue<T extends Value> extends Value {

    /**
     * Sets the encapsulated(封装的) value to another value
     *
     * @param value the new value of the encapsulated value
     */
    void setValue(T value);
}
