package com.ipd.jianghuzuche.presenter;

import android.content.Context;

import com.ipd.jianghuzuche.bean.CashWithdrawalBean;
import com.ipd.jianghuzuche.bean.CashWithdrawalFeeBean;
import com.ipd.jianghuzuche.bean.LastBankBean;
import com.ipd.jianghuzuche.contract.CashWithdrawalFeeContract;
import com.ipd.jianghuzuche.model.CashWithdrawalFeeModel;
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
public class CashWithdrawalFeePresenter extends CashWithdrawalFeeContract.Presenter {

    private CashWithdrawalFeeModel model;
    private Context context;

    public CashWithdrawalFeePresenter(Context context) {
        this.model = new CashWithdrawalFeeModel();
        this.context = context;
    }

    @Override
    public void getCashWithdrawalFee(TreeMap<String, String> map, boolean isDialog, boolean cancelable) {
        model.getCashWithdrawalFee(context, map, isDialog, cancelable, getView().bindLifecycle(), new ObserverResponseListener() {
            @Override
            public void onNext(Object o) {
                //这一步是必须的，判断view是否已经被销毁
                if (getView() != null) {
                    getView().resultCashWithdrawalFee((CashWithdrawalFeeBean) o);
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
    public void getCashWithdrawal(TreeMap<String, String> map, boolean isDialog, boolean cancelable) {
        model.getCashWithdrawal(context, map, isDialog, cancelable, getView().bindLifecycle(), new ObserverResponseListener() {
            @Override
            public void onNext(Object o) {
                //这一步是必须的，判断view是否已经被销毁
                if (getView() != null) {
                    getView().resultCashWithdrawal((CashWithdrawalBean) o);
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
    public void getLastBank(TreeMap<String, String> map, boolean isDialog, boolean cancelable) {
        model.getLastBank(context, map, isDialog, cancelable, getView().bindLifecycle(), new ObserverResponseListener() {
            @Override
            public void onNext(Object o) {
                //这一步是必须的，判断view是否已经被销毁
                if (getView() != null) {
                    getView().resultLastBank((LastBankBean) o);
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