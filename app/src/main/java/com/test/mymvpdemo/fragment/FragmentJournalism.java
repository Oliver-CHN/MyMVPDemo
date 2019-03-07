package com.test.mymvpdemo.fragment;

import android.os.Bundle;
import android.os.Parcelable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.test.mymvpdemo.R;
import com.test.mymvpdemo.adapter.TechAdapter;
import com.test.mymvpdemo.base.BaseFragment;
import com.test.mymvpdemo.bean.JournalismBean;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

public class FragmentJournalism extends BaseFragment {

    @BindView(R.id.rv_layout)
    RecyclerView recyclerView;

    @Override
    protected int setContentView() {
        return R.layout.layout_rv;
    }

    @Override
    protected void init() {
        List<JournalismBean.ChildData> listData = null;
        if (getArguments() != null) {
            listData = getArguments().getParcelableArrayList("data");
        }
        recyclerView.setLayoutManager(new LinearLayoutManager(activity));
        TechAdapter adapter = new TechAdapter(activity, listData);
        recyclerView.setAdapter(adapter);
    }

    @Override
    protected boolean isOpenLoadSir() {
        return false;
    }

    public static FragmentJournalism newInstance(List<JournalismBean.ChildData> data) {
        FragmentJournalism fragment = new FragmentJournalism();
        Bundle bundle = new Bundle();
        bundle.putParcelableArrayList("data", (ArrayList<? extends Parcelable>) data);
        fragment.setArguments(bundle);
        return fragment;
    }

}
