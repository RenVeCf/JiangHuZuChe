package com.ipd.jianghuzuche.activity;

import android.app.Dialog;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.os.Parcelable;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.text.Html;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.baidu.mapapi.model.LatLng;
import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.google.gson.Gson;
import com.gyf.barlibrary.ImmersionBar;
import com.ipd.jianghuzuche.R;
import com.ipd.jianghuzuche.adapter.ViewPagerAdapter;
import com.ipd.jianghuzuche.base.BaseActivity;
import com.ipd.jianghuzuche.bean.ChargeBean;
import com.ipd.jianghuzuche.bean.ChoiceStoreBean;
import com.ipd.jianghuzuche.bean.RepairConfirmBean;
import com.ipd.jianghuzuche.bean.RepairProjectHorizontalBean;
import com.ipd.jianghuzuche.bean.StoreDetailsBean;
import com.ipd.jianghuzuche.common.config.IConstants;
import com.ipd.jianghuzuche.common.view.AutoHeightViewPager;
import com.ipd.jianghuzuche.common.view.NavitationLayout;
import com.ipd.jianghuzuche.common.view.TopView;
import com.ipd.jianghuzuche.contract.StoreDetailsContract;
import com.ipd.jianghuzuche.fragment.RepairProjectVerticalFragment;
import com.ipd.jianghuzuche.presenter.StoreDetailsPresenter;
import com.ipd.jianghuzuche.utils.ApplicationUtil;
import com.ipd.jianghuzuche.utils.LogUtils;
import com.ipd.jianghuzuche.utils.NumberUtils;
import com.ipd.jianghuzuche.utils.SPUtil;
import com.ipd.jianghuzuche.utils.ToastUtil;
import com.ryane.banner.AdPageInfo;
import com.ryane.banner.AdPlayBanner;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import butterknife.BindView;
import butterknife.OnClick;
import io.reactivex.ObservableTransformer;

import static android.Manifest.permission.CALL_PHONE;
import static com.ipd.jianghuzuche.common.config.IConstants.IS_LOGIN;
import static com.ipd.jianghuzuche.common.config.IConstants.SERVICE_PHONE;
import static com.ipd.jianghuzuche.common.config.IConstants.USER_ID;
import static com.ipd.jianghuzuche.common.config.UrlConfig.BASE_LOCAL_URL;
import static com.ipd.jianghuzuche.utils.ExchangeMapUtil.BD2GCJ;
import static com.ipd.jianghuzuche.utils.isClickUtil.isFastClick;
import static com.ryane.banner.AdPlayBanner.ImageLoaderType.GLIDE;

/**
 * Description ：门店详情
 * Author ： rmy
 * Email ： 942685687@qq.com
 * Time ： 2019/5/5.
 */
public class StoreDetailsActivity extends BaseActivity<StoreDetailsContract.View, StoreDetailsContract.Presenter> implements StoreDetailsContract.View {

