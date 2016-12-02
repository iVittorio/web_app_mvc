package ru.innopolis.web.exception;

/**
 * Created by i.viktor on 02/12/2016.
 */
public class MyException extends RuntimeException {
    private String exceptionMsg;

    public MyException(String exceptionMsg) {
        this.exceptionMsg = exceptionMsg;
    }

    public String getExceptionMsg(){
        return this.exceptionMsg;
    }

    public void setExceptionMsg(String exceptionMsg) {
        this.exceptionMsg = exceptionMsg;
    }
}
