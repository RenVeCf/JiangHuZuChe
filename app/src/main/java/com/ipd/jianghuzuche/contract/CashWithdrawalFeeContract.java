package com.ipd.jianghuzuche.contract;

import com.ipd.jianghuzuche.base.BasePresenter;
import com.ipd.jianghuzuche.base.BaseView;
import com.ipd.jianghuzuche.bean.CashWithdrawalBean;
import com.ipd.jianghuzuche.bean.CashWithdrawalFeeBean;
import com.ipd.jianghuzuche.bean.LastBankBean;

import java.util.TreeMap;

import io.reactivex.ObservableTransformer;

/**
 * Description ：MemberCenterContract  V 、P契约类
 * Author ： MengYang
 * Email ： 942685687@qq.com
 * Time ： 2019/4/2.
 */
public interface CashWithdrawalFeeContract {

    interface View extends BaseView {
        //不同的Bean单独处理
        void resultCashWithdrawalFee(CashWithdrawalFeeBean data);

        void resultCashWithdrawal(CashWithdrawalBean data);

        void resultLastBank(LastBankBean data);

        <T> ObservableTransformer<T, T> bindLifecycle();
    }

    abstract class Presenter extends BasePresenter<View> {
        public abstract void getCashWithdrawalFee(TreeMap<String, String> map, boolean isDialog, boolean cancelable);

        public abstract void getCashWithdrawal(TreeMap<String, String> map, boolean isDialog, boolean cancelable);

        public abstract void getLastBank(TreeMap<String, String> map, boolean isDialog, boolean cancelable);
    }
}