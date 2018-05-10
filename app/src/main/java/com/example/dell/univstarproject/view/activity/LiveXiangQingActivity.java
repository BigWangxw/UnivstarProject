package com.example.dell.univstarproject.view.activity;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.v4.graphics.drawable.RoundedBitmapDrawable;
import android.support.v4.graphics.drawable.RoundedBitmapDrawableFactory;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.webkit.WebResourceRequest;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.target.BitmapImageViewTarget;
import com.example.dell.univstarproject.R;
import com.example.dell.univstarproject.adapter.NewstAdapter;
import com.example.dell.univstarproject.base.BaseActivity;
import com.example.dell.univstarproject.model.bean.ClassDetailed;
import com.example.dell.univstarproject.presenter.DetailContrcat;
import com.example.dell.univstarproject.presenter.DetailPresenter;

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

                break;
                //关注
            case R.id.xiangqing_guanzhu_btn:

                break;
        }
    }

    @Override
    public void showDetailBean(ClassDetailed detailed) {
        if (detailed == null) {

            return;

        } else {

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
}
