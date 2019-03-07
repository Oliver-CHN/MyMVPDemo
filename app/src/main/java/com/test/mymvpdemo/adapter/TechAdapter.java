package com.test.mymvpdemo.adapter;

import android.app.Activity;
import android.support.annotation.Nullable;
import android.widget.ImageView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.test.mymvpdemo.R;
import com.test.mymvpdemo.bean.JournalismBean;
import com.test.mymvpdemo.utils.AppImageLoader;

import java.util.List;

public class TechAdapter extends BaseQuickAdapter<JournalismBean.ChildData, BaseViewHolder> {

    private Activity act;

    public TechAdapter(Activity context, @Nullable List<JournalismBean.ChildData> data) {
        super(R.layout.item_journalism, data);
        this.act = context;
    }

    @Override
    protected void convert(BaseViewHolder helper, JournalismBean.ChildData item) {
        helper.setText(R.id.item_journalism_title, item.title);
        helper.setText(R.id.item_journalism_tag, item.tag);
        helper.setText(R.id.item_journalism_content, item.digest);
        if (item.picInfo != null && item.picInfo.size() > 0) {
            AppImageLoader.loadImg(act, item.picInfo.get(0).url, (ImageView) helper.getView(R.id.item_journalism_iv));
        }
    }
}
