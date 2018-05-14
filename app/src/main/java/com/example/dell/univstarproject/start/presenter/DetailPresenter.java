package com.example.dell.univstarproject.start.presenter;

import android.content.Context;
import android.util.Log;

import com.example.dell.univstarproject.base.BaseApp;
import com.example.dell.univstarproject.model.http.RetrofitUtils;
import com.example.dell.univstarproject.model.url.Service;
import com.example.dell.univstarproject.start.model.bean.ClassDetailed;

import java.util.HashMap;
import java.util.Map;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;
import okhttp3.ResponseBody;

/**
 * 作者:天南地北，旺哥最美！
 * 微信:xw15227039901
 */

public class DetailPresenter implements DetailContrcat.DetailPre{
    private Service service;
    private DetailContrcat.DetailView view;

    public DetailPresenter() {
        service = RetrofitUtils.getRetrofitUtils().getService();
    }

    @Override
    public void AcctachView(DetailContrcat.DetailView view) {
        this.view = view;
    }

    @Override
    public void DateView() {
        this.view = null;
    }

    @Override
    public void loadDetailBean(Integer id) {
        Map<String,String> params = new HashMap<>();
        Map<String,String> headers = new HashMap<>();
        params.put("loginUserId","0");
        params.put("id",id+"");
        headers.put("apptoken", BaseApp.activity.getSharedPreferences("111", Context.MODE_PRIVATE).getString("xyxy_apptoken",""));
        service.loadClassDetail(headers,params).subscribeOn(Schedulers.newThread()).observeOn(AndroidSchedulers.mainThread()).subscribe(new Consumer<ClassDetailed>() {
            @Override
            public void accept(ClassDetailed detailed) throws Exception {
                if (detailed !=null) {
                    view.showDetailBean(detailed);
                } else {
                    return;
                }
            }
        });
    }
    @Override
    public void loadDetailBean(String loginid, String id) {
        Map<String,String> params = new HashMap<>();
        Map<String,String> headers = new HashMap<>();
        params.put("attentionId",loginid);
        params.put("loginUserId",id);
        headers.put("apptoken", BaseApp.activity.getSharedPreferences("111", Context.MODE_PRIVATE).getString("xyxy_apptoken",""));
        service.guanzhu(headers,params).subscribeOn(Schedulers.newThread()).observeOn(AndroidSchedulers.mainThread()).subscribe(new Consumer<ResponseBody>() {
            @Override
            public void accept(ResponseBody responseBody) throws Exception {
                String string = responseBody.string();
                Log.e("关注请求结果",string);

            }
        });
    }

    @Override
    public void quxiaoguanzhu(String loginid, String id) {
        Map<String,String> params = new HashMap<>();
        Map<String,String> headers = new HashMap<>();
        params.put("attentionId",loginid);
        params.put("loginUserId",id);
        headers.put("apptoken", BaseApp.activity.getSharedPreferences("111", Context.MODE_PRIVATE).getString("xyxy_apptoken",""));
        service.guanzhu(headers,params).subscribeOn(Schedulers.newThread()).observeOn(AndroidSchedulers.mainThread()).subscribe(new Consumer<ResponseBody>() {
            @Override
            public void accept(ResponseBody responseBody) throws Exception {
                String string = responseBody.string();
                Log.e("取消关注请求结果",string);

            }
        });
    }
}
