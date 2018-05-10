package com.example.dell.univstarproject.view.fragment;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.dell.univstarproject.R;
import com.example.dell.univstarproject.adapter.LiveAdapter;
import com.example.dell.univstarproject.base.BaseFragment;
import com.example.dell.univstarproject.model.bean.LiveBean;
import com.example.dell.univstarproject.presenter.LiveContrcat;
import com.example.dell.univstarproject.presenter.LivePresenter;
import com.example.dell.univstarproject.view.activity.LiveXiangQingActivity;

import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class ClassFragment extends BaseFragment<LivePresenter> implements LiveContrcat.LiveView {


    private RecyclerView live_recycle;
    private LiveAdapter adapter;
    private List<LiveBean.DataBean.ListBean> list;

    @Override
    protected int getLayoutid() {
        return R.layout.fragment_class;
    }

    @Override
    protected void initView() {
        live_recycle = getView().findViewById(R.id.live_recycle);
    }

    @Override
    protected void loaddata() {
        presenter.loadLiveBean();
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
    public void showLiveBean(LiveBean liveBean) {
        if (liveBean == null) {
            return;

        } else {
            list = liveBean.getData().getList();
            adapter = new LiveAdapter(list,getActivity());
            LinearLayoutManager manager = new LinearLayoutManager(getActivity(),LinearLayoutManager.VERTICAL,false);
            live_recycle.setLayoutManager(manager);
            live_recycle.setAdapter(adapter);
            initListener();
        }
    }

    private void initListener() {
        adapter.setonclicklistener(new LiveAdapter.onclicklistener() {
            @Override
            public void onitemclick(int position) {
                Intent intent = new Intent(getActivity(),LiveXiangQingActivity.class);
                intent.putExtra("classid",list.get(position).getId());
                startActivity(intent);
            }
        });
    }
}
