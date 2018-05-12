package com.example.dell.univstarproject.sign.orderAdapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.dell.univstarproject.R;
import com.example.dell.univstarproject.sign.entry.Label;

import java.util.List;

/**
 * Created by Administrator on 2018/5/9 0009.
 */

public class PianHaoAdapter extends RecyclerView.Adapter<PianHaoAdapter.Holder> implements View.OnClickListener{
    private List<Label.DataBean.MajorsBean> arrayList;
    private Context context;
    private OnItemClick onItemClick;

    public PianHaoAdapter(List<Label.DataBean.MajorsBean> arrayList, Context context) {
        this.arrayList = arrayList;
        this.context = context;
    }

    @NonNull
    @Override
    public Holder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.pianhao_item_zhuanye,parent,false);
        Holder holder = new Holder(view);

        view.setOnClickListener(this);
        return holder;
    }
    @Override
    public void onBindViewHolder(@NonNull Holder holder, int position) {
        Label.DataBean.MajorsBean majorsBean = arrayList.get(position);
        holder.button.setText(majorsBean.getName());
        holder.itemView.setTag(position);
    }
    @Override
    public int getItemCount() {
        return arrayList.size();
    }
    public interface OnItemClick{
        void setOnItemClik(View view,int position);
    }
    public void setOnItemClick(OnItemClick onItemClick){
        this.onItemClick=onItemClick;
    }
    @Override
    public void onClick(View v) {
        if (onItemClick!=null){
            onItemClick.setOnItemClik(v, (int) v.getTag());
        }
    }
    public class Holder extends RecyclerView.ViewHolder {
        private Button button;
        public Holder(View itemView) {
            super(itemView);
            button=itemView.findViewById(R.id.pianhao_zhuanye);
        }
    }
}
