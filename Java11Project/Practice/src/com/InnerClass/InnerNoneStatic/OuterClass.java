package com.InnerClass.InnerNoneStatic;

public class OuterClass {
    int x = 10;
    class InnerClass{
        int y = 5;
        public int getOuterValue(){
            return x;
        }
    }
}
