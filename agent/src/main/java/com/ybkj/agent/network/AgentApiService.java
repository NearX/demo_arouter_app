package com.ybkj.agent.network;

import com.ybkj.base.bean.BaseResponse;
import com.ybkj.project_base.bean.LoginRes;

import io.reactivex.Observable;
import retrofit2.http.GET;

/**
 * - @Author:  Yi Shan Xiang
 * - @Description:  ApiService
 * - @Time:  2018/8/31
 * - @Emaill:  380948730@qq.com
 */
public interface AgentApiService {

    /**
     * 用户登录
     *
     * @return
     */
    @GET("/example/data")
    Observable<BaseResponse<LoginRes>> getExampleData();

}
