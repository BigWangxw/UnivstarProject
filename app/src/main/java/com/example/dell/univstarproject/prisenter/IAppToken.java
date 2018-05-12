package com.example.dell.univstarproject.prisenter;

import com.example.dell.univstarproject.model.http.AppTokenModel;

import io.reactivex.Observable;
import retrofit2.http.POST;
import retrofit2.http.Url;

/**
 * Created by Administrator on 2018/5/11 0011.
 */

public interface IAppToken {
    @POST
    Observable<AppTokenModel> getAppToken(@Url String url);
}
