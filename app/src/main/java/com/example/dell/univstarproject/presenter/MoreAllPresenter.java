package com.example.dell.univstarproject.presenter;

import android.content.Context;
import android.util.Log;
import android.view.View;

import com.example.dell.univstarproject.base.BaseApp;
import com.example.dell.univstarproject.model.bean.BabyBean;
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

public class MoreAllPresenter implements MoreAllContrcat.MoreAllPre{
    private DemoService service;
    private MoreAllContrcat.MoreaddView moreaddView;

    public MoreAllPresenter() {
        service = RetrofitUtils.getRetrofitUtils().getService();
    }

    @Override
    public void AcctachView(MoreAllContrcat.MoreaddView view) {
        this.moreaddView = view;
    }

    @Override
    public void DateView() {
        this.moreaddView = null;
    }

    @Override
    public void loaddata(String page, String row, String sortord) {
        Map<String,String> headers = new HashMap<>();
        Map<String,String> params = new HashMap<>();
        headers.put("apptoken", BaseApp.activity.getSharedPreferences("111", Context.MODE_PRIVATE).getString("xyxy_apptoken",""));
        params.put("page",page);
        params.put("rows",row);
        params.put("loginUserId",sortord);
        params.put("sortord","0");
        service.loadbabydata(headers,params).subscribeOn(Schedulers.newThread()).observeOn(AndroidSchedulers.mainThread()).subscribe(new Consumer<BabyBean>() {
            @Override
            public void accept(BabyBean babyBean) throws Exception {

                Log.e("请求",babyBean.toString());
               if (babyBean !=null) {
                   moreaddView.showdata(babyBean);

               } else {
                   moreaddView.showlinear(true);
               }

            }
        });
    }

}
