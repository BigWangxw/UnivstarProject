package com.example.dell.univstarproject.view.activity;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.v4.graphics.drawable.RoundedBitmapDrawable;
import android.support.v4.graphics.drawable.RoundedBitmapDrawableFactory;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.webkit.WebResourceRequest;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.target.BitmapImageViewTarget;
import com.example.dell.univstarproject.R;
import com.example.dell.univstarproject.adapter.NewstAdapter;
import com.example.dell.univstarproject.base.BaseActivity;
import com.example.dell.univstarproject.base.BaseApp;
import com.example.dell.univstarproject.model.bean.ClassDetailed;
import com.example.dell.univstarproject.presenter.DetailContrcat;
import com.example.dell.univstarproject.presenter.DetailPresenter;
import com.umeng.socialize.ShareAction;
import com.umeng.socialize.UMShareListener;
import com.umeng.socialize.bean.SHARE_MEDIA;
import com.umeng.socialize.editorpage.ShareActivity;
import com.umeng.socialize.media.UMImage;

import java.text.SimpleDateFormat;
import java.util.Date;

public class LiveXiangQingActivity extends BaseActivity<DetailPresenter> implements View.OnClickListener, DetailContrcat.DetailView {

    private ImageView xiangqing_big_img;
    private ImageView xiangqing_fenxiang;
    private ImageView xiangqing_back;
    private TextView xiangqing_time;
    private TextView xiangqing_num;
    private TextView xingqing_price;
    private ImageView xiangqing_img;
    private TextView xiangqing_name;
    private TextView zhiye_type;
    private Button xiangqing_guanzhu_btn;
    private WebView xiangqing_web;
    private ImageView xiangqing_zan;
    private TextView xiangqing_buy;

    private UMShareListener shareListener = new UMShareListener() {
        /**
         * @descrption 分享开始的回调
         * @param platform 平台类型
         */
        @Override
        public void onStart(SHARE_MEDIA platform) {

        }

        /**
         * @descrption 分享成功的回调
         * @param platform 平台类型
         */
        @Override
        public void onResult(SHARE_MEDIA platform) {
            Toast.makeText(LiveXiangQingActivity.this,"成功了",Toast.LENGTH_LONG).show();
        }

        /**
         * @descrption 分享失败的回调
         * @param platform 平台类型
         * @param t 错误原因
         */
        @Override
        public void onError(SHARE_MEDIA platform, Throwable t) {
            Toast.makeText(LiveXiangQingActivity.this,"失败"+t.getMessage(),Toast.LENGTH_LONG).show();
        }

        /**
         * @descrption 分享取消的回调
         * @param platform 平台类型
         */
        @Override
        public void onCancel(SHARE_MEDIA platform) {
            Toast.makeText(LiveXiangQingActivity.this,"取消了",Toast.LENGTH_LONG).show();

        }
    };
    private UMImage image;
    ClassDetailed detailed;
    int count = 0;
    @Override
    protected int getLayoutId() {
        return R.layout.activity_live_xiang_qing;
    }

    @Override
    protected void loadData() {
        final int classid = getIntent().getIntExtra("classid", 0);
        presenter.loadDetailBean(classid);

        xiangqing_web.loadUrl("http://share.univstar.com/view/live.html?id="+classid);
        WebSettings settings = xiangqing_web.getSettings();
        settings.setJavaScriptEnabled(true);
        xiangqing_web.setWebViewClient(new WebViewClient(){
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, WebResourceRequest request) {
                xiangqing_web.loadUrl("http://share.univstar.com/view/live.html?id="+classid);
                return super.shouldOverrideUrlLoading(view, request);
            }
        });
    }

    protected void initView() {
        xiangqing_big_img = (ImageView) findViewById(R.id.xiangqing_big_img);
        xiangqing_fenxiang = (ImageView) findViewById(R.id.xiangqing_fenxiang);
        xiangqing_back = (ImageView) findViewById(R.id.xiangqing_back);
        xiangqing_time = (TextView) findViewById(R.id.xiangqing_time);
        xiangqing_num = (TextView) findViewById(R.id.xiangqing_num);
        xingqing_price = (TextView) findViewById(R.id.xingqing_price);
        xiangqing_img = (ImageView) findViewById(R.id.xiangqing_img);
        xiangqing_name = (TextView) findViewById(R.id.xiangqing_name);
        zhiye_type = (TextView) findViewById(R.id.zhiye_type);
        xiangqing_guanzhu_btn = (Button) findViewById(R.id.xiangqing_guanzhu_btn);
        xiangqing_web = (WebView) findViewById(R.id.xiangqing_web);
        xiangqing_zan = (ImageView) findViewById(R.id.xiangqing_zan);
        xiangqing_buy = (TextView) findViewById(R.id.xiangqing_buy);
        xiangqing_guanzhu_btn.setOnClickListener(this);
        xiangqing_back.setOnClickListener(this);
        xiangqing_fenxiang.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            //返回
            case R.id.xiangqing_back:
                finish();
                break;
                //分享
            case R.id.xiangqing_fenxiang:
                new ShareAction(LiveXiangQingActivity.this)
                        .withMedia(image)
                        .setDisplayList(SHARE_MEDIA.SINA,SHARE_MEDIA.QQ,SHARE_MEDIA.WEIXIN)
                        .setCallback(shareListener)
                        .open();
                break;
                //关注
            case R.id.xiangqing_guanzhu_btn:
                if (TextUtils.isEmpty(BaseApp.activity.getSharedPreferences("111",MODE_PRIVATE).getString("xyxy_user_id",""))) {
                    //去登陆
                    Toast.makeText(this, "您尚未登陆", Toast.LENGTH_SHORT).show();
                    return;
                }
                count++;
               if (count %2 !=0) {
                   presenter.loadDetailBean("662",detailed.getData().getId()+"");
                   xiangqing_guanzhu_btn.setText("已关注");
               } else {
                   presenter.quxiaoguanzhu("662",detailed.getData().getId()+"");
                   xiangqing_guanzhu_btn.setText("关注");
               }

                break;
        }
    }

    @Override
    public void showDetailBean(ClassDetailed detailed) {
        if (detailed == null)

            return;
        this.detailed = detailed;
        image = new UMImage(LiveXiangQingActivity.this, detailed.getData().getCoverImg());
        image.compressStyle = UMImage.CompressStyle.SCALE;
            Glide.with(this).load(detailed.getData().getCoverImg()).into(xiangqing_big_img);
            SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            Date date = new Date(detailed.getData().getStartDate());
            xiangqing_time.setText(format.format(date));
            xiangqing_num.setText(detailed.getData().getSubscribe()+"/"+detailed.getData().getSubscribeNum());
            xiangqing_name.setText(detailed.getData().getNickname());
            zhiye_type.setText(detailed.getData().getIntro());
            xingqing_price.setText(detailed.getData().getPrice()+"");

            Glide.with(this).load(detailed.getData().getPhoto()).asBitmap().centerCrop().into(new BitmapImageViewTarget(xiangqing_img) {

                @Override

                protected void setResource(Bitmap resource) {

                    RoundedBitmapDrawable circularBitmapDrawable =

                            RoundedBitmapDrawableFactory.create(LiveXiangQingActivity.this.getResources(), resource);

                    circularBitmapDrawable.setCircular(true);

                    xiangqing_img.setImageDrawable(circularBitmapDrawable);

                }

            });
        }

}
