package com.example.dell.univstarproject.model.http;

import android.content.Context;
import android.content.SharedPreferences;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

import com.example.dell.univstarproject.base.BaseApp;
import com.example.dell.univstarproject.model.entry.TokenBean;
import com.example.dell.univstarproject.model.url.AppTokenService;
import com.example.dell.univstarproject.model.url.RetrofitUrl;
import com.example.dell.univstarproject.model.url.Service;
import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * 作者:天南地北，旺哥最美！
 * 微信:xw15227039901
 */

public class RetrofitUtils {
    private static RetrofitUtils retrofitUtils;
    private final Retrofit retrofit;

    //    private final OkHttpClient okHttpClient;
//    private final Cache cache;
//    private final HttpLoggingInterceptor httpLoggingInterceptor;
    private RetrofitUtils() {
//        Interceptor interceptor = new Interceptor() {
//
//            @Override
//            public Response intercept(Chain chain) throws IOException {
//                Request request = chain.request();
//                Response response = chain.proceed(request);
//                if (RetrofitUtils.getRetrofitUtils().isConnected(BaseApp.activity)) {
//                    int maxAge = 60*60*24*2;//缓存失效时间，单位为秒
//                    return response.newBuilder()
//                            .removeHeader("Pragma")//清除头信息，因为服务器如果不支持，会返回一些干扰信息，不清除下面无法生效
//                            .header("Cache-Control", "public ,max-age=" + maxAge)
//                            .build();
//                }
//                return response;
//            }
//        };
//        httpLoggingInterceptor = new HttpLoggingInterceptor(HttpLoggingInterceptor.Logger.DEFAULT);
//        httpLoggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
//
//        cache = new Cache(BaseApp.activity.getCacheDir(),1024*1024*30);
//        okHttpClient = new OkHttpClient.Builder()
//                .addInterceptor(httpLoggingInterceptor)
//                .addNetworkInterceptor(interceptor)
//                .cache(cache)
//                .build();
        getAppToken();
        retrofit = new Retrofit.Builder()
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl(RetrofitUrl.BASE_URL)
                .build();
    }

    public static void getAppToken() {
        Retrofit retrofit = new Retrofit.Builder()
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl(RetrofitUrl.BASE_URL)
                .build();
        retrofit.create(AppTokenService.class)
                .getToken("https://www.univstar.com/v1/m/security/apptoken")
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.newThread())
                .subscribe(new Consumer<TokenBean>() {
                    @Override
                    public void accept(TokenBean tokenBean) throws Exception {
                        String apptoken = tokenBean.getData().getApptoken();
                        SharedPreferences appToken = BaseApp.activity.getSharedPreferences("appToken", Context.MODE_PRIVATE);
                        SharedPreferences.Editor edit = appToken.edit();
                        long time = System.currentTimeMillis();
                        String desApptoken = EncryptUtil.decrypt(apptoken);
                        String headerApptoken = EncryptUtil.encrypt(time + desApptoken).replaceAll("\\n", "").toUpperCase();
                        edit.putString("apptoken", headerApptoken + "." + time);
                        edit.commit();
                    }
        });
    }
    public static RetrofitUtils getRetrofitUtils() {
        if (retrofitUtils == null) {
            synchronized (RetrofitUtils.class) {
                if (retrofitUtils == null) {
                    retrofitUtils = new RetrofitUtils();
                }
            }
        }
        return retrofitUtils;
    }

    public boolean isConnected(Context context) {
        NetworkInfo info = getActiveNetworkInfo(context);
        return info != null && info.isConnected();
    }

    public static NetworkInfo getActiveNetworkInfo(Context context) {
        ConnectivityManager cm = (ConnectivityManager) context
                .getSystemService(Context.CONNECTIVITY_SERVICE);
        return cm.getActiveNetworkInfo();
    }

    public Service getService() {
        return retrofit.create(Service.class);
    }
}
