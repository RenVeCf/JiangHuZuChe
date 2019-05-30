package com.ipd.jianghuzuche.adapter;

import android.support.annotation.Nullable;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.ipd.jianghuzuche.R;
import com.ipd.jianghuzuche.utils.ApplicationUtil;

import java.util.List;

import static com.ipd.jianghuzuche.common.config.UrlConfig.BASE_LOCAL_URL;

/**
 * Description ：
 * Author ： MengYang
 * Email ： 942685687@qq.com
 * Time ： 2019/5/16.
 */
public class CarPhotoAdapter extends BaseQuickAdapter<String, BaseViewHolder> {
    public CarPhotoAdapter(@Nullable List<String> data) {
        super(R.layout.adapter_car_photo, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, String item) {
        Glide.with(ApplicationUtil.getContext()).load(BASE_LOCAL_URL + item).apply(new RequestOptions().placeholder(R.drawable.bg_photo)).into((ImageView) helper.getView(R.id.iv_car_photo));
    }
}
