package com.ybkj.base.dagger.component;

import android.app.Activity;
import android.content.Context;

import com.ybkj.base.dagger.module.ActivityModule;
import com.ybkj.base.dagger.scope.ActivityScope;

import dagger.Component;

/**
 * - @Author:  Yi Shan Xiang
 * - @Description:  Activity的Component
 * 主要作用是将@Inject标注的Presenter和@Module标注的ActivityModule联系起来，从@Module中获取依赖，
 * 并将依赖注入给@Inject标注的对象。
 * - @Time:  2018/9/5
 * - @Emaill:  380948730@qq.com
 */
@ActivityScope
@Component(dependencies = AppComponent.class, modules = ActivityModule.class)
public interface ActivityComponent {
    Activity getActivity();

    Context getContext();
}
