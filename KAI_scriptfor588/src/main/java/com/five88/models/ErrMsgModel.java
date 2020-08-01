package com.five88.models;

public class ErrMsgModel extends MsgModel {
    public Object result;

    public ErrMsgModel(String testCaseName, Object data, String expected, Object result) {
        super(testCaseName, data, expected);
        this.result = result;
    }
}
