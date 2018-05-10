package com.example.dell.univstarproject.presenter;

import com.example.dell.univstarproject.base.BaseApp;
import com.example.dell.univstarproject.model.bean.NewstBean;
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

public class NewstPresenter implements NewtContrcat.NewsPre{
    private DemoService service;
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
        headers.put("apptoken", BaseApp.activity.getSharedPreferences("111", BaseApp.activity.MODE_PRIVATE).getString("xyxy_apptoken",""));
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
