package com.example.dell.univstarproject.sign.prisenter;

import com.example.dell.univstarproject.model.http.RetrofitUtils;
import com.example.dell.univstarproject.model.url.Service;
import com.example.dell.univstarproject.sign.entry.GuanZhu;
import com.example.dell.univstarproject.sign.signview.ConcernView;
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
 * Created by Administrator on 2018/5/9 0009.
 */

public class Concernprisenter implements IConcernprisenter{
    private Service service;
    private ConcernView concernView;

    public Concernprisenter(ConcernView concernView) {
        this.concernView = concernView;
        service= RetrofitUtils.getRetrofitUtils().getService();
    }

    @Override
    public void loadCon(int id) {
        Map<String,String> map=new HashMap<String, String>();
        map.put("loginUserId",id+"");
        service.guanzhu(map)
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
                            GuanZhu guanZhu = gson.fromJson(string, GuanZhu.class);
                            concernView.showCon(guanZhu);
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
