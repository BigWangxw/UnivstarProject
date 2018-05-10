package com.example.dell.univstarproject.presenter;

import android.content.Context;

import com.example.dell.univstarproject.base.BaseApp;
import com.example.dell.univstarproject.model.bean.MingTeacher;
import com.example.dell.univstarproject.model.entry.DemoService;
import com.example.dell.univstarproject.model.http.RetrofitUtils;

import java.util.HashMap;
import java.util.Map;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

/**
 * 作者:天南地北，旺哥最美！
 * 微信:xw15227039901
 */

public class MingTeacherPresenter implements MingTeacherContrcat.MingTeacherPre{

    private DemoService service;
    private MingTeacherContrcat.MingTeacherView view;

    public MingTeacherPresenter() {
        service = RetrofitUtils.getRetrofitUtils().getService();
    }

    @Override
    public void AcctachView(MingTeacherContrcat.MingTeacherView view) {
        this.view = view;
    }

    @Override
    public void DateView() {
        this.view = null;
    }

    @Override
    public void loadMingTeacher() {
        Map<String,Integer> params = new HashMap<>();
        Map<String,String> headers = new HashMap<>();
        params.put("page",1);
        params.put("loginUserId",0);
        params.put("rows",20);
        params.put("userType",4);
        headers.put("apptoken", BaseApp.activity.getSharedPreferences("111", Context.MODE_PRIVATE).getString("xyxy_apptoken",""));
        service.loadMingTeacher(headers,params).subscribeOn(Schedulers.newThread()).observeOn(AndroidSchedulers.mainThread()).subscribe(new Consumer<MingTeacher>() {
            @Override
            public void accept(MingTeacher teacher) throws Exception {
                if (teacher !=null) {
                    view.showMingteacher(teacher);
                } else {
                    return;
                }
            }
        });

    }

    @Override
    public void loadMingTeacher(Integer page, Integer rows,Integer loginUserId, Integer usertype) {
        Map<String,Integer> params = new HashMap<>();
        Map<String,String> headers = new HashMap<>();
        params.put("page",page);
        params.put("rows",rows);
        params.put("loginUserId",loginUserId);
        params.put("userType",usertype);
        headers.put("apptoken", BaseApp.activity.getSharedPreferences("111", Context.MODE_PRIVATE).getString("xyxy_apptoken",""));
        service.loadMingTeacher(headers,params).subscribeOn(Schedulers.newThread()).observeOn(AndroidSchedulers.mainThread()).subscribe(new Consumer<MingTeacher>() {
            @Override
            public void accept(MingTeacher teacher) throws Exception {
                if (teacher !=null) {
                    view.showMingteacher(teacher);
                } else {
                    return;
                }
            }
        });
    }
}
