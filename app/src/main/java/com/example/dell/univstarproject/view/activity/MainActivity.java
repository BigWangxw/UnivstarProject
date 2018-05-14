package com.example.dell.univstarproject.view.activity;

import android.content.Intent;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.example.dell.univstarproject.R;
import com.example.dell.univstarproject.base.BaseActivity;
import com.example.dell.univstarproject.sign.message.MessageActivity;
import com.example.dell.univstarproject.start.model.bean.StatusBarCompat;
import com.example.dell.univstarproject.view.fragment.BabyFragment;
import com.example.dell.univstarproject.view.fragment.DemoFragment;
import com.example.dell.univstarproject.view.fragment.ForeShowFragment;
import com.example.dell.univstarproject.view.fragment.TeacherFragment;
import com.example.dell.univstarproject.view.fragment.PersongeFragment;
public class MainActivity extends BaseActivity {

    public   ImageView font_img;
    private ImageView message_img;
    private Toolbar toobar;
    private FrameLayout fg;
    private RadioButton teacher_btn;
    public static RadioButton demo_btn;
    public static RadioButton baby_btn;
    public static RadioButton foreshow_btn;
    private RadioButton my_btn;
    private RadioGroup rado_group;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_main;

    }


    @Override
    protected void initView() {
        StatusBarCompat.translucentStatusBar(this,true);
        //windowManager = (WindowManager)getSystemService(Context.WINDOW_SERVICE);
        AddFragment(R.id.fg,TeacherFragment.class,null);
        font_img = (ImageView) findViewById(R.id.font_img);
        message_img = (ImageView) findViewById(R.id.message_img);
        toobar = (Toolbar) findViewById(R.id.toobar);
        setSupportActionBar(toobar);
        fg = (FrameLayout) findViewById(R.id.fg);
        teacher_btn = (RadioButton) findViewById(R.id.teacher_btn);
        demo_btn = (RadioButton) findViewById(R.id.demo_btn);
        baby_btn = (RadioButton) findViewById(R.id.baby_btn);
        foreshow_btn = (RadioButton) findViewById(R.id.foreshow_btn);
        my_btn = (RadioButton) findViewById(R.id.my_btn);
        rado_group = (RadioGroup) findViewById(R.id.rado_group);
        rado_group.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId) {
                    case R.id.teacher_btn:
                        AddFragment(R.id.fg,TeacherFragment.class,null);
                        break;
                    case R.id.demo_btn:
                        AddFragment(R.id.fg,DemoFragment.class,null);
                        break;
                    case R.id.baby_btn:
                        AddFragment(R.id.fg,BabyFragment.class,null).setTitle();
                        break;
                    case R.id.foreshow_btn:
                        AddFragment(R.id.fg,ForeShowFragment.class,null);
                        break;
                    case R.id.my_btn:
                        AddFragment(R.id.fg,PersongeFragment.class,null);
                        break;
                }
            }
        });
        message_img.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this,MessageActivity.class));
                overridePendingTransition(R.anim.trantion,R.anim.trantion1);
            }
        });
        font_img.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this,AddActivity.class));
            }
        });
    }
    @Override
    protected void loadData() {

    }
}
