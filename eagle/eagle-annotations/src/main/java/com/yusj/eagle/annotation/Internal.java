package com.yusj.eagle.annotation;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Target;

/**
 * 开发人员内部API接口，稳定接口
 * <p>这个注解说明开发者API是稳定的且只对Flink内部开放，但是可能随着版本的发布而改变</p>
 */
@Documented //@Documented指定被标注的注解会包含在javadoc中。
@Target({ElementType.TYPE, ElementType.METHOD, ElementType.CONSTRUCTOR})
@Public
public @interface Internal {
}
