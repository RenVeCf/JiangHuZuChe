package com.ipd.jianghuzuche.adapter;

import android.support.annotation.Nullable;
import android.view.View;
import android.widget.ImageView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.ipd.jianghuzuche.R;
import com.ipd.jianghuzuche.bean.CouponBean;

import java.util.List;

/**
 * Description ：
 * Author ： MengYang
 * Email ： 942685687@qq.com
 * Time ： 2019/4/30.
 */
public class UserCouponAdapter extends BaseQuickAdapter<CouponBean.DataBean.UserCouponListBean, BaseViewHolder> {

    private ImageView ivCouponSelect;
    private int couponType = 0;

    public UserCouponAdapter(@Nullable List<CouponBean.DataBean.UserCouponListBean> data, int couponType) {
        super(R.layout.adapter_user_coupon, data);
        this.couponType = couponType;
    }

    @Override
    protected void convert(BaseViewHolder helper, CouponBean.DataBean.UserCouponListBean item) {
        ivCouponSelect = helper.getView(R.id.iv_coupon_select);
        helper.setText(R.id.tv_coupon_use_money, item.getMoney() + "")
                .setText(R.id.tv_coupon_condition_money, item.getTitle())
                .setText(R.id.tv_coupon_end_time, item.getValidityTime());
        if (couponType == 1) {
            helper.setGone(R.id.aciv_coupon_type, true);
            helper.setImageResource(R.id.aciv_coupon_type, item.getStatus() == 1 ? R.mipmap.ic_coupon : R.mipmap.ic_not_coupon);//1:未使用，2:使用了
        } else
            helper.setGone(R.id.aciv_coupon_type, false);
        if (item.isShow()) {
            ivCouponSelect.setVisibility(View.VISIBLE);
        } else {
            ivCouponSelect.setVisibility(View.GONE);
        }
    }
}
