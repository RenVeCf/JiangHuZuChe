package com.ipd.jianghuzuche.contract;

import com.ipd.jianghuzuche.base.BasePresenter;
import com.ipd.jianghuzuche.base.BaseView;
import com.ipd.jianghuzuche.bean.ModifyUserDataBean;
import com.ipd.jianghuzuche.bean.SupplementInfoBean;
import com.ipd.jianghuzuche.bean.UploadImgBean;

import java.util.TreeMap;

import io.reactivex.ObservableTransformer;
import okhttp3.RequestBody;

/**
 * Description ：MemberCenterContract  V 、P契约类
 * Author ： MengYang
 * Email ： 942685687@qq.com
 * Time ： 2019/4/2.
 */
public interface ModifyUserDataContract {

    interface View extends BaseView {
        //不同的Bean单独处理
        void resultModifyUserData(ModifyUserDataBean data);

        void resultUploadImg(UploadImgBean data);

        <T> ObservableTransformer<T, T> bindLifecycle();
    }

    abstract class Presenter extends BasePresenter<View> {
        public abstract void getModifyUserData(TreeMap<String, String> map, boolean isDialog, boolean cancelable);

        public abstract void getUploadImg(String imgType, TreeMap<String, RequestBody> map, boolean isDialog, boolean cancelable);
    }
}