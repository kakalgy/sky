package com.yusj.magpie.jvm.bytecode.overload;

/**
 * @Description
 * @Author kakalgy
 * @Date 2019/1/14 21:55
 **/
public class StaticDispatch {
    static abstract class Human {
        static {
            System.out.println("Human");
        }
    }

    static class Man extends Human {
        static {
            System.out.println("Man");
        }
    }

    static class Woman extends Human {
        static {
            System.out.println("Woman");
        }
    }

    public static void sayHello(Human guy) {
        System.out.println("hello,guy!");
    }

    public static void sayHello(Man guy) {
        System.out.println("hello,gentlemen!");
    }

    public static void sayHello(Woman guy) {
        System.out.println("hello,lady!");
    }

    public static void main(String[] args) {
        Human man = new Man();
        sayHello(man);
        sayHello((Man) man);//类型转换，静态类型变化，我们知道转型后的静态类型一定是Man
        man = new Woman(); //实际类型变化,实际类型却是不确定的
        sayHello(man);
        sayHello((Woman) man);//类型转换，静态类型变化
    }

}
