package com.ybkj.agent.dagger.module;

import com.ybkj.agent.network.AgentApiService;

import dagger.Module;
import dagger.Provides;
import retrofit2.Retrofit;

/**
 * Description
 * Author Ren Xingzhi
 * Created on 2019/3/26.
 * Email 15384030400@163.com
 */
@Module
public class AgentHttpModule {

    @Provides
    AgentApiService provideAuthApiService(Retrofit retrofit) {
        return retrofit.create(AgentApiService.class);
    }
}
