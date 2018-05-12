package com.example.dell.univstarproject.base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;

import com.example.dell.univstarproject.R;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

/**
 * 作者:天南地北，旺哥最美！
 * 微信:xw15227039901
 */

public abstract class BaseActivity<T extends BasePresenter> extends AppCompatActivity{
    private int layoutId;
    private BaseFragment lastFragment;
    protected T presenter;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getLayoutId());
        BaseApp.activity = this;
        presenter = getPresenter();
        if (presenter != null) {
            presenter.AcctachView(this);
        }
        loadData();
        initView();
    }

    @Override
    protected void onResume() {
        super.onResume();
        BaseApp.activity = this;
    }

    @Override
    protected void onPause() {
        super.onPause();
        BaseApp.activity = null;
    }

    @Override
    protected void onStop() {
        super.onStop();
        if (presenter !=null) {
            presenter.DateView();
        }
    }

    public T getPresenter() {
        Type type = getClass().getGenericSuperclass();
        if (BaseActivity.class.equals(type)) {
            return null;
        }
        Type[] arguments = ((ParameterizedType) type).getActualTypeArguments();
        Class<T> aClass = (Class<T>) arguments[0];
        try {
            return aClass.newInstance();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        return null;

    }
    public BaseFragment setContentView(Class<? extends BaseFragment> fragmentClass){
        FragmentManager supportFragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = supportFragmentManager.beginTransaction();
        String simpleName = fragmentClass.getSimpleName();
        /**
         * 1、如何创建Fragment对象
         * 2、如何知道该Fragment已经创建过  如果已创建 直接查询到显示 没有创建 才创建
         */

        //根据Tag来查找Fragment
        BaseFragment fragmentByTag = (BaseFragment) supportFragmentManager.findFragmentByTag(simpleName);
        if (fragmentByTag == null) {
            try {
                fragmentByTag = fragmentClass.newInstance();
                fragmentTransaction.add(R.id.fg, fragmentByTag, simpleName);
                if (lastFragment != null)
                    //隐藏上一个Fragment
                    fragmentTransaction.hide(lastFragment);
                    //显示当前fragment
                    fragmentTransaction.show(fragmentByTag);


            } catch (InstantiationException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
            lastFragment = fragmentByTag;
            fragmentTransaction.commit();
        }
        return fragmentByTag;
    }
    protected abstract int getLayoutId();
    protected abstract void loadData();
    protected abstract void initView();
}
