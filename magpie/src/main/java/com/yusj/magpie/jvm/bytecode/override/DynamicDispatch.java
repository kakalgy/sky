package com.yusj.magpie.jvm.bytecode.override;

/**
 * @Description
 * @Author kakalgy
 * @Date 2019/1/14 22:19
 **/
public class DynamicDispatch {
    static abstract class Human {
        protected abstract void sayHello();
    }

    static class Man extends Human {
        @Override
        protected void sayHello() {
            System.out.println("man say hello!");
        }
    }

    static class Woman extends Human {
        @Override
        protected void sayHello() {
            System.out.println("woman say hello!");
        }

        static abstract class Human {
            protected abstract void sayHello();
        }


    }

    public static void main(String[] args) {

        Human man = new Man();
        Human woman = new Woman();
        man.sayHello();
        woman.sayHello();
        man = new Woman();
        man.sayHello();
    }

}
