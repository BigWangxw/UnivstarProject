package com.example.dell.univstarproject.sign.prisenter;

import android.content.Context;
import android.content.SharedPreferences;
import android.util.Log;

import com.example.dell.univstarproject.base.BaseApp;
import com.example.dell.univstarproject.model.http.RetrofitUtils;
import com.example.dell.univstarproject.model.url.Service;
import com.example.dell.univstarproject.sign.entry.Team;
import com.example.dell.univstarproject.sign.signview.TeamView;
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
 * Created by Administrator on 2018/5/9 0009.
 */

public class Teamprisenter implements ITeamprisenter {
    private Service service;
    private TeamView teamView;

    public Teamprisenter(TeamView teamView) {
        this.teamView = teamView;
        service = RetrofitUtils.getRetrofitUtils().getService();
    }

    @Override
    public void loadTeam(int id) {
        SharedPreferences apptoken = BaseApp.content.getSharedPreferences("appToken", Context.MODE_PRIVATE);
        String token = apptoken.getString("apptoken", "");
        Map<String, String> header = new HashMap<String, String>();
        header.put("apptoken", token);
        Map<String, String> map = new HashMap<String, String>();
        map.put("loginUserId", id + "");
        service.Team(map, header)
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
                            Log.e("str", string);
                            Gson gson = new Gson();
                            Team team = gson.fromJson(string, Team.class);
                            List<Team.DataBean.ListBean> list = team.getData().getList();
                            teamView.showTeam(list);
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }

                    @Override
                    public void onError(Throwable e) {
                        String message = e.getMessage();
                        Log.e("aaa", message);

                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }


}
