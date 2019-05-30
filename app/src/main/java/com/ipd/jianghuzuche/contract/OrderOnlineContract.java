package com.ipd.jianghuzuche.contract;

import com.ipd.jianghuzuche.base.BasePresenter;
import com.ipd.jianghuzuche.base.BaseView;
import com.ipd.jianghuzuche.bean.AddBankBean;
import com.ipd.jianghuzuche.bean.AliPayBean;
import com.ipd.jianghuzuche.bean.WeChatPayBean;

import java.util.TreeMap;

import io.reactivex.ObservableTransformer;

/**
 * Description ：MemberCenterContract  V 、P契约类
 * Author ： MengYang
 * Email ： 942685687@qq.com
 * Time ： 2019/4/2.
 */
public interface OrderOnlineContract {

    interface View extends BaseView {
        //不同的Bean单独处理
        void resultRepairAli(AliPayBean data);

        void resultRepairWeChat(WeChatPayBean data);

        <T> ObservableTransformer<T, T> bindLifecycle();
    }

    abstract class Presenter extends BasePresenter<View> {
        public abstract void getRepairAli(TreeMap<String, String> map, boolean isDialog, boolean cancelable);

        public abstract void getRepairWeChat(TreeMap<String, String> map, boolean isDialog, boolean cancelable);
    }
}