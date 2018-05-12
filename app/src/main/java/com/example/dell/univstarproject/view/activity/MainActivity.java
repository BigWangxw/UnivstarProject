package com.example.dell.univstarproject.view.activity;

import android.support.v7.widget.Toolbar;
import android.view.WindowManager;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.example.dell.univstarproject.R;
import com.example.dell.univstarproject.base.BaseActivity;
import com.example.dell.univstarproject.model.bean.MyScrollView;
import com.example.dell.univstarproject.view.fragment.BabyFragment;
import com.example.dell.univstarproject.view.fragment.DemoFragment;
import com.example.dell.univstarproject.view.fragment.ForeShowFragment;
import com.example.dell.univstarproject.view.fragment.PersongeFragment;
import com.example.dell.univstarproject.view.fragment.TeacherFragment;

public class MainActivity extends BaseActivity implements MyScrollView.OnScrollListener{

    private ImageView font_img;
    private ImageView message_img;
    private Toolbar toobar;
    private FrameLayout fg;
    private RadioButton teacher_btn;
    private RadioButton demo_btn;
    private RadioButton baby_btn;
    private RadioButton foreshow_btn;
    private RadioButton my_btn;
    private RadioGroup rado_group;
    private LinearLayout ll_tab;
    private MyScrollView myScrollView;
    private int tabHeight;
    private int tabTop;
    private int scrollTop;
    private int picBottom;
    private WindowManager windowManager;
    @Override
    protected int getLayoutId() {
        return R.layout.activity_main;

    }


    @Override
    protected void initView() {
        //windowManager = (WindowManager)getSystemService(Context.WINDOW_SERVICE);
        ll_tab = findViewById(R.id.ll_tab);
        myScrollView = findViewById(R.id.myScrollView);
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
       // myScrollView.setOnScrollListener(this);
        rado_group.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId) {
                    case R.id.teacher_btn:
                        setContentView(TeacherFragment.class);
                        break;
                    case R.id.demo_btn:
                        setContentView(DemoFragment.class);
                        break;
                    case R.id.baby_btn:
                        setContentView(BabyFragment.class);
                        break;
                    case R.id.foreshow_btn:
                        setContentView(ForeShowFragment.class);
                        break;
                    case R.id.my_btn:
                        setContentView(PersongeFragment.class);

                        break;
                }
            }
        });
      /*  message_img.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this,MessageActivity.class));
                overridePendingTransition(R.anim.trantion,R.anim.trantion1);
            }
        });*/

    }
    @Override
    protected void loadData() {
        setContentView(TeacherFragment.class);

    }

  /*  @Override
    public void onWindowFocusChanged(boolean hasFocus) {
        super.onWindowFocusChanged(hasFocus);

            if (hasFocus) {
                tabHeight = ll_tab.getHeight();
                tabTop = ll_tab.getTop();
                scrollTop = myScrollView.getTop();

            }

    }*/

    @Override
    public void onScroll(int scrollY) {
        int top = Math.max(scrollY, picBottom);
        ll_tab.layout(0, top, ll_tab.getWidth(), top + ll_tab.getHeight());
    }

}
