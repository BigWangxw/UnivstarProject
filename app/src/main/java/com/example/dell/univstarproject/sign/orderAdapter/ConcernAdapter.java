package com.example.dell.univstarproject.sign.orderAdapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.RequestManager;
import com.example.dell.univstarproject.R;
import com.example.dell.univstarproject.sign.activity.GlideCircleTransform;
import com.example.dell.univstarproject.sign.entry.GuanZhu;

import java.util.ArrayList;

/**
 * Created by Administrator on 2018/5/9 0009.
 */

public class ConcernAdapter extends RecyclerView.Adapter<ConcernAdapter.Holder>{
    private RequestManager glideRequest;
    private ArrayList<GuanZhu.DataBean.ListBean> arrayList;
    private Context context;

    public ConcernAdapter(ArrayList<GuanZhu.DataBean.ListBean> arrayList, Context context) {
        this.arrayList = arrayList;
        this.context = context;
    }

    @NonNull
    @Override
    public Holder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.concern_item,parent,false);
        Holder holder = new Holder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull Holder holder, int position) {
        GuanZhu.DataBean.ListBean listBean = arrayList.get(position);
        holder.textView.setText(listBean.getNickname()+"关注了你");
        glideRequest = Glide.with(context);
        glideRequest.load(listBean.getPhoto()).transform(new GlideCircleTransform(context)).into(holder.imageButton);
        holder.itemView.setTag(position);
    }

    @Override
    public int getItemCount() {
        return arrayList.size();
    }

    public class Holder extends RecyclerView.ViewHolder {
        private TextView textView;
        private ImageButton imageButton;
        public Holder(View itemView) {
            super(itemView);
            textView=itemView.findViewById(R.id.concern_text);
            imageButton=itemView.findViewById(R.id.concern_icon);
        }
    }
}
