package com.example.dell.univstarproject.start.presenter;


import android.content.Context;
import android.content.SharedPreferences;

import com.example.dell.univstarproject.base.BaseApp;
import com.example.dell.univstarproject.model.http.RetrofitUtils;
import com.example.dell.univstarproject.model.url.Service;
import com.example.dell.univstarproject.start.model.bean.NewstBean;

import java.util.HashMap;
import java.util.Map;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

/**
 * 作者:天南地北，旺哥最美！
 * 微信:xw15227039901
 */

public class NewstPresenter implements NewtContrcat.NewsPre{
    private Service service;
    private NewtContrcat.NewsView view;

    public NewstPresenter() {
        service = RetrofitUtils.getRetrofitUtils().getService();
    }


    @Override
    public void AcctachView(NewtContrcat.NewsView view) {
        this.view = view;
    }

    @Override
    public void DateView() {
        this.view = null;
    }

    @Override
    public void loaddata() {
        Map<String,String> params = new HashMap<>();
        params.put("page","1");
        params.put("rows","20");
        params.put("loginUserId","0");
        params.put("sortord","2");
        Map<String,String> headers = new HashMap<>();
        SharedPreferences apptoken = BaseApp.activity.getSharedPreferences("appToken", Context.MODE_PRIVATE);
        String token = apptoken.getString("apptoken", "");
        headers.put("apptoken",token);
        service.loadnewtbeandata(headers,params).subscribeOn(Schedulers.newThread()).observeOn(AndroidSchedulers.mainThread()).subscribe(new Observer<NewstBean>() {
            @Override
            public void onSubscribe(Disposable d) {

            }

            @Override
            public void onNext(NewstBean value) {
                if (value !=null) {
                    view.showDemodata(value);
                } else {
                    view.showErrorMessage("请求异常");
                }

            }

            @Override
            public void onError(Throwable e) {
                view.showErrorMessage(e.getMessage());
            }

            @Override
            public void onComplete() {

            }
        });
    }
}
