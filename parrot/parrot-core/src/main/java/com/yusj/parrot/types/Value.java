package com.yusj.parrot.types;

import com.yusj.parrot.annotation.Public;
import com.yusj.parrot.core.io.IOReadableWritable;

import java.io.Serializable;

/**
 * Basic value interface for types that act as serializable values.
 * <p>
 * This interface extends {@link IOReadableWritable} and requires to implement
 * the serialization of its value.
 * </p>
 * <p>
 * 能够序列化的Value的基接口
 * </p>
 *
 * @see com.yusj.parrot.core.io.IOReadableWritable
 */
@Public
public interface Value extends IOReadableWritable, Serializable {
}
