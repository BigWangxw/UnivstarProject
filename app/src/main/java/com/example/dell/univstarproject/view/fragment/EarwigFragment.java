package com.example.dell.univstarproject.view.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.dell.univstarproject.R;
import com.example.dell.univstarproject.adapter.BrainPowerAdapter;
import com.example.dell.univstarproject.base.BaseFragment;
import com.example.dell.univstarproject.model.bean.DemoBean;
import com.example.dell.univstarproject.model.bean.DemoFirstBean;
import com.example.dell.univstarproject.presenter.DemoContrcat;
import com.example.dell.univstarproject.presenter.DemoPresenter;

import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class EarwigFragment extends BaseFragment<DemoPresenter> implements DemoContrcat.DemoView{

    private RecyclerView recycle;
    @Override
    protected int getLayoutid() {
        return R.layout.fragment_earwig;
    }

    @Override
    protected void initView() {
        recycle = getView().findViewById(R.id.recycle);
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
    public void showDemodata(DemoFirstBean demoBean) {
        final List<DemoFirstBean.DataBean.ListBean> list = demoBean.getData().getList();
        Log.d("showDemodata: ",demoBean.getData().getList().size()+"");
        BrainPowerAdapter adapter = new BrainPowerAdapter(list,getActivity());
        LinearLayoutManager manager = new LinearLayoutManager(getActivity());
        recycle.setLayoutManager(manager);
        recycle.setAdapter(adapter);
    }
}
