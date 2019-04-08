package com.ybkj.project_base.base;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.View;

import com.ybkj.base.base.BaseFragment;
import com.ybkj.base.base.BasePresenter;
import com.ybkj.base.base.BaseView;
import com.ybkj.base.utils.LogUtil;

import javax.inject.Inject;

/**
 * author：rongkui.xiao --2018/3/16
 * email：dovexiaoen@163.com
 * description:mvp模式下的fragment
 */

public abstract class BaseMvpFragment<T extends BasePresenter> extends BaseFragment implements BaseView {

    @Inject
    public T presenter;

    protected abstract void injectPresenter();


    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        injectPresenter();
        if (presenter != null) {
            presenter.attachView(this);
        }
        super.onViewCreated(view, savedInstanceState);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        if (presenter != null) {
            presenter.detachView();
        }
    }

    @Override
    public void onSuccess(int tag) {

    }

    @Override
    public void onError(String errorMsg) {
        LogUtil.i("接口请求失败" + ";errorMsg=" + errorMsg);
        if (isShowNetErrorDefaultToast()) {
            toast(errorMsg);
        }
    }

    /**
     * 登录过期失效
     */
    @Override
    public void onLoginError() {
        showLogoutDialog();
    }

    protected boolean isShowNetErrorDefaultToast() {
        return true;
    }

    /**
     * 显示掉线弹框
     */
    private void showLogoutDialog() {

    }

}
