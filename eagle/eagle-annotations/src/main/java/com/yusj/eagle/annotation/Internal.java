package com.yusj.eagle.annotation;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Target;

/**
 * 开发人员内部API接口
 */
@Documented //@Documented指定被标注的注解会包含在javadoc中。
@Target({ElementType.TYPE, ElementType.METHOD, ElementType.CONSTRUCTOR})
@Public
public @interface Internal {
}
