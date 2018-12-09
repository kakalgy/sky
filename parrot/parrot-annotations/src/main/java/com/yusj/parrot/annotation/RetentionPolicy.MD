@Retention({RetentionPolicy.Runtime}) 注解
    RetentionPolicy这个枚举类型的常量描述保留注释的各种策略，它们与元注释(@Retention)一起指定注释要保留多长时间

public enum RetentionPolicy {
    /**
     * 注释只在源代码级别保留，编译时被忽略
     */
    SOURCE,
    /**
     * 注释将被编译器在类文件中记录
     * 但在运行时不需要JVM保留。这是默认的
     * 行为.
     */
    CLASS,
    /**
     *注释将被编译器记录在类文件中
     *在运行时保留VM，因此可以反读。
     * @see java.lang.reflect.AnnotatedElement
     */
    RUNTIME
}