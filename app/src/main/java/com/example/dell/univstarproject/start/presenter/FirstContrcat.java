package com.example.dell.univstarproject.start.presenter;

import com.example.dell.univstarproject.base.BasePresenter;
import com.example.dell.univstarproject.start.model.bean.FirstBean;


/**
 * 作者:天南地北，旺哥最美！
 * 微信:xw15227039901
 */

public interface FirstContrcat {
    public interface FirstView {
        void showdata(FirstBean firstBean);
    }
    public interface FirstPre extends BasePresenter<FirstView> {
        void  loadfirstdata();
    }
}
