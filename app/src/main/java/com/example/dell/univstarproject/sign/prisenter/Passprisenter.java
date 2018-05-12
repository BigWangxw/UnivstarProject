package com.example.dell.univstarproject.sign.prisenter;

import android.util.Log;

import com.example.dell.univstarproject.model.http.RetrofitUtils;
import com.example.dell.univstarproject.model.url.Service;
import com.example.dell.univstarproject.sign.signview.PassView;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import okhttp3.ResponseBody;

/**
 * Created by Administrator on 2018/5/4 0004.
 */

public class Passprisenter implements IPassprisenter{
    private Service service;
    private PassView passView;

    public Passprisenter(PassView passView) {
        this.passView = passView;
        service= RetrofitUtils.getRetrofitUtils().getService();
    }

    @Override
    public void pass(String phone, String password) {
        Map<String,String> pramas=new HashMap<String, String>();
        pramas.put("mobile",phone);
        pramas.put("password",password);
        service.pass(pramas)
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
                            Log.e("nnn",string);
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
