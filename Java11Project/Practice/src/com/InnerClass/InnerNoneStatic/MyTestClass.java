package com.InnerClass.InnerNoneStatic;

public class MyTestClass {
    public static void main(String[] args) {
        OuterClass outerClass = new OuterClass();
        OuterClass.InnerClass innerClass = outerClass.new InnerClass();
        System.out.println(outerClass.x + ":" + innerClass.y);
        System.out.println(innerClass.getOuterValue());
    }
}
