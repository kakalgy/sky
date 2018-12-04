package com.yusj.parrot.util;

import org.junit.Test;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

public class StringUtilsTest {
    /**
     * 测试@Nonnull和@Nullable，目前看来并没有什么检测，只是加上注解
     */
    @Test
    public void testNonnullAnnotation() {
        nonNull(null);
        nullable(null);
    }

    private void nonNull(@Nonnull String str) {
        System.out.println(str);
    }

    private void nullable(@Nullable String str) {
        System.out.println(str);
    }
}
