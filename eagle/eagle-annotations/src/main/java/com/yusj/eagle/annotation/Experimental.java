package com.yusj.eagle.annotation;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Target;

/**
 * 这个注释用来标记实验为目的的类
 * <p>带有此注释的类既不经过实战测试也不稳定，可能会在将来的版本中更改或删除</p>
 * <p>此注释还排除了使用{@link Public}和{@link PublicEvolving}注释的不断发展的接口/签名的类</p>
 **/
@Documented
@Target(ElementType.TYPE)
@Public
public @interface Experimental {
}
