package com.example.dell.univstarproject.start.adapter;

import android.content.Context;
import android.graphics.Bitmap;
import android.support.v4.graphics.drawable.RoundedBitmapDrawable;
import android.support.v4.graphics.drawable.RoundedBitmapDrawableFactory;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.target.BitmapImageViewTarget;
import com.example.dell.univstarproject.R;
import com.example.dell.univstarproject.start.model.bean.DeailBean;

import java.util.List;

/**
 * 作者:天南地北，旺哥最美！
 * 微信:xw15227039901
 */

public class UserListAdapter extends RecyclerView.Adapter<UserListAdapter.ViewHolder>{
    private List<DeailBean.DataBean.RewardUserListBean> mList;
    private Context mContext;

    public UserListAdapter(List<DeailBean.DataBean.RewardUserListBean> mList, Context mContext) {
        this.mList = mList;
        this.mContext = mContext;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View inflate = LayoutInflater.from(mContext).inflate(R.layout.userlist, parent, false);
        ViewHolder holder = new ViewHolder(inflate);
        return holder;
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {
        Glide.with(mContext).load(mList.get(position).getUserPhoto()).asBitmap().centerCrop().into(new BitmapImageViewTarget(holder.user_list_img) {

            @Override

            protected void setResource(Bitmap resource) {

                RoundedBitmapDrawable circularBitmapDrawable =

                        RoundedBitmapDrawableFactory.create(mContext.getResources(), resource);

                circularBitmapDrawable.setCircular(true);

                holder.user_list_img .setImageDrawable(circularBitmapDrawable);

            }

        });
    }

    @Override
    public int getItemCount() {
        return mList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        private final ImageView user_list_img;

        public ViewHolder(View itemView) {
            super(itemView);
            user_list_img = itemView.findViewById(R.id.user_list_img);
        }
    }
}
