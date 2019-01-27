package com.yusj.eagle.annotation;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Target;

/**
 * 标记用于公共使用的类和方法的注释，但具有不断发展的接口。
 * <p>使用此注解的类和方法旨在供公众使用，并具有稳定的行为。
 *   但是，它们的接口和签名不被认为是稳定的，并且可能会在不同版本中进行更改。</p>
 * <p>此注释还排除了使用{@link Public}注释的类中具有不断变化的接口/签名的方法和类</p>
 **/
@Documented
@Target({ElementType.TYPE, ElementType.METHOD, ElementType.FIELD, ElementType.CONSTRUCTOR})
@Public
public @interface PublicEvolving {
}
