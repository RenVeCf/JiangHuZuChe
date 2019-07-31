package com.ipd.jianghuzuche.activity;

import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

import com.gyf.barlibrary.ImmersionBar;
import com.ipd.jianghuzuche.R;
import com.ipd.jianghuzuche.base.BaseActivity;
import com.ipd.jianghuzuche.bean.ModifyVersionBean;
import com.ipd.jianghuzuche.common.view.CustomUpdateParser;
import com.ipd.jianghuzuche.common.view.TopView;
import com.ipd.jianghuzuche.contract.ModifyVersionContract;
import com.ipd.jianghuzuche.presenter.ModifyVersionPresenter;
import com.ipd.jianghuzuche.utils.ApplicationUtil;
import com.ipd.jianghuzuche.utils.CacheUtil;
import com.ipd.jianghuzuche.utils.SPUtil;
import com.ipd.jianghuzuche.utils.ToastUtil;
import com.xuexiang.xupdate.XUpdate;

import java.util.List;
import java.util.TreeMap;

import butterknife.BindView;
import butterknife.OnClick;
import cn.jpush.android.api.JPushInterface;
import io.reactivex.ObservableTransformer;

import static com.ipd.jianghuzuche.common.config.IConstants.JPUSH_SEQUENCE;
import static com.ipd.jianghuzuche.common.config.IConstants.PACKAGE_NAME;
import static com.ipd.jianghuzuche.common.config.UrlConfig.BASE_URL;
import static com.ipd.jianghuzuche.common.config.UrlConfig.MODIFY_VERSION;
import static com.ipd.jianghuzuche.utils.AppUtils.getAppVersionName;

public class SettingsActivity extends BaseActivity<ModifyVersionContract.View, ModifyVersionContract.Presenter> implements ModifyVersionContract.View {

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
    public ModifyVersionContract.Presenter createPresenter() {
        return new ModifyVersionPresenter(this);
    }

    @Override
    public ModifyVersionContract.View createView() {
        return this;
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

    /**
     * 检测程序是否安装
     *
     * @param packageName
     * @return
     */
    private boolean isInstalled(String packageName) {
        PackageManager manager = this.getPackageManager();
        //获取所有已安装程序的包信息
        List<PackageInfo> installedPackages = manager.getInstalledPackages(0);
        if (installedPackages != null) {
            for (PackageInfo info : installedPackages) {
                if (info.packageName.equals(packageName))
                    return true;
            }
        }
        return false;
    }

    @Override
    public void resultModifyVersion(ModifyVersionBean data) {
        if (data.getCode() == 200) {
            if (!getAppVersionName(this, PACKAGE_NAME).equals(data.getData().getVersionYes().getVersionNo())) {
                if (!isInstalled("com.baidu.appsearch")) {
                    ToastUtil.showShortToast("请先安装百度手机助手客户端");
                    return;
                }
                Intent intent = new Intent(Intent.ACTION_VIEW);
                Uri uri = Uri.parse("market://details?id=" + PACKAGE_NAME);//app包名
                intent.setData(uri);
                intent.setPackage("com.baidu.appsearch");//百度手机助手包名
                intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(intent);
            } else
                ToastUtil.showLongToast("应用已是最新版本");
        } else
            ToastUtil.showLongToast(data.getMsg());
    }

    @OnClick({R.id.ll_clear_app, R.id.ll_check_version, R.id.ll_about_us, R.id.bt_settings})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.ll_clear_app:
                CacheUtil.clearAllCache(this);
                break;
            case R.id.ll_check_version:
                //版本更新
                XUpdate.newBuild(this)
                        .updateUrl(BASE_URL + MODIFY_VERSION)
                        .isAutoMode(true) //如果需要完全无人干预，自动更新，需要root权限【静默安装需要】
                        .updateParser(new CustomUpdateParser()) //设置自定义的版本更新解析器
                        .update();
//                TreeMap<String, String> modifyVersionMap = new TreeMap<>();
//                modifyVersionMap.put("platform", "1");
//                modifyVersionMap.put("type", "1");
//                getPresenter().getModifyVersion(modifyVersionMap, false, false);
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

    @Override
    public <T> ObservableTransformer<T, T> bindLifecycle() {
        return this.bindToLifecycle();
    }
}