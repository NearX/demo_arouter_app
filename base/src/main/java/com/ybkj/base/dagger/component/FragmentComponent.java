package com.ybkj.base.dagger.component;


import android.content.Context;
import android.support.v4.app.Fragment;

import com.ybkj.base.dagger.module.FragmentModule;
import com.ybkj.base.dagger.scope.FragmentScope;

import dagger.Component;

/**
 * - @Author:  Yi Shan Xiang
 * - @Description:  将对象注解到实力对象的接口
 * - @Time:  2018/9/6
 * - @Emaill:  380948730@qq.com
 */
@FragmentScope
@Component(dependencies = AppComponent.class, modules = FragmentModule.class)
public interface FragmentComponent {
    Fragment getFragment();

    Context getContext();


}
