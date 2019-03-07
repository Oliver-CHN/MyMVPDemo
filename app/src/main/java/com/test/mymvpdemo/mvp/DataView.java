package com.test.mymvpdemo.mvp;

public interface DataView<T> extends BaseView {

    /**
     * 当数据请求成功后，调用此接口显示数据
     */
    void showData(T t);

    /**
     * 当数据请求失败后，调用此接口提示
     */
    void showFailureMessage(String msg);

    /**
     * 当数据请求异常，调用此接口提示
     */
    void showErrorMessage(String msg);
}
