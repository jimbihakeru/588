package com.five88.models;

public class MsgModel {

    public String testCase;
    public Object data;
    public String expected;

    public MsgModel(String testCase, Object data, String expected) {
        this.testCase = testCase;
        this.data = data;
        this.expected = expected;
    }
}
