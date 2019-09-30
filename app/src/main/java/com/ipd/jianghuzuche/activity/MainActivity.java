package com.ipd.jianghuzuche.activity;

import android.Manifest;
import android.app.Dialog;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.support.annotation.Nullable;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.content.ContextCompat;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.gyf.barlibrary.ImmersionBar;
import com.ipd.jianghuzuche.R;
import com.ipd.jianghuzuche.base.BaseActivity;
import com.ipd.jianghuzuche.bean.ModifyVersionBean;
import com.ipd.jianghuzuche.common.config.IConstants;
import com.ipd.jianghuzuche.common.view.CircleImageView;
import com.ipd.jianghuzuche.common.view.CustomUpdateParser;
import com.ipd.jianghuzuche.common.view.TopView;
import com.ipd.jianghuzuche.contract.ModifyVersionContract;
import com.ipd.jianghuzuche.fragment.PlaceOrderFragment;
import com.ipd.jianghuzuche.fragment.RepairFragment;
import com.ipd.jianghuzuche.fragment.SelectOrderFragment;
import com.ipd.jianghuzuche.presenter.ModifyVersionPresenter;
import com.ipd.jianghuzuche.utils.ApplicationUtil;
import com.ipd.jianghuzuche.utils.LogUtils;
import com.ipd.jianghuzuche.utils.NavigationBarUtil;
import com.ipd.jianghuzuche.utils.SPUtil;
import com.ipd.jianghuzuche.utils.ToastUtil;
import com.tbruyelle.rxpermissions2.RxPermissions;
import com.xuexiang.xupdate.XUpdate;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;
import io.reactivex.ObservableTransformer;
import io.reactivex.functions.Consumer;

import static android.Manifest.permission.CALL_PHONE;
import static com.ipd.jianghuzuche.common.config.IConstants.FIRST_APP;
import static com.ipd.jianghuzuche.common.config.IConstants.IS_LOGIN;
import static com.ipd.jianghuzuche.common.config.IConstants.LATIUDE;
import static com.ipd.jianghuzuche.common.config.IConstants.LONGTITUDE;
import static com.ipd.jianghuzuche.common.config.IConstants.PACKAGE_NAME;
import static com.ipd.jianghuzuche.common.config.IConstants.REQUEST_CODE_98;
import static com.ipd.jianghuzuche.common.config.IConstants.SERVICE_PHONE;
import static com.ipd.jianghuzuche.common.config.UrlConfig.BASE_URL;
import static com.ipd.jianghuzuche.common.config.UrlConfig.MODIFY_VERSION;
import static com.ipd.jianghuzuche.utils.AppUtils.getAppVersionName;

/**
 * Description ：主页
 * Author ： rmy
 * Email ： 942685687@qq.com
 * Time ： 2019/4/29.
 */
public class MainActivity extends BaseActivity<ModifyVersionContract.View, ModifyVersionContract.Presenter> implements ModifyVersionContract.View {

    @BindView(R.id.tv_main_top)
    TopView tvMainTop;
    @BindView(R.id.tv_top_title)
    public TextView tvTopTitle;
    @BindView(R.id.iv_top_msg)
    ImageView ivTopMsg;
    @BindView(R.id.iv_top_sidebar)
    ImageView ivTopSidebar;
    @BindView(R.id.ll_main)
    LinearLayout llMain;
    @BindView(R.id.vp_main)
    ViewPager vpMain;
    @BindView(R.id.rb_navigation_place_order)
    RadioButton rbNavigationPlaceOrder;
    @BindView(R.id.rb_navigation_select_order)
    RadioButton rbNavigationSelectOrder;
    @BindView(R.id.rb_navigation_repair)
    RadioButton rbNavigationRepair;
    @BindView(R.id.civ_sidebar_user_head)
    CircleImageView civSidebarUserHead;
    @BindView(R.id.tv_sidebar_user_name)
    TextView tvSidebarUserName;
    @BindView(R.id.tv_sidebar_user_phone)
    TextView tvSidebarUserPhone;
    @BindView(R.id.ll_sidebar_head)
    LinearLayout llSidebarHead;
    @BindView(R.id.iv_white_wallet)
    ImageView ivWhiteWallet;
    @BindView(R.id.iv_blue_wallet)
    ImageView ivBlueWallet;
    @BindView(R.id.iv_wallet)
    ImageView ivWallet;
    @BindView(R.id.tv_wallet)
    TextView tvWallet;
    @BindView(R.id.rl_wallet)
    RelativeLayout rlWallet;
    @BindView(R.id.iv_white_maintenance_order)
    ImageView ivWhiteMaintenanceOrder;
    @BindView(R.id.iv_blue_maintenance_order)
    ImageView ivBlueMaintenanceOrder;
    @BindView(R.id.iv_maintenance_order)
    ImageView ivMaintenanceOrder;
    @BindView(R.id.tv_maintenance_order)
    TextView tvMaintenanceOrder;
    @BindView(R.id.rl_maintenance_order)
    RelativeLayout rlMaintenanceOrder;
    @BindView(R.id.iv_white_customer_service)
    ImageView ivWhiteCustomerService;
    @BindView(R.id.iv_blue_customer_service)
    ImageView ivBlueCustomerService;
    @BindView(R.id.iv_customer_service)
    ImageView ivCustomerService;
    @BindView(R.id.tv_customer_service)
    TextView tvCustomerService;
    @BindView(R.id.rl_customer_service)
    RelativeLayout rlCustomerService;
    @BindView(R.id.iv_white_feedback)
    ImageView ivWhiteFeedback;
    @BindView(R.id.iv_blue_feedback)
    ImageView ivBlueFeedback;
    @BindView(R.id.iv_feedback)
    ImageView ivFeedback;
    @BindView(R.id.tv_feedback)
    TextView tvFeedback;
    @BindView(R.id.rl_feedback)
    RelativeLayout rlFeedback;
    @BindView(R.id.iv_white_coupon)
    ImageView ivWhiteCoupon;
    @BindView(R.id.iv_blue_coupon)
    ImageView ivBlueCoupon;
    @BindView(R.id.iv_coupon)
    ImageView ivCoupon;
    @BindView(R.id.tv_coupon)
    TextView tvCoupon;
    @BindView(R.id.rl_coupon)
    RelativeLayout rlCoupon;
    @BindView(R.id.iv_white_notice)
    ImageView ivWhiteNotice;
    @BindView(R.id.iv_blue_notice)
    ImageView ivBlueNotice;
    @BindView(R.id.iv_notice)
    ImageView ivNotice;
    @BindView(R.id.tv_notice)
    TextView tvNotice;
    @BindView(R.id.rl_notice)
    RelativeLayout rlNotice;
    @BindView(R.id.iv_white_setting)
    ImageView ivWhiteSetting;
    @BindView(R.id.iv_blue_setting)
    ImageView ivBlueSetting;
    @BindView(R.id.iv_setting)
    ImageView ivSetting;
    @BindView(R.id.tv_setting)
    TextView tvSetting;
    @BindView(R.id.rl_setting)
    RelativeLayout rlSetting;
    @BindView(R.id.ll_sidebar_main)
    LinearLayout llSidebarMain;
    @BindView(R.id.dl_main)
    DrawerLayout dlMain;
    @BindView(R.id.ll_not_sidebar_main)
    LinearLayout llNotSidebarMain;
    @BindView(R.id.iv_white_invitation_code)
    ImageView ivWhiteInvitationCode;
    @BindView(R.id.iv_blue_invitation_code)
    ImageView ivBlueInvitationCode;
    @BindView(R.id.iv_invitation_code)
    ImageView ivInvitationCode;
    @BindView(R.id.tv_invitation_code)
    TextView tvInvitationCode;
    @BindView(R.id.tv_user_invitation_code)
    TextView tvUserInvitationCode;
    @BindView(R.id.rl_invitation_code)
    RelativeLayout rlInvitationCode;

