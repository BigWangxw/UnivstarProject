package com.example.dell.univstarproject.sign.activity;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.example.dell.univstarproject.R;
import com.example.dell.univstarproject.sign.entry.Label;
import com.example.dell.univstarproject.sign.orderAdapter.ZongPianAdapter;
import com.example.dell.univstarproject.sign.prisenter.IPreferpresenter;
import com.example.dell.univstarproject.sign.prisenter.Prefenpresenter;
import com.example.dell.univstarproject.sign.signview.PreferView;

import java.util.ArrayList;
import java.util.List;

public class PreferenceActivity extends AppCompatActivity implements PreferView{

    private RecyclerView pre_recy;
    private IPreferpresenter preferpresenter;
    private List<Object> arrayList=new ArrayList<>();
    private ZongPianAdapter zongPianAdapter;
    private Button pianhao_zhuanye;
    private Button button2;
    int i=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_preference);
        initView();
    }
    private void initView() {
        preferpresenter=new Prefenpresenter(this);
        preferpresenter.prefersenter();
        pre_recy = (RecyclerView) findViewById(R.id.pre_recy);
        LinearLayoutManager linearLayoutManager=new LinearLayoutManager(this);
        pre_recy.setLayoutManager(linearLayoutManager);
        zongPianAdapter=new ZongPianAdapter(arrayList,this);
        pre_recy.setAdapter(zongPianAdapter);
        zongPianAdapter.setTiaoTama(new ZongPianAdapter.Onclick() {
            @Override
            public void wai(View view, int psii) {
                pianhao_zhuanye=view.findViewById(R.id.pianhao_zhuanye);
                if(i==0) {
                    i=1;
                    pianhao_zhuanye.setBackgroundColor(Color.parseColor("#F8F8FF"));
                }else if(i==1){
                    pianhao_zhuanye.setTextColor(Color.parseColor("#000000"));
                    Log.e("aaa",i+"");
                    i=0;
                }
            }
        });
    }
    @Override
    public void showPrefer(Label label) {
        arrayList.add(label.getData());
        arrayList.add(label.getData());
        zongPianAdapter.notifyDataSetChanged();
    }
}
