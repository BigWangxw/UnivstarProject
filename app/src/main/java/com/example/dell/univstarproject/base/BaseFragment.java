package com.example.dell.univstarproject.base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

/**
 * 作者:天南地北，旺哥最美！
 * 微信:xw15227039901
 */

public abstract class BaseFragment<T extends BasePresenter> extends Fragment{
    protected T presenter;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(getLayoutid(),container,false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
       // presenter = getPresenter();
        if (presenter != null) {
            presenter.AcctachView(this);
        }
        initView();
        loaddata();
    }
    @Override
    public void onStop() {
        super.onStop();
        if (presenter !=null) {
            presenter.DateView();
        }
    }

    protected abstract int getLayoutid();
    protected abstract void initView();
    protected abstract void loaddata();
    public T getPresenter() {
        Type type = getClass().getGenericSuperclass();
        if (BaseActivity.class.equals(type)) {
            return null;
        }
        Type[] arguments = ((ParameterizedType) type).getActualTypeArguments();
        Class<T> aClass = (Class<T>) arguments[0];
        try {
            return aClass.newInstance();
        } catch (java.lang.InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        return null;
    }
    @Override
    public void onHiddenChanged(boolean hidden) {
        super.onHiddenChanged(hidden);
        if (hidden)
            onHidden();
        else
            onShow();

    }

    /**
     * 代表Fragment处于隐藏状态
     */
    protected abstract void onHidden();

    /**
     * 代表Fragment处于可见状态
     */
    protected abstract void onShow();

    /**
     * 设置标题
     * @return
     */
    public abstract void setTitle();
}
