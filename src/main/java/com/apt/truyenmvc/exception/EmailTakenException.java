package com.apt.truyenmvc.exception;

/**
 * @author Huy Thang on 12/10/2018
 * @project truyenmvc
 */

public class EmailTakenException extends Exception {
    public EmailTakenException(String message) {
        super(message);
    }

    public EmailTakenException(String message, Throwable cause) {
        super(message, cause);
    }
}
