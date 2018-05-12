package com.example.dell.univstarproject.sign.orderAdapter;

import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.ArrayList;

/**
 * Created by Administrator on 2018/5/6 0006.
 */

public class OrderAdapter extends FragmentPagerAdapter{
    private ArrayList<Fragment> arrayList;
    private ArrayList<String> arrayList1;

    public OrderAdapter(FragmentManager fm, ArrayList<Fragment> arrayList, ArrayList<String> arrayList1) {
        super(fm);
        this.arrayList = arrayList;
        this.arrayList1 = arrayList1;
    }
    @Override
    public Fragment getItem(int position) {
        return arrayList.get(position);
    }

    @Override
    public int getCount() {
        return arrayList.size();
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        return arrayList1.get(position);
    }
}
