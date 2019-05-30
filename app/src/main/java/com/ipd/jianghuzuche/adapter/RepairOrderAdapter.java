package com.ipd.jianghuzuche.adapter;

import android.support.annotation.Nullable;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.ipd.jianghuzuche.R;
import com.ipd.jianghuzuche.bean.RepairOrderBean;
import com.ipd.jianghuzuche.utils.ApplicationUtil;

import java.util.List;

import static com.ipd.jianghuzuche.common.config.UrlConfig.BASE_LOCAL_URL;

/**
 * Description ：
 * Author ： MengYang
 * Email ： 942685687@qq.com
 * Time ： 2019/5/7.
 */
public class RepairOrderAdapter extends BaseQuickAdapter<RepairOrderBean.DataBean.OrderListBean, BaseViewHolder> {

    private int type;

    public RepairOrderAdapter(@Nullable List<RepairOrderBean.DataBean.OrderListBean> data, int type) {
        super(R.layout.adapter_repair_order, data);
        this.type = type;
    }

    @Override
    protected void convert(BaseViewHolder helper, RepairOrderBean.DataBean.OrderListBean item) {
        Glide.with(ApplicationUtil.getContext()).load(BASE_LOCAL_URL + item.getLogo()).apply(new RequestOptions().placeholder(R.drawable.ic_launcher)).into((ImageView) helper.getView(R.id.iv_store_logo));

        helper.setText(R.id.tv_repair_order_num, "订单号: " + item.getOrderNo())
                .setText(R.id.tv_repair_order_time, "2019-05-07") //FIXME
                .setText(R.id.tv_store_name, item.getStoreName())
                .setText(R.id.tv_repair_order_project, "项目：" + item.getRepairs())
                .setText(R.id.tv_repair_order_service_type, "充电服务：" + item.getCharges());
        switch (type) {
            case 0:
                helper.setText(R.id.bt_repair_order_type, "进行中")
                        .setBackgroundRes(R.id.bt_repair_order_type, R.drawable.bg_repair_order_runing);
                break;
            case 1:
                helper.setText(R.id.bt_repair_order_type, "已完成")
                        .setBackgroundRes(R.id.bt_repair_order_type, R.drawable.bg_repair_order_end);
                break;
            case 2:
                helper.setText(R.id.bt_repair_order_type, "已取消")
                        .setBackgroundRes(R.id.bt_repair_order_type, R.drawable.bg_repair_order_cancel);
                break;
        }

    }
}
