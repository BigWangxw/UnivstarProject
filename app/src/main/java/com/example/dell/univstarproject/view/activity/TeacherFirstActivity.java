package com.example.dell.univstarproject.view.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.dell.univstarproject.R;
import com.example.dell.univstarproject.base.BaseActivity;
import com.example.dell.univstarproject.base.BaseApp;
import com.example.dell.univstarproject.model.bean.Quxiao;
import com.example.dell.univstarproject.model.bean.Teacher;
import com.example.dell.univstarproject.model.bean.ToastBean;
import com.example.dell.univstarproject.model.bean.ZanClick;
import com.example.dell.univstarproject.model.http.RetrofitUtils;
import com.example.dell.univstarproject.presenter.TeacherContrcat;
import com.example.dell.univstarproject.presenter.TeacherPresneter;

public class TeacherFirstActivity extends BaseActivity<TeacherPresneter> implements View.OnClickListener, TeacherContrcat.TeacherView {

    private RelativeLayout qingtafudao;
    private ImageView masterdetail_img;
    private Button biaoqian_btn;
    private LinearLayout linnnnnn;
    private ImageView teachen_img;
    private TextView teacher_name;
    private TextView teacher_type;
    private TextView class_num;
    private TextView demo_num;
    private TextView fudao_num;
    private TextView tie_num;
    private TextView guanzhu_num;
    private TextView fensi_num;
    private TextView jianjie_tv;
    private CheckBox zan_check;
    private TextView zan_num;
    private Button guanzhubtn;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_teacher_first;
    }

    @Override
    protected void loadData() {
        Integer teaId = getIntent().getIntExtra("teaId",0);
        presenter.loadTeachenBean(teaId);

    }

    protected void initView() {
        qingtafudao = (RelativeLayout) findViewById(R.id.qingtafudao);
        masterdetail_img = (ImageView) findViewById(R.id.masterdetail_img);
        biaoqian_btn = (Button) findViewById(R.id.biaoqian_btn);
        linnnnnn = (LinearLayout) findViewById(R.id.linnnnnn);
        zan_check = (CheckBox) findViewById(R.id.zan_check);
        zan_num = findViewById(R.id.zan_num);
        teachen_img = (ImageView) findViewById(R.id.teachen_img);
        teacher_name = (TextView) findViewById(R.id.teacher_name);
        teacher_type = (TextView) findViewById(R.id.teacher_type);
        class_num = (TextView) findViewById(R.id.class_num);
        demo_num = (TextView) findViewById(R.id.demo_num);
        fudao_num = (TextView) findViewById(R.id.fudao_num);
        tie_num = (TextView) findViewById(R.id.tie_num);
        guanzhu_num = (TextView) findViewById(R.id.guanzhu_num);
        fensi_num = (TextView) findViewById(R.id.fensi_num);
        jianjie_tv = (TextView) findViewById(R.id.jianjie_tv);
        guanzhubtn = (Button) findViewById(R.id.guanzhubtn);
        biaoqian_btn.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.guanzhubtn:

                break;
        }
    }

    @Override
    public void showTeacherBean(final Teacher teacher) {
        if (teacher == null) {
            return;

        } else {

            Teacher.DataBean.UserBean user = teacher.getData().getUser();
            Glide.with(this).load(user.getImages()).into(masterdetail_img);
            biaoqian_btn.setText(user.getSkilled());
            zan_check.setText(teacher.getData().getPraise().getPraiseCount() + "");
           // teacher_name.setText(user.getNickname()+"");
            teacher_type.setText(user.getIntro());
            class_num.setText(teacher.getData().getLiveCount()+"");
            demo_num.setText(teacher.getData().getHomewokPublishCount()+"");
            fudao_num.setText(teacher.getData().getCoachingCount()+"");
            tie_num.setText(teacher.getData().getPostsCount()+"");
            guanzhu_num.setText(teacher.getData().getAttentionCount()+"");
            fensi_num.setText(teacher.getData().getFansCount()+"");
            jianjie_tv.setText(user.getDetails()+"");
            Glide.with(this).load(user.getPhoto()).into(teachen_img);
            if (teacher.getData().getPraise().getIsPraise() == 0) {


                zan_check.setChecked(false);

            }else {

                zan_check.setText(teacher.getData().getPraise().getPraiseCount() + "");
                zan_check.setChecked(true);

            }
                zan_check.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                @Override
                public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                    if (TextUtils.isEmpty(BaseApp.activity.getSharedPreferences("111",MODE_PRIVATE).getString("xyxy_user_id",""))) {
                        //如果Userid为空   那么去登陆
                        //startIntent(gotoLoginAcitivty.class)
                        if (isChecked ==true) {
                            if (teacher.getData().getPraise().getIsPraise() == 0) {
                                zan_check.setText(teacher.getData().getPraise().getPraiseCount()+"");
                                zan_check.setChecked(false);
                            }else {
                                presenter.dianzan(0,teacher.getData().getUser().get_$Id32()+"","662","老师");
                                zan_check.setText(teacher.getData().getPraise().getPraiseCount()+1+"");
                                zan_check.setChecked(true);
                            }
                        } else {

                            presenter.quxiao(0,teacher.getData().getUser().get_$Id32()+"","662","老师");
                            zan_check.setText(teacher.getData().getPraise().getPraiseCount()+"");
                        }
                    }else {
                            //跳转登录界面
                    }

                }
            });
        }
    }

    @Override
    public void showdianzan(String zanClick) {
        ToastBean.showmessage(this,zanClick);
    }

    @Override
    public void showquxiao(String quxiao) {
        ToastBean.showmessage(this,quxiao);

    }


}
