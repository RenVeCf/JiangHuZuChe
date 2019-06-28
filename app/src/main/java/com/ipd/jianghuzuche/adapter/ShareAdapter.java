package com.ipd.jianghuzuche.adapter;

import android.support.annotation.Nullable;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.ipd.jianghuzuche.R;
import com.ipd.jianghuzuche.bean.ShareBean;
import com.ipd.jianghuzuche.utils.ApplicationUtil;

import java.util.List;

import static com.ipd.jianghuzuche.common.config.UrlConfig.BASE_LOCAL_URL;

/**
 * Description ：
 * Author ： MengYang
 * Email ： 942685687@qq.com
 * Time ： 2019/5/9.
 */
public class ShareAdapter extends BaseQuickAdapter<ShareBean.DataBean.AppInvitationBean, BaseViewHolder> {
    public ShareAdapter(@Nullable List<ShareBean.DataBean.AppInvitationBean> data) {
        super(R.layout.adapter_share, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, ShareBean.DataBean.AppInvitationBean item) {
        Glide.with(ApplicationUtil.getContext()).load(BASE_LOCAL_URL + item.getAvatar()).apply(new RequestOptions()).into((ImageView) helper.getView(R.id.civ_head));
        helper.setText(R.id.tv_phone, item.getTelPhone())
                .setText(R.id.tv_date, item.getCreateTime());
    }
}
