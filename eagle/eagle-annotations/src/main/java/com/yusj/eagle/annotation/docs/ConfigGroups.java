package com.yusj.eagle.annotation.docs;

import com.yusj.eagle.annotation.Internal;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 这个注释使用在包含config选项的类上，可以根据key的前缀将选项分离到不同的表上。
 * <p>一个config选项如果选项的key匹配ConfigGroup的前缀则被分配到这个 {@link ConfigGroup}。</p>
 * <p>如果一个key匹配多个ConfigGroup的前缀，则最长的匹配前缀优先，一个选项永远不会分配到多个ConfigGroup</p>
 * <p>如果一个选项不匹配任何ConfigGroup则隐式添加到默认ConfigGroup</p>
 *
 * @Author kakalgy
 * @Date 2019/1/27 13:26
 **/
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Internal
public @interface ConfigGroups {
    ConfigGroup[] groups() default {};
}
