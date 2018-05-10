package com.example.dell.univstarproject.view.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.dell.univstarproject.R;
import com.example.dell.univstarproject.adapter.FirstAdapter;
import com.example.dell.univstarproject.base.BaseFragment;
import com.example.dell.univstarproject.model.bean.FirstBean;
import com.example.dell.univstarproject.presenter.FirstContrcat;
import com.example.dell.univstarproject.presenter.FirstPresenter;

import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class TeacherFragment extends BaseFragment<FirstPresenter> implements FirstContrcat.FirstView{


    private RecyclerView first_recycle;
    private FirstAdapter adapter;

    @Override
    protected int getLayoutid() {
        return R.layout.fragment_teacher;
    }

    @Override
    protected void initView() {
        first_recycle = getView().findViewById(R.id.first_recycle);
    }

    @Override
    protected void loaddata() {
        presenter.loadfirstdata();
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

    @Override
    public void showdata(FirstBean firstBean) {
        adapter = new FirstAdapter(firstBean.getData(),getActivity());
        LinearLayoutManager manager = new LinearLayoutManager(getActivity(),LinearLayoutManager.VERTICAL,false);
        first_recycle.setLayoutManager(manager);
        first_recycle.setAdapter(adapter);
        initListener();
    }

    private void initListener() {
        adapter.setonclicklistener(new FirstAdapter.onclicklistener() {
            @Override
            public void onitemclick(int position) {

            }
        });
    }
}
