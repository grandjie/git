package com.jie.helloservice.common.http;

public class RequestException extends Exception {

    public RequestException(String message) {
        super(message);
    }

    public RequestException(String message, Exception e) {
        super(message, e);
    }

    public RequestException(Exception e) {
        super(e);
    }

}
