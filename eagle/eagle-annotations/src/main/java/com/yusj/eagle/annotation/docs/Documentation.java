package com.yusj.eagle.annotation.docs;

import com.yusj.eagle.annotation.Internal;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 收集注释以修改文档生成器的行为。
 *
 * @Author kakalgy
 * @Date 2019/1/27 13:35
 **/
public final class Documentation {

    /**
     * Config选项字段上使用的注释将覆盖记录的默认值。
     **/
    @Target(ElementType.FIELD)
    @Retention(RetentionPolicy.RUNTIME)
    @Internal
    public @interface OverrideDefault {
        String value();
    }

    /**
     * Config选项字段上使用的注释将它们包含在“公共选项”部分中。
     * <p>{@link CommonOption＃position（）}参数控制生成的表中的位置，较低的值位于顶部。 具有相同位置的字段按键按字母顺序排序。</p>
     **/
    @Target(ElementType.FIELD)
    @Retention(RetentionPolicy.RUNTIME)
    @Internal
    public @interface CommonOption {
        int POSITION_MEMORY = 10;
        int POSITION_PARALLELISM_SLOTS = 20;
        int POSITION_FAULT_TOLERANCE = 30;
        int POSITION_HIGH_AVAILABILITY = 40;
        int POSITION_SECURITY = 50;

        int position() default Integer.MAX_VALUE;
    }

    private Documentation() {
    }
}
