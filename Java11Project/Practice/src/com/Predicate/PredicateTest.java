package com.Predicate;

import java.util.function.Function;
import java.util.function.Predicate;

public class PredicateTest {
    public static void main(String[] args) {
        Predicate<String> isEmpty = String::isEmpty;
        System.out.println(isEmpty.test(""));
        System.out.println(isEmpty.test("123"));
        isEmpty = isEmpty.and(PredicateTest::checkNumber);
        System.out.println(isEmpty.test("0"));
        System.out.println(isEmpty.test(""));
        Predicate<String> checkOr = String::isEmpty;
        checkOr = checkOr.or(PredicateTest::checkNumber);
        System.out.println(checkOr.test(""));
    }
    private static boolean checkNumber(String value){
        return value.equals("0");
    }
}
