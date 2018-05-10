package com.example.dell.univstarproject.presenter;

import android.content.Context;

import com.example.dell.univstarproject.base.BaseApp;
import com.example.dell.univstarproject.model.bean.FirstBean;
import com.example.dell.univstarproject.model.entry.DemoService;
import com.example.dell.univstarproject.model.http.RetrofitUtils;

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

public class FirstPresenter implements FirstContrcat.FirstPre{
    private DemoService service;
    private FirstContrcat.FirstView view;

    public FirstPresenter() {
        service = RetrofitUtils.getRetrofitUtils().getService();
    }

    @Override
    public void AcctachView(FirstContrcat.FirstView view) {
        this.view = view;
    }

    @Override
    public void DateView() {
        this.view = null;
    }

    @Override
    public void loadfirstdata() {

        Map<String,String> params = new HashMap<>();
        Map<String,String> heades = new HashMap<>();
        params.put("loginUserId","0");
        heades.put("apptoken",BaseApp.activity.getSharedPreferences("111", Context.MODE_PRIVATE).getString("xyxy_apptoken",""));

        service.loadfirstdata(heades,params).subscribeOn(Schedulers.newThread()).observeOn(AndroidSchedulers.mainThread()).subscribe(new Observer<FirstBean>() {
            @Override
            public void onSubscribe(Disposable d) {

            }

            @Override
            public void onNext(FirstBean value) {
                if (value !=null) {
                    view.showdata(value);
                }
            }

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onComplete() {

            }
        });
    }
}
