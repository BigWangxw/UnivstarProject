package com.example.dell.univstarproject.presenter;

import com.example.dell.univstarproject.base.BasePresenter;
import com.example.dell.univstarproject.model.bean.DemoFirstBean;
import com.example.dell.univstarproject.model.bean.NewstBean;

/**
 * 作者:天南地北，旺哥最美！
 * 微信:xw15227039901
 */

public interface NewtContrcat {
    public interface NewsView{
        void showDemodata(NewstBean newstBean);
        void showErrorMessage(String msg);
    }
    public interface NewsPre extends BasePresenter<NewsView> {
        void loaddata();
    }
}
