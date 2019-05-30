package com.ipd.jianghuzuche.contract;

import com.ipd.jianghuzuche.base.BasePresenter;
import com.ipd.jianghuzuche.base.BaseView;
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
public interface SelectTypePayContract {

    interface View extends BaseView {
        //不同的Bean单独处理
        void resultSelectTypePayAli(AliPayBean data);

        void resultSelectTypePayWeChat(WeChatPayBean data);

        <T> ObservableTransformer<T, T> bindLifecycle();
    }

    abstract class Presenter extends BasePresenter<View> {
        public abstract void getSelectTypePayAli(TreeMap<String, String> map, boolean isDialog, boolean cancelable);

        public abstract void getSelectTypePayWeChat(TreeMap<String, String> map, boolean isDialog, boolean cancelable);
    }
}