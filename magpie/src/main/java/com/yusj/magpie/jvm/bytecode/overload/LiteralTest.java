package com.yusj.magpie.jvm.bytecode.overload;

import java.io.Serializable;

/**
 * @Description
 * @Author kakalgy
 * @Date 2019/1/14 22:10
 **/
public class LiteralTest {

    public static void sayHello(Object arg) {
        System.out.println("hello object");
    }

//    public static void sayHello(char arg) {
//        System.out.println("hello char");
//    }

//    public static void sayHello(int arg) {
//        System.out.println("hello int");
//    }

//    public static void sayHello(long arg) {
//        System.out.println("hello long");
//    }

//    public static void sayHello(Character arg) {
//        System.out.println("hello Character");
//    }

    public static void sayHello(char... arg) {
        System.out.println("hello char...");
    }

    public static void sayHello(Serializable arg) {
        System.out.println("hello Serializable");
    }

//    public static void sayHello(Comparable<Character> arg) {
//        System.out.println("hello Comparable<Character>");
//    }

    public static void main(String[] args) {
        sayHello('a');
    }

}
