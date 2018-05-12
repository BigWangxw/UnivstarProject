package com.example.dell.univstarproject.sign.activity;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.TextView;
import android.widget.Toast;

import com.example.dell.univstarproject.R;
import com.example.dell.univstarproject.view.activity.MainActivity;

public class PayActivity extends AppCompatActivity implements View.OnClickListener {

    private ImageButton pay_back;
    private TextView textView;
    private TextView pay_zhanghao;
    private TextView pay_yu;
    private ImageView imageView5;
    private Button pay_one;
    private ImageView imageView6;
    private Button pay_twohundred;
    private ImageView imageView7;
    private Button pay_fivehundred;
    private ImageView imageView8;
    private Button pay_onethousand;
    private ImageView imageView9;
    private Button pay_twothousand;
    private ImageView imageView11;
    private Button pay_fivethousand;
    private ImageView imageView22;
    private Button pay_tenthousand;
    private ImageView imageView33;
    private Button pay_twotythousand;
    private PopupWindow popupWindow;
    private LinearLayout zhifubao,weixin;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pay);
        Pay();
        initView();
        Intent intent = getIntent();
        String shoujihao = intent.getStringExtra("shoujihao");
        pay_zhanghao.setText(shoujihao);
    }

    private void initView() {
        pay_back = (ImageButton) findViewById(R.id.pay_back);
        textView = (TextView) findViewById(R.id.textView);
        pay_zhanghao = (TextView) findViewById(R.id.pay_zhanghao);
        pay_yu = (TextView) findViewById(R.id.pay_yu);
        imageView5 = (ImageView) findViewById(R.id.imageView5);
        pay_one = (Button) findViewById(R.id.pay_one);
        imageView6 = (ImageView) findViewById(R.id.imageView6);
        pay_twohundred = (Button) findViewById(R.id.pay_twohundred);
        imageView7 = (ImageView) findViewById(R.id.imageView7);
        pay_fivehundred = (Button) findViewById(R.id.pay_fivehundred);
        imageView8 = (ImageView) findViewById(R.id.imageView8);
        pay_onethousand = (Button) findViewById(R.id.pay_onethousand);
        imageView9 = (ImageView) findViewById(R.id.imageView9);
        pay_twothousand = (Button) findViewById(R.id.pay_twothousand);
        imageView11 = (ImageView) findViewById(R.id.imageView11);
        pay_fivethousand = (Button) findViewById(R.id.pay_fivethousand);
        imageView22 = (ImageView) findViewById(R.id.imageView22);
        pay_tenthousand = (Button) findViewById(R.id.pay_tenthousand);
        imageView33 = (ImageView) findViewById(R.id.imageView33);
        pay_twotythousand = (Button) findViewById(R.id.pay_twotythousand);

        pay_back.setOnClickListener(this);
        pay_one.setOnClickListener(this);
        pay_twohundred.setOnClickListener(this);
        pay_fivehundred.setOnClickListener(this);
        pay_onethousand.setOnClickListener(this);
        pay_twothousand.setOnClickListener(this);
        pay_fivethousand.setOnClickListener(this);
        pay_tenthousand.setOnClickListener(this);
        pay_twotythousand.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.pay_back:
                Intent intent = new Intent(this, MainActivity.class);
                startActivity(intent);
                break;
            case R.id.pay_one:
                popupWindow.showAtLocation(findViewById(R.id.biwa), Gravity.CENTER|Gravity.BOTTOM,0,0);
                break;
            case R.id.pay_twohundred:
                popupWindow.showAtLocation(findViewById(R.id.biwa), Gravity.CENTER|Gravity.BOTTOM,0,0);
                break;
            case R.id.pay_fivehundred:
                popupWindow.showAtLocation(findViewById(R.id.biwa), Gravity.CENTER|Gravity.BOTTOM,0,0);
                break;
            case R.id.pay_onethousand:
                popupWindow.showAtLocation(findViewById(R.id.biwa), Gravity.CENTER|Gravity.BOTTOM,0,0);
                break;
            case R.id.pay_twothousand:
                popupWindow.showAtLocation(findViewById(R.id.biwa), Gravity.CENTER|Gravity.BOTTOM,0,0);
                break;
            case R.id.pay_fivethousand:
                popupWindow.showAtLocation(findViewById(R.id.biwa), Gravity.CENTER|Gravity.BOTTOM,0,0);
                break;
            case R.id.pay_tenthousand:
                popupWindow.showAtLocation(findViewById(R.id.biwa), Gravity.CENTER|Gravity.BOTTOM,0,0);
                break;
            case R.id.pay_twotythousand:
                popupWindow.showAtLocation(findViewById(R.id.biwa), Gravity.CENTER|Gravity.BOTTOM,0,0);
                break;
            case R.id.zhifubao:
                Toast.makeText(this, "正在跳转到支付宝...", Toast.LENGTH_SHORT).show();
                break;
            case R.id.weixin:
                Toast.makeText(this,"正在跳转到微信...",Toast.LENGTH_SHORT).show();
                break;
        }
    }
    //支付宝和微信支付入口
    private void Pay(){
        View view= LayoutInflater.from(this).inflate(R.layout.me_zhifu,null);
        zhifubao=view.findViewById(R.id.zhifubao);
        weixin=view.findViewById(R.id.weixin);
        zhifubao.setOnClickListener(this);
        weixin.setOnClickListener(this);
        popupWindow=new PopupWindow(view, LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT,true);
        // 设置PopupWindow是否能响应外部点击事件
        popupWindow.setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        popupWindow.setOutsideTouchable(true);
        // 设置PopupWindow是否能响应点击事件
        popupWindow.setTouchable(true);
    }
}
