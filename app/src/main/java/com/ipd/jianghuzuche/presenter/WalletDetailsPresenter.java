package com.ipd.jianghuzuche.presenter;

import android.content.Context;

import com.ipd.jianghuzuche.bean.WalletDetailsBean;
import com.ipd.jianghuzuche.contract.WalletDetailsContract;
import com.ipd.jianghuzuche.model.WalletDetailsModel;
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
public class WalletDetailsPresenter extends WalletDetailsContract.Presenter {

    private WalletDetailsModel model;
    private Context context;

    public WalletDetailsPresenter(Context context) {
        this.model = new WalletDetailsModel();
        this.context = context;
    }

    @Override
    public void getWalletDetails(TreeMap<String, String> map, boolean isDialog, boolean cancelable) {
        model.getWalletDetails(context, map, isDialog, cancelable, getView().bindLifecycle(), new ObserverResponseListener() {
            @Override
            public void onNext(Object o) {
                //这一步是必须的，判断view是否已经被销毁
                if (getView() != null) {
                    getView().resultWalletDetails((WalletDetailsBean) o);
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