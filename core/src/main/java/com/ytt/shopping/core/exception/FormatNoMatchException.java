package com.ytt.shopping.core.exception;

/**
 * @Author: aaron
 * @Descriotion:
 * @Date: 22:31 2019/6/10
 * @Modiflid By:
 */
public class FormatNoMatchException extends RuntimeException{
    public FormatNoMatchException() {
        super();
    }

    public FormatNoMatchException(String message) {
        super(message);
    }

    public FormatNoMatchException(String message, Throwable cause) {
        super(message, cause);
    }

    public FormatNoMatchException(Throwable cause) {
        super(cause);
    }

    protected FormatNoMatchException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
