package com.example.dell.univstarproject.sign.signview;

import android.content.Intent;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;

import com.example.dell.univstarproject.R;
import com.example.dell.univstarproject.base.BaseActivity;
import com.example.dell.univstarproject.sign.prisenter.IZhuceprisenter;
import com.example.dell.univstarproject.sign.prisenter.Zhuceprisenter;

public class FindActivity extends BaseActivity implements View.OnClickListener,ZhuceView{

    private ImageButton find_back;
    private EditText find_phone;
    private EditText find_yzm;
    private Button find_exit;
    private IZhuceprisenter zhuceprisenter;
    private Button huoqu;
    private int a=60;
    private Handler handler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            switch (msg.what) {
                case 1:
                    a--;
                    huoqu.setText(a + "s");
                    if (a > 0) {
                        Message message = handler.obtainMessage(1);
                        handler.sendMessageDelayed(message, 1000);      // send message
                    } else {
                        huoqu.setText("发送验证码");
                    }
            }
            super.handleMessage(msg);
        }
    };



    @Override
    protected int getLayoutId() {
        return R.layout.activity_find;
    }

    @Override
    protected void loadData() {
        initView();
    }

    protected void initView() {
        find_back = (ImageButton) findViewById(R.id.find_back);
        find_phone = (EditText) findViewById(R.id.find_phone);
        find_yzm = (EditText) findViewById(R.id.find_yzm);
        find_exit = (Button) findViewById(R.id.find_exit);
        huoqu = (Button) findViewById(R.id.find_huoqu);

        huoqu.setOnClickListener(this);
        find_back.setOnClickListener(this);
        find_exit.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.find_back:
                Intent intent = new Intent(this,SignActivity.class);
                startActivity(intent);
                break;
            case R.id.find_huoqu:
                Message message = handler.obtainMessage(1);
                handler.sendMessageDelayed(message, 1000);
                String s2 = find_phone.getText().toString();
                zhuceprisenter=new Zhuceprisenter(this);
                zhuceprisenter.zhuce(s2);
                break;
            case R.id.find_exit:
                String s = find_phone.getText().toString();
                String s1 = find_yzm.getText().toString();
                zhuceprisenter.zhuceSuccess(s,s1);
                Intent intent1 = new Intent(this,PassActivity.class);
                intent1.putExtra("phone",s);
                startActivity(intent1);
                finish();
                break;
        }
    }

    @Override
    public void showZhuce(String string) {

    }

    @Override
    public void shousuccess(String string) {

    }
}
