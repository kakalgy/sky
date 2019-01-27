package com.yusj.eagle.util;

import com.yusj.eagle.annotation.Internal;

import javax.annotation.Nullable;

/**
 * 用于验证输入的静态工具类方法的集合
 * <p>此类以Google Guava的Preconditions类为模型，从该类获取部分代码。 我们将此代码添加到Flink代码库中，以减少外部依赖性。</p>
 *
 * @Author kakalgy
 * @Date 2019/1/27 13:47
 **/
@Internal
public class Preconditions {

    //-------------------------------------------------------
    //-------------------------------------------------------
    //
    //构造函数
    //
    //-------------------------------------------------------
    //-------------------------------------------------------

    /**
     * 私有的构造函数，防止实例化
     **/
    private Preconditions() {
    }


    //-------------------------------------------------------
    //-------------------------------------------------------
    //
    //Null检查
    //
    //-------------------------------------------------------
    //-------------------------------------------------------

    /**
     * 确保给定的对象引用不为null。 违规时，将抛出没有消息的{@code NullPointerException}。
     *
     * @return T 对象引用本身（通常情况下）
     * @Param reference 对象引用
     **/
    public static <T> T checkNotNull(T reference) {
        if (reference == null) {
            throw new NullPointerException();
        }
        return reference;
    }

    /**
     * 确保给定的对象引用不为null。 违规时，会抛出带有给定消息的{@code NullPointerException}。
     *
     * @return T 对象引用本身（通常情况下）
     * @throws NullPointerException
     * @Param reference 对象引用
     * @Param errorMessage 异常信息
     **/
    public static <T> T checkNotNull(T reference, @Nullable String errorMessage) {
        if (reference == null) {
            throw new NullPointerException(String.valueOf(errorMessage));
        }
        return reference;
    }

    /**
     * 确保给定的对象引用不为null。 违规时，会抛出带有给定消息的{@code NullPointerException}。
     * <p>错误消息是从模板和参数数组构造的，其方式与{@link String＃format（String，Object ...）}类似，但仅支持{@code％s}作为占位符。</p>
     *
     * @return T 对象引用本身（通常情况下）
     * @Param reference 对象引用
     * @Param errorMessageTemplate 检查失败时抛出的{@code NullPointerException}的消息模板。 该模板使用错误消息参数替换其{@code％s}占位符。
     * @Param errorMessageArgs 错误消息的参数，插入到{@code％s}占位符的消息模板中。
     **/
    public static <T> T checkNotNull(T reference, @Nullable String errorMessageTemplate, @Nullable Object... errorMessageArgs) {
        if (reference == null) {
            throw new NullPointerException(format(errorMessageTemplate, errorMessageArgs));
        }
        return reference;
    }

    //-------------------------------------------------------
    //-------------------------------------------------------
    //
    //Boolean 状态检查(参数)
    //
    //-------------------------------------------------------
    //-------------------------------------------------------

    /**
     * 检查给定的布尔条件，如果不满足条件，则抛出{@code IllegalArgumentException}（计算结果为{@code false}）。
     *
     * @return void
     * @throws IllegalArgumentException
     * @Param condition
     **/
    public static void checkArgument(boolean condition) {
        if (!condition) {
            throw new IllegalArgumentException();
        }
    }

    /**
     * 检查给定的布尔条件，如果不满足条件，则抛出{@code IllegalArgumentException}（计算结果为{@code false}）。 该异常将具有给定的错误消息。
     *
     * @return void
     * @Param condition
     * @Param errorMessage 异常信息
     **/
    public static void checkArgument(boolean condition, @Nullable Object errorMessage) {
        if (!condition) {
            throw new IllegalArgumentException(String.valueOf(errorMessage));
        }
    }

    /**
     * 检查给定的布尔条件，如果不满足条件，则抛出{@code IllegalArgumentException}（计算结果为{@code false}）。 该异常将具有给定的错误消息。
     *
     * @return void
     * @Param condition
     * @Param errorMessageTemplate 检查失败时抛出的{@code IllegalArgumentException}的消息模板。 该模板使用错误消息参数替换其{@code％s}占位符。
     * @Param errorMessageArgs 错误消息的参数，插入到{@code％s}占位符的消息模板中。
     **/
    public static void checkArgument(boolean condition, @Nullable String errorMessageTemplate, @Nullable Object... errorMessageArgs) {
        if (!condition) {
            throw new IllegalArgumentException(format(errorMessageTemplate, errorMessageArgs));
        }
    }