    @BindView(R.id.tv_store_details_top)
    TopView tvStoreDetailsTop;
    @BindView(R.id.tv_top_title)
    TextView tvTopTitle;
    @BindView(R.id.ab_store_details)
    AdPlayBanner abStoreDetails;
    @BindView(R.id.tv_store_name)
    TextView tvStoreName;
    @BindView(R.id.tv_store_distance)
    TextView tvStoreDistance;
    @BindView(R.id.tv_store_phone)
    TextView tvStorePhone;
    @BindView(R.id.tv_store_call_phone)
    TextView tvStoreCallPhone;
    @BindView(R.id.tv_store_path)
    TextView tvStorePath;
    @BindView(R.id.tv_go_store)
    TextView tvGoStore;
    @BindView(R.id.bt_store_details)
    Button btStoreDetails;
    @BindView(R.id.ll_repair)
    LinearLayout llRepair;
    @BindView(R.id.tv_charge_frist_num)
    TextView tvChargeFristNum;
    @BindView(R.id.ll_charge_frist)
    LinearLayout llChargeFrist;
    @BindView(R.id.tv_charge_second_num)
    TextView tvChargeSecondNum;
    @BindView(R.id.ll_charge_second)
    LinearLayout llChargeSecond;
    @BindView(R.id.tv_charge_three_num)
    TextView tvChargeThreeNum;
    @BindView(R.id.ll_charge_three)
    LinearLayout llChargeThree;
    @BindView(R.id.ll_charge)
    LinearLayout llCharge;
    @BindView(R.id.iv_frist_reduce)
    ImageView ivFristReduce;
    @BindView(R.id.iv_frist_plus)
    ImageView ivFristPlus;
    @BindView(R.id.iv_second_reduce)
    ImageView ivSecondReduce;
    @BindView(R.id.iv_second_plus)
    ImageView ivSecondPlus;
    @BindView(R.id.iv_three_reduce)
    ImageView ivThreeReduce;
    @BindView(R.id.iv_three_plus)
    ImageView ivThreePlus;
    @BindView(R.id.nl_store_infor)
    NavitationLayout nlStoreInfor;
    @BindView(R.id.vp_store_infor)
    public AutoHeightViewPager vpStoreInfor;
    @BindView(R.id.tv_charge_frist)
    TextView tvChargeFrist;
    @BindView(R.id.tv_charge_frist_fee)
    TextView tvChargeFristFee;
    @BindView(R.id.tv_charge_second)
    TextView tvChargeSecond;
    @BindView(R.id.tv_charge_second_fee)
    TextView tvChargeSecondFee;
    @BindView(R.id.tv_charge_three)
    TextView tvChargeThree;
    @BindView(R.id.tv_charge_three_fee)
    TextView tvChargeThreeFee;
    @BindView(R.id.ll_store_details)
    LinearLayout llStoreDetails;
    @BindView(R.id.iv_charge_frist)
    ImageView ivChargeFrist;
    @BindView(R.id.iv_charge_second)
    ImageView ivChargeSecond;
    @BindView(R.id.iv_charge_three)
    ImageView ivChargeThree;

    private int chargeType = 0;
    private String[] picPath = null;
    private String[] chargePath = null;
    private int type;
    private List<AdPageInfo> images;
    private ChoiceStoreBean.DataBean.StoreListBean storeListBean = new ChoiceStoreBean.DataBean.StoreListBean();
    private ViewPagerAdapter viewPagerAdapter;
    private List<Fragment> fragments;
    private List<ChargeBean.DataBean.ChargeListBean> chargeListBean;
    private RepairProjectVerticalFragment fm;
    private List<RepairProjectHorizontalBean.DataBean.RepairTypeBean> repairProjectHorizontalBean = new ArrayList<>();
    private String chargeId = "";

    @Override
    public int getLayoutId() {
        return R.layout.activity_store_details;
    }

    @Override
    public StoreDetailsContract.Presenter createPresenter() {
        return new StoreDetailsPresenter(this);
    }

    @Override
    public StoreDetailsContract.View createView() {
        return this;
    }

    @Override
    public void init() {
        //将每个Activity加入到栈中
        ApplicationUtil.getManager().addActivity(this);
        //防止状态栏和标题重叠
        ImmersionBar.setTitleBar(this, tvStoreDetailsTop);

        type = getIntent().getIntExtra("store_type", 0);
        storeListBean = getIntent().getParcelableExtra("store_details");

        tvTopTitle.setText(storeListBean.getStoreName());
        if (type == 0) {
            btStoreDetails.setText("预订车辆");
            btStoreDetails.setVisibility(View.VISIBLE);
            llStoreDetails.setVisibility(View.GONE);
        } else if (type == 1) {
            llRepair.setVisibility(View.VISIBLE);
            llCharge.setVisibility(View.VISIBLE);
            btStoreDetails.setText("确认下单");
        }

        chargeListBean = new ArrayList<>();
        images = new ArrayList<>();
        fragments = new ArrayList<>();
    }

