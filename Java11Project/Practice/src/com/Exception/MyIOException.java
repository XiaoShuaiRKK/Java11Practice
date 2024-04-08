package com.Exception;

import java.io.IOException;

public class MyIOException extends IOException {
    public MyIOException(){
        super("此错误是IOException 必须要try catch捕获 或者 抛出");
    }
}
