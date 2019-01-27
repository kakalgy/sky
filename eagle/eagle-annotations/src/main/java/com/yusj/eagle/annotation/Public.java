package com.yusj.eagle.annotation;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Target;

/**
 * 这个注解是用来标记公共的，稳定的接口
 * <p>带有此注释的类，方法和属性在小版本（1.0,1.1,1.2）中是稳定的。 换一种说法，使用@Public注释类的应用程序将针对同一主要版本的较新版本进行编译</p>
 * <p>只有主要版本（1.0,2.0,3.0）才能破坏与此注释的接口。</p>
 */
@Documented
@Target(ElementType.TYPE)
@Public
public @interface Public {
}
