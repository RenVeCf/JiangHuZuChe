package com.ipd.jianghuzuche.presenter;

import android.content.Context;

import com.ipd.jianghuzuche.bean.UserSelectCarBean;
import com.ipd.jianghuzuche.contract.UserSelectCarContract;
import com.ipd.jianghuzuche.model.UserSelectCarModel;
import com.ipd.jianghuzuche.progress.ObserverResponseListener;
import com.ipd.jianghuzuche.utils.ExceptionHandle;
import com.ipd.jianghuzuche.utils.ToastUtil;

import java.util.TreeMap;

/**
 * Description ：
 * Author ： MengYang
 * Email ： 942685687@qq.com
 * Time ： 2018/8/26.
 */
public class UserSelectCarPresenter extends UserSelectCarContract.Presenter {

    private UserSelectCarModel model;
    private Context context;

    public UserSelectCarPresenter(Context context) {
        this.model = new UserSelectCarModel();
        this.context = context;
    }

    @Override
    public void getUserSelectCar(TreeMap<String, String> map, boolean isDialog, boolean cancelable) {
        model.getUserSelectCar(context, map, isDialog, cancelable, getView().bindLifecycle(), new ObserverResponseListener() {
            @Override
            public void onNext(Object o) {
                //这一步是必须的，判断view是否已经被销毁
                if (getView() != null) {
                    getView().resultUserSelectCar((UserSelectCarBean) o);
                }
            }

            @Override
            public void onError(ExceptionHandle.ResponeThrowable e) {
                if (getView() != null) {
                    //// TODO: 2017/12/28 自定义处理异常
                    ToastUtil.showShortToast(ExceptionHandle.handleException(e).message);
                }
            }
        });
    }
}