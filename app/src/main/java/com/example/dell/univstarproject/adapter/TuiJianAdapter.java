package com.example.dell.univstarproject.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.dell.univstarproject.R;
import com.example.dell.univstarproject.model.bean.FirstBean;
import com.example.dell.univstarproject.view.activity.TeacherFirstActivity;

import java.util.ArrayList;
import java.util.List;

/**
 * 作者:天南地北，旺哥最美！
 * 微信:xw15227039901
 */

public class TuiJianAdapter extends RecyclerView.Adapter<TuiJianAdapter.ViewHolder>{
    private List<FirstBean.DataBean.UsersBean> mList;
    private Context mContext;
    private onclicklistener listener;

    public TuiJianAdapter(List<FirstBean.DataBean.UsersBean> mList, Context mContext) {
        this.mList = mList;
        this.mContext = mContext;
    }

    @Override
    public TuiJianAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View inflate = LayoutInflater.from(mContext).inflate(R.layout.tuijianitem, parent, false);
        ViewHolder holder = new ViewHolder(inflate);
        return holder;
    }

    @Override
    public void onBindViewHolder(TuiJianAdapter.ViewHolder holder, final int position) {
        Glide.with(mContext).load(mList.get(position).getImages()).into(holder.user_img);
        holder.user_name.setText(mList.get(position).getNickname());
        holder.user_speak.setText(mList.get(position).getIntro());
        if (!"李苒苒".equals(mList.get(position).getNickname())) {
           holder.vip_bianzhi.setImageResource(R.mipmap.home_level_vip_yellow);
        } else {
            holder.vip_bianzhi.setImageResource(R.mipmap.home_level_vip_red);
        }
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
              listener.onitemclick(position);
            }
        });
    }

    @Override
    public int getItemCount() {
        return mList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        private final ImageView user_img;
        private final TextView user_name;
        private final TextView user_speak;
        private final ImageView vip_bianzhi;

        public ViewHolder(View itemView) {
            super(itemView);
            user_img = itemView.findViewById(R.id.user_img);
            user_name = itemView.findViewById(R.id.user_name);
            user_speak = itemView.findViewById(R.id.user_speak);
            vip_bianzhi = itemView.findViewById(R.id.vip_bianzhi);
        }
    }
    public interface onclicklistener {
        void onitemclick(int position);
    }
    public void setonclicklistener (onclicklistener listener) {
        this.listener=listener;
    }
}
