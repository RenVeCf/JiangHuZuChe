package com.ipd.jianghuzuche.contract;

import com.ipd.jianghuzuche.base.BasePresenter;
import com.ipd.jianghuzuche.base.BaseView;
import com.ipd.jianghuzuche.bean.ChargeBean;
import com.ipd.jianghuzuche.bean.RepairConfirmBean;
import com.ipd.jianghuzuche.bean.RepairProjectHorizontalBean;

import java.util.TreeMap;

import io.reactivex.ObservableTransformer;

/**
 * Description ：MemberCenterContract  V 、P契约类
 * Author ： MengYang
 * Email ： 942685687@qq.com
 * Time ： 2019/4/2.
 */
public interface StoreDetailsContract {

    interface View extends BaseView {
        //不同的Bean单独处理
        void resultRepairProjectHorizontal(RepairProjectHorizontalBean data);

        void resultCharge(ChargeBean data);

        void resultRepairConfirm(RepairConfirmBean data);

        <T> ObservableTransformer<T, T> bindLifecycle();
    }

    abstract class Presenter extends BasePresenter<View> {
        public abstract void getRepairProjectHorizontal(TreeMap<String, String> map, boolean isDialog, boolean cancelable);

        public abstract void getCharge(TreeMap<String, String> map, boolean isDialog, boolean cancelable);

        public abstract void getRepairConfirm(TreeMap<String, String> map, boolean isDialog, boolean cancelable);
    }
}