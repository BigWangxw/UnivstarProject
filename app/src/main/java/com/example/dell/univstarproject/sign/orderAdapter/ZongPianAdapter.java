package com.example.dell.univstarproject.sign.orderAdapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.dell.univstarproject.R;
import com.example.dell.univstarproject.sign.entry.Label;

import java.util.List;

/**
 * Created by Administrator on 2018/5/9 0009.
 */

public class ZongPianAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private static final int PIANHAO_ITEM_RECY=0;
    private static final int PIANHAO_ITEM_RECYSCHOOL=1;
    private List<Object> arrayList;
    private Context context;
    private List<Label.DataBean.MajorsBean> majors;
    private List<Label.DataBean.CollegesBean> colleges;

    public ZongPianAdapter(List<Object> arrayList, Context context) {
        this.arrayList = arrayList;
        this.context = context;
    }

    @Override
    public int getItemViewType(int position) {
        if (position == 0) {
            return PIANHAO_ITEM_RECY;
        } else if (position == 1) {
            return PIANHAO_ITEM_RECYSCHOOL;
        }
        return super.getItemViewType(position);
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        final View view=null;
        if (viewType==PIANHAO_ITEM_RECY){
            Label.DataBean dataBean= (Label.DataBean) arrayList.get(PIANHAO_ITEM_RECY);
            majors = dataBean.getMajors();
            PianHaoAdapter homeAdapter = new PianHaoAdapter(majors,context);
            homeAdapter.setOnItemClick(new PianHaoAdapter.OnItemClick() {
                @Override
                public void setOnItemClik(View view, int position) {
                    onclick.wai(view,position);
                }
            });
            return new Zhuanye(Zhuanye(parent,R.layout.pianhao_item_recy,R.id.zhuanye_recycle,homeAdapter));
        }else if (viewType==PIANHAO_ITEM_RECYSCHOOL){
            Label.DataBean lis= (Label.DataBean) arrayList.get(PIANHAO_ITEM_RECY);
            colleges = lis.getColleges();
            SchoolAdapter zhiboAdapter = new SchoolAdapter(colleges,context);
            return new School(School(parent,R.layout.pianhao_item_recyschool,R.id.school_recycle,zhiboAdapter));
        }
        return null;
    }
    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        if (holder instanceof Zhuanye){
            ((Zhuanye) holder).textView.setText("专业");
            holder.itemView.setTag(position);
        }else if (holder instanceof School){

            ((School) holder).textView.setText("院校");
            holder.itemView.setTag(position);
        }
    }

    @Override
    public int getItemCount() {
        return arrayList.size();
    }
    public class Zhuanye extends RecyclerView.ViewHolder{
        private TextView textView;
        public Zhuanye(View itemView) {
            super(itemView);
            textView=itemView.findViewById(R.id.recy_text);
        }
    }
    public class School extends RecyclerView.ViewHolder{

        private TextView textView;
        public School(View itemView) {
            super(itemView);
            textView=itemView.findViewById(R.id.recy_text_school);
        }
    }

    private View Zhuanye(ViewGroup parent, int item, int id, RecyclerView.Adapter adapter){
        View inflate = LayoutInflater.from(parent.getContext()).inflate(item, parent, false);
        RecyclerView recyclerView = inflate.findViewById(id);
        GridLayoutManager gridLayoutManager=new GridLayoutManager(context,3);
        recyclerView.setLayoutManager(gridLayoutManager);
        recyclerView.setAdapter(adapter);
        return inflate;
    }
    private View School(ViewGroup parent, int item, int id, RecyclerView.Adapter adapter){
        View inflate = LayoutInflater.from(parent.getContext()).inflate(item, parent, false);
        RecyclerView recyclerView = inflate.findViewById(id);
        GridLayoutManager gridLayoutManager=new GridLayoutManager(context,2);
        recyclerView.setLayoutManager(gridLayoutManager);
        recyclerView.setAdapter(adapter);
        return inflate;
    }
    public interface Onclick{
        void wai(View view,int psii);
    }
    private Onclick onclick;
    public void setTiaoTama(Onclick onclick){
        this.onclick=onclick;
    }
}
