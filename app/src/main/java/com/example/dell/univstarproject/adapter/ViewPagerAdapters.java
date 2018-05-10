package com.example.dell.univstarproject.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.ArrayList;

/**
 * 作者:天南地北，旺哥最美！
 * 微信:xw15227039901
 */

public class ViewPagerAdapters extends FragmentPagerAdapter{

    private ArrayList<Fragment> fragmentArrayList;
    private ArrayList<String> mList;

    public ViewPagerAdapters(FragmentManager fm, ArrayList<Fragment> fragmentArrayList, ArrayList<String> mList) {
        super(fm);
        this.fragmentArrayList = fragmentArrayList;
        this.mList = mList;
    }

    @Override
    public Fragment getItem(int position) {
        return fragmentArrayList.get(position);
    }

    @Override
    public int getCount() {
        return fragmentArrayList.size();
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return mList.get(position);
    }
}
