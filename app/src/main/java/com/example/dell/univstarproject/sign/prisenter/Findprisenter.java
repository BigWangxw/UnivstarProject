package com.example.dell.univstarproject.sign.prisenter;

import com.example.dell.univstarproject.model.http.RetrofitUtils;
import com.example.dell.univstarproject.model.url.Service;
import com.example.dell.univstarproject.sign.signview.FindView;

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

public class Findprisenter implements IFindprisenter {
    private Service service;
    private FindView findView;

    public Findprisenter(FindView findView) {
        this.findView = findView;
        service= RetrofitUtils.getRetrofitUtils().getService();
    }

    @Override
    public void findphone(String phone) {
        Map<String,String> params=new HashMap<String, String>();
        params.put("mobile",phone);
        service.findphone(params)
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<ResponseBody>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(ResponseBody value) {

                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }
    @Override
    public void find(String phone, String yzm) {
        Map<String, String> pramas = new HashMap<>();
        pramas.put("mobile",phone);
        pramas.put("mobileValidCode",yzm);
        service.findphone(pramas)
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<ResponseBody>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(ResponseBody value) {

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
