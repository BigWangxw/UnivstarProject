package com.example.dell.univstarproject.start.presenter;

import android.content.Context;

import com.example.dell.univstarproject.base.BaseApp;
import com.example.dell.univstarproject.model.http.RetrofitUtils;
import com.example.dell.univstarproject.model.url.Service;
import com.example.dell.univstarproject.start.model.bean.DianZanUtils;
import com.example.dell.univstarproject.start.model.bean.Teacher;

import java.util.HashMap;
import java.util.Map;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;
import okhttp3.ResponseBody;

/**
 * 作者:天南地北，旺哥最美！
 * 微信:xw15227039901
 */

public class TeacherPresneter implements TeacherContrcat.TeacherPre{
    private Service service;
    private TeacherContrcat.TeacherView view;

    public TeacherPresneter() {
        service = RetrofitUtils.getRetrofitUtils().getService();
    }

    @Override
    public void AcctachView(TeacherContrcat.TeacherView view) {
        this.view = view;
    }

    @Override
    public void DateView() {
        this.view = null;
    }

    @Override
    public void loadTeachenBean(Integer teaid) {
        Map<String,Integer> params = new HashMap<>();
        Map<String,String> headers = new HashMap<>();
        params.put("loginUserId",0);
        params.put("teacherId",teaid);
        headers.put("apptoken", BaseApp.activity.getSharedPreferences("111", Context.MODE_PRIVATE).getString("xyxy_apptoken",""));
        service.loadTeacherBean(headers,params).subscribeOn(Schedulers.newThread()).observeOn(AndroidSchedulers.mainThread()).subscribe(new Consumer<Teacher>() {
            @Override
            public void accept(Teacher teacher) throws Exception {
                if (teacher !=null) {
                    view.showTeacherBean(teacher);
                } else {
                    return;
                }
            }
        });
    }

    @Override
    public void dianzan(Integer userId, String id, String loginUserId, String type) {
       /* Map<String,String> params = new HashMap<>();
        Map<String,String> headers = new HashMap<>();
        params.put("userId", id);
        params.put("id",id);
        params.put("loginUserId",loginUserId);
        params.put("type",type);
        headers.put("apptoken", BaseApp.activity.getSharedPreferences("111", Context.MODE_PRIVATE).getString("xyxy_apptoken",""));*/
        service.dianzan(DianZanUtils.getDianZanUtils().getheadres(),DianZanUtils.getDianZanUtils().getparamsMap(userId+"",id,loginUserId,type)).subscribeOn(Schedulers.newThread()).observeOn(AndroidSchedulers.mainThread()).subscribe(new Consumer<ResponseBody>() {
            @Override
            public void accept(ResponseBody zanClick) throws Exception {

                    String string = zanClick.string();
                    view.showdianzan("赞一个");
            }
        });
    }

    @Override
    public void quxiao(Integer userId, String id, String loginUserId, String type) {
        Map<String,String> params = new HashMap<>();
        Map<String,String> headers = new HashMap<>();
        params.put("userId",id+"");
        params.put("id",id);
        params.put("loginUserId",loginUserId);
        params.put("type",type);
        headers.put("apptoken", BaseApp.activity.getSharedPreferences("111", Context.MODE_PRIVATE).getString("xyxy_apptoken",""));

        service.quxiao(headers,params).subscribeOn(Schedulers.newThread()).observeOn(AndroidSchedulers.mainThread()).subscribe(new Consumer<ResponseBody>() {
            @Override
            public void accept(ResponseBody quxiao) throws Exception {
                if (quxiao !=null) {
                    view.showquxiao("取消点赞");
                }
            }
        });
    }
}
