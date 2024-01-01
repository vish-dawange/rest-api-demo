package com.example.demo.helloworld;

public class HelloWorldBean {

    private String message;

    public String getMessage() {
        return this.message;
    }

    public void setMessage(String message) {
        this.message = message;
    };

    public HelloWorldBean(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return "Hello world bean " + message;

    }

}
