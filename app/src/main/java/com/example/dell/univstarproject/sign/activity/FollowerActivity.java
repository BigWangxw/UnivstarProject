package com.example.dell.univstarproject.sign.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageButton;

import com.example.dell.univstarproject.R;
import com.example.dell.univstarproject.model.http.ShapeUtils;
import com.example.dell.univstarproject.sign.entry.Fans;
import com.example.dell.univstarproject.sign.orderAdapter.FanAdapter;
import com.example.dell.univstarproject.sign.prisenter.Followprisenter;
import com.example.dell.univstarproject.sign.prisenter.IFollowprisenter;
import com.example.dell.univstarproject.sign.signview.FollowerView;

import java.util.ArrayList;
import java.util.List;

public class FollowerActivity extends AppCompatActivity implements View.OnClickListener,FollowerView{


    private ImageButton follower_back;
    private RecyclerView follower_recy;
    private IFollowprisenter followprisenter;
    private FanAdapter fanAdapter;
    private List<Fans.DataBean.ListBean> listBeans=new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_follower);
        initView();
    }
    private void initView() {
        follower_back = (ImageButton) findViewById(R.id.follower_back);
        follower_recy = (RecyclerView) findViewById(R.id.follower_recy);
        LinearLayoutManager linearLayoutManager=new LinearLayoutManager(this);
        follower_recy.setLayoutManager(linearLayoutManager);
        follower_back.setOnClickListener(this);
        int id = ShapeUtils.getIntance().getId();
        followprisenter=new Followprisenter(this);
        followprisenter.loadFoller(id);
        fanAdapter=new FanAdapter(listBeans,this);
        follower_recy.setAdapter(fanAdapter);
    }
    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.follower_back:
                break;
        }
    }
    @Override
    public void show(List<Fans.DataBean.ListBean> listBean) {
        listBeans.addAll(listBean);
        fanAdapter.notifyDataSetChanged();
    }
}
