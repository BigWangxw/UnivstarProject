package com.example.dell.univstarproject.sign.personal;

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


//编辑昵称
public class NameActivity extends AppCompatActivity implements View.OnClickListener {

    private ImageButton name_back;
    private Button name_baocun;
    private EditText name_name;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_name);
        initView();
    }

    private void initView() {
        name_back = (ImageButton) findViewById(R.id.name_back);
        name_baocun = (Button) findViewById(R.id.name_baocun);
        name_name = (EditText) findViewById(R.id.name_name);

        name_back.setOnClickListener(this);
        name_baocun.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.name_back:
                Intent intent = new Intent(this,PersonalActivity.class);
                startActivity(intent);
                break;
            case R.id.name_baocun:
                String s = name_name.getText().toString();
                Intent intent1= getIntent();
                intent1.putExtra("name",s);
                setResult(20,intent1);
                finish();
                break;

        }
    }

    private void submit() {
        // validate
        String name = name_name.getText().toString().trim();
        if (TextUtils.isEmpty(name)) {
            Toast.makeText(this, "请输入昵称", Toast.LENGTH_SHORT).show();
            return;
        }

        // TODO validate success, do something


    }
}
