package com.xc.crowdfunding.exception;

public class LoginFailException extends RuntimeException{
    public LoginFailException(String msg){
        super(msg);
    }
}
