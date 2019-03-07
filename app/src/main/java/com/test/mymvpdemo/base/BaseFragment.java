package com.test.mymvpdemo.base;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.kingja.loadsir.core.LoadService;
import com.kingja.loadsir.core.LoadSir;
import com.test.mymvpdemo.mvp.BaseView;

import butterknife.ButterKnife;
import butterknife.Unbinder;

public abstract class BaseFragment extends Fragment implements BaseView {

    protected View rootView;

    protected Activity activity;

    private Unbinder unbinder;

    protected LoadService loadService;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        if (rootView != null) {
            ViewGroup parent = (ViewGroup) rootView.getParent();
            if (parent != null) {
                parent.removeView(rootView);
            }
        } else {
            rootView = inflater.inflate(setContentView(), container, false);
            unbinder = ButterKnife.bind(this, rootView);
            if (isOpenLoadSir()) {
                loadService = LoadSir.getDefault().register(rootView);
            }
            init();
        }
        if (loadService != null && loadService.getLoadLayout() != null) {
            return loadService.getLoadLayout();
        } else {
            return rootView;
        }
    }

    /**
     * 加载页面布局文件
     */
    protected abstract int setContentView();

    /**
     * 让布局中的view与fragment中的变量建立起映射
     */
    protected abstract void init();

    /**
     * 可以由子类复写，表示此Fragment是否添加无网络缺省页
     * true:添加 false:不添加
     */
    protected boolean isOpenLoadSir() {
        return true;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        activity = (Activity) context;
    }

    @Override
    public void onDetach() {
        super.onDetach();
        activity = null;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }

    @Override
    public void showLoading() {
        if (isOpenLoadSir()) {
            loadService.showCallback(LoadingCallback.class);
        }
    }

    @Override
    public void hideLoading() {

    }
}
