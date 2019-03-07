package com.test.mymvpdemo.mvp.novel;

import com.test.mymvpdemo.base.ApiService;
import com.test.mymvpdemo.base.HttpResult;
import com.test.mymvpdemo.base.ResponseSubscriber;
import com.test.mymvpdemo.base.RetrofitManager;
import com.test.mymvpdemo.bean.JournalismBean;
import com.test.mymvpdemo.mvp.BaseCallback;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Action;
import io.reactivex.schedulers.Schedulers;

class JournalismModel {

    static void journalismData(final BaseCallback<JournalismBean> callback) {
        RetrofitManager.getService(ApiService.class).journalismApi()
                .doFinally(new Action() {
                    @Override
                    public void run() {
                        callback.onComplete();
                    }
                })
                .observeOn(AndroidSchedulers.mainThread()).subscribeOn(Schedulers.io())
                .subscribe(new ResponseSubscriber<HttpResult<JournalismBean>>(callback) {
                    @Override
                    public void onSuccess(HttpResult<JournalismBean> httpResult) {
                        if (httpResult.getCode() == 200) {
                            callback.onSuccess(httpResult.getData());
                        } else {
                            callback.onFail(httpResult.getMsg());
                        }
                    }
                });
    }

}
