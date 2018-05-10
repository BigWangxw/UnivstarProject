package com.example.dell.univstarproject.presenter;

import com.example.dell.univstarproject.base.BasePresenter;
import com.example.dell.univstarproject.model.bean.BabyBean;

/**
 * 作者:天南地北，旺哥最美！
 * 微信:xw15227039901
 */

public interface BabyContrcat {
    public interface BabyView{
        void showbaby(BabyBean babyBean);
    }
    public interface BabyPre extends BasePresenter<BabyView> {
        void loadbabydata();
    }
}
