package com.yusj.eagle.types;

import com.yusj.eagle.annotation.PublicEvolving;
import com.yusj.eagle.core.io.IOReadableWritable;

/**
 * <ul>
 * <li><h3>所有能够充当Key的数据类型都必须实现这个接口.</h3></li>
 * <li>Key用来建立Value之间的联系，两个相同类型的Key必须能够通过{@link java.lang.Comparable}来进行比较；</li>
 * <li>此外，所有的Key必须实现正确的{@link java.lang.Object#hashCode()}和{@link java.lang.Object#equals(Object)}方法，
 * 以保证Key能够正常的分组</li>
 * </ul>
 * <p>此接口扩展{@link Value}并要求实现其值的序列化。</p>
 *
 * @Author kakalgy
 * @Date 2019/1/27 19:53
 * @see Value
 * @see IOReadableWritable
 * @see java.lang.Comparable
 * @deprecated Key类型是已弃用和已删除的API的遗留物，也将在未来（2.0）版本中删除。
 **/
@Deprecated
@PublicEvolving
public interface Key<T> extends Value, Comparable<T> {
    /**
     * 所有Key必须覆盖hashCode函数，以根据其内容生成适当的确定性hashCode。
     *
     * @return Key的hashCode
     */
    public int hashCode();

    /**
     * 将对象与另一个对象进行相等性比较。
     *
     * @param object 另外一个进行对比的对象
     * @return true代表两个对象相等，否则为false
     */
    public boolean equals(Object object);
}
