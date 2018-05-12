package com.example.dell.univstarproject.prisenter;

import android.util.Log;

import com.example.dell.univstarproject.model.http.RetrofitUtils;
import com.example.dell.univstarproject.model.url.Service;
import com.example.dell.univstarproject.sign.signview.DetaView;

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

public class WangChengPresent implements IWangChengPresent {
    private DetaView view;
    private Service service;
    public WangChengPresent(DetaView view) {
        this.view=view;
        service= RetrofitUtils.getRetrofitUtils().getService();
    }

    @Override
    public void wangCheng(String name, String sex, String photo, String mobile, String psw) {
        Map<String,String> paras=new HashMap<>();
        paras.put("nickname",name);
        paras.put("sex",sex);
        paras.put("photo",photo);
        paras.put("mobile",mobile);
        paras.put("psw",psw);
        service.wangCheng(paras)
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
                            Log.e("ssjkdfhas",string);
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