    @Override
    public void initListener() {

    }

    @Override
    public void initData() {
        tvStoreName.setText(storeListBean.getStoreName());
        tvStoreDistance.setText(NumberUtils.formatTwoDecimal((float) storeListBean.getDistance() / 1000) + "km");
        tvStorePhone.setText("联系电话: " + storeListBean.getContactsPhone());
        tvStorePath.setText("地址: " + storeListBean.getDescAddress());
        try {
            picPath = storeListBean.getPicPath().split(",");
            for (int i = 0; i < picPath.length; i++) {
                AdPageInfo info1 = new AdPageInfo("", BASE_LOCAL_URL + picPath[i], "", i + 1);
                images.add(info1);
            }
            abStoreDetails.setInfoList(images)
                    .setImageLoadType(GLIDE)
                    .setUp();
        } catch (NullPointerException e) {

        }

        if (type == 1) {
            TreeMap<String, String> repairProjectHorizontalMap = new TreeMap<>();
            repairProjectHorizontalMap.put("storeId", storeListBean.getStoreId() + "");
            getPresenter().getRepairProjectHorizontal(repairProjectHorizontalMap, false, false);

            TreeMap<String, String> storeDetailsMap = new TreeMap<>();
//            storeDetailsMap.put("userId", SPUtil.get(this, USER_ID, "") + "");
            storeDetailsMap.put("storeId", storeListBean.getStoreId() + "");
            getPresenter().getStoreDetails(storeDetailsMap, false, false);
//
//            TreeMap<String, String> chargeMap = new TreeMap<>();
//            chargeMap.put("city", SPUtil.get(this, CITY, "") + "");
//            getPresenter().getCharge(chargeMap, false, false);
        }
    }

