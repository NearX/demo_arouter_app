package com.ybkj.agent.dagger.component;

import android.content.Context;
import android.support.v4.app.Fragment;

import com.ybkj.base.dagger.component.AppComponent;
import com.ybkj.base.dagger.module.FragmentModule;
import com.ybkj.base.dagger.scope.FragmentScope;

import dagger.Component;

/**
 * Description
 * Author Ren Xingzhi
 * Created on 2019/3/26.
 * Email 15384030400@163.com
 */
@FragmentScope
@Component(dependencies = AppComponent.class, modules = FragmentModule.class)
public interface AgentFragmentComponent {
    Fragment getFragment();

    Context getContext();
}
