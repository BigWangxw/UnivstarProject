package com.example.dell.univstarproject.sign.message;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.dell.univstarproject.R;
import com.example.dell.univstarproject.sign.entry.Team;

import java.util.List;

/**
 * Created by Administrator on 2018/5/10 0010.
 */

class TeamAdapter extends RecyclerView.Adapter<TeamAdapter.Holder> implements View.OnClickListener{
    private List<Team.DataBean.ListBean> listBeans;
    private Context context;

    public TeamAdapter(List<Team.DataBean.ListBean> listBeans, Context context) {
        this.listBeans = listBeans;
        this.context = context;
    }

    @NonNull
    @Override
    public Holder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.message_item,parent,false);
        Holder holder = new Holder(view);
        view.setOnClickListener(this);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull Holder holder, int position) {
        Team.DataBean.ListBean listBean = listBeans.get(position);
        holder.textView.setText(listBean.getContent());
        holder.itemView.setTag(position);
    }

    @Override
    public int getItemCount() {
        return listBeans.size();
    }

    @Override
    public void onClick(View v) {

    }

    public class Holder extends RecyclerView.ViewHolder {
        private TextView textView;
        public Holder(View itemView) {
            super(itemView);
            textView=itemView.findViewById(R.id.message_team);
        }
    }
}
