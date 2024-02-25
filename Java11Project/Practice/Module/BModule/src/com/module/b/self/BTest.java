package com.module.b.self;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class BTest {
    public static void main(String[] args) throws ClassNotFoundException,
            NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
        Class<?> cls = Class.forName("com.module.a.Util.AUtil");
        Constructor<?> constructor = cls.getConstructor();
        Object o = constructor.newInstance();
        System.out.println(o.getClass());
    }
}
