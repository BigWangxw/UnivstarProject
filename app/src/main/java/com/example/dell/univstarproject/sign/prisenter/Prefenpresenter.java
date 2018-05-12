package com.example.dell.univstarproject.sign.prisenter;

import com.example.dell.univstarproject.model.http.RetrofitUtils;
import com.example.dell.univstarproject.model.url.Service;
import com.example.dell.univstarproject.sign.entry.Label;
import com.example.dell.univstarproject.sign.signview.PreferView;
import com.google.gson.Gson;

import java.io.IOException;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import okhttp3.ResponseBody;

/**
 * Created by Administrator on 2018/5/7 0007.
 */

public class Prefenpresenter implements IPreferpresenter {
    private Service service;
    private PreferView preferView;

    public Prefenpresenter(PreferView preferView) {
        this.preferView = preferView;
        service= RetrofitUtils.getRetrofitUtils().getService();
    }

    @Override
    public void prefersenter() {
        service.Pianhao()
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<ResponseBody>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(ResponseBody value) {
                        try {
                            String string = value.string();
                            Gson gson = new Gson();
                            Label label = gson.fromJson(string, Label.class);
                            preferView.showPrefer(label);
                        } catch (IOException e) {
                            e.printStackTrace();
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
