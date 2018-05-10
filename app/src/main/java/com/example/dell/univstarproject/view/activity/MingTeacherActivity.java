package com.example.dell.univstarproject.view.activity;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;

import com.androidkun.xtablayout.XTabLayout;
import com.example.dell.univstarproject.R;
import com.example.dell.univstarproject.adapter.MingTeacherAdapter;
import com.example.dell.univstarproject.adapter.ViewPagerAdapters;
import com.example.dell.univstarproject.base.BaseActivity;
import com.example.dell.univstarproject.model.bean.MingTeacher;
import com.example.dell.univstarproject.presenter.MingTeacherContrcat;
import com.example.dell.univstarproject.presenter.MingTeacherPresenter;
import com.example.dell.univstarproject.view.fragment.BigTeacherFragment;

import java.util.ArrayList;
import java.util.List;

public class MingTeacherActivity extends BaseActivity<MingTeacherPresenter> implements MingTeacherContrcat.MingTeacherView{

    private XTabLayout Ming_tablayout;
    private ViewPager Ming_vip;
    private ArrayList<String> tabList;
    private ArrayList<Fragment> fragments;
    int count = 4;
    @Override
    protected int getLayoutId() {
        return R.layout.activity_ming_teacher;
    }

    @Override
    protected void loadData() {
        presenter.loadMingTeacher();
    }

    protected void initView() {
        Ming_tablayout = (XTabLayout) findViewById(R.id.Ming_tablayout);
        Ming_vip = (ViewPager) findViewById(R.id.Ming_vip);
    }
    @Override
    public void showMingteacher(MingTeacher teacher) {
        if (teacher ==null) {
            return;
        } else {
            tabList = new ArrayList<>();
            tabList.add("大师");
            tabList.add("名师");
            tabList.add("达人");
            fragments = new ArrayList<>();
            for (int i = 0; i < tabList.size(); i++) {
                BigTeacherFragment bigTeacherFragment = new BigTeacherFragment();
                Bundle bundle = new Bundle();
                bundle.putInt("loginUserId",0);
                bundle.putInt("page",i);
                bundle.putInt("rows",i+15);
                bundle.putInt("userType",count--);
                bigTeacherFragment.setArguments(bundle);
                fragments.add(bigTeacherFragment);

            }

            ViewPagerAdapters  adapters = new ViewPagerAdapters(getSupportFragmentManager(),fragments,tabList);
            Ming_vip.setCurrentItem(0);
            Ming_vip.setAdapter(adapters);
            Ming_tablayout.setupWithViewPager(Ming_vip);
        }
    }

}
