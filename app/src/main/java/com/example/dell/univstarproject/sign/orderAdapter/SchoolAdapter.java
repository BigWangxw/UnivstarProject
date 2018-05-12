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

public class SchoolAdapter extends RecyclerView.Adapter<SchoolAdapter.Holder> implements View.OnClickListener{
    private List<Label.DataBean.CollegesBean> list;
    private Context context;

    public SchoolAdapter(List<Label.DataBean.CollegesBean> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @NonNull
    @Override
    public Holder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.pianhao_item_yuanxiao,parent,false);
        Holder holder = new Holder(view);
        view.setOnClickListener(this);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull Holder holder, int position) {
        Label.DataBean.CollegesBean collegesBean = list.get(position);
        holder.button.setText(collegesBean.getName());
        holder.itemView.setTag(position);
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    @Override
    public void onClick(View v) {

    }

    public class Holder extends RecyclerView.ViewHolder {
        private Button button;
        public Holder(View itemView) {
            super(itemView);
            button=itemView.findViewById(R.id.pianhao_yuanxiao);
        }
    }
}
