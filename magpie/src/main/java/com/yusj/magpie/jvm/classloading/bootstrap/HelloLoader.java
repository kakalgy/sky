package com.yusj.magpie.jvm.classloading.bootstrap;

/**
 * @Description
 * @Author kakalgy
 * @Date 2019/1/13 19:24
 **/
public class HelloLoader {
//    public void print() {
//        System.out.println("I am in apploader");
//    }

    /**
     * 这个方法的意义在于，在开始时使用这个方法，注释上面的，将生成的class文件存入一个位置，然后使用-Xbootclasspath参数
     **/
    public void print() {
        System.out.println("I am in boostraploader");
    }
}
