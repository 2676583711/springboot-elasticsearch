package cn.zhou.eslaticsearch.exception;

import java.io.PrintStream;

public class MyException extends Exception {

    public MyException() {
        super();
    }

    public void printStackTrace(String message) {
        System.out.println("现在的异常是：" + message);
    }
}
