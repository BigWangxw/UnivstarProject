package com.example.dell.univstarproject.sign.personal;

import android.app.AlertDialog;
import android.app.DatePickerDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.DatePicker;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.RequestManager;
import com.example.dell.univstarproject.R;
import com.example.dell.univstarproject.sign.activity.GlideCircleTransform;

import java.util.Calendar;

public class PersonalActivity extends AppCompatActivity implements View.OnClickListener {

    private ImageButton personal_back;
    private TextView textView3;
    private ImageView imageView16;
    private ImageView text_image;
    private RelativeLayout person_icon;
    private TextView text_name;
    private ImageView imageView15;
    private RelativeLayout person_name;
    private ImageView imageView14;
    private TextView text_sex;
    private RelativeLayout person_sex;
    private TextView textView4;
    private TextView text_region;
    private ImageView imageView13;
    private RelativeLayout person_region;
    private TextView text_birthday;
    private ImageView imageView12;
    private RelativeLayout person_birthday;

    private RequestManager glideRequest;
    private String picturePath;
    private String name;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_personal);
        initView();
    }

    private void initView() {
        personal_back = (ImageButton) findViewById(R.id.personal_back);
        textView3 = (TextView) findViewById(R.id.textView3);
        imageView16 = (ImageView) findViewById(R.id.imageView16);
        text_image = (ImageView) findViewById(R.id.text_image);
        person_icon = (RelativeLayout) findViewById(R.id.person_icon);
        text_name = (TextView) findViewById(R.id.text_name);
        imageView15 = (ImageView) findViewById(R.id.imageView15);
        person_name = (RelativeLayout) findViewById(R.id.person_name);
        imageView14 = (ImageView) findViewById(R.id.imageView14);
        text_sex = (TextView) findViewById(R.id.text_sex);
        person_sex = (RelativeLayout) findViewById(R.id.person_sex);
        textView4 = (TextView) findViewById(R.id.textView4);
        text_region = (TextView) findViewById(R.id.text_region);
        imageView13 = (ImageView) findViewById(R.id.imageView13);
        person_region = (RelativeLayout) findViewById(R.id.person_region);
        text_birthday = (TextView) findViewById(R.id.text_birthday);
        imageView12 = (ImageView) findViewById(R.id.imageView12);
        person_birthday = (RelativeLayout) findViewById(R.id.person_birthday);

        personal_back.setOnClickListener(this);
        person_icon.setOnClickListener(this);
        person_name.setOnClickListener(this);
        person_sex.setOnClickListener(this);
        person_region.setOnClickListener(this);
        person_birthday.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.personal_back:
                Intent intent2 = getIntent();
                intent2.putExtra("photo",picturePath);
                intent2.putExtra("name",name);
                setResult(222,intent2);
                finish();
                break;
            case R.id.person_icon://头像
                // 打开本地相册
                Intent i = new Intent(
                        Intent.ACTION_PICK,
                        android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
// 设定结果返回
                startActivityForResult(i, 2);
                break;
            case R.id.person_name://昵称
                Intent intent = new Intent(this,NameActivity.class);
                startActivityForResult(intent,20);
                break;
            case R.id.person_sex://性别
                new AlertDialog.Builder(this)
                        .setTitle("请选择性别")
                        .setPositiveButton("男", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                text_sex.setText("男");
                            }
                        })
                        .setNegativeButton("女", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                text_sex.setText("女");
                            }
                        })
                        .create().show();
                break;
            case R.id.person_region://地区
                Intent intent1 = new Intent(this,RegionActivity.class);
                startActivityForResult(intent1,30);
                break;
            case R.id.person_birthday://生日
                Calendar c=Calendar.getInstance();
                        //直接创建一个DatePickerDialog对话框实例，并显示出来
                         new DatePickerDialog(this,
                                    //绑定监听器
                                    new DatePickerDialog.OnDateSetListener() {
                      @Override
                      public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                          String text = year + "-" + (month + 1)
                                  + "-" + dayOfMonth;
                          text_birthday.setText(text);
        }
    }//设置初始日期
                          ,c.get(Calendar.YEAR)
                          ,c.get(Calendar.MONTH)
                          ,c.get(Calendar.DAY_OF_MONTH)).show();
                break;
        }
    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
// TODO Auto-generated method stub
        super.onActivityResult(requestCode, resultCode, data);
        if (data != null) {
            switch (requestCode) {
                case 2: {
//打开相册并选择照片，这个方式选择单张
// 获取返回的数据，这里是android自定义的Uri地址
                    Uri selectedImage = data.getData();
                    String[] filePathColumn = {MediaStore.Images.Media.DATA};
// 获取选择照片的数据视图
                    Cursor cursor = getContentResolver().query(selectedImage,
                            filePathColumn, null, null, null);
                    cursor.moveToFirst();
// 从数据视图中获取已选择图片的路径
                    int columnIndex = cursor.getColumnIndex(filePathColumn[0]);
                    picturePath = cursor.getString(columnIndex);
                    cursor.close();
// 将图片显示到界面上
                    glideRequest = Glide.with(this);
                    glideRequest.load(picturePath).transform(new GlideCircleTransform(this)).into(text_image);
                    text_image.setVisibility(View.VISIBLE);
                    break;
                }
                default:
                    break;
            }
        }
        if (requestCode==20&&resultCode==20){
            name = data.getStringExtra("name");
            text_name.setText(name);
        }
        if (requestCode==30&&resultCode==30){
            String region = data.getStringExtra("region");
            text_region.setText(region);
        }
    }
}
