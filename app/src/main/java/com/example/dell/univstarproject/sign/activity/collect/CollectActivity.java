package com.example.dell.univstarproject.sign.activity.collect;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageButton;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.example.dell.univstarproject.R;

import java.util.ArrayList;

public class CollectActivity extends AppCompatActivity implements View.OnClickListener {

    private ImageButton collect_back;
    private ViewPager collect_viewpager;
    private ArrayList<Fragment> arrayList = new ArrayList<>();
    private ArrayList<String> arrayList1 = new ArrayList<>();
    private CollectAdapter collectAdapter;
    private ZhiboFragment zhiboFragment;
    private TiyanFragment tiyanFragment;
    private ToitingFragment toitingFragment;
    private TieziFragment tieziFragment;
    private RadioButton collect_zhibo;
    private RadioButton collect_tiyan;
    private RadioButton collect_touting;
    private RadioButton collect_tiezi;
    private RadioGroup collect_rg;
    private int id;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_collect);
        Intent intent = getIntent();
        id = intent.getIntExtra("id", 0);
        initData();
        initView();
    }

    private void initData() {
        zhiboFragment=new ZhiboFragment();
        tiyanFragment=new TiyanFragment();
        toitingFragment=new ToitingFragment();
        tieziFragment=new TieziFragment();
        arrayList.add(zhiboFragment);
        arrayList.add(tiyanFragment);
        arrayList.add(toitingFragment);
        arrayList.add(tieziFragment);
        arrayList1.add("");
        arrayList1.add("");
        arrayList1.add("");
        arrayList1.add("");
    }

    private void initView() {
        collect_back = (ImageButton) findViewById(R.id.collect_back);
        collect_viewpager = (ViewPager) findViewById(R.id.collect_viewpager);
        collect_back.setOnClickListener(this);
        collect_zhibo = (RadioButton) findViewById(R.id.collect_zhibo);
        collect_zhibo.setOnClickListener(this);
        collect_tiyan = (RadioButton) findViewById(R.id.collect_tiyan);
        collect_tiyan.setOnClickListener(this);
        collect_touting = (RadioButton) findViewById(R.id.collect_touting);
        collect_touting.setOnClickListener(this);
        collect_tiezi = (RadioButton) findViewById(R.id.collect_tiezi);
        collect_tiezi.setOnClickListener(this);
        collect_rg = (RadioGroup) findViewById(R.id.collect_rg);
        collectAdapter=new CollectAdapter(getSupportFragmentManager(),arrayList,arrayList1);
        collect_viewpager.setAdapter(collectAdapter);
        collect_rg.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId){
                    case R.id.collect_zhibo:
                        collect_viewpager.setCurrentItem(0);
                        break;
                    case R.id.collect_tiyan:
                        collect_viewpager.setCurrentItem(1);
                        break;
                    case R.id.collect_touting:
                        collect_viewpager.setCurrentItem(2);
                        break;
                    case R.id.collect_tiezi:
                        collect_viewpager.setCurrentItem(3);
                        break;
                }
            }
        });
    }
    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.collect_back:
                Intent intent = getIntent();
                setResult(333,intent);
                finish();
                break;
        }
    }
}
