package com.Predicate;

import java.nio.file.Files;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.HashMap;
import java.util.Map;
import java.util.function.BiPredicate;

public class BiPredicateTest {
    public static void main(String[] args) {
        BiPredicate<String,Integer> biPredicate = (name,length) -> name.length() == length;
        System.out.println(biPredicate.test("hello",5));
        Map<String,Integer> localTest = new HashMap<>();
        localTest.put("Google",6);
        localTest.put("Microsoft",5);
        localTest.put("Alibaba",7);
        localTest.entrySet()
                .stream()
                .filter(entry -> biPredicate.test(entry.getKey(), entry.getValue()))
                .forEach(System.out::println);
    }
}
