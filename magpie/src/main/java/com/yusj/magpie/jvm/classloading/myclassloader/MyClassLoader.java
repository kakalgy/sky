package com.yusj.magpie.jvm.classloading.myclassloader;

import java.net.URL;
import java.net.URLClassLoader;

/**
 * @Description
 * @Author kakalgy
 * @Date 2019/1/13 19:48
 **/
public class MyClassLoader extends URLClassLoader {
    public MyClassLoader(URL[] urls) {
        super(urls);
    }

    /**
     * 打破双亲模式，保证自己的类会被自己的classloader加载
     **/
    @Override
    protected Class<?> loadClass(String name, boolean resolve) throws ClassNotFoundException {
        Class c = findLoadedClass(name);
        if (c == null) {
            try {
                c = findClass(name);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        if (c == null) {
            c = super.loadClass(name, resolve);
        }
        return c;
    }
}
