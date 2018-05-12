package com.example.dell.univstarproject.sign.signview;

import android.content.Intent;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import com.example.dell.univstarproject.R;
import com.example.dell.univstarproject.base.BaseActivity;
import com.example.dell.univstarproject.sign.prisenter.Zhuceprisenter;


//注册界面
public class ZhuceActivity extends BaseActivity implements View.OnClickListener,ZhuceView{

    private ImageButton zhuce_back;
    private EditText zhuce_phone;
    private TextView a;
    private EditText zhuce_yzm;
    private Button zhuce_huoqu;
    private Button button;
    private Button zhuce;
    private ImageButton zhuce_weixin;
    private ImageButton zhuce_qq;
    private ImageButton zhuce_weibo;
    private Zhuceprisenter zhuceprisenter;
    private String sss;
    private String s1;
    private String s2;
    private int aa=60;
    private Handler handler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            switch (msg.what) {
                case 1:
                    aa--;
                    zhuce_huoqu.setText(aa + "s");
                    if (aa > 0) {
                        Message message = handler.obtainMessage(1);
                        handler.sendMessageDelayed(message, 1000);      // send message
                    } else {
                        zhuce_huoqu.setText("重新发送");
                    }
            }
            super.handleMessage(msg);
        }
    };


    @Override
    protected int getLayoutId() {
        return R.layout.activity_zhuce;
    }

    @Override
    protected void loadData() {
        initView();
    }

    protected void initView() {
        zhuce_back = (ImageButton) findViewById(R.id.zhuce_back);
        zhuce_phone = (EditText) findViewById(R.id.zhuce_phone);
        a = (TextView) findViewById(R.id.a);
        zhuce_yzm = (EditText) findViewById(R.id.zhuce_yzm);
        zhuce_huoqu = (Button) findViewById(R.id.zhuce_huoqu);
        button = (Button) findViewById(R.id.button);
        zhuce = (Button) findViewById(R.id.zhuce);
        zhuce_weixin = (ImageButton) findViewById(R.id.zhuce_weixin);
        zhuce_qq = (ImageButton) findViewById(R.id.zhuce_qq);
        zhuce_weibo = (ImageButton) findViewById(R.id.zhuce_weibo);

        zhuce_back.setOnClickListener(this);
        zhuce_huoqu.setOnClickListener(this);
        button.setOnClickListener(this);
        zhuce.setOnClickListener(this);
        zhuce_weixin.setOnClickListener(this);
        zhuce_qq.setOnClickListener(this);
        zhuce_weibo.setOnClickListener(this);
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.zhuce_back:
                Intent intent1 = new Intent(this,SignActivity.class);
                startActivity(intent1);
                break;
            case R.id.zhuce_huoqu:
                String s = zhuce_phone.getText().toString();
                zhuceprisenter=new Zhuceprisenter(this);
                zhuceprisenter.zhuce(s);
                Message message = handler.obtainMessage(1);
                handler.sendMessageDelayed(message, 1000);
                break;
            case R.id.button:

                break;
            case R.id.zhuce:
                s1 = zhuce_phone.getText().toString();
                s2 = zhuce_yzm.getText().toString();
                zhuceprisenter.zhuceSuccess(s1, s2);
                Intent intent = new Intent(this, DetaActivity.class);
                intent.putExtra("phone", s1);
                startActivity(intent);
                break;
            case R.id.zhuce_weixin:

                break;
            case R.id.zhuce_qq:

                break;
            case R.id.zhuce_weibo:

                break;
        }
    }
    private void submit() {
        // validate
        String phone = zhuce_phone.getText().toString().trim();
        if (TextUtils.isEmpty(phone)) {
            Toast.makeText(this, "输入手机号", Toast.LENGTH_SHORT).show();
            return;
        }

        String yzm = zhuce_yzm.getText().toString().trim();
        if (TextUtils.isEmpty(yzm)) {
            Toast.makeText(this, "输入验证码", Toast.LENGTH_SHORT).show();
            return;
        }
        // TODO validate success, do something
    }
    @Override
    public void showZhuce(String string) {
        sss = string.toString();
        if (sss.contains("验证码已发送")) {
            Toast.makeText(this, "发送成功", Toast.LENGTH_SHORT).show();
        }else {
            Toast.makeText(this, "发送失败", Toast.LENGTH_SHORT).show();
        }
    }
    @Override
    public void shousuccess(String string) {
    }
}
