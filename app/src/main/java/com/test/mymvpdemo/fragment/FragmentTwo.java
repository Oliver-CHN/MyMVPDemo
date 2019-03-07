package com.test.mymvpdemo.fragment;

import android.content.Context;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import com.test.mymvpdemo.R;
import com.test.mymvpdemo.adapter.NovelAdapter;
import com.test.mymvpdemo.base.BaseFragment;
import com.test.mymvpdemo.base.NetworkErrorCallback;
import com.test.mymvpdemo.bean.NovelBean;
import com.test.mymvpdemo.mvp.DataView;
import com.test.mymvpdemo.mvp.novel.NovelPresenter;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

public class FragmentTwo extends BaseFragment implements DataView<List<NovelBean>> {

    @BindView(R.id.rv_layout)
    RecyclerView recyclerView;

    private NovelAdapter adapter;

    private List<NovelBean> listData = new ArrayList<>();

    private NovelPresenter novelPresenter = new NovelPresenter();

    @Override
    protected int setContentView() {
        return R.layout.layout_rv;
    }

    @Override
    protected void init() {
        recyclerView.setLayoutManager(new LinearLayoutManager(activity));
        adapter = new NovelAdapter(activity, listData);
        recyclerView.setAdapter(adapter);
        // 数据
        novelPresenter.getData();
    }

    public static FragmentTwo newInstance() {
        return new FragmentTwo();
    }

    @Override
    public void showData(List<NovelBean> novelBeans) {
        loadService.showSuccess();
        if (listData != null) {
            listData.clear();
            listData.addAll(novelBeans);
        }
        adapter.notifyDataSetChanged();
    }

    @Override
    public void showFailureMessage(String msg) {
        Toast.makeText(activity, msg, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void showErrorMessage(String msg) {
        loadService.showCallback(NetworkErrorCallback.class);
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        novelPresenter.attachView(this);
    }

    @Override
    public void onDetach() {
        super.onDetach();
        novelPresenter.detachView();
    }

}
