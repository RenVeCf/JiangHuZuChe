package com.ipd.jianghuzuche.presenter;

import android.content.Context;

import com.ipd.jianghuzuche.bean.HomeBean;
import com.ipd.jianghuzuche.contract.PlaceOrderContract;
import com.ipd.jianghuzuche.model.PlaceOrderModel;
import com.ipd.jianghuzuche.progress.ObserverResponseListener;
import com.ipd.jianghuzuche.utils.ExceptionHandle;
import com.ipd.jianghuzuche.utils.ToastUtil;

/**
 * Description ：
 * Author ： MengYang
 * Email ： 942685687@qq.com
 * Time ： 2019/5/5.
 */
public class PlaceOrderPresenter extends PlaceOrderContract.Presenter {

    private PlaceOrderModel model;
    private Context context;

    public PlaceOrderPresenter(Context context) {
        this.model = new PlaceOrderModel();
        this.context = context;
    }

    @Override
    public void getHome(boolean isDialog, boolean cancelable) {
        model.getHome(context, isDialog, cancelable, new ObserverResponseListener() {
            @Override
            public void onNext(Object o) {
                //这一步是必须的，判断view是否已经被销毁
                if (getView() != null) {
                    getView().resultHome((HomeBean) o);
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
