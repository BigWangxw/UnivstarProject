package com.example.dell.univstarproject.sign.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.example.dell.univstarproject.R;
import com.example.dell.univstarproject.sign.entry.GuanZhu;
import com.example.dell.univstarproject.sign.orderAdapter.ConcernAdapter;
import com.example.dell.univstarproject.sign.prisenter.Concernprisenter;
import com.example.dell.univstarproject.sign.prisenter.IConcernprisenter;
import com.example.dell.univstarproject.sign.signview.ConcernView;

import java.util.ArrayList;

//关注
public class ConcernActivity extends AppCompatActivity implements View.OnClickListener,ConcernView{


    private ImageButton concern_back;
    private ImageView imageView3;
    private LinearLayout concern_meiyou;
    private RecyclerView concern_recy;
    private LinearLayout concern_you;
    private IConcernprisenter concernprisenter;
    private int id;
    private ConcernAdapter concernAdapter;
    private int size;
    private ArrayList<GuanZhu.DataBean.ListBean> arrayList=new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_concern);
        Intent intent = getIntent();
        id = intent.getIntExtra("id", 0);
        Log.e("id",id+"");
        initView();

    }

    private void initView() {
        concern_back = (ImageButton) findViewById(R.id.concern_back);
        imageView3 = (ImageView) findViewById(R.id.imageView3);
        concern_meiyou = (LinearLayout) findViewById(R.id.concern_meiyou);
        concern_recy = (RecyclerView) findViewById(R.id.concern_recy);
        LinearLayoutManager linearLayoutManager=new LinearLayoutManager(this);
        concern_recy.setLayoutManager(linearLayoutManager);
        concern_you = (LinearLayout) findViewById(R.id.concern_you);
        concern_back.setOnClickListener(this);
        concernprisenter=new Concernprisenter(this);
        concernprisenter.loadCon(id);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.concern_back:

                break;
        }
    }

    @Override
    public void showCon(GuanZhu guanZhu) {
        Log.e("guanzhu",guanZhu.toString());
        arrayList.addAll(guanZhu.getData().getList());
        concernAdapter=new ConcernAdapter(arrayList,this);
        concern_recy.setAdapter(concernAdapter);
    }
}
