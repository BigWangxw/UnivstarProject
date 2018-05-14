package com.example.dell.univstarproject.start.presenter;


import com.example.dell.univstarproject.base.BasePresenter;
import com.example.dell.univstarproject.start.model.bean.LiveDetailModel;

/**
 * 作者:天南地北，旺哥最美！
 * 微信:xw15227039901
 */

public interface FurContrcat {
    public interface FurView {
        void showdata(LiveDetailModel model);
    }
    public interface FurPre extends BasePresenter<FurView> {
        void loaddata(Integer userid, int id);
    }
}
