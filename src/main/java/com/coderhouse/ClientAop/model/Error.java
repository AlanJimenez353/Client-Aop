package com.coderhouse.ClientAop.model;

public class Error {
    private String msg;

    public Error(String msg) {
        this.setMsg(msg);
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}

