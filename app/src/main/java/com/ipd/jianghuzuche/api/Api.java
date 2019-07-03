package com.ipd.jianghuzuche.api;


import com.ipd.jianghuzuche.base.BaseApi;

import static com.ipd.jianghuzuche.common.config.UrlConfig.BASE_URL;

/**
 * Description ：处理请求链接的地方
 * Author ： MengYang
 * Email ： 942685687@qq.com
 * Time ： 2018/8/27.
 */

public class Api {

    private volatile static ApiService apiService;

    public static ApiService getApiService() {
        if (apiService == null) {
            synchronized (Api.class) {
                if (apiService == null) {
                    new Api();
                }
            }
        }
        return apiService;
    }

    private Api() {
        BaseApi baseApi = new BaseApi();
        apiService = baseApi.getRetrofit(BASE_URL).create(ApiService.class);
    }
}
