package com.yusj.parrot.util;

import org.junit.Test;

public class PreconditionsTest {
    @Test
    public void testFormat() {
        Preconditions.checkArgument(false, "%s is %s, %s",
                "test", "get", "kaka");
    }
}
