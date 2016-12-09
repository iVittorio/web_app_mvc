package ru.innopolis.web.exception;

import org.hibernate.HibernateException;

/**
 * Created by i.viktor on 02/12/2016.
 */
public class MyException extends HibernateException {
    public MyException(String message) {
        super(message);
    }

    public MyException(Throwable cause) {
        super(cause);
    }

    public MyException(String message, Throwable cause) {
        super(message, cause);
    }
}
