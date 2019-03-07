package com.test.mymvpdemo.mvp.novel;

import com.test.mymvpdemo.base.ApiService;
import com.test.mymvpdemo.base.HttpResult;
import com.test.mymvpdemo.base.ResponseSubscriber;
import com.test.mymvpdemo.base.RetrofitManager;
import com.test.mymvpdemo.bean.NovelBean;
import com.test.mymvpdemo.mvp.BaseCallback;

import java.util.List;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Action;
import io.reactivex.schedulers.Schedulers;

class NovelModel {

    static void novelData(final BaseCallback<List<NovelBean>> callback) {
        RetrofitManager.getService(ApiService.class).novelApi()
                .doFinally(new Action() {
                    @Override
                    public void run() {
                        callback.onComplete();
                    }
                })
                .observeOn(AndroidSchedulers.mainThread()).subscribeOn(Schedulers.io())
                .subscribe(new ResponseSubscriber<HttpResult<List<NovelBean>>>(callback) {
                    @Override
                    public void onSuccess(HttpResult<List<NovelBean>> httpResult) {
                        if (httpResult.getCode() == 200) {
                            callback.onSuccess(httpResult.getData());
                        } else {
                            callback.onFail(httpResult.getMsg());
                        }
                    }
                });
    }

}