    private long firstTime = 0;
    private List<Integer> couponId = new ArrayList<>();
    private Fragment currentFragment = new Fragment();
    private PlaceOrderFragment placeOrderFragment = new PlaceOrderFragment();
    private SelectOrderFragment selectOrderFragment = new SelectOrderFragment();
    private RepairFragment repairFragment = new RepairFragment();
    /**
     * 获取权限使用的 RequestCode
     */
    private static final int PERMISSIONS_REQUEST_CODE = 1002;

    @Override
    public int getLayoutId() {
        return R.layout.activity_main;
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
        //适配虚拟按键
        if (NavigationBarUtil.hasNavigationBar(this)) {
            NavigationBarUtil.initActivity(findViewById(android.R.id.content));
        }
        //将每个Activity加入到栈中
        ApplicationUtil.getManager().addActivity(this);
        //防止状态栏和标题重叠
        ImmersionBar.setTitleBar(this, tvMainTop);

        SPUtil.put(this, FIRST_APP, false);

        requestPermission(); //权限

        //上一层界面跳过来时，要求显示对的碎片
        switch (getIntent().getIntExtra("howPage", 0)) {
            case 0:
                rbNavigationPlaceOrder.setChecked(true);
                switchFragment(placeOrderFragment).commit();
                break;
            case 1:
                rbNavigationSelectOrder.setChecked(true);
                switchFragment(selectOrderFragment).commit();
                break;
            case 2:
                rbNavigationRepair.setChecked(true);
                switchFragment(repairFragment).commit();
                break;
        }

        Glide.with(this).load(SPUtil.get(this, IConstants.AVATAR, "")).apply(new RequestOptions()).into(civSidebarUserHead);
        tvSidebarUserName.setText((String) SPUtil.get(this, IConstants.NAME, ""));
        tvSidebarUserPhone.setText((String) SPUtil.get(this, IConstants.PHONE, ""));
        tvUserInvitationCode.setText((String) SPUtil.get(this, IConstants.INVITAION_CODE, ""));

        //定义底部标签SVG图片大小
        Drawable drawableHome = getResources().getDrawable(R.drawable.select_bg_place_order);
        drawableHome.setBounds(0, 0, (int) getResources().getDimension(R.dimen.y60), (int) getResources().getDimension(R.dimen.y60));//第一0是距左右边距离，第二0是距上下边距离，第三长度,第四宽度
        rbNavigationPlaceOrder.setCompoundDrawables(null, drawableHome, null, null);//只放上面

        Drawable drawableFutures = getResources().getDrawable(R.drawable.select_bg_select_order);
        drawableFutures.setBounds(0, 0, (int) getResources().getDimension(R.dimen.y60), (int) getResources().getDimension(R.dimen.y60));//第一0是距左右边距离，第二0是距上下边距离，第三长度,第四宽度
        rbNavigationSelectOrder.setCompoundDrawables(null, drawableFutures, null, null);//只放上面

        Drawable drawableShares = getResources().getDrawable(R.drawable.select_bg_repair);
        drawableShares.setBounds(0, 0, (int) getResources().getDimension(R.dimen.y60), (int) getResources().getDimension(R.dimen.y60));//第一0是距左右边距离，第二0是距上下边距离，第三长度,第四宽度
        rbNavigationRepair.setCompoundDrawables(null, drawableShares, null, null);//只放上面

        dlMain.setDrawerLockMode(DrawerLayout.LOCK_MODE_LOCKED_CLOSED);
        dlMain.setScrimColor(Color.TRANSPARENT);//侧滑菜单打开后主内容区域的颜色
        dlMain.addDrawerListener(drawerListener);

        //定义侧边栏标签SVG图片大小
        ivBlueWallet.setImageResource(R.drawable.bg_sidebar_item_select);
        ViewGroup.LayoutParams paramsBlueWallet = ivBlueWallet.getLayoutParams();
        paramsBlueWallet.width = 15;
        ivBlueWallet.setLayoutParams(paramsBlueWallet);

        ivWallet.setImageResource(R.drawable.ic_wallet_gray);
        ViewGroup.LayoutParams paramsWalletGray = ivWallet.getLayoutParams();
        paramsWalletGray.height = 50;
        paramsWalletGray.width = 50;
        ivWallet.setLayoutParams(paramsWalletGray);

        ivWallet.setImageResource(R.drawable.ic_wallet);
        ViewGroup.LayoutParams paramsWalletSelect = ivWallet.getLayoutParams();
        paramsWalletSelect.height = 50;
        paramsWalletSelect.width = 50;
        ivWallet.setLayoutParams(paramsWalletSelect);

        ivBlueMaintenanceOrder.setImageResource(R.drawable.bg_sidebar_item_select);
        ViewGroup.LayoutParams paramsBlueMaintenanceOrder = ivBlueMaintenanceOrder.getLayoutParams();
        paramsBlueMaintenanceOrder.width = 15;
        ivBlueMaintenanceOrder.setLayoutParams(paramsBlueMaintenanceOrder);

        ivMaintenanceOrder.setImageResource(R.drawable.ic_maintenance_order);
        ViewGroup.LayoutParams paramsMaintenanceOrderSelect = ivMaintenanceOrder.getLayoutParams();
        paramsMaintenanceOrderSelect.height = 50;
        paramsMaintenanceOrderSelect.width = 50;
        ivMaintenanceOrder.setLayoutParams(paramsMaintenanceOrderSelect);

        ivMaintenanceOrder.setImageResource(R.drawable.ic_maintenance_order_gray);
        ViewGroup.LayoutParams paramsMaintenanceOrderGray = ivMaintenanceOrder.getLayoutParams();
        paramsMaintenanceOrderGray.height = 50;
        paramsMaintenanceOrderGray.width = 50;
        ivMaintenanceOrder.setLayoutParams(paramsMaintenanceOrderGray);

        ivBlueCustomerService.setImageResource(R.drawable.bg_sidebar_item_select);
        ViewGroup.LayoutParams paramsBlueCustomerService = ivBlueCustomerService.getLayoutParams();
        paramsBlueCustomerService.width = 15;
        ivBlueCustomerService.setLayoutParams(paramsBlueCustomerService);

        ivCustomerService.setImageResource(R.drawable.ic_customer_service);
        ViewGroup.LayoutParams paramsCustomerServiceSelect = ivCustomerService.getLayoutParams();
        paramsCustomerServiceSelect.height = 50;
        paramsCustomerServiceSelect.width = 50;
        ivCustomerService.setLayoutParams(paramsCustomerServiceSelect);

        ivCustomerService.setImageResource(R.drawable.ic_customer_service_gray);
        ViewGroup.LayoutParams paramsCustomerServiceGray = ivCustomerService.getLayoutParams();
        paramsCustomerServiceGray.height = 50;
        paramsCustomerServiceGray.width = 50;
        ivCustomerService.setLayoutParams(paramsCustomerServiceGray);

        ivBlueFeedback.setImageResource(R.drawable.bg_sidebar_item_select);
        ViewGroup.LayoutParams paramsBlueFeedback = ivBlueFeedback.getLayoutParams();
        paramsBlueFeedback.width = 15;
        ivBlueFeedback.setLayoutParams(paramsBlueFeedback);

        ivFeedback.setImageResource(R.drawable.ic_feedback);
        ViewGroup.LayoutParams paramsFeedbackSelect = ivFeedback.getLayoutParams();
        paramsFeedbackSelect.height = 50;
        paramsFeedbackSelect.width = 50;
        ivFeedback.setLayoutParams(paramsFeedbackSelect);

        ivFeedback.setImageResource(R.drawable.ic_feedback_gray);
        ViewGroup.LayoutParams paramsFeedbackGray = ivFeedback.getLayoutParams();
        paramsFeedbackGray.height = 50;
        paramsFeedbackGray.width = 50;
        ivFeedback.setLayoutParams(paramsFeedbackGray);

        ivBlueCoupon.setImageResource(R.drawable.bg_sidebar_item_select);
        ViewGroup.LayoutParams paramsBlueCoupon = ivBlueCoupon.getLayoutParams();
        paramsBlueCoupon.width = 15;
        ivBlueCoupon.setLayoutParams(paramsBlueCoupon);

        ivCoupon.setImageResource(R.drawable.ic_coupon);
        ViewGroup.LayoutParams paramsCouponSelect = ivCoupon.getLayoutParams();
        paramsCouponSelect.height = 50;
        paramsCouponSelect.width = 50;
        ivCoupon.setLayoutParams(paramsCouponSelect);

        ivCoupon.setImageResource(R.drawable.ic_coupon_gray);
        ViewGroup.LayoutParams paramsCouponGray = ivCoupon.getLayoutParams();
        paramsCouponGray.height = 50;
        paramsCouponGray.width = 50;
        ivCoupon.setLayoutParams(paramsCouponGray);

        ivBlueNotice.setImageResource(R.drawable.bg_sidebar_item_select);
        ViewGroup.LayoutParams paramsBlueNotice = ivBlueNotice.getLayoutParams();
        paramsBlueNotice.width = 15;
        ivBlueNotice.setLayoutParams(paramsBlueNotice);

        ivNotice.setImageResource(R.drawable.ic_notice);
        ViewGroup.LayoutParams paramsNoticeSelect = ivFeedback.getLayoutParams();
        paramsNoticeSelect.height = 50;
        paramsNoticeSelect.width = 50;
        ivNotice.setLayoutParams(paramsNoticeSelect);

        ivNotice.setImageResource(R.drawable.ic_notice_gray);
        ViewGroup.LayoutParams paramsNoticeGray = ivFeedback.getLayoutParams();
        paramsNoticeGray.height = 50;
        paramsNoticeGray.width = 50;
        ivNotice.setLayoutParams(paramsNoticeGray);

        ivBlueInvitationCode.setImageResource(R.drawable.bg_sidebar_item_select);
        ViewGroup.LayoutParams paramsBlueInvitationCode = ivBlueInvitationCode.getLayoutParams();
        paramsBlueInvitationCode.width = 15;
        ivBlueInvitationCode.setLayoutParams(paramsBlueInvitationCode);

        ivInvitationCode.setImageResource(R.drawable.ic_invitation_code);
        ViewGroup.LayoutParams paramsInvitationCodeSelect = ivInvitationCode.getLayoutParams();
        paramsInvitationCodeSelect.height = 50;
        paramsInvitationCodeSelect.width = 50;
        ivInvitationCode.setLayoutParams(paramsInvitationCodeSelect);

        ivInvitationCode.setImageResource(R.drawable.ic_invitation_code_gray);
        ViewGroup.LayoutParams paramsInvitationCode = ivInvitationCode.getLayoutParams();
        paramsInvitationCode.height = 50;
        paramsInvitationCode.width = 50;
        ivInvitationCode.setLayoutParams(paramsInvitationCode);

        ivBlueSetting.setImageResource(R.drawable.bg_sidebar_item_select);
        ViewGroup.LayoutParams paramsBlueSetting = ivBlueSetting.getLayoutParams();
        paramsBlueSetting.width = 15;
        ivBlueSetting.setLayoutParams(paramsBlueSetting);

        ivSetting.setImageResource(R.drawable.ic_setting);
        ViewGroup.LayoutParams paramsSettingSelect = ivSetting.getLayoutParams();
        paramsSettingSelect.height = 50;
        paramsSettingSelect.width = 50;
        ivSetting.setLayoutParams(paramsSettingSelect);

        ivSetting.setImageResource(R.drawable.ic_setting_gray);
        ViewGroup.LayoutParams paramsSetting = ivSetting.getLayoutParams();
        paramsSetting.height = 50;
        paramsSetting.width = 50;
        ivSetting.setLayoutParams(paramsSetting);
    }

