package com.example.dell.univstarproject.model.bean;

import com.google.gson.Gson;

/**
 * 作者:天南地北，旺哥最美！
 * 微信:xw15227039901
 */

public class AppTokenBean {

    /**
     * code : 0
     * message : 成功
     * data : {"apptoken":"G00hN1wuqkr/NStp+5iS7itUQup0nEDpNHELksZAl9yaUIXK1tVHgg=="}
     */

    private int code;
    private String message;
    private DataBean data;

    public static AppTokenBean objectFromData(String str) {

        return new Gson().fromJson(str, AppTokenBean.class);
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
        /**
         * apptoken : G00hN1wuqkr/NStp+5iS7itUQup0nEDpNHELksZAl9yaUIXK1tVHgg==
         */

        private String apptoken;

        public static DataBean objectFromData(String str) {

            return new Gson().fromJson(str, DataBean.class);
        }

        public String getApptoken() {
            return apptoken;
        }

        public void setApptoken(String apptoken) {
            this.apptoken = apptoken;
        }
    }
}
