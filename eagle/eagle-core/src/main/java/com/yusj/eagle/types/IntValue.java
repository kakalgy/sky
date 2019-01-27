package com.yusj.eagle.types;

import com.yusj.eagle.annotation.Public;
import com.yusj.eagle.core.memory.DataInputView;
import com.yusj.eagle.core.memory.DataOutputView;
import com.yusj.eagle.core.memory.MemorySegment;

import java.io.IOException;

/**
 * 封装的可序列化和可比较的的int类型，表示基本类型{@code int}。
 *
 * @Author kakalgy
 * @Date 2019/1/27 20:46
 **/
@Public
public class IntValue implements ResettableValue<IntValue>, CopyableValue<IntValue>, NormalizableKey<IntValue> {

    private static final long serialVersionUID = 1L;

    private int value;

    //-------------------------------------------------------
    //-------------------------------------------------------
    //
    //构造函数
    //
    //-------------------------------------------------------
    //-------------------------------------------------------

    /**
     * 使用0初始化封装的int。
     */
    public IntValue() {
        this.value = 0;
    }

    /**
     * 使用参数value初始化封装的int。
     *
     * @param value
     */
    public IntValue(int value) {
        this.value = value;
    }

    //-------------------------------------------------------
    //-------------------------------------------------------
    //
    //getter/setter方法
    //
    //-------------------------------------------------------
    //-------------------------------------------------------

    /**
     * 返回封装的int的值。
     *
     * @return
     */
    public int getValue() {
        return value;
    }

    /**
     * 将封装的int设置为指定的值。
     *
     * @param value
     */
    public void setValue(int value) {
        this.value = value;
    }
    //-------------------------------------------------------
    //-------------------------------------------------------
    //
    //实现IOReadableWritable接口的方法
    //
    //-------------------------------------------------------
    //-------------------------------------------------------

    @Override
    public void read(DataInputView in) throws IOException {
        this.value = in.readInt();
    }

    @Override
    public void write(DataOutputView out) throws IOException {
        out.write(this.value);
    }

    //-------------------------------------------------------
    //-------------------------------------------------------
    //
    //实现ResettableValue接口的方法
    //
    //-------------------------------------------------------
    //-------------------------------------------------------

    @Override
    public void setValue(IntValue value) {
        this.value = value.value;
    }

    //-------------------------------------------------------
    //-------------------------------------------------------
    //
    //实现CopyableValue接口的方法
    //
    //-------------------------------------------------------
    //-------------------------------------------------------

    @Override
    public int getBinaryLength() {
        return 4;
    }

    @Override
    public void copyTo(IntValue target) {
        target.value = this.value;
    }

    @Override
    public IntValue copy() {
        return new IntValue(this.value);
    }

    @Override
    public void copy(DataInputView source, DataOutputView target) throws IOException {
        target.write(source, 4);
    }

    //-------------------------------------------------------
    //-------------------------------------------------------
    //
    //实现NormalizableKey接口的方法
    //
    //-------------------------------------------------------
    //-------------------------------------------------------

    @Override
    public int getMaxNormalizedKeyLen() {
        return 4;
    }

    @Override
    public void copyNormalizedKey(MemorySegment memory, int offset, int len) {

    }

    //-------------------------------------------------------
    //-------------------------------------------------------
    //
    //实现Comparable接口的方法
    //
    //-------------------------------------------------------
    //-------------------------------------------------------

    @Override
    public int compareTo(IntValue o) {
        final int other = o.value;
        return this.value < other ? -1 : this.value > other ? 1 : 0;
    }

    //-------------------------------------------------------
    //-------------------------------------------------------
    //
    //覆盖Object对象的方法
    //
    //-------------------------------------------------------
    //-------------------------------------------------------

    @Override
    public int hashCode() {
        return this.value;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof IntValue) {
            return ((IntValue) obj).value == this.value;
        }
        return false;
    }

    @Override
    public String toString() {
        return String.valueOf(this.value);
    }
}
