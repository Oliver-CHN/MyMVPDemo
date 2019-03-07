package com.test.mymvpdemo.mvp;

/**
 * 通用UI回调，用于UI操作
 */
public interface BaseView {

    /**
     * 显示正在加载进度框
     */
    void showLoading();

    /**
     * 隐藏正在加载进度框
     */
    void hideLoading();

}
