package com.example.dell.univstarproject.model.entry;

import java.util.Map;

import io.reactivex.Observable;
import okhttp3.Response;
import okhttp3.ResponseBody;
import retrofit2.http.FieldMap;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

/**
 * 作者:天南地北，旺哥最美！
 * 微信:xw15227039901
 */

public interface DemoService {
    @FormUrlEncoded
    @POST("v1/m/homewok/home")
    Observable<ResponseBody> loaddata(@FieldMap Map<String,String> params);
}
