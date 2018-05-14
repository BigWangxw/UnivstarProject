package com.example.dell.univstarproject.start.presenter;

import android.content.Context;

import com.example.dell.univstarproject.base.BaseApp;
import com.example.dell.univstarproject.model.http.RetrofitUtils;
import com.example.dell.univstarproject.model.url.Service;
import com.example.dell.univstarproject.start.model.bean.ControllerBean;
import com.example.dell.univstarproject.start.model.bean.DeailBean;
import com.example.dell.univstarproject.start.model.bean.DianZanUtils;

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

public class HomeWorkDeailPresenter implements HomeWorkDeailContrcat.HomeWorkDeailPre{

    private Service service;
    private HomeWorkDeailContrcat.HomeWorkDeailView homeWorkDeailView;

    public HomeWorkDeailPresenter(HomeWorkDeailContrcat.HomeWorkDeailView homeWorkDeailView) {
        service = RetrofitUtils.getRetrofitUtils().getService();
        this.homeWorkDeailView = homeWorkDeailView;
    }

    public void AcctachView(HomeWorkDeailContrcat.HomeWorkDeailView view) {
        this.homeWorkDeailView = view;
    }


    @Override
    public void DateView() {
        this.homeWorkDeailView = null;
    }
//充值请求
    @Override
    public void loadControllerBean() {
        Map<String,String> params = new HashMap<>();
        Map<String,String> headers = new HashMap<>();
        params.put("loginUserId","662");
        headers.put("apptoken", BaseApp.activity.getSharedPreferences("111", Context.MODE_PRIVATE).getString("xyxy_apptoken",""));
        service.loadController(headers,params).subscribeOn(Schedulers.newThread()).observeOn(AndroidSchedulers.mainThread()).subscribe(new Consumer<ControllerBean>() {
            @Override
            public void accept(ControllerBean bean) throws Exception {
                if (bean!=null) {

                    homeWorkDeailView.showControllerBean(bean);

                } else {
                    return;
                }
            }
        });
    }
//作业详情请求
    @Override
    public void loadDeailBean(String id) {
        Map<String,String> params = new HashMap<>();
        Map<String,String> headers = new HashMap<>();
        params.put("loginUserId","662");
        params.put("homewokId",id);
        headers.put("apptoken", BaseApp.activity.getSharedPreferences("111", Context.MODE_PRIVATE).getString("xyxy_apptoken",""));
        service.loadDeailBean(headers,params).subscribeOn(Schedulers.newThread()).observeOn(AndroidSchedulers.mainThread()).subscribe(new Consumer<DeailBean>() {
            @Override
            public void accept(DeailBean deailBean) throws Exception {
                if (deailBean == null) {
                    return;
                }
                homeWorkDeailView.showDeailBean(deailBean);
            }
        });
    }

    @Override
    public void dianzandata(String id) {

        service.dianzan(DianZanUtils.getDianZanUtils().getheadres(),DianZanUtils.getDianZanUtils().getparamsMap("0",id,"662","作业评论")).subscribeOn(Schedulers.newThread()).observeOn(AndroidSchedulers.mainThread()).subscribe(new Consumer<ResponseBody>() {
            @Override
            public void accept(ResponseBody responseBody) throws Exception {
               if (responseBody !=null) {
                   homeWorkDeailView.showwin("点赞成功");
               }
            }
        });
    }

    @Override
    public void quxiao(String id) {
        service.quxiao(DianZanUtils.getDianZanUtils().getheadres(),DianZanUtils.getDianZanUtils().getparamsMap("0",id,"662","作业评论")).subscribeOn(Schedulers.newThread()).observeOn(AndroidSchedulers.mainThread()).subscribe(new Consumer<ResponseBody>() {
            @Override
            public void accept(ResponseBody responseBody) throws Exception {
                if (responseBody !=null) {
                    homeWorkDeailView.showwin("取消点赞");
                }
            }
        });
    }


}
