package com.ipd.jianghuzuche.model;

import android.content.Context;

import com.ipd.jianghuzuche.api.Api;
import com.ipd.jianghuzuche.base.BaseModel;
import com.ipd.jianghuzuche.progress.ObserverResponseListener;

import java.util.TreeMap;

import io.reactivex.ObservableTransformer;
import okhttp3.RequestBody;

/**
 * Description ：
 * Author ： MengYang
 * Email ： 942685687@qq.com
 * Time ： 2018/8/26.
 */
public class SupplementInfoModel<T> extends BaseModel {

    public void getSupplementInfo(Context context, TreeMap<String, String> map, boolean isDialog, boolean cancelable,
                                  ObservableTransformer<T, T> transformer, ObserverResponseListener observerListener) {

        //当不需要指定是否由dialog时，可以调用这个方法
        //        subscribe(context, Api.getApiService().SupplementInfo(map), observerListener);
        paramSubscribe(context, Api.getApiService().getSupplementInfo(map), observerListener, transformer, isDialog, cancelable);
    }

    public void getUploadImg(Context context, String imgType, TreeMap<String, RequestBody> map, boolean isDialog, boolean cancelable,
                             ObservableTransformer<T, T> transformer, ObserverResponseListener observerListener) {

        //当不需要指定是否由dialog时，可以调用这个方法
        //        subscribe(context, Api.getApiService().login(map), observerListener);
        paramSubscribe(context, Api.getApiService().getUploadImg(imgType, map), observerListener, transformer, isDialog, cancelable);
    }
    //// TODO: 2017/12/27 其他需要请求、数据库等等的操作
}
