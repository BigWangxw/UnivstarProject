package com.example.dell.univstarproject.sign.activity.collect;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.dell.univstarproject.R;
import com.example.dell.univstarproject.sign.DateUtils;
import com.example.dell.univstarproject.sign.entry.TIyan;
import com.squareup.picasso.Picasso;

import java.util.List;

/**
 * Created by Administrator on 2018/5/11 0011.
 */

class TIyanAdapter extends RecyclerView.Adapter<TIyanAdapter.Holder> implements View.OnClickListener{
    private List<TIyan.DataBean.ListBean> listBeans;
    private Context context;

    public TIyanAdapter(List<TIyan.DataBean.ListBean> listBeans, Context context) {
        this.listBeans = listBeans;
        this.context = context;
    }

    @NonNull
    @Override
    public Holder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.tiyan_item,parent,false);
        Holder holder = new Holder(view);
        view.setOnClickListener(this);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull Holder holder, int position) {
        TIyan.DataBean.ListBean listBean = listBeans.get(position);
        Picasso.with(context).load(listBean.getCoverImg()).into(holder.imageView);
        holder.issum.setText(listBean.getReservationNum()+"");
        holder.piece.setText(listBean.getPrice()+"");
        holder.Sum.setText(listBean.getSubscribeNum()+"");
        holder.dizhi.setText(listBean.getAddress());
        String dateToString = DateUtils.getDateToString(listBean.getEndDate());
        holder.date.setText(dateToString);
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
        private TextView dizhi,issum,Sum,piece,date;
        public Holder(View itemView) {
            super(itemView);
            imageView=itemView.findViewById(R.id.tiyan_image);
            dizhi=itemView.findViewById(R.id.tiyan_dizhi);
            issum=itemView.findViewById(R.id.tiyan_issum);
            Sum=itemView.findViewById(R.id.tiyan_sum);
            piece=itemView.findViewById(R.id.tiyan_piece);
            date=itemView.findViewById(R.id.tiyan_date);
        }
    }
}
