package com.example.dell.univstarproject.view.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.androidkun.xtablayout.XTabLayout;
import com.example.dell.univstarproject.R;
import com.example.dell.univstarproject.adapter.ViewPagerAdapters;
import com.example.dell.univstarproject.base.BaseActivity;
import com.example.dell.univstarproject.base.BaseApp;
import com.example.dell.univstarproject.base.BaseFragment;
import com.example.dell.univstarproject.model.bean.BabyBean;
import com.example.dell.univstarproject.model.bean.PisicImage;
import com.example.dell.univstarproject.presenter.BabyContrcat;
import com.example.dell.univstarproject.presenter.BabyPresenter;
import com.example.dell.univstarproject.view.activity.MainActivity;
import com.youth.banner.Banner;
import com.youth.banner.BannerConfig;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class BabyFragment extends BaseFragment<BabyPresenter> implements BabyContrcat.BabyView{


    private Banner baby_banner;
    private XTabLayout baby_tablayout;
    private ViewPager baby_vip;
    private ArrayList<Fragment> fragmentArrayList;
    private ArrayList<String> tabList1;

    @Override
    protected int getLayoutid() {
        return R.layout.fragment_baby;
    }

    @Override
    protected void initView() {
        baby_banner = getView().findViewById(R.id.baby_banner);
        baby_tablayout = getView().findViewById(R.id.baby_tablayout);
        baby_vip = getView().findViewById(R.id.baby_vip);
    }

    @Override
    protected void loaddata() {
        presenter.loadbabydata();

    }

    @Override
    protected void onHidden() {

    }

    @Override
    protected void onShow() {

    }

    @Override
    public void setTitle() {
      // ((MainActivity) getActivity()).font_img.setVisibility(View.VISIBLE);
    }

    @Override
    public void showbaby(BabyBean babyBean) {
        List<BabyBean.DataBean.SystemAdsBean> systemAds = babyBean.getData().getSystemAds();
        ArrayList<String> arrayList = new ArrayList<>();
        arrayList.add(systemAds.get(0).getMobileImgUrl());
        arrayList.add(systemAds.get(1).getMobileImgUrl());

        baby_banner.setImages(arrayList)
                .setDelayTime(2000)
                .setBannerStyle(BannerConfig.NUM_INDICATOR)
                .setImageLoader(new PisicImage())
                .setIndicatorGravity(BannerConfig.RIGHT)
                .start();
        fragmentArrayList = new ArrayList<>();
        tabList1 = new ArrayList<>();
        tabList1.add("智能筛选");
        tabList1.add("赞数最多");
        tabList1.add("最新评论");
        List<BabyBean.DataBean.ArtcircleCategoriesBean> list = babyBean.getData().getArtcircleCategories();
        Log.e("43776384568", list.size()+"");
        for (int i = 0; i < list.size(); i++) {
            tabList1.add(list.get(i).getName());

        }
        for (int j = 0; j < tabList1.size(); j++) {
            MoreAllFragment fragment = new MoreAllFragment();
            Bundle bundle = new Bundle();
            //BabyBean.DataBean.ArtcircleListBean listBean = babyBean.getData().getArtcircleList();
            bundle.putInt("page",1+j);
            bundle.putInt("row",2+j);
            bundle.putInt("sortord",j);
            fragment.setArguments(bundle);
            fragmentArrayList.add(fragment);
        }
        ViewPagerAdapters adapters = new ViewPagerAdapters(getActivity().getSupportFragmentManager(),fragmentArrayList,tabList1);
        baby_vip.setCurrentItem(0);
        baby_vip.setAdapter(adapters);
        baby_tablayout.setupWithViewPager(baby_vip);
    }

}
