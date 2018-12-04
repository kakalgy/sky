package com.yusj.parrot.util;

import com.yusj.parrot.annotation.Internal;

import java.util.Collection;
import java.util.Map;

/**
 * Simple utility to work with Java collections.
 */
@Internal
public final class CollectionUtil {

    /**
     * A safe maximum size for arrays in the JVM.
     */
    public static final int MAX_ARRAY_SIZE = Integer.MAX_VALUE - 8;

    private CollectionUtil() {
        throw new AssertionError();
    }

    public static boolean isNullOrEmpty(Collection<?> collection) {
        return collection == null || collection.isEmpty();
    }

    public static boolean isNullOrEmpty(Map<?, ?> map) {
        return map == null || map.isEmpty();
    }
}

