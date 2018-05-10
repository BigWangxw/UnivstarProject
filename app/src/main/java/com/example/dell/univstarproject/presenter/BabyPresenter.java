package com.example.dell.univstarproject.presenter;

import android.content.Context;

import com.example.dell.univstarproject.base.BaseApp;
import com.example.dell.univstarproject.model.bean.BabyBean;
import com.example.dell.univstarproject.model.entry.DemoService;
import com.example.dell.univstarproject.model.http.RetrofitUtils;

import java.util.HashMap;
import java.util.Map;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;
import okhttp3.Response;
import okhttp3.ResponseBody;
import okhttp3.internal.http.RealResponseBody;

/**
 * 作者:天南地北，旺哥最美！
 * 微信:xw15227039901
 */

public class BabyPresenter implements BabyContrcat.BabyPre{
    private DemoService service;
    private BabyContrcat.BabyView babyView;

    public BabyPresenter() {
        service = RetrofitUtils.getRetrofitUtils().getService();
    }

    @Override
    public void AcctachView(BabyContrcat.BabyView view) {
        this.babyView = view;
    }

    @Override
    public void DateView() {
        this.babyView = null;
    }

    @Override
    public void loadbabydata() {
        Map<String,String> headers = new HashMap<>();
        Map<String,String> params = new HashMap<>();
        headers.put("apptoken", BaseApp.activity.getSharedPreferences("111", Context.MODE_PRIVATE).getString("xyxy_apptoken",""));
        params.put("page","1");
        params.put("rows","20");
        params.put("loginUserId","0");
        params.put("sortord","0");
        service.loadbabydata(headers,params).subscribeOn(Schedulers.newThread()).observeOn(AndroidSchedulers.mainThread()).subscribe(new Consumer<BabyBean>() {
            @Override
            public void accept(BabyBean babyBean) throws Exception {

                if (babyBean !=null) {
                    babyView.showbaby(babyBean);
                }
            }
        });
    }
}
