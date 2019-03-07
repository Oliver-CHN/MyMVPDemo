package com.test.mymvpdemo.adapter;

import android.app.Activity;
import android.support.annotation.Nullable;
import android.widget.ImageView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.test.mymvpdemo.R;
import com.test.mymvpdemo.bean.NovelBean;
import com.test.mymvpdemo.utils.AppImageLoader;

import java.util.List;

public class NovelAdapter extends BaseQuickAdapter<NovelBean, BaseViewHolder> {

    private Activity act;

    public NovelAdapter(Activity context, @Nullable List<NovelBean> data) {
        super(R.layout.item_novel, data);
        this.act = context;
    }

    @Override
    protected void convert(BaseViewHolder helper, NovelBean item) {
        helper.setText(R.id.item_novel_title, item.bookname);
        helper.setText(R.id.item_novel_content, item.topic);
        AppImageLoader.loadImg(act, item.book_cover, (ImageView) helper.getView(R.id.item_novel_iv));
    }
}
