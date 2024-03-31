package com.String;

import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.sql.SQLOutput;
import java.util.stream.IntStream;

public class StringTest {
    public static void main(String[] args) {
//        constructorTest();
        methodTest();
    }

    private static void constructorTest() {
        char[] chars = {'h', 'e', 'l', 'l', 'o'};
        byte[] bytes = "hello".getBytes();
        for (byte aByte : bytes) {
            System.out.print(aByte + " ");
        }
        int[] ints = {bytes[0], bytes[1], bytes[2], bytes[3], bytes[4]};
        System.out.println();
        String str = new String(chars, 1, 2);
        String strInt = new String(ints, 0, 2);
        String strCod_UTF8 = new String(bytes, StandardCharsets.UTF_8);
        String strCod_UTF16 = new String(bytes, StandardCharsets.UTF_16);
        System.out.println("String\u200B(char[] value, int offset, int count) : " + str);
        System.out.println("String\u200B(int[] codePoints, int offset, int count) : " + strInt);
        System.out.println("String\u200B(byte[] bytes, Charset charset) - UTF8 : " + strCod_UTF8);
        System.out.println("String\u200B(byte[] bytes, Charset charset) - UTF16 : " + strCod_UTF16);
    }

    private static void methodTest(){
        //codePointAt 将指定的字符转成byte
        System.out.println("hello".codePointAt(2));
        //返回此 String的指定文本范围内的Unicode代码点数。
        System.out.println("hello".codePointCount(0,5));
        //返回int stream
        IntStream intStream = "hello".codePoints();
        intStream.forEach((value)-> System.out.print(value + " "));
        System.out.println();
        //比较 不区分大小写
        System.out.println("HELLO".compareToIgnoreCase("hello"));
        //concat() 将指定的字符串连接到此字符串的末尾。
        System.out.println("hello".concat(",world"));
        //当且仅当此字符串包含指定的char值序列时，才返回true。
        System.out.println("hello".contains("e"));
        System.out.println("hello".contains(new StringBuffer("e")));
        System.out.println("hello".contains(new StringBuffer("e")));
    }
}
