package com.ipd.jianghuzuche.base;

import android.content.pm.ActivityInfo;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.inputmethod.InputMethodManager;

import com.gyf.barlibrary.ImmersionBar;
import com.ipd.jianghuzuche.common.view.AndroidBug5497Workaround;
import com.trello.rxlifecycle2.components.support.RxAppCompatActivity;

import butterknife.ButterKnife;


/**
 * Description ：父类->基类->动态指定类型->泛型设计（通过泛型指定动态类型->由子类指定，父类只需要规定范围即可）
 * Author ： MengYang
 * Email ： 942685687@qq.com
 * Time ： 2018/8/27.
 */
public abstract class BaseActivity<V extends BaseView, P extends BasePresenter<V>> extends RxAppCompatActivity {

    //引用V层和P层
    private P presenter;
    private V view;
    public Bundle savedInstanceState;
//    PermissionUtils.PermissionGrant mPermissionGrant;

    public P getPresenter() {
        return presenter;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        //防止getFragment为null
        if (savedInstanceState != null) {
            savedInstanceState.remove("android:support:fragments");
        }
        super.onCreate(savedInstanceState);
        this.savedInstanceState = savedInstanceState;
        //键盘不遮盖输入框
//        getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_ADJUST_PAN);
        setContentView(getLayoutId());
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        AndroidBug5497Workaround.assistActivity(this);
        //控件绑定初始化
        ButterKnife.bind(this);
        //沉浸式状态栏初始化
        ImmersionBar.with(this).fitsSystemWindows(false).statusBarDarkFont(true).init();
        if (presenter == null) {
            presenter = createPresenter();
        }
        if (view == null) {
            view = createView();
        }
        if (presenter != null && view != null) {
            presenter.attachView(view);
        }
        /**
         * 初始化
         */
        init();

        /**
         * 事件
         */
        initListener();

        /**
         * 数据
         */
        initData();
    }
//
//    //权限回调
//    private OnPermissionListener OnPermissionListener;
//
//    public void setOnPermissionListener(OnPermissionListener OnPermissionListener) {
//        this.OnPermissionListener = OnPermissionListener;
//    }
//
//    public interface OnPermissionListener {
//        void openIntent();
//    }
//
//    //权限请求
//    public void openPermission(int[] code_permission) {
//        mPermissionGrant = new PermissionUtils.PermissionGrant() {
//            @Override
//            public void onPermissionGranted(int requestCode) {
//                if (OnPermissionListener != null) {
//                    OnPermissionListener.openIntent();
//                }
//            }
//        };
//        if (code_permission.length <= 0) {
//            return;
//        } else if (code_permission.length == 1) {
//            PermissionUtils.requestPermission(BaseActivity.this, code_permission[0], mPermissionGrant);
//        } else {
//            PermissionUtils.requestMultiPermissions(BaseActivity.this, code_permission, mPermissionGrant);
//        }
//    }
//
//    //请求权限回调方法（必须实现OnRequestPermissionsResultCallback接口)
//    @Override
//    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
//        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
//        PermissionUtils.requestPermissionsResult(BaseActivity.this, requestCode, permissions, grantResults, mPermissionGrant);
//    }

    //由子类指定具体类型
    public abstract int getLayoutId();

    public abstract P createPresenter();

    public abstract V createView();

    public abstract void init();

    public abstract void initListener();

    public abstract void initData();

    /**
     * 防止手机字体调整，统一return字体大小
     *
     * @return
     */
    @Override
    public Resources getResources() {
        Resources res = super.getResources();
        Configuration config = new Configuration();
        config.setToDefaults();
        res.updateConfiguration(config, res.getDisplayMetrics());
        return res;
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        if (null != this.getCurrentFocus()) {
            /**
             * 点击空白位置 隐藏软键盘
             */
            InputMethodManager mInputMethodManager = (InputMethodManager) getSystemService(INPUT_METHOD_SERVICE);
            return mInputMethodManager.hideSoftInputFromWindow(this.getCurrentFocus().getWindowToken(), 0);
        }
        return super.onTouchEvent(event);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        //沉浸式状态栏注销
        ImmersionBar.with(this).destroy(); //不调用该方法，如果界面bar发生改变，在不关闭app的情况下，退出此界面再进入将记忆最后一次bar改变的状态
        if (presenter != null) {
            presenter.detachView();
        }
    }
}