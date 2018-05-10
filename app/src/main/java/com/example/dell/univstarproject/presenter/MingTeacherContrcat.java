package com.example.dell.univstarproject.presenter;

import com.example.dell.univstarproject.base.BasePresenter;
import com.example.dell.univstarproject.model.bean.MingTeacher;

/**
 * 作者:天南地北，旺哥最美！
 * 微信:xw15227039901
 */

public interface MingTeacherContrcat {
    public interface MingTeacherView{
        void showMingteacher(MingTeacher teacher);
    }
    public interface MingTeacherPre extends BasePresenter<MingTeacherView> {
        void loadMingTeacher();
        void loadMingTeacher(Integer page, Integer rows,Integer loginUserId, Integer usertype);
    }
}
