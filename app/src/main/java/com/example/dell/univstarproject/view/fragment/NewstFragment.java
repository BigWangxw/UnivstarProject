package com.example.dell.univstarproject.view.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.dell.univstarproject.R;
import com.example.dell.univstarproject.adapter.BrainPowerAdapter;
import com.example.dell.univstarproject.adapter.NewstAdapter;
import com.example.dell.univstarproject.base.BaseFragment;
import com.example.dell.univstarproject.model.bean.NewstBean;
import com.example.dell.univstarproject.model.bean.ToastBean;
import com.example.dell.univstarproject.presenter.NewstPresenter;
import com.example.dell.univstarproject.presenter.NewtContrcat;

import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class NewstFragment extends BaseFragment<NewstPresenter> implements NewtContrcat.NewsView{


    private RecyclerView news_recycle;

    @Override
    protected int getLayoutid() {
        return R.layout.fragment_newst;
    }

    @Override
    protected void initView() {
        news_recycle = getView().findViewById(R.id.news_recycle);
    }

    @Override
    protected void loaddata() {
        presenter.loaddata();
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
    public void showDemodata(NewstBean newstBean) {
        List<NewstBean.DataBean.ListBean> list = newstBean.getData().getList();
        NewstAdapter adapter = new NewstAdapter(list,getActivity());
        LinearLayoutManager manager = new LinearLayoutManager(getActivity());
        news_recycle.setLayoutManager(manager);
        news_recycle.setAdapter(adapter);
    }

    @Override
    public void showErrorMessage(String msg) {
        ToastBean.showmessage(getActivity(),msg);
    }
}