    @Override
    public void initListener() {

    }

    @Override
    public void initData() {
        //版本更新
        XUpdate.newBuild(this)
                .updateUrl(BASE_URL + MODIFY_VERSION)
                .isAutoMode(true) //如果需要完全无人干预，自动更新，需要root权限【静默安装需要】
                .updateParser(new CustomUpdateParser()) //设置自定义的版本更新解析器
                .update();
//        TreeMap<String, String> modifyVersionMap = new TreeMap<>();
//        modifyVersionMap.put("platform", "1");
//        modifyVersionMap.put("type", "1");
//        getPresenter().getModifyVersion(modifyVersionMap, false, false);
    }

    /**
     * 检查支付宝 SDK 所需的权限，并在必要的时候动态获取。
     * 在 targetSDK = 23 以上，READ_PHONE_STATE 和 WRITE_EXTERNAL_STORAGE 权限需要应用在运行时获取。
     * 如果接入支付宝 SDK 的应用 targetSdk 在 23 以下，可以省略这个步骤。
     */
    private void requestPermission() {
        // Here, thisActivity is the current activity
        if (ContextCompat.checkSelfPermission(this, Manifest.permission.READ_PHONE_STATE)
                != PackageManager.PERMISSION_GRANTED
                || ContextCompat.checkSelfPermission(this, Manifest.permission.WRITE_EXTERNAL_STORAGE)
                != PackageManager.PERMISSION_GRANTED
                || ContextCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION)
                != PackageManager.PERMISSION_GRANTED
                || ContextCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION)
                != PackageManager.PERMISSION_GRANTED) {

            ActivityCompat.requestPermissions(this,
                    new String[]{
                            Manifest.permission.READ_PHONE_STATE,
                            Manifest.permission.WRITE_EXTERNAL_STORAGE,
                            Manifest.permission.ACCESS_FINE_LOCATION,
                            Manifest.permission.ACCESS_COARSE_LOCATION
                    }, PERMISSIONS_REQUEST_CODE);
        }
    }

    /**
     * 权限获取回调
     */
    @Override
    public void onRequestPermissionsResult(int requestCode, String permissions[], int[] grantResults) {
        switch (requestCode) {
            case PERMISSIONS_REQUEST_CODE:
                // 用户取消了权限弹窗
                if (grantResults.length == 0) {
                    ToastUtil.showShortToast(getString(R.string.permission_rejected));
                    return;
                }

                // 用户拒绝了某些权限
                for (int x : grantResults) {
                    if (x == PackageManager.PERMISSION_DENIED) {
                        ToastUtil.showShortToast(getString(R.string.permission_rejected));
                        return;
                    }
                }

                placeOrderFragment.Permissions();
                // 所需的权限均正常获取
                //                ToastUtil.showShortToast(getString(R.string.permission_granted));
                break;
        }
    }

    //Fragment优化
    public FragmentTransaction switchFragment(Fragment targetFragment) {
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        if (!targetFragment.isAdded()) {
            //第一次使用switchFragment()时currentFragment为null，所以要判断一下
            if (currentFragment != null) {
                transaction.hide(currentFragment);
            }
            transaction.add(R.id.ll_main, targetFragment, targetFragment.getClass().getName());
        } else {
            transaction
                    .hide(currentFragment)
                    .show(targetFragment);
        }
        currentFragment = targetFragment;
        return transaction;
    }

    DrawerLayout.DrawerListener drawerListener = new DrawerLayout.DrawerListener() {
        @Override
        public void onDrawerSlide(View drawerView, float slideOffset) {
            // 得到contentView
            View content = dlMain.getChildAt(0);
            int offset = (int) (drawerView.getWidth() * slideOffset);
            content.setTranslationX(offset);
        }

        @Override
        public void onDrawerOpened(View drawerView) {

        }

        @Override
        public void onDrawerClosed(View drawerView) {

        }

        @Override
        public void onDrawerStateChanged(int newState) {

        }
    };

    private void setCenterDialog() {
        TextView tv;
        final Dialog mCameraDialog = new Dialog(this, R.style.BottomDialog);
        //Dialog布局
        LinearLayout root = (LinearLayout) LayoutInflater.from(this).inflate(R.layout.dialog_center, null);
        root.findViewById(R.id.tv_dialog_center_start).setVisibility(View.VISIBLE);
        tv = root.findViewById(R.id.tv_dialog_center_end);
        tv.setText(SPUtil.get(this, SERVICE_PHONE, "") + "");
        //初始化视图
        root.findViewById(R.id.dialog_center_confirm).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                rxPermissionCall();
                mCameraDialog.dismiss();
            }
        });
        root.findViewById(R.id.dialog_center_cancel).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mCameraDialog.dismiss();
            }
        });
        mCameraDialog.setContentView(root);
        Window dialogWindow = mCameraDialog.getWindow();
        dialogWindow.setGravity(Gravity.CENTER); //设置弹出方式
        WindowManager.LayoutParams lp = dialogWindow.getAttributes(); // 获取对话框当前的参数值
        lp.x = 0; // 新位置X坐标
        lp.y = 0; // 新位置Y坐标
        lp.width = 700;
        root.measure(0, 0);
        lp.height = 320;

        lp.alpha = 9f; // 透明度
        dialogWindow.setAttributes(lp);
        mCameraDialog.show();
    }

    private void rxPermissionCall() {
        RxPermissions rxPermissions = new RxPermissions((FragmentActivity) this);
        rxPermissions.request(CALL_PHONE).subscribe(new Consumer<Boolean>() {
            @Override
            public void accept(Boolean granted) throws Exception {
                if (granted) {
                    callPhone();
                } else {
                    // 权限被拒绝
                    ToastUtil.showLongToast("权限被拒绝");
                }
            }
        });
    }

    //打电话
    private void callPhone() {
        Intent intent = new Intent(Intent.ACTION_CALL);
        Uri data = Uri.parse("tel:" + SPUtil.get(this, SERVICE_PHONE, ""));//TODO  客服电话
        intent.setData(data);
        if (ActivityCompat.checkSelfPermission(this, CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
            // TODO: Consider calling
            //    ActivityCompat#requestPermissions
            // here to request the missing permissions, and then overriding
            //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
            //                                          int[] grantResults)
            // to handle the case where the user grants the permission. See the documentation
            // for ActivityCompat#requestPermissions for more details.
            return;
        }
        startActivity(intent);
    }

    private void setCenterModifyVersionDialog() {
        TextView tv;
        final Dialog mCameraDialog = new Dialog(this, R.style.BottomDialog);
        //Dialog布局
        LinearLayout root = (LinearLayout) LayoutInflater.from(this).inflate(R.layout.dialog_center, null);
        root.findViewById(R.id.tv_dialog_center_start).setVisibility(View.GONE);
        tv = root.findViewById(R.id.tv_dialog_center_end);
        tv.setText("请先登录");
        //初始化视图
        root.findViewById(R.id.dialog_center_confirm).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                if ((Boolean) (SPUtil.get(MainActivity.this, IConstants.IS_LOGIN, false)) == false) {
                startActivity(new Intent(MainActivity.this, LoginActivity.class));
                SPUtil.put(MainActivity.this, IS_LOGIN, false);
                finish();
//                }
//                else if ((Boolean) (SPUtil.get(MainActivity.this, IConstants.IS_SUPPLEMENT_INFO, false)) == false) {
//                    startActivity(new Intent(MainActivity.this, SupplementInfoActivity.class).putExtra("review_type", Integer.valueOf(SPUtil.get(MainActivity.this, REVIEW, "") + "")));
//                    finish();
//                }
                mCameraDialog.dismiss();
            }
        });
        root.findViewById(R.id.dialog_center_cancel).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mCameraDialog.dismiss();
            }
        });
        mCameraDialog.setContentView(root);
        Window dialogWindow = mCameraDialog.getWindow();
        dialogWindow.setGravity(Gravity.CENTER); //设置弹出方式
        WindowManager.LayoutParams lp = dialogWindow.getAttributes(); // 获取对话框当前的参数值
        lp.x = 0; // 新位置X坐标
        lp.y = 0; // 新位置Y坐标
        lp.width = 700;
        root.measure(0, 0);
        lp.height = 320;

        lp.alpha = 9f; // 透明度
        dialogWindow.setAttributes(lp);
        mCameraDialog.show();
    }

    /**
     * 双击退出程序
     */
    @Override
    public void onBackPressed() {
        long secondTime = System.currentTimeMillis();
        if (secondTime - firstTime > 2000) {
            ToastUtil.showShortToast(getResources().getString(R.string.click_out_again));
            firstTime = secondTime;
        } else {
            ApplicationUtil.getManager().exitApp();
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (data != null) {
            switch (requestCode) {
                case IConstants.REQUEST_CODE_98:
                    Glide.with(this).load(SPUtil.get(this, IConstants.AVATAR, "")).apply(new RequestOptions()).into(civSidebarUserHead);
                    tvSidebarUserName.setText((String) SPUtil.get(this, IConstants.NAME, ""));
                    break;
            }
        }
    }

    @OnClick({R.id.iv_top_msg, R.id.iv_top_sidebar, R.id.rb_navigation_place_order, R.id.rb_navigation_select_order, R.id.rb_navigation_repair, R.id.ll_sidebar_head, R.id.rl_wallet, R.id.rl_maintenance_order, R.id.rl_customer_service, R.id.rl_feedback, R.id.rl_coupon, R.id.rl_notice, R.id.rl_invitation_code, R.id.rl_setting})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.iv_top_msg:
                if ((Boolean) (SPUtil.get(this, IConstants.IS_LOGIN, false)) == false) {
                    setCenterModifyVersionDialog();
                } else if ((Boolean) (SPUtil.get(this, IConstants.IS_SUPPLEMENT_INFO, false)) == false) {
                    setCenterModifyVersionDialog();
                } else
                    startActivity(new Intent(this, MsgActivity.class));
                break;
            case R.id.iv_top_sidebar:
                if ((Boolean) (SPUtil.get(this, IConstants.IS_LOGIN, false)) == false)
                    setCenterModifyVersionDialog();
                else if ((Boolean) (SPUtil.get(this, IConstants.IS_SUPPLEMENT_INFO, false)) == false)
                    setCenterModifyVersionDialog();
                else {
                    if (!dlMain.isDrawerOpen(llSidebarMain)) {
                        dlMain.openDrawer(llSidebarMain);
                    }
                }
                break;
            case R.id.rb_navigation_place_order:
                switchFragment(placeOrderFragment).commit();
                break;
            case R.id.rb_navigation_select_order:
                if ((Boolean) (SPUtil.get(this, IConstants.IS_LOGIN, false)) == false)
                    setCenterModifyVersionDialog();
                else if ((Boolean) (SPUtil.get(this, IConstants.IS_SUPPLEMENT_INFO, false)) == false)
                    setCenterModifyVersionDialog();
                else
                    switchFragment(selectOrderFragment).commit();
                break;
            case R.id.rb_navigation_repair:
                LogUtils.i("rmy", "维修保养  LATIUDE = " + SPUtil.get(this, LATIUDE, "") + ", LONGTITUDE = " + SPUtil.get(this, LONGTITUDE, ""));
                if ((SPUtil.get(this, LATIUDE, "") + "").indexOf("E") == -1) {
                    switchFragment(repairFragment).commit();
                } else
                    ToastUtil.showShortToast("请重新获取位置...");
                break;
            case R.id.ll_sidebar_head:
                startActivityForResult(new Intent(this, PersonalDataActivity.class), REQUEST_CODE_98);
                break;
            case R.id.rl_wallet:
                startActivity(new Intent(this, WalletActivity.class));

                ivWhiteWallet.setVisibility(View.VISIBLE);
                ivBlueWallet.setVisibility(View.VISIBLE);
                ivWallet.setImageDrawable(this.getResources().getDrawable(R.drawable.ic_wallet));
                tvWallet.setTextColor(this.getResources().getColor(R.color.tx_select_fragment));

                ivWhiteMaintenanceOrder.setVisibility(View.GONE);
                ivBlueMaintenanceOrder.setVisibility(View.INVISIBLE);
                ivMaintenanceOrder.setImageDrawable(this.getResources().getDrawable(R.drawable.ic_maintenance_order_gray));
                tvMaintenanceOrder.setTextColor(this.getResources().getColor(R.color.black));

                ivWhiteCustomerService.setVisibility(View.GONE);
                ivBlueCustomerService.setVisibility(View.INVISIBLE);
                ivCustomerService.setImageDrawable(this.getResources().getDrawable(R.drawable.ic_customer_service_gray));
                tvCustomerService.setTextColor(this.getResources().getColor(R.color.black));

                ivWhiteFeedback.setVisibility(View.GONE);
                ivBlueFeedback.setVisibility(View.INVISIBLE);
                ivFeedback.setImageDrawable(this.getResources().getDrawable(R.drawable.ic_feedback_gray));
                tvFeedback.setTextColor(this.getResources().getColor(R.color.black));

                ivWhiteCoupon.setVisibility(View.GONE);
                ivBlueCoupon.setVisibility(View.INVISIBLE);
                ivCoupon.setImageDrawable(this.getResources().getDrawable(R.drawable.ic_coupon_gray));
                tvCoupon.setTextColor(this.getResources().getColor(R.color.black));

                ivWhiteNotice.setVisibility(View.GONE);
                ivBlueNotice.setVisibility(View.INVISIBLE);
                ivNotice.setImageDrawable(this.getResources().getDrawable(R.drawable.ic_notice_gray));
                tvNotice.setTextColor(this.getResources().getColor(R.color.black));

                ivWhiteInvitationCode.setVisibility(View.GONE);
                ivBlueInvitationCode.setVisibility(View.INVISIBLE);
                ivInvitationCode.setImageDrawable(this.getResources().getDrawable(R.drawable.ic_invitation_code_gray));
                tvInvitationCode.setTextColor(this.getResources().getColor(R.color.black));

                ivWhiteSetting.setVisibility(View.GONE);
                ivBlueSetting.setVisibility(View.INVISIBLE);
                ivSetting.setImageDrawable(this.getResources().getDrawable(R.drawable.ic_setting_gray));
                tvSetting.setTextColor(this.getResources().getColor(R.color.black));
                break;
            case R.id.rl_maintenance_order:
                startActivity(new Intent(this, RepairOrderActivity.class));

                ivWhiteWallet.setVisibility(View.GONE);
                ivBlueWallet.setVisibility(View.INVISIBLE);
                ivWallet.setImageDrawable(this.getResources().getDrawable(R.drawable.ic_wallet_gray));
                tvWallet.setTextColor(this.getResources().getColor(R.color.black));

                ivWhiteMaintenanceOrder.setVisibility(View.VISIBLE);
                ivBlueMaintenanceOrder.setVisibility(View.VISIBLE);
                ivMaintenanceOrder.setImageDrawable(this.getResources().getDrawable(R.drawable.ic_maintenance_order));
                tvMaintenanceOrder.setTextColor(this.getResources().getColor(R.color.tx_select_fragment));

                ivWhiteCustomerService.setVisibility(View.GONE);
                ivBlueCustomerService.setVisibility(View.INVISIBLE);
                ivCustomerService.setImageDrawable(this.getResources().getDrawable(R.drawable.ic_customer_service_gray));
                tvCustomerService.setTextColor(this.getResources().getColor(R.color.black));

                ivWhiteFeedback.setVisibility(View.GONE);
                ivBlueFeedback.setVisibility(View.INVISIBLE);
                ivFeedback.setImageDrawable(this.getResources().getDrawable(R.drawable.ic_feedback_gray));
                tvFeedback.setTextColor(this.getResources().getColor(R.color.black));

                ivWhiteCoupon.setVisibility(View.GONE);
                ivBlueCoupon.setVisibility(View.INVISIBLE);
                ivCoupon.setImageDrawable(this.getResources().getDrawable(R.drawable.ic_coupon_gray));
                tvCoupon.setTextColor(this.getResources().getColor(R.color.black));

                ivWhiteNotice.setVisibility(View.GONE);
                ivBlueNotice.setVisibility(View.INVISIBLE);
                ivNotice.setImageDrawable(this.getResources().getDrawable(R.drawable.ic_notice_gray));
                tvNotice.setTextColor(this.getResources().getColor(R.color.black));

                ivWhiteInvitationCode.setVisibility(View.GONE);
                ivBlueInvitationCode.setVisibility(View.INVISIBLE);
                ivInvitationCode.setImageDrawable(this.getResources().getDrawable(R.drawable.ic_invitation_code_gray));
                tvInvitationCode.setTextColor(this.getResources().getColor(R.color.black));

                ivWhiteSetting.setVisibility(View.GONE);
                ivBlueSetting.setVisibility(View.INVISIBLE);
                ivSetting.setImageDrawable(this.getResources().getDrawable(R.drawable.ic_setting_gray));
                tvSetting.setTextColor(this.getResources().getColor(R.color.black));
                break;
            case R.id.rl_customer_service:
                setCenterDialog();

                ivWhiteWallet.setVisibility(View.GONE);
                ivBlueWallet.setVisibility(View.INVISIBLE);
                ivWallet.setImageDrawable(this.getResources().getDrawable(R.drawable.ic_wallet_gray));
                tvWallet.setTextColor(this.getResources().getColor(R.color.black));

                ivWhiteMaintenanceOrder.setVisibility(View.GONE);
                ivBlueMaintenanceOrder.setVisibility(View.INVISIBLE);
                ivMaintenanceOrder.setImageDrawable(this.getResources().getDrawable(R.drawable.ic_maintenance_order_gray));
                tvMaintenanceOrder.setTextColor(this.getResources().getColor(R.color.black));

                ivWhiteCustomerService.setVisibility(View.VISIBLE);
                ivBlueCustomerService.setVisibility(View.VISIBLE);
                ivCustomerService.setImageDrawable(this.getResources().getDrawable(R.drawable.ic_customer_service));
                tvCustomerService.setTextColor(this.getResources().getColor(R.color.tx_select_fragment));

                ivWhiteFeedback.setVisibility(View.GONE);
                ivBlueFeedback.setVisibility(View.INVISIBLE);
                ivFeedback.setImageDrawable(this.getResources().getDrawable(R.drawable.ic_feedback_gray));
                tvFeedback.setTextColor(this.getResources().getColor(R.color.black));

                ivWhiteCoupon.setVisibility(View.GONE);
                ivBlueCoupon.setVisibility(View.INVISIBLE);
                ivCoupon.setImageDrawable(this.getResources().getDrawable(R.drawable.ic_coupon_gray));
                tvCoupon.setTextColor(this.getResources().getColor(R.color.black));

                ivWhiteNotice.setVisibility(View.GONE);
                ivBlueNotice.setVisibility(View.INVISIBLE);
                ivNotice.setImageDrawable(this.getResources().getDrawable(R.drawable.ic_notice_gray));
                tvNotice.setTextColor(this.getResources().getColor(R.color.black));

                ivWhiteInvitationCode.setVisibility(View.GONE);
                ivBlueInvitationCode.setVisibility(View.INVISIBLE);
                ivInvitationCode.setImageDrawable(this.getResources().getDrawable(R.drawable.ic_invitation_code_gray));
                tvInvitationCode.setTextColor(this.getResources().getColor(R.color.black));

                ivWhiteSetting.setVisibility(View.GONE);
                ivBlueSetting.setVisibility(View.INVISIBLE);
                ivSetting.setImageDrawable(this.getResources().getDrawable(R.drawable.ic_setting_gray));
                tvSetting.setTextColor(this.getResources().getColor(R.color.black));
                break;
            case R.id.rl_feedback:
                startActivity(new Intent(this, FeedBackActivity.class));

                ivWhiteWallet.setVisibility(View.GONE);
                ivBlueWallet.setVisibility(View.INVISIBLE);
                ivWallet.setImageDrawable(this.getResources().getDrawable(R.drawable.ic_wallet_gray));
                tvWallet.setTextColor(this.getResources().getColor(R.color.black));

                ivWhiteMaintenanceOrder.setVisibility(View.GONE);
                ivBlueMaintenanceOrder.setVisibility(View.INVISIBLE);
                ivMaintenanceOrder.setImageDrawable(this.getResources().getDrawable(R.drawable.ic_maintenance_order_gray));
                tvMaintenanceOrder.setTextColor(this.getResources().getColor(R.color.black));

                ivWhiteCustomerService.setVisibility(View.GONE);
                ivBlueCustomerService.setVisibility(View.INVISIBLE);
                ivCustomerService.setImageDrawable(this.getResources().getDrawable(R.drawable.ic_customer_service_gray));
                tvCustomerService.setTextColor(this.getResources().getColor(R.color.black));

                ivWhiteFeedback.setVisibility(View.VISIBLE);
                ivBlueFeedback.setVisibility(View.VISIBLE);
                ivFeedback.setImageDrawable(this.getResources().getDrawable(R.drawable.ic_feedback));
                tvFeedback.setTextColor(this.getResources().getColor(R.color.tx_select_fragment));

                ivWhiteCoupon.setVisibility(View.GONE);
                ivBlueCoupon.setVisibility(View.INVISIBLE);
                ivCoupon.setImageDrawable(this.getResources().getDrawable(R.drawable.ic_coupon_gray));
                tvCoupon.setTextColor(this.getResources().getColor(R.color.black));

                ivWhiteNotice.setVisibility(View.GONE);
                ivBlueNotice.setVisibility(View.INVISIBLE);
                ivNotice.setImageDrawable(this.getResources().getDrawable(R.drawable.ic_notice_gray));
                tvNotice.setTextColor(this.getResources().getColor(R.color.black));

                ivWhiteInvitationCode.setVisibility(View.GONE);
                ivBlueInvitationCode.setVisibility(View.INVISIBLE);
                ivInvitationCode.setImageDrawable(this.getResources().getDrawable(R.drawable.ic_invitation_code_gray));
                tvInvitationCode.setTextColor(this.getResources().getColor(R.color.black));

                ivWhiteSetting.setVisibility(View.GONE);
                ivBlueSetting.setVisibility(View.INVISIBLE);
                ivSetting.setImageDrawable(this.getResources().getDrawable(R.drawable.ic_setting_gray));
                tvSetting.setTextColor(this.getResources().getColor(R.color.black));
                break;
            case R.id.rl_coupon:
                startActivity(new Intent(this, UserCouponActivity.class).putExtra("coupon_type", 1).putIntegerArrayListExtra("coupon_id", (ArrayList<Integer>) couponId));

                ivWhiteWallet.setVisibility(View.GONE);
                ivBlueWallet.setVisibility(View.INVISIBLE);
                ivWallet.setImageDrawable(this.getResources().getDrawable(R.drawable.ic_wallet_gray));
                tvWallet.setTextColor(this.getResources().getColor(R.color.black));

                ivWhiteMaintenanceOrder.setVisibility(View.GONE);
                ivBlueMaintenanceOrder.setVisibility(View.INVISIBLE);
                ivMaintenanceOrder.setImageDrawable(this.getResources().getDrawable(R.drawable.ic_maintenance_order_gray));
                tvMaintenanceOrder.setTextColor(this.getResources().getColor(R.color.black));

                ivWhiteCustomerService.setVisibility(View.GONE);
                ivBlueCustomerService.setVisibility(View.INVISIBLE);
                ivCustomerService.setImageDrawable(this.getResources().getDrawable(R.drawable.ic_customer_service_gray));
                tvCustomerService.setTextColor(this.getResources().getColor(R.color.black));

                ivWhiteFeedback.setVisibility(View.GONE);
                ivBlueFeedback.setVisibility(View.INVISIBLE);
                ivFeedback.setImageDrawable(this.getResources().getDrawable(R.drawable.ic_feedback_gray));
                tvFeedback.setTextColor(this.getResources().getColor(R.color.black));

                ivWhiteCoupon.setVisibility(View.VISIBLE);
                ivBlueCoupon.setVisibility(View.VISIBLE);
                ivCoupon.setImageDrawable(this.getResources().getDrawable(R.drawable.ic_coupon));
                tvCoupon.setTextColor(this.getResources().getColor(R.color.tx_select_fragment));

                ivWhiteNotice.setVisibility(View.GONE);
                ivBlueNotice.setVisibility(View.INVISIBLE);
                ivNotice.setImageDrawable(this.getResources().getDrawable(R.drawable.ic_notice_gray));
                tvNotice.setTextColor(this.getResources().getColor(R.color.black));

                ivWhiteInvitationCode.setVisibility(View.GONE);
                ivBlueInvitationCode.setVisibility(View.INVISIBLE);
                ivInvitationCode.setImageDrawable(this.getResources().getDrawable(R.drawable.ic_invitation_code_gray));
                tvInvitationCode.setTextColor(this.getResources().getColor(R.color.black));

                ivWhiteSetting.setVisibility(View.GONE);
                ivBlueSetting.setVisibility(View.INVISIBLE);
                ivSetting.setImageDrawable(this.getResources().getDrawable(R.drawable.ic_setting_gray));
                tvSetting.setTextColor(this.getResources().getColor(R.color.black));
                break;
            case R.id.rl_notice:
                startActivity(new Intent(this, WebViewActivity.class).putExtra("h5Type", 3));

                ivWhiteWallet.setVisibility(View.GONE);
                ivBlueWallet.setVisibility(View.INVISIBLE);
                ivWallet.setImageDrawable(this.getResources().getDrawable(R.drawable.ic_wallet_gray));
                tvWallet.setTextColor(this.getResources().getColor(R.color.black));

                ivWhiteMaintenanceOrder.setVisibility(View.GONE);
                ivBlueMaintenanceOrder.setVisibility(View.INVISIBLE);
                ivMaintenanceOrder.setImageDrawable(this.getResources().getDrawable(R.drawable.ic_maintenance_order_gray));
                tvMaintenanceOrder.setTextColor(this.getResources().getColor(R.color.black));

                ivWhiteCustomerService.setVisibility(View.GONE);
                ivBlueCustomerService.setVisibility(View.INVISIBLE);
                ivCustomerService.setImageDrawable(this.getResources().getDrawable(R.drawable.ic_customer_service_gray));
                tvCustomerService.setTextColor(this.getResources().getColor(R.color.black));

                ivWhiteFeedback.setVisibility(View.GONE);
                ivBlueFeedback.setVisibility(View.INVISIBLE);
                ivFeedback.setImageDrawable(this.getResources().getDrawable(R.drawable.ic_feedback_gray));
                tvFeedback.setTextColor(this.getResources().getColor(R.color.black));

                ivWhiteCoupon.setVisibility(View.GONE);
                ivBlueCoupon.setVisibility(View.INVISIBLE);
                ivCoupon.setImageDrawable(this.getResources().getDrawable(R.drawable.ic_coupon_gray));
                tvCoupon.setTextColor(this.getResources().getColor(R.color.black));

                ivWhiteNotice.setVisibility(View.VISIBLE);
                ivBlueNotice.setVisibility(View.VISIBLE);
                ivNotice.setImageDrawable(this.getResources().getDrawable(R.drawable.ic_notice));
                tvNotice.setTextColor(this.getResources().getColor(R.color.tx_select_fragment));

                ivWhiteInvitationCode.setVisibility(View.GONE);
                ivBlueInvitationCode.setVisibility(View.INVISIBLE);
                ivInvitationCode.setImageDrawable(this.getResources().getDrawable(R.drawable.ic_invitation_code_gray));
                tvInvitationCode.setTextColor(this.getResources().getColor(R.color.black));

                ivWhiteSetting.setVisibility(View.GONE);
                ivBlueSetting.setVisibility(View.INVISIBLE);
                ivSetting.setImageDrawable(this.getResources().getDrawable(R.drawable.ic_setting_gray));
                tvSetting.setTextColor(this.getResources().getColor(R.color.black));
                break;
            case R.id.rl_invitation_code:
                startActivity(new Intent(this, ShareActivity.class));

                ivWhiteWallet.setVisibility(View.GONE);
                ivBlueWallet.setVisibility(View.INVISIBLE);
                ivWallet.setImageDrawable(this.getResources().getDrawable(R.drawable.ic_wallet_gray));
                tvWallet.setTextColor(this.getResources().getColor(R.color.black));

                ivWhiteMaintenanceOrder.setVisibility(View.GONE);
                ivBlueMaintenanceOrder.setVisibility(View.INVISIBLE);
                ivMaintenanceOrder.setImageDrawable(this.getResources().getDrawable(R.drawable.ic_maintenance_order_gray));
                tvMaintenanceOrder.setTextColor(this.getResources().getColor(R.color.black));

                ivWhiteCustomerService.setVisibility(View.GONE);
                ivBlueCustomerService.setVisibility(View.INVISIBLE);
                ivCustomerService.setImageDrawable(this.getResources().getDrawable(R.drawable.ic_customer_service_gray));
                tvCustomerService.setTextColor(this.getResources().getColor(R.color.black));

                ivWhiteFeedback.setVisibility(View.GONE);
                ivBlueFeedback.setVisibility(View.INVISIBLE);
                ivFeedback.setImageDrawable(this.getResources().getDrawable(R.drawable.ic_feedback_gray));
                tvFeedback.setTextColor(this.getResources().getColor(R.color.black));

                ivWhiteCoupon.setVisibility(View.GONE);
                ivBlueCoupon.setVisibility(View.INVISIBLE);
                ivCoupon.setImageDrawable(this.getResources().getDrawable(R.drawable.ic_coupon_gray));
                tvCoupon.setTextColor(this.getResources().getColor(R.color.black));

                ivWhiteNotice.setVisibility(View.GONE);
                ivBlueNotice.setVisibility(View.INVISIBLE);
                ivNotice.setImageDrawable(this.getResources().getDrawable(R.drawable.ic_notice_gray));
                tvNotice.setTextColor(this.getResources().getColor(R.color.black));

                ivWhiteInvitationCode.setVisibility(View.VISIBLE);
                ivBlueInvitationCode.setVisibility(View.VISIBLE);
                ivInvitationCode.setImageDrawable(this.getResources().getDrawable(R.drawable.ic_invitation_code));
                tvInvitationCode.setTextColor(this.getResources().getColor(R.color.tx_select_fragment));

                ivWhiteSetting.setVisibility(View.GONE);
                ivBlueSetting.setVisibility(View.INVISIBLE);
                ivSetting.setImageDrawable(this.getResources().getDrawable(R.drawable.ic_setting_gray));
                tvSetting.setTextColor(this.getResources().getColor(R.color.black));
                break;
            case R.id.rl_setting:
                startActivity(new Intent(this, SettingsActivity.class));

                ivWhiteWallet.setVisibility(View.GONE);
                ivBlueWallet.setVisibility(View.INVISIBLE);
                ivWallet.setImageDrawable(this.getResources().getDrawable(R.drawable.ic_wallet_gray));
                tvWallet.setTextColor(this.getResources().getColor(R.color.black));

                ivWhiteMaintenanceOrder.setVisibility(View.GONE);
                ivBlueMaintenanceOrder.setVisibility(View.INVISIBLE);
                ivMaintenanceOrder.setImageDrawable(this.getResources().getDrawable(R.drawable.ic_maintenance_order_gray));
                tvMaintenanceOrder.setTextColor(this.getResources().getColor(R.color.black));

                ivWhiteCustomerService.setVisibility(View.GONE);
                ivBlueCustomerService.setVisibility(View.INVISIBLE);
                ivCustomerService.setImageDrawable(this.getResources().getDrawable(R.drawable.ic_customer_service_gray));
                tvCustomerService.setTextColor(this.getResources().getColor(R.color.black));

                ivWhiteFeedback.setVisibility(View.GONE);
                ivBlueFeedback.setVisibility(View.INVISIBLE);
                ivFeedback.setImageDrawable(this.getResources().getDrawable(R.drawable.ic_feedback_gray));
                tvFeedback.setTextColor(this.getResources().getColor(R.color.black));

                ivWhiteCoupon.setVisibility(View.GONE);
                ivBlueCoupon.setVisibility(View.INVISIBLE);
                ivCoupon.setImageDrawable(this.getResources().getDrawable(R.drawable.ic_coupon_gray));
                tvCoupon.setTextColor(this.getResources().getColor(R.color.black));

                ivWhiteNotice.setVisibility(View.GONE);
                ivBlueNotice.setVisibility(View.INVISIBLE);
                ivNotice.setImageDrawable(this.getResources().getDrawable(R.drawable.ic_notice_gray));
                tvNotice.setTextColor(this.getResources().getColor(R.color.black));

                ivWhiteInvitationCode.setVisibility(View.GONE);
                ivBlueInvitationCode.setVisibility(View.INVISIBLE);
                ivInvitationCode.setImageDrawable(this.getResources().getDrawable(R.drawable.ic_invitation_code_gray));
                tvInvitationCode.setTextColor(this.getResources().getColor(R.color.black));

                ivWhiteSetting.setVisibility(View.VISIBLE);
                ivBlueSetting.setVisibility(View.VISIBLE);
                ivSetting.setImageDrawable(this.getResources().getDrawable(R.drawable.ic_setting));
                tvSetting.setTextColor(this.getResources().getColor(R.color.tx_select_fragment));
                break;
        }
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
            }
        } else
            ToastUtil.showLongToast(data.getMsg());
    }

    @Override
    public <T> ObservableTransformer<T, T> bindLifecycle() {
        return this.bindToLifecycle();
    }
}
