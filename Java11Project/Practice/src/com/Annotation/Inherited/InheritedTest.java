package com.Annotation.Inherited;

import java.lang.annotation.Annotation;

public class InheritedTest {
    public static void main(String[] args) {
        //打印父类注解的信息
        Annotation[] annotationsFather = Father.class.getAnnotations();
        System.out.println("======== 父类注解信息 ========");
        System.out.println("父类注解个数: " + annotationsFather.length);
        for (Annotation fa : annotationsFather) {
            System.out.println(fa.annotationType().getSimpleName());
        }
        //打印子类注解的信息
        Annotation[] annotationsChild = Child.class.getAnnotations();
        System.out.println("======== 子类注解信息 ========");
        System.out.println("子类注解个数: " + annotationsChild.length);
        for (Annotation ca : annotationsChild) {
            System.out.println(ca.annotationType().getSimpleName());
        }
    }
}
