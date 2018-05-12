package com.example.dell.univstarproject.sign.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.dell.univstarproject.R;
import com.example.dell.univstarproject.sign.signview.FindActivity;
import com.example.dell.univstarproject.view.fragment.PersongeFragment;

public class SetActivity extends AppCompatActivity implements View.OnClickListener {

    private ImageButton set_back;
    private TextView shoujihao;
    private ImageView imageView17;
    private RelativeLayout set_jiebang;
    private TextView shejiao;
    private ImageView imageView18;
    private RelativeLayout set_shejiao;
    private TextView mima;
    private ImageView imageView19;
    private RelativeLayout set_mima;
    private ImageView imageView20;
    private RelativeLayout set_qingchu;
    private TextView shengji;
    private ImageView imageView21;
    private RelativeLayout set_shenhji;
    private RelativeLayout set_tuichu;
    private ImageButton imageButton;
    private TextView textView;
    private String phone;
    private int id;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_set);
        textView= (TextView) findViewById(R.id.huancun);
        try {
            textView.setText(CacheUtil.getTotalCacheSize(this));
        } catch (Exception e) {
            e.printStackTrace();
        }
        Intent intent = getIntent();
        phone = intent.getStringExtra("mobile");
        id = intent.getIntExtra("id",0);
        Log.d("zz",phone+id);
        initView();
        shoujihao.setText(phone);
    }
    private void initView() {
        set_back = (ImageButton) findViewById(R.id.set_back);
        shoujihao = (TextView) findViewById(R.id.shoujihao);
        imageView17 = (ImageView) findViewById(R.id.imageView17);
        set_jiebang = (RelativeLayout) findViewById(R.id.set_jiebang);
        shejiao = (TextView) findViewById(R.id.shejiao);
        imageView18 = (ImageView) findViewById(R.id.imageView18);
        set_shejiao = (RelativeLayout) findViewById(R.id.set_shejiao);
        mima = (TextView) findViewById(R.id.mima);
        imageView19 = (ImageView) findViewById(R.id.imageView19);
        set_mima = (RelativeLayout) findViewById(R.id.set_mima);
        imageView20 = (ImageView) findViewById(R.id.imageView20);
        set_qingchu = (RelativeLayout) findViewById(R.id.set_qingchu);
        shengji = (TextView) findViewById(R.id.shengji);
        imageView21 = (ImageView) findViewById(R.id.imageView21);
        set_shenhji = (RelativeLayout) findViewById(R.id.set_shenhji);
        set_tuichu = (RelativeLayout) findViewById(R.id.set_tuichu);
        imageButton=findViewById(R.id.imagebuttonaa);
        textView=findViewById(R.id.huancun);

        set_back.setOnClickListener(this);
        set_jiebang.setOnClickListener(this);
        set_shejiao.setOnClickListener(this);
        set_mima.setOnClickListener(this);
        set_shenhji.setOnClickListener(this);
        set_tuichu.setOnClickListener(this);
        imageButton.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.set_back://返回
                Intent intent3 = new Intent(this, PersongeFragment.class);
                intent3.putExtra("sdcvsd","sfed");
                setResult(111,intent3);
                finish();
                break;
            case R.id.imagebuttonaa://清除缓存
                CacheUtil.clearAllCache(this);
                textView.setText("0.0K");
                Toast.makeText(this,"缓存已清理",Toast.LENGTH_SHORT).show();
                break;
            case R.id.set_jiebang://解绑
                Intent intent = new Intent(this, JiaohuanActivity.class);
                intent.putExtra("b",id);
                startActivity(intent);
                finish();
                break;
            case R.id.set_shejiao://社交
                break;
            case R.id.set_mima://修改密码
                Intent intent2 = new Intent(this, FindActivity.class);
                startActivity(intent2);
                finish();
                break;
            case R.id.set_shenhji://升级
                break;
            case R.id.set_tuichu://退出
                Intent intent1 = getIntent();
            intent1.putExtra("hah","gahha");
            setResult(77,intent1);
            finish();
                break;
        }
    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode==1&&resultCode==1){
            String haoma = data.getStringExtra("aaa");
            shoujihao.setText(haoma);
        }
    }
}
