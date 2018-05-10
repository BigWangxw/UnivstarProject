package com.example.dell.univstarproject.view.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.example.dell.univstarproject.R;
import com.example.dell.univstarproject.adapter.MoreAllAdapter;
import com.example.dell.univstarproject.base.BaseFragment;
import com.example.dell.univstarproject.model.bean.BabyBean;
import com.example.dell.univstarproject.presenter.MoreAllContrcat;
import com.example.dell.univstarproject.presenter.MoreAllPresenter;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class
MoreAllFragment extends BaseFragment<MoreAllPresenter> implements MoreAllContrcat.MoreaddView{

    private RecyclerView baby_recycle;
    private LinearLayout linear;

    @Override
    protected int getLayoutid() {
        return R.layout.fragment_more_all;
    }

    @Override
    protected void initView() {
        baby_recycle = getView().findViewById(R.id.baby_recycle);
        linear = getView().findViewById(R.id.linear);

    }

    @Override
    protected void loaddata() {


        Bundle bundle = getArguments();
        String spage = String.valueOf(bundle.getInt("page"));
        String row = String.valueOf(bundle.getInt("row"));
        String sortord = String.valueOf(bundle.getInt("sortord"));

        presenter.loaddata(spage,row,sortord);


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
    public void showdata(BabyBean babyBean) {

        List<BabyBean.DataBean.ArtcircleListBean.ListBean> list = babyBean.getData().getArtcircleList().getList();
         if(list.size() == 0){

            linear.setVisibility(View.VISIBLE);
        }else {

            linear.setVisibility(View.GONE);
        }
        MoreAllAdapter adapter = new MoreAllAdapter((ArrayList<BabyBean.DataBean.ArtcircleListBean.ListBean>) list,getActivity());
        LinearLayoutManager manager = new LinearLayoutManager(getActivity(),LinearLayoutManager.VERTICAL,false);

            baby_recycle.setLayoutManager(manager);
            baby_recycle.setAdapter(adapter);





    }

    @Override
    public void showlinear(boolean yes) {
//        if (yes) {
//
//            linear.setVisibility(View.VISIBLE);
//        } else {
//
//            linear.setVisibility(View.GONE);
//        }
    }
}
