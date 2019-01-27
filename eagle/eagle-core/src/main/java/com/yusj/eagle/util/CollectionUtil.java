package com.yusj.eagle.util;

import com.yusj.eagle.annotation.Internal;

import java.util.Collection;
import java.util.Map;

/**
 * Java集合的简单工具类
 *
 * @Author kakalgy
 * @Date 2019/1/27 14:49
 **/
@Internal
public class CollectionUtil {
    /**
     * JVM中数组的安全最大大小。
     **/
    public static final int MAX_ARRAY_SIZE = Integer.MAX_VALUE - 8;

    //-------------------------------------------------------
    //-------------------------------------------------------
    //
    //构造函数
    //
    //-------------------------------------------------------
    //-------------------------------------------------------

    /**
     * 私有构造函数
     **/
    private CollectionUtil() {
        throw new AssertionError();
    }

    //-------------------------------------------------------
    //-------------------------------------------------------
    //
    //工具方法
    //
    //-------------------------------------------------------
    //-------------------------------------------------------

    /**
     * 判断Collection是否为null或为空
     *
     * @return boolean
     * @Param [collection]
     **/
    public static boolean isNullOrEmpty(Collection<?> collection) {
        return collection == null || collection.isEmpty();
    }

    /**
     * 判断Map是否为null或为空
     *
     * @return boolean
     * @Param [map]
     **/
    public static boolean isNullOrEmpty(Map<?, ?> map) {
        return map == null || map.isEmpty();
    }
}
