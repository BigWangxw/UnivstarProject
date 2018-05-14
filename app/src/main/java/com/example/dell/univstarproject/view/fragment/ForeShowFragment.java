package com.example.dell.univstarproject.view.fragment;


import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Button;

import com.example.dell.univstarproject.R;
import com.example.dell.univstarproject.base.BaseFragment;
import com.example.dell.univstarproject.start.adapter.ForeAdapter;
import com.example.dell.univstarproject.start.model.bean.ForeBean;
import com.example.dell.univstarproject.start.presenter.ForeContrcat;
import com.example.dell.univstarproject.start.presenter.ForePresenter;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class ForeShowFragment extends BaseFragment<ForePresenter> implements ForeContrcat.ForeView {


    private Button sizer_btn;
    private RecyclerView fore_recycle;

    @Override
    protected int getLayoutid() {
        return R.layout.fragment_fore_show;
    }

    @Override
    protected void initView() {
        sizer_btn = getView().findViewById(R.id.sizer_btn);
        fore_recycle = getView().findViewById(R.id.fore_recycle);
    }

    @Override
    protected void loaddata() {
        presenter.loadforedata();
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
    public void showbean(ForeBean foreBean) {
        List<ForeBean.DataBean.ListBean> list = foreBean.getData().getList();
        ForeAdapter adapter = new ForeAdapter((ArrayList<ForeBean.DataBean.ListBean>) list,getActivity());
        LinearLayoutManager manager = new LinearLayoutManager(getActivity(),LinearLayoutManager.VERTICAL,false);
        fore_recycle.setLayoutManager(manager);
        fore_recycle.setAdapter(adapter);
    }
}
