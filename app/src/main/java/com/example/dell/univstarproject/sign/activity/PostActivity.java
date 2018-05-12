package com.example.dell.univstarproject.sign.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageButton;

import com.example.dell.univstarproject.R;
import com.example.dell.univstarproject.sign.signview.SignActivity;

public class PostActivity extends AppCompatActivity implements View.OnClickListener {

    private ImageButton post_back;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_post);
        initView();
    }

    private void initView() {
        post_back = (ImageButton) findViewById(R.id.post_back);

        post_back.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.post_back:
                Intent intent = new Intent(this, SignActivity.class);
                startActivity(intent);
                break;
        }
    }
}
