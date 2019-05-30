package com.ipd.jianghuzuche.model;

import android.content.Context;

import com.ipd.jianghuzuche.api.Api;
import com.ipd.jianghuzuche.base.BaseModel;
import com.ipd.jianghuzuche.progress.ObserverResponseListener;

import java.util.TreeMap;

/**
 * Description ：
 * Author ： MengYang
 * Email ： 942685687@qq.com
 * Time ： 2019/5/5.
 */
public class PlaceOrderModel<T> extends BaseModel {
    public void getHome(Context context, boolean isDialog, boolean cancelable, ObserverResponseListener observerListener) {

        //当不需要指定是否由dialog时，可以调用这个方法
//                subscribe(context, Api.getApiService().login(map), observerListener, transformer);
        nullParamSubscribe(context, Api.getApiService().getHome(), observerListener, isDialog, cancelable);
    }
}
