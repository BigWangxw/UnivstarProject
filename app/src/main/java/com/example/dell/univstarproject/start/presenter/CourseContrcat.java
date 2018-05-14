package com.example.dell.univstarproject.start.presenter;

import com.example.dell.univstarproject.base.BasePresenter;
import com.example.dell.univstarproject.start.model.bean.Course;


/**
 * 作者:天南地北，旺哥最美！
 * 微信:xw15227039901
 */

public interface CourseContrcat {
    public interface CourseView {
        void showcourse(Course course);
    }
    public interface CoursePre extends BasePresenter<CourseView> {
        void loaddata();
    }

}
