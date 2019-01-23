package com.yusj.magpie.jvm.classloading;

/**
 * @Description
 * @Author kakalgy
 * @Date 2019/1/6 19:42
 **/
public class NotInitialization {

    /**
     * 可以添加-XX:+TraceClassLoading查看类的加载情况
     **/
    public static void main(String[] args) {
        //Test1 通过子类引用父类的静态字段，不会导致子类初始化
//        System.out.println(SubClass.value);

        //Test2 通过数组定义来引用类，不会触发此类的初始化
//        SuperClass[] sca = new SuperClass[10];

        //Test3 常量在编译阶段会存入调用类的常量池中，本质上并没有直接引用到定义常量的类，因此不会触发定义常量的类的初始化
        System.out.println(ConstClass.he);
    }

}
