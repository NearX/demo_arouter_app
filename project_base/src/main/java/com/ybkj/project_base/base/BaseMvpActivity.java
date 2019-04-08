package com.ybkj.project_base.base;

import android.os.Bundle;
import android.support.annotation.Nullable;

import com.ybkj.base.BaseApplication;
import com.ybkj.base.base.BaseActivity;
import com.ybkj.base.base.BaseRxPresenter;
import com.ybkj.base.base.BaseView;
import com.ybkj.base.dagger.component.ActivityComponent;
import com.ybkj.base.dagger.component.DaggerActivityComponent;
import com.ybkj.base.dagger.module.ActivityModule;
import com.ybkj.base.utils.LogUtil;

import javax.inject.Inject;


/**
 * - @Author:  Yi Shan Xiang
 * - @Description:  基础的采用mvp模式建立的 BaseMvpActivity
 * - @Time:  2018/8/31
 * - @Emaill:  380948730@qq.com
 */
public abstract class BaseMvpActivity<T extends BaseRxPresenter> extends BaseActivity implements BaseView {

    /**
     * 对象要给子类用，所以要在其实例化的地方进行注解
     */
    @Inject
    public T presenter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        injectPresenter();
        if (presenter != null) {
            presenter.attachView(this);
        }
        super.onCreate(savedInstanceState);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        if (presenter != null) {
            presenter.detachView();
        }
        presenter = null;
    }

    /**
     * 这种是通过dagger2方式创建percent  暂时先不使用
     *
     * @return
     */
    public ActivityComponent getActivityComponent() {
        return DaggerActivityComponent.builder()
                .appComponent(BaseApplication.getAppComponent())
                .activityModule(new ActivityModule(this))
                .build();
    }

    /**
     * 初始化presenter
     *
     * @return
     */
    protected abstract void injectPresenter();

    /**
     * 请求成功
     *
     * @param tag 网络请求标记，作为返回
     */
    @Override
    public void onSuccess(int tag) {
    }

    /**
     * 登录过期，弹出提示框
     */
    @Override
    public void onLoginError() {
        showLogoutDialog();
    }

    /**
     * 请求失败
     *
     * @param errorMsg 网络请求失败的返回结果
     */
    @Override
    public void onError(String errorMsg) {
        LogUtil.i("接口请求失败" + ";errorMsg=" + errorMsg);
        toast(errorMsg);
    }

    /**
     * 显示掉线弹框
     */
    private void showLogoutDialog() {

    }

}
