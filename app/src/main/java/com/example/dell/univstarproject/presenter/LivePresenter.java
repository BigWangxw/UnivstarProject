package com.example.dell.univstarproject.presenter;

import android.content.Context;

import com.example.dell.univstarproject.base.BaseApp;
import com.example.dell.univstarproject.model.bean.LiveBean;
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

public class LivePresenter implements LiveContrcat.LivePre{
    private DemoService service;
    private LiveContrcat.LiveView view;

    public LivePresenter() {
        service = RetrofitUtils.getRetrofitUtils().getService();
    }

    @Override
    public void AcctachView(LiveContrcat.LiveView view) {
        this.view = view;
    }

    @Override
    public void DateView() {
        this.view = null;
    }

    @Override
    public void loadLiveBean() {
        Map<String,String> params = new HashMap<>();
        Map<String,String> headers = new HashMap<>();
        params.put("page","1");
        params.put("rows","20");
        params.put("loginUserId","0");
        params.put("type","讲堂");
        headers.put("apptoken", BaseApp.activity.getSharedPreferences("111", Context.MODE_PRIVATE).getString("xyxy_apptoken",""));
        service.loadLiveBean(headers,params).subscribeOn(Schedulers.newThread()).observeOn(AndroidSchedulers.mainThread()).subscribe(new Consumer<LiveBean>() {
            @Override
            public void accept(LiveBean liveBean) throws Exception {
                if (liveBean !=null) {
                    view.showLiveBean(liveBean);
                } else {
                    return;
                }
            }
        });
    }
}
