package com.example.dell.univstarproject.presenter;

import android.content.Context;
import android.util.Log;

import com.example.dell.univstarproject.base.BaseApp;
import com.example.dell.univstarproject.model.bean.DemoBean;
import com.example.dell.univstarproject.model.bean.DemoFirstBean;
import com.example.dell.univstarproject.model.entry.DemoService;
import com.example.dell.univstarproject.model.http.RetrofitUtils;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;
import okhttp3.ResponseBody;

/**
 * 作者:天南地北，旺哥最美！
 * 微信:xw15227039901
 */

public class DemoPresenter implements DemoContrcat.DemoPre{
    private DemoContrcat.DemoView view;
    private DemoService service;

    public DemoPresenter(/*DemoContrcat.DemoView  view*/) {
        //this.view=view;
        service = RetrofitUtils.getRetrofitUtils().getService();
    }

    @Override
    public void AcctachView(DemoContrcat.DemoView view) {
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
        params.put("sortord","1");
        Map<String,String> headers = new HashMap<>();
        headers.put("apptoken", BaseApp.activity.getSharedPreferences("111", BaseApp.activity.MODE_PRIVATE).getString("xyxy_apptoken",""));
        service.loaddata(headers,params).subscribeOn(Schedulers.newThread()).observeOn(AndroidSchedulers.mainThread()).subscribe(new Observer<DemoFirstBean>() {
            @Override
            public void onSubscribe(Disposable d) {

            }

            @Override
            public void onNext(DemoFirstBean value) {
              if (value !=null) {
                   view.showDemodata(value);
               }


            }

            @Override
            public void onError(Throwable e) {
                Log.e("aaa",e.getMessage());
            }

            @Override
            public void onComplete() {

            }
        });

    }
}
