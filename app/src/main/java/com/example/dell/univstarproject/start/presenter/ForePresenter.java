package com.example.dell.univstarproject.start.presenter;

import android.content.Context;
import android.content.SharedPreferences;

import com.example.dell.univstarproject.base.BaseApp;
import com.example.dell.univstarproject.model.http.RetrofitUtils;
import com.example.dell.univstarproject.model.url.Service;
import com.example.dell.univstarproject.start.model.bean.ForeBean;

import java.util.HashMap;
import java.util.Map;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

/**
 * 作者:天南地北，旺哥最美！
 * 微信:xw15227039901
 */

public class ForePresenter implements ForeContrcat.ForePre{

    private Service service;
    private ForeContrcat.ForeView view;

    public ForePresenter() {
        service = RetrofitUtils.getRetrofitUtils().getService();
    }

    @Override
    public void AcctachView(ForeContrcat.ForeView view) {
        this.view = view;
    }

    @Override
    public void DateView() {
        this.view = null;
    }

    @Override
    public void loadforedata() {
        Map<String,String> headers = new HashMap<>();
        Map<String,String> params = new HashMap<>();
        SharedPreferences apptoken = BaseApp.activity.getSharedPreferences("appToken", Context.MODE_PRIVATE);
        String token = apptoken.getString("apptoken", "");
        headers.put("apptoken",token);
        params.put("page","1");
        params.put("rows","20");
        params.put("loginUserId","");
        params.put("startDate","");
        params.put("endDate","");
        service.loadforedata(headers,params).subscribeOn(Schedulers.newThread()).observeOn(AndroidSchedulers.mainThread()).subscribe(new Consumer<ForeBean>() {
            @Override
            public void accept(ForeBean foreBean) throws Exception {
                if (foreBean !=null) {
                    view.showbean(foreBean);
                }
            }
        });
    }
}
