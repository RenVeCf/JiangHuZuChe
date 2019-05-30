package com.ipd.jianghuzuche.activity;

import android.app.Activity;
import android.content.Intent;

import com.bumptech.glide.Glide;
import com.ipd.jianghuzuche.R;
import com.ipd.jianghuzuche.base.BaseActivity;
import com.ipd.jianghuzuche.base.BasePresenter;
import com.ipd.jianghuzuche.base.BaseView;
import com.ipd.jianghuzuche.utils.ApplicationUtil;
import com.ipd.jianghuzuche.weight.scaleimage.PhotoView;
import com.ipd.jianghuzuche.weight.scaleimage.PhotoViewAttacher;

import butterknife.BindView;

import static com.ipd.jianghuzuche.common.config.UrlConfig.BASE_LOCAL_URL;

/**
 * Description ：图片放大
 * Author ： rmy
 * Email ： 942685687@qq.com
 * Time ： 2019/4/8.
 */
public class BigImageActivity extends BaseActivity {
    @BindView(R.id.pv_image)
    PhotoView pvImage;

    public static final String PATH = "image_path";

    public static void launch(Activity activity, String path) {
        Intent intent = new Intent(activity, BigImageActivity.class);
        intent.putExtra(PATH, path);
        activity.startActivity(intent);
    }

    @Override
    public int getLayoutId() {
        return R.layout.activity_bigimage;
    }

    @Override
    public BasePresenter createPresenter() {
        return null;
    }


    @Override
    public BaseView createView() {
        return null;
    }

    @Override
    public void init() {
        //将每个Activity加入到栈中
        ApplicationUtil.getManager().addActivity(this);
        Glide.with(this).load(BASE_LOCAL_URL + getIntent().getStringExtra(PATH)).into(pvImage);
    }

    @Override
    public void initListener() {
        pvImage.setClickListener(new PhotoViewAttacher.onClickListener() {
            @Override
            public void onClick() {
                finish();
            }
        });
    }

    @Override
    public void initData() {
    }
}
