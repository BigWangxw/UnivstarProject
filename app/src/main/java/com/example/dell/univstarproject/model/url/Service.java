package com.example.dell.univstarproject.model.url;

import com.example.dell.univstarproject.sign.entry.TokenData;
import com.example.dell.univstarproject.start.model.bean.AppTokenBean;
import com.example.dell.univstarproject.start.model.bean.BabyBean;
import com.example.dell.univstarproject.start.model.bean.ClassDetailed;
import com.example.dell.univstarproject.start.model.bean.ControllerBean;
import com.example.dell.univstarproject.start.model.bean.Course;
import com.example.dell.univstarproject.start.model.bean.DeailBean;
import com.example.dell.univstarproject.start.model.bean.DemoFirstBean;
import com.example.dell.univstarproject.start.model.bean.FirstBean;
import com.example.dell.univstarproject.start.model.bean.ForeBean;
import com.example.dell.univstarproject.start.model.bean.LiveBean;
import com.example.dell.univstarproject.start.model.bean.LiveDetailModel;
import com.example.dell.univstarproject.start.model.bean.MingTeacher;
import com.example.dell.univstarproject.start.model.bean.NewstBean;
import com.example.dell.univstarproject.start.model.bean.Teacher;

import java.util.Map;

import io.reactivex.Observable;
import okhttp3.ResponseBody;
import retrofit2.http.Field;
import retrofit2.http.FieldMap;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.HeaderMap;
import retrofit2.http.POST;
import retrofit2.http.Url;

/**
 * Created by Administrator on 2018/5/4 0004.
 */

public interface Service {
    //获取验证码
    @FormUrlEncoded
    @POST("v1/m/user/authcode")
    Observable<ResponseBody> zhuce( @FieldMap Map<String,String> pramas);

    //注册
    @FormUrlEncoded
    @POST("v1/m/user/register/mobile")
    Observable<ResponseBody> zhucesuccess(@FieldMap Map<String,String> pramas);

    @FormUrlEncoded
    @POST("v1/m/user/saveCompleteUser")
    Observable<ResponseBody> wangCheng(@FieldMap Map<String,String> pramas);

    //修改密码
    @FormUrlEncoded
    @POST("v1/m/user/save/password")
    Observable<ResponseBody> pass(@FieldMap Map<String,String> pramas);

    //更换手机号
    @FormUrlEncoded
    @POST("v1/m/user/authcode")
    Observable<ResponseBody> findphone( @FieldMap Map<String,String> pramas);

    @FormUrlEncoded
    @POST("v1/m/user/register/mobile")
    Observable<ResponseBody> find(@FieldMap Map<String,String> pramas);

    //登录
    @FormUrlEncoded
    @POST("v1/m/user/login/mobile")
    Observable<ResponseBody> sign(@FieldMap Map<String,String> pramas);

    //偏好获取标签
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

    @FormUrlEncoded
    @POST("v1/m/homewok/home")
    Observable<DemoFirstBean> loaddata(@HeaderMap Map<String, String> headers, @FieldMap Map<String, String> map);
    @FormUrlEncoded
    @POST("v1/m/homewok/home")
    Observable<NewstBean> loadnewtbeandata(@HeaderMap Map<String, String> headers, @FieldMap Map<String, String> map);
    @POST
    Observable<AppTokenBean> getAppToken(@Url String url);

    @FormUrlEncoded
    @POST("/v1/m/home/alliance/list")
    Observable<FirstBean> loadfirstdata(@HeaderMap Map<String, String> headers, @FieldMap Map<String, String> map);

    @FormUrlEncoded
    @POST("/v1/m/artcircle/home")
    Observable<BabyBean> loadbabydata(@HeaderMap Map<String, String> headers, @FieldMap Map<String, String> map);

    @FormUrlEncoded
    @POST("/v1/m/forthcoming/home")
    Observable<ForeBean> loadforedata(@HeaderMap Map<String, String> headers, @FieldMap Map<String, String> map);

    @FormUrlEncoded
    @POST("/v1/m/home/courses/page")
    Observable<Course> loadcourse(@HeaderMap Map<String, String> headers, @FieldMap Map<String, String> map);

    @FormUrlEncoded
    @POST("/v1/m/liveCourse/detail")
    Observable<LiveDetailModel> getlivedetailmodel(@Field("loginUserId") Integer loginUserId, @Field("id") int id);

    @FormUrlEncoded
    @POST("/v1/m/user/teacher/list")
    Observable<MingTeacher> loadMingTeacher(@HeaderMap Map<String, String> headers, @FieldMap Map<String, Integer> map);

    @FormUrlEncoded
    @POST("/v1/m/user/teacher/homepage")
    Observable<Teacher> loadTeacherBean(@HeaderMap Map<String, String> headers, @FieldMap Map<String, Integer> map);

    @FormUrlEncoded
    @POST("/v1/m/user/praise")
    Observable<ResponseBody> dianzan(@HeaderMap Map<String, String> headers, @FieldMap Map<String, String> map);

    @FormUrlEncoded
    @POST("/v1/m/user/praise/cancel")
    Observable<ResponseBody> quxiao(@HeaderMap Map<String, String> headers, @FieldMap Map<String, String> map);

    @FormUrlEncoded
    @POST("/v1/m/liveCourse/list")
    Observable<LiveBean> loadLiveBean(@HeaderMap Map<String, String> headers, @FieldMap Map<String, String> map);

    @FormUrlEncoded
    @POST("/v1/m/liveCourse/detail")
    Observable<ClassDetailed> loadClassDetail(@HeaderMap Map<String, String> headers, @FieldMap Map<String, String> map);

    @FormUrlEncoded
    @POST("/v1/m/user/attention")
    Observable<ResponseBody> guanzhu(@HeaderMap Map<String, String> headers, @FieldMap Map<String, String> map);
    @FormUrlEncoded
    @POST("/v1/m/user/attention/cancel")
    Observable<ResponseBody> quxiaoguanzhu(@HeaderMap Map<String, String> headers, @FieldMap Map<String, String> map);

    @FormUrlEncoded
    @POST("/v1/m/gift/list")
    Observable<ControllerBean> loadController(@HeaderMap Map<String, String> headers, @FieldMap Map<String, String> map);

    @FormUrlEncoded
    @POST("/v1/m/homewok/detail")
    Observable<DeailBean> loadDeailBean(@HeaderMap Map<String, String> headers, @FieldMap Map<String, String> map);

    @FormUrlEncoded
    @POST("v1/m/message/attention")
    Observable<ResponseBody> Guan(@FieldMap Map<String,String> pramas,@HeaderMap Map<String,String> map);
}
