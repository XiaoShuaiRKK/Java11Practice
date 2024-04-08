package com.Exception;

public class ExceptionTest {
    public static void main(String[] args) {
        MyClass myClass = new MyClass();
        myClass.setValue(5);
        System.out.println(myClass.getValue());
        try {
            myClass.setFile("");
            System.out.println(myClass.getFile());
        } catch (MyIOException e) {
            throw new RuntimeException(e);
        }
    }

}
