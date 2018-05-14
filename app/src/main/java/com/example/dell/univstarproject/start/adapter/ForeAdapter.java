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
import com.example.dell.univstarproject.start.model.bean.ForeBean;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

/**
 * 作者:天南地北，旺哥最美！
 * 微信:xw15227039901
 */

public class ForeAdapter extends RecyclerView.Adapter<ForeAdapter.ViewHolder>{
    private ArrayList<ForeBean.DataBean.ListBean> mList;
    private Context mContext;

    public ForeAdapter(ArrayList<ForeBean.DataBean.ListBean> mList, Context mContext) {
        this.mList = mList;
        this.mContext = mContext;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View inflate = LayoutInflater.from(mContext).inflate(R.layout.foreitem, parent, false);
        ViewHolder holder = new ViewHolder(inflate);
        return holder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Glide.with(mContext).load(mList.get(position).getCoverImg()).into(holder.fore_img);
        holder.address.setText(mList.get(position).getAddress());
        if (position == 0) {

        } else if (position == 1) {
            int yellow = R.drawable.yellow;
            holder.music_tv.setText("表演");
            holder.music_tv.setBackgroundResource(yellow);
        }
        holder.num.setText(mList.get(position).getReservationNum()+"/"+mList.get(position).getSubscribeNum());
        holder.price.setText(mList.get(position).getPrice()+".0");
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date date = new Date(mList.get(position).getStartDate());
        holder.play_class.setText("  "+sdf.format(date));
    }

    @Override
    public int getItemCount() {
        return mList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        private final ImageView fore_img;
        private final TextView music_tv;
        private final TextView play_class;
        private final TextView address;
        private final TextView num;
        private final TextView price;

        public ViewHolder(View itemView) {
            super(itemView);
            fore_img = itemView.findViewById(R.id.fore_img);
            music_tv = itemView.findViewById(R.id.music_tv);
            play_class = itemView.findViewById(R.id.play_class);
            address = itemView.findViewById(R.id.address);
            num = itemView.findViewById(R.id.num);
            price = itemView.findViewById(R.id.price);
        }
    }
}
