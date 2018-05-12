package com.example.dell.univstarproject.sign.prisenter;

import com.example.dell.univstarproject.model.http.RetrofitUtils;
import com.example.dell.univstarproject.model.url.Service;
import com.example.dell.univstarproject.sign.activity.collect.ZhiboView;
import com.example.dell.univstarproject.sign.entry.Collect_zhibo;
import com.google.gson.Gson;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import okhttp3.ResponseBody;

/**
 * Created by Administrator on 2018/5/10 0010.
 */

public class Zhiboprisenter implements IZhiboprisenter {
    private Service service;
    private ZhiboView zhiboView;

    public Zhiboprisenter(ZhiboView zhiboView) {
        this.zhiboView = zhiboView;
        service= RetrofitUtils.getRetrofitUtils().getService();
    }

    @Override
    public void loadCollect(int id, int type) {
        Map<String,String> map=new HashMap<String, String>();
        map.put("loginUserId",id+"");
        map.put("type",type+"");
        service.Collectzhobo(map)
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
                            Collect_zhibo collect_zhibo = gson.fromJson(string, Collect_zhibo.class);
                            List<Collect_zhibo.DataBean.ListBean> list = collect_zhibo.getData().getList();
                            zhiboView.showZhibo(list);
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
