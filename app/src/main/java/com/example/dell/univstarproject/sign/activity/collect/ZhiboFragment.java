package com.example.dell.univstarproject.sign.activity.collect;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.dell.univstarproject.R;
import com.example.dell.univstarproject.model.http.ShapeUtils;
import com.example.dell.univstarproject.sign.entry.Collect_zhibo;
import com.example.dell.univstarproject.sign.prisenter.IZhiboprisenter;
import com.example.dell.univstarproject.sign.prisenter.Zhiboprisenter;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class ZhiboFragment extends Fragment implements ZhiboView{


    private RecyclerView zhibo_recy;
    private View view;
    private IZhiboprisenter zhiboprisenter;
    private List<Collect_zhibo.DataBean.ListBean> listBeans=new ArrayList<>();
    private ZhiboAdapter zhiboAdapter;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view=inflater.inflate(R.layout.fragment_zhibo,container,false);
        zhibo_recy=view.findViewById(R.id.zhibo_recy);
        LinearLayoutManager linearLayoutManager=new LinearLayoutManager(getContext());
        zhibo_recy.setLayoutManager(linearLayoutManager);
        int id = ShapeUtils.getIntance().getId();
        zhiboprisenter=new Zhiboprisenter(this);
        zhiboprisenter.loadCollect(id,1);
        zhiboAdapter=new ZhiboAdapter(listBeans,getContext());
        zhibo_recy.setAdapter(zhiboAdapter);
        return view;
    }

    @Override
    public void showZhibo(List<Collect_zhibo.DataBean.ListBean> collect_zhibo) {
        listBeans.clear();
        listBeans.addAll(collect_zhibo);
        zhiboAdapter.notifyDataSetChanged();
    }
}
