package com.example.dell.univstarproject.view.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.dell.univstarproject.R;
import com.example.dell.univstarproject.base.BaseFragment;
import com.example.dell.univstarproject.model.bean.DemoBean;
import com.example.dell.univstarproject.presenter.DemoContrcat;
import com.example.dell.univstarproject.presenter.DemoPresenter;

import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class BrainPowerFragment extends BaseFragment<DemoPresenter> implements DemoContrcat.DemoView{

   // private DemoContrcat.DemoPre pre;
    @Override
    protected int getLayoutid() {
        return R.layout.fragment_brain_power;
    }

    @Override
    protected void initView() {
       // pre=new DemoPresenter(this);
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
    public void showDemodata(DemoBean demoBean) {
        List<DemoBean.DataBean.ListBean> list = demoBean.getData().getList();

    }
}
