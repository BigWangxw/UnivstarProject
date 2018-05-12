package com.example.dell.univstarproject.sign.prisenter;

import android.util.Log;

import com.example.dell.univstarproject.model.http.RetrofitUtils;
import com.example.dell.univstarproject.model.url.Service;
import com.example.dell.univstarproject.sign.entry.Sign;
import com.example.dell.univstarproject.sign.signview.SignView;
import com.google.gson.Gson;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import okhttp3.ResponseBody;

/**
 * Created by Administrator on 2018/5/5 0005.
 */

public class Signprisenter implements Isignprisenter {
    private Service service;
    private SignView signView;

    public Signprisenter(SignView signView) {
        this.signView = signView;
        service= RetrofitUtils.getRetrofitUtils().getService();
    }

    @Override
    public void sign(String phone, String password) {
        Map<String,String> pramas=new HashMap<String, String>();
        pramas.put("mobile",phone);
        pramas.put("password",password);
        service.sign(pramas)
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
                            Log.e("--",string);
                            Gson gson = new Gson();
                            Sign sign = gson.fromJson(string, Sign.class);
                            signView.showData(sign);
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
