package com.example.dell.univstarproject.adapter;

import android.content.Context;
import android.graphics.Bitmap;
import android.support.v4.graphics.drawable.RoundedBitmapDrawable;
import android.support.v4.graphics.drawable.RoundedBitmapDrawableFactory;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.target.BitmapImageViewTarget;
import com.example.dell.univstarproject.R;
import com.example.dell.univstarproject.model.bean.BabyBean;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * 作者:天南地北，旺哥最美！
 * 微信:xw15227039901
 */

public class MoreAllAdapter extends RecyclerView.Adapter<MoreAllAdapter.ViewHolder>{

    private ArrayList<BabyBean.DataBean.ArtcircleListBean.ListBean> mListBeans ;
    private Context mContext;

    public MoreAllAdapter(ArrayList<BabyBean.DataBean.ArtcircleListBean.ListBean> mListBeans, Context mContext) {
        this.mListBeans = mListBeans;
        this.mContext = mContext;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View inflate = LayoutInflater.from(mContext).inflate(R.layout.babyitem, parent, false);
        ViewHolder holder = new ViewHolder(inflate);
        return holder;
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {
        Glide.with(mContext).load(mListBeans.get(position).getPhoto()).asBitmap().centerCrop().into(new BitmapImageViewTarget(((ViewHolder) holder).baby_img) {

            @Override

            protected void setResource(Bitmap resource) {

                RoundedBitmapDrawable circularBitmapDrawable =

                        RoundedBitmapDrawableFactory.create(mContext.getResources(), resource);

                circularBitmapDrawable.setCircular(true);

                holder.baby_img .setImageDrawable(circularBitmapDrawable);

            }

        });

        SimpleDateFormat sdf = new SimpleDateFormat("MM/dd");
        Date date = new Date(mListBeans.get(position).getCreateDate());
        holder.baby_date.setText(sdf.format(date));
        Glide.with(mContext).load(mListBeans.get(position).getCoverImg()).into(holder.baby_music);
        holder.baby_type.setText(mListBeans.get(position).getWorksType());
        holder.content.setText(mListBeans.get(position).getTitle());
        holder.content_speak.setText(mListBeans.get(position).getContent());
        holder.baby_name.setText(mListBeans.get(position).getNickname());
    }

    @Override
    public int getItemCount() {
        return mListBeans.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        private final ImageView baby_img;
        private final TextView baby_name;
        private final TextView baby_date;
        private final TextView content;
        private final TextView content_speak;
        private final ImageView baby_music;
        private final TextView baby_type;
        private final RadioButton start;
        private final RadioButton ping;
        private final RadioButton zan;
        private final RadioButton fenxiang;

        public ViewHolder(View itemView) {
            super(itemView);
            baby_img = itemView.findViewById(R.id.baby_img);
            baby_name = itemView.findViewById(R.id.baby_name);
            baby_date = itemView.findViewById(R.id.baby_date);
            content = itemView.findViewById(R.id.content);
            content_speak = itemView.findViewById(R.id.content_speak);
            baby_music = itemView.findViewById(R.id.baby_music);
            baby_type = itemView.findViewById(R.id.baby_type);
            start = itemView.findViewById(R.id.start);
            ping = itemView.findViewById(R.id.ping);
            zan = itemView.findViewById(R.id.zan);
            fenxiang = itemView.findViewById(R.id.fenxiang);
        }
    }
}
