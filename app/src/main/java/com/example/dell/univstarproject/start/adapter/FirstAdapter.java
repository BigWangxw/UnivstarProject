package com.example.dell.univstarproject.start.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.dell.univstarproject.R;
import com.example.dell.univstarproject.base.BaseApp;
import com.example.dell.univstarproject.start.model.bean.FirstBean;
import com.example.dell.univstarproject.start.model.bean.PisicImage;
import com.example.dell.univstarproject.view.activity.FurActivity;
import com.example.dell.univstarproject.view.activity.HomeWorkDeailActivity;
import com.example.dell.univstarproject.view.activity.LiveActivity;
import com.example.dell.univstarproject.view.activity.MainActivity;
import com.example.dell.univstarproject.view.activity.MingTeacherActivity;
import com.example.dell.univstarproject.view.activity.SeeActivity;
import com.example.dell.univstarproject.view.activity.TeacherFirstActivity;
import com.example.dell.univstarproject.view.fragment.BabyFragment;
import com.example.dell.univstarproject.view.fragment.DemoFragment;
import com.example.dell.univstarproject.view.fragment.ForeShowFragment;
import com.youth.banner.Banner;
import com.youth.banner.BannerConfig;
import com.youth.banner.listener.OnBannerListener;

import java.util.ArrayList;
import java.util.List;

/**
 * 作者:天南地北，旺哥最美！
 * 微信:xw15227039901
 */

public class FirstAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder>{
    private static final int BIGIMG = 0;
    private static final int TEATUIJIAN = 1;
    private static final int CLASSTUIJIAN = 2;
    private static final int DEMO = 3;
    FirstBean.DataBean dataBean;
    private Context mContext;
    private onclicklistener listener;

    public FirstAdapter(FirstBean.DataBean dataBean, Context mContext) {
        this.dataBean = dataBean;
        this.mContext = mContext;
    }

    @Override
    public int getItemViewType(int position) {
        if (position == 0) {
            return BIGIMG;
        } else if (position == 1) {
            return TEATUIJIAN;
        } else if (position == 2) {
            return CLASSTUIJIAN;
        } else if (position == 3) {
            return DEMO;
        }
        return super.getItemViewType(position);
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        RecyclerView.ViewHolder holder = null;
        if (viewType == BIGIMG) {
            View bigimg = LayoutInflater.from(mContext).inflate(R.layout.bigimg, parent, false);
            holder = new FirstViewHolder(bigimg);
        } else if (viewType == TEATUIJIAN) {
            View tuijian = LayoutInflater.from(mContext).inflate(R.layout.tuijian, parent, false);
            holder = new OtherViewHolder(tuijian);
        } else if (viewType == CLASSTUIJIAN) {
            View classtuijian = LayoutInflater.from(mContext).inflate(R.layout.classtuijian, parent, false);
            holder = new ThreeViewHolder(classtuijian);
        } else if (viewType == DEMO) {
            View demo = LayoutInflater.from(mContext).inflate(R.layout.demotest, parent, false);
            holder = new FurViewHolder(demo);
        }
        return holder;
    }

