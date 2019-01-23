package com.yusj.magpie.jvm.classloading;

/**
 * @Description
 * @Author kakalgy
 * @Date 2019/1/6 21:55
 **/
public class FieldResolution {
    interface Interface0 {
        int A = 0;
    }

    interface Interface1 extends Interface0 {
        int A = 1;
    }

    interface Interface2 {
        int A = 2;
    }

    static class Parent implements Interface1, Interface0 {
        public static int A = 3;
    }

    static class Sub extends Parent implements Interface2 {
        //当注释掉这行时，由于A同时出现在接口和父类中，编译器有可能拒绝编译
        public static int A = 4;
    }

    public static void main(String[] args) {
        System.out.println(Sub.A);
    }
}
