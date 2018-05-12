package com.example.dell.univstarproject.model.url;

import com.example.dell.univstarproject.sign.entry.TokenData;

import java.util.Map;

import io.reactivex.Observable;
import okhttp3.ResponseBody;
import retrofit2.http.FieldMap;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.HeaderMap;
import retrofit2.http.POST;

/**
 * Created by Administrator on 2018/5/4 0004.
 */

public interface Service {
    @FormUrlEncoded
    @POST("v1/m/user/authcode")
    Observable<ResponseBody> zhuce( @FieldMap Map<String,String> pramas);

    @FormUrlEncoded
    @POST("v1/m/user/register/mobile")
    Observable<ResponseBody> zhucesuccess(@FieldMap Map<String,String> pramas);

    @FormUrlEncoded
    @POST("v1/m/user/saveCompleteUser")
    Observable<ResponseBody> wangCheng(@FieldMap Map<String,String> pramas);

    @FormUrlEncoded
    @POST("v1/m/user/save/password")
    Observable<ResponseBody> pass(@FieldMap Map<String,String> pramas);

    @FormUrlEncoded
    @POST("v1/m/user/authcode")
    Observable<ResponseBody> findphone( @FieldMap Map<String,String> pramas);

    @FormUrlEncoded
    @POST("v1/m/user/register/mobile")
    Observable<ResponseBody> find(@FieldMap Map<String,String> pramas);

    @FormUrlEncoded
    @POST("v1/m/user/login/mobile")
    Observable<ResponseBody> sign(@FieldMap Map<String,String> pramas);


    @GET("v1/m/user/preference")
    Observable<ResponseBody> Pianhao();


    //更换手机号
    @FormUrlEncoded
    @POST("v1/m/user/authcode")
    Observable<ResponseBody> changefind( @FieldMap Map<String,String> pramas);

    @FormUrlEncoded
    @POST("v1/m/user/register/mobile")
    Observable<ResponseBody> Chenge(@FieldMap Map<String,String> pramas);
    //POST /v1/m/user/setting/mobile


    @FormUrlEncoded
    @POST("v1/m/user/authcode")
    Observable<ResponseBody> Jiao( @FieldMap Map<String,String> pramas);

    @FormUrlEncoded
    @POST("v1/m/user/setting/mobile")
    Observable<ResponseBody> Jiaohuan(@FieldMap Map<String,String> pramas);

    //系统消息
    @FormUrlEncoded
    @POST("v1/m/message/univstar")
    Observable<ResponseBody> Team(@FieldMap Map<String,String> pramas, @HeaderMap Map<String,String> header);


    //AppToken
    @POST("/v1/m/security/apptoken")
    Observable<TokenData> getToken();

    //关注
    @FormUrlEncoded
    @POST("v1/m/user/my/attention")
    Observable<ResponseBody> guanzhu(@FieldMap Map<String,String> pramas);

    //我的收藏
    @FormUrlEncoded
    @POST("v1/m/user/my/favorites")
    Observable<ResponseBody> Collectzhobo(@FieldMap Map<String,String> pramas);

    //我的粉丝
    @FormUrlEncoded
    @POST("v1/m/user/my/fans")
    Observable<ResponseBody> Follower(@FieldMap Map<String,String> pramas);


}
