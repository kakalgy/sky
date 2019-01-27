package com.yusj.eagle.annotation;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Target;

/**
 * 这个注解是用来声明方法，属性，构造函数和类型，仅仅有测试为目的的可见性
 * <p>举例：这个注解通常在这个情况下使用：
 * 当一个方法需要声明为private时，但是又不能声明为private，因为有些测试类需要调用这些方法</p>
 **/
@Documented
@Target({ElementType.TYPE, ElementType.METHOD, ElementType.FIELD, ElementType.CONSTRUCTOR})
@Internal
public @interface VisibleForTesting {
}
