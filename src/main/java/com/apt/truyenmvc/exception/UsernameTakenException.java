package com.apt.truyenmvc.exception;

/**
 * @author Huy Thang on 12/10/2018
 * @project truyenmvc
 */
public class UsernameTakenException extends Exception {

    public UsernameTakenException(String message) {
        super(message);
    }

    public UsernameTakenException(String message, Throwable cause) {
        super(message, cause);
    }
}
