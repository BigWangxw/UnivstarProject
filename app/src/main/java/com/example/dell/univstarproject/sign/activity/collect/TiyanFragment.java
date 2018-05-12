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
import com.example.dell.univstarproject.sign.entry.TIyan;
import com.example.dell.univstarproject.sign.prisenter.ITiyanprisenter;
import com.example.dell.univstarproject.sign.prisenter.Tiyanprisenter;
import com.example.dell.univstarproject.sign.signview.TIyanView;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class TiyanFragment extends Fragment implements TIyanView{
    private View view;
    private RecyclerView recyclerView;
    private ITiyanprisenter tiyanprisenter;
    private List<TIyan.DataBean.ListBean> listBeans=new ArrayList<>();
    private TIyanAdapter tIyanAdapter;




    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view=inflater.inflate(R.layout.fragment_tiyan,container,false);
        recyclerView=view.findViewById(R.id.tiyan_recy);
        LinearLayoutManager linearLayoutManager=new LinearLayoutManager(getContext());
        recyclerView.setLayoutManager(linearLayoutManager);
        int id = ShapeUtils.getIntance().getId();
        tiyanprisenter=new Tiyanprisenter(this);
        tiyanprisenter.loadTiyan(id,2);
        tIyanAdapter=new TIyanAdapter(listBeans,getContext());
        recyclerView.setAdapter(tIyanAdapter);
        return view;
    }

    @Override
    public void showTiyan(List<TIyan.DataBean.ListBean> listBean) {
        listBeans.clear();
        listBeans.addAll(listBean);
        tIyanAdapter.notifyDataSetChanged();
    }
}
