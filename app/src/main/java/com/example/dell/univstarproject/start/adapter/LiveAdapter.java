package com.example.dell.univstarproject.start.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.dell.univstarproject.R;
import com.example.dell.univstarproject.start.model.bean.LiveBean;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * 作者:天南地北，旺哥最美！
 * 微信:xw15227039901
 */

public class LiveAdapter extends RecyclerView.Adapter<LiveAdapter.ViewHolder>{
    private List<LiveBean.DataBean.ListBean> mList;
    private Context mContext;
    private onclicklistener listener;

    public LiveAdapter(List<LiveBean.DataBean.ListBean> mList, Context mContext) {
        this.mList = mList;
        this.mContext = mContext;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View inflate = LayoutInflater.from(mContext).inflate(R.layout.liveitem, parent, false);
        ViewHolder holder = new ViewHolder(inflate);
        return holder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, final int position) {
        Glide.with(mContext).load(mList.get(position).getCoverImg()).into(holder.live_img);
        holder.live_name.setText(mList.get(position).getNickname());
        holder.live_num.setText(mList.get(position).getSubscribe()+"/"+mList.get(position).getSubscribeNum());
        holder.live_price.setText(mList.get(position).getPrice()+"");
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date date = new Date(mList.get(position).getStartDate());
        holder.class_time.setText("  开课时间："+sdf.format(date));

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

        private final ImageView live_img;
        private final TextView live_name;
        private final TextView live_num;
        private final TextView live_price;
        private final TextView class_time;
        private final Button chongbo_btn;

        public ViewHolder(View itemView) {
            super(itemView);
            live_img = itemView.findViewById(R.id.live_img);
            live_name = itemView.findViewById(R.id.live_name);
            live_num = itemView.findViewById(R.id.live_num);
            live_price = itemView.findViewById(R.id.live_price);
            class_time = itemView.findViewById(R.id.class_time);
            chongbo_btn = itemView.findViewById(R.id.chongbo_btn);
        }

    }
    public interface  onclicklistener {
        void onitemclick(int position);
    }
    public void setonclicklistener (onclicklistener listener ) {
        this.listener=listener;
    }
}
