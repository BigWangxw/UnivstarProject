package com.example.dell.univstarproject.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.dell.univstarproject.R;
import com.example.dell.univstarproject.model.bean.FirstBean;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

/**
 * 作者:天南地北，旺哥最美！
 * 微信:xw15227039901
 */

public class ClassAdapter extends RecyclerView.Adapter<ClassAdapter.ViewHolder>{
    private ArrayList<FirstBean.DataBean.LiveCoursesBean> mList;
    private Context mContext;
    private onclicklistener listener;

    public ClassAdapter(ArrayList<FirstBean.DataBean.LiveCoursesBean> mList, Context mContext) {
        this.mList = mList;
        this.mContext = mContext;
    }

    @Override
    public ClassAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View inflate = LayoutInflater.from(mContext).inflate(R.layout.classitem, parent, false);
        ViewHolder holder = new ViewHolder(inflate);
        return holder;
    }

    @Override
    public void onBindViewHolder(ClassAdapter.ViewHolder holder, final int position) {
        holder.teacher_name.setText(mList.get(position).getNickname());
        Glide.with(mContext).load(mList.get(position).getCoverImg()).into(holder.teacher_img);
        SimpleDateFormat sdf = new SimpleDateFormat("MM-dd HH:mm:ss");
        Date date = new Date(mList.get(position).getStartDate());
        holder.play_time.setText("讲堂开播:"+date);
        if (!"李苒苒".equals(mList.get(position).getNickname())) {
            holder.vip_bz.setImageResource(R.mipmap.home_level_vip_yellow);
        } else {
            holder.vip_bz.setImageResource(R.mipmap.home_level_vip_red);
        }
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                listener.onitemclicklistener(position);
            }
        });
    }

    @Override
    public int getItemCount() {
        return mList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        private final ImageView teacher_img;
        private final ImageView vip_bz;
        private final TextView teacher_name;
        private final TextView play_time;

        public ViewHolder(View itemView) {
            super(itemView);
            teacher_img = itemView.findViewById(R.id.teacher_img);
            vip_bz = itemView.findViewById(R.id.vip_bz);
            teacher_name = itemView.findViewById(R.id.teacher_name);
            play_time = itemView.findViewById(R.id.play_time);
        }
    }
    public interface onclicklistener {
        void onitemclicklistener (int position);
    }
    public void setonclicklistener (onclicklistener listener) {
        this.listener = listener;
    }
}
