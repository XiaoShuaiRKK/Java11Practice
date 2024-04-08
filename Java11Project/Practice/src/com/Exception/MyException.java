package com.Exception;

public class MyException extends RuntimeException {
    public MyException(){
        super("错误,请重试");
    }

    @Override
    public String getMessage() {
        return super.getMessage();
    }
}
