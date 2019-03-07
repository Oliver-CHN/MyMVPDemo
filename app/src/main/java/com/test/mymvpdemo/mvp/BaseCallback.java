package com.test.mymvpdemo.mvp;

/**
 * 通用接口回调，用于访问接口后回调
 *
 * @param <T> 数据源
 */
public interface BaseCallback<T> {

    void onSuccess(T t);

    void onFail(String msg);

    void onError(String msg);

    void onComplete();

}
