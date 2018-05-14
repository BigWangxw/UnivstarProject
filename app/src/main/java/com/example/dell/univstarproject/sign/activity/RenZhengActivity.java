package com.example.dell.univstarproject.sign.activity;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.dell.univstarproject.R;
import com.example.dell.univstarproject.sign.signview.SignActivity;
import com.googlecode.tesseract.android.TessBaseAPI;

import java.io.File;
import java.io.FileOutputStream;
import java.text.SimpleDateFormat;
import java.util.Date;

public class RenZhengActivity extends AppCompatActivity implements View.OnClickListener {

    private ImageButton renzheng_back;
    private ImageView renzheng_v;
    private TextView renzheng_vv;
    private EditText renzheng_name;
    private EditText renzheng_lingyu;
    private EditText renzheng_jieshao;
    private RelativeLayout renzheng_card;
    private ImageView imageView10;
    private RelativeLayout relativeLayout;
    Bitmap photo;
    String picPath;
    private TextView textView;
    private Button tijiao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ren_zheng);
        initView();
    }

    private void initView() {
        renzheng_back = (ImageButton) findViewById(R.id.renzheng_back);
        renzheng_v = (ImageView) findViewById(R.id.renzheng_v);
        renzheng_vv = (TextView) findViewById(R.id.renzheng_vv);
        renzheng_name = (EditText) findViewById(R.id.renzheng_name);
        renzheng_lingyu = (EditText) findViewById(R.id.renzheng_lingyu);
        renzheng_jieshao = (EditText) findViewById(R.id.renzheng_jieshao);
        renzheng_card = (RelativeLayout) findViewById(R.id.renzheng_card);
        textView=findViewById(R.id.card_id);
        tijiao=findViewById(R.id.button_tijiao);
        tijiao.setOnClickListener(this);
        renzheng_back.setOnClickListener(this);
        renzheng_card.setOnClickListener(this);
        imageView10=findViewById(R.id.imageView10);
        relativeLayout=findViewById(R.id.hahaha);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.renzheng_back:
                Intent intent = new Intent(this, SignActivity.class);
                startActivity(intent);
                break;
            case R.id.renzheng_card:
                new AlertDialog.Builder(this)
                        .setTitle("请选择")
                        .setPositiveButton("去拍照", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                String state = Environment.getExternalStorageState();// 获取内存卡可用状态
                                if (state.equals(Environment.MEDIA_MOUNTED)) {
// 内存卡状态可用
                                    Intent intent = new Intent("android.media.action.IMAGE_CAPTURE");
                                    startActivityForResult(intent, 1);
                                } else {
                                    Toast.makeText(RenZhengActivity.this, "内存卡不可用", Toast.LENGTH_SHORT).show();
                                }
                            }
                        })
                        .setNegativeButton("打开相册", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                Intent i = new Intent(
                                        Intent.ACTION_PICK,
                                        android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
// 设定结果返回
                                startActivityForResult(i, 2);
                            }
                        }).create().show();
                break;
            case R.id.button_tijiao:
                localre();
                break;
        }
    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
