package com.example.dell.univstarproject.sign.signview;

import android.content.Intent;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import com.example.dell.univstarproject.R;
import com.example.dell.univstarproject.base.BaseActivity;
import com.example.dell.univstarproject.sign.entry.Sign;
import com.example.dell.univstarproject.sign.prisenter.Isignprisenter;
import com.example.dell.univstarproject.sign.prisenter.Signprisenter;
import com.example.dell.univstarproject.view.fragment.PersongeFragment;
import com.umeng.socialize.UMAuthListener;
import com.umeng.socialize.UMShareAPI;
import com.umeng.socialize.bean.SHARE_MEDIA;

import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


//登录界面
public class SignActivity extends BaseActivity implements View.OnClickListener,SignView{

    private Button sign_close;
    private Button sign_zhuce;
    private EditText sign_phone;
    private TextView a;
    private EditText sign_password;
    private Button button;
    private Button sign;
    private ImageButton sign_weixin;
    private ImageButton sign_qq;
    private ImageButton sign_weibo;

    private Isignprisenter isignprisenter;
    private String s;




    @Override
    protected int getLayoutId() {
        return R.layout.activity_sign2;
    }

    @Override
    protected void loadData() {

    }

    protected void initView() {
        isignprisenter = new Signprisenter(this);
        //登录前
        sign_close = (Button) findViewById(R.id.sign_close);
        sign_zhuce = (Button) findViewById(R.id.sign_zhuce);
        sign_phone = (EditText) findViewById(R.id.sign_phone);


        a = (TextView) findViewById(R.id.a);
        sign_password = (EditText) findViewById(R.id.sign_password);
        button = (Button) findViewById(R.id.button);
        sign = (Button) findViewById(R.id.sign);
        sign_weixin = (ImageButton) findViewById(R.id.sign_weixin);
        sign_qq = (ImageButton) findViewById(R.id.sign_qq);
        sign_weibo = (ImageButton) findViewById(R.id.sign_weibo);

        sign_close.setOnClickListener(this);
        sign_zhuce.setOnClickListener(this);
        button.setOnClickListener(this);
        sign.setOnClickListener(this);
        sign_weixin.setOnClickListener(this);
        sign_qq.setOnClickListener(this);
        sign_weibo.setOnClickListener(this);

        sign_password.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                String s = sign_phone.getText().toString();
                Pattern pattern = Pattern.compile("^1[3578]\\d{9}$");
                Matcher matcher = pattern.matcher(s);
                if (matcher.matches()){

                }else {
                    Toast.makeText(SignActivity.this, "手机号格式不正确", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.sign_close:
                Intent intent2 = getIntent();
                intent2.putExtra("hajhd","sjfh");
                setResult(88,intent2);
                finish();
                break;
            case R.id.sign_zhuce:
                Intent intent = new Intent(this, ZhuceActivity.class);
                startActivity(intent);
                finish();
                break;
            case R.id.button:
                Intent intent1 = new Intent(this, FindActivity.class);
                startActivity(intent1);
                finish();
                break;
            case R.id.sign:
                s = sign_phone.getText().toString();
                String s1 = sign_password.getText().toString();
                isignprisenter.sign(s, s1);
                break;
            case R.id.sign_weixin:

                break;
            case R.id.sign_qq:
                UMShareAPI umShareAPI = UMShareAPI.get(SignActivity.this);
                umShareAPI.doOauthVerify(SignActivity.this, SHARE_MEDIA.QQ, umAuthListener);
                Intent intent3 = getIntent();
                setResult(11111,intent3);
                finish();
                finish();
                break;
            case R.id.sign_weibo:

                break;
        }
    }
    @Override
    public void showData(Sign sign) {
        String nickname = sign.getData().getNickname();
        String photo = (String) sign.getData().getPhoto();
        int id = sign.getData().getId();
        String mobile = sign.getData().getMobile();
        Log.d("aaaa",nickname+photo+id+mobile);
        if (sign_phone.getText().toString().equals(mobile)) {
            Toast.makeText(this, "登录成功...", Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(this, PersongeFragment.class);
            intent.putExtra("nicname", nickname);
            intent.putExtra("photo", photo);
            intent.putExtra("mobile", mobile);
            intent.putExtra("id", id);
            setResult(10, intent);
            finish();
        }else {
            Toast.makeText(this, "登录失败", Toast.LENGTH_SHORT).show();
        }
    }
    UMAuthListener umAuthListener = new UMAuthListener() {
        /**
         * @desc 授权开始的回调
         * @param platform 平台名称
         */
        @Override
        public void onStart(SHARE_MEDIA platform) {

        }

        /**
         * @desc 授权成功的回调
         * @param platform 平台名称
         * @param action 行为序号，开发者用不上
         * @param data 用户资料返回
         */
        @Override
        public void onComplete(SHARE_MEDIA platform, int action, Map<String, String> data) {

            Toast.makeText(SignActivity.this, "成功了", Toast.LENGTH_LONG).show();
            Log.e("map",data+"");
        }


        /**
         * @desc 授权失败的回调
         * @param platform 平台名称
         * @param action 行为序号，开发者用不上
         * @param t 错误原因
         */
        @Override
        public void onError(SHARE_MEDIA platform, int action, Throwable t) {

            Toast.makeText(SignActivity.this, "失败：" + t.getMessage(), Toast.LENGTH_LONG).show();
        }

        /**
         * @desc 授权取消的回调
         * @param platform 平台名称
         * @param action 行为序号，开发者用不上
         */
        @Override
        public void onCancel(SHARE_MEDIA platform, int action) {

            Toast.makeText(SignActivity.this, "取消了", Toast.LENGTH_LONG).show();
        }
    };
}
