package com.example.dell.univstarproject.model.bean;

import android.content.Context;
import android.widget.Toast;

/**
 * 作者:天南地北，旺哥最美！
 * 微信:xw15227039901
 */

public class ToastBean {
    public static void showmessage (Context context, String msg) {
        Toast.makeText(context,msg,Toast.LENGTH_SHORT).show();
    }
}
