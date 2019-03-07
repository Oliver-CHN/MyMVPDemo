package com.test.mymvpdemo.mvp.novel;

import com.test.mymvpdemo.base.ApiService;
import com.test.mymvpdemo.base.HttpResult;
import com.test.mymvpdemo.base.ResponseSubscriber;
import com.test.mymvpdemo.base.RetrofitManager;
import com.test.mymvpdemo.bean.ImageBean;
import com.test.mymvpdemo.mvp.BaseCallback;

import java.util.List;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Action;
import io.reactivex.schedulers.Schedulers;

class ImageModel {

    static void meitu(final BaseCallback<List<ImageBean>> callback) {
        RetrofitManager.getService(ApiService.class).meituApi()
                .doFinally(new Action() {
                    @Override
                    public void run() {
                        callback.onComplete();
                    }
                })
                .observeOn(AndroidSchedulers.mainThread()).subscribeOn(Schedulers.io())
                .subscribe(new ResponseSubscriber<HttpResult<List<ImageBean>>>(callback) {
                    @Override
                    public void onSuccess(HttpResult<List<ImageBean>> httpResult) {
                        if (httpResult.getCode() == 200) {
                            callback.onSuccess(httpResult.getData());
                        } else {
                            callback.onFail(httpResult.getMsg());
                        }
                    }
                });
    }

}
