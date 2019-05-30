package com.ipd.jianghuzuche.contract;

import com.ipd.jianghuzuche.base.BasePresenter;
import com.ipd.jianghuzuche.base.BaseView;
import com.ipd.jianghuzuche.bean.CancelOrderBean;
import com.ipd.jianghuzuche.bean.CarReturnConfirmBean;
import com.ipd.jianghuzuche.bean.CarReturnDetailsBean;
import com.ipd.jianghuzuche.bean.OrderDetailsBean;

import java.util.TreeMap;

import io.reactivex.ObservableTransformer;

/**
 * Description ：MemberCenterContract  V 、P契约类
 * Author ： MengYang
 * Email ： 942685687@qq.com
 * Time ： 2019/4/2.
 */
public interface OrderDetailsContract {

    interface View extends BaseView {
        //不同的Bean单独处理
        void resultOrderDetails(OrderDetailsBean data);

        void resultUnpaidCancelOrder(CancelOrderBean data);

        void resultCarReturnDetails(CarReturnDetailsBean data);

        void resultCarReturnCancelOrder(CancelOrderBean data);

        void resultCarReturnConfirm(CarReturnConfirmBean data);

        void resultGetCarCancelOrder(CancelOrderBean data);

        <T> ObservableTransformer<T, T> bindLifecycle();
    }

    abstract class Presenter extends BasePresenter<View> {
        public abstract void getOrderDetails(TreeMap<String, String> map, boolean isDialog, boolean cancelable);

        public abstract void getUnpaidCancelOrder(TreeMap<String, String> map, boolean isDialog, boolean cancelable);

        public abstract void getCarReturnDetails(TreeMap<String, String> map, boolean isDialog, boolean cancelable);

        public abstract void getCarReturnCancelOrder(TreeMap<String, String> map, boolean isDialog, boolean cancelable);

        public abstract void getCarReturnConfirm(TreeMap<String, String> map, boolean isDialog, boolean cancelable);

        public abstract void getGetCarCancelOrder(TreeMap<String, String> map, boolean isDialog, boolean cancelable);
    }
}