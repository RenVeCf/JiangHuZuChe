package com.ipd.jianghuzuche.contract;

import com.ipd.jianghuzuche.base.BasePresenter;
import com.ipd.jianghuzuche.base.BaseView;
import com.ipd.jianghuzuche.bean.ChoiceStoreBean;
import com.ipd.jianghuzuche.bean.CouponBean;

import java.util.TreeMap;

import io.reactivex.ObservableTransformer;

/**
 * Description ：MemberCenterContract  V 、P契约类
 * Author ： MengYang
 * Email ： 942685687@qq.com
 * Time ： 2019/4/2.
 */
public interface CouponContract {

    interface View extends BaseView {
        //不同的Bean单独处理
        void resultCoupon(CouponBean data);

        <T> ObservableTransformer<T, T> bindLifecycle();
    }

    abstract class Presenter extends BasePresenter<View> {
        public abstract void getCoupon(TreeMap<String, String> map, boolean isDialog, boolean cancelable);
    }
}