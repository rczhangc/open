package org.open.boot.api.kuaidizs.exception;

/**
 * @author barnak
 */
public class KdzsException extends RuntimeException {

    public KdzsException() {
        super();
    }

    public KdzsException(String message) {
        super(message);
    }

    public KdzsException(String message, Throwable cause) {
        super(message, cause);
    }

    public KdzsException(Throwable cause) {
        super(cause);
    }

    protected KdzsException(String message, Throwable cause,
                               boolean enableSuppression,
                               boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
