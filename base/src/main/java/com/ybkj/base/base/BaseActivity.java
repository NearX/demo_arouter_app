package com.ybkj.base.base;

import android.app.Activity;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.trello.rxlifecycle2.components.support.RxAppCompatActivity;
import com.ybkj.base.R;
import com.ybkj.base.manager.ActivityManager;
import com.ybkj.base.manager.SystemManager;
import com.ybkj.base.utils.LogUtil;
import com.ybkj.base.utils.ResourcesUtil;
import com.ybkj.base.utils.ToastUtil;

import java.util.ArrayList;
import java.util.List;

import butterknife.ButterKnife;
import butterknife.Unbinder;
import io.reactivex.disposables.Disposable;

/**
 * - @Author:  Yi Shan Xiang
 * - @Description:  最基础Activity
 * - @Time:  2018/8/31
 * - @Emaill:  380948730@qq.com
 */
public abstract class BaseActivity extends RxAppCompatActivity implements View.OnClickListener {
    public List<Disposable> disposableList = new ArrayList<>();

    protected Activity mContext;
    private Unbinder unbinder;
    private View mNetErrorView;
    //无数据显示的view
    private View mNetEmptyView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mContext = this;
        setContentView(getLayoutId());
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

        if (isImmersiveStatusBar()) {
            SystemManager.setStatusBar(this, ResourcesUtil.getColor(immersiveStatusBarColor()));
        }

        //绑定控件注解
        unbinder = ButterKnife.bind(this);
        if (savedInstanceState != null) {
            initSavedInstanceState(savedInstanceState);
        }
        if (getIntent() != null) {
            initIntentData(getIntent());
        }
        initView();
        initData();
    }

    /**
     * 是否使用沉浸式状态栏，默认不使用
     */
    public boolean isImmersiveStatusBar() {
        return false;
    }

    /**
     * 沉浸式状态栏颜色，默认蓝色
     */
    protected int immersiveStatusBarColor() {
        return R.color.base_colorTheme;
    }


    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (unbinder != null) {
            unbinder.unbind();
        }
        //清空任务栈
        if (disposableList != null) {
            for (Disposable disposable : disposableList) {
                disposable.dispose();
            }
            disposableList.clear();
        }
        ActivityManager.getInstance().removeActivity(this);
    }

    /**
     * 初始化Activity异常销毁保存的数据
     */
    public void initSavedInstanceState(Bundle bundle) {

    }

    /**
     * 初始化intent传递的数据
     */
    public void initIntentData(Intent intent) {

    }

    /**
     * 获取布局id
     */
    protected abstract int getLayoutId();

    /**
     * 初始化view
     */
    protected abstract void initView();

    /**
     * 初始化数据,在initView之后执行
     */
    protected abstract void initData();


    protected void toast(int res) {
        toast(mContext.getResources().getText(res));
    }

    protected void toast(CharSequence res) {
        ToastUtil.showShort(res);
    }

    /**
     * 设置网络数据加载失败界面 true则显示错误， false 显示数据
     *
     * @param view   被错误界面替换
     * @param isShow 是否显示错误界面
     */
    protected void showNetErrorView(ViewGroup view, boolean isShow) {
        if (mNetErrorView == null) {
            mNetErrorView = View.inflate(mContext, getNetErrorLayoutRes(), null);
//            Button button = (Button) mNetErrorView.findViewById(R.id.net_error_btn);
//            button.setOnClickListener(v -> {
//                tryData(view.getId());
//            });
        }
        if (isShow) {
            view.setVisibility(View.GONE);
            ViewGroup showViewParent = (ViewGroup) view.getParent();
            int indexOfChild = showViewParent.indexOfChild(view);
            int indexOfChildError = showViewParent.indexOfChild(mNetErrorView);
            if (indexOfChildError < 0) {//表示当前错误界面不存在
                showViewParent.addView(mNetErrorView, indexOfChild);
            }
        } else {
            view.setVisibility(View.VISIBLE);
            mNetErrorView.setVisibility(View.GONE);
        }

    }


    /**
     * 设置当前界面无数据可显示 true则显示错误， false 显示数据
     *
     * @param view   被错误界面替换
     * @param isShow 是否显示错误界面
     */
    protected void showEmptyView(ViewGroup view, boolean isShow) {
        if (mNetEmptyView == null) {
            mNetEmptyView = View.inflate(mContext, getNetEmptyLayoutRes(), null);
            mNetEmptyView.setOnClickListener(v -> tryData(view.getId()));
        }
        if (isShow) {
            view.setVisibility(View.GONE);
            ViewGroup showViewParent = (ViewGroup) view.getParent();
            int indexOfChild = showViewParent.indexOfChild(view);
            int indexOfChildError = showViewParent.indexOfChild(mNetEmptyView);
            if (indexOfChildError < 0)//表示当前错误界面不存在
                showViewParent.addView(mNetEmptyView, indexOfChild);
        } else {
            view.setVisibility(View.VISIBLE);
            mNetEmptyView.setVisibility(View.GONE);
        }
    }


    /**
     * 设置当前页面RecycleView加载不出数据的时候显示的view
     *
     * @param recyclerView
     */
    protected void showNetRecycleEmptyView(RecyclerView recyclerView) {
        if (mNetEmptyView == null) {
            mNetEmptyView = View.inflate(mContext, getNetEmptyLayoutRes(), null);
        }

        RecyclerView.Adapter recyclerViewAdapter = recyclerView.getAdapter();
        if (recyclerViewAdapter != null && recyclerViewAdapter instanceof BaseQuickAdapter) {
            ((BaseQuickAdapter) recyclerViewAdapter).setEmptyView(mNetEmptyView);
            recyclerViewAdapter.notifyDataSetChanged();
        }
    }


    //点击错误界面时触发刷新
    protected void tryData(int id) {
        LogUtil.i("点击刷新");
    }

    /*可以自定义错误界面*/
    protected int getNetErrorLayoutRes() {
        return R.layout.base_net_error_view_default;
    }


    /**
     * 自定义无数据界面
     *
     * @return
     */
    protected int getNetEmptyLayoutRes() {
        return R.layout.base_empty_view_default;
    }

    @Override
    public void onClick(View v) {
    }
}
