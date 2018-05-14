package com.example.dell.univstarproject.start.model.bean;

import android.content.Context;

import com.example.dell.univstarproject.base.BaseApp;

import java.util.HashMap;
import java.util.Map;

/**
 * 作者:天南地北，旺哥最美！
 * 微信:xw15227039901
 */

public class DianZanUtils {
    private static DianZanUtils dianZanUtils;

    private DianZanUtils() {

    }
    public static DianZanUtils getDianZanUtils () {
        if (dianZanUtils == null) {
            synchronized (DianZanUtils.class) {
                if (dianZanUtils == null) {
                    dianZanUtils = new DianZanUtils();
                }
            }
        }
        return dianZanUtils;
    }

    public  Map<String, String> getparamsMap(String userid, String id, String loginid, String type) {
        Map<String,String> params = new HashMap<>();
        params.put("userId", userid);
        params.put("id",id);
        params.put("loginUserId",loginid);
        params.put("type",type);
        return params;
    }
    public  Map getheadres () {
        Map<String,String> headers = new HashMap<>();
        headers.put("apptoken", BaseApp.activity.getSharedPreferences("111", Context.MODE_PRIVATE).getString("xyxy_apptoken",""));
        return headers;
    }
}
