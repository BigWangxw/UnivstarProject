package com.example.dell.univstarproject.start.adapter;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.support.v4.graphics.drawable.RoundedBitmapDrawable;
import android.support.v4.graphics.drawable.RoundedBitmapDrawableFactory;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.target.BitmapImageViewTarget;
import com.example.dell.univstarproject.R;
import com.example.dell.univstarproject.start.model.bean.DeailBean;
import com.example.dell.univstarproject.start.model.bean.TimeUtil;
import com.example.dell.univstarproject.start.presenter.HomeWorkDeailPresenter;
import com.example.dell.univstarproject.view.activity.HomeWorkDeailActivity;
import com.example.dell.univstarproject.view.activity.PingActivity;

import java.util.Date;
import java.util.List;

/**
 * 作者:天南地北，旺哥最美！
 * 微信:xw15227039901
 */

public class CommentAdapter extends RecyclerView.Adapter<CommentAdapter.ViewHolder>{
    private List<DeailBean.DataBean.CommentsBean.ListBean> mList;
    private Context mContext;
    private HomeWorkDeailPresenter presenter;
    public CommentAdapter(HomeWorkDeailPresenter presenter,List<DeailBean.DataBean.CommentsBean.ListBean> mList, Context mContext) {
        this.mList = mList;
        this.mContext = mContext;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View inflate = LayoutInflater.from(mContext).inflate(R.layout.comments, parent, false);
        ViewHolder holder = new ViewHolder(inflate);
        return holder;
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, final int position) {

        Date date = new Date(mList.get(position).getCreateDate());
        holder.com_time.setText(TimeUtil.getTimeFormatText(date));

        holder.com_hui.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mContext.startActivity(new Intent(mContext, PingActivity.class));
            }
        });
        holder.com_name.setText(mList.get(position).getNickname());
      //  holder.com_num.setText(mList.get(position).getPraiseNum());
        presenter = new HomeWorkDeailPresenter((HomeWorkDeailActivity)mContext);

        if (mList.get(position).getIsPraise() == 0) {
            holder.com_num.setChecked(false);
        }else {
            holder.com_num.setText(mList.get(position).getPraiseNum() + "");
            //zan_check.setChecked(true);

        }
       holder.com_num.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
           @Override
           public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
              /* if (TextUtils.isEmpty(BaseApp.activity.getSharedPreferences("111",Context.MODE_PRIVATE).getString("xyxy_user_id",""))) {
                   //
                   Toast.makeText(mContext, "您尚未登陆", Toast.LENGTH_SHORT).show();
               }*/
               if (isChecked) {

                       presenter.dianzandata(mList.get(position).getId()+"");
                      holder.com_num.setText(mList.get(position).getPraiseNum()+1+"");

               } else {

                       presenter.quxiao(mList.get(position).getId() + "");
                      holder.com_num.setText(mList.get(position).getPraiseNum() + "");

               }
           }
       });
        if (mList.get(position).getReplyNum() !=0) {
            holder.com_hui_num.setText("共"+mList.get(position).getReplyNum()+"条回复");
        } else {
           holder.com_hui_num.setText("");
        }
        if (!"".equals(mList.get(position).getContent())) {
            holder.com_cont.setText(mList.get(position).getContent());
        } else {
            holder.com_cont.setText("");
        }

        Glide.with(mContext).load(mList.get(position).getPhoto()).asBitmap().centerCrop().into(new BitmapImageViewTarget(holder.com_img) {

            @Override

            protected void setResource(Bitmap resource) {

                RoundedBitmapDrawable circularBitmapDrawable =

                        RoundedBitmapDrawableFactory.create(mContext.getResources(), resource);

                circularBitmapDrawable.setCircular(true);

                holder.com_img .setImageDrawable(circularBitmapDrawable);

            }

        });
    }

    @Override
    public int getItemCount() {
        return mList.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {

        private final TextView com_name;
        private final TextView com_cont;
        private final TextView com_hui;
        private final CheckBox com_num;
        private final ImageView com_img;
        private final TextView com_time;
        private final TextView com_hui_num;

        public ViewHolder(View itemView) {
            super(itemView);
            com_name = itemView.findViewById(R.id.com_name);
            com_cont = itemView.findViewById(R.id.com_cont);
            com_hui = itemView.findViewById(R.id.com_hui);
            com_num = itemView.findViewById(R.id.com_num);
            com_img = itemView.findViewById(R.id.com_img);
            com_time = itemView.findViewById(R.id.com_time);
            com_hui_num = itemView.findViewById(R.id.com_hui_num);
        }
    }
}