    private void setCenterDialog() {
        TextView tv;
        final Dialog mCameraDialog = new Dialog(this, R.style.BottomDialog);
        //Dialog布局
        LinearLayout root = (LinearLayout) LayoutInflater.from(this).inflate(R.layout.dialog_center, null);
        root.findViewById(R.id.tv_dialog_center_start).setVisibility(View.VISIBLE);
        tv = root.findViewById(R.id.tv_dialog_center_end);
        tv.setText(storeListBean.getContactsPhone());
        //初始化视图
        root.findViewById(R.id.dialog_center_confirm).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                callPhone();
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

    //打电话
    private void callPhone() {
        Intent intent = new Intent(Intent.ACTION_CALL);
        Uri data = Uri.parse("tel:" + SERVICE_PHONE);//TODO  客服电话
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

    private void setDocumentsReceivedDialog() {
        final TextView tv;
        final Dialog mCameraDialog = new Dialog(this, R.style.BottomDialog);
        //Dialog布局
        LinearLayout root = (LinearLayout) LayoutInflater.from(this).inflate(R.layout.dialog_toast, null);
        tv = root.findViewById(R.id.tv_content);
        String str = "请确保您选择的<font color='#FFBA6B'>服务项目已经过维修师傅确认</font>，支付后不可更改";
        tv.setText(Html.fromHtml(str));

        //初始化视图
        root.findViewById(R.id.bt_dialog_toast).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (isFastClick()) {
                    if (chargeType != 0 || !fm.getLoadStringTwo().equals("")) {
                        TreeMap<String, String> loginMap = new TreeMap<>();
                        loginMap.put("userId", SPUtil.get(StoreDetailsActivity.this, USER_ID, "") + "");
                        if (chargeType != 0) {
                            LogUtils.i("rmy", "0000 = " + getLoadString());
                            loginMap.put("charges", getLoadString());
                        }
                        if (!fm.getLoadStringTwo().equals("")) {
                            LogUtils.i("rmy", "1111 = " + getLoadString());
                            loginMap.put("repairs", fm.getLoadStringTwo());
                        }
                        loginMap.put("storeId", storeListBean.getStoreId() + "");
                        getPresenter().getRepairConfirm(loginMap, false, false);
                    } else
                        ToastUtil.showLongToast("请选择服务！");
                    mCameraDialog.dismiss();
                }
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
        lp.height = 650;

        lp.alpha = 9f; // 透明度
        dialogWindow.setAttributes(lp);
        mCameraDialog.show();
    }

    private String getLoadString() {
        List<Map<String, String>> listMap = new ArrayList<>();
        Map<String, String> map = new HashMap<>();
        map.put("chargeId", chargeListBean.get(chargeType - 1).getChargeId() + "");
        switch (chargeType){
            case 1:
                map.put("title", tvChargeFrist.getText().toString().trim());
                map.put("cost", tvChargeFristFee.getText().toString().trim().replaceAll("费用","").replaceAll("元", ""));
                break;
            case 2:
                map.put("title", tvChargeSecond.getText().toString().trim());
                map.put("cost", tvChargeSecondFee.getText().toString().trim().replaceAll("费用","").replaceAll("元", ""));
                break;
            case 3:
                map.put("title", tvChargeThree.getText().toString().trim());
                map.put("cost", tvChargeThreeFee.getText().toString().trim().replaceAll("费用","").replaceAll("元", ""));
                break;
        }
//        map.put("title", chargeListBean.get(chargeType - 1).getTitle());
//        for (int i = 0; i < chargeListBean.size(); i++) {
            LogUtils.i("rmy", "chargeType = " + chargeType);
//        }
//        map.put("cost", chargeListBean.get(chargeType - 1).getCost() + "");
        if (!tvChargeFristNum.getText().toString().equals("0"))
            map.put("chargeNum", tvChargeFristNum.getText().toString());
        else if (!tvChargeSecondNum.getText().toString().equals("0"))
            map.put("chargeNum", tvChargeSecondNum.getText().toString());
        else if (!tvChargeThreeNum.getText().toString().equals("0"))
            map.put("chargeNum", tvChargeThreeNum.getText().toString());
        listMap.add(map);
        Gson g = new Gson();
        String jsonString = g.toJson(listMap);
        return jsonString;
    }

    private void setCenterLoginDialog() {
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
//                if ((Boolean) (SPUtil.get(StoreDetailsActivity.this, IConstants.IS_LOGIN, false)) == false) {
                startActivity(new Intent(StoreDetailsActivity.this, LoginActivity.class));
                SPUtil.put(StoreDetailsActivity.this, IS_LOGIN, false);
                finish();
//                }
//                else if ((Boolean) (SPUtil.get(StoreDetailsActivity.this, IConstants.IS_SUPPLEMENT_INFO, false)) == false) {
//                    startActivity(new Intent(StoreDetailsActivity.this, SupplementInfoActivity.class).putExtra("review_type", Integer.valueOf(SPUtil.get(StoreDetailsActivity.this, REVIEW, "") + "")));
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

    @OnClick({R.id.iv_frist_reduce, R.id.iv_frist_plus, R.id.iv_second_reduce, R.id.iv_second_plus, R.id.iv_three_reduce, R.id.iv_three_plus, R.id.tv_store_call_phone, R.id.tv_go_store, R.id.bt_store_details})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.iv_frist_reduce:
                if (Integer.parseInt(tvChargeFristNum.getText().toString().trim()) > 0)
                    tvChargeFristNum.setText(Integer.parseInt(tvChargeFristNum.getText().toString().trim()) - 1 + "");
                if (tvChargeFristNum.getText().toString().trim().equals("0") && tvChargeSecondNum.getText().toString().trim().equals("0") && tvChargeThreeNum.getText().toString().trim().equals("0"))
                    chargeType = 0;
                break;
            case R.id.iv_frist_plus:
                if (Integer.parseInt(tvChargeSecondNum.getText().toString().trim()) > 0 || Integer.parseInt(tvChargeThreeNum.getText().toString().trim()) > 0)
                    ToastUtil.showShortToast("充电服务仅为一种!");
                else {
                    tvChargeFristNum.setText(Integer.parseInt(tvChargeFristNum.getText().toString().trim()) + 1 + "");
                    chargeType = 1;
                }
                break;
            case R.id.iv_second_reduce:
                if (Integer.parseInt(tvChargeSecondNum.getText().toString().trim()) > 0)
                    tvChargeSecondNum.setText(Integer.parseInt(tvChargeSecondNum.getText().toString().trim()) - 1 + "");
                if (tvChargeFristNum.getText().toString().trim().equals("0") && tvChargeSecondNum.getText().toString().trim().equals("0") && tvChargeThreeNum.getText().toString().trim().equals("0"))
                    chargeType = 0;
                break;
            case R.id.iv_second_plus:
                if (Integer.parseInt(tvChargeFristNum.getText().toString().trim()) > 0 || Integer.parseInt(tvChargeThreeNum.getText().toString().trim()) > 0)
                    ToastUtil.showShortToast("充电服务仅为一种!");
                else {
                    tvChargeSecondNum.setText(Integer.parseInt(tvChargeSecondNum.getText().toString().trim()) + 1 + "");
                    chargeType = 2;
                }
                break;
            case R.id.iv_three_reduce:
                if (Integer.parseInt(tvChargeThreeNum.getText().toString().trim()) > 0)
                    tvChargeThreeNum.setText(Integer.parseInt(tvChargeThreeNum.getText().toString().trim()) - 1 + "");
                if (tvChargeFristNum.getText().toString().trim().equals("0") && tvChargeSecondNum.getText().toString().trim().equals("0") && tvChargeThreeNum.getText().toString().trim().equals("0"))
                    chargeType = 0;
                break;
            case R.id.iv_three_plus:
                if (Integer.parseInt(tvChargeFristNum.getText().toString().trim()) > 0 || Integer.parseInt(tvChargeSecondNum.getText().toString().trim()) > 0)
                    ToastUtil.showShortToast("充电服务仅为一种!");
                else {
                    tvChargeThreeNum.setText(Integer.parseInt(tvChargeThreeNum.getText().toString().trim()) + 1 + "");
                    chargeType = 3;
                }
                break;
            case R.id.tv_store_call_phone:
                setCenterDialog();
                break;
            case R.id.tv_go_store:
                setMapDialog();
                break;
            case R.id.bt_store_details:
                if (isFastClick()) {
                    if ((Boolean) (SPUtil.get(this, IConstants.IS_LOGIN, false)) == false)
                        setCenterLoginDialog();
                    else if ((Boolean) (SPUtil.get(this, IConstants.IS_SUPPLEMENT_INFO, false)) == false)
                        setCenterLoginDialog();
                    else {
                        if (type == 0)
                            finish();
                        else if (type == 1) {
                            if (chargeType == 0 && fm.getLoadStringTwo().equals(""))
                                ToastUtil.showLongToast("请选择服务！");
                            else
                                setDocumentsReceivedDialog();
                        }
                    }
                }
                break;
        }
    }

    // 选择地图
    private void setMapDialog() {
        final Dialog mCameraDialog = new Dialog(this, R.style.BottomDialog);
        //Dialog布局
        LinearLayout root = (LinearLayout) LayoutInflater.from(this).inflate(R.layout.dialog_map, null);
        root.findViewById(R.id.ll_baidu_map).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                goToBaiduMap(storeListBean.getDescAddress());
                mCameraDialog.dismiss();
            }
        });
        root.findViewById(R.id.ll_gaode_map).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                goToGaodeMap(storeListBean.getLatitude(), storeListBean.getLongitude(), storeListBean.getDescAddress());
                mCameraDialog.dismiss();
            }
        });
        root.findViewById(R.id.ll_tengxun_map).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                goToTengxunMap(storeListBean.getLatitude(), storeListBean.getLongitude(), storeListBean.getDescAddress());
                mCameraDialog.dismiss();
            }
        });
        mCameraDialog.setContentView(root);
        Window dialogWindow = mCameraDialog.getWindow();
        dialogWindow.setGravity(Gravity.BOTTOM); //设置弹出方式
        WindowManager.LayoutParams lp = dialogWindow.getAttributes(); // 获取对话框当前的参数值
        lp.x = 0; // 新位置X坐标
        lp.y = 0; // 新位置Y坐标
        lp.width = (int) getResources().getDisplayMetrics().widthPixels; // 宽度
        root.measure(0, 0);
        lp.height = 500;

        lp.alpha = 9f; // 透明度
        dialogWindow.setAttributes(lp);
        mCameraDialog.show();
    }

    /**
     * 跳转高德地图
     */
    private void goToGaodeMap(String lat, String lon, String descAddress) {
        if (!isInstalled("com.autonavi.minimap")) {
            ToastUtil.showShortToast("请先安装高德地图客户端");
            return;
        }
        LatLng endPoint = BD2GCJ(new LatLng(Double.parseDouble(lat), Double.parseDouble(lon)));//坐标转换
        StringBuffer stringBuffer = new StringBuffer("amapuri://openFeature?featureName=").append("OnRideNavi");
        stringBuffer.append("&rideType=").append("bike")
                .append("&sourceApplication=").append("amap")
                .append("&lat=").append(endPoint.latitude)
                .append("&lon=").append(endPoint.longitude)
                .append("&dev=").append(0);
        Intent intent = new Intent("android.intent.action.VIEW", Uri.parse(stringBuffer.toString()));
        intent.addCategory(Intent.CATEGORY_DEFAULT);
        intent.setPackage("com.autonavi.minimap");
        startActivity(intent);
    }

    /**
     * 跳转腾讯地图
     */
    private void goToTengxunMap(String lat, String lon, String descAddress) {
        if (!isInstalled("com.tencent.map")) {
            ToastUtil.showShortToast("请先安装腾讯地图客户端");
            return;
        }
        LatLng endPoint = BD2GCJ(new LatLng(Double.parseDouble(lat), Double.parseDouble(lon)));//坐标转换
        StringBuffer stringBuffer = new StringBuffer("qqmap://map/routeplan?type=bike")
                .append("&tocoord=").append(endPoint.latitude).append(",").append(endPoint.longitude).append("&to=" + descAddress);
        Intent intent = new Intent("android.intent.action.VIEW", Uri.parse(stringBuffer.toString()));
        startActivity(intent);
    }

    /**
     * 跳转百度地图
     */
    private void goToBaiduMap(String descAddress) {
        if (!isInstalled("com.baidu.BaiduMap")) {
            ToastUtil.showShortToast("请先安装百度地图客户端");
            return;
        }
        Intent intent = new Intent();
        intent.setData(Uri.parse("baidumap://map/direction?destination="
                + descAddress + // 终点
                "&mode=riding" + // 导航路线方式
                "&coord_type=bd09ll" + // 坐标系
                "&src=" + getPackageName()));
        startActivity(intent); // 启动调用
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
    public void resultRepairProjectHorizontal(RepairProjectHorizontalBean data) {
        repairProjectHorizontalBean.addAll(data.getData().getRepairType());
        if (repairProjectHorizontalBean.size() > 0) {
            List<String> list = new ArrayList<>();
            for (int i = 0; i < repairProjectHorizontalBean.size(); i++) {
                list.add(repairProjectHorizontalBean.get(i).getRepairName());
            }
            String[] titles = list.toArray(new String[list.size()]);

            //向集合添加Fragment
            for (int i = 0; i < titles.length; i++) {
                fm = new RepairProjectVerticalFragment();
                Bundle args = new Bundle();
                args.putParcelableArrayList("store_details", (ArrayList<? extends Parcelable>) repairProjectHorizontalBean);
                args.putInt("status_position", i);
                fm.setArguments(args);
                fragments.add(fm);
            }
            //设置导航条
            nlStoreInfor.setViewPager(this, titles, vpStoreInfor, R.color.tx_bottom_navigation, R.color.tx_bottom_navigation_select, 16, 16, 0, 45, true);
            nlStoreInfor.setBgLine(this, 0, R.color.whitesmoke);
            nlStoreInfor.setNavLine(this, 3, R.color.tx_bottom_navigation_select, 0);

            viewPagerAdapter = new ViewPagerAdapter(this.getSupportFragmentManager(), fragments);
            vpStoreInfor.setAdapter(viewPagerAdapter);
            vpStoreInfor.setOffscreenPageLimit(titles.length);

            btStoreDetails.setVisibility(View.VISIBLE);
        } else
            llRepair.setVisibility(View.GONE);

        vpStoreInfor.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(final int position) {
                int o = 0;
                if (repairProjectHorizontalBean.get(position).getAppRepairs().size() > 4)
                    o = repairProjectHorizontalBean.get(position).getAppRepairs().size() % 4 == 0 ? repairProjectHorizontalBean.get(position).getAppRepairs().size() / 4 : repairProjectHorizontalBean.get(position).getAppRepairs().size() / 4 + 1;
                else if (repairProjectHorizontalBean.get(position).getAppRepairs().size() <= 4 && repairProjectHorizontalBean.get(position).getAppRepairs().size() != 0)
                    o = 1;
                // 切换到当前页面，重置高度
                vpStoreInfor.resetHeight(position, o);
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });

        int o = 0;
        if (repairProjectHorizontalBean.get(0).getAppRepairs().size() > 4)
            o = repairProjectHorizontalBean.get(0).getAppRepairs().size() % 4 == 0 ? repairProjectHorizontalBean.get(0).getAppRepairs().size() / 4 : repairProjectHorizontalBean.get(0).getAppRepairs().size() / 4 + 1;
        else if (repairProjectHorizontalBean.get(0).getAppRepairs().size() <= 4 && repairProjectHorizontalBean.get(0).getAppRepairs().size() != 0)
            o = 1;
        vpStoreInfor.resetHeight(0, o);
    }

    @Override
    public void resultCharge(ChargeBean data) {
        chargeListBean.addAll(data.getData().getChargeList());
        chargePath = chargeId.split(",");
        if (chargePath.length < 1 || chargeId.equals("")) {
            llCharge.setVisibility(View.GONE);
        } else if (chargePath.length < 2) {
            for (int j = 0; j < chargeListBean.size(); j++) {
                if (chargePath[0].equals(chargeListBean.get(j).getChargeId() + "")) {
                    llChargeSecond.setVisibility(View.GONE);
                    llChargeThree.setVisibility(View.GONE);
                    tvChargeFrist.setText(chargeListBean.get(j).getTitle());
                    Glide.with(ApplicationUtil.getContext()).load(BASE_LOCAL_URL + chargeListBean.get(j).getIcon()).apply(new RequestOptions()).apply(new RequestOptions().placeholder(R.drawable.ic_charge)).into(ivChargeFrist);
                    tvChargeFristFee.setText("费用" + chargeListBean.get(j).getCost() + "元");
                }
            }
        } else if (chargePath.length < 3) {
            for (int j = 0; j < chargeListBean.size(); j++) {
                if (chargePath[0].equals(chargeListBean.get(j).getChargeId() + "")) {
                    llChargeSecond.setVisibility(View.GONE);
                    llChargeThree.setVisibility(View.GONE);
                    tvChargeFrist.setText(chargeListBean.get(j).getTitle());
                    Glide.with(ApplicationUtil.getContext()).load(BASE_LOCAL_URL + chargeListBean.get(j).getIcon()).apply(new RequestOptions()).apply(new RequestOptions().placeholder(R.drawable.ic_charge)).into(ivChargeFrist);
                    tvChargeFristFee.setText("费用" + chargeListBean.get(j).getCost() + "元");
                }
            }

            for (int j = 0; j < chargeListBean.size(); j++) {
                if (chargePath[1].equals(chargeListBean.get(j).getChargeId() + "")) {
                    llChargeSecond.setVisibility(View.VISIBLE);
                    llChargeThree.setVisibility(View.GONE);
                    tvChargeSecond.setText(chargeListBean.get(j).getTitle());
                    Glide.with(ApplicationUtil.getContext()).load(BASE_LOCAL_URL + chargeListBean.get(j).getIcon()).apply(new RequestOptions()).apply(new RequestOptions().placeholder(R.drawable.ic_charge)).into(ivChargeSecond);
                    tvChargeSecondFee.setText("费用" + chargeListBean.get(j).getCost() + "元");
                }
            }
        } else {
            for (int j = 0; j < chargeListBean.size(); j++) {
                if (chargePath[0].equals(chargeListBean.get(j).getChargeId() + "")) {
                    llChargeSecond.setVisibility(View.GONE);
                    llChargeThree.setVisibility(View.GONE);
                    tvChargeFrist.setText(chargeListBean.get(j).getTitle());
                    Glide.with(ApplicationUtil.getContext()).load(BASE_LOCAL_URL + chargeListBean.get(j).getIcon()).apply(new RequestOptions()).apply(new RequestOptions().placeholder(R.drawable.ic_charge)).into(ivChargeFrist);
                    tvChargeFristFee.setText("费用" + chargeListBean.get(j).getCost() + "元");
                }
            }

            for (int j = 0; j < chargeListBean.size(); j++) {
                if (chargePath[1].equals(chargeListBean.get(j).getChargeId() + "")) {
                    llChargeSecond.setVisibility(View.VISIBLE);
                    llChargeThree.setVisibility(View.GONE);
                    tvChargeSecond.setText(chargeListBean.get(j).getTitle());
                    Glide.with(ApplicationUtil.getContext()).load(BASE_LOCAL_URL + chargeListBean.get(j).getIcon()).apply(new RequestOptions()).apply(new RequestOptions().placeholder(R.drawable.ic_charge)).into(ivChargeSecond);
                    tvChargeSecondFee.setText("费用" + chargeListBean.get(j).getCost() + "元");
                }
            }

            for (int j = 0; j < chargeListBean.size(); j++) {
                if (chargePath[2].equals(chargeListBean.get(j).getChargeId() + "")) {
                    llChargeThree.setVisibility(View.VISIBLE);
                    tvChargeThree.setText(chargeListBean.get(j).getTitle());
                    Glide.with(ApplicationUtil.getContext()).load(BASE_LOCAL_URL + chargeListBean.get(j).getIcon()).apply(new RequestOptions()).apply(new RequestOptions().placeholder(R.drawable.ic_charge)).into(ivChargeThree);
                    tvChargeThreeFee.setText("费用" + chargeListBean.get(j).getCost() + "元");
                }
            }
        }
    }

    @Override
    public void resultRepairConfirm(RepairConfirmBean data) {
        if (data.getCode() == 200)
            startActivity(new Intent(StoreDetailsActivity.this, OrderOnlineActivity.class).putExtra("order_online", data.getData().getOrder()).putParcelableArrayListExtra("order_online_list", (ArrayList<? extends Parcelable>) data.getData().getCostList()).putExtra("longitude", storeListBean.getLongitude()).putExtra("latitude", storeListBean.getLatitude()));
    }

    @Override
    public void resultStoreDetails(StoreDetailsBean data) {
        chargeId = data.getData().getStore().getChargeId();
        TreeMap<String, String> chargeMap = new TreeMap<>();
        chargeMap.put("storeId", storeListBean.getStoreId() + "");
//        chargeMap.put("city", SPUtil.get(this, CITY, "") + "");
        getPresenter().getCharge(chargeMap, false, false);
    }

    @Override
    public <T> ObservableTransformer<T, T> bindLifecycle() {
        return this.bindToLifecycle();
    }
}
