package com.example.dell.univstarproject.view.fragment;


import android.content.Context;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.androidkun.xtablayout.XTabLayout;
import com.example.dell.univstarproject.R;
import com.example.dell.univstarproject.adapter.ViewPagerAdapters;
import com.example.dell.univstarproject.base.BaseApp;
import com.example.dell.univstarproject.base.BaseFragment;
import com.example.dell.univstarproject.model.bean.MyScrollView;
import com.example.dell.univstarproject.model.bean.NoScrollViewPager;
import com.example.dell.univstarproject.presenter.DemoContrcat;
import com.example.dell.univstarproject.presenter.DemoPresenter;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class DemoFragment extends BaseFragment  {


    private XTabLayout tab_layout;
    private TextView commite_demo;
    private TextView fabu_demo;
    private ViewPager vip;
    private ArrayList<Fragment> fragmentArrayList;
    private ArrayList<String> arrayList;

    @Override
    protected int getLayoutid() {

        return R.layout.fragment_demo;
    }

    @Override
    protected void initView() {


        tab_layout = getView().findViewById(R.id.xTablayout);
        commite_demo = getView().findViewById(R.id.commite_demo);
        fabu_demo = getView().findViewById(R.id.fabu_demo);
        vip = getView().findViewById(R.id.vip);
//        vip.setCurrentItem(0);
//        vip.setNoScroll(true);

    }




    @Override
    protected void loaddata() {

        arrayList = new ArrayList<>();
        arrayList.add("智能筛选");
        arrayList.add("偷听最多");
        arrayList.add("最新点评");
        fragmentArrayList = new ArrayList<>();
        fragmentArrayList.add(new BrainPowerFragment());
        fragmentArrayList.add(new EarwigFragment());
        fragmentArrayList.add(new NewstFragment());
        ViewPagerAdapters adapters = new ViewPagerAdapters(getActivity().getSupportFragmentManager(),fragmentArrayList,arrayList);
        vip.setCurrentItem(0);
        vip.setAdapter(adapters);
        tab_layout.setupWithViewPager(vip);

    }
    @Override
    protected void onHidden() {

    }

    @Override
    protected void onShow() {

    }

    @Override
    public void setTitle() {

    }



}
