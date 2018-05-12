package com.example.dell.univstarproject.model.http;

import android.content.SharedPreferences;

import com.example.dell.univstarproject.base.BaseApp;

/**
 * Created by Administrator on 2018/5/9 0009.
 */

public class ShapeUtils {
    public static ShapeUtils shapeUtils;
    private final SharedPreferences.Editor edit;
    private final SharedPreferences shape;

    public ShapeUtils() {
        shape = BaseApp.activity.getSharedPreferences("name", 0);
        edit = shape.edit();
        edit.commit();
    }

    public static ShapeUtils getIntance(){
        if (shapeUtils == null){
            synchronized (ShapeUtils.class){
                if (shapeUtils == null){
                    shapeUtils = new ShapeUtils();
                }
            }
        }
        return shapeUtils;
    }
    public void insertId(int id){
        edit.putInt("id",id);
        edit.commit();
    }

    public int getId(){
        int id = shape.getInt("id", 0);
        return id;
    }

    public void clear(){
        edit.clear();
        edit.commit();
    }

    public void inserName(String name){
        edit.putString("name",name);
        edit.commit();
    }

    public String getName(){
        String name = shape.getString("name",null);
        return name;
    }
    public void inserphoto(String photo){
        edit.putString("photo",photo);
        edit.commit();
    }

    public String getphoto(){
        String photo = shape.getString("photo",null);
        return photo;
    }
}

