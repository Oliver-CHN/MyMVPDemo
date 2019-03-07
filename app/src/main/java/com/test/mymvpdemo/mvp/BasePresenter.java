package com.test.mymvpdemo.mvp;

public class BasePresenter<V extends BaseView> {

    // View接口
    protected V mView;

    public void attachView(V mView) {
        this.mView = mView;
    }

    public void detachView() {
        this.mView = null;
    }

    protected boolean isViewAttached() {
        return mView != null;
    }
}
