package com.ipd.jianghuzuche.activity;

import android.content.Intent;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

import com.gyf.barlibrary.ImmersionBar;
import com.ipd.jianghuzuche.R;
import com.ipd.jianghuzuche.base.BaseActivity;
import com.ipd.jianghuzuche.base.BasePresenter;
import com.ipd.jianghuzuche.base.BaseView;
import com.ipd.jianghuzuche.common.view.TopView;
import com.ipd.jianghuzuche.utils.ApplicationUtil;
import com.ipd.jianghuzuche.utils.CacheUtil;
import com.ipd.jianghuzuche.utils.SPUtil;

import butterknife.BindView;
import butterknife.OnClick;
import cn.jpush.android.api.JPushInterface;

import static com.ipd.jianghuzuche.common.config.IConstants.JPUSH_SEQUENCE;

public class SettingsActivity extends BaseActivity {

    @BindView(R.id.tv_settings_top)
    TopView tvSettingsTop;
    @BindView(R.id.ll_clear_app)
    LinearLayout llClearApp;
    @BindView(R.id.ll_about_us)
    LinearLayout llAboutUs;
    @BindView(R.id.bt_settings)
    Button btSettings;

    @Override
    public int getLayoutId() {
        return R.layout.activity_settings;
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
        //防止状态栏和标题重叠
        ImmersionBar.setTitleBar(this, tvSettingsTop);
    }

    @Override
    public void initListener() {

    }

    @Override
    public void initData() {

    }

    @OnClick({R.id.ll_clear_app, R.id.ll_about_us, R.id.bt_settings})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.ll_clear_app:
                CacheUtil.clearAllCache(this);
                break;
            case R.id.ll_about_us:
                startActivity(new Intent(this, WebViewActivity.class).putExtra("h5Type", 7));
                break;
            case R.id.bt_settings:
                // 退出登录删除别名
                JPushInterface.deleteAlias(this, JPUSH_SEQUENCE);
                ApplicationUtil.getManager().finishActivity(MainActivity.class);
                //清除所有临时储存
                SPUtil.clear(ApplicationUtil.getContext());
                startActivity(new Intent(this, LoginActivity.class));
                finish();
                break;
        }
    }
}