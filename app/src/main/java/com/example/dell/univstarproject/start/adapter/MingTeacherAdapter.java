package com.example.dell.univstarproject.start.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.dell.univstarproject.R;
import com.example.dell.univstarproject.start.model.bean.MingTeacher;

import java.util.ArrayList;

/**
 * 作者:天南地北，旺哥最美！
 * 微信:xw15227039901
 */

public class MingTeacherAdapter extends RecyclerView.Adapter<MingTeacherAdapter.ViewHolder>{
    private ArrayList<MingTeacher.DataBean.ListBean> mList;
    private Context mContext;
    private onclicklosyener listrener;

    public MingTeacherAdapter(ArrayList<MingTeacher.DataBean.ListBean> mList, Context mContext) {
        this.mList = mList;
        this.mContext = mContext;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View inflate = LayoutInflater.from(mContext).inflate(R.layout.mingitem, parent, false);
        ViewHolder holder = new ViewHolder(inflate);
        return holder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, final int position) {
        Glide.with(mContext).load(mList.get(position).getPhoto()).into(holder.ming_img);
        holder.mingname.setText(mList.get(position).getNickname());
        holder.ming_type.setText(mList.get(position).getIntro());
        if (mList.get(position).getUserType()==4) {

            holder.ming_biaozhi.setImageResource(R.mipmap.home_level_vip_red);

        } else if (mList.get(position).getUserType()==3){

            holder.ming_biaozhi.setImageResource(R.mipmap.home_level_vip_yellow);

        } else if (mList.get(position).getUserType()==2) {

            holder.ming_biaozhi.setImageResource(R.mipmap.home_level_vip_blue);

        }
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                listrener.onitemclick(position);
            }
        });
    }

    @Override
    public int getItemCount() {

        return mList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        private final ImageView ming_img;
        private final ImageView ming_biaozhi;
        private final TextView mingname;
        private final TextView ming_type;

        public ViewHolder(View itemView) {
            super(itemView);
            ming_img = itemView.findViewById(R.id.ming_img);
            ming_biaozhi = itemView.findViewById(R.id.ming_biaozhi);
            mingname = itemView.findViewById(R.id.mingname);
            ming_type = itemView.findViewById(R.id.ming_type);
        }
    }
    public interface  onclicklosyener {
        void onitemclick(int position);
    }
    public void setonclicklistener (onclicklosyener listrener) {
        this.listrener=listrener;
    }
}
