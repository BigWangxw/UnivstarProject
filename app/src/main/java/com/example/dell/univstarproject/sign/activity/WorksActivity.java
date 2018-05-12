package com.example.dell.univstarproject.sign.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageButton;

import com.example.dell.univstarproject.R;
import com.example.dell.univstarproject.sign.signview.SignActivity;

public class WorksActivity extends AppCompatActivity implements View.OnClickListener {

    private ImageButton works_back;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_works);
        initView();
    }

    private void initView() {
        works_back = (ImageButton) findViewById(R.id.works_back);

        works_back.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.works_back:
                Intent intent = new Intent(this, SignActivity.class);
                startActivity(intent);
                break;
        }
    }
}
