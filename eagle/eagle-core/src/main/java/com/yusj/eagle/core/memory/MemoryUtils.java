package com.yusj.eagle.core.memory;

import com.yusj.eagle.annotation.Internal;

import java.lang.reflect.Field;
import java.nio.ByteOrder;

/**
 * 内存操作的工具类。
 *
 * @Author kakalgy
 * @Date 2019/1/27 21:13
 **/
@Internal
public class MemoryUtils {
    /**
     * 系统当前运行的平台的ByteOrder顺序：BIG_ENDIAN/LITTLE_ENDIAN。
     */
    public static final ByteOrder NATIVE_BYTE_ORDER = ByteOrder.nativeOrder();

    /**
     * 私有构造函数，不能被实例化
     */
    private MemoryUtils() {
    }

    /**
     * Unsafe实例，可用于执行本机内存访问。
     */
    @SuppressWarnings("restriction")
    public static final sun.misc.Unsafe UNSAFE = getUnsafe();

    @SuppressWarnings("restriction")
    private static sun.misc.Unsafe getUnsafe() {
        try {
            Field unsafeField = sun.misc.Unsafe.class.getDeclaredField("theUnsafe");
            unsafeField.setAccessible(true);
            return (sun.misc.Unsafe) unsafeField.get(null);
        } catch (SecurityException e) {
            throw new RuntimeException("Could not access the sun.misc.Unsafe handle, permission denied by security manager.", e);
        } catch (NoSuchFieldException e) {
            throw new RuntimeException("The static handle field in sun.misc.Unsafe was not found.");
        } catch (IllegalArgumentException e) {
            throw new RuntimeException("Bug: Illegal argument reflection access for static field.", e);
        } catch (IllegalAccessException e) {
            throw new RuntimeException("Access to sun.misc.Unsafe is forbidden by the runtime.", e);
        } catch (Throwable t) {
            throw new RuntimeException("Unclassified error while trying to access the sun.misc.Unsafe handle.", t);
        }
    }
}
