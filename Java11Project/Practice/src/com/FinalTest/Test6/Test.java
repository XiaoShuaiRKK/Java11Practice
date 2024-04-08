package com.FinalTest.Test6;

public class Test {
    enum Alphabet{
        A,B,C;
        static String getFirstLetter(){
            return Alphabet.values()[0].toString();
        }
        static String getFirstLetterByName(){
            return Alphabet.A.toString();
        }
    }

    public static void main(String[] args) {
        System.out.println(Alphabet.getFirstLetter());
        System.out.println(Alphabet.getFirstLetterByName());
    }
}
