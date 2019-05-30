package com.ipd.jianghuzuche.presenter;

import android.content.Context;

import com.ipd.jianghuzuche.bean.RepairDetailsBean;
import com.ipd.jianghuzuche.contract.RepairDetailsContract;
import com.ipd.jianghuzuche.model.RepairDetailsModel;
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
public class RepairDetailsPresenter extends RepairDetailsContract.Presenter {

    private RepairDetailsModel model;
    private Context context;

    public RepairDetailsPresenter(Context context) {
        this.model = new RepairDetailsModel();
        this.context = context;
    }

    @Override
    public void getRepairDetails(TreeMap<String, String> map, boolean isDialog, boolean cancelable) {
        model.getRepairDetails(context, map, isDialog, cancelable, getView().bindLifecycle(), new ObserverResponseListener() {
            @Override
            public void onNext(Object o) {
                //这一步是必须的，判断view是否已经被销毁
                if (getView() != null) {
                    getView().resultRepairDetails((RepairDetailsBean) o);
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