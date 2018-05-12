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
//编辑地址
public class RegionActivity extends AppCompatActivity implements View.OnClickListener {

    private ImageButton region_back;
    private Button region_baocun;
    private EditText region_region;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_region);
        initView();
    }

    private void initView() {
        region_back = (ImageButton) findViewById(R.id.region_back);
        region_baocun = (Button) findViewById(R.id.region_baocun);
        region_region = (EditText) findViewById(R.id.region_region);

        region_back.setOnClickListener(this);
        region_baocun.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.region_back:
                Intent intent = new Intent(this,PersonalActivity.class);
                startActivity(intent);
                break;
            case R.id.region_baocun:
                String s = region_region.getText().toString();
                Intent intent1 = getIntent();
                intent1.putExtra("region",s);
                setResult(30,intent1);
                finish();
                break;
        }
    }

    private void submit() {
        // validate
        String region = region_region.getText().toString().trim();
        if (TextUtils.isEmpty(region)) {
            Toast.makeText(this, "请输入昵称", Toast.LENGTH_SHORT).show();
            return;
        }

        // TODO validate success, do something


    }
}
