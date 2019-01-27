package com.yusj.eagle.annotation.docs;

import com.yusj.eagle.annotation.Internal;

import java.lang.annotation.Target;

/**
 * 一个指定一组配置选项的类。 组的名称将用作生成的html文件的文件名的基础，如{@link ConfigOptionsDocGenerator}中所定义。
 *
 * @see ConfigGroups
 **/
@Target({})
@Internal
public @interface ConfigGroup {
    String name();

    String keyPrefix();
}
