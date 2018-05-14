package com.example.dell.univstarproject.start.presenter;


import com.example.dell.univstarproject.base.BasePresenter;
import com.example.dell.univstarproject.start.model.bean.DemoFirstBean;

/**
 * 作者:天南地北，旺哥最美！
 * 微信:xw15227039901
 */

public interface DemoContrcat {
    public interface DemoView{
        void showDemodata(DemoFirstBean demoBean);
    }
    public interface DemoPre extends BasePresenter<DemoView> {
        void loaddata();
    }
}
