package com.example.dell.univstarproject.view.fragment;


import android.content.Intent;
import android.support.v4.app.Fragment;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioGroup;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.RequestManager;
import com.example.dell.univstarproject.R;
import com.example.dell.univstarproject.base.BaseFragment;
import com.example.dell.univstarproject.model.http.ShapeUtils;
import com.example.dell.univstarproject.sign.activity.ConcernActivity;
import com.example.dell.univstarproject.sign.activity.FollowerActivity;
import com.example.dell.univstarproject.sign.activity.GlideCircleTransform;
import com.example.dell.univstarproject.sign.activity.OrderActivity;
import com.example.dell.univstarproject.sign.activity.PayActivity;
import com.example.dell.univstarproject.sign.activity.PostActivity;
import com.example.dell.univstarproject.sign.activity.PreferenceActivity;
import com.example.dell.univstarproject.sign.activity.RenZhengActivity;
import com.example.dell.univstarproject.sign.activity.SetActivity;
import com.example.dell.univstarproject.sign.activity.WorksActivity;
import com.example.dell.univstarproject.sign.activity.collect.CollectActivity;
import com.example.dell.univstarproject.sign.entry.Fans;
import com.example.dell.univstarproject.sign.entry.GuanZhu;
import com.example.dell.univstarproject.sign.message.MessageActivity;
import com.example.dell.univstarproject.sign.personal.PersonalActivity;
import com.example.dell.univstarproject.sign.prisenter.Concernprisenter;
import com.example.dell.univstarproject.sign.prisenter.Followprisenter;
import com.example.dell.univstarproject.sign.prisenter.IConcernprisenter;
import com.example.dell.univstarproject.sign.prisenter.IFollowprisenter;
import com.example.dell.univstarproject.sign.signview.ConcernView;
import com.example.dell.univstarproject.sign.signview.FollowerView;
import com.example.dell.univstarproject.sign.signview.SignActivity;
import com.example.dell.univstarproject.sign.signview.ZhuceActivity;

