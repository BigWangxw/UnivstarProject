package com.example.dell.univstarproject.sign.signview;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

import com.example.dell.univstarproject.R;
import com.example.dell.univstarproject.sign.prisenter.IPassprisenter;
import com.example.dell.univstarproject.sign.prisenter.Passprisenter;

public class PassActivity extends AppCompatActivity implements View.OnClickListener,PassView{

    private ImageButton pass_back;
    private EditText pass_one;
    private EditText pass_two;
    private Button pass_finish;
    private IPassprisenter passprisenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pass);
        initView();
    }

    private void initView() {
        pass_back = (ImageButton) findViewById(R.id.pass_back);
        pass_one = (EditText) findViewById(R.id.pass_one);
        pass_two = (EditText) findViewById(R.id.pass_two);
        pass_finish = (Button) findViewById(R.id.pass_finish);

        pass_back.setOnClickListener(this);
        pass_finish.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.pass_back:
                Intent intent = new Intent(this,FindActivity.class);
                startActivity(intent);
                break;
            case R.id.pass_finish:
                Intent intent1 = getIntent();
                String phone = intent1.getStringExtra("phone");
                String s = pass_two.getText().toString();
                passprisenter=new Passprisenter(this);
                passprisenter.pass(phone,s);
                Toast.makeText(this, "修改成功", Toast.LENGTH_SHORT).show();
                Intent intent2 = new Intent(this, SignActivity.class);
                startActivity(intent2);
                finish();
                break;
        }
    }

    private void submit() {
        // validate
        String one = pass_one.getText().toString().trim();
        if (TextUtils.isEmpty(one)) {
            Toast.makeText(this, "请输入密码", Toast.LENGTH_SHORT).show();
            return;
        }

        String two = pass_two.getText().toString().trim();
        if (TextUtils.isEmpty(two)) {
            Toast.makeText(this, "请确认密码", Toast.LENGTH_SHORT).show();
            return;
        }

        // TODO validate success, do something


    }

    @Override
    public void showpass(String string) {

    }
}
