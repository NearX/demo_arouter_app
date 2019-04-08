package com.ybkj.agent.dagger.component;

import android.app.Activity;
import android.content.Context;

import com.ybkj.agent.dagger.module.AgentHttpModule;
import com.ybkj.agent.network.AgentApiService;
import com.ybkj.agent.page.activity.ListExampleActivity;
import com.ybkj.base.dagger.component.AppComponent;
import com.ybkj.base.dagger.module.ActivityModule;
import com.ybkj.base.dagger.scope.ActivityScope;

import dagger.Component;

/**
 * Description
 * Author Ren Xingzhi
 * Created on 2019/3/26.
 * Email 15384030400@163.com
 */
@ActivityScope
@Component(dependencies = AppComponent.class, modules = {ActivityModule.class, AgentHttpModule.class})
public interface AgentActivityComponent {
    Activity getActivity();

    Context getContext();

    AgentApiService getAuthApiService();

    void inject(ListExampleActivity listExampleActivity);

}
