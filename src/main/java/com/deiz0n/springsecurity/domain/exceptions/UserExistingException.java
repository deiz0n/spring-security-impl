package com.deiz0n.springsecurity.domain.exceptions;

public class UserExistingException extends RuntimeException{

    public UserExistingException(String msg) {
        super(msg);
    }
}
