package com.example.dell.univstarproject.sign.activity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.example.dell.univstarproject.R;
import com.example.dell.univstarproject.sign.entry.Change;
import com.example.dell.univstarproject.sign.prisenter.IJiaohuanPresenter;
import com.example.dell.univstarproject.sign.prisenter.Jiaohuanprisenter;
import com.example.dell.univstarproject.sign.signview.JiaohuanView;

public class JiaohuanActivity extends AppCompatActivity implements View.OnClickListener,JiaohuanView{

    private ImageButton jiaohuan_back;
    private EditText jiaohuan_phone;
    private EditText jiaohuan_yzm;
    private Button jianhuan_huoqu;
    private LinearLayout jianhuan_qian;
    private ImageButton jiaohuan_back2;
    private LinearLayout jiaohuan_hou;
    private IJiaohuanPresenter jiaohuanPresenter;
    private Button queding;
    private int c;
    private int a=60;
    private int b=3;
    private String mobile;
    private Button daojishi;
    private Handler handler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            switch (msg.what) {
                case 1:
                    a--;
                    jianhuan_huoqu.setText(a + "s");
                    if (a > 0) {
                        Message message = handler.obtainMessage(1);
                        handler.sendMessageDelayed(message, 1000);      // send message
                    } else {
                        //跳转到主界面
                        jianhuan_huoqu.setText("重新获取");
                    }
            }
            super.handleMessage(msg);
        }
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_jiaohuan);
        Intent intent = getIntent();
        c = intent.getIntExtra("b",0);
        initView();
    }

    private void initView() {
        daojishi=findViewById(R.id.daojishi);
        jiaohuan_back = (ImageButton) findViewById(R.id.jiaohuan_back);
        jiaohuan_phone = (EditText) findViewById(R.id.jiaohuan_phone);
        jiaohuan_yzm = (EditText) findViewById(R.id.jiaohuan_yzm);
        jianhuan_huoqu = (Button) findViewById(R.id.jianhuan_huoqu);
        jianhuan_qian = (LinearLayout) findViewById(R.id.jianhuan_qian);
        jiaohuan_back2 = (ImageButton) findViewById(R.id.jiaohuan_back2);
        jiaohuan_hou = (LinearLayout) findViewById(R.id.jiaohuan_hou);
        queding=findViewById(R.id.queding);

        jiaohuan_back.setOnClickListener(this);
        jianhuan_huoqu.setOnClickListener(this);
        jiaohuan_back2.setOnClickListener(this);
        queding.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.jiaohuan_back:
//17330263005
                break;
            case R.id.jianhuan_huoqu:
                String s = jiaohuan_phone.getText().toString();
                jiaohuanPresenter=new Jiaohuanprisenter(this);
                jiaohuanPresenter.loadYzm(s);
                Message message = handler.obtainMessage(1);
                handler.sendMessageDelayed(message, 1000);
                break;
            case R.id.jiaohuan_back2:
                Intent intent = getIntent();
                intent.putExtra("aaa",mobile);
                setResult(1,intent);
                finish();
                break;
            case R.id.queding:
                String s1 = jiaohuan_phone.getText().toString();
                String s2 = jiaohuan_yzm.getText().toString();
                jiaohuanPresenter.loadJiaohuan(c,s1,s2);
                jianhuan_qian.setVisibility(View.GONE);
                jiaohuan_hou.setVisibility(View.VISIBLE);
                break;
        }
    }
    private void submit() {
        // validate
        String phone = jiaohuan_phone.getText().toString().trim();
        if (TextUtils.isEmpty(phone)) {
            Toast.makeText(this, "输入手机号", Toast.LENGTH_SHORT).show();
            return;
        }

        String yzm = jiaohuan_yzm.getText().toString().trim();
        if (TextUtils.isEmpty(yzm)) {
            Toast.makeText(this, "输入验证码", Toast.LENGTH_SHORT).show();
            return;
        }

        // TODO validate success, do something


    }

    @Override
    public void showone(String string) {

    }

    @Override
    public void ShowTwo(Change change) {
        mobile = change.getData().getMobile();
    }
}
