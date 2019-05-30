package com.ipd.jianghuzuche.adapter;

import android.support.annotation.Nullable;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.ipd.jianghuzuche.R;
import com.ipd.jianghuzuche.bean.RepairListBean;
import com.ipd.jianghuzuche.utils.ApplicationUtil;
import com.ipd.jianghuzuche.utils.NumberUtils;

import java.util.List;

import static com.ipd.jianghuzuche.common.config.UrlConfig.BASE_LOCAL_URL;

/**
 * Description ：
 * Author ： MengYang
 * Email ： 942685687@qq.com
 * Time ： 2019/5/7.
 */
public class RepairAdapter extends BaseQuickAdapter<RepairListBean.DataBean.StoreListBean, BaseViewHolder> {

    public RepairAdapter(@Nullable List<RepairListBean.DataBean.StoreListBean> data) {
        super(R.layout.adapter_repair, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, RepairListBean.DataBean.StoreListBean item) {
        Glide.with(ApplicationUtil.getContext()).load(BASE_LOCAL_URL + item.getLogo()).apply(new RequestOptions()).into((ImageView) helper.getView(R.id.iv_store_logo));

        helper.setText(R.id.tv_car_name, item.getStoreName())
                .setText(R.id.tv_store_distance, NumberUtils.formatTwoDecimal((float) item.getDistance() / 1000) + "km")
                .setText(R.id.tv_service_content, item.getRepairNames())
                .setText(R.id.tv_store_path, item.getDescAddress());
    }
}
