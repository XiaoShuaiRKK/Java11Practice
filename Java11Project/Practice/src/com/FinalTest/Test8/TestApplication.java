package com.FinalTest.Test8;

import java.sql.DriverManager;
import java.sql.PreparedStatement;

/**
 * 未指定泛型默认是Object
 */
public class TestApplication extends CustomType {
    public static void main(String[] args) {
        String[] words = {"banana","orange","apple","lemon"};
        Integer[] numbers = {1,2,3,4,5};
        CustomType type = new CustomType();
        CustomType<String> stringType = new CustomType<>();
        System.out.println(stringType.count(words,"apple"));
        System.out.println(type.count(words,"apple"));
        System.out.println(type.count(numbers,3));
    }
}
