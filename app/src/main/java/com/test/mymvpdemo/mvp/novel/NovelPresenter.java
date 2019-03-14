package com.test.mymvpdemo.mvp.novel;

import com.test.mymvpdemo.bean.NovelBean;
import com.test.mymvpdemo.mvp.BaseCallback;
import com.test.mymvpdemo.mvp.BasePresenter;
import com.test.mymvpdemo.mvp.DataView;

import java.util.List;

public class NovelPresenter extends BasePresenter<DataView<List<NovelBean>>> {

    /**
     * 获取网络数据
     */
    public void getData() {
        //显示正在加载进度条
        if (isViewAttached()) {
            mView.showLoading();
        }
        // 调用Model请求数据
        NovelModel.novelData(new BaseCallback<List<NovelBean>>() {
            @Override
            public void onSuccess(List<NovelBean> novelBeans) {
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
