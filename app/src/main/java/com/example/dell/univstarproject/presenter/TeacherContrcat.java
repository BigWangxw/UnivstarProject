package com.example.dell.univstarproject.presenter;

import com.example.dell.univstarproject.base.BasePresenter;
import com.example.dell.univstarproject.model.bean.Quxiao;
import com.example.dell.univstarproject.model.bean.Teacher;
import com.example.dell.univstarproject.model.bean.ZanClick;

/**
 * 作者:天南地北，旺哥最美！
 * 微信:xw15227039901
 */

public interface TeacherContrcat {
    public interface TeacherView {
        void showTeacherBean(Teacher teacher);
        void showdianzan(String zanClick);
        void showquxiao(String quxiao);
    }
    public interface TeacherPre extends BasePresenter<TeacherView> {
        void loadTeachenBean(Integer teaid);
        void dianzan(Integer userId,String id,String loginUserId,String type);
        void quxiao(Integer userId,String id,String loginUserId,String type);
    }
}
