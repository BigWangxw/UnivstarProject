package com.example.dell.univstarproject.sign.message;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageButton;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.dell.univstarproject.R;

public class MessageActivity extends AppCompatActivity implements View.OnClickListener{

    private TextView text_dingdan;
    private RelativeLayout message_dingdan;
    private TextView text_zan;
    private RelativeLayout message_zan;
    private TextView text_ping;
    private RelativeLayout message_works;
    private TextView text_works;
    private RelativeLayout message_pinglun;
    private TextView text_tuandui;
    private RelativeLayout message_tuan;
    private TextView text_guanzhu;
    private RelativeLayout message_guanzhu;
    private ImageButton back;
    private int idd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_m);
        Intent intent = getIntent();
        idd = intent.getIntExtra("idd", 0);
        initView();
    }

    private void initView() {
        text_dingdan = (TextView) findViewById(R.id.text_dingdan);
        message_dingdan = (RelativeLayout) findViewById(R.id.message_dingdan);
        text_zan = (TextView) findViewById(R.id.text_zan);
        message_zan = (RelativeLayout) findViewById(R.id.message_zan);
        text_ping = (TextView) findViewById(R.id.text_ping);
        message_works = (RelativeLayout) findViewById(R.id.message_works);
        text_works = (TextView) findViewById(R.id.text_works);
        message_pinglun = (RelativeLayout) findViewById(R.id.message_pinglun);
        text_tuandui = (TextView) findViewById(R.id.text_tuandui);
        message_tuan = (RelativeLayout) findViewById(R.id.message_tuan);
        text_guanzhu = (TextView) findViewById(R.id.text_guanzhu);
        message_guanzhu = (RelativeLayout) findViewById(R.id.message_guanzhu);
        back= (ImageButton) findViewById(R.id.message_back);
        back.setOnClickListener(this);
        message_dingdan.setOnClickListener(this);
        message_zan.setOnClickListener(this);
        message_pinglun.setOnClickListener(this);
        message_guanzhu.setOnClickListener(this);
        message_tuan.setOnClickListener(this);
        message_works.setOnClickListener(this);
    }
    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.message_dingdan://订单提醒
                break;
            case R.id.message_zan://赞我的
                break;
            case R.id.message_pinglun://评论我的
                break;
            case R.id.message_works://作业提醒
                break;
            case R.id.message_tuan://团队
                Intent intent = new Intent(this, TeamActivity.class);
                startActivityForResult(intent,1234);
                break;
            case R.id.message_guanzhu://关注
                Intent intent1 = new Intent(this, GuanzhuActivity.class);
                startActivityForResult(intent1,1235);
                break;
            case R.id.message_back://返回
                break;
        }
    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode==10&&resultCode==10){
            String content = data.getStringExtra("content");
            text_tuandui.setText(content);
        }
        if (requestCode==1234&&resultCode==1234){
            String aaa = data.getStringExtra("aaa");
            text_tuandui.setText(aaa);
        }
        if (requestCode==1235&&resultCode==1235){
            String bbb = data.getStringExtra("bbb");
            text_guanzhu.setText(bbb+"关注了你");
        }
    }
}
