package com.example.dell.univstarproject.adapter;

import android.content.Context;
import android.graphics.Bitmap;
import android.support.v4.graphics.drawable.RoundedBitmapDrawable;
import android.support.v4.graphics.drawable.RoundedBitmapDrawableFactory;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.target.BitmapImageViewTarget;
import com.example.dell.univstarproject.R;
import com.example.dell.univstarproject.model.bean.FirstBean;
import com.example.dell.univstarproject.model.bean.NewstBean;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * 作者:天南地北，旺哥最美！
 * 微信:xw15227039901
 */

public class HomeWorkAdapter extends RecyclerView.Adapter<HomeWorkAdapter.Holder>{
    List<FirstBean.DataBean.HomewoksBean> mList;
    private Context mContext;
    private onclciklistener listener;

    public HomeWorkAdapter(List<FirstBean.DataBean.HomewoksBean> mList, Context mContext) {
        this.mList = mList;
        this.mContext = mContext;
    }

    @Override
    public HomeWorkAdapter.Holder onCreateViewHolder(ViewGroup parent, int viewType) {
        View inflate = LayoutInflater.from(mContext).inflate(R.layout.demo, parent, false);
        HomeWorkAdapter.Holder holder =  new HomeWorkAdapter.Holder(inflate);
        return holder;
    }

    @Override
    public void onBindViewHolder(final HomeWorkAdapter.Holder holder, final int position) {

        String tRealname = (String) mList.get(position).getTRealname();
        if (!TextUtils.isEmpty(tRealname)) {
            ((HomeWorkAdapter.Holder)holder).linear.setVisibility(View.VISIBLE);
            Glide.with(mContext).load(mList.get(position).getTPhoto()).into(((HomeWorkAdapter.Holder) holder).tptho_img);;
            ((HomeWorkAdapter.Holder) holder).reaname.setText((String)mList.get(position).getTRealname());
            holder.tintrf.setVisibility(View.VISIBLE);
            ((HomeWorkAdapter.Holder) holder).tintrf.setText((String)mList.get(position).getTIntro());

            Glide.with(mContext).load(mList.get(position).getPhoto()).into(((HomeWorkAdapter.Holder) holder).phto_img);
            ((HomeWorkAdapter.Holder) holder).nick_name.setText(mList.get(position).getNickname());
            SimpleDateFormat sdf = new SimpleDateFormat("MM/dd");
            Date date = new Date(mList.get(position).getCreateDate());
            holder.create_date.setText(sdf.format(date));
            ((HomeWorkAdapter.Holder) holder).source.setText("来自"+mList.get(position).getSource());
            ((HomeWorkAdapter.Holder) holder).content.setText(mList.get(position).getContent());
            Glide.with(mContext).load(mList.get(position).getCoverImg()).into(((HomeWorkAdapter.Holder) holder).play_music);
            ((HomeWorkAdapter.Holder) holder).work_type.setText(mList.get(position).getWorksType());
            holder.tou_btn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Toast.makeText(mContext, "支付功能暂未完善", Toast.LENGTH_SHORT).show();
                }
            });
        } else {
            ((HomeWorkAdapter.Holder)holder).linear.setVisibility(View.GONE);
            Glide.with(mContext).load(mList.get(position).getPhoto()).into(((HomeWorkAdapter.Holder) holder).phto_img);
            ((HomeWorkAdapter.Holder) holder).nick_name.setText(mList.get(position).getNickname());
            SimpleDateFormat sdf = new SimpleDateFormat("MM/dd");
            Date date = new Date(mList.get(position).getCreateDate());
            holder.create_date.setText(sdf.format(date));
            ((HomeWorkAdapter.Holder) holder).source.setText("来自"+mList.get(position).getSource());
            ((HomeWorkAdapter.Holder) holder).content.setText(mList.get(position).getContent());
            Glide.with(mContext).load(mList.get(position).getCoverImg()).into(((HomeWorkAdapter.Holder) holder).play_music);
            ((HomeWorkAdapter.Holder) holder).work_type.setText(mList.get(position).getWorksType());


        }

        //加載原型圖片

        Glide.with(mContext).load(mList.get(position).getPhoto()).asBitmap().centerCrop().into(new BitmapImageViewTarget(((HomeWorkAdapter.Holder) holder).phto_img) {

            @Override

            protected void setResource(Bitmap resource) {

                RoundedBitmapDrawable circularBitmapDrawable =

                        RoundedBitmapDrawableFactory.create(mContext.getResources(), resource);

                circularBitmapDrawable.setCircular(true);

                holder.phto_img .setImageDrawable(circularBitmapDrawable);

            }

        });
        Glide.with(mContext).load(mList.get(position).getTPhoto()).asBitmap().centerCrop().into(new BitmapImageViewTarget(((HomeWorkAdapter.Holder) holder).tptho_img) {

            @Override

            protected void setResource(Bitmap resource) {

                RoundedBitmapDrawable circularBitmapDrawable =

                        RoundedBitmapDrawableFactory.create(mContext.getResources(), resource);

                circularBitmapDrawable.setCircular(true);

                holder.tptho_img.setImageDrawable(circularBitmapDrawable);


            }

        });
        ((Holder) holder).itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                listener.onitemclick(position);
            }
        });
    }

    @Override
    public int getItemCount() {
        return mList.isEmpty()?0:mList.size();
    }

    public class Holder extends RecyclerView.ViewHolder {
        private ImageView phto_img;
        private TextView nick_name;
        private  TextView create_date;
        private  TextView source;
        private ImageView play_music;
        private TextView work_type;
        private  ImageView tptho_img;
        private  TextView reaname;
        private  TextView tintrf;
        private LinearLayout linear;
        private  TextView content;
        private final Button tou_btn;

        public Holder(View itemView) {
            super(itemView);
            //用户头像
            phto_img = itemView.findViewById(R.id.phto_img);
            //用户昵称
            nick_name = itemView.findViewById(R.id.nick_name);
            //发布时间
            create_date = itemView.findViewById(R.id.create_date);
            //来自哪里
            source = itemView.findViewById(R.id.source);
            //作品图片
            play_music = itemView.findViewById(R.id.play_music);
            //作品简介
            content = itemView.findViewById(R.id.content);
            //作品类型
            work_type = itemView.findViewById(R.id.work_type);
            //评论人头像
            tptho_img = itemView.findViewById(R.id.tptho_img);
            //评论人昵称
            reaname = itemView.findViewById(R.id.reaname);
            //评论内容
            tintrf = itemView.findViewById(R.id.tintrf);

            linear = itemView.findViewById(R.id.linear);

            tou_btn = itemView.findViewById(R.id.tou_btn);
        }
    }
    public interface onclciklistener {
        void onitemclick(int position);
    }
    public void setonclicklistener (onclciklistener listener) {
        this.listener = listener;
    }
}
