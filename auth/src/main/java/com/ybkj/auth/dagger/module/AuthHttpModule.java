package com.ybkj.auth.dagger.module;

import com.ybkj.auth.network.AuthApiService;

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
public class AuthHttpModule {

    @Provides
    AuthApiService provideAuthApiService(Retrofit retrofit) {
        return retrofit.create(AuthApiService.class);
    }
}
