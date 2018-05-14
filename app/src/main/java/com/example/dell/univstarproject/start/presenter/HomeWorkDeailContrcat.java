package com.example.dell.univstarproject.start.presenter;


import com.example.dell.univstarproject.base.BasePresenter;
import com.example.dell.univstarproject.start.model.bean.ControllerBean;
import com.example.dell.univstarproject.start.model.bean.DeailBean;

/**
 * 作者:天南地北，旺哥最美！
 * 微信:xw15227039901
 */

public interface HomeWorkDeailContrcat {
    public interface HomeWorkDeailView{
        void showControllerBean(ControllerBean bean);
        void showDeailBean(DeailBean deailBean);
        void showwin(String msg);
    }
    public interface HomeWorkDeailPre extends BasePresenter<HomeWorkDeailView> {
        void loadControllerBean();
        void loadDeailBean(String id);
        void dianzandata(String id);
        void quxiao(String id);
    }
}
