package com.example.dell.univstarproject.start.model.bean;

import android.content.Context;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.youth.banner.loader.ImageLoader;

public class PisicImage extends ImageLoader {
        @Override
        public void displayImage(Context context, Object path, ImageView imageView) {
           Glide.with(context).load((String)path).into(imageView);
        }
    }