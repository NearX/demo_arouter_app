package com.ybkj.base.dagger.component;


import com.ybkj.base.BaseApplication;
import com.ybkj.base.dagger.module.AppModule;
import com.ybkj.base.dagger.module.HttpModule;
import com.ybkj.base.net.api.BaseNetFunction;

import javax.inject.Singleton;

import dagger.Component;
import retrofit2.Retrofit;

/**
 * - @Author:  Yi Shan Xiang
 * - @Description:  引入dragger2依赖注入，创建项目中所需要用到的全局对象
 *
 * @Singleton 代表这些全局对象单例
 * @AppModule app全局都要用到的对象module
 * @HttpModule Http请求所需要用到的对象
 * <p>
 * - @Time:  2018/9/5
 * - @Emaill:  380948730@qq.com
 */
@Singleton
@Component(modules = {AppModule.class, HttpModule.class})
public interface AppComponent {
    BaseApplication getContext();

    BaseNetFunction provideBaseNetFunction();

    Retrofit provideRetrofit();
}
