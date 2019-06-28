package com.ipd.jianghuzuche.presenter;

import android.content.Context;

import com.ipd.jianghuzuche.bean.ChargeBean;
import com.ipd.jianghuzuche.bean.RepairConfirmBean;
import com.ipd.jianghuzuche.bean.RepairProjectHorizontalBean;
import com.ipd.jianghuzuche.bean.StoreDetailsBean;
import com.ipd.jianghuzuche.contract.StoreDetailsContract;
import com.ipd.jianghuzuche.model.StoreDetailsModel;
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
public class StoreDetailsPresenter extends StoreDetailsContract.Presenter {

    private StoreDetailsModel model;
    private Context context;

    public StoreDetailsPresenter(Context context) {
        this.model = new StoreDetailsModel();
        this.context = context;
    }

    @Override
    public void getRepairProjectHorizontal(TreeMap<String, String> map, boolean isDialog, boolean cancelable) {
        model.getRepairProjectHorizontal(context, map, isDialog, cancelable, getView().bindLifecycle(), new ObserverResponseListener() {
            @Override
            public void onNext(Object o) {
                //这一步是必须的，判断view是否已经被销毁
                if (getView() != null) {
                    getView().resultRepairProjectHorizontal((RepairProjectHorizontalBean) o);
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

    @Override
    public void getCharge(TreeMap<String, String> map, boolean isDialog, boolean cancelable) {
        model.getCharge(context, map, isDialog, cancelable, getView().bindLifecycle(), new ObserverResponseListener() {
            @Override
            public void onNext(Object o) {
                //这一步是必须的，判断view是否已经被销毁
                if (getView() != null) {
                    getView().resultCharge((ChargeBean) o);
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

    @Override
    public void getRepairConfirm(TreeMap<String, String> map, boolean isDialog, boolean cancelable) {
        model.getRepairConfirm(context, map, isDialog, cancelable, getView().bindLifecycle(), new ObserverResponseListener() {
            @Override
            public void onNext(Object o) {
                //这一步是必须的，判断view是否已经被销毁
                if (getView() != null) {
                    getView().resultRepairConfirm((RepairConfirmBean) o);
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

    public void getStoreDetails(TreeMap<String, String> map, boolean isDialog, boolean cancelable) {
        model.getStoreDetails(context, map, isDialog, cancelable, getView().bindLifecycle(), new ObserverResponseListener() {
            @Override
            public void onNext(Object o) {
                //这一步是必须的，判断view是否已经被销毁
                if (getView() != null) {
                    getView().resultStoreDetails((StoreDetailsBean) o);
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