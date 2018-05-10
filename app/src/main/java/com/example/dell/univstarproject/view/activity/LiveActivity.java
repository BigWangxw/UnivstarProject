package com.example.dell.univstarproject.view.activity;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.androidkun.xtablayout.XTabLayout;
import com.example.dell.univstarproject.R;
import com.example.dell.univstarproject.adapter.ViewPagerAdapters;
import com.example.dell.univstarproject.base.BaseActivity;
import com.example.dell.univstarproject.model.bean.LiveBean;
import com.example.dell.univstarproject.presenter.LiveContrcat;
import com.example.dell.univstarproject.presenter.LivePresenter;
import com.example.dell.univstarproject.view.fragment.ClassFragment;
import com.example.dell.univstarproject.view.fragment.ZhiBoLiveFragment;

import java.util.ArrayList;
import java.util.List;

public class LiveActivity extends BaseActivity{

    private ViewPager live_vip;
    private ArrayList<String> tabList;
    private ArrayList<Fragment> fragments;
    private XTabLayout live_tablayout;



    @Override
    protected int getLayoutId() {
        return R.layout.activity_live;
    }

    @Override
    protected void loadData() {
        tabList = new ArrayList<>();
        tabList.add("课程");
        tabList.add("直播live");
        fragments = new ArrayList<>();
        fragments.add(new ClassFragment());
        fragments.add(new ZhiBoLiveFragment());

        ViewPagerAdapters adapters = new ViewPagerAdapters(getSupportFragmentManager(),fragments,tabList);
        live_vip.setCurrentItem(0);
        live_vip.setAdapter(adapters);
        live_tablayout.setupWithViewPager(live_vip);
    }

    protected void initView() {
        live_tablayout = findViewById(R.id.live_tablayout);
        live_vip = (ViewPager) findViewById(R.id.live_vip);
    }


}
