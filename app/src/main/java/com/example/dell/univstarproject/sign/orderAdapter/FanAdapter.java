package com.example.dell.univstarproject.sign.orderAdapter;

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
import com.example.dell.univstarproject.sign.activity.GlideCircleTransform;
import com.example.dell.univstarproject.sign.entry.Fans;

import java.util.List;

/**
 * Created by Administrator on 2018/5/10 0010.
 */

public class FanAdapter extends RecyclerView.Adapter<FanAdapter.Holder> implements View.OnClickListener{
    private List<Fans.DataBean.ListBean> listBeans;
    private Context context;
    private RequestManager glideRequest;

    public FanAdapter(List<Fans.DataBean.ListBean> listBeans, Context context) {
        this.listBeans = listBeans;
        this.context = context;
    }

    @NonNull
    @Override
    public Holder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.item_fans,parent,false);
        Holder holder = new Holder(view);
        view.setOnClickListener(this);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull Holder holder, int position) {
        Fans.DataBean.ListBean listBean = listBeans.get(position);


        glideRequest = Glide.with(context);
        glideRequest.load(listBean.getPhoto()).transform(new GlideCircleTransform(context)).into(holder.imageView);
        holder.textView.setText(listBean.getNickname());
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
        private TextView textView;
        public Holder(View itemView) {
            super(itemView);
            imageView=itemView.findViewById(R.id.fans_icon);
            textView=itemView.findViewById(R.id.text_hahahah);
        }
    }
}
