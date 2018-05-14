package com.example.dell.univstarproject.start.presenter;

import com.example.dell.univstarproject.base.BasePresenter;
import com.example.dell.univstarproject.start.model.bean.ForeBean;


/**
 * 作者:天南地北，旺哥最美！
 * 微信:xw15227039901
 */

public interface ForeContrcat {
    public interface ForeView {
        void showbean(ForeBean foreBean);
    }
    public interface ForePre extends BasePresenter<ForeView> {
        void loadforedata();
    }
}
