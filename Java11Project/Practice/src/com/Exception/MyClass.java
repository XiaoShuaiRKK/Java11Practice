package com.Exception;

public class MyClass {
    private int value;
    private String fileName;

    //throws 声明此方法可能会抛出异常
    public void setValue(int value) throws MyException {
        if(value < 0)
            throw new MyException();
        this.value = value;
    }

    public int getValue(){
        return value;
    }

    public void setFile(String fileName) throws MyIOException {
        if(fileName.isBlank())
            throw new MyIOException();
        this.fileName = fileName;
    }

    public String getFile(){
        return fileName;
    }
}
