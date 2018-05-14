package com.example.dell.univstarproject.start.presenter;

import com.example.dell.univstarproject.base.BasePresenter;
import com.example.dell.univstarproject.start.model.bean.ClassDetailed;


/**
 * 作者:天南地北，旺哥最美！
 * 微信:xw15227039901
 */

public interface DetailContrcat {
    public interface DetailView {
        void showDetailBean(ClassDetailed detailed);
    }
    public interface DetailPre extends BasePresenter<DetailView> {
        void loadDetailBean(Integer id);
        void loadDetailBean(String loginid, String id);
        void quxiaoguanzhu(String loginid, String id);
    }
}
