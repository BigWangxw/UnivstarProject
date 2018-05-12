package com.example.dell.univstarproject.sign.activity.collect;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.RequestManager;
import com.example.dell.univstarproject.R;
import com.example.dell.univstarproject.sign.entry.Collect_zhibo;

import java.util.List;

/**
 * Created by Administrator on 2018/5/10 0010.
 */

class ZhiboAdapter extends RecyclerView.Adapter<ZhiboAdapter.Holder> implements View.OnClickListener{
    private List<Collect_zhibo.DataBean.ListBean> listBeans;
    private Context context;

    private RequestManager glideRequest;

    public ZhiboAdapter(List<Collect_zhibo.DataBean.ListBean> listBeans, Context context) {
        this.listBeans = listBeans;
        this.context = context;
    }

    @NonNull
    @Override
    public Holder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.collect_zhibo_item,parent,false);
        Holder holder = new Holder(view);
        view.setOnClickListener(this);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull Holder holder, int position) {
        Collect_zhibo.DataBean.ListBean listBean = listBeans.get(position);
        if (listBean.getCoverImg()!=null) {
            Glide.with(context).load(listBean.getCoverImg()).into(holder.imageView);
        }
        holder.name.setText(listBean.getNickname());
        holder.isSub.setText(listBean.getIsSubscribe()+"");
        holder.num.setText("/"+listBean.getSubscribeNum()+"");
        holder.piece.setText("￥"+listBean.getPrice()+"");
        holder.itemView.setTag(position);
    }
    @Override
    public int getItemCount() {
        return listBeans.size();
    }

    @Override
    public void onClick(View v) {

    }

    public class Holder extends RecyclerView.ViewHolder {
        private ImageView imageView;
        private TextView name,isSub,num,piece;
        public Holder(View itemView) {
            super(itemView);
            imageView=itemView.findViewById(R.id.zhibo_image);
            name=itemView.findViewById(R.id.zhibo_teacher);
            isSub=itemView.findViewById(R.id.zhibo_isSub);
            piece=itemView.findViewById(R.id.zhibo_piece);
            num=itemView.findViewById(R.id.zhibo_num);
        }
    }
}
