package com.ytt.shopping.core.exception;

/**
 * @Author: aaron
 * @Descriotion:
 * @Date: 18:39 2019/6/10
 * @Modiflid By:
 */
public class OutOfRootTreeNodeException extends RuntimeException {

    public OutOfRootTreeNodeException() {
    }

    public OutOfRootTreeNodeException(String message) {
        super(message);
    }

    public OutOfRootTreeNodeException(String message, Throwable cause) {
        super(message, cause);
    }

    public OutOfRootTreeNodeException(Throwable cause) {
        super(cause);
    }

    public OutOfRootTreeNodeException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
