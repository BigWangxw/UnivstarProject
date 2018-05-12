package com.example.dell.univstarproject.sign.prisenter;

import com.example.dell.univstarproject.model.http.RetrofitUtils;
import com.example.dell.univstarproject.model.url.Service;
import com.example.dell.univstarproject.sign.entry.Fans;
import com.example.dell.univstarproject.sign.signview.FollowerView;
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

public class Followprisenter implements IFollowprisenter{
    private Service service;
    private FollowerView followerView;

    public Followprisenter(FollowerView followerView) {
        this.followerView = followerView;
        service= RetrofitUtils.getRetrofitUtils().getService();
    }

    @Override
    public void loadFoller(int id) {
        Map<String,String> map=new HashMap<String, String>();
        map.put("loginUserId",id+"");
        service.Follower(map)
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
                            Fans fans = gson.fromJson(string, Fans.class);
                            List<Fans.DataBean.ListBean> list = fans.getData().getList();
                            followerView.show(list);
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
