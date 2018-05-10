package com.example.dell.univstarproject.view.fragment;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.dell.univstarproject.R;
import com.example.dell.univstarproject.adapter.MingTeacherAdapter;
import com.example.dell.univstarproject.base.BaseFragment;
import com.example.dell.univstarproject.model.bean.MingTeacher;
import com.example.dell.univstarproject.presenter.MingTeacherContrcat;
import com.example.dell.univstarproject.presenter.MingTeacherContrcat.MingTeacherView;
import com.example.dell.univstarproject.presenter.MingTeacherPresenter;
import com.example.dell.univstarproject.view.activity.TeacherFirstActivity;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class BigTeacherFragment extends BaseFragment<MingTeacherPresenter> implements MingTeacherView {


    private RecyclerView big_recycle;
    private MingTeacherAdapter adapter;
    private List<MingTeacher.DataBean.ListBean> list;

    @Override
    protected int getLayoutid() {
        return R.layout.fragment_big_teacher;
    }

    @Override
    protected void initView() {
        big_recycle = getView().findViewById(R.id.big_recycle);
    }

    @Override
    protected void loaddata() {
        Bundle bundle = getArguments();
        int page = bundle.getInt("page");
        int loginUserId = bundle.getInt("loginUserId");
        int rows = bundle.getInt("rows");
        int userType = bundle.getInt("userType");
        presenter.loadMingTeacher(page,rows,loginUserId,userType);
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
    public void showMingteacher(MingTeacher teacher) {
        if (teacher == null) {
            return;
        } else {
            list = teacher.getData().getList();
            adapter = new MingTeacherAdapter((ArrayList<MingTeacher.DataBean.ListBean>) list,getActivity());
            StaggeredGridLayoutManager manager = new StaggeredGridLayoutManager(2,StaggeredGridLayoutManager.VERTICAL);
            big_recycle.setLayoutManager(manager);
            big_recycle.setAdapter(adapter);
            initAdapter();
        }
    }

    private void initAdapter() {
        adapter.setonclicklistener(new MingTeacherAdapter.onclicklosyener() {
            @Override
            public void onitemclick(int position) {

                Intent intent = new Intent(getActivity(),TeacherFirstActivity.class);
                intent.putExtra("teaId",list.get(position).get_$Id164());
                startActivity(intent);
            }
        });
    }
}
