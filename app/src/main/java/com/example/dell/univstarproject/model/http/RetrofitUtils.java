package com.example.dell.univstarproject.model.http;

import android.content.Context;
import android.content.SharedPreferences;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.text.TextUtils;
import android.util.Log;

import com.example.dell.univstarproject.base.BaseApp;
import com.example.dell.univstarproject.model.Utils.EncryptUtil;
import com.example.dell.univstarproject.model.bean.AppTokenBean;
import com.example.dell.univstarproject.model.entry.DemoService;
import com.example.dell.univstarproject.model.url.RetrofitUrl;
import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import okhttp3.Cache;
import okhttp3.Headers;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.ResponseBody;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.Url;

/**
 * 作者:天南地北，旺哥最美！
 * 微信:xw15227039901
 */

public class RetrofitUtils {
    private static RetrofitUtils retrofitUtils;
    private final Retrofit retrofit;
    private final OkHttpClient okHttpClient;
    private final Cache cache;
    private final HttpLoggingInterceptor httpLoggingInterceptor;
    private RetrofitUtils () {
       /* Interceptor interceptor = new Interceptor() {

            @Override
            public Response intercept(Chain chain) throws IOException {
                Request request = chain.request();
                Response response = chain.proceed(request);
                if (RetrofitUtils.getRetrofitUtils().isConnected(BaseApp.activity)) {
                    int maxAge = 60*60*24*2;//缓存失效时间，单位为秒
                    return response.newBuilder()
                            .removeHeader("Pragma")//清除头信息，因为服务器如果不支持，会返回一些干扰信息，不清除下面无法生效
                            .header("Cache-Control", "public ,max-age=" + maxAge)
                            .build();
                }
                return response;

            }
        };*/
        httpLoggingInterceptor = new HttpLoggingInterceptor(HttpLoggingInterceptor.Logger.DEFAULT);
        httpLoggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);

        cache = new Cache(BaseApp.activity.getCacheDir(),1024*1024*30);
        okHttpClient = new OkHttpClient.Builder()
                .addInterceptor(new AddCookiesInterceptor(BaseApp.activity))
                .addInterceptor(new ReceivedCookiesInterceptor(BaseApp.activity))
                .cache(cache)
                .build();
        if(TextUtils.isEmpty(RetrofitUtils.getAppToken(BaseApp.activity))){
            RetrofitUtils.loadApptoken(BaseApp.activity);
        }
        retrofit = new Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .client(okHttpClient)
                .baseUrl(RetrofitUrl.BASE_URL)
                .build();


    }

    public static void loadApptoken(final Context context){

        OkHttpClient okHttpClient = new OkHttpClient.Builder()
                .connectTimeout(15, TimeUnit.SECONDS)
                .readTimeout(20,TimeUnit.SECONDS)
                .writeTimeout(20,TimeUnit.SECONDS)
                .retryOnConnectionFailure(false)
                .addInterceptor(new ReceivedCookiesInterceptor(context))
                .addInterceptor(new AddCookiesInterceptor(context))
                .build();

        Retrofit retrofit= new Retrofit.Builder()
                .client(okHttpClient)
                .baseUrl("https://www.univstar.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();

        retrofit.create(DemoService.class)
                .getAppToken("v1/m/security/apptoken")
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<AppTokenBean>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(AppTokenBean value) {

                        if(value==null||value.getData()==null){
                            return;
                        }

                        String apptoken = value.getData().getApptoken();

                        long time = System.currentTimeMillis();

                        try {
                            //对AppToken解码
                            String desApptoken= EncryptUtil.decrypt(apptoken);
                            //对AppToken编码，加密
                            String headerApptoken=EncryptUtil.encrypt(time + desApptoken).replaceAll("\\n","").toUpperCase();

                            RetrofitUtils.saveAppToken(context,headerApptoken,time);

                        } catch (Exception e) {
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
    public static Integer getUserId(Context context){

        if(context==null){
            return 0 ;
        }

        SharedPreferences sharedPreferences = context.getApplicationContext().getSharedPreferences("111", Context.MODE_PRIVATE);

        String id = sharedPreferences.getString("xyxy_user_id", "");
        if(TextUtils.isEmpty(id)){
            return 0;
        }

        Integer idInteger= Integer.parseInt(id);

        //TODU测试id
        return idInteger;

    }

    public static String getAppToken(Context context){

        if(context==null){
            return "" ;
        }

        SharedPreferences sharedPreferences = context.getApplicationContext().getSharedPreferences("111", Context.MODE_PRIVATE);

        String apptoken = sharedPreferences.getString("xyxy_apptoken", "");
        if(TextUtils.isEmpty(apptoken)){
            return "";
        }

        //TODU测试id
        return apptoken;

    }


    public static void saveId(Context context,String id){
        if(context==null){
            return ;
        }

        SharedPreferences sharedPreferences = context.getApplicationContext().getSharedPreferences("111", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString("xyxy_user_id", id);
        editor.commit();

    }

    public static void saveToken(Context context,String token){
        if(context==null){
            return ;
        }

        SharedPreferences sharedPreferences = context.getApplicationContext().getSharedPreferences("111", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString("xyxy_cookiename",token);
        editor.commit();

    }
    public static void saveAppToken(Context context,String token ,long time){
        if(context==null){
            return ;
        }

        SharedPreferences sharedPreferences = context.getApplicationContext().getSharedPreferences("111", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString("xyxy_apptoken",token+"."+time);
        editor.commit();

    }
    public static RetrofitUtils getRetrofitUtils () {
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
    public DemoService getService () {
        return retrofit.create(DemoService.class);
    }
}
