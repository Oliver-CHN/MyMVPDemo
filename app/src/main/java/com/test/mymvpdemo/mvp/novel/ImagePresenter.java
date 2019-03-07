package com.test.mymvpdemo.mvp.novel;

import com.test.mymvpdemo.bean.ImageBean;
import com.test.mymvpdemo.mvp.BaseCallback;
import com.test.mymvpdemo.mvp.BasePresenter;
import com.test.mymvpdemo.mvp.DataView;

import java.util.List;

public class ImagePresenter extends BasePresenter<DataView<List<ImageBean>>> {

    /**
     * 获取网络数据
     */
    public void getData() {
        //显示正在加载进度条
        mView.showLoading();
        // 调用Model请求数据
        ImageModel.meitu(new BaseCallback<List<ImageBean>>() {
            @Override
            public void onSuccess(List<ImageBean> novelBeans) {
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
