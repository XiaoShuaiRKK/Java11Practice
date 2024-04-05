package com.String;

import java.util.ArrayList;

public class StringBuilderTest {
    public static void main(String[] args) {
        constructorTest();
    }

    private static void constructorTest(){
        //StringBuilder(int capacity)
        //构造一个字符串构建器，其中没有字符，并且具有 capacity参数指定的初始容量。
        StringBuilder stringBuilder = new StringBuilder(5);
        stringBuilder.append("hello").append("a");
        System.out.println(stringBuilder);
        //StringBuilder(CharSequence seq)
        //构造一个字符串构建器，其中包含与指定的 CharSequence相同的字符。
        StringBuilder sb = new StringBuilder(stringBuilder.append("b"));
        System.out.println(sb);
    }

    private static void methodOneTest(){

    }
}
