package com.example.dell.univstarproject.sign.prisenter;

import android.util.Log;

import com.example.dell.univstarproject.model.http.RetrofitUtils;
import com.example.dell.univstarproject.model.url.Service;
import com.example.dell.univstarproject.sign.signview.ZhuceView;

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

public class Zhuceprisenter implements IZhuceprisenter{
    private Service service;
    private ZhuceView zhuceView;

    public Zhuceprisenter(ZhuceView zhuceView) {
        this.zhuceView = zhuceView;
        service= RetrofitUtils.getRetrofitUtils().getService();
    }

    @Override
    public void zhuce(String phone) {
        Map<String,String> params=new HashMap<String, String>();
        params.put("mobile",phone);
        service.zhuce(params).subscribeOn(Schedulers.newThread()).observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<ResponseBody>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }
                    @Override
                    public void onNext(ResponseBody value) {
                        try {
                            String string = value.string();
                            zhuceView.showZhuce(string);
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                    @Override
                    public void onError(Throwable e) {
                        Log.e("aaaaaa",e.getMessage());
                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }
    @Override
    public void zhuceSuccess(String phone, String yzm) {
        Map<String, String> pramas = new HashMap<>();
        pramas.put("mobile",phone);
        pramas.put("mobileValidCode",yzm);
        service.zhucesuccess(pramas)
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
                            zhuceView.shousuccess(string);
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
