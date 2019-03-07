package com.test.mymvpdemo.mvp.novel;

import com.test.mymvpdemo.bean.JournalismBean;
import com.test.mymvpdemo.mvp.BaseCallback;
import com.test.mymvpdemo.mvp.BasePresenter;
import com.test.mymvpdemo.mvp.DataView;

public class JournalismPresenter extends BasePresenter<DataView<JournalismBean>> {

    /**
     * 获取网络数据
     */
    public void getData() {
        //显示正在加载进度条
        if (isViewAttached()) {
            mView.showLoading();
        }
        // 调用Model请求数据
        JournalismModel.journalismData(new BaseCallback<JournalismBean>() {
            @Override
            public void onSuccess(JournalismBean novelBeans) {
                if (isViewAttached()) {
                    mView.showData(novelBeans);
                }
            }

            @Override
            public void onFail(String msg) {
                if (isViewAttached()) {
                    mView.showFailureMessage(msg);
                }
            }

            @Override
            public void onError(String msg) {
                if (isViewAttached()) {
                    mView.showErrorMessage(msg);
                }
            }

            @Override
            public void onComplete() {
                if (isViewAttached()) {
                    mView.hideLoading();
                }
            }
        });
    }

}
