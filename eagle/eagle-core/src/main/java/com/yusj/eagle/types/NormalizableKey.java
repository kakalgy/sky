package com.yusj.eagle.types;

import com.yusj.eagle.annotation.Public;
import com.yusj.eagle.core.memory.MemorySegment;

/**
 * <ul>
 * <li>规范化的Key的基本接口,该接口指定了实现规范化的键(normalizable key)需要满足的契约</li>
 * <li>规范化的Key指一种在二进制表示的方式下可以进行逐字节比较的键</li>
 * <li>两个规范化Key的比较是逐字节进行的，直到所有字节都已比较完或在两个Key相同位置上的两个字节不相等</li>
 * <li>如果两个Key对应的字节值不相等，则字节值较小的Key小一些</li>
 * <li>如果两个可规范化Key对应的字节值都相等，则可能需要查看实际的Key来决定哪一个Key更小</li>
 * </ul>
 * <p>后者取决于规范化Key是整个Key还是仅仅Key的前缀；如果规范化Key的长度小于最大规范化Key长度，则将其视为前缀。</p>
 *
 * @Author kakalgy
 * @Date 2019/1/27 20:08
 **/
@Public
public interface NormalizableKey<T> extends Comparable<T>, Key<T> {

    /**
     * 获取数据类型生成的规范化Key的最大长度，仅仅通过规范化Key来确定实例的顺序。
     * {@link java.lang.Integer}.MAX_VALUE的值被认为无限。
     * <p>例如，32位整数返回4，而字符串（可能无限长）返回{@link java.lang.Integer}.MAX_VALUE。</p>
     *
     * @return 规范化Key的最大长度。
     */
    int getMaxNormalizedKeyLen();

    /**
     * 将给定记录的规范化Key写入目标字节数组，从指定位置开始，精确写入给定的字节数。
     * 请注意，字节的比较是将字节视为无符号字节：{@code int byteI = bytes [i]＆0xFF;}
     * <p>如果规范化Key的有意义部分小于给定的字节数(即写入的字节数小于len)，则必须填充。 对于可变长度数据类型（例如字符串），通常需要填充。
     * 填充使用特殊字符{@code 0}或{@code 0xff}，具体取决于较短的值是排序到开头还是结尾。</p>
     *
     * @param memory 用于将规范化Key字节放入的内存段
     * @param offset 字节数组中应该开始规范化Key的字节的偏移量。
     * @param len    要放入的字节数。
     */
    void copyNormalizedKey(MemorySegment memory, int offset, int len);
}
