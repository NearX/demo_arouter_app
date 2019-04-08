package com.ybkj.base.dagger.module;


import android.text.TextUtils;

import com.ybkj.base.BuildConfig;
import com.ybkj.base.common.Constants;
import com.ybkj.base.net.api.BaseNetFunction;
import com.ybkj.base.utils.LogUtil;
import com.ybkj.base.utils.SPHelper;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import javax.inject.Named;
import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;


/**
 * - @Author:  Yi Shan Xiang
 * - @Description:  通过dagger方式创建网络请求所需要的对象
 *
 * @Singleton全局单例
 * @Provides 为创建Presenter提供依赖的
 * - @Time:  2018/9/5
 * - @Emaill:  380948730@qq.com
 */
@Module
public class HttpModule {

    @Provides
    @Singleton
    Retrofit.Builder provideRetrofitBuilder() {
        return new Retrofit.Builder();
    }

    @Provides
    @Singleton
    OkHttpClient.Builder provideOkHttpBuilder() {
        return new OkHttpClient.Builder();
    }

    @Provides
    @Singleton
    BaseNetFunction provideBaseNetFunction() {
        return new BaseNetFunction();
    }

    @Provides
    @Singleton
    OkHttpClient provideClient(OkHttpClient.Builder builder, @Named("tokenKey") String tokenKey) {
        if (BuildConfig.DEBUG) {
            HttpLoggingInterceptor loggingInterceptor = new HttpLoggingInterceptor(message -> {
                LogUtil.i("OkHttp --> " + message);
            });
            loggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
            builder.addInterceptor(loggingInterceptor);
        }
        return builder.addInterceptor(new TokenInterceptor(tokenKey))
                .addNetworkInterceptor(new SleepInterceptor())
                .connectTimeout(Constants.connectionTime, TimeUnit.SECONDS)
                .readTimeout(Constants.connectionTime, TimeUnit.SECONDS)
                .writeTimeout(Constants.connectionTime, TimeUnit.SECONDS)
                .build();
    }

    @Provides
    @Singleton
    Retrofit provideRetrofit(Retrofit.Builder builder, OkHttpClient client, @Named("serverAddress") String serverAddress) {
        return createRetrofit(builder, client, serverAddress);
    }

    /**
     * 创建Retrofit
     *
     * @param builder
     * @param client
     * @param url
     * @return
     */
    private Retrofit createRetrofit(Retrofit.Builder builder, OkHttpClient client, String url) {
        return builder.baseUrl(url)
                .client(client)
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }

    /**
     * token&sign拦截器
     */
    private class TokenInterceptor implements Interceptor {
        private String tokenKey;

        public TokenInterceptor(String tokenKey) {
            this.tokenKey = tokenKey;
        }

        @Override
        public Response intercept(Chain chain) throws IOException {
            Request oldRequest = chain.request();
            String token = SPHelper.getInstance().getString(Constants.TOKEN_SAVE_KEY);
            Request.Builder builder = oldRequest.newBuilder();
            if (!TextUtils.isEmpty(token)) {
                builder.addHeader(tokenKey, token);
                LogUtil.i("token=" + token);
            }
            return chain.proceed(builder.build());
        }
    }

    /**
     * 平滑请求时间拦截器
     */
    private class SleepInterceptor implements Interceptor {
        @Override
        public Response intercept(Chain chain) throws IOException {
            long start = System.currentTimeMillis();
            Response response = chain.proceed(chain.request());
            if (System.currentTimeMillis() - start < 1000) {
                try {
                    Thread.sleep(700);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            return response;
        }
    }

}
