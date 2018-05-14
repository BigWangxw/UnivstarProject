package com.example.dell.univstarproject.start.presenter;


import com.example.dell.univstarproject.model.http.RetrofitUtils;
import com.example.dell.univstarproject.model.url.Service;
import com.example.dell.univstarproject.start.model.bean.LiveDetailModel;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

/**
 * 作者:天南地北，旺哥最美！
 * 微信:xw15227039901
 */

public class FurPresenter implements FurContrcat.FurPre{
    private Service service;
    private FurContrcat.FurView view;

    public FurPresenter() {
        service = RetrofitUtils.getRetrofitUtils().getService();
    }

    @Override
    public void AcctachView(FurContrcat.FurView view) {
        this.view = view;
    }

    @Override
    public void DateView() {
        this.view = null;
    }

    @Override
    public void loaddata(Integer userid,int id) {
        service.getlivedetailmodel(userid,id).subscribeOn(Schedulers.newThread()).observeOn(AndroidSchedulers.mainThread()).subscribe(new Consumer<LiveDetailModel>() {
            @Override
            public void accept(LiveDetailModel model) throws Exception {
               if (model == null) {

                   return;

               }else {
                   view.showdata(model);
               }
            }
        });
    }
}
