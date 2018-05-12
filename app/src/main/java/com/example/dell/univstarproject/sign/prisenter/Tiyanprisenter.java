package com.example.dell.univstarproject.sign.prisenter;

import com.example.dell.univstarproject.model.http.RetrofitUtils;
import com.example.dell.univstarproject.model.url.Service;
import com.example.dell.univstarproject.sign.entry.TIyan;
import com.example.dell.univstarproject.sign.signview.TIyanView;
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
 * Created by Administrator on 2018/5/11 0011.
 */

public class Tiyanprisenter implements ITiyanprisenter {
    private Service service;
    private TIyanView tIyanView;

    public Tiyanprisenter(TIyanView tIyanView) {
        this.tIyanView = tIyanView;
        service= RetrofitUtils.getRetrofitUtils().getService();
    }

    @Override
    public void loadTiyan(int id, int type) {
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
                            TIyan tIyan = gson.fromJson(string, TIyan.class);
                            List<TIyan.DataBean.ListBean> list = tIyan.getData().getList();
                            tIyanView.showTiyan(list);
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
