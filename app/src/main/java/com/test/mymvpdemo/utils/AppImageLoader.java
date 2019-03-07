package com.test.mymvpdemo.utils;

import android.app.Activity;
import android.text.TextUtils;
import android.widget.ImageView;

import com.test.mymvpdemo.base.GlideApp;

import java.lang.ref.WeakReference;

public class AppImageLoader {

    public static void loadImg(Activity act,String url, ImageView iv) {
        if (!TextUtils.isEmpty(url)) {
            GlideApp.with(new WeakReference<>(act).get()).load(url).into(iv);
        }
    }

}
