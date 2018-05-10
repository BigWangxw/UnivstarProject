package com.example.dell.univstarproject.model.entry;

import com.example.dell.univstarproject.model.bean.AppTokenBean;
import com.example.dell.univstarproject.model.bean.BabyBean;
import com.example.dell.univstarproject.model.bean.ClassDetailed;
import com.example.dell.univstarproject.model.bean.Course;
import com.example.dell.univstarproject.model.bean.DemoBean;
import com.example.dell.univstarproject.model.bean.DemoFirstBean;
import com.example.dell.univstarproject.model.bean.FirstBean;
import com.example.dell.univstarproject.model.bean.ForeBean;
import com.example.dell.univstarproject.model.bean.LiveBean;
import com.example.dell.univstarproject.model.bean.LiveDetailModel;
import com.example.dell.univstarproject.model.bean.MingTeacher;
import com.example.dell.univstarproject.model.bean.NewstBean;
import com.example.dell.univstarproject.model.bean.Quxiao;
import com.example.dell.univstarproject.model.bean.Teacher;
import com.example.dell.univstarproject.model.bean.ZanClick;

import java.util.Map;

import io.reactivex.Observable;
import okhttp3.Response;
import okhttp3.ResponseBody;
import retrofit2.http.Field;
import retrofit2.http.FieldMap;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.HeaderMap;
import retrofit2.http.POST;
import retrofit2.http.Url;

/**
 * 作者:天南地北，旺哥最美！
 * 微信:xw15227039901
 */

public interface DemoService {
    @FormUrlEncoded
    @POST("v1/m/homewok/home")
    Observable<DemoFirstBean> loaddata(@HeaderMap Map<String,String> headers, @FieldMap Map<String,String> map);
    @FormUrlEncoded
    @POST("v1/m/homewok/home")
    Observable<NewstBean> loadnewtbeandata(@HeaderMap Map<String,String> headers, @FieldMap Map<String,String> map);
    @POST
    Observable<AppTokenBean> getAppToken (@Url String url);
    @FormUrlEncoded
    @POST("/v1/m/home/alliance/list")
    Observable<FirstBean> loadfirstdata(@HeaderMap Map<String,String> headers, @FieldMap Map<String,String> map);

    @FormUrlEncoded
    @POST("/v1/m/artcircle/home")
    Observable<BabyBean> loadbabydata(@HeaderMap Map<String,String> headers, @FieldMap Map<String,String> map);

    @FormUrlEncoded
    @POST("/v1/m/forthcoming/home")
    Observable<ForeBean> loadforedata(@HeaderMap Map<String,String> headers, @FieldMap Map<String,String> map);

    @FormUrlEncoded
    @POST("/v1/m/home/courses/page")
    Observable<Course> loadcourse(@HeaderMap Map<String,String> headers, @FieldMap Map<String,String> map);

    @FormUrlEncoded
    @POST("/v1/m/liveCourse/detail")
    Observable<LiveDetailModel> getlivedetailmodel(@Field("loginUserId") Integer loginUserId,@Field("id") int id);

    @FormUrlEncoded
    @POST("/v1/m/user/teacher/list")
    Observable<MingTeacher> loadMingTeacher (@HeaderMap Map<String,String> headers, @FieldMap Map<String,Integer> map);

    @FormUrlEncoded
    @POST("/v1/m/user/teacher/homepage")
    Observable<Teacher> loadTeacherBean(@HeaderMap Map<String,String> headers, @FieldMap Map<String,Integer> map);

    @FormUrlEncoded
    @POST("/v1/m/user/praise")
    Observable<ResponseBody> dianzan(@HeaderMap Map<String,String> headers, @FieldMap Map<String,String> map);

    @FormUrlEncoded
    @POST("/v1/m/user/praise/cancel")
    Observable<ResponseBody> quxiao(@HeaderMap Map<String,String> headers, @FieldMap Map<String,String> map);

    @FormUrlEncoded
    @POST("/v1/m/liveCourse/list")
    Observable<LiveBean> loadLiveBean (@HeaderMap Map<String,String> headers, @FieldMap Map<String,String> map);

    @FormUrlEncoded
    @POST("/v1/m/liveCourse/detail")
    Observable<ClassDetailed> loadClassDetail(@HeaderMap Map<String,String> headers, @FieldMap Map<String,String> map);
}
