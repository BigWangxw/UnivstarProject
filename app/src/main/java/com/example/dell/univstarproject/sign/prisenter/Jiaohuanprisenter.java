package com.example.dell.univstarproject.sign.prisenter;

import com.example.dell.univstarproject.model.http.RetrofitUtils;
import com.example.dell.univstarproject.model.url.Service;
import com.example.dell.univstarproject.sign.entry.Change;
import com.example.dell.univstarproject.sign.signview.JiaohuanView;
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
 * Created by Administrator on 2018/5/8 0008.
 */

public class Jiaohuanprisenter implements IJiaohuanPresenter{
    private Service service;
    private JiaohuanView jiaohuanView;

    public Jiaohuanprisenter(JiaohuanView jiaohuanView) {
        this.jiaohuanView = jiaohuanView;
        service= RetrofitUtils.getRetrofitUtils().getService();
    }

    @Override
    public void loadYzm(String phone) {
        Map<String,String> pramas=new HashMap<String, String>();
        pramas.put("mobile",phone);
        service.Jiao(pramas)
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

    @Override
    public void loadJiaohuan(int id, String phone, String yzm) {
        Map<String,String> map=new HashMap<String, String>();
        map.put("loginUserId",id+"");
        map.put("mobile",phone);
        map.put("code",yzm);
        service.Jiaohuan(map)
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
                            Change change = gson.fromJson(string, Change.class);
                            jiaohuanView.ShowTwo(change);
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
