package com.example.dell.univstarproject.sign.signview;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.dell.univstarproject.R;
import com.example.dell.univstarproject.prisenter.IWangChengPresent;
import com.example.dell.univstarproject.prisenter.WangChengPresent;

public class DetaActivity extends AppCompatActivity implements View.OnClickListener,DetaView{

    private ImageButton deta_back;
    private ImageView imageView;
    private ImageButton camera;
    private EditText deta_name;
    private ImageButton boy;
    private ImageButton girl;
    private EditText deta_password;
    private Button deta_finish;

    private IWangChengPresent wangChengPresent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_deta);
        initView();
    }

    private void initView() {
        deta_back = (ImageButton) findViewById(R.id.deta_back);
        imageView = (ImageView) findViewById(R.id.imageView);
        camera = (ImageButton) findViewById(R.id.camera);
        deta_name = (EditText) findViewById(R.id.deta_name);
        boy = (ImageButton) findViewById(R.id.boy);
        girl = (ImageButton) findViewById(R.id.girl);
        deta_password = (EditText) findViewById(R.id.deta_password);
        deta_finish = (Button) findViewById(R.id.deta_finish);

        deta_back.setOnClickListener(this);
        camera.setOnClickListener(this);
        boy.setOnClickListener(this);
        girl.setOnClickListener(this);
        deta_finish.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.deta_back:

                break;
            case R.id.camera:

                break;
            case R.id.boy:

                break;
            case R.id.girl:

                break;
            case R.id.deta_finish:
                Intent intent = getIntent();
                String phone = intent.getStringExtra("phone");
                String s = deta_name.getText().toString();
                String s1 = deta_password.getText().toString();
                wangChengPresent=new WangChengPresent(this);
                wangChengPresent.wangCheng(s,"","",phone,s1);
                Intent intent1 = new Intent(this,SignActivity.class);
                startActivity(intent);
                break;
        }
    }
    private void submit() {
        // validate
        String name = deta_name.getText().toString().trim();
        if (TextUtils.isEmpty(name)) {
            Toast.makeText(this, "请输入昵称", Toast.LENGTH_SHORT).show();
            return;
        }

        String password = deta_password.getText().toString().trim();
        if (TextUtils.isEmpty(password)) {
            Toast.makeText(this, "请输入密码", Toast.LENGTH_SHORT).show();
            return;
        }

        // TODO validate success, do something


    }

    @Override
    public void showDeta(String string) {

    }
}
