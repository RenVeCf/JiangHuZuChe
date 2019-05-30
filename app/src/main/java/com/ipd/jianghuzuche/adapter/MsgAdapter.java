package com.ipd.jianghuzuche.adapter;

import android.support.annotation.Nullable;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.ipd.jianghuzuche.R;
import com.ipd.jianghuzuche.bean.MsgBean;

import java.util.List;

/**
 * Description ：
 * Author ： MengYang
 * Email ： 942685687@qq.com
 * Time ： 2019/5/9.
 */
public class MsgAdapter extends BaseQuickAdapter<MsgBean.DataBean.MessageListBean, BaseViewHolder> {
    public MsgAdapter(@Nullable List<MsgBean.DataBean.MessageListBean> data) {
        super(R.layout.adapter_msg, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, MsgBean.DataBean.MessageListBean item) {
        helper.setText(R.id.tv_msg, item.getTitle())
                .setText(R.id.tv_to_do, item.getContent());
    }
}
