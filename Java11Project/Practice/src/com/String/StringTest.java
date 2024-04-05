package com.String;

import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.sql.SQLOutput;
import java.util.*;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class StringTest {
    public static void main(String[] args) {
//        constructorTest();
//        methodTest();
//        methodTwoTest();
//        methodThreeTest();
//        methodFourTest();
//        methodFiveTest();
//        methodSixTest();
//        methodSevenTest();
//        methodEightTest();
//        staticMethodTest();
//        staticMethodDateFormat();
//        staticMethodTimeFormat();
        staticMethodTwo();
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
        //将此字符串与指定的对象进行比较。
        System.out.println("HELLO".equalsIgnoreCase("hello"));
        //concat() 将指定的字符串连接到此字符串的末尾。
        System.out.println("hello".concat(",world"));
        //当且仅当此字符串包含指定的char值序列时，才返回true。
        System.out.println("hello".contains("e"));
        System.out.println("hello".contains(new StringBuffer("e")));
        System.out.println("hello".contains(new StringBuffer("e")));
        //将此字符串与指定的 CharSequence
        System.out.println("hello".contentEquals(new StringBuffer("hello")));
        byte[] bytes = "hello".getBytes();
        System.out.println("hello".contentEquals(new String(bytes,StandardCharsets.UTF_8)));
    }

    private static void methodTwoTest(){
        System.out.println("hello".startsWith("lo"));
        System.out.println("hello".startsWith("he"));
        System.out.println("hello".startsWith("ll",1));
        System.out.println("hello".startsWith("ll",2));
        //测试此字符串是否以指定的后缀结尾。
        System.out.println("hello".endsWith("lo"));
        try {
            System.out.println("getBytes(String charsetName) - UTF8 : ");
            for(byte b : "hello".getBytes("UTF-8"))
                System.out.print(b + " ");
            System.out.println();
            System.out.println("getBytes(Charset charset) - UTF8 : ");
            for (byte aByte : "hello".getBytes(StandardCharsets.UTF_8))
                System.out.print(aByte + " ");
            System.out.println();
            System.out.println("getBytes(String charsetName) - UTF16 : ");
            for(byte b : "hello".getBytes("UTF-16"))
                System.out.print(b + " ");
            System.out.println();
            System.out.println("getBytes(Charset charset) - UTF16 : ");
            for(byte b : "hello".getBytes(StandardCharsets.UTF_16))
                System.out.print(b + " ");
            System.out.println();
        } catch (UnsupportedEncodingException e) {
            throw new RuntimeException(e);
        }
        //将此字符串中的字符复制到目标字符数组中
        char[] values = {'w','o','r','l','d'};
        "hello".getChars(0,3,values,0);
        System.out.println(values);
        //返回此字符串的哈希码。
        System.out.println("hashCode() : " + "hello".hashCode());
    }

    private static void methodThreeTest(){
        byte[] bytes = "hello".getBytes();
        //返回指定字符第一次出现的字符串中的索引。
        System.out.println("hello".indexOf(bytes[2]));
        System.out.println("hello".indexOf(bytes[2],3));
        System.out.println("hello,world".indexOf(",w"));
        System.out.println("hellollo".indexOf("ll"));
        System.out.println("hellollo".indexOf("ll",3));
        System.out.println("String::intern() 它的作用是如果字符串常量池中已经包含一个等于此 String 对象的字符串，\n" +
                "则返回代表池中这个字符串的 String 对象的引用；\n" +
                "否则，会将此 String 对象包含的字符串添加到常量池中，并且返回此 String 对象的引用。");
        String s1 = new StringBuilder().append("hello").append(",world").toString();
        System.out.println(s1.intern() == s1);
        String s2 = new StringBuilder().append("ja").append("va").toString().intern();
        System.out.println(s2.intern() == s2);
        //isBlank()
        //如果字符串为空或仅包含 white space代码点，则返回 true ，否则 false 。
        //isEmpty()
        //返回 true ，当且仅当， length()是 0 。
        String emptyStr = "",blankStr = " ",nullStr = null;
        System.out.println("blankStr is blank : " + blankStr.isBlank());
        System.out.println("blankStr is empty : " + blankStr.isEmpty());
        System.out.println("emptyStr is blank : " + emptyStr.isBlank());
        System.out.println("emptyStr is empty : " + emptyStr.isEmpty());
    }

    private static void methodFourTest(){
        System.out.println("hellol".lastIndexOf('l'));
        //lastIndexOf(String str, int fromIndex)
        //返回指定子字符串最后一次出现的字符串中的索引，从指定索引开始向后搜索。
        System.out.println("hellol".lastIndexOf('l',3));
        Stream<String> stream = "hello".lines();
        stream.map(String::toUpperCase).forEach(System.out::println);
        System.out.println("hello".matches("(.*)"));
        System.out.println("hello,world".matches("(.*)world"));
        System.out.println("hello,world".matches("(.*),(.*)"));
        System.out.println("hello,world".matches("(.*),hello"));
        //测试两个字符串区域是否相等。
        //ignoreCase 如果为true则忽略大小写
        //toffset "hello,world" 此字符串中的区域偏移量 toffset = 4 则从o开始
        //other 要比较的str
        //ooffset 字符串参数中的区域起始偏移量
        //len 要比较的长度
        System.out.println("hello,world".regionMatches(4,"o,w",0,3));
        System.out.println("hello,world".regionMatches(0,"o,w",0,3));
        System.out.println("hello,world".regionMatches(true,4,"O,W",0,3));
        System.out.println("hello,world".regionMatches(true,4,"O,w",0,3));
        System.out.println("hello,world".regionMatches(false,4,"O,w",0,3));
    }

    private static void methodFiveTest(){
        //返回一个字符串，其值为此字符串的串联重复 count次。0的话则为空字符
        System.out.println("hello ".repeat(5));
        System.out.println("hello ".repeat(0));
        //	replace(char oldChar, char newChar)
        //	返回从替换所有出现的导致一个字符串 oldChar在此字符串 newChar 。
        //	replace(CharSequence target, CharSequence replacement)
        //	将此字符串中与文字目标序列匹配的每个子字符串替换为指定的文字替换序列。
        //如果有则替换无则返回原来的字符串
        //如果target为""则在每个字符的前后面穿插 如 hello 变成 ahaealalaoa
        System.out.println("hello".replace("h","a"));
        System.out.println("hello".replace("","aaaa"));
        System.out.println("hello".replace("hello","aaaa"));
        System.out.println("hello".replace("","a"));
        System.out.println("hello".replace('h','a'));
        System.out.println("hello".replace('h','a'));
        System.out.println("hello".replace("a","h"));
        System.out.println("hello".replace('a','h'));
        System.out.println("hello".replace("l","p"));
        System.out.println("hello".replace("ll","p"));
        System.out.println("hello".replace('l','p'));
        //	replaceAll(String regex, String replacement)
        //将给定替换的给定 regular expression匹配的此字符串的每个子字符串替换。
        System.out.println("hello".replaceAll("(.*)o(.*)","all"));
        System.out.println("hello".replaceAll("(.*)","all"));
        System.out.println("hello".replaceAll("(.)","all"));
        System.out.println("hello".replaceAll("()","all"));
        System.out.println("hello".replaceAll("","all"));
        System.out.println("h11e22l33l44o".replaceAll("\\d+",""));
        System.out.println("h11e22l33l44o".replaceAll("(?:h)\\d+",""));
        System.out.println("h11e22l33l44o".replaceAll("h\\d+",""));
        System.out.println("h11e22l33l44o".replaceAll("(h)\\d+","$1"));
        //	replaceFirst(String regex, String replacement)
        //将给定替换的给定 regular expression匹配的此字符串的第一个子字符串替换。
        System.out.println("hello".replaceFirst("(l)","p"));
        System.out.println("hello".replaceFirst("(l)","p").replaceFirst("l","p"));
    }

    private static void methodSixTest(){
        System.out.println("------split(String regex)------");
        printArrayString("hello".split("e"));
        printArrayString("hello".split("l"));
        printArrayString("a,,b,,c".split(","));
        printArrayString("a,,,b,,,c".split(","));
        printArrayString("a,,b,,c,".split(","));
        printArrayString(",a,,b,,c,".split(","));
        printArrayString(",a,,b,,c,,".split(","));
        printArrayString(",,a,,b,,c,,".split(","));
        System.out.println("------split(String regex,int limit)------");
        printArrayString("hello".split("e",0));
        printArrayString("hello".split("e",1));
        printArrayString("hello hello".split("e",1));
        printArrayString("hello hello".split("e",2));
        printArrayString("hello hello".split("e",3));
        printArrayString("hello hello".split("e",4));
        printArrayString("hello".split("l",1));
        printArrayString("hello".split("l",2));
        printArrayString("hello".split("l",3));
    }

    private static void methodSevenTest(){
        System.out.println("hello".startsWith("h"));
        System.out.println("hello".startsWith("he"));
        System.out.println("hello".startsWith("e"));
        System.out.println("hello".startsWith("e",1));
        System.out.println("hello".startsWith("e",2));
        //trim()方法无法删除掉Unicode空白字符，但用Character.isWhitespace©方法可以判断出来
        //\u2000这个值trim无法去除
        System.out.println(" hello ".trim());
        System.out.println("\u2000hello ".trim());
        //返回一个字符串，其值为此字符串，并删除了所有前导 white space 。
        System.out.println(" hello a".strip());
        System.out.println(" hello ".strip() + "a");
        System.out.println(" hello ".stripLeading() + "a");
        System.out.println(" hello ".stripTrailing() + "a");
        System.out.println(" hello ".strip() + "a");
        //正则表达式来去除空格
        System.out.println(" hello ".replaceAll("^[ \t]+|[ \t]+$","") + "a");
        System.out.println(" hello ".replaceAll("^[ \t]+","") + "a");
        System.out.println(" hello ".replaceAll("[ \t]+$","") + "a");
    }

    private static void methodEightTest(){
        System.out.println("hello".substring(0));
        System.out.println("hello".substring(1));
        System.out.println("hello".substring(2));
        System.out.println("hello".substring(3));
        System.out.println("hello".substring(4));
        System.out.println("".equals("hello".substring(5)));
        System.out.println("hello".substring(0,5));
        System.out.println("hello".substring(1,4));
        System.out.println("hello".substring(2,3));
        System.out.println(Arrays.toString("hello".toCharArray()));
        System.out.println(Arrays.toString("  ".toCharArray()));
        System.out.println(Arrays.toString("    ".toCharArray()));
        System.out.println("Hello".toLowerCase());
        System.out.println("HELLO".toLowerCase());
        System.out.println("Ni好".toLowerCase(Locale.getDefault()));
        System.out.println("Ni好".toLowerCase(Locale.ROOT));
        System.out.println("Ni好".toLowerCase(Locale.CHINA));
        System.out.println("Ni好".toLowerCase(Locale.SIMPLIFIED_CHINESE));
        System.out.println("Ni好".toLowerCase(Locale.TAIWAN));
        System.out.println("Ni好".toLowerCase(Locale.US));
        System.out.println("Ni好".toUpperCase());
        System.out.println("Ni好".toUpperCase(Locale.getDefault()));
        System.out.println("Ni好".toUpperCase(Locale.CHINA));
        System.out.println("Ni好".toUpperCase(Locale.SIMPLIFIED_CHINESE));
        System.out.println("Ni好".toUpperCase(Locale.TAIWAN));
        System.out.println("Ni好".toUpperCase(Locale.US));
        System.out.println("Ni好".toUpperCase(Locale.UK));
        System.out.println("".toLowerCase());
        System.out.println("  ".toLowerCase());
        System.out.println("\u2000\u2000".toLowerCase());
        System.out.println("、｜?./\\".toLowerCase());
        System.out.println("".toUpperCase());
        System.out.println("  ".toUpperCase());
        System.out.println("\u2000\u2000".toUpperCase());
        System.out.println("、｜?./\\".toUpperCase());
    }



    private static void printArrayString(Object[] value){
        Arrays.stream(value).forEach((v) ->{
            if("".equals(v))
                System.out.print("empty");
            else
                System.out.print(v);
            System.out.print("|");
        });
        System.out.print("   length : " + value.length);
        System.out.println();
    }

    private static void methodBycode(){
        //返回此 String中的索引，该索引从给定的 index偏移 codePointOffset代码点。
        String n = "hello";
        System.out.println(n.offsetByCodePoints(4,-1));
        System.out.println(n);
    }

    private static void staticMethodTest(){
        char[] chars = {'h','e','l','l','o'};
        //相当于 valueOf(char[]) 。
        System.out.println(String.copyValueOf(chars));
        //相当于 valueOf(char[], int, int) 。
        System.out.println(String.copyValueOf(chars,0,2));
        //使用指定的格式字符串和参数返回格式化字符串。
        //%s = string
        System.out.println(String.format("hello,%s","world"));
        System.out.println(String.format("hello,%s",'c'));
        //%c = char
        System.out.println(String.format("hello,%c",'c'));
        //%b  = boolean
        System.out.println(String.format("hello,%b",true));
        //%d = 整形(十进制) = decimal
        System.out.println(String.format("hello,%d",577));
        System.out.println(String.format("hello,%d",0xFFFFFFFF));
        //%x = 整形(十六进制) = hexadecimal
        System.out.println(String.format("hello,%x",0xFFFFFFFF));
        System.out.println(String.format("hello,%x",0x01101FFF));
        System.out.println(String.format("hello,%x",51));
        //%o 整形(八进制) = octal
        System.out.println(String.format("hello,%o",51));
        System.out.println(String.format("hello,%o",77));
        System.out.println(String.format("hello,%o",7));
        System.out.println(String.format("hello,%o",72));
        System.out.println(String.format("hello,%o",9));
        //%f 浮点数 float
        System.out.println(String.format("hello,%f",15.55));
        System.out.println(String.format("hello,%f",10.25D));
        System.out.println(String.format("hello,%f",15.55F));
        System.out.println(String.format("hello,%f",10.25F));
        System.out.println(String.format("hello,%f",10.D));
        System.out.println(String.format("hello,%f",10.F));
        System.out.println(String.format("hello,%f",-0.05D));
        System.out.println(String.format("hello,%f",-0.05F));
        System.out.println(String.format("hello,%f",10F));
        //Error
//        System.out.println(String.format("hello,%f",10));
        //%a 十六进制浮点类型
        System.out.println(String.format("hello,%a",10F));
        System.out.println(String.format("hello,%a",10D));
        //Error
//        System.out.println(String.format("hello,%a",0xFFF));
//        System.out.println(String.format("hello,%a",100));
        //%e 指数类型
        System.out.println(String.format("hello,%e",10D));
        System.out.println(String.format("hello,%e",10F));
        System.out.println(String.format("hello,%e",10F * 5000D));
        //%g 通用浮点类型（f和e类型中较短的）
        System.out.println(String.format("hello,%g",10D));
        System.out.println(String.format("hello,%g",10F));
        System.out.println(String.format("hello,%g",10F * 5000D));
        System.out.println(String.format("hello,%g",10F * 5000000000D));
        //%h 散列码
        System.out.println(String.format("hello,%h",'A'));
        System.out.println(String.format("hello,%h",'B'));
        System.out.println(String.format("hello,%h",10));
        System.out.println(String.format("hello,%h",11));
        //%% 百分比类型
        System.out.println(String.format("hello,%d%%",85));
        
        //$使用
        System.out.println(String.format("hello,%1$d,%2$s",100,"ABC"));
        System.out.println(String.format("hello,%2$d,%1$s","你好",577));
        //+为正数或者负数添加符号
        System.out.println(String.format("hello,%+d",15));
        //-左对齐 如｜%-10d｜相当在值的右侧加了10个空格
        System.out.println(String.format("hello,|%-10d|",15));
        //右对齐 在整数之前添加指定数量的空格
        System.out.println(String.format("hello,|%10d|",15));
        //在值之前添加指定数量的0
        System.out.println(String.format("hello,|%05d|",15));
        //以“,”对数字分组 如1500 变成 1,500
        System.out.println(String.format("hello,|%,f|",15000.0D));
        //使用括号包含负数 如-10 变成(10) 正数则不会变
        System.out.println(String.format("hello,|%(f|",-15000D));
        System.out.println(String.format("hello,|%(f|",15000D));
        //# 如果是浮点数则包含小数点，如果是16进制或8进制则添加0x或0
        System.out.println(String.format("hello,|%#x|",99));
        System.out.println(String.format("hello,|%#o|",99));
        //< 格式化前一个转换符所描述的参数
        System.out.println(String.format("hello,|%f和%<3.0f|",99.45D));
        System.out.println(String.format("hello,|%f和%<3.2f|",99.45D));
        System.out.println(String.format("hello,|%f和%<3.5f|",99.45D));
    }

    private static void staticMethodDateFormat(){
        Date date = new Date();
        //c 包括全部日期和时间信息
        System.out.println(String.format("全部日期和时间信息: %tc",date));
        //F “年-月-日”格式
        System.out.println(String.format("“年-月-日”格式: %tF",date));
        //D “月/日/年”格式
        System.out.println(String.format("“月/日/年”格式: %tD",date));
        //r “HH:MM:SS PM”格式（12时制）
        System.out.println(String.format("“HH:MM:SS PM”格式（12时制）: %tr",date));
        //T “HH:MM:SS”格式（24时制）
        System.out.println(String.format("“HH:MM:SS”格式（24时制）: %tT",date));
        //R “HH:MM”格式（24时制）
        System.out.println(String.format("“HH:MM:SS”格式（24时制）: %tR",date));
        System.out.println(String.format("中文月份的简称: %tb",date));
        System.out.println(String.format(Locale.US,"英文月份的简称: %tb",date));
        System.out.println(String.format(Locale.KOREA,"韩文月份的简称: %tb",date));
        //%ta 星期
        System.out.println(String.format("中文星期的简称: %ta",date));
        System.out.println(String.format(Locale.US,"英文星期的简称: %ta",date));
        System.out.println(String.format(Locale.KOREA,"英文星期的简称: %ta",date));
        ///%tm 月份
        System.out.println(String.format("两位数字的月份(不足两位前面补0) : %tm",date));
        //%td 日补0
        System.out.println(String.format("两位数字的日 (不足两位前面补0) : %td",date));
        //%te 日不补0
        System.out.println(String.format("两位数字的日 (一位不补零) : %te",date));
        System.out.println(String.format("两位数字的日 (一位不补零) : %te",date));
    }

    public static void staticMethodTimeFormat(){
        Date date = new Date();
        //%tH 24小时 不足补0
        System.out.println(String.format("2位数字24时制的小时(不足2位补0) : %tH h",date));
        //%tI 12小时 不足补0
        System.out.println(String.format("2位数字12时制的小时(不足2位补0) : %tI h",date));
        //%tk 24小时 不补0
        System.out.println(String.format("2位数字24时制的小时(不足2位补0) : %tk h",date));
        //%tl 12小时 不补0
        System.out.println(String.format("2位数字12时制的小时(不足2位补0) : %tl h",date));
        //%tM 分钟 不足补0
        System.out.println(String.format("2位数字分钟 (不足2位补0) : %tM min",date));
        //%tS 秒 不足补0
        System.out.println(String.format("2位数字秒 (不足2位补0) : %tS s",date));
        //%tL 三位毫秒 不足补0
        System.out.println(String.format("3位数字毫秒 (不足3位补0) : %tL ms",date));
        //%tN 九位毫秒 不足补0
        System.out.println(String.format("9位数字毫秒 (不足9位补0) : %tN ms",date));
        //%tp 上午或者下午
        System.out.println(String.format(Locale.US,"小写字母的上午或者下午标记(英) : %tp",date));
        System.out.println(String.format(Locale.CHINA,"小写字母的上午或者下午标记(中) : %tp",date));
        System.out.println(String.format(Locale.JAPAN,"小写字母的上午或者下午标记(日) : %tp",date));
        System.out.println(String.format(Locale.KOREA,"小写字母的上午或者下午标记(韩) : %tp",date));
        //%tz
        System.out.println(String.format("相对于GMT的RFC822时区偏移量 : %tz",date));
        //%ts 待验证真实性
        System.out.println(String.format("1990-1-1 00:00:00 到现在的经过的秒数 : %ts",date));
        //%tQ 待验证真实性
        System.out.println(String.format("1990-1-1 00:00:00 到现在的经过的毫秒数 : %tQ",date));
    }

    private static void staticMethodTwo(){
        String[] strArrays = {"a","b","c","d"};
        List<String> strList = new ArrayList<>();
        for(int i = 97;i <= 100;i++)
            strList.add(String.valueOf((char) i));
        System.out.println(String.join("||", strArrays));
        System.out.println(String.join("||",strList));
        System.out.println(String.join("||","a","b","c","d"));
    }
}
