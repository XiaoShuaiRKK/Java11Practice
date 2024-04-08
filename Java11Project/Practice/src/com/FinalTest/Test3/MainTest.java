package com.FinalTest.Test3;

import java.util.Optional;

public class MainTest {
    public static void main(String[] args) {
        Optional<String> value = createValue();
        String str = value.orElse("Duke");
        System.out.println(str);
    }

    private static Optional<String> createValue(){
        String s = null;
        return Optional.ofNullable(s);
    }
}
