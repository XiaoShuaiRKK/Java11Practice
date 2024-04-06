package com.String;

import java.util.ArrayList;
import java.util.stream.IntStream;

public class StringBuilderTest {
    public static void main(String[] args) {
//        constructorTest();
//        methodOneTest();
//        methodTwoTest();
        methodThreeTest();
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
        System.out.println();
        System.out.println("string builder count : " + sb.capacity());
        System.out.println(sb.codePointBefore(1));
        System.out.println(sb.codePointBefore(5));
        System.out.println(sb.codePointCount(0,5));
        IntStream codeStream = sb.codePoints();
        codeStream.forEach((i) -> System.out.print(i + " "));
        System.out.println();
        //string builder compareTo 比较到数组中不匹配的那个一个则返回他们之间的code值差
        //如 hello 和 Hello 中相差 32 因为 h 和 H
        //或 hello 和 hEllo 中相差 32 因为 e 和 E
        //或 hello 和 hEAAlo 中相差 32 因为 e 和 E
        //hello 和 hOLL 中相差22 因为 e 和 O
        System.out.println(sb.compareTo(new StringBuilder("hello")));
        System.out.println(sb.compareTo(new StringBuilder().append("hello")));
        System.out.println(sb.compareTo(new StringBuilder("Hello")));
        System.out.println(sb.compareTo(new StringBuilder().append("Hello")));
        System.out.println(sb.compareTo(new StringBuilder("hOLLL")));
        System.out.println(sb.compareTo(new StringBuilder().append("hOLLL")));
        System.out.println(sb.delete(2,10));
        System.out.println(sb.delete(2,20));
        System.out.println(sb.delete(2,Integer.MAX_VALUE));
        System.out.println(sb.delete(0,Integer.MAX_VALUE));
        System.out.println(sb.append("hello"));
        System.out.println(sb.deleteCharAt(4));
        System.out.println(sb.capacity());
        //string builder 的扩容机制是原本的容量乘2然后再加2
        //如16 变成 34容量
        sb.ensureCapacity(20);
        System.out.println(sb.capacity());
    }

    private static void methodThreeTest(){
        StringBuilder sb = new StringBuilder("hello");
        char[] chars = new char[5];
        sb.getChars(0,5,chars,0);
        System.out.println(chars);
        System.out.println(sb.indexOf("e"));
        System.out.println(sb.indexOf("ll"));
        System.out.println(sb.indexOf("l",3));
        System.out.println(sb.indexOf("l",4));
        System.out.println(sb.insert(0,true));
        System.out.println(sb.insert(1,'Z'));
        System.out.println(sb.insert(5,new char[]{'A','B','C'}));
        System.out.println(sb.insert(5,new char[]{'A','B','C','D','E'},3,2));
        System.out.println(sb.insert(10,3.1415926D));
        System.out.println(sb.insert(10,3.1415926F));
        System.out.println(sb.insert(10,30));
        System.out.println(sb.insert(10,30L));
        //insert(int offset,Object obj) 会调用obj的toString()方法
        System.out.println(sb.insert(10,new SayHay()));
        System.out.println(sb.insert(10,"world",0,3));
    }

    static class SayHay{
        @Override
        public String toString() {
            return "你好";
        }
    }
}