    @Override
    public void onBindViewHolder(final RecyclerView.ViewHolder holder, final int position) {
        final List<FirstBean.DataBean.SystemAdsBean> bigimgList = dataBean.getSystemAds();
        ArrayList<String> arrayList = new ArrayList<>();
        if (holder instanceof FirstViewHolder) {
            bigimgList.get(position).getMobileImgUrl();
            for (int i = 0; i < bigimgList.size(); i++) {
                arrayList.add(bigimgList.get(i).getMobileImgUrl());
            }
            ((FirstViewHolder) holder).banner.setImages(arrayList)
                    .setDelayTime(2000)
                    .setBannerStyle(BannerConfig.NUM_INDICATOR)
                    .setImageLoader(new PisicImage())
                    .setIndicatorGravity(BannerConfig.CENTER)
                    .start();
            ((FirstViewHolder) holder).banner.setOnBannerListener(new OnBannerListener() {
                @Override
                public void OnBannerClick(int position) {
                   if (bigimgList.get(position).getUrlType().equals("3")) {
                       Intent intent = new Intent(mContext,SeeActivity.class);
                       String mobileUrl = bigimgList.get(position).getMobileUrl();
                       intent.putExtra("id",mobileUrl);
                       mContext.startActivity(intent);
                   } else  {
                       Intent intent = new Intent(mContext,FurActivity.class);
                       String mobileUrl = bigimgList.get(position).getMobileUrl();
                       intent.putExtra("bean",dataBean);
                       intent.putExtra("id1",mobileUrl);
                       mContext.startActivity(intent);
                   }

                }
            });
            ((FirstViewHolder) holder).zhao_tea.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    mContext.startActivity(new Intent(BaseApp.activity,MingTeacherActivity.class));
                }
            });
            ((FirstViewHolder) holder).xian_class.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    mContext.startActivity(new Intent(mContext,LiveActivity.class));
                }
            });
            ((FirstViewHolder) holder).comm_tea.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    MainActivity.demo_btn.setChecked(true);
                   BaseApp.activity.AddFragment(R.id.fg,DemoFragment.class,null);
                }
            });
            ((FirstViewHolder) holder).liao_tea.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    MainActivity.baby_btn.setChecked(true);
                    BaseApp.activity.AddFragment(R.id.fg,BabyFragment.class,null);
                }
            });
            ((FirstViewHolder) holder).xia_class.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    MainActivity.foreshow_btn.setChecked(true);
                    BaseApp.activity.AddFragment(R.id.fg,ForeShowFragment.class,null);

                }
            });
        } else if (holder instanceof OtherViewHolder) {
            final List<FirstBean.DataBean.UsersBean> list = dataBean.getUsers();
            TuiJianAdapter adapter = new TuiJianAdapter(list,mContext);
            LinearLayoutManager manager = new LinearLayoutManager(mContext,LinearLayoutManager.HORIZONTAL,false);
            ((OtherViewHolder) holder).tuijian_recycle.setLayoutManager(manager);
            ((OtherViewHolder) holder).tuijian_recycle.setAdapter(adapter);
            adapter.setonclicklistener(new TuiJianAdapter.onclicklistener() {
                @Override
                public void onitemclick(int position) {
                    Intent intent = new Intent(mContext, TeacherFirstActivity.class);
                    intent.putExtra("teaId",list.get(position).getId());
                    mContext.startActivity(intent);
                }
            });
        } else if (holder instanceof ThreeViewHolder) {
            final List<FirstBean.DataBean.LiveCoursesBean> liveCourses = dataBean.getLiveCourses();
            ClassAdapter adapter = new ClassAdapter((ArrayList<FirstBean.DataBean.LiveCoursesBean>) liveCourses,mContext);
            StaggeredGridLayoutManager manager = new StaggeredGridLayoutManager(2,StaggeredGridLayoutManager.VERTICAL);
            ((ThreeViewHolder) holder).class_recycle.setLayoutManager(manager);
            ((ThreeViewHolder) holder).class_recycle.setAdapter(adapter);
            adapter.setonclicklistener(new ClassAdapter.onclicklistener() {
                @Override
                public void onitemclicklistener(int position) {
                  Intent intent = new Intent(mContext,FurActivity.class);
                  intent.putExtra("id1",liveCourses.get(position).getId()+"");
                  mContext.startActivity(intent);
                }
            });
        } else if (holder instanceof FurViewHolder) {
            final List<FirstBean.DataBean.HomewoksBean> homewoks = dataBean.getHomewoks();
            HomeWorkAdapter adapter = new HomeWorkAdapter(homewoks,mContext);
            LinearLayoutManager manager = new LinearLayoutManager(mContext,LinearLayoutManager.VERTICAL,false);
            ((FurViewHolder) holder).fur_recycle.setLayoutManager(manager);
            ((FurViewHolder) holder).fur_recycle.setAdapter(adapter);
            adapter.setonclicklistener(new HomeWorkAdapter.onclciklistener() {
                @Override
                public void onitemclick(int position) {
                    Intent intent = new Intent(mContext,HomeWorkDeailActivity.class);
                    intent.putExtra("deail",homewoks.get(position).getId());
                    mContext.startActivity(intent);
                }
            });
        }
    }

    @Override
    public int getItemCount() {
        return 4;
    }
    public class FirstViewHolder extends RecyclerView.ViewHolder{

        private final Banner banner;
        private final TextView zhao_tea;
        private final TextView xian_class;
        private final TextView comm_tea;
        private final TextView liao_tea;
        private final TextView xia_class;

        public FirstViewHolder(View itemView) {
            super(itemView);
            //轮播图
            banner = itemView.findViewById(R.id.banner);
            //找老师
            zhao_tea = itemView.findViewById(R.id.zhao_tea);
            //线上课
            xian_class = itemView.findViewById(R.id.xian_class);
            //交作业
            comm_tea = itemView.findViewById(R.id.comm_tea);
            //聊艺考
            liao_tea = itemView.findViewById(R.id.liao_tea);
            //线下课
            xia_class = itemView.findViewById(R.id.xia_class);
        }
    }
    public class OtherViewHolder extends RecyclerView.ViewHolder{

        private final RecyclerView tuijian_recycle;

        public OtherViewHolder(View itemView) {
            super(itemView);
            tuijian_recycle = itemView.findViewById(R.id.tuijian_recycle);
        }
    }
    public class ThreeViewHolder extends RecyclerView.ViewHolder{

        private final RecyclerView class_recycle;

        public ThreeViewHolder(View itemView) {
            super(itemView);
            class_recycle = itemView.findViewById(R.id.class_recycle);
        }
    }
    public class FurViewHolder extends RecyclerView.ViewHolder{

        private final RecyclerView fur_recycle;

        public FurViewHolder(View itemView) {
            super(itemView);
            fur_recycle = itemView.findViewById(R.id.fur_recycle);
        }
    }
    public interface onclicklistener {
        void onitemclick(int position);
    }
    public void setonclicklistener (onclicklistener listener) {
        this.listener=listener;
    }
}
