package com.test.mymvpdemo.adapter;

import android.app.Activity;
import android.support.annotation.Nullable;
import android.widget.ImageView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.test.mymvpdemo.R;
import com.test.mymvpdemo.bean.ImageBean;
import com.test.mymvpdemo.utils.AppImageLoader;

import java.util.List;

public class ImageAdapter extends BaseQuickAdapter<ImageBean, BaseViewHolder> {

    private Activity act;

    public ImageAdapter(Activity context, @Nullable List<ImageBean> data) {
        super(R.layout.item_image, data);
        this.act = context;
    }

    @Override
    protected void convert(BaseViewHolder helper, ImageBean item) {
        AppImageLoader.loadImg(act, item.url, (ImageView) helper.getView(R.id.item_image_iv));
    }
}