import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class PersongeFragment extends BaseFragment implements View.OnClickListener,ConcernView,FollowerView{


    private ImageButton start_icon;
    private ImageButton start_set;
    private ImageButton start_info;
    private Button my_sign;
    private Button my_zhuce;
    private LinearLayout Sign_qian;

    //登录后
    private ImageButton sign_success_icon;
    private TextView sign_success_name;
    private Button sign_success_info_Btn;
    private ImageButton sign_success_set;
    private ImageButton sign_success_message;
    private TextView zuopin_count;
    private Button sign_success_zuoping;
    private TextView tiezi_count;
    private Button sign_success_tiezi;
    private TextView guanzhu_count;
    private Button sign_success_guanzhu;
    private TextView fensi_count;
    private Button sign_success_fensi;
    private RadioGroup sign_success_List;
    private Button chongzhizhongxin;
    private ImageView imageView2;
    private ImageButton imageButton2;
    private Button liwuzhongxin;
    private Button my_shoucang;
    private Button my_pianhao;
    private Button my_renzheng;
    private LinearLayout sign_hou;

    private LinearLayout sign_qian;

    private TextView textView;
    private TextView textView2;
    private String mobile;
    private int id;
    private RequestManager glideRequest;
    private IConcernprisenter concernprisenter;

    private IFollowprisenter followprisenter;


    @Override
    protected int getLayoutid() {
        return R.layout.fragment_personage;
    }

    @Override
    protected void initView() {
        textView2=getView().findViewById(R.id.baga);
        start_icon=getView().findViewById(R.id.start_icon);
        start_info=getView().findViewById(R.id.start_info);
        start_set=getView().findViewById(R.id.start_set);
        my_sign=getView().findViewById(R.id.my_sign);
        my_zhuce=getView().findViewById(R.id.my_zhuce);
        start_icon.setOnClickListener(this);
        start_info.setOnClickListener(this);
        start_set.setOnClickListener(this);
        my_sign.setOnClickListener(this);
        my_zhuce.setOnClickListener(this);
        sign_qian=getView().findViewById(R.id.sign_qian);

        //登录后
        sign_hou=getView().findViewById(R.id.sign_hou);
        sign_success_icon=getView().findViewById(R.id.sign_success_icon);//头像
        sign_success_icon.setOnClickListener(this);

        sign_success_name=getView().findViewById(R.id.sign_success_name);//昵称

        sign_success_info_Btn=getView().findViewById(R.id.sign_success_info_Btn);//我的信息
        sign_success_info_Btn.setOnClickListener(this);

        sign_success_set=getView().findViewById(R.id.sign_success_set);//设置
        sign_success_set.setOnClickListener(this);

        sign_success_zuoping=getView().findViewById(R.id.sign_success_zuoping);//作品
        sign_success_zuoping.setOnClickListener(this);
        zuopin_count=getView().findViewById(R.id.zuopin_count);//作品数量

        sign_success_tiezi=getView().findViewById(R.id.sign_success_tiezi);//贴子
        sign_success_tiezi.setOnClickListener(this);
        tiezi_count=getView().findViewById(R.id.tiezi_count);//贴子数量

        sign_success_guanzhu=getView().findViewById(R.id.sign_success_guanzhu);
        sign_success_guanzhu.setOnClickListener(this);
        guanzhu_count=getView().findViewById(R.id.guanzhu_count);


        sign_success_fensi=getView().findViewById(R.id.sign_success_fensi);
        sign_success_fensi.setOnClickListener(this);
        fensi_count=getView().findViewById(R.id.fensi_count);

        sign_success_List=getView().findViewById(R.id.sign_success_List);
        sign_success_List.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId){
                    case R.id.daifukuan://待付款
                        Intent intent = new Intent(getContext(),OrderActivity.class);
                        startActivity(intent);
                        break;
                    case R.id.daishiyong://待使用
                        Intent intent1 = new Intent(getContext(),OrderActivity.class);
                        startActivity(intent1);
                        break;
                    case R.id.daituihuo://待退货
                        Intent intent2 = new Intent(getContext(),OrderActivity.class);
                        startActivity(intent2);
                        break;
                    case R.id.wodedingdang://我的订单
                        Intent intent3 = new Intent(getContext(),OrderActivity.class);
                        startActivity(intent3);
                        break;
                }
            }
        });

        chongzhizhongxin=getView().findViewById(R.id.chongzhizhongxin);
        chongzhizhongxin.setOnClickListener(this);

        liwuzhongxin=getView().findViewById(R.id.liwuzhongxin);
        liwuzhongxin.setOnClickListener(this);

        my_shoucang=getView().findViewById(R.id.my_shoucang);
        my_shoucang.setOnClickListener(this);

        my_pianhao=getView().findViewById(R.id.my_pianhao);
        my_pianhao.setOnClickListener(this);

        my_renzheng=getView().findViewById(R.id.my_renzheng);
        my_renzheng.setOnClickListener(this);
        textView=getView().findViewById(R.id.shoujihao);

        sign_success_message=getView().findViewById(R.id.sign_success_message);
        sign_success_message.setOnClickListener(this);

        if (ShapeUtils.getIntance().getId() != 0){
            sign_qian.setVisibility(View.VISIBLE);
            sign_hou.setVisibility(View.GONE);
        }else {
            sign_hou.setVisibility(View.VISIBLE);
            sign_qian.setVisibility(View.GONE);
            String getphoto = ShapeUtils.getIntance().getphoto();
            glideRequest = Glide.with(this);
            glideRequest.load(getphoto).transform(new GlideCircleTransform(getContext())).into(sign_success_icon);
            sign_success_name.setText(ShapeUtils.getIntance().getName());
        }
    }

    @Override
    protected void loaddata() {

    }

    @Override
    protected void onHidden() {

    }

    @Override
    protected void onShow() {

    }

    @Override
    public void setTitle() {

    }
    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.start_icon:
                Intent intent2 = new Intent(getContext(), SignActivity.class);
                startActivity(intent2);
                break;
            case R.id.start_info:
                Intent intent3= new Intent(getContext(), SignActivity.class);
                startActivity(intent3);
                break;
            case R.id.start_set:
                Intent intent4 = new Intent(getContext(), SignActivity.class);
                startActivityForResult(intent4,123);
                break;
            case R.id.my_sign:
                Intent intent1 = new Intent(getContext(), SignActivity.class);
                startActivityForResult(intent1,10);
                break;
            case R.id.my_zhuce:
                Intent intent = new Intent(getContext(), ZhuceActivity.class);
                startActivity(intent);
                break;
            //登录后
            case R.id.sign_success_icon://头像
                break;
            case R.id.sign_success_info_Btn://我的信息
                Intent intent9 = new Intent(getContext(), PersonalActivity.class);
                startActivityForResult(intent9,222);
                break;
            case R.id.sign_success_set://设置
                Intent intent12 = new Intent(getContext(), SetActivity.class);
                intent12.putExtra("id",id);
                intent12.putExtra("phone",mobile);
                startActivityForResult(intent12,77);
                break;
            case R.id.sign_success_zuoping://作品
                Intent intent11 = new Intent(getContext(), WorksActivity.class);
                startActivity(intent11);
                break;
            case R.id.sign_success_tiezi://贴子
                Intent intent22 = new Intent(getContext(), PostActivity.class);
                startActivity(intent22);
                break;
            case R.id.sign_success_guanzhu://关注
                Intent intent5 = new Intent(getContext(), ConcernActivity.class);
                intent5.putExtra("id",id);
                startActivityForResult(intent5,333);
                break;
            case R.id.sign_success_fensi://粉丝
                Intent intent6 = new Intent(getContext(), FollowerActivity.class);
                startActivity(intent6);
                break;
            case R.id.chongzhizhongxin://充值中心
                String s = textView.getText().toString();
                Intent intent7 = new Intent(getContext(), PayActivity.class);
                intent7.putExtra("shoujihao",s);
                startActivity(intent7);
                break;
            case R.id.liwuzhongxin://礼物中心
                break;
            case R.id.my_shoucang://我的收藏
                Intent intent14 = new Intent(getContext(), CollectActivity.class);
                intent14.putExtra("id",id);
                startActivityForResult(intent14,333);
                break;
            case R.id.my_pianhao://我的偏好
                String s1 = textView2.getText().toString();
                Intent intent10 = new Intent(getContext(), PreferenceActivity.class);
                intent10.putExtra("id",s1);
                startActivity(intent10);
                break;
            case R.id.my_renzheng://我要认证
                Intent intent8 = new Intent(getContext(), RenZhengActivity.class);
                startActivity(intent8);
                break;
            case R.id.sign_success_message://消息提醒
                Intent intent13 = new Intent(getContext(), MessageActivity.class);
                intent13.putExtra("idd",id);
                startActivity(intent13);
                break;
        }
    }
    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode==10&&resultCode==10){
            String name = data.getStringExtra("nicname");
            mobile = data.getStringExtra("mobile");
            String photo = data.getStringExtra("photo");
            id = data.getIntExtra("id", 0);
            concernprisenter=new Concernprisenter(this);
            concernprisenter.loadCon(id);
            followprisenter=new Followprisenter(this);
            followprisenter.loadFoller(id);
            ShapeUtils.getIntance().insertId(id);
            ShapeUtils.getIntance().inserName(name);
            ShapeUtils.getIntance().inserphoto(photo);
            glideRequest = Glide.with(this);
            glideRequest.load(photo).transform(new GlideCircleTransform(getContext())).into(sign_success_icon);
            sign_success_name.setText(name);
            textView.setText(mobile);
            sign_qian.setVisibility(View.GONE);
            sign_hou.setVisibility(View.VISIBLE);
        }
        if (requestCode==77&&resultCode==77){
            sign_qian.setVisibility(View.VISIBLE);
            sign_hou.setVisibility(View.GONE);
            ShapeUtils.getIntance().clear();
        }
        if (requestCode==88&&resultCode==88){


        }
        if (requestCode==111&&requestCode==111){


        }
        if (requestCode==222&&resultCode==222){

            ShapeUtils.getIntance().clear();
            String photo = data.getStringExtra("photo");
            glideRequest = Glide.with(this);
            glideRequest.load(photo).transform(new GlideCircleTransform(getContext())).into(sign_success_icon);
            String name = data.getStringExtra("name");
            sign_success_name.setText(name);
            ShapeUtils.getIntance().inserphoto(photo);
            ShapeUtils.getIntance().inserName(name);
        }
        if (requestCode==333&&resultCode==333){

        }
        if (requestCode==123&&resultCode==123){
            sign_qian.setVisibility(View.GONE);
            sign_hou.setVisibility(View.VISIBLE);
        }
    }
    @Override
    public void showCon(GuanZhu guanZhu) {


        guanzhu_count.setText(guanZhu.getData().getSize()+"");
    }

    @Override
    public void show(List<Fans.DataBean.ListBean> listBean) {


        fensi_count.setText(listBean.size()+"");
    }
}
