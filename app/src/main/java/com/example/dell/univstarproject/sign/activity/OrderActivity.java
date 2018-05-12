package com.example.dell.univstarproject.sign.activity;

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
import com.example.dell.univstarproject.sign.activity.orderfragment.OrderFragment;
import com.example.dell.univstarproject.sign.activity.orderfragment.PaymentFragment;
import com.example.dell.univstarproject.sign.activity.orderfragment.RejectFragment;
import com.example.dell.univstarproject.sign.activity.orderfragment.UseFragment;
import com.example.dell.univstarproject.sign.orderAdapter.OrderAdapter;
import com.example.dell.univstarproject.sign.signview.SignActivity;

import java.util.ArrayList;

public class OrderActivity extends AppCompatActivity implements View.OnClickListener {

    private PaymentFragment paymentFragment;
    private UseFragment useFragment;
    private RejectFragment rejectFragment;
    private OrderFragment orderFragment;
    private ArrayList<Fragment> arrayList = new ArrayList<>();
    private ArrayList<String> arrayList1 = new ArrayList<>();
    private ImageButton order_back;
    private RadioButton order_quanbu;
    private RadioButton order_daifukuan;
    private RadioButton order_daishiyong;
    private RadioButton order_tuihuo;
    private RadioGroup order_rg;
    private ViewPager orser_viewpager;
    private OrderAdapter orderAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order);
        initView();
    }

    private void initView() {
        orderFragment = new OrderFragment();
        paymentFragment = new PaymentFragment();
        useFragment = new UseFragment();
        rejectFragment = new RejectFragment();
        arrayList.add(orderFragment);
        arrayList.add(paymentFragment);
        arrayList.add(useFragment);
        arrayList.add(rejectFragment);
        arrayList1.add("");
        arrayList1.add("");
        arrayList1.add("");
        arrayList1.add("");
        order_back = (ImageButton) findViewById(R.id.order_back);
        order_back.setOnClickListener(this);
        order_quanbu = (RadioButton) findViewById(R.id.order_quanbu);
        order_quanbu.setOnClickListener(this);
        order_daifukuan = (RadioButton) findViewById(R.id.order_daifukuan);
        order_daifukuan.setOnClickListener(this);
        order_daishiyong = (RadioButton) findViewById(R.id.order_daishiyong);
        order_daishiyong.setOnClickListener(this);
        order_tuihuo = (RadioButton) findViewById(R.id.order_tuihuo);
        order_tuihuo.setOnClickListener(this);
        order_rg = (RadioGroup) findViewById(R.id.order_rg);
        order_rg.setOnClickListener(this);
        orser_viewpager = (ViewPager) findViewById(R.id.orser_viewpager);
        orser_viewpager.setOnClickListener(this);
        orderAdapter=new OrderAdapter(getSupportFragmentManager(),arrayList,arrayList1);
        orser_viewpager.setAdapter(orderAdapter);
        order_rg.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId){
                    case R.id.order_quanbu:
                        orser_viewpager.setCurrentItem(0);
                        break;
                    case R.id.order_daifukuan:
                        orser_viewpager.setCurrentItem(1);
                        break;
                    case R.id.order_daishiyong:
                        orser_viewpager.setCurrentItem(2);
                        break;
                    case R.id.order_tuihuo:
                        orser_viewpager.setCurrentItem(3);
                        break;
                }
            }
        });
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.order_back:
                Intent intent = new Intent(this, SignActivity.class);
                startActivity(intent);
                break;
        }
    }
}