    //-------------------------------------------------------
    //-------------------------------------------------------
    //
    //Boolean 状态检查(状态)
    //
    //-------------------------------------------------------
    //-------------------------------------------------------

    /**
     * 检查给定的布尔条件，如果不满足条件，则抛出{@code IllegalStateException}（计算结果为{@code false}）。
     *
     * @return void
     * @throws IllegalStateException
     * @Param condition
     **/
    public static void checkState(boolean condition) {
        if (!condition) {
            throw new IllegalStateException();
        }
    }

    /**
     * 检查给定的布尔条件，如果不满足条件，则抛出{@code IllegalStateException}（计算结果为{@code false}）。 该异常将具有给定的错误消息。
     *
     * @return void
     * @Param condition
     * @Param errorMessage 异常信息
     **/
    public static void checkState(boolean condition, @Nullable Object errorMessage) {
        if (!condition) {
            throw new IllegalStateException(String.valueOf(errorMessage));
        }
    }

    /**
     * 检查给定的布尔条件，如果不满足条件，则抛出{@code IllegalStateException}（计算结果为{@code false}）。 该异常将具有给定的错误消息。
     *
     * @return void
     * @Param condition
     * @Param errorMessageTemplate 检查失败时抛出的{@code IllegalStateException}的消息模板。 该模板使用错误消息参数替换其{@code％s}占位符。
     * @Param errorMessageArgs 错误消息的参数，插入到{@code％s}占位符的消息模板中。
     **/
    public static void checkState(boolean condition, @Nullable String errorMessageTemplate, @Nullable Object... errorMessageArgs) {
        if (!condition) {
            throw new IllegalStateException(format(errorMessageTemplate, errorMessageArgs));
        }
    }

    /**
     * 确保给定索引对给定大小的数组，列表或字符串有效。
     *
     * @return void
     * @throws IllegalArgumentException
     * @throws IndexOutOfBoundsException
     * @Param [index 索引, size 数组，列表或字符串的大小]
     **/
    public static void checkElementIndex(int index, int size) {
        checkArgument(size >= 0, "Size was negative.");
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
        }
    }

    /**
     * 确保给定索引对给定大小的数组，列表或字符串有效。
     *
     * @return void
     * @throws IllegalArgumentException
     * @throws IndexOutOfBoundsException
     * @Param index 索引
     * @Param size 数组，列表或字符串的大小
     * @Param errorMessage 异常信息
     **/
    public static void checkElementIndex(int index, int size, @Nullable String errorMessage) {
        checkArgument(size >= 0, "Size was negative.");
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException(String.valueOf(errorMessage) + " Index: " + index + ", Size: " + size);
        }
    }

    //-------------------------------------------------------
    //-------------------------------------------------------
    //
    //工具方法
    //
    //-------------------------------------------------------
    //-------------------------------------------------------

    /**
     * 简化的格式化方法。 类似于{@link String＃format（String，Object ...）}，但开销较低（只有String参数，没有语言环境，没有格式验证）。
     * <p>这种方法是从Guava Preconditions类中逐字逐句采用的。</p>
     *
     * @return java.lang.String
     * @Param [template, args]
     **/
    private static String format(@Nullable String template, @Nullable Object... args) {
        final int numArgs = args == null ? 0 : args.length;
        //若template为null， 将其转换为字符串"null"
        template = String.valueOf(template);

        //开始将参数替换为'％s'占位符
        StringBuilder sb = new StringBuilder(template.length() + 16 * numArgs);
        int templateStart = 0;
        int i = 0;
        while (i < numArgs) {
            int placeholderStart = template.indexOf("%s", templateStart);
            if (placeholderStart == -1) {
                break;
            }
            sb.append(template.substring(templateStart, placeholderStart));
            sb.append(args[i++]);
            templateStart = placeholderStart + 2;
        }
        sb.append(template.substring(templateStart));

        //如果我们用尽占位符，请将额外的args附加到方括号中，也就是说%s的个数小于args的个数
        if (i < numArgs) {
            sb.append(" [");
            sb.append(args[i++]);
            while (i < numArgs) {
                sb.append(", ");
                sb.append(args[i++]);
            }
            sb.append(']');
        }

        return sb.toString();
    }
}
