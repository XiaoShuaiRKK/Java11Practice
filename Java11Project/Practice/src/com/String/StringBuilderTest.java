package com.String;

import java.util.ArrayList;
import java.util.stream.IntStream;

public class StringBuilderTest {
    public static void main(String[] args) {
//        constructorTest();
//        methodOneTest();
        methodTwoTest();
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
        StringBuilder sb = new StringBuilder();
        System.out.println(sb.append(true));
        System.out.println(sb.append('A'));
        System.out.println(sb.append(new char[] {'B','C'}));
        System.out.println(sb.append(new char[] {'D','E','F','G','H'},1,3));
        System.out.println(sb.append(50.0D));
        System.out.println(sb.append(100.05F));
        System.out.println(sb.append(1314));
        System.out.println(sb.append(577L));
        System.out.println(sb.append("What"));
        System.out.println(sb.append("Hello",2,4));
        System.out.println(sb.append("Hello",2,4));
        System.out.println(sb.append(new StringBuilderTest.SayHay()));
        System.out.println(sb.append(sb));
        System.out.println(sb.appendCodePoint(97));
        System.out.println(sb.appendCodePoint(98));
        System.out.println(sb.appendCodePoint(99));
        System.out.println(sb.length());
        System.out.println(sb.capacity());
        System.out.println(sb.charAt(52));
    }

    private static void methodTwoTest(){
        StringBuilder sb = new StringBuilder();
        System.out.println(sb.append("hello"));
        IntStream intStream = sb.chars();
        intStream.forEach((i) -> System.out.print(i + " "));
        System.out.println();
        for(int i=0;i<sb.length();i++)
            System.out.print(sb.codePointAt(i) + " ");
    }

    static class SayHay{
        @Override
        public String toString() {
            return "你好";
        }
    }
}
