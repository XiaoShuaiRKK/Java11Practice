package com.String;

import java.util.ArrayList;
import java.util.stream.IntStream;

/**
 * new StringBuilder(String str){ capacity = str.length() + 16 }
 * 而且按照 当前容量*2+2 扩容一次也不够，其容量会直接扩容到与所添加的字符串长度相等的长度。之后再追加的话，还会按照 当前容量*2+2进行扩容
 * 如 capacity 为 90 下次扩容长度为182
 * 若setLength(200)则 capacity 为 200
 * 这时再setLength(201) 或追加值 则会按照正常添加 capacity 为 402
 */
public class StringBuilderTest {
    public static void main(String[] args) {
//        constructorTest();
//        methodOneTest();
//        methodTwoTest();
//        methodThreeTest();
//        methodFourTest();
//        methodFiveTest();
        methodSixTest();
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

    private static void methodFourTest(){
        StringBuilder sb = new StringBuilder("hello");
        System.out.println(sb.lastIndexOf("e"));
        System.out.println(sb.lastIndexOf("l",2));
        System.out.println(sb.lastIndexOf("l",3));
        System.out.println("capacity : " + sb.capacity());
        System.out.println("length : " + sb.length());
        sb.setLength(10);
        System.out.println("capacity : " + sb.capacity());
        System.out.println("length : " + sb.length());
        System.out.println(sb);
        System.out.println(sb.append("a"));
        System.out.println("capacity : " + sb.capacity());
        System.out.println("length : " + sb.length());
    }

    private static void methodFiveTest(){
        StringBuilder sb = new StringBuilder("hello");
        int cp1,cp5,cp2;
        System.out.println((cp1 = sb.offsetByCodePoints(0,1)));
        System.out.println((cp5 = sb.offsetByCodePoints(1,4)));
        System.out.println((cp2 = sb.offsetByCodePoints(4,-2)));
        System.out.printf("cp1 : %d , cp5 : %d , cp2 : %d",
                sb.codePointAt(cp1 - 1),sb.codePointAt(cp5 - 1),sb.codePointAt(cp2 - 1));
        System.out.println();
        System.out.println(sb);
        System.out.println("capacity : " + sb.capacity());
        System.out.println("length : " + sb.length());
        System.out.println(sb.replace(2,4,"p"));
        System.out.println("capacity : " + sb.capacity());
        System.out.println("length : " + sb.length());
        System.out.println(sb.replace(2,3,"pp"));
        System.out.println("capacity : " + sb.capacity());
        System.out.println("length : " + sb.length());
        sb.setLength(10);
        System.out.println("capacity : " + sb.capacity());
        System.out.println("length : " + sb.length());
        System.out.println(sb.replace(5,10,"world"));
        System.out.println("capacity : " + sb.capacity());
        System.out.println("length : " + sb.length());
        sb.setLength(21);
        System.out.println(sb);
        System.out.println("capacity : " + sb.capacity());
        System.out.println("length : " + sb.length());
        System.out.println(sb.append('a'));
        System.out.println("capacity : " + sb.capacity());
        System.out.println("length : " + sb.length());
        sb.setLength(45);
        System.out.println("capacity : " + sb.capacity());
        System.out.println("length : " + sb.length());
        sb.setLength(200);
        System.out.println("capacity : " + sb.capacity());
        System.out.println("length : " + sb.length());
        sb.setLength(201);
        System.out.println("capacity : " + sb.capacity());
        System.out.println("length : " + sb.length());
    }

    private static void methodSixTest(){
        StringBuilder sb = new StringBuilder(4);
        System.out.println("capacity : " + sb.capacity());
        System.out.println("length : " + sb.length());
        System.out.println(sb.append("helloworldHHO"));
        System.out.println("capacity : " + sb.capacity());
        System.out.println("length : " + sb.length());
        System.out.println(sb.append("a"));
        System.out.println("capacity : " + sb.capacity());
        System.out.println("length : " + sb.length());
        StringBuilder newSb = new StringBuilder("hello");
        //reverse() 将顺序反转
        System.out.println(newSb.reverse());
        System.out.println(newSb.reverse());
        newSb.setCharAt(0,'A');
        System.out.println(newSb);
        System.out.println(newSb.subSequence(0,3));
        System.out.println(newSb.substring(2));
        System.out.println(newSb.substring(0,3));
        //尝试减少用于字符序列的存储空间。
        //原本 capacity 为 21
        //再调用了trimToSize() 了之后 capacity 为 length
        StringBuilder stringBuilder = new StringBuilder("hello");
        System.out.println("capacity : " + stringBuilder.capacity());
        System.out.println("length : " + stringBuilder.length());
        stringBuilder.trimToSize();
        System.out.println("capacity : " + stringBuilder.capacity());
        System.out.println("length : " + stringBuilder.length());
    }

    static class SayHay{
        @Override
        public String toString() {
            return "你好";
        }
    }
}