// TODO Auto-generated method stub
        super.onActivityResult(requestCode, resultCode, data);
        if (data != null) {
            switch (requestCode) {
                case 1:
// 两种方式 获取拍好的图片
                    if (data.getData() != null || data.getExtras() != null) { // 防止没有返回结果
                        Uri uri = data.getData();
                        if (uri != null) {
                            this.photo = BitmapFactory.decodeFile(uri.getPath()); // 拿到图片
                        }
                        if (photo == null) {
                            Bundle bundle = data.getExtras();
                            if (bundle != null) {
                                photo = (Bitmap) bundle.get("data");
                                FileOutputStream fileOutputStream = null;
                                try {
// 获取 SD 卡根目录 生成图片并
                                    String saveDir = Environment
                                            .getExternalStorageDirectory()
                                            + "/dhj_Photos";
// 新建目录
                                    File dir = new File(saveDir);
                                    if (!dir.exists())
                                        dir.mkdir();
// 生成文件名
                                    SimpleDateFormat t = new SimpleDateFormat(
                                            "yyyyMMddssSSS");
                                    String filename = "MT" + (t.format(new Date()))
                                            + ".jpg";
// 新建文件
                                    File file = new File(saveDir, filename);
// 打开文件输出流
                                    fileOutputStream = new FileOutputStream(file);
// 生成图片文件
                                    this.photo.compress(Bitmap.CompressFormat.JPEG,
                                            100, fileOutputStream);
// 相片的完整路径
                                    this.picPath = file.getPath();
                                    imageView10.setImageBitmap(this.photo);
                                    localre();
                                    relativeLayout.setVisibility(View.GONE);
                                } catch (Exception e) {
                                    e.printStackTrace();
                                } finally {
                                    if (fileOutputStream != null) {
                                        try {
                                            fileOutputStream.close();
                                        } catch (Exception e) {
                                            e.printStackTrace();
                                        }
                                    }
                                }
                                Toast.makeText(getApplicationContext(), "获取到了",
                                        Toast.LENGTH_SHORT).show();
                            } else {
                                Toast.makeText(getApplicationContext(), "找不到图片",
                                        Toast.LENGTH_SHORT).show();
                            }
                        }
                    }
                    break;
                case 2: {
//打开相册并选择照片，这个方式选择单张
// 获取返回的数据，这里是android自定义的Uri地址
                    Uri selectedImage = data.getData();
                    String[] filePathColumn = { MediaStore.Images.Media.DATA };
// 获取选择照片的数据视图
                    Cursor cursor = getContentResolver().query(selectedImage,
                            filePathColumn, null, null, null);
                    cursor.moveToFirst();
// 从数据视图中获取已选择图片的路径
                    int columnIndex = cursor.getColumnIndex(filePathColumn[0]);
                    String picturePath = cursor.getString(columnIndex);
                    cursor.close();
// 将图片显示到界面上
                    imageView10.setImageBitmap(BitmapFactory.decodeFile(picturePath));
                    relativeLayout.setVisibility(View.GONE);
                    break;
                }
                default:
                    break;
            }
        }
    }
    //训练数据路径，tessdata
    static final String TESSBASE_PATH = Environment.getExternalStorageDirectory() + "/";
    //识别语言英文
    static final String DEFAULT_LANGUAGE = "eng";

    /**
     * 传SD卡图片路径（当然你们也可以传Bitmap）
     * @param
     */
    private void localre() {
        //把图片转为Bitmap
        Bitmap bmp = BitmapFactory.decodeFile(picPath);
        //创建Tess
        final TessBaseAPI baseApi = new TessBaseAPI();
        //下面这一块代码为裁取身份证号码区域（否则识别乱码，不准确）
        int x, y, w, h;
        x = (int) (bmp.getWidth() * 0.340);
        y = (int) (bmp.getHeight() * 0.800);
        w = (int) (bmp.getWidth() * 0.6 + 0.5f);
        h = (int) (bmp.getHeight() * 0.12 + 0.5f);
        Bitmap bit_hm = Bitmap.createBitmap(bmp, x, y, w, h);
        //初始化OCR的训练数据路径与语言
        baseApi.init(TESSBASE_PATH, DEFAULT_LANGUAGE);
        //设置识别模式
        baseApi.setPageSegMode(TessBaseAPI.PageSegMode.PSM_SINGLE_LINE);
        //设置要识别的图片
        baseApi.setImage(bit_hm);
        //设置字典白名单
        baseApi.setVariable("tessedit_char_whitelist", "0123456789Xx");
        //把识别内容设置到EditText里
        textView.setText(baseApi.getUTF8Text());
        //收尾
        baseApi.clear();
        baseApi.end();
    }
}
