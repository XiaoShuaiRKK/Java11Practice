package com.Lambda;

import com.Lambda.Functional.ICompute;
import com.Lambda.Util.AddUtil;

import java.util.Arrays;
import java.util.List;

public class LambdaTest {
    public static void main(String[] args) {
        System.out.println(new AddUtil(() -> 1.5 + 5.5).add());
    }
}
