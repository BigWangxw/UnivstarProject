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
import com.example.dell.univstarproject.start.model.bean.ControllerBean;

import java.util.List;

/**
 * 作者:天南地北，旺哥最美！
 * 微信:xw15227039901
 */

public class HomeWorkDeailAdapter extends RecyclerView.Adapter<HomeWorkDeailAdapter.ViewHolder>{

    private List<ControllerBean.DataBean.GiftListBean> mList;
    private Context mContext;
    private onclicklistener listener;

    public HomeWorkDeailAdapter(List<ControllerBean.DataBean.GiftListBean> mList, Context mContext) {
        this.mList = mList;
        this.mContext = mContext;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View inflate = LayoutInflater.from(mContext).inflate(R.layout.homeworkdeailitem, parent, false);
        ViewHolder holder = new ViewHolder(inflate);
        return holder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, final int position) {
        Glide.with(mContext).load(mList.get(position).getImg()).into(holder.deail_img);
        holder.deail_name.setText(mList.get(position).getName());
        holder.deail_price.setText(mList.get(position).getAmount()+"");

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

        private final ImageView deail_img;
        private final TextView deail_name;
        private final TextView deail_price;

        public ViewHolder(View itemView) {
            super(itemView);
            deail_img = itemView.findViewById(R.id.deail_img);
            deail_name = itemView.findViewById(R.id.deail_name);
            deail_price = itemView.findViewById(R.id.deail_price);
        }
    }
    public interface onclicklistener {
        void onitemclick(int position);
    }
    public void setonclicklistener (onclicklistener listener) {
        this.listener=listener;
    }
}
