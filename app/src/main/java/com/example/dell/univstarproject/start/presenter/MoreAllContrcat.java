package com.example.dell.univstarproject.start.presenter;


import com.example.dell.univstarproject.base.BasePresenter;
import com.example.dell.univstarproject.start.model.bean.BabyBean;

/**
 * 作者:天南地北，旺哥最美！
 * 微信:xw15227039901
 */

public interface MoreAllContrcat {
    public interface MoreaddView {
        void showdata(BabyBean babyBean);
        void showlinear(boolean yes);
    }
    public interface MoreAllPre extends BasePresenter<MoreaddView> {
        void loaddata(String page, String row, String sortord);
    }
}
