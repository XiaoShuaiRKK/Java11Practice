package com.FinalTest.Test1;

public class TestOneApplication {
    private int x;
    private static int y;

    public static void main(String[] args) {
        TestOneApplication.y = 10;
        TestOneApplication test1 = new TestOneApplication();
        test1.x = 5;
        TestOneApplication test2 = new TestOneApplication();
        test2.x = 8;
        test2.y = 20;
        System.out.println(test1.x + ":" + test1.y);
        System.out.println(test2.x + ":" + test2.y);
        System.out.println(TestOneApplication.y + ":" + y);
    }
}
