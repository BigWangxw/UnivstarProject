package com.example.dell.univstarproject.model.bean;

import com.google.gson.Gson;

/**
 * 作者:天南地北，旺哥最美！
 * 微信:xw15227039901
 */

public class ZanClick {

    /**
     * code : 0
     * message : 成功
     * data : {}
     */

    private int code;
    private String message;
    private DataBean data;

    public static ZanClick objectFromData(String str) {

        return new Gson().fromJson(str, ZanClick.class);
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public DataBean getData() {
        return data;
    }

    public void setData(DataBean data) {
        this.data = data;
    }

    public static class DataBean {
        public static DataBean objectFromData(String str) {

            return new Gson().fromJson(str, DataBean.class);
        }
    }
}
