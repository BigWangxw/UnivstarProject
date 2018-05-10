package com.example.dell.univstarproject.presenter;

import com.example.dell.univstarproject.base.BasePresenter;
import com.example.dell.univstarproject.model.bean.LiveBean;

/**
 * 作者:天南地北，旺哥最美！
 * 微信:xw15227039901
 */

public interface LiveContrcat {
    public interface LiveView{
        void showLiveBean(LiveBean liveBean);
    }
    public interface LivePre extends BasePresenter<LiveView> {
        void loadLiveBean();
    }
}
