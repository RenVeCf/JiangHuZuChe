package com.ipd.jianghuzuche.presenter;

import android.content.Context;

import com.ipd.jianghuzuche.bean.RepairProjectVerticalBean;
import com.ipd.jianghuzuche.contract.RepairProjectVerticalContract;
import com.ipd.jianghuzuche.model.RepairProjectVerticalModel;
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
public class RepairProjectVerticalPresenter extends RepairProjectVerticalContract.Presenter {

    private RepairProjectVerticalModel model;
    private Context context;

    public RepairProjectVerticalPresenter(Context context) {
        this.model = new RepairProjectVerticalModel();
        this.context = context;
    }

    @Override
    public void getRepairProjectVertical(TreeMap<String, String> map, boolean isDialog, boolean cancelable) {
        model.getRepairProjectVertical(context, map, isDialog, cancelable, getView().bindLifecycle(), new ObserverResponseListener() {
            @Override
            public void onNext(Object o) {
                //这一步是必须的，判断view是否已经被销毁
                if (getView() != null) {
                    getView().resultRepairProjectVertical((RepairProjectVerticalBean) o);
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