package com.yusj.parrot.annotation;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Target;

/**
 * Interface to mark methods within stable, public APIs as an internal developer API.
 *
 * <p>Developer APIs are stable but internal to Flink and might change across releases.
 */
@Documented //@Documented指定被标注的注解会包含在javadoc中。
@Target({ElementType.TYPE, ElementType.METHOD, ElementType.CONSTRUCTOR})
@Public
public @interface Internal {
}
